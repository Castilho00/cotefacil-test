# cotefacil-test: guia para executar os testes.

## Ambiente de desenvolvimento:

- Windows 10
- Intellij IDEA Community Edition

## Linguagens e ferramentas utilizadas:

- Java (Spring Boot)
- JavaScript (React)
- H2 Database
- Postman

## Pré-requisitos:

Para conseguir executar, necessário possuir instalado:

- Java 17
- NodeJS
- Maven

### Questão 1:

Para executar, insira os seguintes comandos no Windows PowerShell no diretório onde os arquivos foram clonados:

- `mvn clean install -f .\cotefacil-test\`
- `java -jar ./cotefacil-test/target/cotefacil-test.jar`

Para verificar as informações do banco de dados através do navegador:

- Insira o endereço `http://localhost:8080/h2-console` em algum navegador de sua escolha
- Clique no botão `Connect` -> selecione a tabela `PLANETS_TB` -> clique em `Run`
- A tabela mostrará todas as informações dos planetas que foram solicitadas

Para verificar as informações do banco de dados utilizando Postman:

- Insira o endereço `http://localhost:8080/sw` através da operação `"GET"`

### Questão 2:

- Arquivo .txt presente no diretório raiz do teste.

### Questão 3:

- `cd Question3/`
- `npm install`
- `npm start`
