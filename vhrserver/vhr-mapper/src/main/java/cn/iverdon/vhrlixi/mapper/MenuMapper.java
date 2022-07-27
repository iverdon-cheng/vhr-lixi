package cn.iverdon.vhrlixi.mapper;

import cn.iverdon.vhrlixi.model.Menu;

import java.util.List;

/**
 * @author iverdon
 * @date 2020/7/14 4:13 下午
 */
public interface MenuMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(Menu record);

    int insertSelective(Menu record);

    Menu selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Menu record);

    int updateByPrimaryKey(Menu record);

    List<Menu> getMenusByHrId(Integer hrid);

    List<Menu> getAllMenusWithRole();

    List<Menu> getAllMenus();

    List<Integer> getMidsByRid(Integer rid);
}
