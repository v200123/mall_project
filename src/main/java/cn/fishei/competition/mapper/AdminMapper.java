package cn.fishei.competition.mapper;

import cn.fishei.competition.bean.Admin;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;


/**
 * 管理员Mapper接口
 */
public interface AdminMapper extends BaseMapper<Admin> {

    /**
     * 修改
     * @param admin
     * @return
     */
    public Integer update(Admin admin);

}
