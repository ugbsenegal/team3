package com.example.monimc;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class calculimc extends AppCompatActivity{

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calculimc);
        final float[] imc = new float[1];
        Button btCalcular = (Button) findViewById(R.id.btCalcular);
        btCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView editPerso = (TextView) findViewById(R.id.editPerso);
                TextView editAltura = (TextView) findViewById(R.id.editAltura);
                TextView tvResultado = (TextView) findViewById(R.id.tvResultado);
                TextView tvDescricao = (TextView) findViewById(R.id.tvDescricao);
                int ptaille = Integer.parseInt(editPerso.getText().toString());
                float  tpois = Float.parseFloat(editAltura.getText().toString());
                imc[0] = ptaille/(tpois*tpois);
                if(imc[0]<18.5) {
                    tvResultado.setText(imc[0]+"");
                    tvDescricao.setText("Poids en baisse");

                }
                else {
                    if(imc[0]<25){
                        tvResultado.setText("RESULTAT IMC = "+imc[0]);
                        tvDescricao.setText("Poids Normal");

                    }
                    else {
                        if(imc[0]<30){
                            tvResultado.setText(imc[0]+"");
                            tvDescricao.setText("Surpoids");

                        }
                        else {
                            tvResultado.setText(imc[0]+"");
                            tvDescricao.setText("Obesite");
                        }
                    }
                }
            }
        });

        Spinner spinner;
        spinner = (Spinner) findViewById(R.id.spinner);
        List exempleList = new ArrayList();
        exempleList.add("sexe");
        exempleList.add("homme");
        exempleList.add("femme");

        ArrayAdapter adapter = new ArrayAdapter(
                this,
                android.R.layout.simple_spinner_item,
                exempleList
        );
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
    }



}
