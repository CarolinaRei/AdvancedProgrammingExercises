package com.example.numero_aleatorio;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private int numeroAdivinhar =NumerosAleatorios.proximoNumero();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    static final String STATE_NUMEROADIVINHAR = "numeroAdivinhar";
    static final String STATE_SOMA = "soma";


    @Override
    protected void onSaveInstanceState(@NonNull Bundle savedInstanceState) {

            // Save the user's current game state
            savedInstanceState.putInt(STATE_NUMEROADIVINHAR, numeroAdivinhar);
            savedInstanceState.putInt(STATE_SOMA, soma);

            // Always call the superclass so it can save the view hierarchy state
            super.onSaveInstanceState(savedInstanceState);

    }

    public void onRestoreInstanceState(Bundle savedInstanceState){
        numeroAdivinhar = savedInstanceState.getInt(STATE_NUMEROADIVINHAR);
        soma = savedInstanceState.getInt(STATE_SOMA);
    }
    int soma;

    public void verificaNumero(View view) {


        EditText editTextNumero = (EditText) findViewById(R.id.editTextNumero);

        String strNumero = editTextNumero.getText().toString();


        int numero;
        try {
            numero = Integer.parseInt(strNumero);
        } catch (NumberFormatException e) {
            editTextNumero.setError(getString(R.string.numero_obrigatorio));
            editTextNumero.requestFocus();
            return;
        }
        if ((numero < 1) || (numero > 10)) {
            editTextNumero.setError(getString(R.string.numero_limites));
            editTextNumero.requestFocus();
            return;
        }

        TextView textViewMostrarResultado = findViewById(R.id.textViewMostrarResultado);
        final TextView textViewMostrarTentativas = findViewById(R.id.textViewMostrarTentativas);



            if(numeroAdivinhar == numero){
                soma++;
                textViewMostrarResultado.setText(R.string.resultado_correto);
                textViewMostrarResultado.setTextColor(Color.GREEN);
                textViewMostrarTentativas.setText(String.valueOf(soma));

                AlertDialog.Builder  builder= new AlertDialog.Builder(this);
                builder.setTitle("Novo Jogo");
                builder.setMessage("Quer jogar novamente?");
                builder.setCancelable(false);
                builder.setPositiveButton("sim", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        novoJogo();
                        textViewMostrarTentativas.setText("Tentativas: 0");
                        textViewMostrarTentativas.setText("");

                    }
                });


                builder.setNegativeButton("não", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                });
                builder.show();
         }
            else if (numeroAdivinhar > numero){
                soma++;
                textViewMostrarTentativas.setText(String.valueOf(soma));
                textViewMostrarResultado.setText(R.string.resultado_errado_maior);
                textViewMostrarResultado.setTextColor(Color.RED);
            }
            else{
                soma++;
                textViewMostrarTentativas.setText(String.valueOf(soma));
                textViewMostrarResultado.setText(R.string.resultado_errado_menor);
                textViewMostrarResultado.setTextColor(Color.RED);
            }
    }

    private void novoJogo() {
            numeroAdivinhar = NumerosAleatorios.proximoNumero();
            soma = 0;
        }
    }



