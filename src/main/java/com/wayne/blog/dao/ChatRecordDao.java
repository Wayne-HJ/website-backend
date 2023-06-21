package com.wayne.blog.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wayne.blog.entity.ChatRecord;
import org.springframework.stereotype.Repository;

/**
 * 聊天记录
 *
 * @author wayne
 * @date 2021/08/10
 */
@Repository
public interface ChatRecordDao extends BaseMapper<ChatRecord> {
}
