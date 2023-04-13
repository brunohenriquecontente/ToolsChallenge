#ToolsChallenge

#### Esta é uma aplicação para realizar pagamentos e estornar pagamentos.

##Requisitos
-Postgres 13  
-Java JDK 8  

##Endpoints
###Realizar pagamento
Método: POST  
Path: /pagamento  
Content-Type: application/json   
Body:

`{
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
`  

Resposta de sucesso:
Código de resposta: 200 OK
Body: json 

`{
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
`
###Realizar estorno
Método: POST  
Path: /estorno  
Content-Type: application/json   
Body:
`
{ "id": "100235 68900001" }
`


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