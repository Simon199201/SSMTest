package com.itheima.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.itheima.domain.ResponseBean;
import com.itheima.domain.User;
import com.itheima.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    private ObjectMapper objectMapper = new ObjectMapper();

    @RequestMapping("login.action")
    @ResponseBody
    public String login(String username, String password, HttpSession session) throws JsonProcessingException {
        System.out.println("UserController login username is " + username + "\tpassword is " + password);
        User user = userService.login(username, password);
        ResponseBean responseBean = new ResponseBean();
        if (user != null) {
            session.setAttribute("user", user);
            responseBean.setCode(0);
            responseBean.setMsg("success");
            return objectMapper.writeValueAsString(responseBean);
        } else {
            responseBean.setCode(1);
            responseBean.setMsg("username or password invalid");
            return objectMapper.writeValueAsString(responseBean);
        }

    }

    @RequestMapping("userList.action")
    @ResponseBody
    public String userList() throws JsonProcessingException {
        List<User> userList = userService.findAllUser();
        System.out.println("userList is " + userList);
        ResponseBean responseBean = new ResponseBean();
        if (userList != null) {
            responseBean.setCode(0);
            responseBean.setMsg("success");
            responseBean.setData(userList);
            return objectMapper.writeValueAsString(responseBean);
        } else {
            responseBean.setCode(1);
            responseBean.setMsg("error ");
            return objectMapper.writeValueAsString(responseBean);
        }
    }

    @RequestMapping("findUser.action")
    @ResponseBody
    public String findUserByName(String username) throws JsonProcessingException {
        System.out.println("findUserByName username is " + username);
        List<User> userList = userService.findUserByName(username);
        System.out.println("userList is " + userList);
        ResponseBean responseBean = new ResponseBean();
        if (userList != null) {
            responseBean.setCode(0);
            responseBean.setMsg("success");
            responseBean.setData(userList);
            return objectMapper.writeValueAsString(responseBean);
        } else {
            responseBean.setCode(1);
            responseBean.setMsg("error ");
            return objectMapper.writeValueAsString(responseBean);
        }
    }

    @RequestMapping(value = "findUserAndAccount.action", method = RequestMethod.POST)
    @ResponseBody
    public String findUserAndAccount(int uid) throws JsonProcessingException {
        System.out.println("findUserAndAccount id is " + uid);
        User user = userService.findUserAndAccount("" + uid);
        System.out.println("user is " + user);
        ResponseBean responseBean = new ResponseBean();
        if (user != null) {
            responseBean.setCode(0);
            responseBean.setMsg("success");
            responseBean.setData(user);
            return objectMapper.writeValueAsString(responseBean);
        } else {
            responseBean.setCode(1);
            responseBean.setMsg("error ");
            return objectMapper.writeValueAsString(responseBean);
        }
    }

    @RequestMapping("deleteUser.action")
    @ResponseBody
    public String deleteUser(String id) throws JsonProcessingException {
        userService.deleteUser(id);
        List<User> userList = userService.findAllUser();
        System.out.println("userList is " + userList);
        ResponseBean responseBean = new ResponseBean();
        if (userList != null) {
            responseBean.setCode(0);
            responseBean.setMsg("success");
            responseBean.setData(userList);
            return objectMapper.writeValueAsString(responseBean);
        } else {
            responseBean.setCode(1);
            responseBean.setMsg("error ");
            return objectMapper.writeValueAsString(responseBean);
        }
    }

    @RequestMapping("modifyUserUrl.action")
    @ResponseBody
    public String modifyUserUrl(User user) throws JsonProcessingException {
        System.out.println("user is " + user.toString());
        userService.modifyUser(user);
        ResponseBean responseBean = new ResponseBean();
        responseBean.setCode(0);
        responseBean.setMsg("success");
        return objectMapper.writeValueAsString(responseBean);
    }
}
