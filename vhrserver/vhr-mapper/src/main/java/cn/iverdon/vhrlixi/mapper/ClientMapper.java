package cn.iverdon.vhrlixi.mapper;


import cn.iverdon.vhrlixi.model.Client;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ClientMapper {

    List<Client> getClientByPage(@Param("page") Integer page, @Param("size") Integer size, @Param("client") Client client);

    Long getTotal(@Param("client") Client client);

    List<Client> getAllClients();

    String getClientCodeName(@Param("clientId") int clientId);
}