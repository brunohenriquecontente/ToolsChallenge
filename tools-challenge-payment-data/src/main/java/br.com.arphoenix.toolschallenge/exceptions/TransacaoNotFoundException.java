package br.com.arphoenix.toolschallenge.exceptions;

import java.util.UUID;

public class TransacaoNotFoundException extends RuntimeException{
    private static final long serialVersionUID = 7072427892424422698L;

    public TransacaoNotFoundException(UUID id) {
        super("Registro não encontrado", new IllegalArgumentException("ID do pagamento: " + id.toString()));

    }

}
