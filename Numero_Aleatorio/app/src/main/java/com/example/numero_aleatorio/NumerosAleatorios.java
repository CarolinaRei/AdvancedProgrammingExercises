package com.example.numero_aleatorio;

import java.util.Random;

public class NumerosAleatorios {
    private static Random random = new Random();

    /**
     *
     * @return devolve um número aleatório entre 1 e 10
     */
    public static int proximoNumero(){
        return random.nextInt(10) + 1;

    }
}
