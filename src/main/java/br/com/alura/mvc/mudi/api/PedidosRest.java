package br.com.alura.mvc.mudi.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.alura.mvc.mudi.model.Pedido;
import br.com.alura.mvc.mudi.model.StatusPedido;
import br.com.alura.mvc.mudi.rapository.PedidoRepository;
import br.com.alura.mvc.mudi.utilities.PaginacaoOrdenada;

@RestController
@RequestMapping("/api/pedidos")
public class PedidosRest {

    @Autowired
    private PedidoRepository pedidoRepository;

    @GetMapping("/aguardando")
    public List<Pedido> getPedidosAguardandoOfertas() {

        return pedidoRepository.findByStatus(StatusPedido.AGUARDANDO,PaginacaoOrdenada.porIdDesc());
    }
}
