package br.com.arphoenix.toolschallenge.exceptions;

public class CartaoCreditoInvalidoException extends RuntimeException{
    private static final long serialVersionUID = 7072427892424422698L;

    public CartaoCreditoInvalidoException() {
        super("Cartao de crédito inválido");
    }
}
