package pt.ipg.adivinha;

import java.util.Random;

public class NumerosAleatorios {
    private static Random random = new Random();

    /**
     *
     * @return Devolve um número aleatório entre 1 e 10
     */
    public static int proximoNumero() {
        return random.nextInt(10) + 1;
    }
}