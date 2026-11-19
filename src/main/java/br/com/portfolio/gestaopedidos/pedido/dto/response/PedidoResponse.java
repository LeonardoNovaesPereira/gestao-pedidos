package br.com.portfolio.gestaopedidos.pedido.dto.response;

import java.util.List;

public record PedidoResponse(Long id, Long clienteId, String status
        , List<ItemPedidoResponse> itens) {
}
