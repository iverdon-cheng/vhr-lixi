package cn.iverdon.vhrlixi.mapper;

import cn.iverdon.vhrlixi.model.MailSendLog;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

/**
 * @author iverdon
 * @date 2020/10/7 15:59
 */
public interface MailSendLogMapper {

    Integer updateMailSendLogStatus(@Param("msgId") String msgId, @Param("status") int status);

    Integer insert(MailSendLog mailSendLog);

    List<MailSendLog> getMailSendLogsByStatus();

    Integer updateCount(@Param("msgId") String msgId, @Param("date") Date date);
}
