package cn.iverdon.vhrlixi.model;

import java.io.Serializable;

/**
 * @author iverdon
 * @date 2020/7/11 5:10 下午
 */
public class Role implements Serializable {

    private Integer id;

    private String name;

    private String nameZh;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNameZh() {
        return nameZh;
    }

    public void setNameZh(String nameZh) {
        this.nameZh = nameZh;
    }
}