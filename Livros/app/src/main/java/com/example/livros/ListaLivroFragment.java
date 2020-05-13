package com.example.livros;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;

public class ListaLivroFragment extends Fragment {

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_lista_livros, container, false);
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

     view.findViewById(R.id.buttonNovo).setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
             novoLivro();
         }
     });
     view.findViewById(R.id.buttonAlterar).setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
             alterarLivro();
         }
     });
         /*
        view.findViewById(R.id.button_first).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(FirstFragment.this)
                        .navigate(R.id.action_FirstFragment_to_SecondFragment);
            }
        });
        */
    }
    private void alterarLivro(){
    NavController navController = NavHostFragment.findNavController(ListaLivroFragment.this);
    navController.navigate(R.id.action_alterar_livro);
    }
    private void novoLivro(){
    NavController navController = NavHostFragment.findNavController(ListaLivroFragment.this);
    navController.navigate(R.id.action_novoLivro);
    }
}
