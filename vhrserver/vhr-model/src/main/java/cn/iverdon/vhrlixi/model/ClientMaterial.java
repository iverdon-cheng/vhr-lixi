package cn.iverdon.vhrlixi.model;


public class ClientMaterial {

    private Integer id;


    private Integer clientMaterialId;


    private Integer materialId;


    private Integer clientId;

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
     * @return clientMaterialId
     */
    public Integer getClientMaterialId() {
        return clientMaterialId;
    }

    /**
     * @param clientMaterialId
     */
    public void setClientMaterialId(Integer clientMaterialId) {
        this.clientMaterialId = clientMaterialId;
    }

    /**
     * @return materialId
     */
    public Integer getMaterialId() {
        return materialId;
    }

    /**r
     * @param materialId
     */
    public void setMaterialId(Integer materialId) {
        this.materialId = materialId;
    }

    /**
     * @return clientId
     */
    public Integer getClientId() {
        return clientId;
    }

    /**
     * @param clientId
     */
    public void setClientId(Integer clientId) {
        this.clientId = clientId;
    }
}