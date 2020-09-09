package cn.iverdon.vhrlixi.mapper;

import cn.iverdon.vhrlixi.model.Department;

import java.util.List;

/**
 * @author iverdon
 * @date 2020/8/14 14:30
 */
public interface DepartmentMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(Department record);

    int insertSelective(Department record);

    Department selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Department record);

    int updateByPrimaryKey(Department record);

    List<Department> getAllDepartmentsByParentId(Integer pid);

    void addDep(Department dep);

    void deleteDepById(Department dep);

    List<Department> getAllDepartmentsWithOutChildren();
}
