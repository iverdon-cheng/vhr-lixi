package cn.iverdon.vhrlixi.service;

import cn.iverdon.vhrlixi.mapper.NationMapper;
import cn.iverdon.vhrlixi.model.Nation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author iverdon
 * @date 2020/8/19 17:24
 */
@Service
public class NationService {

    @Autowired
    NationMapper nationMapper;

    public List<Nation> getAllNations() {
        return nationMapper.getAllNations();
    }
}
