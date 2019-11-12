package com.moxin.design_pattern.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @auther moxinHuoHuo
 * @createDate 2019/10/16 10:00
 */
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class FoodTemplate {

    private String foodName;

    private Integer price;

}
