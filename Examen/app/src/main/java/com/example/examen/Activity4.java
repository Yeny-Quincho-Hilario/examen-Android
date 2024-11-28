package com.example.examen;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Activity4 extends AppCompatActivity {
    EditText txtnombre, txtnota1, txtnota2,txtnota3, txtpeso1,txtpeso2,txtpeso3;
    Button btncalcular4,btnsalir4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_4);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        txtnombre = findViewById(R.id.txtnombre);
        txtnota1 = findViewById(R.id.txtnota1);
        txtnota2 = findViewById(R.id.txtnota2);
        txtnota3 = findViewById(R.id.txtnota3);
        txtpeso1 = findViewById(R.id.txtpeso1);
        txtpeso2 = findViewById(R.id.txtpeso2);
        txtpeso3 = findViewById(R.id.txtpeso3);
        btncalcular4 = findViewById(R.id.btncalcular4);
        btnsalir4 = findViewById(R.id.btnsalir4);

    }

    public void setBtncalcular4(View view){
        String  nombre = txtnombre.getText().toString();
        int nota1 = Integer.parseInt(txtnota1.getText().toString());
        int nota2 = Integer.parseInt(txtnota2.getText().toString());
        int nota3 = Integer.parseInt(txtnota3.getText().toString());
        int peso1 = Integer.parseInt(txtpeso1.getText().toString());
        int peso2 = Integer.parseInt(txtpeso2.getText().toString());
        int peso3 = Integer.parseInt(txtpeso3.getText().toString());
        double notafinal ;

        notafinal = (nota1 * ((peso1/100.0)) + nota2 * ((peso2/100.0)) + nota3 * ((peso3/100.0)));

        String estado;
        if (notafinal > 12){
            estado = "Estudiante aprueba";
        }
        else {
            estado = "Estudiante reprueba";
        }

        Intent ventana02 = new Intent(Activity4.this, Activity5.class);
        ventana02.putExtra("notafinal",notafinal);
        ventana02.putExtra("estado", estado);



        startActivity(ventana02);

    }
}