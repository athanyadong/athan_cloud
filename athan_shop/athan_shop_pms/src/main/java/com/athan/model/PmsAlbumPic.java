package com.athan.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 画册图片表
 * @TableName pms_album_pic
 */
@TableName(value ="pms_album_pic")
@Data
public class PmsAlbumPic implements Serializable {
    /**
     * 
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 
     */
    private Long albumId;

    /**
     * 
     */
    private String pic;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}