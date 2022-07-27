package cn.iverdon.vhrlixi.model;

import java.io.Serializable;
import java.util.Date;

/**
 * @author iverdon
 * @date 2022/3/2 11:15
 */
public class Oplog implements Serializable {

    private int id;

    private Date addDate;

    private String operate;

    private int hrid;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getAddDate() {
        return addDate;
    }

    public void setAddDate(Date addDate) {
        this.addDate = addDate;
    }

    public String getOperate() {
        return operate;
    }

    public void setOperate(String operate) {
        this.operate = operate;
    }

    public int getHrid() {
        return hrid;
    }

    public void setHrid(int hrid) {
        this.hrid = hrid;
    }
}
