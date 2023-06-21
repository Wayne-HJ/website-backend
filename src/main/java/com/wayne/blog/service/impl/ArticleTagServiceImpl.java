package com.wayne.blog.service.impl;

import com.wayne.blog.entity.ArticleTag;
import com.wayne.blog.dao.ArticleTagDao;
import com.wayne.blog.service.ArticleTagService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * 文章标签服务
 *
 * @author wayne
 * @date 2021/08/10
 */
@Service
public class ArticleTagServiceImpl extends ServiceImpl<ArticleTagDao, ArticleTag> implements ArticleTagService {

}
