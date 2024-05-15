package cn.fishei.competition.service;

import cn.fishei.competition.bean.Admin;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 管理员Service接口
 */
public interface IAdminService extends IService<Admin> {

    /**
     * 修改
     * @param admin
     * @return
     */
    public Integer update(Admin admin);

}
