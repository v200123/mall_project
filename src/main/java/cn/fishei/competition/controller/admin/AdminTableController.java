package cn.fishei.competition.controller.admin;

import cn.fishei.competition.bean.PageBean;
import cn.fishei.competition.bean.R;
import cn.fishei.competition.bean.Table;
import cn.fishei.competition.service.ITableService;
import cn.fishei.competition.util.DateUtil;
import cn.fishei.competition.util.HttpClientUtil;
import cn.fishei.competition.util.QRCodeUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 桌号管理
 */
@RestController
@RequestMapping("/admin/table")
public class AdminTableController {

    @Autowired
    private ITableService tableService;

    //@Autowired
    //private WeixinProperties weixinProperties;

    @Autowired
    HttpClientUtil httpClientUtil;

    @Value("${qrcodeImgsFilePath}")
    private String qrcodeImgsFilePath;

    /**
     * 添加
     * @param table
     * @return
     */
    @PostMapping("/add")
    public R add(@RequestBody Table table){
        table.setTime(new Date());
        //System.out.println("accesstoken:"+this.getAccessToken());
        //table.setQrcode(genQrCodeImage(this.getAccessToken(),table.getNumber()));
        table.setQrcode(genQrCodeImage(table.getNumber()));
        tableService.save(table);
        return R.ok();
    }

    /**
     * 删除
     * @param id
     * @return
     */
    @GetMapping("/delete")
    public R delete(Integer id){
        tableService.removeById(id);
        return R.ok();
    }

    /**
     * 分页显示
     * @param pageBean
     * @return
     */
    @RequestMapping("/list")
    public R list(@RequestBody PageBean pageBean){
        System.out.println(pageBean);
        Map<String,Object> map=new HashMap<>();
        map.put("start",pageBean.getStart());
        map.put("pageSize",pageBean.getPageSize());
        List<Table> list=tableService.list(map);
        Long total =tableService.getTotal(map);
        Map<String,Object> resultMap=new HashMap<>();
        resultMap.put("tableList",list);
        resultMap.put("total",total);
        return R.ok(resultMap);
    }



    private String getAccessToken(){
        //String url="https://api.weixin.qq.com/cgi-bin/token" + "?grant_type=client_credential&appid=" + weixinProperties.getAppid()+ "&secret=" + weixinProperties.getSecret();
        String url="https://api.weixin.qq.com/cgi-bin/token" + "?grant_type=client_credential&appid=";
        System.out.println(url);
        String token = httpClientUtil.sendHttpGet(url);
        JSONObject jsonObject = JSON.parseObject(token);
        return jsonObject.get("access_token").toString();
    }

    private String genQrCodeImage(String accessToken,String table){
        Map<String, Object> body =new HashMap<>();
        body.put("path","pages/index/index?number="+table);
        String url="https://api.weixin.qq.com/wxa/getwxacode?access_token="+accessToken;
        try {
            ByteArrayInputStream bis = new ByteArrayInputStream(getWechatQrcodeByHttpClient(url,body));
            BufferedImage image = ImageIO.read(bis);
            String newFileName=table+"_"+ DateUtil.getCurrentDateStr()+".png";
            File output = new File(qrcodeImgsFilePath+newFileName);
            ImageIO.write(image, "png", output);
            return newFileName;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


    private String genQrCodeImage(String table){
        Map<String, Object> body =new HashMap<>();
        body.put("path","pages/index/index?number="+table);
        //String url="https://api.weixin.qq.com/wxa/getwxacode?access_token="+accessToken;
        try {
            BufferedImage image = QRCodeUtil.getBufferedImage(table);
            String newFileName=table+"_"+ DateUtil.getCurrentDateStr()+".png";
            File output = new File(qrcodeImgsFilePath+newFileName);
            ImageIO.write(image, "png", output);
            return newFileName;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private  byte[] getWechatQrcodeByHttpClient(String url, Map<String, Object> body) {
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        HttpPost httpPost = new HttpPost(url);
        try {
            StringEntity entity = new StringEntity(JSONObject.toJSONString(body));
            entity.setContentType("image/png");
            httpPost.setEntity(entity);
            HttpResponse response = httpClient.execute(httpPost);
            try (InputStream inputStream = response.getEntity().getContent();
                 ByteArrayOutputStream out = new ByteArrayOutputStream()) {
                byte[] buffer = new byte[1024];
                int len = -1;
                while ((len = inputStream.read(buffer)) != -1) {
                    out.write(buffer, 0, len);
                }
                return out.toByteArray();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
