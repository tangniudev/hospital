package edu.cwnu.hospital.Controller;

import edu.cwnu.hospital.Pojo.Blood;
import edu.cwnu.hospital.Pojo.Hospital;
import edu.cwnu.hospital.Pojo.User;
import edu.cwnu.hospital.Service.BloodService;
import edu.cwnu.hospital.Service.HospitalService;
import edu.cwnu.hospital.Service.UserService;
import edu.cwnu.hospital.utils.MTimeUtil;
import edu.cwnu.hospital.utils.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import static java.util.Calendar.YEAR;

@Controller
@RequestMapping("/blood")
public class BloodController {
    @Autowired
    private BloodService bloodService;
    @Autowired
    private HospitalService hospitalService;
    @Autowired
    private UserService userService;
    private HttpServletRequest request;
    private Model model;
    private int h_id;

    @RequestMapping("/findMyself")
    public String findMyself(HttpServletRequest request, Model model){
        User user = (User) request.getSession().getAttribute("user");
        List<Blood> boolds = bloodService.findMyself(user.getId());

        for (Blood blood:boolds) {
            setObject(blood);


        }
//        System.out.println(boolds);
        model.addAttribute("boolds",boolds);
        model.addAttribute("user",user);
        return "Blood/MyRecord";
    }
     public void setObject(Blood blood){
        blood.setHospital(hospitalService.findById(blood.getH_id()));
        blood.setUser(userService.fingById(blood.getU_id()));

     }
     @RequestMapping("/donate")
      public String order(HttpServletRequest request,Model model){
        User user= (User) request.getSession().getAttribute("user");
        model.addAttribute("user",user);
         List<Hospital> hospitals = hospitalService.findByAddress(user.getU_address());
         model.addAttribute("hospitals",hospitals);
         return "Blood/Donation";
     }
     @RequestMapping("/{h_id}/toaddblood")
     public String addblood(HttpServletRequest request, Model model, @PathVariable int h_id){
        User user= (User) request.getSession().getAttribute("user");
        model.addAttribute("user",user);
       Hospital hospital=hospitalService.findById(h_id);
       request.getSession().setAttribute("hospital",hospital);

       model.addAttribute("hospital",hospital);

      return "Blood/AddBlood";
     }
     @RequestMapping("/{h_id}/addblood")
    public String addblood(HttpServletRequest request,Model model){
         User user = (User) request.getSession().getAttribute("user");
         model.addAttribute("user",user);
         Hospital hospital= (Hospital) request.getSession().getAttribute("hospital");

         String date=request.getParameter("date");
         String capacity=request.getParameter("capacity");
         String type=request.getParameter("type");
         Date date1=MTimeUtil.stringParse(date);
         Calendar cal = Calendar.getInstance();
         cal.setTime(date1);
         cal.add(YEAR, 3);
         Date date2 = cal.getTime();
         Blood blood=new Blood();
         blood.setH_id(hospital.getH_id());
         blood.setU_id(user.getId());
         blood.setCapacity(Integer.parseInt(capacity));
         blood.setP_date(date1);
         blood.setE_date(date2);
         blood.setState("已预约");


         bloodService.insertone(blood);
         return "welcome";
     }
     @RequestMapping("/findByPage/{currentpage}")
    public String findByPage(HttpServletRequest request,Model model,@PathVariable int currentpage){
        User user= (User) request.getSession().getAttribute("user");
        model.addAttribute("user",user);
         PageBean<Blood> pageBean=bloodService.findByPage(currentpage);
         List<Blood> list = pageBean.getList();
         for (Blood blood :list) {
             setObject(blood);

         }
         request.getSession().setAttribute("pageBean",pageBean);
         model.addAttribute("pageBean",pageBean);

        return "Admin/AllRecord";
     }
     @RequestMapping("/toupdate/{b_id}")
    public String toupdate(HttpServletRequest request,Model model,@PathVariable int b_id){
        User user= (User) request.getSession().getAttribute("user");
        model.addAttribute("user",user);
        Blood blood=bloodService.findById(b_id);
        setObject(blood);
        model.addAttribute("blood",blood);
        return "Admin/toupdate";
     }
    @RequestMapping("/{b_id}/updateblood")
    public String update(HttpServletRequest request,Model model,@PathVariable int b_id){
        User user= (User) request.getSession().getAttribute("user");
        model.addAttribute("user",user);
        String state = request.getParameter("state");
        Blood blood = bloodService.findById(b_id);
        blood.setState(state);
        bloodService.updateState(blood);
        return findByPage(request,model,1);
    }
    @RequestMapping("/delete/{b_id}")
    public String delete(HttpServletRequest request,Model model,@PathVariable int b_id){
        User user= (User) request.getSession().getAttribute("user");
        model.addAttribute("user",user);
        PageBean<Blood> pageBean= (PageBean<Blood>) request.getSession().getAttribute("pageBean");
        int currentpage=pageBean.getCurrentPage();
        bloodService.deleteById(b_id);


        return findByPage(request,model,currentpage);
    }
    @RequestMapping("/selectByState/{state}")
    public String selectByState(HttpServletRequest request,Model model,@PathVariable int state){
        User user= (User) request.getSession().getAttribute("user");
        model.addAttribute("user",user);
        System.out.print(state);
        PageBean<Blood> pageBean = null;
        switch (state){
            case 1:
                pageBean=bloodService.selectByState("已完成");
                System.out.print("123");
                break;
            case 2:
                pageBean=bloodService.selectByState("已献血");
                break;
            case 3:
                pageBean=bloodService.selectByState("已取消");
                break;
            case 4:
                pageBean=bloodService.selectByState("已预约");

        }
        for (Blood b :pageBean.getList()) {
           setObject(b);
        }
        model.addAttribute("pageBean",pageBean);

        return "Admin/RecordByState";

    }


}
