package pt.ipg.mensagem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MostraMensagemActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostra_mensagem);

        Intent intent = getIntent();
        String mensagem = intent.getStringExtra("MENSAGEM");

        //Recebe string na caixa de texto
        TextView textView = findViewById(R.id.txtMostraMensagem);
        textView.setText(mensagem);

        //Toast com mensagem da activity anterior
        Toast.makeText(this,mensagem, Toast.LENGTH_LONG).show();

    }
}
