package cn.fishei.competition.bean;


import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.ibatis.type.Alias;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("goods")
public class Goods {
    private int id;
    private String price;
    private String name;
    private String description;
    private int sales;
    private String pic;
    private int categoryId;
    private int tagsId;
    private int status;
}
