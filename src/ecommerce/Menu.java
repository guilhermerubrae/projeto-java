package ecommerce;

import java.util.InputMismatchException;
import java.util.Scanner;

import conta.util.Cores;
import ecommerce.model.Carrinho;
import ecommerce.model.IngressoLocal;
import ecommerce.model.User;

public class Menu {
	private static Scanner scanner = new Scanner(System.in);
	private static User usuario;
	private static Carrinho carrinho;

	public static void main(String[] args) {
		carrinho = new Carrinho(); // Adicione esta linha
		cadastrarUsuario();

		while (true) {
			exibirMenu();
			try {
				int escolha = escolhaUser();
				processarEscolha(escolha);
			} catch (InputMismatchException e) {
				scanner.nextLine();
				exibirMensagem("Erro: Por favor, insira um número válido.");
			}
		}
	}

	private static void cadastrarUsuario() {
		System.out.println(Cores.TEXT_WHITE + Cores.ANSI_BLACK_BACKGROUND);
		System.out.println("╔═════════════════════════════════════════════════════╗");
		System.out.println("║              Beyonce Renaissance Tour!              ║");
		System.out.println("╚═════════════════════════════════════════════════════╝");

		System.out.print("Digite seu nome: ");
		String nome = scanner.nextLine();

		System.out.print("Digite seu e-mail: ");
		String email = scanner.nextLine();

		System.out.print("Digite seu CPF: ");
		String cpf = scanner.nextLine();

		System.out.print("Digite sua idade: ");
		int idade = scanner.nextInt();

		usuario = new User(nome, email, cpf, idade);

		exibirMenu();
	}

	private static int escolhaUser() {
		try {
			System.out.print("Escolha uma opção: ");
			return scanner.nextInt();
		} catch (InputMismatchException e) {
			scanner.nextLine();
			throw new InputMismatchException("Erro: Por favor, insira um número inteiro válido.");
		}
	}

	public static void exibirMenu() {
		System.out.println(Cores.TEXT_WHITE + Cores.ANSI_BLACK_BACKGROUND);
		System.out.println("╔═════════════════════════════════════════════════════╗");
		System.out.println("║       Menu Ingressos Beyonce Renaissance Tour!      ║");
		System.out.println("╚═════════════════════════════════════════════════════╝");
		System.out.println("╔═════════════════════════════════════════════════════╗");
		System.out.println("║     1. Ingresso Pista                               ║");
		System.out.println("║     2. Ingresso Principal                           ║");
		System.out.println("║     3. Ingresso Estádio                             ║");
		System.out.println("║     4. Listar Ingressos                             ║");
		System.out.println("║     5. Remover Ingresso                             ║");
		System.out.println("║     6. Finalizar Compra                             ║");
		System.out.println("║     7. Sair                                         ║");
		System.out.println("╚═════════════════════════════════════════════════════╝");
	}

	   private static void processarEscolha(int escolha) {
	        switch (escolha) {
	            case 1:
	                adicionarIngresso("Pista", 800.0);
	                break;
	            case 2:
	                adicionarIngresso("Principal", 1000.0);
	                break;
	            case 3:
	                adicionarIngresso("Estádio", 500.0);
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
	                exibirMensagem("Compra feita com sucesso! Aproveite o show!");
	                System.exit(0);
	            default:
	                exibirMensagem("Opção inválida. Por favor, escolha novamente.");
	        }
	    }

	    private static void adicionarIngresso(String localidade, double preco) {
	        if (usuario.getIdade() < 18) {
	            exibirMensagem("Desculpe, apenas maiores de 18 anos podem comprar ingressos para o show.");
	        } else {
	            int numero = carrinho.getIngressos().length + 1;
	            carrinho.adicionarIngresso(localidade, preco, numero);
	            exibirMensagem("Ingresso para a " + localidade + " adicionado ao carrinho.");
	        }
	    }

	    private static void listarIngressos() {
	        IngressoLocal[] ingressos = carrinho.getIngressos();
	        if (ingressos[0] == null) {
	            exibirMensagem("Carrinho vazio. Adicione ingressos primeiro.");
	        } else {
	            System.out.println("Ingressos no carrinho:");
	            for (IngressoLocal ingresso : ingressos) {
	                if (ingresso != null) {
	                    ingresso.exibirDetalhes();
	                }
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
	        IngressoLocal[] ingressos = carrinho.getIngressos();
	        if (ingressos[0] == null) {
	            exibirMensagem("Carrinho vazio. Adicione ingressos primeiro.");
	        } else {
	            try {
	                exibirMensagem("Compra de ingressos finalizada com sucesso! Aproveite o show!");
	                exibirDetalhesCompra();
	                carrinho.limparCarrinho();
	                System.exit(0);
	            } catch (ArithmeticException e) {
	                exibirMensagem("Erro ao calcular o total a pagar. Por favor, tente novamente.");
	                carrinho.limparCarrinho();
	                System.exit(1);
	            }
	        }
	    }

	    private static void exibirDetalhesCompra() {
	        System.out.println("Detalhes da Compra:");
	        System.out.println("Usuário: " + usuario.getNome() + ", Email: " + usuario.getEmail());
	        System.out.println("Ingressos:");
	        IngressoLocal[] ingressos = carrinho.getIngressos();
	        for (IngressoLocal ingresso : ingressos) {
	            if (ingresso != null) {
	                ingresso.exibirDetalhes();
	            }
	        }
	        System.out.println("Total a pagar: R$" + carrinho.calcularPrecoTotal());
	    }

	    private static void exibirMensagem(String mensagem) {
	        System.out.println(mensagem);
	    }
	}