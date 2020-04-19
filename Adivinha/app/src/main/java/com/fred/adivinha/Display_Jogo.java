package com.fred.adivinha;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class Display_Jogo extends AppCompatActivity {
    private Random random = new Random();
    public int numeroAdivinhar = random.nextInt(10) + 1;
    public int tentativas = 0;
    public boolean venceu = false;
    private boolean testou = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display__jogo);
        //Toast.makeText(this, "numero\n"+ numeroAdivinhar, Toast.LENGTH_SHORT).show(); // Mensagem informativa
    }

    public void tentar(View view){
        EditText numero_inserido = (EditText) findViewById(R.id.InsertNumber);

        if(numero_inserido.length()==0){
            numero_inserido.setError(numero_inserido.getHint());
            numero_inserido.requestFocus();
            return;
        }

        TextView introduzidos = findViewById(R.id.textViewUsed);
        int numero_selecionado = Integer.parseInt(numero_inserido.getText().toString());
        TextView ntentativas = findViewById(R.id.textViewTentativas);
        Button button =  (Button)findViewById(R.id.buttonPlay);

        if(numero_selecionado < 0 || numero_selecionado > 10){
            numero_inserido.setError(getString(R.string.inserir));
            numero_inserido.requestFocus();
            return;
        }


        if(venceu){
            button.setText(R.string.TryButon);
            numeroAdivinhar = random.nextInt(10) + 1;
            tentativas = 0;
            ntentativas.setText("" + tentativas);
            introduzidos.setText("");
            venceu=false;
        }
        else
            {
            tentativas++;

            if (numeroAdivinhar == numero_selecionado) { //verifica se acertou
                ntentativas.setText("" + tentativas);
                Toast.makeText(this, "numero de tentativas\n" + tentativas, Toast.LENGTH_SHORT).show(); // Mensagem informativa
                button.setText(R.string.Restart);
                venceu=true;
                testou=false;
            } else {
                if(!testou){
                    introduzidos.setText(getString(R.string.number_already_used)+" "+numero_selecionado);
                    testou=true;
                }
                else{
                    introduzidos.setText(introduzidos.getText().toString()+", "+numero_selecionado);
                }
                ntentativas.setText("" + tentativas);
                numero_inserido.setText("");
                numero_inserido.requestFocus();
            }
        }
    }
}
