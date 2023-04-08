package br.com.alura.mvc.mudi.api;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.alura.mvc.mudi.interceptor.InterceptadoreAcessos;
import br.com.alura.mvc.mudi.interceptor.InterceptadoreAcessos.Acesso;
@RequestMapping("acessos")
@RestController
public class AcessosRest {
    @GetMapping
    public List<Acesso>getAcessos(){
        return InterceptadoreAcessos.acesos;
    }
}
