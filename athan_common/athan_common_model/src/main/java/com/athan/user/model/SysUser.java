package com.athan.user.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;

/**
* 用户信息表
* @TableName sys_user
*/
@Data
public class SysUser implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
    * 用户ID
    */
    @NotNull(message="[用户ID]不能为空")
    @ApiModelProperty("用户ID")
    private Long userId;
    /**
    * 部门ID
    */
    @ApiModelProperty("部门ID")
    private Long deptId;
    /**
    * 用户账号
    */
    @NotBlank(message="[用户账号]不能为空")
    @Size(max= 30,message="编码长度不能超过30")
    @ApiModelProperty("用户账号")
    private String userName;
    /**
    * 用户昵称
    */
    @NotBlank(message="[用户昵称]不能为空")
    @Size(max= 30,message="编码长度不能超过30")
    @ApiModelProperty("用户昵称")
    private String nickName;
    /**
    * 用户类型（00系统用户）
    */
    @Size(max= 2,message="编码长度不能超过2")
    @ApiModelProperty("用户类型（00系统用户）")
    private String userType;
    /**
    * 用户邮箱
    */
    @Size(max= 50,message="编码长度不能超过50")
    @ApiModelProperty("用户邮箱")
    private String email;
    /**
    * 手机号码
    */
    @Size(max= 11,message="编码长度不能超过11")
    @ApiModelProperty("手机号码")
    private String phonenumber;
    /**
    * 用户性别（0男 1女 2未知）
    */
    @ApiModelProperty("用户性别（0男 1女 2未知）")
    private String sex;
    /**
    * 头像地址
    */
    @Size(max= 100,message="编码长度不能超过100")
    @ApiModelProperty("头像地址")
    private String avatar;
    /**
    * 密码
    */
    @Size(max= 100,message="编码长度不能超过100")
    @ApiModelProperty("密码")
    private String password;
    /**
    * 帐号状态（0正常 1停用）
    */
    @ApiModelProperty("帐号状态（0正常 1停用）")
    private String status;
    /**
    * 删除标志（0代表存在 2代表删除）
    */
    @ApiModelProperty("删除标志（0代表存在 2代表删除）")
    private String delFlag;
    /**
    * 最后登录IP
    */
    @Size(max= 128,message="编码长度不能超过128")
    @ApiModelProperty("最后登录IP")
    private String loginIp;
    /**
    * 最后登录时间
    */
    @ApiModelProperty("最后登录时间")
    private Date loginDate;
    /**
    * 创建者
    */
    @Size(max= 64,message="编码长度不能超过64")
    @ApiModelProperty("创建者")
    private String createBy;
    /**
    * 创建时间
    */
    @ApiModelProperty("创建时间")
    private Date createTime;
    /**
    * 更新者
    */
    @Size(max= 64,message="编码长度不能超过64")
    @ApiModelProperty("更新者")
    private String updateBy;
    /**
    * 更新时间
    */
    @ApiModelProperty("更新时间")
    private Date updateTime;
    /**
    * 备注
    */
    @Size(max= 500,message="编码长度不能超过500")
    @ApiModelProperty("备注")
    private String remark;


}
