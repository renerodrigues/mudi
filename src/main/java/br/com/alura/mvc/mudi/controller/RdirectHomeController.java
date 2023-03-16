package br.com.alura.mvc.mudi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("")

public class RdirectHomeController {
    @GetMapping("/")
    // public String hello(HttpServletRequest request){
    // public String hello(Model model){
    public String redirect() {
        // request.setAttribute("nome", " thymeleaf ");
        // model.addAttribute("nome", " thymeleaf ");
        return "redirect:/home";
    }
}
