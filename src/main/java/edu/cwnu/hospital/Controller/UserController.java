package edu.cwnu.hospital.Controller;

import edu.cwnu.hospital.Pojo.User;
import edu.cwnu.hospital.Service.UserService;
import edu.cwnu.hospital.utils.MTimeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService service;
    @RequestMapping("/select")
    public String select(HttpServletRequest request, Model model){
        User user= (User) request.getSession().getAttribute("user");
        model.addAttribute("user",user);

        return "User/info";

    }
    @RequestMapping("/show")
    public String show(HttpServletRequest request, Model model){
        User user= (User) request.getSession().getAttribute("user");
        model.addAttribute("user",user);
        return "User/update";

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
//       System.out.print(request.getParameter("number"));
//        System.out.print(request.getParameter("date"));
//        System.out.print(request.getParameter("phone"));
//        System.out.print(request.getParameter("u_gender"));
          service.updateAll(user);
          model.addAttribute("user",user);
//        return "User/info";
        return "User/info";

    }

}
