package edu.cwnu.hospital.Controller;

import edu.cwnu.hospital.Pojo.Hospital;
import edu.cwnu.hospital.Pojo.User;
import edu.cwnu.hospital.Service.HospitalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/hospital")
public class HospitalController {
    @Autowired
    private HospitalService hospitalService;
    @RequestMapping("/findAll")
    public String findAll(HttpServletRequest request, Model model){
        User user = (User) request.getSession().getAttribute("user");
        model.addAttribute("user",user);
        List<Hospital> hospitals = hospitalService.findAll();
        model.addAttribute("hospitals",hospitals);
        return "Admin/AllHospital";

    }
    @RequestMapping("/{h_id}/hospitalInfo")
    public String hospitalInfo(HttpServletRequest request, Model model, @PathVariable int h_id){
        User user = (User) request.getSession().getAttribute("user");
        model.addAttribute("user",user);
//        System.out.print(h_id);
        Hospital hospital = hospitalService.findById(h_id);
        model.addAttribute("hospital",hospital);
        return "Admin/HospitalInfo";
    }
    @RequestMapping("/echarts")
    public String echarts(HttpServletRequest request,Model model){
        User user= (User) request.getSession().getAttribute("user");
        model.addAttribute("user",user);
        return "Admin/Echarts";
    }
}
