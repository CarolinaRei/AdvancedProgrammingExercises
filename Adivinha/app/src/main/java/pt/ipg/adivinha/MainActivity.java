package pt.ipg.adivinha;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private int numeroAdivinhar = NumerosAleatorios.proximoNumero();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void adivinhar(View view) {
        EditText editTextNumero = (EditText) findViewById(R.id.editTextNumero);
        String strNumero = editTextNumero.getText().toString();

        int numero;
        try {
            numero = Integer.parseInt(strNumero);
        } catch (NumberFormatException e) {
            editTextNumero.setError("Número inválido");
            editTextNumero.requestFocus();
            return;
        }

        if (numero < 1 || numero > 10) {
            editTextNumero.setError("O número que estou a pensar é entre 1 e 10.");
            editTextNumero.requestFocus();
            return;
        }
    }
}