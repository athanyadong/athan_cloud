package com.athan.service;


import com.alibaba.fastjson.JSON;
import com.alibaba.nacos.shaded.com.google.protobuf.ServiceException;
import com.athan.RemoteLogService;
import com.athan.SysUserService;
import com.athan.constants.Constants;
import com.athan.constants.UserConstants;

import com.athan.doman.R;
import com.athan.user.dto.LoginDTO;
import com.athan.user.model.LogInfo;
import com.athan.user.model.SysUser;
import com.athan.util.SecurityUtils;
import com.athan.util.ServletUtils;
import com.athan.util.ip.IpUtils;
import com.athan.util.web.AjaxResult;
import com.athan.util.web.HttpStatus;


import com.athan.util.web.StringUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @aurhor yyh
 * @description 登录校验
 * @date 2022/7/13 15:27
 */
@Component
@Slf4j
public class LoginService {


    @Resource
    private RemoteLogService remoteLogService;
    @Resource
    private SysUserService sysUserService;

    /**
     * 登录
     *
     * @param userName
     * @param passWord
     * @return
     */
    public AjaxResult login(String userName, String passWord) {
        //查看是否都是空的
        if (StringUtils.isAnyBlank(userName, passWord)) {
            recordLogininfor(userName, "登录失败", "用户/密码必须填写");
            return AjaxResult.error(HttpStatus.ERROR, "用户名或密码不得为空");
        }
        //如果密码不在指定范围内  长度是否小于五
        if (passWord.length() < UserConstants.PASSWORD_MIN_LENGTH || passWord.length() > UserConstants.PASSWORD_MAX_LENGTH) {
            recordLogininfor(userName, "登录失败", "密码不在指定范围");
            return AjaxResult.error(HttpStatus.ERROR, "密码必须在指定范围内");
        }
        //用户名的指定范围

        if (userName.length() < UserConstants.USERNAME_MIN_LENGTH || userName.length() > UserConstants.USERNAME_MAX_LENGTH) {
            recordLogininfor(userName, "登录失败", "用户名不在指定范围");
            return AjaxResult.error(HttpStatus.ERROR, "用户名必须在指定范围内");
        }
        //获取用户信息
        R<LoginDTO> userResult = sysUserService.selectUserByUserName(userName);
        if (userResult.getCode()== HttpStatus.ERROR) {
            return AjaxResult.error("发生错误信息");
        }
        if (StringUtils.isNull(userResult) || StringUtils.isNull(userResult.getData())){
            recordLogininfor(userName, Constants.LOGIN_FAIL, "登录用户不存在");
            return AjaxResult.error("登录用户：" + userName + " 不存在");
        }
        LoginDTO data =  userResult.getData();
        log.info("响应中获取到的信息为:{}", JSON.toJSONString(data));
        SysUser user = (userResult.getData()).getSysUser();
        //检验密码是否正确
        if (!SecurityUtils.matchesPassword(passWord, user.getPassword()))
        {
            recordLogininfor(passWord, Constants.LOGIN_FAIL, "用户密码错误");
            return AjaxResult.error("密码错误");
        }
        recordLogininfor(userName, Constants.LOGIN_SUCCESS, "登录成功");

        return AjaxResult.success(data);
    }

    /**
     * 进行注册
     * @param userName
     * @param passWord
     * @return
     */
    public AjaxResult register(String userName, String passWord) {
        //检查用户名是否存在，邮箱是否存在
        return null;
    }



    //记录登录信息的日志
    private void recordLogininfor(String userName, String status, String message) {
        LogInfo logininfor = new LogInfo();
        logininfor.setUserName(userName);
        logininfor.setIpaddr(IpUtils.getIpAddr(ServletUtils.getRequest()));
        logininfor.setMsg(message);
        // 日志状态  登陆成功
        if (StringUtils.equalsAny(status, Constants.LOGIN_SUCCESS, Constants.LOGOUT, Constants.REGISTER)) {
            logininfor.setStatus(Constants.LOGIN_SUCCESS_STATUS);
        }
        //登陆失败
        else if (Constants.LOGIN_FAIL.equals(status)) {
            logininfor.setStatus(Constants.LOGIN_FAIL_STATUS);
        }
        remoteLogService.saveLogininfor(logininfor);
    }
}
