package com.example.jogodacapital;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Locale;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    TextView state, output;
    EditText capitalInput;
    String estado, cidade;
    int pontos = 0, rodada = 0;

    private String[] estados = {
            "acre", "amapa", "bahia", "distrito federal", "goias",
            "mato grosso", "minas gerais", "paraiba", "pernambuco", "rio de janeiro",
            "rio grande do sul", "roraima", "sao paulo", "tocantins", "rio grande do norte"
    };
    private String[] capitais = {
            "rio branco", "macapa", "salvador", "brasilia", "goiania",
            "cuiaba", "belo horizonte", "joao pessoa", "recife", "rio de janeiro",
            "porto alegre", "boa vista", "sao paulo", "palmas", "natal"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        state = findViewById(R.id.textViewState);
        output = findViewById(R.id.textViewResult);

        Random r = new Random();
        int index = r.nextInt(15);
        estado = estados[index];
        cidade = capitais[index];

        state.setText(estado);
        findViewById(R.id.button2).setVisibility(View.INVISIBLE);
    }

    public void guess(View view){
        capitalInput = findViewById(R.id.editTextCapital);
        String capital = String.valueOf(capitalInput.getText());
        capital = capital.toLowerCase();

        if((capital).equals(cidade)){
            pontos += 10;
            output.setText("Acertou a capital!\n" + String.valueOf(pontos) + " pontos");
        }else{
            output.setText("Errou a capital! A correta é " + cidade + "\n" + String.valueOf(pontos) + " pontos");
        }
        findViewById(R.id.button).setVisibility(View.INVISIBLE);
        findViewById(R.id.button2).setVisibility(View.VISIBLE);
        capitalInput.setText("");
        rodada++;
        visibleButtons();
    }

    public void newQuestion(View view){
        Random r = new Random();
        int index = r.nextInt(15);
        estado = estados[index];
        cidade = capitais[index];

        state.setText(estado);
        output.setText("\n" + String.valueOf(pontos) + " pontos");
        findViewById(R.id.button).setVisibility(View.VISIBLE);
        findViewById(R.id.button2).setVisibility(View.INVISIBLE);
    }

    public void visibleButtons(){
        if(rodada == 5) {
            findViewById(R.id.button).setVisibility(View.INVISIBLE);
            findViewById(R.id.button2).setVisibility(View.INVISIBLE);
        }
    }
}