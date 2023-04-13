package br.com.arphoenix.toolschallenge.utils;

import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class GeradorNSU {

    public static String gerarNSU() {
        Random random = new Random();
        int nsu = random.nextInt(1000000000); // gerar um NSU aleatório de até 9 dígitos
        return String.format("%09d", nsu); // formatar o NSU para ter 9 dígitos com zeros à esquerda
    }
}
