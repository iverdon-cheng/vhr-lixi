package cn.iverdon.vhrlixi.controller.ord;

import cn.iverdon.vhrlixi.model.Process;
import cn.iverdon.vhrlixi.model.RespBean;
import cn.iverdon.vhrlixi.model.RespPageBean;
import cn.iverdon.vhrlixi.service.ProcessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author iverdon
 * @date 2021/6/12 11:01
 */
@RestController
@RequestMapping("/order/process")
public class ProcessController {
    @Autowired
    ProcessService processService;

    @GetMapping
    public List<Process> getAllProcesses(){
        return processService.getAllProcesses();
    }

    @DeleteMapping("/{id}")
    public RespBean deleteProcessById(@PathVariable Integer id){
        if (processService.deleteProcessById(id) == 1){
            return RespBean.ok("删除成功！");
        }
        return RespBean.error("删除失败！");
    }

    @PostMapping
    public RespBean addProcess(@RequestBody Process process){
        int id = processService.addProcess(process);
        if ( id != 0){
            return RespBean.ok("添加成功！",process);
        }
        return RespBean.error("添加失败！");
    }
}
