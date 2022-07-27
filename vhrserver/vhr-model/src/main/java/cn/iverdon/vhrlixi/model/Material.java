package cn.iverdon.vhrlixi.model;

import java.util.Date;


public class Material {

    private Integer id;

    private String materialCode;

    private Integer quantity;

    private String type;

    private Date updateTime;

    private String name;

    private String specification;

    private Float weight;

    private String handler;

    public String getHandler() {
        return handler;
    }

    public void setHandler(String handler) {
        this.handler = handler;
    }

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return materialCode
     */
    public String getMaterialCode() {
        return materialCode;
    }

    /**
     * @param materialCode
     */
    public void setMaterialCode(String materialCode) {
        this.materialCode = materialCode;
    }

    /**
     * @return quantity
     */
    public Integer getQuantity() {
        return quantity;
    }

    /**
     * @param quantity
     */
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    /**
     * @return type
     */
    public String getType() {
        return type;
    }

    /**
     * @param type
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * @return updateTime
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * @param updateTime
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return specification
     */
    public String getSpecification() {
        return specification;
    }

    /**
     * @param specification
     */
    public void setSpecification(String specification) {
        this.specification = specification;
    }

    /**
     * @return weight
     */
    public Float getWeight() {
        return weight;
    }

    /**
     * @param weight
     */
    public void setWeight(Float weight) {
        this.weight = weight;
    }
}