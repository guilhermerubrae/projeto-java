package ecommerce;

import java.util.InputMismatchException;
import java.util.Scanner;

import conta.util.Cores;

public class Menu {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            exibirMenu();
            try {
                int escolha = obterEscolhaUsuario();
                escolhaUsuario(escolha);
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
    	System.out.println(Cores.TEXT_WHITE + Cores.ANSI_BLACK_BACKGROUND);
    	System.out.println("╔═════════════════════════════════════════════════════╗");
        System.out.println("║       Menu Ingressos Beyonce Renaissance Tour!      ║");
        System.out.println("╚═════════════════════════════════════════════════════╝");
        System.out.println("╔═════════════════════════════════════════════════════╗");
        System.out.println("║     1. Pista                                        ║");
        System.out.println("║     2. Principal                                    ║");
        System.out.println("║     3. Estádio                                      ║");
        System.out.println("║     4. Sair                                         ║");
        System.out.println("╚═════════════════════════════════════════════════════╝");
        System.out.println(Cores.TEXT_WHITE + Cores.ANSI_BLACK_BACKGROUND);
    }

    private static void escolhaUsuario(int escolha) {
        switch (escolha) {
            case 1:
                venderIngresso("Pista");
                break;
            case 2:
                venderIngresso("Principal");
                break;
            case 3:
                venderIngresso("Estádio");
                break;
            case 4:
                exibirMensagem("Compra de ingressos feita com sucesso! Aproveite o show!");
                System.exit(0);
            default:
                exibirMensagem("Opção inválida. Por favor, escolha novamente.");
        }
    }

    private static void venderIngresso(String localidade) {
        System.out.println("Ingresso para a " + localidade + " Beyonce Renaissance Tour vendido com sucesso!");
    }

    private static void exibirMensagem(String mensagem) {
        System.out.println(mensagem);
    }
}
