package cn.iverdon.vhrlixi.service;

import cn.iverdon.vhrlixi.mapper.ProcessMapper;
import cn.iverdon.vhrlixi.model.Process;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author iverdon
 * @date 2021/6/12 15:26
 */
@Service
public class ProcessService {
    @Autowired
    ProcessMapper processMapper;


    public int addProcess(Process process) {
        return processMapper.insertProcess(process);
    }

    public List<Process> getAllProcesses() {
        return processMapper.getALLProcess();
    }

    public int deleteProcessById(Integer id) {
        return processMapper.deleteById(id);
    }
}
