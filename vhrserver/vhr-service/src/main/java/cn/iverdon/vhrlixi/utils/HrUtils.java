package cn.iverdon.vhrlixi.utils;

import cn.iverdon.vhrlixi.model.Hr;
import org.csource.common.MyException;
import org.csource.fastdfs.ProtoCommon;
import org.springframework.security.core.context.SecurityContextHolder;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.time.Instant;

/**
 * @author iverdon
 * @date 2020/8/15 0:14
 */
public class HrUtils {

    private static String nginxHost = "http://121.199.42.141/";

    public static Hr getCurrentHr(){
        return ((Hr) SecurityContextHolder.getContext().getAuthentication().getPrincipal());
    }

    public static String getTokenIn(String fileName) {
        int ts = (int) Instant.now().getEpochSecond();
        String token = null;
        try {
            token = ProtoCommon.getToken(fileName.substring(7),ts,"FastDFS1234567890");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (MyException e) {
            e.printStackTrace();
        }
        StringBuilder sb =new StringBuilder();
        sb.append(nginxHost).append(fileName)
                .append("?token=").append(token)
                .append("&ts=").append(ts);
        return sb.toString();
    }
}
