package cn.iverdon.vhrlixi.model;

import java.io.Serializable;
import java.util.Objects;

/**
 * @author iverdon
 * @date 2020/8/17 9:06
 */
public class Politicsstatus implements Serializable {

    public Politicsstatus() {
    }

    public Politicsstatus(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Politicsstatus that = (Politicsstatus) o;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    private Integer id;

    private String name;

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
}
