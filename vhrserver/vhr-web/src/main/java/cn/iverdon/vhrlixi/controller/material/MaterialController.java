package cn.iverdon.vhrlixi.controller.material;

import cn.iverdon.vhrlixi.model.*;
import cn.iverdon.vhrlixi.service.MaterialService;
import org.apache.ibatis.annotations.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author iverdon
 * @date 2021/10/23 10:38
 */
@RestController
@RequestMapping("/material/material")
public class MaterialController {

    @Autowired
    MaterialService materialService;

    @GetMapping("/")
    public RespPageBean getMaterialByPage(@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "10") Integer size, Material material){
        return materialService.getMaterialByPage(page, size, material);
    }

    @PostMapping("/")
    public RespBean addMaterial(@RequestBody Material material, @RequestParam("clientId") Integer clientId){
        if (materialService.addMaterial(material,clientId) == 1){
            return RespBean.ok("新增成功！");
        }
        return RespBean.error("新增失败！");
    }

    @DeleteMapping("/{id}")
    public RespBean deleteMaterial(@PathVariable int id){
        if (materialService.deleteMaterial(id) == 1){
            return RespBean.ok("删除成功！");
        }
        return RespBean.error("删除失败！");
    }

    @PutMapping("/in/{id}/{num}")
    public RespBean inMaterial(@PathVariable String id, @PathVariable String num, Authentication authentication){
        Hr hr = (Hr) authentication.getPrincipal();
        if (materialService.inMaterial(Integer.parseInt(id),Integer.parseInt(num)) == 1){
            return RespBean.ok("入库成功！");
        }
        return RespBean.error("入库失败！");
    }

    @PostMapping("/related")
    public RespBean relatedMaterial(@RequestBody MaterialSequence materialSequence){
        System.out.println(materialSequence.getMaterialId());
        if (materialService.relatedMaterial(materialSequence) == 1){
            return RespBean.ok("关联成功！");
        }
        return RespBean.error("关联失败！");
    }

    @GetMapping("/related")
    public RespBean getRelatedMaterial(@RequestParam Integer id){

        List<Material> materialList = materialService.getRelatedMaterial(id);
        if ( materialList != null){
            return RespBean.ok("查询成功",materialList);
        }
        return RespBean.error("查询失败");
    }

}
