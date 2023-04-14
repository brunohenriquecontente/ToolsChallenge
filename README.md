#ToolsChallenge

Esta é uma aplicação para realizar pagamentos e estornar pagamentos.
Como executar?
Para executar este projeto em sua máquina, é necessário ter instalado os seguintes requisitos:

Java 8 ou superior
Maven 3.6 ou superior
PostgreSQL 13 ou superior
Para executar o projeto:

Configure as seguintes variáveis de ambiente:

ENVIRONMENT: dev (desenvolvimento), prod (produção) ou test (teste)
POSTGRES_HOST: nome do host e porta do banco de dados
POSTGRES_DB: nome do banco de dados
POSTGRES_USER: nome do usuário do banco de dados
POSTGRES_PASSWORD: senha do usuário do banco de dados
POSTGRES_SCHEMA: nome do schema
Clone o repositório: git clone https://github.com/brunohenriquecontente/ToolsChallenge.git

Navegue até a pasta raiz do projeto: cd ToolsChallenge

Execute o comando Maven para construir o projeto: mvn clean package

Inicie o aplicativo pela classe ToolschallengeApplication.java

Endpoints
Realizar pagamento
Método: POST
Path: /pagamento
Content-Type: application/json
Body:
json
Copy code
{
"transacao": {
"cartao": "4444 **** 1234",
"id": "100023568900001",
"descricao": {
"valor": "500.50",
"dataHora": "2021-05-01T18:30:00",
"estabelecimento": "PetShop Mundo cão"
},
"formaPagamento": {
"tipo": "AVISTA",
"parcelas": "1"
}
}
}
Resposta de sucesso:
Código de resposta: 200 OK
Body: JSON
json
Copy code
{
"transacao": {
"cartao": "4444 **** 1234",
"id": "100023568900001",
"descricao": {
"valor": "50.00",
"dataHora": "2021-05-01T18:30:00",
"estabelecimento": "PetShop Mundo cão",
"nsu": "1234567898",
"codigoAutorizacao": "147258369"
},
"status": "AUTORIZADO",
"formaPagamento": {
"tipo": "AVISTA",
"parcelas": "1"
}
}
}
Buscar transação por id
Método: GET
Path: /pagamento/{id}
Content-Type: application/json
Resposta de sucesso:
Código de resposta: 200 OK
Body: JSON
json

###Buscar transação por id
Método: GET  
Path: /pagamento/{id}
Content-Type: application/json
Resposta de sucesso:
Código de resposta: 200 OK
Body: json
`
{
"id": "42622edf-06e0-4c74-aff7-5ad26da4a4a9",
"transacao": {
"id": "42622edf-06e0-4c74-aff7-5ad26da4a4a9",
"cartao": "5388894638245289",
"descricao": {
"id": "c36582fa-1ace-4a22-9b25-b19a925e02d4",
"valor": "500.50",
"dataHora": "2021-05-01T18:30:00",
"estabelecimento": "PetShop Mundo cão",
"nsu": "666430114",
"codigoAutorizacao": "GJ8EHRQMXiuNfdas",
"status": "AUTORIZADO"
},
"formaPagamento": {
"tipo": "AVISTA",
"parcelas": 1
}
}
}`

###Buscar todos pagamentos
Método: GET  
Path: /pagamento
Content-Type: application/json
Resposta de sucesso:
Código de resposta: 200 OK
Body: json
`
[
{
"id": "9e505544-454e-456d-b25e-cfe5de5222ef",
"transacao": {
"id": "9e505544-454e-456d-b25e-cfe5de5222ef",
"cartao": "5388894638245289",
"descricao": {
"id": "c01b8a8f-0635-49d8-9eec-7d58cfe2da14",
"valor": "500.50",
"dataHora": "2021-05-01T18:30:00",
"estabelecimento": "PetShop Mundo cão",
"nsu": "027648770",
"codigoAutorizacao": "Tjw2GtPYpoQt90qZ",
"status": "AUTORIZADO"
},
"formaPagamento": {
"tipo": "AVISTA",
"parcelas": 1
}
}
},
{
"id": "06a5bf2e-5ebb-413f-ae09-1006466cc8fb",
"transacao": {
"id": "06a5bf2e-5ebb-413f-ae09-1006466cc8fb",
"cartao": "5388894638245289",
"descricao": {
"id": "5db9e6c8-251d-48b6-be5a-ae75b0251b3e",
"valor": "500.50",
"dataHora": "2021-05-01T18:30:00",
"estabelecimento": "PetShop Mundo cão",
"nsu": "145727402",
"codigoAutorizacao": "Ic2W24cfFbd1XFLu",
"status": "AUTORIZADO"
},
"formaPagamento": {
"tipo": "AVISTA",
"parcelas": 1
}
}
}
]
`

Resposta de sucesso:
Código de resposta: 200 OK
Body: json

###Realizar estorno
Método: PUT  
Path: /estorno/{id}
Content-Type: application/json

Resposta de sucesso:
Código de resposta: 200 OK
Body: json  

`{
    "transacao": {
        "cartao": "4444 **** 1234",
        "id": "100235 68900001",
        "descricao": {
        "valor": "50.00",
        "dataHora": "2021-05-01T18:30:00",
        "estabelecimento": "PetShop Mundo cão",
        "nsu": "1234567890",
        "codigoAutorizacao": "147258369",
        "status": "CANCELADO"
    },
    "formaPagamento": {
        "tipo": "AVISTA",
        "parcelas": "1"
    }
}
`


