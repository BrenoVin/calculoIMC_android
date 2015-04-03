package com.breno.calculoimc10;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    //meus metodos
        //acao do botao de calcular imc
        public void calculaIMC(View view){
            //recupera o valor de cada edit text pelo id
            EditText alturaStr = (EditText) findViewById(R.id.altura);
            EditText pesoStr = (EditText) findViewById(R.id.peso);

            //faz a refereciancia para os campos que vao ser de resposta
            TextView imcT = (TextView) findViewById(R.id.imc);
            TextView message = (TextView) findViewById(R.id.message);

        try{
            //converte os valores de edittext para double
            double altura = Double.parseDouble(alturaStr.getText().toString());
            double peso = Double.parseDouble(pesoStr.getText().toString());
            //calculo de imc
            double imc = peso / (altura * altura);

            //coloca no textview o valor do imc
            imcT.setText("Seu imc é: " + Math.round(imc));

            //verificações de qual situação o valor do imc se encontra
            if (imc < 17) {
                message.setText("Muito Abaixo do Peso!");
            } else if (imc >= 17 && imc < 18.50) {
                message.setText("Abaixo do Peso!");
            }  else if (imc >= 18.5 && imc < 25) {
                message.setText("Peso Normal!");
            } else if (imc >= 25 && imc < 30) {
                message.setText("Obesidade I!");
            } else if (imc >= 30 && imc < 35) {
                message.setText("Obesidade II (Severa)!");
            } else if (imc >= 40) {
                message.setText("Obesidade III (Morbida)!");
            }
            alturaStr.setText("");
            pesoStr.setText("");

        }catch (Exception e){
            Log.e("ERRO"," = "+e);
            alturaStr.setText("");
            pesoStr.setText("");
            imcT.setText("");
            message.setText("");
        }
        }

}
