package com.example.employee_mangment;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnGoTo = findViewById(R.id.btnGoTo);
        Button btnLogOut = findViewById(R.id.btnLogOut);

        btnGoTo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                 Intent intent = new Intent(getBaseContext(), Home.class);
                 startActivity(intent);
                //Toast.makeText(null,"مرحبآ بيك",Toast.LENGTH_LONG).show();


            }
        });

        btnLogOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(null,"شكرآ لتعاملك مع التطبيق",Toast.LENGTH_LONG).show();
                System.exit(1);
            }
        });

    }


}