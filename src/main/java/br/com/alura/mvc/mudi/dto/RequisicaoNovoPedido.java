package br.com.alura.mvc.mudi.dto;

import br.com.alura.mvc.mudi.model.Pedido;
import br.com.alura.mvc.mudi.model.StatusPedido;
import jakarta.validation.constraints.NotBlank;

public class RequisicaoNovoPedido {
    @NotBlank // NotBlank.requisicaoNovoPedido.nomeProduto=Não pode estar em branco. essa é a
              // mensagem de erro padrão
    private String nomeProduto;
    @NotBlank
    private String urlProduto;
    @NotBlank
    private String urlImagem;
    private String descricao;

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public String getUrlProduto() {
        return urlProduto;
    }

    public void setUrlProduto(String urlProduto) {
        this.urlProduto = urlProduto;
    }

    public String getUrlImagem() {
        return urlImagem;
    }

    public void setUrlImagem(String urlImagem) {
        this.urlImagem = urlImagem;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Pedido toPedido() {
        Pedido pedido = new Pedido();
        pedido.setDescricao(descricao);
        pedido.setNomeProduto(nomeProduto);
        pedido.setUrlImagem(urlImagem);
        pedido.setUrlProduto(urlProduto);
        pedido.setStatus(StatusPedido.AGUARDANDO);
        return pedido;
    }

}
