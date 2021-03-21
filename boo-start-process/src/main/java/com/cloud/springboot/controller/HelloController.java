package com.cloud.springboot.controller;

import com.cloud.springboot.Listener.PersonInfo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @auther: wjx
 * @Date: 2021/1/7 13:35
 * @Description:
 */
@RestController
@RequestMapping("/hello")
public class HelloController {

    @GetMapping("/hello")
    public String hello(HttpServletRequest request){

        String realPath = request.getSession().getServletContext().getRealPath("/");
        System.out.println(realPath);
        System.out.println("hello...start..");
//        HttpSession session = request.getSession();
        HttpSession session = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).
                getRequest().getSession();
        session.setAttribute("person",new PersonInfo());
        System.out.println("hello...end..");
        session.removeAttribute("person");
        return "hello ok";
    }
}
