package com.wayne.blog.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.wayne.blog.dto.OperationLogDTO;
import com.wayne.blog.vo.PageResult;
import com.wayne.blog.entity.OperationLog;
import com.wayne.blog.vo.ConditionVO;

/**
 * 操作日志服务
 *
 * @author wayne
 * @date 2021/07/29
 */
public interface OperationLogService extends IService<OperationLog> {

    /**
     * 查询日志列表
     *
     * @param conditionVO 条件
     * @return 日志列表
     */
    PageResult<OperationLogDTO> listOperationLogs(ConditionVO conditionVO);

}
