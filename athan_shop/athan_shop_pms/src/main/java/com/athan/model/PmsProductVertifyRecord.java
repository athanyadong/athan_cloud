package com.athan.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 商品审核记录
 * @TableName pms_product_vertify_record
 */
@TableName(value ="pms_product_vertify_record")
@Data
public class PmsProductVertifyRecord implements Serializable {
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
    private Date createTime;

    /**
     * 审核人
     */
    private String vertifyMan;

    /**
     * 
     */
    private Integer status;

    /**
     * 反馈详情
     */
    private String detail;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}