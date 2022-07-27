package cn.iverdon.vhrlixi.model;


public class QuotationProduct {

    private Integer id;


    private String clientNum;


    private Integer productNum;

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
     * @return clientNum
     */
    public String getClientNum() {
        return clientNum;
    }

    /**
     * @param clientNum
     */
    public void setClientNum(String clientNum) {
        this.clientNum = clientNum;
    }

    /**
     * @return productNum
     */
    public Integer getProductNum() {
        return productNum;
    }

    /**
     * @param productNum
     */
    public void setProductNum(Integer productNum) {
        this.productNum = productNum;
    }
}