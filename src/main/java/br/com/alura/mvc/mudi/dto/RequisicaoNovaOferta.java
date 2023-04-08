package br.com.alura.mvc.mudi.dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import br.com.alura.mvc.mudi.model.Oferta;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public class RequisicaoNovaOferta {
    private static final DateTimeFormatter formater = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    private long pedidoId;

    @Pattern(regexp = "^\\d+(\\.\\d+{2})?$") // a string tem que começar com um digito o + significa que pode conter
                                             // varios desses digitos. a ? diz que o que está entre parenteses pode ou
                                             // não ser
                                             // preenchido
    @NotNull
    private String valor;

    @Pattern(regexp = "^\\d{2}/\\d{2}/\\d{4}$") // as validações funcionam se a chamada da classe estiver marcada com
                                                // @Valid ex: public Oferta criaOferta(@Valid @RequestBody
                                                // RequisicaoNovaOferta requisicao) {}

    @NotNull
    private String dataDaEntrega;
    private String comentario;

    public long getPedidoId() {
        return pedidoId;
    }

    public void setPedidoId(long pedidoId) {
        this.pedidoId = pedidoId;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public String getDataDaEntrega() {
        return dataDaEntrega;
    }

    public void setDataDaEntrega(String dataDaEntrega) {
        this.dataDaEntrega = dataDaEntrega;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public Oferta toOferta() {
        Oferta oferta = new Oferta();
        oferta.setComentario(this.comentario);
        oferta.setDataDaEntrega(LocalDate.parse(this.dataDaEntrega, formater));
        oferta.setValor(new BigDecimal(this.valor));

        return oferta;
    }

}
