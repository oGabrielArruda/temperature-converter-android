package br.unicamp.conversortemperatura;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText edtConverter;
    Button btnConverter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtConverter = findViewById(R.id.edtCelsius);
        btnConverter = findViewById(R.id.btnConverter);

        btnConverter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String celsius = edtConverter.getText().toString();
                if(celsius.isEmpty())
                    Toast.makeText(MainActivity.this, "Preencha o campo Celsius", Toast.LENGTH_LONG).show();
                else
                    mudarParaTelaExibicao(Double.parseDouble(celsius));
            }
        });
    }

    private void mudarParaTelaExibicao(double celsius) {
        Intent intent = new Intent(MainActivity.this, ExibicaoActivity.class);
        Bundle params = new Bundle();
        params.putDouble("celsius", celsius);
        intent.putExtras(params);
        startActivity(intent);
        edtConverter.setText("");
    }
}