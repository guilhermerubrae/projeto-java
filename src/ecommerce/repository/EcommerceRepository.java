package ecommerce.repository;

import java.util.List;

import ecommerce.model.IngressoLocal;

public interface EcommerceRepository {
    void adicionarIngresso(String localidade, double preco, int numero);
    double calcularPrecoTotal();
    List<IngressoLocal> getIngressos();
    void removerIngresso(int numeroIngresso);
    void limparIngressos();
}
