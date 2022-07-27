package cn.iverdon.vhrlixi.mapper;

import cn.iverdon.vhrlixi.model.Process;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author iverdon
 * @date 2021/6/11 0:12
 */
public interface ProcessMapper {

    int insertProcess(Process process);

    int deleteById(@Param("id") int id);

    List<Process> getALLProcess();
}
