package cn.iverdon.vhrlixi.model;



public class Product {

    private Integer id;

    /**
     * 产品名称
     */
    private String name;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    /**
     * 产品
     * 类型
     */
    private String type;

    /**
     * 单位成本
     */
    private Float cost;

    /**
     * 报价
     */
    private Float price;

    /**
     * 图纸
     */
    private String url;

    /**
     * 数量
     */
    private Integer sum;

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
     * 获取产品名称
     *
     * @return name - 产品名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置产品名称
     *
     * @param name 产品名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取单位成本
     *
     * @return cost - 单位成本
     */
    public Float getCost() {
        return cost;
    }

    /**
     * 设置单位成本
     *
     * @param cost 单位成本
     */
    public void setCost(Float cost) {
        this.cost = cost;
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
     * 获取图纸
     *
     * @return url - 图纸
     */
    public String getUrl() {
        return url;
    }

    /**
     * 设置图纸
     *
     * @param url 图纸
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * 获取数量
     *
     * @return sum - 数量
     */
    public Integer getSum() {
        return sum;
    }

    /**
     * 设置数量
     *
     * @param sum 数量
     */
    public void setSum(Integer sum) {
        this.sum = sum;
    }
}