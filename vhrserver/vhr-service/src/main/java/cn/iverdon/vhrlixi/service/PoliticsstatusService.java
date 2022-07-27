package cn.iverdon.vhrlixi.service;

import cn.iverdon.vhrlixi.mapper.PoliticsstatusMapper;
import cn.iverdon.vhrlixi.model.Politicsstatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author iverdon
 * @date 2020/8/19 17:31
 */
@Service
public class PoliticsstatusService {

    @Autowired
    PoliticsstatusMapper politicsstatusMapper;

    public List<Politicsstatus> getAllPoliticsstatus() {
        return politicsstatusMapper.getAllPoliticsstatus();
    }
}
