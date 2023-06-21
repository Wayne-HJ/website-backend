package com.wayne.blog.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 时区枚举
 *
 * @author wayne
 * @date 2021/08/13
 */
@Getter
@AllArgsConstructor
public enum ZoneEnum {

    /**
     * 上海
     */
    SHANGHAI("Asia/Shanghai", "中国上海"),
    SYDNEY("Australia/Sydney", "悉尼");


    /**
     * 时区
     */
    private final String zone;

    /**
     * 描述
     */
    private final String desc;

}
