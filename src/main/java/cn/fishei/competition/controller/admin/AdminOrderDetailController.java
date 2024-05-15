package cn.fishei.competition.controller.admin;

import cn.fishei.competition.bean.OrderDetail;
import cn.fishei.competition.bean.R;
import cn.fishei.competition.service.IOrderDetailService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
//import com.java1234.entity.OrderDetail;
//import com.java1234.entity.R;
//import com.java1234.service.IOrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 管理端-订单详情Controller控制器
 */
@RestController
@RequestMapping("/admin/orderDetail")
public class AdminOrderDetailController {

    @Autowired
    private IOrderDetailService orderDetailService;

    /**
     * 根据订单号查询订单详情
     * @param id
     * @return
     */
    @GetMapping("/list")
    public R listByOrderId(Integer id){
        System.out.println("id="+id);
        List<OrderDetail> orderDetailList = orderDetailService.list(new QueryWrapper<OrderDetail>().eq("mId", id));
        Map<String,Object> resultMap=new HashMap<>();
        resultMap.put("list",orderDetailList);
        return R.ok(resultMap);
    }

}
