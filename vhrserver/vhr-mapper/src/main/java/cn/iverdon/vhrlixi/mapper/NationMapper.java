package cn.iverdon.vhrlixi.mapper;

import cn.iverdon.vhrlixi.model.Nation;

import java.util.List;

/**
 * @author iverdon
 * @date 2020/8/19 17:41
 */
public interface NationMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(Nation record);

    int insertSelective(Nation record);

    Nation selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Nation record);

    int updateByPrimaryKey(Nation record);

    List<Nation> getAllNations();
}
