package pt.ipg.mensagem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    public void enviaMensagem(View view) {

        EditText txtMensagem = findViewById(R.id.txtMensagem);
        String mensagem = txtMensagem.getText().toString();

        Intent intent = new Intent(this, MostraMensagemActivity.class);
        intent.putExtra("MENSAGEM",mensagem);

        //todo:enviar mensagem


        //Colocar mensagem aparecer na textview




        startActivity(intent);
    }
}
