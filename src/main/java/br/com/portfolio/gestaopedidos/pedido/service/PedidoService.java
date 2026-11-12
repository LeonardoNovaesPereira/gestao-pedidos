package br.com.portfolio.gestaopedidos.pedido.service;

import br.com.portfolio.gestaopedidos.pedido.domain.Pedido;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.Clock;
import java.time.LocalDateTime;

@Service
public class PedidoService {

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
}
