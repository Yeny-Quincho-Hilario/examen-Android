package com.example.examen;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Activity2 extends AppCompatActivity {
    EditText txtproducto, txtdescuento, txtprecio;
    Button btncalcular2,btnsalir2;
    RadioGroup rbtopciones;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_2);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        txtproducto = findViewById(R.id.txtproducto);
        txtdescuento = findViewById(R.id.txtdescuento);
        txtprecio = findViewById(R.id.txtprecio);
        btncalcular2 = findViewById(R.id.btncalcular2);
        btnsalir2 = findViewById(R.id.btnsalir2);
        rbtopciones = findViewById(R.id.rbtopciones);

    }

    public void setBtncalcular2 (View view){

        String producto = txtproducto.getText().toString();
        double precio = Double.parseDouble(txtprecio.getText().toString());
        int descuento =Integer.parseInt (txtdescuento.getText().toString());
        double precioDescuento = precio * (1 -(descuento/100.0));

        int opciones = rbtopciones.getCheckedRadioButtonId();
        boolean igv = opciones==R.id.rbtigv;

        Intent ventana01 = new Intent(Activity2.this, Activity3.class);
        ventana01.putExtra("producto", producto);
        ventana01.putExtra("precio", precio);
        ventana01.putExtra("descuento", descuento);
        ventana01.putExtra("precioDescuento",precioDescuento);
        ventana01.putExtra("igv",igv);

        startActivity(ventana01);

    }
}