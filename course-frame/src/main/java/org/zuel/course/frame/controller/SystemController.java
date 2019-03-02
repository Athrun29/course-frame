package org.zuel.course.frame.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zuel.course.frame.model.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/")
public class SystemController {

    @RequestMapping("/login")
    public ModelAndView login(@ModelAttribute("error") String error) {
        ModelAndView modelAndView = new ModelAndView("login");
        if(error != null) {
            modelAndView.addObject("error", error);
        }
        return modelAndView;
    }

    @RequestMapping("/doLogin")
    public String doLogin(@RequestParam("username") String username, @RequestParam("username") String password,
                          RedirectAttributes attr, HttpServletRequest request) {
        try {
            if (("admin".equals(username) && "admin".equals(password))
                    || ("guest".equals(username) && "guest".equals(password))) {
                request.getSession().setAttribute("login", username);
                User user = new User();
                user.setUsername(username);
                user.setPassword(password);
                request.getSession().setAttribute("user", user);
                return "redirect:/home";
            } else {
                attr.addFlashAttribute("error", "用户名或密码错误，请重新填写");
                return "redirect:/login";
            }
        } catch (Exception e) {
            attr.addFlashAttribute("error", e.getMessage());
            return "forward:/500";
        }
    }

    @RequestMapping("/home")
    public String index() {
        return "home";
    }

    @RequestMapping("/logout")
    public ModelAndView logout(@ModelAttribute("username") String username) {
        ModelAndView modelAndView = new ModelAndView("logout");
        modelAndView.addObject("username", username);
        return modelAndView;
    }

    @RequestMapping("/doLogout")
    public String doLogout(HttpSession session, RedirectAttributes attr) {
        try {
            Object username = session.getAttribute("login");
            attr.addFlashAttribute("username", username);
            session.invalidate();
            return "redirect:/logout";
        } catch (Exception e) {
            attr.addFlashAttribute("error", e.getMessage());
            return "forward:/500";
        }
    }

    @RequestMapping("/500")
    public ModelAndView error(@ModelAttribute("error") String error) {
        ModelAndView modelAndView = new ModelAndView("500");
        if(!"".equals(error)) {
            modelAndView.addObject("error", error);
        }
        return modelAndView;
    }
}
