package ecommerce;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Menu {
    private static Scanner scanner = new Scanner(System.in);
    private static Carrinho carrinho = new Carrinho();

    public static void main(String[] args) {
        while (true) {
            exibirMenu();
            try {
                int escolha = obterEscolhaUsuario();
                processarEscolha(escolha);
            } catch (InputMismatchException e) {
                // Limpar o buffer do scanner
                scanner.nextLine();
                exibirMensagem("Erro: Por favor, insira um número válido.");
            }
        }
    }

    private static int obterEscolhaUsuario() {
        System.out.print("Escolha uma opção: ");
        return scanner.nextInt();
    }

    public static void exibirMenu() {
        System.out.println("╔═════════════════════════════════════════════════════╗");
        System.out.println("║       Menu Ingressos Beyonce Renaissance Tour!      ║");
        System.out.println("╚═════════════════════════════════════════════════════╝");
        System.out.println("╔═════════════════════════════════════════════════════╗");
        System.out.println("║     1. Pista                                        ║");
        System.out.println("║     2. Principal                                    ║");
        System.out.println("║     3. Estádio                                      ║");
        System.out.println("║     4. Listar Ingressos                             ║");
        System.out.println("║     5. Remover Ingresso                             ║");
        System.out.println("║     6. Finalizar Compra                             ║");
        System.out.println("║     7. Sair                                         ║");
        System.out.println("╚═════════════════════════════════════════════════════╝");
    }
    
    private static void processarEscolha(int escolha) {
        switch (escolha) {
            case 1:
                adicionarIngresso("Pista");
                break;
            case 2:
                adicionarIngresso("Principal");
                break;
            case 3:
                adicionarIngresso("Estádio");
                break;
            case 4:
                listarIngressos();
                break;
            case 5:
                removerIngresso();
                break;
            case 6:
                finalizarCompra();
                break;
            case 7:
                exibirMensagem("Compra de ingressos feita com sucesso! Aproveite o show!");
                System.exit(0);
            default:
                exibirMensagem("Opção inválida. Por favor, escolha novamente.");
        }
    }

    private static void adicionarIngresso(String localidade) {
        Ingresso ingresso = new Ingresso(localidade);
        carrinho.adicionarIngresso(ingresso);
        exibirMensagem("Ingresso para a " + localidade + " adicionado ao carrinho.");
    }

    private static void listarIngressos() {
        List<Ingresso> ingressos = carrinho.getIngressos();
        if (ingressos.isEmpty()) {
            exibirMensagem("Carrinho vazio. Adicione ingressos primeiro.");
        } else {
            System.out.println("Ingressos no carrinho:");
            for (Ingresso ingresso : ingressos) {
                System.out.println(ingresso.getLocalidade());
            }
        }
    }

    private static void removerIngresso() {
        listarIngressos();
        System.out.print("Digite o número do ingresso que deseja remover: ");
        int numeroIngresso = scanner.nextInt();
        carrinho.removerIngresso(numeroIngresso);
        exibirMensagem("Ingresso removido do carrinho.");
    }

    private static void finalizarCompra() {
        List<Ingresso> ingressos = carrinho.getIngressos();
        if (ingressos.isEmpty()) {
            exibirMensagem("Carrinho vazio. Adicione ingressos primeiro.");
        } else {
            exibirMensagem("Compra de ingressos finalizada com sucesso! Aproveite o show!");
            carrinho.limparCarrinho();
            System.exit(0);
        }
    }

    private static void exibirMensagem(String mensagem) {
        System.out.println(mensagem);
    }
}
