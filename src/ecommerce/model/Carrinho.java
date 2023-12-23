package ecommerce.model;

public class Carrinho {
    private IngressoLocal[] ingressos;
    private int tamanho;

    public Carrinho() {
        this.ingressos = new IngressoLocal[10]; // ajuste o tamanho conforme necessário
        this.tamanho = 0;
    }

    public void adicionarIngresso(String localidade, double preco, int numero) {
        if (tamanho < ingressos.length) {
            ingressos[tamanho++] = new IngressoLocal(localidade, preco, numero);
        } else {
            // Caso o array esteja cheio, você pode expandi-lo ou tratar de alguma outra forma.
            System.out.println("Carrinho cheio. Não é possível adicionar mais ingressos.");
        }
    }

    public double calcularPrecoTotal() {
        double precoTotal = 0;
        for (int i = 0; i < tamanho; i++) {
            precoTotal += ingressos[i].calcularPreco();
        }
        return precoTotal;
    }

    public IngressoLocal[] getIngressos() {
        return ingressos;
    }

    public void removerIngresso(int numeroIngresso) {
        for (int i = 0; i < tamanho; i++) {
            if (ingressos[i].getNumero() == numeroIngresso) {
                // Mova os elementos à frente do índice de remoção uma posição para trás
                for (int j = i; j < tamanho - 1; j++) {
                    ingressos[j] = ingressos[j + 1];
                }
                // Ajuste o tamanho para indicar que um elemento foi removido
                tamanho--;
                return; // Saia após remover o ingresso
            }
        }
        System.out.println("Ingresso não encontrado no carrinho.");
    }

    public void limparIngressos() {
        // Se desejar, você pode criar um novo array ou simplesmente ajustar o tamanho
        tamanho = 0;
    }

    public void limparCarrinho() {
        ingressos = new IngressoLocal[10]; // ajuste o tamanho conforme necessário
        tamanho = 0;
    }
}
