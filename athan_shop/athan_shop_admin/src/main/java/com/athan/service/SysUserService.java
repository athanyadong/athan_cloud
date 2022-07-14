package com.athan.service;


import com.athan.doman.R;
import com.athan.user.dto.LoginDTO;
import com.athan.user.model.SysUser;

public interface SysUserService {

    public R<LoginDTO> selectUserByUserName(String userName);
    public R<Boolean> register(SysUser sysUser);
    public boolean registerUser(SysUser user);
}
