package cn.iverdon.vhrlixi.mapper;

import cn.iverdon.vhrlixi.model.MaterialSequence;

/**
 * @author iverdon
 * @date 2021/12/24 14:54
 */
public interface MaterialSequenceMapper {

    int insertMaterialSequence(MaterialSequence materialSequence);


    MaterialSequence getMaterialSequence(Integer id);
}
