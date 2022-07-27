package cn.iverdon.vhrlixi.service;

import cn.iverdon.vhrlixi.mapper.HrMapper;
import cn.iverdon.vhrlixi.mapper.HrRoleMapper;
import cn.iverdon.vhrlixi.model.Hr;
import cn.iverdon.vhrlixi.utils.HrUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author iverdon
 * @date 2020/7/11 11:22 下午
 */
@Service
public class HrService implements UserDetailsService {
    @Autowired
    HrMapper hrMapper;

    @Autowired
    HrRoleMapper hrRoleMapper;

    public Integer updateHr(Hr hr) {
        return hrMapper.updateByPrimaryKeySelective(hr);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Hr hr = hrMapper.loadUserByUsername(username);
        if (hr == null){
            throw new UsernameNotFoundException("用户不存在");
        }
        hr.setRoles(hrMapper.getHrRolesById(hr.getId()));
        hr.setUserFace(HrUtils.getTokenIn(hr.getUserFace()));
        System.out.println(hr.getUserFace());
        return hr;
    }

    public List<Hr> getAllHrs(String keywords) {
        return hrMapper.getAllHrs(HrUtils.getCurrentHr().getId(),keywords);
    }

    @Transactional
    public boolean updateHrRoles(Integer hrid, Integer[] rids){
        hrRoleMapper.deleteByHrid(hrid);
        return hrRoleMapper.addRole(hrid,rids) == rids.length;
    }

    public Integer deleteHrById(Integer id) {
        return hrMapper.deleteByPrimaryKey(id);
    }

    public List<Hr> getAllHrsExceptCurrentHr() {
        return hrMapper.getAllHrsExceptCurrentHr(HrUtils.getCurrentHr().getId());
    }

    public boolean updateHrPasswd(String oldPass, String pass, Integer hrid) {
        Hr hr = hrMapper.selectByPrimaryKey(hrid);
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        if (encoder.matches(oldPass,hr.getPassword())){
            String encode = encoder.encode(pass);
            Integer result = hrMapper.updatePasswd(hrid,encode);
            if (result == 1){
                return true;
            }
        }
        return false;
    }

    public int updateUserFace(String url, Integer id) {
        return hrMapper.updateUserFace(url, id);
    }
}
