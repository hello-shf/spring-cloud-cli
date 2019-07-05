package com.shf.service.impl;

import com.shf.dao.PermissionDao;
import com.shf.entity.user.TPermission;
import com.shf.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 描述：
 *
 * @Author shf
 * @Date 2019/7/1 20:56
 * @Version V1.0
 **/
@Service
public class PermissionServiceImpl implements PermissionService {
    @Autowired
    private PermissionDao permissionDao;

    @Override
    public List<TPermission> findByName(String username) {
        return permissionDao.findByName(username);
    }
}
