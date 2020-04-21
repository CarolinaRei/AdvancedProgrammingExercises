package com.example.actividade4;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;


public class MainActivity extends AppCompatActivity {

    public static final String name = "com.example.actividade4.MESSAGE";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /** Called when the user taps the Send button */
    public void sendMessage(View view) {
        Intent intent = new Intent(this, DisplayMessageActivity.class);

        EditText Nome = (EditText) findViewById(R.id.editText);
        String messageNome = Nome.getText().toString();
        intent.putExtra(name: "messageNome", messageNome);

        EditText Telefone = (EditText) findViewById(R.id.editText2);
        String messageTelefone = Telefone.getText().toString();
        intent.putExtra(name: "messageTelefone", messageTelefone);

        EditText Email = (EditText) findViewById(R.id.editText3);
        String messageEmail = Email.getText().toString();
        intent.putExtra(name: "messageEmail", messageEmail);

        EditText Idade = (EditText) findViewById(R.id.editText4);
        String messageIdade = Idade.getText().toString();
        intent.putExtra(name: "messageIdade", messageIdade);

        EditText Peso = (EditText) findViewById(R.id.editText5);
        String messagePeso = Peso.getText().toString();
        intent.putExtra(name: "messagePeso", messagePeso);

        EditText Altura = (EditText) findViewById(R.id.editText6);
        String messageAltura = Altura.getText().toString();
        intent.putExtra(name: "messageAltura", messageAltura);

        startActivity(intent);
    }

}
