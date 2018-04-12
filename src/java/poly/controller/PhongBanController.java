/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poly.controller;

import bean.controller.PhongBan;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import model.controller.PhongBanModel;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author hoanghai
 */
@Controller
@RequestMapping("/phongban/")
public class PhongBanController {
     @RequestMapping("showall")
    public String showAll(ModelMap model){
        PhongBanModel st = new PhongBanModel();
        List<PhongBan> list = new ArrayList<PhongBan>();
        list = st.showPhongBan("");
        model.addAttribute("listPhongBan", list);
        PhongBan sv = new PhongBan();
        sv = list.get(0);
        model.addAttribute("Departs", sv);
        return "phongban";
    }
    
    @RequestMapping("edit")
    public String edit(HttpServletRequest request, ModelMap model) {
        String id = request.getParameter("txtMaPB");
        String tenpb = request.getParameter("txtTenPB");
        PhongBan sv = new PhongBan(id, tenpb);
        model.addAttribute("Departs", sv);
        List<PhongBan> list = new ArrayList<PhongBan>();
        list = PhongBanModel.showPhongBan("");
        model.addAttribute("listPhongBan", list);
        return "phongban";
    }

    @RequestMapping("delete")
    public String delete(HttpServletRequest request, ModelMap model,
            @ModelAttribute("Departs") PhongBan Departs) {
        String id = request.getParameter("txtMaPB");
        PhongBanModel.delete(id);
        List<PhongBan> list = new ArrayList<PhongBan>();
        list = PhongBanModel.showPhongBan("");
        model.addAttribute("listPhongBan", list);
        return "phongban";
    }

    @RequestMapping(params = "btnUpdate")
    public String update(@ModelAttribute("Departs") PhongBan Departs, ModelMap model) {
        PhongBanModel.update(Departs);
        List<PhongBan> list = new ArrayList<PhongBan>();
        list = PhongBanModel.showPhongBan("");
        model.addAttribute("listPhongBan", list);
        return "phongban";
    }

    @RequestMapping(params="btnInsert")
    public String insert(@ModelAttribute("Departs") PhongBan Departs, ModelMap model){
        PhongBanModel.insert(Departs);
        List<PhongBan> list = new ArrayList<PhongBan>();
        list = PhongBanModel.showPhongBan("");
        model.addAttribute("listPhongBan", list);
        return "phongban";
    }

    @RequestMapping(params="btnSearch")
    public String Search(HttpServletRequest request, ModelMap model, 
            @ModelAttribute("Departs") PhongBan Departs){
        String name =request.getParameter("txtSearch");
        PhongBanModel.showPhongBan(name);
        
        List<PhongBan> list = new ArrayList<PhongBan>();
        list = PhongBanModel.showPhongBan(name);
        model.addAttribute("listPhongBan", list);
        return "phongban";
    }

    
}
