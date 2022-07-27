package cn.iverdon.vhrlixi.mapper;

import  cn.iverdon.vhrlixi.model.Supplier;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SupplierMapper {

    List<Supplier> getAllSuppliers();

    List<Supplier> getSuppliersByPage(@Param("page") Integer page, @Param("size") Integer size, @Param("supplier")Supplier supplier);

    Long getTotal(@Param("supplier") Supplier supplier);
}