package com.athan.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.athan.model.PmsProductCategoryAttributeRelation;
import com.athan.service.PmsProductCategoryAttributeRelationService;
import com.athan.mapper.PmsProductCategoryAttributeRelationMapper;
import org.springframework.stereotype.Service;

/**
* @author Administrator
* @description 针对表【pms_product_category_attribute_relation(产品的分类和属性的关系表，用于设置分类筛选条件（只支持一级分类）)】的数据库操作Service实现
* @createDate 2022-07-22 16:53:04
*/
@Service
public class PmsProductCategoryAttributeRelationServiceImpl extends ServiceImpl<PmsProductCategoryAttributeRelationMapper, PmsProductCategoryAttributeRelation>
    implements PmsProductCategoryAttributeRelationService{

}




