package br.com.arphoenix.toolschallenge.utils;

import org.apache.commons.lang3.RandomStringUtils;

public class GeradorCodigoAutorizacao {

    public static String gerarCodigoAutorizacao() {

        // gerar um código alfanumérico aleatório de 16 caracteres
        String authorizationCode = RandomStringUtils.randomAlphanumeric(16);
        return authorizationCode;
    }
}
