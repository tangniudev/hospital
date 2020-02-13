package edu.cwnu.hospital.Controller;

import edu.cwnu.hospital.Pojo.Hospital;
import edu.cwnu.hospital.Pojo.User;
import edu.cwnu.hospital.Service.HospitalService;
import edu.cwnu.hospital.Service.UserService;
import edu.cwnu.hospital.utils.MTimeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private UserService service;
    @Autowired
    private HospitalService hospitalService;

    @RequestMapping("/login")
    public String login(){
        return "Admin/Alogin";
    }
    @RequestMapping("/welcome")
    public String welcome(HttpServletRequest request, Model model) {
        HttpSession session = request.getSession();
        String u_number = request.getParameter("number");
        System.out.print(u_number);
        String u_password = request.getParameter("password");
        int number = Integer.parseInt(u_number);
        int password = Integer.parseInt(u_password);
        User user = service.login(number, password);
        if (user == null) {
            return "login";
        } else {
            session.setAttribute("user", user);
            model.addAttribute("user", user);


            return "Admin/Awelcome";
        }
    }
    @RequestMapping("index")
    public String index(HttpServletRequest request,Model model){
        User user = (User) request.getSession().getAttribute("user");
        model.addAttribute("user", user);
        return "Admin/Awelcome";
    }
    @RequestMapping("/select")
    public String select(HttpServletRequest request, Model model) {
        User user = (User) request.getSession().getAttribute("user");
        model.addAttribute("user", user);

        return "Admin/Ainfo";
    }
    @RequestMapping("/update")
    public String update(HttpServletRequest request, Model model){
        User user= (User) request.getSession().getAttribute("user");
        user.setU_mail(request.getParameter("email"));
        user.setU_number(Integer.parseInt(request.getParameter("number")));
        user.setU_birthday(MTimeUtil.stringParse(request.getParameter("date")));
        user.setU_name(request.getParameter("name"));
        user.setU_password(Integer.parseInt(request.getParameter("password")));
        user.setU_phone(request.getParameter("phone"));
        user.setU_address(request.getParameter("address"));
        user.setU_gender(request.getParameter("u_gender"));
        user.setU_totle(Integer.parseInt(request.getParameter("total")));
        user.setU_type(request.getParameter("type"));

        service.updateAll(user);
        model.addAttribute("user",user);

        return "Admin/Ainfo";

    }
    @RequestMapping("/show")
    public String show(HttpServletRequest request, Model model){
        User user= (User) request.getSession().getAttribute("user");
        model.addAttribute("user",user);
        return "Admin/Aupdate";

    }
    @RequestMapping("/hospital")
    public String hospital(HttpServletRequest request,Model model){
        List<Hospital> all = hospitalService.findAll();
        for (Hospital h:all) {
            System.out.println(h);
        }
        return "demo";
    }

}
