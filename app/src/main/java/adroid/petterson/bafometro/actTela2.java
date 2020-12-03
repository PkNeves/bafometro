package adroid.petterson.bafometro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class actTela2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act_tela2);
    }

    public double txalcoolemia(int ncopos, double peso, String sexo, String jejum) {
        double coeficiente;
        double alcool;
        double tx;

        // calcula coeficiente
        if (jejum.equals("n")) {
            coeficiente = 1.1;
        } else {
            coeficiente = sexo.equals("f") ? 0.6 : 0.7;
        }

        // calcula alcool
        alcool = ncopos * 4.8;

        // calcula taxa
        tx = alcool / (peso * coeficiente);

        return tx;
    }
    public void calculaAlcoolemia(View v) {
        Intent it = getIntent();

        double peso = it.getDoubleExtra("peso", 1.0);
        String sexo = it.getStringExtra("sexo");
        int ncopos = it.getIntExtra("ncopos", 0);
        String jejum = it.getStringExtra("jejum");

        Log.i("teste-peso2", String.valueOf(peso));
        Log.i("teste-sexo2", sexo);
        Log.i("teste-ncopos2", String.valueOf(ncopos));
        Log.i("teste-jejum2", jejum);



        double tx = txalcoolemia(ncopos, peso, sexo, jejum);
        String classificacao;

        classificacao = tx > 0 ? "Pessoa Alcoolizada" : "Pessoa NÃO Alcoolizada";

        it.putExtra("txAlcoolemia", tx);
        it.putExtra("classificacao", classificacao);

        setResult(10, it);

        finish();
    }
}