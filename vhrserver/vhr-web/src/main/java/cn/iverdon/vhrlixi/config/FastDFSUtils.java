package cn.iverdon.vhrlixi.config;

import org.csource.common.MyException;
import org.csource.fastdfs.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.time.Instant;

/**
 * @author iverdon
 * @date 2020/10/6 15:55
 */
public class FastDFSUtils {

    private static StorageClient1 client1;

    static{
        try {
            ClientGlobal.initByProperties("fastdfs-client.properties");
            TrackerClient trackerClient = new TrackerClient();
            TrackerServer trackerServer = trackerClient.getConnection();
            client1 = new StorageClient1(trackerServer,null);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (MyException e) {
            e.printStackTrace();
        }
    }

    public static String upload(MultipartFile file){
        String oldName = file.getOriginalFilename();
        try {
            return client1.upload_file1(file.getBytes(),oldName.substring(oldName.lastIndexOf(".")+1),null);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (MyException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String getToken(String fileName) {
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
        sb.append(fileName)
                .append("?token=").append(token)
                .append("&ts=").append(ts);
        return sb.toString();
    }


    public static Integer delete(String fileName) {
        try{
            return client1.delete_file1(fileName);
        }catch (IOException e){
            e.printStackTrace();
        }catch (MyException e){
            e.printStackTrace();
        }
        return 0;
    }
}
