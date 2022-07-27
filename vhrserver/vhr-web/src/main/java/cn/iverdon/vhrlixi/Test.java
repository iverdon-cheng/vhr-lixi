package cn.iverdon.vhrlixi;

import cn.iverdon.vhrlixi.config.FastDFSUtils;
import org.csource.fastdfs.*;
import org.omg.CORBA.NameValuePair;

/**
 * @author iverdon
 * @date 2021/6/2 23:35
 */

public class Test {
    public static void main(String[] args) {
//        try {
//            System.out.println(FastDFSUtils.delete("group1/M00/00/00/eccqjWD4Q2KABxXaAAe23fcIGqE517.pdf"));
////            ClientGlobal.initByProperties("fastdfs-client.properties");
////            TrackerClient tracker = new TrackerClient();
////            TrackerServer trackerServer = tracker.getConnection();
////            StorageServer storageServer = null;
////            StorageClient1 client = new StorageClient1(trackerServer, storageServer);
////            //上传到文件系统
////            String fileId = client.upload_file1("C:\\Users\\CD\\Pictures\\Camera Roll\\rose.jpg", "jpg",null);
//  //          System.out.println(fileId);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
        String[] s = "http://121.199.42.141/group1/M00/00/00/eccqjWDp3ySAbwD8AAAjiCx0x_E792.jpg?token=bd44296aa412d6231b20d1f466f20933&ts=1625939748".split("\\?");
        System.out.println(s[0]);
        String temp = s[0].substring(21);
        System.out.println(temp);
    }
}
