package cn.iverdon.vhrlixi.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

public class Quotation {
    /**
     * 采购单号
     */
    private String quotationNum;

    public String getQuotationNum() {
        return quotationNum;
    }

    public void setQuotationNum(String quotationNum) {
        this.quotationNum = quotationNum;
    }

    /**
     * 客户单号
     */
    private String clientNum;

    public String getClientNum() {
        return clientNum;
    }

    public void setClientNum(String clientNum) {
        this.clientNum = clientNum;
    }

    /**
     * 客户名称
     */
    private String client;

    /**
     * 订单名称
     */
    private String name;

    private List<Product> products;

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /**
     * 申请时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;

    /**
     * 备注
     */
    private String remark;

    /**
     * 是否报价
     */
    private Boolean isOffer;

    /**
     * 申请部门
     */
    private String department;

    /**
     * 报价
     */
    private Float price;

    /**
     * 成本价
     */
    private Float cost;

    /**
     * 托工单图片
     */
    private String clientUrl;

    /**
     * 是否下单
     */
    private Boolean isOrder;

    /**
     * 是否估算成本
     */
    private Boolean isCost;


    /**
     * 是否含税
     */
    private Boolean isTax;


    /**
     * 获取客户名称
     *
     * @return client - 客户名称
     */
    public String getClient() {
        return client;
    }

    /**
     * 设置客户名称
     *
     * @param client 客户名称
     */
    public void setClient(String client) {
        this.client = client;
    }

    /**
     * 获取申请时间
     *
     * @return createTime - 申请时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置申请时间
     *
     * @param createTime 申请时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取备注
     *
     * @return remark - 备注
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 设置备注
     *
     * @param remark 备注
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }

    /**
     * 获取是否报价
     *
     * @return isOffer - 是否报价
     */
    public Boolean getIsOffer() {
        return isOffer;
    }

    /**
     * 设置是否报价
     *
     * @param isOffer 是否报价
     */
    public void setIsOffer(Boolean isOffer) {
        this.isOffer = isOffer;
    }

    /**
     * 获取申请部门
     *
     * @return department - 申请部门
     */
    public String getDepartment() {
        return department;
    }

    /**
     * 设置申请部门
     *
     * @param department 申请部门
     */
    public void setDepartment(String department) {
        this.department = department;
    }

    /**
     * 获取报价
     *
     * @return price - 报价
     */
    public Float getPrice() {
        return price;
    }

    /**
     * 设置报价
     *
     * @param price 报价
     */
    public void setPrice(Float price) {
        this.price = price;
    }

    /**
     * 获取成本价
     *
     * @return cost - 成本价
     */
    public Float getCost() {
        return cost;
    }

    /**
     * 设置成本价
     *
     * @param cost 成本价
     */
    public void setCost(Float cost) {
        this.cost = cost;
    }

    /**
     * 获取托工单图片
     *
     * @return clientUrl - 托工单图片
     */
    public String getClientUrl() {
        return clientUrl;
    }

    /**
     * 设置托工单图片
     *
     * @param clientUrl 托工单图片
     */
    public void setClientUrl(String clientUrl) {
        this.clientUrl = clientUrl;
    }

    /**
     * 获取是否下单
     *
     * @return isOrder - 是否下单
     */
    public Boolean getIsOrder() {
        return isOrder;
    }

    /**
     * 设置是否下单
     *
     * @param isOrder 是否下单
     */
    public void setIsOrder(Boolean isOrder) {
        this.isOrder = isOrder;
    }

    /**
     * 获取是否估算成本
     *
     * @return isCost - 是否估算成本
     */
    public Boolean getIsCost() {
        return isCost;
    }

    /**
     * 设置是否估算成本
     *
     * @param isCost 是否估算成本
     */
    public void setIsCost(Boolean isCost) {
        this.isCost = isCost;
    }

    /**
     * 获取是否含税
     *
     * @return isTax - 是否含税
     */
    public Boolean getIsTax() {
        return isTax;
    }

    /**
     * 设置是否含税
     *
     * @param isTax 是否含税
     */
    public void setIsTax(Boolean isTax) {
        this.isTax = isTax;
    }

}