package com.moxin.design_pattern.service;

import com.moxin.design_pattern.entity.FoodTemplate;
import org.apache.shiro.subject.Subject;

import java.util.List;

/**
 * @auther moxinHuoHuo
 * @createDate 2019/10/16 9:57
 */
public interface FoodTemplateService {

    // 获取菜品模板的所有信息
    List<FoodTemplate> selectAll(String sellerId, Integer storeId);

}
