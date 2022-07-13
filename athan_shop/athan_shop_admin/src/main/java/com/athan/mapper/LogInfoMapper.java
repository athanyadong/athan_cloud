package com.athan.mapper;

import com.athan.model.LogInfo;

import java.util.List;

/**
 * @aurhor yyh
 * @description
 * @date 2022/7/13 16:49
 */
public interface LogInfoMapper {
    /**
     * 新增系统登录日志
     *
     * @param logininfor 访问日志对象
     */
    public int insertLogininfor(LogInfo logininfor);

    /**
     * 查询系统登录日志集合
     *
     * @param logininfor 访问日志对象
     * @return 登录记录集合
     */
    public List<LogInfo> selectLogininforList(LogInfo logininfor);

    /**
     * 批量删除系统登录日志
     *
     * @param infoIds 需要删除的登录日志ID
     * @return 结果
     */
    public int deleteLogininforByIds(Long[] infoIds);

    /**
     * 清空系统登录日志
     *
     * @return 结果
     */
    public int cleanLogininfor();
}
