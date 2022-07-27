package cn.iverdon.vhrlixi.mapper;

import cn.iverdon.vhrlixi.model.Hr;
import cn.iverdon.vhrlixi.model.Role;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author iverdon
 * @date 2020/7/11 5:22 下午
 */
public interface HrMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(Hr record);

    int insertSelective(Hr record);

    Hr selectByPrimaryKey(Integer record);

    int updateByPrimaryKeySelective(Hr record);

    int updateByPrimaryKey(Hr record);

    Hr loadUserByUsername(String username);

    List<Role> getHrRolesById(Integer id);

    List<Hr> getAllHrsExceptCurrentHr(Integer id);

    Integer updatePasswd(@Param("hrid") Integer hrid, @Param("encodePass") String encodePass);

    Integer updateUserFace(@Param("url") String url, @Param("id") Integer id);


    List<Hr> getAllHrs(@Param("hrid") Integer id, @Param("keywords") String keywords);
}
