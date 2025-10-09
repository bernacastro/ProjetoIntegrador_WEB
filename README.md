# Projeto Integrador - Interfaces SDI e MDI

Este projeto contém as duas implementações de interface de usuário (SDI e MDI) solicitadas no material de aula.

## Estrutura do Projeto

O código-fonte está organizado na pasta `src` e dividido em pacotes:
- `br.com.projeto.comum`: Contém as classes de acesso ao banco de dados (DAO e Conexão), utilizadas por ambas as versões.
- `br.com.projeto.sdi`: Contém as classes da interface SDI.
- `br.com.projeto.mdi`: Contém as classes da interface MDI.

## Como Executar

O projeto utiliza um banco de dados SQLite (`meu_banco.db`) que é criado automaticamente na raiz do projeto na primeira execução.

### Para executar a versão SDI:

Execute o método `main` da classe:
`br.com.projeto.sdi.TelaPrincipalSDI`

### Para executar a versão MDI:

Execute o método `main` da classe:
`br.com.projeto.mdi.TelaPrincipalMDI`

---
Desenvolvedores: João Pedro de Almeida Martins - SP3115933 e Bernardo de Castro Bertoldo - SP3114775
