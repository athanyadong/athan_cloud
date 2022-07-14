package com.athan.user.model;

import cn.afterturn.easypoi.excel.annotation.Excel;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @aurhor yyh
 * @description 登录信息
 * @date 2022/7/13 16:16
 */
@Data
public class LogInfo implements Serializable {
    private static final long serialVersionUID = 1L;

    /** ID */
    private Long infoId;

    /** 用户账号 */
    @Excel(name = "用户账号")
    private String userName;

    /** 状态 0成功 1失败 */
    private String status;

    /** 地址 */
    @Excel(name = "地址")
    private String ipaddr;

    /** 描述 */
    @Excel(name = "描述")
    private String msg;

    /** 访问时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date accessTime;
}
