package com.wayne.blog.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.wayne.blog.vo.PageResult;
import com.wayne.blog.dto.RoleDTO;
import com.wayne.blog.dto.UserRoleDTO;
import com.wayne.blog.entity.Role;
import com.wayne.blog.vo.ConditionVO;
import com.wayne.blog.vo.RoleVO;

import java.util.List;

/**
 * 角色服务
 *
 * @author wayne
 * @date 2021/08/10
 */
public interface RoleService extends IService<Role> {

    /**
     * 获取用户角色选项
     *
     * @return 角色
     */
    List<UserRoleDTO> listUserRoles();

    /**
     * 查询角色列表
     *
     * @param conditionVO 条件
     * @return 角色列表
     */
    PageResult<RoleDTO> listRoles(ConditionVO conditionVO);

    /**
     * 保存或更新角色
     *
     * @param roleVO 角色
     */
    void saveOrUpdateRole(RoleVO roleVO);

    /**
     * 删除角色
     * @param roleIdList 角色id列表
     */
    void deleteRoles(List<Integer> roleIdList);

}
