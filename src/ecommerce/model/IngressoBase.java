package ecommerce.model;

public class IngressoBase {
    protected String localidade;
    protected double preco;

    public IngressoBase(String localidade, double preco) {
        this.localidade = localidade;
        this.preco = preco;
    }

    public void exibirDetalhes() {
        System.out.println("Ingresso para " + localidade);
    }

    public double calcularPreco() {
        return preco;
    }
}
