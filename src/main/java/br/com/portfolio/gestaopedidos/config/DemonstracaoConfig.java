package br.com.portfolio.gestaopedidos.config;

import br.com.portfolio.gestaopedidos.pedido.service.PedidoService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.Clock;

@Configuration
public class DemonstracaoConfig {

    @Bean
    public Clock clock(){
        return Clock.systemDefaultZone();
    }

    @Bean
    public CommandLineRunner executarDemonstracao(
            PedidoService pedidoService) {

        return args -> {
            var pedido = pedidoService.criarPedido();
            System.out.println("Novo pedido\n" + "Cod: " + pedido.getCodigo()
                    + "\nCliente: " + pedido.getNomeCliente() + "\nTotal: R$ " + pedido.getValorTotal() + ",00");
        };
    }
}
