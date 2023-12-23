package ecommerce.model;

public class Pedido {
    private User usuario;
    private IngressoLocal ingresso;

    public Pedido(User usuario, IngressoLocal ingresso) {
        this.usuario = usuario;
        this.ingresso = ingresso;
    }

    public void exibirDetalhes() {
        usuario.exibirInformacoes();
        System.out.println("Ingresso no pedido:");
        ingresso.exibirDetalhes();
    }

    public static abstract class Venda {
        public abstract double calcularPreco();
        public void exibirDetalhes() {
        }
    }
}
