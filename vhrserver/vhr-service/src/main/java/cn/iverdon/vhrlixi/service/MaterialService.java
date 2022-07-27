package cn.iverdon.vhrlixi.service;

import cn.iverdon.vhrlixi.mapper.ClientMapper;
import cn.iverdon.vhrlixi.mapper.MaterialMapper;
import cn.iverdon.vhrlixi.mapper.MaterialSequenceMapper;
import cn.iverdon.vhrlixi.mapper.OplogMapper;
import cn.iverdon.vhrlixi.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 * @author iverdon
 * @date 2021/10/23 11:23
 */
@Service
public class MaterialService {

    @Autowired
    MaterialMapper materialMapper;


    @Autowired
    ClientMapper clientMapper;

    @Autowired
    MaterialSequenceMapper materialSequenceMapper;

    @Autowired
    OplogMapper oplogMapper;

    public int addMaterial(Material material, Integer clientId) {
        if (material.getName() != null && materialMapper.isMaterial(material) != 1){
            String materialCode = "P";
            switch (material.getType()){
                case "产品":
                    System.out.println(material.getType());
                    materialCode = materialCode.concat(clientMapper.getClientCodeName(clientId));
                    break;
                case "半成品":
                   materialCode = "S".concat(clientMapper.getClientCodeName(clientId));
                    break;
                case "消耗品":
                    materialCode = "C".concat(clientMapper.getClientCodeName(clientId));
                    break;
                case "原材料":
                    materialCode = "R".concat(clientMapper.getClientCodeName(clientId));
                    break;
            }
            String latestNum = materialMapper.getLatestNumByClient(materialCode);
            String now = new SimpleDateFormat("yyMM").format(new Date());
            if (latestNum == null || !latestNum.substring(materialCode.length(),materialCode.length()+4).equals(now)){
                materialCode = materialCode.concat(now).concat(String.format("%04d",1));
            }else {
                String num = latestNum.substring(materialCode.length()+5);
                int temp = Integer.parseInt(num)+1;
                materialCode = materialCode.concat(now).concat(String.format("%04d",temp));
                System.out.println(materialCode+"dfddfdfds");
            }
            material.setMaterialCode(materialCode);
            return materialMapper.addMaterial(material);
        }
        return 0;
    }

    public int deleteMaterial(int id) {
        return materialMapper.deleteMaterial(id);
    }


    @Transactional
    public int inMaterial(int id, int num) {
        Material material = materialMapper.getMaterial(id);
        Hr hr = (Hr) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Oplog oplog = new Oplog();
        oplog.setHrid(hr.getId());
        oplog.setAddDate(new Date());
        // String s = material.getName()+"入库"+num;
        oplog.setOperate(String.format(material.getName()+"入库"+num));
        oplogMapper.insert(oplog);
        System.out.println(num+material.getQuantity());
        return materialMapper.inMaterial(id,num+material.getQuantity());
    }

    public int relatedMaterial(MaterialSequence materialSequence) {
        System.out.println(materialSequence.getMaterialId()+"sdfsdfs"+materialSequence.getPreId());
        return materialSequenceMapper.insertMaterialSequence(materialSequence);
    }

    public List<Material> getRelatedMaterial(Integer id) {
        MaterialSequence materialSequence = materialSequenceMapper.getMaterialSequence(id);
        LinkedList<Material> list = new LinkedList<>();
        if (materialSequence.getPreId() == 0 && materialSequence.getNextId() == 0 ){
            Material material = materialMapper.getMaterial(id);
            list.addFirst(material);
            return list;
        }
        list.addFirst(materialMapper.getMaterial(id));
        while (materialSequence.getPreId() !=0 ){
            Material material = materialMapper.getMaterial(materialSequence.getPreId());
            list.addLast(material);
            materialSequence = materialSequenceMapper.getMaterialSequence(materialSequence.getPreId());
        }
        materialSequence =  materialSequenceMapper.getMaterialSequence(id);
        while (materialSequence.getNextId() != 0 ){
            Material material = materialMapper.getMaterial(materialSequence.getNextId());
            list.addFirst(material);
            materialSequence = materialSequenceMapper.getMaterialSequence(materialSequence.getNextId());
        }
        for (Material m : list){
            System.out.println(m.getName());
        }
        return list;
    }

    public RespPageBean getMaterialByPage(Integer page, Integer size, Material material) {
        if (page != null && size != null){
            page = (page-1)*size;
        }
        List<Supplier> data = materialMapper.getMaterialByPage(page, size, material);
        Long total = materialMapper.getTotal(material);
        RespPageBean bean = new RespPageBean();
        bean.setData(data);
        bean.setTotal(total);
        return bean;
    }
}
