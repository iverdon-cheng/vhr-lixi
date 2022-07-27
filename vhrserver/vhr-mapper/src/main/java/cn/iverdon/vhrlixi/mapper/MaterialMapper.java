package cn.iverdon.vhrlixi.mapper;

import cn.iverdon.vhrlixi.model.Material;
import cn.iverdon.vhrlixi.model.Supplier;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface MaterialMapper{

    //int addMaterial(Material material);

    String getLatestNumByClient(String materialCode);

    int isMaterial(@Param("m") Material m);

    int addMaterial(Material material);

    int deleteMaterial(int id);

    int inMaterial(int id, int num);

    Material getMaterial(Integer id);

    List<Supplier> getMaterialByPage(@Param("page") Integer page,@Param("size") Integer size,@Param("material") Material material);

    Long getTotal(@Param("material") Material material);
}