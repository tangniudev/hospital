package edu.cwnu.hospital.Controller;


import edu.cwnu.hospital.Pojo.User;
import edu.cwnu.hospital.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class IndexController {
    @Autowired
    private UserService service;

    @RequestMapping("/welcome")
    public String welcome(HttpServletRequest request,Model model){
        HttpSession session = request.getSession();
        String u_number=  request.getParameter("number");
        System.out.print(u_number);
        String u_password=  request.getParameter("password");
        int number=Integer.parseInt(u_number);
        int password=Integer.parseInt(u_password);
        User user=service.login(number,password);
        if (user==null) {
            return "login";
        }else {
            session.setAttribute("user",user);
            model.addAttribute("user",user);


            return "welcome";
        }

    }
    @RequestMapping("/login")
   public String login(){

        return "login";
    }
    @RequestMapping("/index")
    public  String index(HttpServletRequest request,Model model){
        model.addAttribute("user",request.getSession().getAttribute("user"));
        return "welcome";
    }
    @RequestMapping("/")
    public String abc(){
        return "index";
    }


}
