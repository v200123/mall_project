package cn.fishei.competition.bean;

/**
 * 数据销售统计
 */
public class SalesVolume {

    // 日期
    private String time;

    // 销售额
    private Double sales_volume;

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Double getSales_volume() {
        return sales_volume;
    }

    public void setSales_volume(Double sales_volume) {
        this.sales_volume = sales_volume;
    }
}
