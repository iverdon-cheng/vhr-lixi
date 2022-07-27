package cn.iverdon.vhrlixi.service;

import cn.iverdon.vhrlixi.mapper.MailSendLogMapper;
import cn.iverdon.vhrlixi.model.MailSendLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author iverdon
 * @date 2020/10/7 16:01
 */

@Service
public class MailSendLogService {
    @Autowired
    MailSendLogMapper mailSendLogMapper;

    public Integer updateMailSendLogStatus(String msgId, int status) {
        return mailSendLogMapper.updateMailSendLogStatus(msgId,status);
    }

    public Integer insert(MailSendLog mailSendLog) {
        return mailSendLogMapper.insert(mailSendLog);
    }

    public List<MailSendLog> getMailSendLogsByStatus() {
        return mailSendLogMapper.getMailSendLogsByStatus();
    }

    public Integer updateCount(String msgId, Date date) {
        return mailSendLogMapper.updateCount(msgId,date);
    }
}
