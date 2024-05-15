package cn.fishei.competition.service.impl;

import cn.fishei.competition.bean.Order;
import cn.fishei.competition.mapper.OrderMapper;
import cn.fishei.competition.service.IOrderService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
//import com.java1234.entity.Order;
//import com.java1234.entity.SalesVolume;
//import com.java1234.mapper.OrderMapper;
//import com.java1234.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


/**
 * 订单主表Service实现类
 */
@Service("orderService")
public class IOrderServiceImpl extends ServiceImpl<OrderMapper, Order> implements IOrderService {

    @Autowired
    private OrderMapper orderMapper;

    @Override
    public List<Order> list(Map<String, Object> map) {
        return orderMapper.list(map);
    }

    @Override
    public Long getTotal(Map<String, Object> map) {
        return orderMapper.getTotal(map);
    }

 /*   @Override
    public List<SalesVolume> getSalesVolume() {
        return orderMapper.getSalesVolume();
    }*/
}
