package com.example.placar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.Chronometer;
import android.os.SystemClock;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

//propriedades
    private Chronometer chronometer1;
    private Button button_Iniciar, button_Pausar, button_Reiniciar;
    private TextView funciones;
    private long elapseTime = 0;
    private String currentTime = "";
    private Boolean activity=false;
    private TextView resultadoT,resultadoS;
    private Button adicionarButtonD,adicionarButtonT,diminuir,sadicionarButtonD,sadicionarButtonT,sdiminuir;
    private TextView contadorTextView,scontadorTextView;

    private int contador = 0;

    private int scontador = 0;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //relacionar os controles com os ojetos desta classe
        this.chronometer1 = findViewById(R.id.chronometer1);
        this.button_Iniciar = findViewById(R.id.button_Iniciar);
        this.button_Pausar = findViewById(R.id.button_Pausar);
        this.button_Reiniciar = findViewById(R.id.button_Reinicar);
        this.contadorTextView = findViewById(R.id.contadorTextView);
        this.scontadorTextView = findViewById(R.id.scontadorTextView);
        this.adicionarButtonD = findViewById(R.id.adicionarButtonD);
        this.adicionarButtonT = findViewById(R.id.adicionarButtonT);
        this.diminuir = findViewById(R.id.diminuir);
        this.sadicionarButtonD = findViewById(R.id.sadicionarButtonD);
        this.sadicionarButtonT = findViewById(R.id.sadicionarButtonT);
        this.sdiminuir = findViewById(R.id.sdiminuir);
        this.resultadoT = findViewById(R.id.resultadoT);
        this.resultadoS = findViewById(R.id.resultadoS);




        //desabilitar e habilitar os butons
        button_Iniciar.setEnabled(true);
        button_Pausar.setEnabled(false);
        button_Reiniciar.setEnabled(false);
        adicionarButtonD.setEnabled(false);
        adicionarButtonT.setEnabled(false);
        diminuir.setEnabled(false);
        sadicionarButtonD.setEnabled(false);
        sadicionarButtonT.setEnabled(false);
        sdiminuir.setEnabled(false);

