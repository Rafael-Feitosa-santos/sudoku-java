# Sudoku Game

Este é um projeto de um jogo de Sudoku desenvolvido em Java utilizando a interface gráfica Swing. O jogo permite ao usuário jogar Sudoku, verificar o status do jogo, reiniciar o jogo, e finalizar a partida.

## Funcionalidades

- **Criação do Tabuleiro**: O tabuleiro de Sudoku é gerado dinamicamente, com cada setor do tabuleiro (3x3) sendo renderizado em uma seção própria da interface gráfica.
- **Resetar o Jogo**: O jogador pode reiniciar o jogo a qualquer momento.
- **Verificar o Status do Jogo**: O jogador pode verificar se o jogo foi concluído, se está incompleto ou se não foi iniciado. Também pode ser verificado se o jogo contém erros.
- **Finalizar o Jogo**: O jogador pode finalizar o jogo e receber um feedback sobre o progresso.

## Requisitos

Antes de rodar o projeto, certifique-se de ter o Java 8 ou superior instalado no seu sistema.

- Java 8+
- Maven (opcional, para gerenciamento de dependências e construção do projeto)

## Estrutura do Projeto

A estrutura do projeto segue o padrão MVC, com as seguintes pastas:

- `br/com/dio/model`: Contém as classes de modelo como `Space`, que representa cada célula do Sudoku.
- `br/com/dio/service`: Contém a lógica de negócios, como `BoardService`, que gerencia o estado do tabuleiro.
- `br/com/dio/ui`: Contém as classes para a interface gráfica, incluindo `MainScreen` e os componentes do Swing como `NumberText`, `FinishGameButton`, etc.
- `br/com/dio/ui/custom`: Contém os componentes gráficos personalizados, como botões e painéis.

## Como Executar

1. **Clonar o repositório**:

   ```bash
   git clone https://github.com/seu-usuario/sudoku-game.git
