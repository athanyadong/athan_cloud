package com.athan.mapper;


import com.athan.user.model.SysUser;

/**
 * 用户表 数据层
 *
 * @author ruoyi
 */
public interface SysUserMapper {

    /**
     * 通过用户名查询用户
     *
     * @param userName 用户名
     * @return 用户对象信息
     */
    public SysUser selectUserByUserName(String userName);

    /**
     * 通过用户ID查询用户
     *
     * @param userId 用户ID
     * @return 用户对象信息
     */
    public SysUser selectUserById(Long userId);
    //查看用户名称是否一致
    public int checkUserNameUnique(String userName);

    //添加用户信息
    int insertUser(SysUser user);
}
