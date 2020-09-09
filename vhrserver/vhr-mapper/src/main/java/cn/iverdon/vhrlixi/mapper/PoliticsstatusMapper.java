package cn.iverdon.vhrlixi.mapper;

import cn.iverdon.vhrlixi.model.Politicsstatus;

import java.util.List;

/**
 * @author iverdon
 * @date 2020/8/19 17:36
 */
public interface PoliticsstatusMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(Politicsstatus record);

    int insertSelective(Politicsstatus record);

    Politicsstatus selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Politicsstatus record);

    int updateByPrimaryKey(Politicsstatus record);

    List<Politicsstatus> getAllPoliticsstatus();
}
