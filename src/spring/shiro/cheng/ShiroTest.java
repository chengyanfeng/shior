package spring.shiro.cheng;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by Administrator on 2017/7/11 0011.
 */
@Controller
@RequestMapping("shiro")
public class ShiroTest {

       @RequestMapping(value = "/login",method = RequestMethod.POST)
        public String testShirologin(@RequestParam("username") String name,@RequestParam("password")String secrte){
System.out.print("12321321321321321321321");
           //获取subject
            Subject currentUser = SecurityUtils.getSubject();

            if (!currentUser.isAuthenticated()) {
                //获取token
                UsernamePasswordToken token = new UsernamePasswordToken(name, secrte);
                // rememberme
                token.setRememberMe(true);
                try {
                    System.out.println("1. " + token.hashCode());
                    // 这次是走的ShiroRealm登陆
                    currentUser.login(token);
                }
                // ... catch more exceptions here (maybe custom ones specific to your application?

                catch (AuthenticationException ae) {
                    //unexpected condition?  error?
                    System.out.println("访问list" + ae.getMessage());
                }
            }
return "redirect:/list.jsp";
        }
}
