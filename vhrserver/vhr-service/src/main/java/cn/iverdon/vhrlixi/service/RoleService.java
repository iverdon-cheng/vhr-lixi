package cn.iverdon.vhrlixi.service;

import cn.iverdon.vhrlixi.mapper.RoleMapper;
import cn.iverdon.vhrlixi.model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author iverdon
 * @date 2020/8/13 12:05
 */
@Service
public class RoleService {
    @Autowired
    RoleMapper roleMapper;

    public List<Role> getAllRoles() {
        return roleMapper.getAllRoles();
    }

    public Integer addRole(Role role) {
        if (role.getName().startsWith("ROLE_")){
            role.setName("ROLE_"+role.getName());
        }
        return roleMapper.insert(role);
    }

    public Integer deleteRole(Integer id) {
        return roleMapper.deleteByPrimaryKey(id);
    }
}
