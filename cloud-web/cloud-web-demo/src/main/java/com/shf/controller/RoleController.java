package com.shf.controller;

import com.shf.tool.Response;
import lombok.extern.slf4j.Slf4j;

//import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 描述：
 *
 * @Author shf
 * @Date 2019/7/1 16:47
 * @Version V1.0
 **/
@RestController
@Slf4j
public class RoleController {
//    @PreAuthorize("hasAuthority('admin:get')")
    @RequestMapping("/admin/get")
    public Response adminGet(HttpServletRequest request, HttpServletResponse response){
        Response result = new Response();
        result.buildSuccessResponse("admin有权限访问");
        log.info("admin有权限访问");
        return result;
    }
//    @PreAuthorize("hasAuthority('vip:get')")
    @RequestMapping("/vip/get")
    public Response vipGet(){
        Response response = new Response();
        response.buildSuccessResponse("admin，vip有权限访问");
        log.info("admin，vip有权限访问");
        return response;
    }
//    @PreAuthorize("hasAuthority('user:get')")
    @RequestMapping("/user/get")
    public Response userGet(){
        Response response = new Response();
        response.buildSuccessResponse("admin，vip，user有权限访问");
        log.info("admin，vip，user有权限访问");
        return response;
    }
}
