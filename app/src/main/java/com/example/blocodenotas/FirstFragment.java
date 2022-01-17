package com.example.blocodenotas;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.blocodenotas.databinding.FragmentFirstBinding;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class FirstFragment extends Fragment {

    private FragmentFirstBinding binding;
    private SharedPreferences anotacao;
    private EditText edtAnotacao;
    private FloatingActionButton fab_enviar;


    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        binding = FragmentFirstBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        //instanciando o componente

        edtAnotacao = root.findViewById(R.id.edtAnotacao);
        fab_enviar = root.findViewById(R.id.fab_enviar);

        //intanciando o share preferencia
        anotacao = this.getActivity().getSharedPreferences("Anotacao", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = anotacao.edit();

        //recuperando o valor que representa a anotação em si
        String valorAnotacao = anotacao.getString("Anotacao"," ");

        //adionando esse valor ao elemento
          edtAnotacao.setText(valorAnotacao);


          //Criando evento de click do FloatingActionButton
          fab_enviar.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View v) {

                  //salvando o texto no arquivo sharepreference
                    editor.putString("Anotacao",edtAnotacao.getText().toString());
                    editor.commit();
                  Toast.makeText(root.getContext(),"Anotação salva com sucesso!!",Toast.LENGTH_LONG).show();

              }
          });

        return root;




    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }


}