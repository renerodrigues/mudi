package br.com.alura.mvc.mudi.interceptor;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.servlet.HandlerInterceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class InterceptadoreAcessos implements HandlerInterceptor {

public static  List<Acesso> acesos = new ArrayList<Acesso>(); // PEsquisar sobre spring boot actuator// o ideal é salvar os acessos em banco de dados, pois na memoria pode derruar a aplicação

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        Acesso acesso = new Acesso();
        acesso.path = request.getRequestURI();
        acesso.data = LocalDateTime.now();

        request.setAttribute("acesso", acesso);
        return true;
        // return HandlerInterceptor.super.preHandle(request, response, handler);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
            throws Exception {
        Acesso acesso = (Acesso) request.getAttribute("acesso");
        acesso.duracao = Duration.between(acesso.data, LocalDateTime.now());
        acesos.add(acesso);
        // HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    }

  public static  class Acesso {
        private String path;
        private LocalDateTime data;
        private Duration duracao;
        public String getPath() {
            return path;
        }
        public void setPath(String path) {
            this.path = path;
        }
        public LocalDateTime getData() {
            return data;
        }
        public void setData(LocalDateTime data) {
            this.data = data;
        }
        public Duration getDuracao() {
            return duracao;
        }
        public void setDuracao(Duration duracao) {
            this.duracao = duracao;
        }

        
    }
}