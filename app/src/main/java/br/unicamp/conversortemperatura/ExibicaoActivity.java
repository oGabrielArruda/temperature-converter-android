package br.unicamp.conversortemperatura;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class ExibicaoActivity extends AppCompatActivity {
    TextView tvFahrenheit;
    TextView tvKelvin;
    Button btnVoltar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exibicao);

        // setar campos
        tvFahrenheit = findViewById(R.id.tvFahrenheit);
        tvKelvin = findViewById(R.id.tvKelvin);
        btnVoltar = findViewById(R.id.btnVoltar);

        // exibir conversao
        Intent intent = getIntent();
        Bundle recebe = intent.getExtras();
        exibirConversoes(recebe.getDouble("celsius"));

        btnVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    private void exibirConversoes(double celsius) {
        double fahrenheit = convertCelsiusToFahrenheit(celsius);
        double kelvin = convertCelsiusToKelvin(celsius);
        tvFahrenheit.setText(fahrenheit + "");
        tvKelvin.setText(kelvin + "");
    }

    private double convertCelsiusToFahrenheit(double celsius) {
        return ((double)9*celsius / 5) + 32;
    }

    private double convertCelsiusToKelvin(double celsius) {
        return celsius + 273.15;
    }
}