package com.lucas.blog.myblog.service;

import java.util.List;

/**
 * @ProjectName: myblog
 * @Package: com.lucas.blog.myblog.service
 * @ClassName: PermissionService
 * @Author: Heyuanhui
 * @Description: ${description}
 * @Date: 2019/12/30 20:52
 * @Version: 1.0
 */
public interface PermissionService {


	List<com.lucas.blog.myblog.entity.Permission> getPermissionsByRoleName(String roleName);
}
