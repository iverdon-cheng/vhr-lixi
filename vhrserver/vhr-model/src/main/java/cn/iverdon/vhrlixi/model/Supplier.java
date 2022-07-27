package cn.iverdon.vhrlixi.model;


import java.io.Serializable;

public class Supplier implements Serializable {

    private Integer id;

    private String name;

    private String address;

    private String email;

    private String telephone;

    private String type;

    private String manage;
    
    private String codeName;

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
     * @return address
     */
    public String getAddress() {
        return address;
    }

    /**
     * @param address
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * @return email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return telephone
     */
    public String getTelephone() {
        return telephone;
    }

    /**
     * @param telephone
     */
    public void setTelephone(String telephone) {
        this.telephone = telephone;
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
     * @return manage
     */
    public String getManage() {
        return manage;
    }

    /**
     * @param manage
     */
    public void setManage(String manage) {
        this.manage = manage;
    }

    /**
     * @return codeName
     */
    public String getCodeName() {
        return codeName;
    }

    /**
     * @param codeName
     */
    public void setCodeName(String codeName) {
        this.codeName = codeName;
    }
}