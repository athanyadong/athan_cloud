package com.athan.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 商品评价表
 * @TableName pms_comment
 */
@TableName(value ="pms_comment")
@Data
public class PmsComment implements Serializable {
    /**
     * 
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 
     */
    private Long productId;

    /**
     * 
     */
    private String memberNickName;

    /**
     * 
     */
    private String productName;

    /**
     * 评价星数：0->5
     */
    private Integer star;

    /**
     * 评价的ip
     */
    private String memberIp;

    /**
     * 
     */
    private Date createTime;

    /**
     * 
     */
    private Integer showStatus;

    /**
     * 购买时的商品属性
     */
    private String productAttribute;

    /**
     * 
     */
    private Integer collectCouont;

    /**
     * 
     */
    private Integer readCount;

    /**
     * 
     */
    private String content;

    /**
     * 上传图片地址，以逗号隔开
     */
    private String pics;

    /**
     * 评论用户头像
     */
    private String memberIcon;

    /**
     * 
     */
    private Integer replayCount;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}