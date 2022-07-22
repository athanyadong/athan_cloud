package com.athan.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 产品评价回复表
 * @TableName pms_comment_replay
 */
@TableName(value ="pms_comment_replay")
@Data
public class PmsCommentReplay implements Serializable {
    /**
     * 
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 
     */
    private Long commentId;

    /**
     * 
     */
    private String memberNickName;

    /**
     * 
     */
    private String memberIcon;

    /**
     * 
     */
    private String content;

    /**
     * 
     */
    private Date createTime;

    /**
     * 评论人员类型；0->会员；1->管理员
     */
    private Integer type;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}