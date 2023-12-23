package ecommerce.model;

public class IngressoLocal extends Pedido.Venda {
    private int numero;
    private double preco;
    private String localidade;

    public IngressoLocal(String localidade, double preco, int numero) {
        this.localidade = localidade;
        this.preco = preco;
        this.numero = numero;
    }

    @Override
    public void exibirDetalhes() {
        System.out.println("Ingresso Número: " + numero + " para: " + localidade + ", Preço: R$" + preco);
    }

    @Override
    public double calcularPreco() {
        return preco;
    }

    public int getNumero() {
        return numero;
    }
}
