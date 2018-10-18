package web;

import com.bean.UserTb;
import com.service.impl.UserTbServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

@Controller
@SessionAttributes({"u1","logintime"})
public class UserTbController{
    @Autowired
    private UserTbServiceImpl userTbService;
   @RequestMapping("/login")
    public void login(ModelMap map,HttpServletResponse response, String DropExpiration, UserTb userTb){
       System.out.println(userTb.getUserName()+"...."+userTb.getUserPs());
       UserTb u = userTbService.login(userTb);
       response.setContentType("text/html;charset=utf-8");
       try {
           PrintWriter out=response.getWriter();
           if(u==null){
               out.print("<script>alert('登录失败!请重新登录!');location.herf='login.jsp'</script>");
           }else{
               map.put("u1",u);
               Cookie cookie=new Cookie("uname",u.getUserName());
               if("DropExpiration".equals("Day")){
                   cookie.setMaxAge(60*60*24);
               }else if("DropExpiration".equals("Month")){
                   cookie.setMaxAge(60*60*30*24);
               }else if("DropExpiration".equals("Year")){
                   cookie.setMaxAge(60*60*365*24);
               }
               response.addCookie(cookie);
               //登录时间
               Date date=new Date();
               map.put("logintime",date);
               out.print("<script>alert('登录成功!');location.href='index.jsp'</script>");
           }
       } catch (IOException e) {
           e.printStackTrace();
       }
   }
}
