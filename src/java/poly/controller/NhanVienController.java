/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poly.controller;

import bean.controller.NhanVien;
import java.util.ArrayList;
import java.util.List;
import model.controller.NhanVienModel;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author hoanghai
 */
@Controller
@RequestMapping("/nhanvien/")
public class NhanVienController {

    @RequestMapping("showall")
    public String showAll(ModelMap model) {
        
        NhanVienModel st = new NhanVienModel();
        List<NhanVien> list = new ArrayList<NhanVien>();
        
        list = st.showNhanVien("");
        
//        if (list.isEmpty()) {
//            model.addAttribute("tt", "Rong");
//            return "nhanvien";
//        }else{
//        model.addAttribute("tt", "co");
//            return "nhanvien";
//        }
        
        model.addAttribute("listNhanVien", list);

        NhanVien sv = new NhanVien();
        sv = list.get(0);
        model.addAttribute("Staff", sv);
        return "nhanvien";
    }
}
