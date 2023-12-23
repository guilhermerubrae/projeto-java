package ecommerce.model;

import java.util.ArrayList;
import java.util.List;
import ecommerce.repository.EcommerceRepository;

public class Carrinho implements EcommerceRepository {
    private List<IngressoLocal> ingressos;

    public Carrinho() {
        this.ingressos = new ArrayList<>();
    }

    @Override
    public void adicionarIngresso(String localidade, double preco, int numero) {
        ingressos.add(new IngressoLocal(localidade, preco, numero));
    }

    @Override
    public double calcularPrecoTotal() {
        double precoTotal = 0;
        for (IngressoLocal ingresso : ingressos) {
            precoTotal += ingresso.calcularPreco();
        }
        return precoTotal;
    }

    @Override
    public List<IngressoLocal> getIngressos() {
        return ingressos;
    }

    @Override
    public void removerIngresso(int numeroIngresso) {
        ingressos.removeIf(ingresso -> ingresso.getNumero() == numeroIngresso);
    }

    @Override
    public void limparIngressos() {
        ingressos.clear();
    }

	public void limparCarrinho() {
		
	}
}
