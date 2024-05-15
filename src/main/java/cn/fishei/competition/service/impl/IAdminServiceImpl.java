package cn.fishei.competition.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.fishei.competition.bean.Admin;
import cn.fishei.competition.mapper.AdminMapper;
import cn.fishei.competition.service.IAdminService;



/**
 * 管理员Service实现类
 */

@Service("adminService")
public class IAdminServiceImpl extends ServiceImpl<AdminMapper,Admin> implements IAdminService {

    @Autowired
    private AdminMapper adminMapper;


    @Override
    public Integer update(Admin admin) {
        return adminMapper.update(admin);
    }
}