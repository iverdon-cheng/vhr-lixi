package cn.iverdon.vhrlixi.mapper;

import cn.iverdon.vhrlixi.model.HrRole;
import org.apache.ibatis.annotations.Param;

/**
 * @author iverdon
 * @date 2020/8/16 10:41
 */
public interface HrRoleMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(HrRole record);

    int insertSelective(HrRole record);

    HrRole selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(HrRole record);

    int updateByPrimaryKey(HrRole record);

    void deleteByHrid(Integer hrid);

    Integer addRole(@Param("hrid") Integer hrid, @Param("rids") Integer[] rids);
}
