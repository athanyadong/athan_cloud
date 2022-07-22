package com.athan.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.athan.model.PmsComment;
import com.athan.service.PmsCommentService;
import com.athan.mapper.PmsCommentMapper;
import org.springframework.stereotype.Service;

/**
* @author Administrator
* @description 针对表【pms_comment(商品评价表)】的数据库操作Service实现
* @createDate 2022-07-22 16:53:04
*/
@Service
public class PmsCommentServiceImpl extends ServiceImpl<PmsCommentMapper, PmsComment>
    implements PmsCommentService{

}




