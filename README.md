# Beyonce Renaissance Tour E-commerce

Este projeto consiste em um sistema simples de e-commerce para a venda de ingressos para a turnê "Beyonce Renaissance". Os usuários podem se cadastrar, visualizar opções de ingressos, adicionar ao carrinho, remover do carrinho e finalizar a compra. O sistema mantém o controle do carrinho do usuário e exibe detalhes da compra no final.

## Funcionalidades

**Cadastro de Usuário:**
- Os usuários podem se cadastrar fornecendo nome, e-mail, CPF e idade.
  
**Menu de Ingressos:**
- Opções para adicionar ingressos de diferentes categorias (Pista, Principal, Estádio).
- Restrição: Apenas maiores de 18 anos podem comprar ingressos.

**Listar Ingressos no Carrinho:**
- Exibe os ingressos adicionados ao carrinho.

**Remover Ingresso:**
- Permite ao usuário remover um ingresso específico do carrinho.

**Finalizar Compra:**
- Calcula o total a pagar, exibe detalhes da compra e finaliza o programa.

## Estrutura do Projeto

**ecommerce.model:**
- Pacote contendo as classes relacionadas ao modelo de dados.
  - `User`: Representa um usuário.
  - `IngressoLocal`: Representa um ingresso.
  - `Carrinho`: Classe responsável pelo gerenciamento do carrinho de compras.
  - `Pedido`: Representa um pedido contendo os ingressos selecionados.

**ecommerce:**
- Pacote contendo as classes principais.
  - `Menu`: Classe principal que interage com o usuário e gerencia o fluxo do programa.

**ecommerce.repository:**
- Pacote contendo a interface que define operações relacionadas ao armazenamento de dados.

**conta.util:**
- Pacote contendo a classe `Cores` para manipulação de cores no console.

## Execução

Para executar o projeto, você pode simplesmente rodar o arquivo `Menu.java`.

```bash
javac ecommerce/Menu.java
java ecommerce.Menu
