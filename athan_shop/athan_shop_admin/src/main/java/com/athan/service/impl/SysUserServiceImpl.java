package com.athan.service.impl;

import com.athan.doman.R;
import com.athan.dto.LoginDTO;
import com.athan.mapper.SysUserMapper;
import com.athan.model.SysUser;
import com.athan.service.SysUserService;
import com.athan.util.web.AjaxResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @aurhor yyh
 * @description
 * @date 2022/7/13 17:07
 */
@Service
public class SysUserServiceImpl implements SysUserService {

    @Resource
    SysUserMapper userMapper;

    /**
     * 通过用户名查询用户
     *
     * @param userName 用户名
     * @return 用户对象信息
     */

    public R selectUserByUserName(String userName)
    {
        SysUser sysUser = userMapper.selectUserByUserName(userName);

        if (sysUser!=null) {
            LoginDTO loginDTO=new LoginDTO();
            loginDTO.setSysUser(sysUser);
            return R.ok(loginDTO);
        }
        return R.fail();
    }
}
