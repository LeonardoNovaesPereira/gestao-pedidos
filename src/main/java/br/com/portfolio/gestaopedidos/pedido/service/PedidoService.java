package br.com.portfolio.gestaopedidos.pedido.service;

import br.com.portfolio.gestaopedidos.pedido.domain.Pedido;
import br.com.portfolio.gestaopedidos.pedido.dto.request.CriarPedidoRequest;
import br.com.portfolio.gestaopedidos.pedido.dto.request.ItemPedidoRequest;
import br.com.portfolio.gestaopedidos.pedido.dto.response.ItemPedidoResponse;
import br.com.portfolio.gestaopedidos.pedido.dto.response.PedidoResponse;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.Clock;
import java.time.LocalDateTime;
import java.util.*;

@Service
public class PedidoService {

    private Map<Long, PedidoResponse> pedidos = new HashMap<>();
    private Long contadorID = 0L;

    private final Clock clock;

    public PedidoService(Clock clock) {
        this.clock = clock;
    }

    public Pedido criarPedido(){
        var pedido = new Pedido();
        pedido.setCodigo("1");
        pedido.setCriadoEm(LocalDateTime.now(clock));
        pedido.setNomeCliente("Kaio");
        pedido.setValorTotal(BigDecimal.valueOf(50L));
        return pedido;
    }

    public PedidoResponse criarPedidoDTO(CriarPedidoRequest pedidoRequest){
        List<ItemPedidoResponse> itens = new ArrayList<>();
        for (ItemPedidoRequest item : pedidoRequest.itens()){
            var itemResp = new ItemPedidoResponse(item.produtoId(), item.quantidade());
            itens.add(itemResp);
        }
        var pedidoResp = new PedidoResponse(gerarID(), pedidoRequest.clienteId(), "RECEBIDO", itens);
        pedidos.put(pedidoResp.id(), pedidoResp);
        return pedidoResp;
    }

    public List<PedidoResponse> listar(){
        return new ArrayList<>(pedidos.values());
    }

    public Optional<PedidoResponse> obterPedido(Long id){
        return Optional.ofNullable(pedidos.get(id));
    }

    public List<PedidoResponse> listarPorStatus(String status){
        return pedidos.values().stream()
                .filter(p -> p.status().equals(status))
                .toList();
    }

    private Long gerarID(){
        contadorID++;
        return contadorID;
    }
}
