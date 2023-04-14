package br.com.arphoenix.toolschallenge;

import br.com.arphoenix.toolschallenge.exceptions.CartaoCreditoInvalidoException;
import br.com.arphoenix.toolschallenge.exceptions.TransacaoNotFoundException;
import org.json.JSONObject;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.NoSuchElementException;

import static br.com.arphoenix.toolschallenge.utils.Constantes.CODE;
import static br.com.arphoenix.toolschallenge.utils.Constantes.MSG;

@RestControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(value = EmptyResultDataAccessException.class)
    public ResponseEntity<String> emptyResultDataAccessException(EmptyResultDataAccessException exception) {
        //adicionar logger
        return new ResponseEntity<>(new JSONObject().put(MSG, "not found").put(CODE, "NOT_FOUND").toString(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = NoSuchElementException.class)
    public ResponseEntity<String> noSuchElementException(NoSuchElementException exception) {
        //adicionar logger
        return new ResponseEntity<>(new JSONObject().put(MSG, "not found").put(CODE, "NOT_FOUND").toString(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = CartaoCreditoInvalidoException.class)
    public ResponseEntity<String> cartaoCreditoInvalidoException(CartaoCreditoInvalidoException exception) {
        //adicionar logger
        return new ResponseEntity<>(new JSONObject().put(MSG, "Cartão de crédito é inválido").put(CODE, "BAD_REQUEST").toString(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = TransacaoNotFoundException.class)
    public ResponseEntity<String> cartaoCreditoInvalidoException(TransacaoNotFoundException exception) {
        //adicionar logger
        return new ResponseEntity<>(new JSONObject().put(MSG, "Transação não encontrada").put(CODE, "NOT_FOUND").toString(), HttpStatus.NOT_FOUND);
    }

}
