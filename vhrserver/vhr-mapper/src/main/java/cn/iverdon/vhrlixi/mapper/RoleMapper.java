package cn.iverdon.vhrlixi.mapper;

import cn.iverdon.vhrlixi.model.Role;

import java.util.List;

/**
 * @author iverdon
 * @date 2020/8/13 12:06
 */
public interface RoleMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Role record);

    int insertSelective(Role record);

    Role selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Role record);

    int updateByPrimaryKey(Role record);

    List<Role> getAllRoles();
}
