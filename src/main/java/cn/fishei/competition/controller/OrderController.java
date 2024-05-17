package cn.fishei.competition.controller;

import cn.fishei.competition.bean.Order;
import cn.fishei.competition.bean.OrderDetail;
import cn.fishei.competition.service.IOrderDetailService;
import cn.fishei.competition.service.IOrderService;
import cn.fishei.competition.bean.R;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

/**
 * 订单控制器
 */
@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private IOrderService orderService;

    @Autowired
    private IOrderDetailService orderDetailService;

    /**
     * 创建订单
     * @param order
     * @return
     */
    @PostMapping("/create")
    public R create(@RequestBody Order order){
        // System.out.println("order:"+order);
        order.setOrder_time(new Date());
        orderService.save(order);
        System.out.println(order.getId());
        for(OrderDetail od:order.getGoods_list()){
            od.setMId(order.getId());
            orderDetailService.save(od);
        }
        return R.ok();
    }

    /**
     * 根据条件获取订单
     * @param table_number
     * @param transac_status
     * @return
     */
    @RequestMapping("/get")
    public R get(String table_number,String transac_status){
        Order order=orderService.list(new QueryWrapper<Order>().eq("table_number", table_number).eq("transac_status", transac_status).orderByDesc("order_time")).get(0);
        System.out.println("11:"+order);
        List<OrderDetail> goods_list = orderDetailService.list(new QueryWrapper<OrderDetail>().eq("m_id", order.getId()));
        Map<String,Object> map=new HashMap<>();
        map.put("goods_list",goods_list);
        map.put("menu",order);
        return R.ok(map);
    }

    @RequestMapping("/getAll")
    public R getAll(){
        List<Order> list = orderService.list();
        list.forEach(new Consumer<Order>() {
            @Override
            public void accept(Order order) {
                List<OrderDetail> goods_list = orderDetailService.list(new QueryWrapper<OrderDetail>().eq("m_id", order.getId()));
                order.setGoods_list(goods_list);
            }
        });
        Order order=orderService.list().get(0);
        System.out.println("11:"+order);
        Map<String,Object> map=new HashMap<>();
        map.put("orderInfo",list);
//        map.put("menu",order);
        return R.ok(map);
    }

}
