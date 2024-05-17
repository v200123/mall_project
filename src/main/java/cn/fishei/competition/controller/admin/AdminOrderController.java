package cn.fishei.competition.controller.admin;

import cn.fishei.competition.bean.R;
import cn.fishei.competition.service.IOrderDetailService;
import cn.fishei.competition.service.IOrderService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import cn.fishei.competition.bean.*;
//import com.java1234.service.IOrderDetailService;
//import com.java1234.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 管理端-订单Controller控制器
 */
@RestController
@RequestMapping("/admin/order")
public class AdminOrderController {

    @Autowired
    private IOrderService orderService;

    @Autowired
    private IOrderDetailService orderDetailService;

    /**
     * 根据条件分页查询
     * @param pageBean
     * @return
     */
    @PostMapping("/list")
    public R list(@RequestBody PageBean pageBean){
        System.out.println(pageBean);
        Map<String,Object> map=new HashMap<>();
        map.put("transac_status",pageBean.getQuery().trim());
        map.put("start",pageBean.getStart());
        map.put("pageSize",pageBean.getPageSize());
        List<Order> list = orderService.list(map);
        Long total = orderService.getTotal(map);
        Map<String,Object> resultMap=new HashMap<>();
        resultMap.put("orderList",list);
        resultMap.put("total",total);
        return R.ok(resultMap);
    }

    /**
     * 更新接单状态
     * @param order
     * @return
     */
    @PostMapping("/receiving")
    public R receiving(@RequestBody Order order){
        Order resultOrder = orderService.getById(order.getId());
        resultOrder.setOrder_receiving(order.getOrder_receiving());
        orderService.updateById(resultOrder);
        return R.ok();
    }

    /**
     * 更新结账状态
     * @param order
     * @return
     */
    @PostMapping("/checkout")
    public R checkout(@RequestBody Order order){
        Order resultOrder = orderService.getById(order.getId());
        resultOrder.setTransac_status(order.getTransac_status());
        orderService.updateById(resultOrder);
        return R.ok();
    }

    /**
     * 删除
     * @param id
     * @return
     */
    @GetMapping("/delete/{id}")
    public R delete(@PathVariable(value = "id") Integer id){
        // 删除订单细表的数据
        orderDetailService.remove(new QueryWrapper<OrderDetail>().eq("mId",id));
        orderService.removeById(id);
        return R.ok();
    }

    /**
     *数据分析：七天销售额
     * @return
     */
/*
    @GetMapping("/salesvolume")
    public R salesvolume(){
       List<SalesVolume> salesVolumeList = orderService.getSalesVolume();
        Map<String,Object> resultMap=new HashMap<>();
        resultMap.put("salesVolumeList",salesVolumeList);
        return R.ok(resultMap);
    }
*/

}
