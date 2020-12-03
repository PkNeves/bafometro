package adroid.petterson.bafometro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onActivityResult(int codigoRequisicao, int codigoResultado, Intent it) {
        super.onActivityResult(codigoRequisicao, codigoResultado, it);
        if (codigoRequisicao == 10) {
            String msg1 = "Taxa de Alcoolemia: " + String.valueOf(it.getDoubleExtra("txAlcoolemia", 0));
            String msg2 = "Classificação: " + it.getStringExtra("classificacao");
            String msg = msg1 + "\n" + msg2;
            Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
        }
    }

    public void navega(View view) {
        EditText peso = (EditText) findViewById(R.id.editPeso);
        EditText sexo = (EditText) findViewById(R.id.editSexo);
        EditText ncopos = (EditText) findViewById(R.id.editNCopos);
        EditText jejum = (EditText) findViewById(R.id.editJejum);

        Intent it = new Intent("DESEJADA_ACAO");

        it.putExtra("peso", Double.parseDouble(peso.getText().toString()));
        it.putExtra("sexo", sexo.getText().toString());
        it.putExtra("ncopos", Integer.parseInt(ncopos.getText().toString()));
        it.putExtra("jejum", jejum.getText().toString());

        startActivityForResult(it, 10);
    }
}