package com.example.livros;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;

public class ListaLivrosFragment extends Fragment {

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
                alteraLivro();
            }
        });
    }

    private void alteraLivro() {
    }

    private void novoLivro() {
        NavController navController = NavHostFragment.findNavController(ListaLivrosFragment.this);
        navController.navigate(R.id.action_lista_livros_to_adicionar_livro);
    }
}
