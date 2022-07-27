package cn.iverdon.vhrlixi.service;

import cn.iverdon.vhrlixi.mapper.ClientMapper;
import cn.iverdon.vhrlixi.model.Client;
import cn.iverdon.vhrlixi.model.RespPageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author iverdon
 * @date 2021/3/9 1:23
 */
@Service
public class ClientService {

    @Autowired
    ClientMapper clientMapper;

    public RespPageBean getClientByPage(Integer page, Integer size, Client client) {
        if (page != null && size != null){
            page = (page-1)*size;
        }
        List<Client> data = clientMapper.getClientByPage(page, size, client);
        Long total = clientMapper.getTotal(client);
        RespPageBean bean = new RespPageBean();
        bean.setData(data);
        bean.setTotal(total);
        return bean;
    }

    public List<Client> getAllClients() {
        return clientMapper.getAllClients();
    }

    public String getCodeNameById(int clientId){return clientMapper.getClientCodeName(clientId);}
}
