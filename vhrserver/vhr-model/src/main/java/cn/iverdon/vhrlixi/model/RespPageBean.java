package cn.iverdon.vhrlixi.model;

import java.util.List;

/**
 * @author iverdon
 * @date 2020/8/16 22:23
 */
public class RespPageBean {
    private Long total;
    private List<?> data;

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public List<?> getData() {
        return data;
    }

    public void setData(List<?> data) {
        this.data = data;
    }
}
