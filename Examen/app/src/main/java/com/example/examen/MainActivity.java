package com.example.examen;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
    public  void setBtnejercicio1 (View view){
        Intent ventana01 = new Intent(MainActivity.this, Activity2.class);
        startActivity(ventana01);
    }
    public  void setBtnejercicio2 (View view){
        Intent ventana02 = new Intent(MainActivity.this, Activity4.class);
        startActivity(ventana02);
    }
  public  void setBtnejercicio3 (View view){
        Intent ventana03 = new Intent(MainActivity.this, Activity6.class);
        startActivity(ventana03);
    }

}