//metodo pelo id do butão
       /* resultadoT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String contadordeT = resultadoT.getText().toString();
                int valordet = Integer.parseInt(contadordeT);
                resultadoT.setText(String.valueOf("teste"));
            }
        });



/*

        diminuir = (Button) findViewById(R.id.diminuirButton);

        diminuir.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                contador --;

                contadorTextView.setText("Contador: "+contador);
            }
        });*/






        button_Iniciar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                //desabilitar e habilitar os butons
                button_Iniciar.setEnabled(false);
                button_Pausar.setEnabled(true);
                button_Reiniciar.setEnabled(true);
                adicionarButtonD.setEnabled(true);
                adicionarButtonT.setEnabled(true);
                diminuir.setEnabled(true);
                sadicionarButtonD.setEnabled(true);
                sadicionarButtonT.setEnabled(true);
                sdiminuir.setEnabled(true);



                if(!activity){

                    chronometer1.setBase(SystemClock.elapsedRealtime());
                    chronometer1.start();

                }
                else{
                    chronometer1.start();

                }
            }
        });
        button_Pausar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                //desabilitar e habilitar os butons
                button_Iniciar.setEnabled(true);
                button_Pausar.setEnabled(false);
                button_Reiniciar.setEnabled(true);
                adicionarButtonD.setEnabled(false);
                adicionarButtonT.setEnabled(false);
                diminuir.setEnabled(false);
                sadicionarButtonD.setEnabled(false);
                sadicionarButtonT.setEnabled(false);
                sdiminuir.setEnabled(false);
                chronometer1.stop();
                chronometer1.setText(currentTime);
                activity=true;

            }
        });

        button_Reiniciar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                //desabilitar e habilitar os butons
                chronometer1.stop();
                chronometer1.setText("00.00");
                activity=false;
                button_Iniciar.setEnabled(true);
                button_Pausar.setEnabled(false);
                button_Reiniciar.setEnabled(false);
                adicionarButtonD.setEnabled(false);
                adicionarButtonT.setEnabled(false);
                diminuir.setEnabled(false);
                sadicionarButtonD.setEnabled(false);
                sadicionarButtonT.setEnabled(false);
                sdiminuir.setEnabled(false);


                //recuperando o valor que está no id contadordeT
                String contadordeT = contadorTextView.getText().toString();
                //transformado String em inteiros
                int valordet = Integer.parseInt(contadordeT);

                contador++;
                //realizando o calculo/ numero =  valordet(valor recuperado já transformado em interio) + numero
                int numero = valordet - valordet;
                contadorTextView.setText(String.valueOf(numero));
                scontadorTextView.setText(String.valueOf(numero));
                resultadoT.setText(String.valueOf(numero));
                resultadoS.setText(String.valueOf(numero));



            }
        });


    chronometer1.setOnChronometerTickListener(new Chronometer.OnChronometerTickListener() {
        @Override
        public void onChronometerTick(Chronometer chronometer) {
            if(!activity){
                long minutos =((SystemClock.elapsedRealtime()- chronometer1.getBase())/1000)/60;
                long segundos = ((SystemClock.elapsedRealtime() - chronometer1.getBase())/1000)%60;
                currentTime=minutos +":" + segundos;
                chronometer1.setText(currentTime);
                elapseTime=SystemClock.elapsedRealtime();

            }else{
                long minutos =((elapseTime-chronometer1.getBase())/1000)/60;
                long segundos = ((elapseTime-chronometer1.getBase())/1000)%60;
                currentTime=minutos +":" + segundos;
                chronometer1.setText(currentTime);
                elapseTime=elapseTime+1000;
                }
            }
        });
    }


    //metodo pelo onclick

    public void pontoD(View view){
        //recuperando o valor que está no id contadordeT
        String contadordeT = contadorTextView.getText().toString();
        //transformado String em inteiros
        int valordet = Integer.parseInt(contadordeT);
        //criando um inteiro com o valor tres
        int numerotres = 2;
        contador++;
        //realizando o calculo/ numero =  valordet(valor recuperado já transformado em interio) + numero
        int numero = valordet + numerotres;
        contadorTextView.setText(String.valueOf(numero));
        resultadoT.setText(String.valueOf(numero));


    }

    public void pontoT(View view){

        //recuperando o valor que está no id contadordeT
        String contadordeT = contadorTextView.getText().toString();
        //transformado String em inteiros
        int valordet = Integer.parseInt(contadordeT);
        //criando um inteiro com o valor tres
        int numerotres = 3;
        contador++;
        //realizando o calculo/ numero =  valordet(valor recuperado já transformado em interio) + numero
        int numero = valordet + numerotres;
        contadorTextView.setText(String.valueOf(numero));
       resultadoT.setText(String.valueOf(numero));
    }

    public void diminuirPlacar(View view){
        String diminuir = contadorTextView.getText().toString();
        int valordediminuir = Integer.parseInt(diminuir);
        int numerodm = 1;
        contador--;

        int numeromenos = valordediminuir - numerodm;
        contadorTextView.setText(String.valueOf(numeromenos));
        resultadoT.setText(String.valueOf(numeromenos));

    }



    public void spontoD(View view){

        String contadordeT = scontadorTextView.getText().toString();
        int valordet = Integer.parseInt(contadordeT);
        int numerotres = 2;
        scontador++;
        int numero = valordet + numerotres;
        scontadorTextView.setText(String.valueOf(numero));
        resultadoS.setText(String.valueOf(numero));
    }

    public void spontoT(View view){
        String contadordeT = scontadorTextView.getText().toString();
        int valordet = Integer.parseInt(contadordeT);
        int numerotres = 3;
        scontador++;
        int numero = valordet + numerotres;
        scontadorTextView.setText(String.valueOf(numero));
        resultadoS.setText(String.valueOf(numero));
    }

    public void sdiminuirPlacar(View view){
        String diminuir = scontadorTextView.getText().toString();
        int valordediminuir = Integer.parseInt(diminuir);
        int numerodm = 1;
        scontador--;
        int numeromenos = valordediminuir - numerodm;
        scontadorTextView.setText(String.valueOf(numeromenos));
        resultadoS.setText(String.valueOf(numeromenos));
    }


}
