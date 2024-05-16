package cn.fishei.competition.bean;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * 订单主表
 */
@TableName("t_order")
@Data
public class Order {

    private Integer id; // 编号

    private String order_no; // 订单号

    private String table_number; // 桌号

    private String number_of_diners; // 用餐人数

    private Double sett_amount; // 计算总价

    private String transac_status; // 结账状态

    private String order_receiving;  // 接单状态

    @JsonSerialize(using=CustomDateTimeSerializer.class)
    private Date order_time; // 下单时间

    @TableField(select = false,exist = false)
    private List<OrderDetail> goods_list; // 订单详情

    private Integer is_appointment; // 是否预约单

    private Date appointment_time;  // 预约到店时间

    private Integer is_takeout_order;  // 是否外卖单

    //@TableField(select = false,exist = false)
    //private Address takeoutAddress  ;  // 外卖地址

    private String takeout_address; //外卖地址

}
