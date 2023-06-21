package com.wayne.blog.strategy;

import com.wayne.blog.dto.UserInfoDTO;

/**
 * 第三方登录策略
 *
 * @author wayne
 * @date 2021/07/28
 */
public interface SocialLoginStrategy {

    /**
     * 登录
     *
     * @param data 数据
     * @return {@link UserInfoDTO} 用户信息
     */
    UserInfoDTO login(String data);

}
