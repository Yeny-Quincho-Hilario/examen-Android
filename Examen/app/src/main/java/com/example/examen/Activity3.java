package com.example.examen;

import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Activity3 extends AppCompatActivity {
    TextView lblresultado;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_3);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        lblresultado = findViewById(R.id.lblresultado);
        String producto = getIntent().getStringExtra("producto");
        double precio = getIntent().getDoubleExtra("precio", 0);
        int descuento = getIntent().getIntExtra("descuento", 0);
        double precioDescuento = getIntent().getDoubleExtra("precioDescuento", 0);
        boolean igv = getIntent().getBooleanExtra("igv", false);

        double precioFinal;
        if (igv){
            precioFinal = precioDescuento * 1.18;
        }
        else{
            precioFinal = precio;
        }
        //finalmente mostramos los resultados

        String resultados = "Producto: "+ producto + "\n"+ "Precio: " + precio +"\n"+ "Descuento: "+
                descuento +  "%"+ "\n" + "precio con Descuento: " + precioDescuento + "\n" + "precio final:"+ precioFinal;
        lblresultado.setText(resultados);

    }


}