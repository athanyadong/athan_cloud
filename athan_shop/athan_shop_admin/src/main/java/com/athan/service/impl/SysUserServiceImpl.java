package com.athan.service.impl;

import com.alibaba.fastjson.JSON;
import com.athan.constants.UserConstants;
import com.athan.doman.R;

import com.athan.mapper.SysUserMapper;
import com.athan.service.SysUserService;
import com.athan.user.dto.LoginDTO;
import com.athan.user.model.SysUser;
import com.athan.util.web.AjaxResult;
import com.sun.org.apache.xpath.internal.operations.Bool;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import javax.annotation.Resource;

/**
 * @aurhor yyh
 * @description
 * @date 2022/7/13 17:07
 */
@Service
@Slf4j
public class SysUserServiceImpl implements SysUserService {

    @Resource
    SysUserMapper userMapper;

    /**
     * 通过用户名查询用户
     *
     * @param userName 用户名
     * @return 用户对象信息
     */

    public R<LoginDTO> selectUserByUserName(String userName) {
        SysUser sysUser = userMapper.selectUserByUserName(userName);
        log.info("通过用户名查询用户 ----》   获取到的用户名信息为:{}", JSON.toJSONString(sysUser));
        if (sysUser != null) {
            LoginDTO loginDTO = new LoginDTO();
            loginDTO.setSysUser(sysUser);
            log.info("通过用户名查询用户 --> 添加好的信息为：{}", JSON.toJSONString(loginDTO));
            return R.ok(loginDTO);
        }
        return R.fail();
    }

    //添加用户信息
    public R<Boolean> register(SysUser sysUser) {
        //检查用户名是否重复
        String s = checkUserNameUnique(sysUser.getUserName());
        if (s.equals("1")) {
            return R.fail("用户名已存在");
        }
        return R.ok(registerUser(sysUser));
    }

    /**
     * 注册用户信息
     *
     * @param user 用户信息
     * @return 结果
     */

    public boolean registerUser(SysUser user) {
        return userMapper.insertUser(user) > 0;
    }

    /**
     * 校验用户名称是否唯一
     *
     * @param userName 用户名称
     * @return 结果
     */
    public String checkUserNameUnique(String userName) {
        int count = userMapper.checkUserNameUnique(userName);
        if (count > 0) {
            return UserConstants.NOT_UNIQUE;
        }
        return UserConstants.UNIQUE;
    }


}
