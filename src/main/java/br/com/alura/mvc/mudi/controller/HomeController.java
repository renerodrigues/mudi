package br.com.alura.mvc.mudi.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.alura.mvc.mudi.model.Pedido;
import br.com.alura.mvc.mudi.model.StatusPedido;
import br.com.alura.mvc.mudi.rapository.PedidoRepository;
import br.com.alura.mvc.mudi.utilities.PaginacaoOrdenada;

@Controller
@RequestMapping("/home")
public class HomeController {
    @Autowired
    PedidoRepository repository;

    @RequestMapping
    public String home(Model model, Principal principal) {

        // Sort sort = Sort.by("dataDaEntrega").descending();
        // PageRequest paginacao = PageRequest.of(0, 10, sort);
        List<Pedido> pedidos = repository.findByStatus(StatusPedido.ENTREGUE, PaginacaoOrdenada.porIdDesc());
        model.addAttribute("pedidos", pedidos);

        return "home";
    }

    // @ExceptionHandler(IllegalArgumentException.class)
    // public String onError() {
    // return "redirect:/home";
    // }

    // outra forma de passar dados para a view
    // @RequestMapping("/")
    // public ModelAndView home2(Model model) {

    // List<Pedido> pedidos = repository.findAll();
    // ModelAndView mv = new ModelAndView("home");
    // mv.addObject("pedidos", pedidos);
    // return mv;
    // }

}
