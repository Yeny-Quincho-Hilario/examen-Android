package com.example.examen;

import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Activity5 extends AppCompatActivity {
    TextView lblresultado;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_5);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        lblresultado = findViewById(R.id.lblresultado);
        double notafinal = getIntent().getDoubleExtra("notafinal",0);
        String estado = getIntent().getStringExtra("estado");
        //finalmente mostramos los resultados

        String resultados = "Nota Final:  "+ notafinal + "\n"+ "Estado: " + estado ;
        lblresultado.setText(resultados);


    }
}