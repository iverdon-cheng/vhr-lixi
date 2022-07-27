package cn.iverdon.vhrlixi.controller.ord;

import cn.iverdon.vhrlixi.model.Client;
import cn.iverdon.vhrlixi.model.Employee;
import cn.iverdon.vhrlixi.model.RespPageBean;
import cn.iverdon.vhrlixi.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

/**
 * @author iverdon
 * @date 2021/3/9 1:21
 */
@RestController
@RequestMapping("/order/client")
public class ClientController {

    @Autowired
    ClientService clientService ;

    @GetMapping("/")
    public RespPageBean getClientByPage(@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "10") Integer size, Client client){
        return clientService.getClientByPage(page,size,client);
    }

    @GetMapping("/all")
    public List<Client> getAllClients(){
        return clientService.getAllClients();
    }
}
