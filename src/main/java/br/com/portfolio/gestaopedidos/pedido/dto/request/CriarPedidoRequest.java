package br.com.portfolio.gestaopedidos.pedido.dto.request;

import java.util.List;

public record CriarPedidoRequest(Long clienteId, List<ItemPedidoRequest> itens) {

}
