package cn.fishei.competition.controller;

import cn.fishei.competition.bean.Goods;
import cn.fishei.competition.bean.R;
import cn.fishei.competition.service.impl.MenuServiceImpl;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/menu")
public class MenuController {

    @Resource
    private MenuServiceImpl menuService;

    @RequestMapping("/goodsLists")
    public Map<String, Object> showGoodsList(String cId){
        Map<String, Object> map = new HashMap<>();
        int categoryId;
        try {
            categoryId = Integer.parseInt(cId);
        } catch (NumberFormatException e) {
            e.printStackTrace();
            map.put("code","error");
            map.put("goods",null);
            map.put("msg","参数有误");
            return map;
        }
        map.put("code","ok");
        map.put("msg","获取成功");

        switch (categoryId){
            case 1:
                map.put("goods", menuService.getHomeLists());
                break;
            case 2:
                map.put("goods", menuService.getPotLists());
                break;
            case 3:
                map.put("goods", menuService.getSnackLists());
            case 4:
                map.put("goods", menuService.getDrinksLists());
            default:
                map.put("goods", null);
        }
        return map;
    }

    @RequestMapping("/searchGoods")
    public Map<String, Object> searchGoods(String key){
        Map<String, Object> map = new HashMap<>();
        try {
            map.put("code","ok");
            map.put("msg","获取成功");
            map.put("goods", menuService.queryLikeGoods(key));
        }catch (Exception e){
            map.put("code","error");
            map.put("msg","未知错误");
            map.put("goods", null);
        }
        return map;
    }


    /**
     * 创建菜单
     * @param goods
     * @return
     */
    @PostMapping("/addGoods")
    public R saveGoods(@RequestBody Goods goods){
        // System.out.println("order:"+order);
        menuService.saveGoods(goods);
        System.out.println(goods.getId());
        return R.ok();
    }




}
