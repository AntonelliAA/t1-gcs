# Parque de Diversões

Este é um projeto em Java para gerenciamento de um parque de diversões. O sistema permite o cadastro de visitantes, emissão de ingressos, registro de visitas a atrações e consulta de faturamento, entre outras funcionalidades.

## Funcionalidades

- **Cadastrar Visitante**: Permite cadastrar visitantes adultos e crianças.
- **Listar Visitantes**: Exibe a lista de todos os visitantes cadastrados.
- **Emitir Ingresso**: Emite um ingresso para um visitante previamente cadastrado.
- **Registrar Visita a Atração**: Registra a visita de um visitante a uma atração do parque.
- **Localizar Visitante**: Permite buscar visitantes pelo nome.
- **Consultar Faturamento**: Consulta o faturamento do parque em um mês e ano específicos.
- **Consultar Visitantes por Atração**: Lista os visitantes que visitaram cada atração.

## Estrutura do Projeto

O projeto está estruturado nas seguintes classes:

- **Visitante**: Classe abstrata que representa um visitante do parque.
- **Adulto**: Classe que herda de Visitante e representa um adulto.
- **Criança**: Classe que herda de Visitante e representa uma criança.
- **Ingresso**: Classe que representa um ingresso do parque.
- **Atracao**: Classe que representa uma atração do parque.
- **Parque**: Classe que representa o parque.
- **Main**: Classe principal que contém o menu e gerencia as operações do parque.

## Como Executar

1. Clone o repositório:
   ```bash
   git clone https://github.com/AntonelliAA/t1-gcs.git
   ```
