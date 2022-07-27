package cn.iverdon.vhrlixi.mapper;

import cn.iverdon.vhrlixi.model.JobLevel;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author iverdon
 * @date 2020/8/11 9:03
 */
public interface JobLevelMapper {

    List<JobLevel> getAllJobLevels();

    int insertSelective(JobLevel record);

    Integer updateByPrimaryKeySelective(JobLevel jobLevel);

    Integer deleteByPrimaryKey(Integer id);

    Integer deleteJobLevelsByIds(@Param("ids") Integer[] ids);
}
