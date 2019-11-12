package com.moxin.design_pattern.service.impl;

import com.moxin.design_pattern.entity.FoodTemplate;
import com.moxin.design_pattern.entity.User;
import com.moxin.design_pattern.service.FoodTemplateService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/**
 * @auther moxinHuoHuo
 * @createDate 2019/10/16 9:57
 */
@Service
public class FoodTemplateServiceImpl implements FoodTemplateService {


    @Override
    @RequiresPermissions("foodTemplate:select")
    public List<FoodTemplate> selectAll(String sellerId, Integer storeId) {

        List<FoodTemplate> foodTemplateList = new ArrayList<>();

        for (int i = 0; i < 10 ; i++) {
            foodTemplateList.add(FoodTemplate.builder().foodName("咸鱼" + i + "号").price(i).build());
        }

        return foodTemplateList;
    }
}
