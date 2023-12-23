package ecommerce.model;

import java.util.List;

public class Pedido {
    private User usuario;
    private List<IngressoLocal> ingressos;

    public Pedido(User usuario, List<IngressoLocal> ingressos) {
        this.usuario = usuario;
        this.ingressos = ingressos;
    }

    public void exibirDetalhes() {
        usuario.exibirInformacoes();
        System.out.println("Ingressos no pedido:");
        for (IngressoLocal ingresso : ingressos) {
            ingresso.exibirDetalhes();
        }
    }

    public static abstract class Venda {
        public abstract double calcularPreco();

		public void exibirDetalhes() {
			
		}
    }
}
