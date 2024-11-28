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

public class Activity6 extends AppCompatActivity {
EditText txtproducto1, txtpreciob, txtmetodo, txtpais;
RadioGroup rbtopcion;
Button btncalcular6, btnsalir6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_6);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        txtproducto1 = findViewById(R.id.txtproducto1);
        txtpreciob = findViewById(R.id.txtpreciob);
        txtpais = findViewById(R.id.txtpais);
        btncalcular6 = findViewById(R.id.btncalcular6);
        rbtopcion = findViewById(R.id.rbtopcion);


    }
    public void setBtncalcular6 (View view){

        String producto1 = txtproducto1.getText().toString();
        double preciob = Double.parseDouble(txtpreciob.getText().toString());
        String pais = txtpais.getText().toString();

        int opciones = rbtopcion.getCheckedRadioButtonId();
        boolean metodo = opciones==R.id.rbtestandar;

        Intent ventana04 = new Intent(Activity6.this, Activity7.class);
        ventana04.putExtra("producto1", producto1);
        ventana04.putExtra("preciob", preciob);
        ventana04.putExtra("pais", pais);
        ventana04.putExtra("metodo", metodo);

        startActivity(ventana04);
    }
}