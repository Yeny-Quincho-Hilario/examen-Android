package com.example.examen;

import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Activity7 extends AppCompatActivity {
    TextView lblresultado7;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_7);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        lblresultado7 = findViewById(R.id.lblresultado7);

        String producto1 = getIntent().getStringExtra("producto1");
        double preciob = getIntent().getDoubleExtra("preciob",0);
        String pais = getIntent().getStringExtra("pais");
        boolean metodo = getIntent().getBooleanExtra("metodo", false);

        double envio;

        if (metodo){
            envio = 20.00;
        }
        else {
            envio = 50.00;
        }

        double impuesto;

        if(pais.equals("EE.UU")){
            impuesto = 0.08 * preciob;
        } else if (pais.equals("China")){
            impuesto = 0.12 * preciob;
        } else if (pais.equals("Europa")) {
           impuesto = 0.15*preciob;
        } else if ( pais.equals("otro")) {
            impuesto = 0.05 * preciob;
        }
        else {
            impuesto = 0;
        }


        double costoenvio = preciob + envio;

        double costoTotal= costoenvio + impuesto ;
        double PrecioConDescuento;

        if (costoTotal > 500){
            PrecioConDescuento =  costoTotal * 0.90;
        }
        else{
            PrecioConDescuento = costoTotal;
        }

        //finalmente mostramos los resultados

                String resultados = "Precio Base:  "+ preciob + "\n"+ "Pais: " + pais + "\n"+ "Impuesto: " + impuesto +
                        "\n" + "Costo Envio: " + costoenvio + "\n" + "Costo total: " + costoTotal + "\n" + "Precio con descuento: " +
                        PrecioConDescuento;

        lblresultado7.setText(resultados);


    }
}