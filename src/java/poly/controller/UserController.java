/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poly.controller;

import bean.controller.PhongBan;
import bean.controller.User;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import model.controller.UserModel;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author hoanghai
 */
@Controller
@RequestMapping("/user/")
public class UserController {
    @RequestMapping("showall")
    public String showAll(ModelMap model){
        UserModel st = new UserModel();
        List<User> list = new ArrayList<User>();
        list = st.showUser("");
        model.addAttribute("listUser", list);
        User sv = new User();
        sv = list.get(0);
        model.addAttribute("User", sv);
        return "user";
    }
    
    @RequestMapping("edit")
    public String edit(HttpServletRequest request, ModelMap model) {
        String user = request.getParameter("txtUsername");
        String pass = request.getParameter("txtPassword");
        String full = request.getParameter("txtFullname");
        User sv = new User(user, pass, full);
        model.addAttribute("User", sv);
        List<User> list = new ArrayList<User>();
        list = UserModel.showUser("");
        model.addAttribute("listUser", list);
        return "user";
    }

    @RequestMapping("delete")
    public String delete(HttpServletRequest request, ModelMap model,
            @ModelAttribute("user") User user) {
        String id = request.getParameter("txtUsername");
        UserModel.delete(id);
        List<User> list = new ArrayList<User>();
        list = UserModel.showUser("");
        model.addAttribute("listUser", list);
        return "user";
    }

    @RequestMapping(params = "btnUpdate")
    public String update(@ModelAttribute("user") User user, ModelMap model) {
        UserModel.update(user);
        List<User> list = new ArrayList<User>();
        list = UserModel.showUser("");
        model.addAttribute("listUser", list);
        return "user";
    }

    @RequestMapping(params="btnInsert")
    public String insert(@ModelAttribute("user") User user, ModelMap model){
        UserModel.insert(user);
        List<User> list = new ArrayList<User>();
        list = UserModel.showUser("");
        model.addAttribute("listUser", list);
        return "user";
    }

    @RequestMapping(params="btnSearch")
    public String Search(HttpServletRequest request, ModelMap model, 
            @ModelAttribute("user") User user){
        String name =request.getParameter("txtSearch");
        UserModel.showUser(name);
        
        List<User> list = new ArrayList<User>();
        list = UserModel.showUser(name);
        model.addAttribute("listUser", list);
        return "user";
    }
}
