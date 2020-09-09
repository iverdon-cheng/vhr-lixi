package cn.iverdon.vhrlixi.utils;

import cn.iverdon.vhrlixi.model.Hr;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * @author iverdon
 * @date 2020/8/15 0:14
 */
public class HrUtils {

    public static Hr getCurrentHr(){
        return ((Hr) SecurityContextHolder.getContext().getAuthentication().getPrincipal());
    }
}
