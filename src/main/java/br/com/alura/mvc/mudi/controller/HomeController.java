package br.com.alura.mvc.mudi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.alura.mvc.mudi.model.Pedido;
import br.com.alura.mvc.mudi.model.StatusPedido;
import br.com.alura.mvc.mudi.rapository.PedidoRepository;

@Controller
@RequestMapping("/home")
public class HomeController {
    @Autowired
    PedidoRepository repository;

    @RequestMapping
    public String home(Model model) {

        List<Pedido> pedidos = repository.findAll();
        model.addAttribute("pedidos", pedidos);

        return "home";
    }

    @RequestMapping("/{status}")
    public String aguardando(@PathVariable("status") String status, Model model) {

        List<Pedido> pedidos = repository.findByStatus(StatusPedido.valueOf(status.toUpperCase()));
        model.addAttribute("pedidos", pedidos);
        model.addAttribute("status", status);

        return "home";
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public String onError() {
        return "redirect:/home";
    }
    // outra forma de passar dados para a view
    // @RequestMapping("/")
    // public ModelAndView home2(Model model) {

    // List<Pedido> pedidos = repository.findAll();
    // ModelAndView mv = new ModelAndView("home");
    // mv.addObject("pedidos", pedidos);
    // return mv;
    // }

}
