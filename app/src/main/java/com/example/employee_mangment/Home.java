package com.example.employee_mangment;

import android.content.Intent;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import javax.security.auth.Destroyable;

public class Home extends AppCompatActivity {
    Database db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Button goBtnAdd = findViewById(R.id.btnAdd);
        Button goBtnShow = findViewById(R.id.btnShow);
        Button goBtnUpdate = findViewById(R.id.btnUpdate);
        Button goBtnDelete = findViewById(R.id.btnDelete);

        Button btnExit = findViewById(R.id.btnLogOut2);
        ImageView image = findViewById(R.id.imageView);


        db = new Database(this);
        goBtnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getBaseContext(), Add_Employee.class);
                startActivity(intent);
            }
        });

        goBtnShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                long empCount = db.countOfEmployee();
                Toast.makeText(Home.this,"عدد الموظفيين هو: "+empCount,Toast.LENGTH_LONG).show();

                //Intent intent = new Intent(getBaseContext(), Display_Employee.class);
                //startActivity(intent);
            }
        });

        goBtnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getBaseContext(), Update_Employee.class);
                startActivity(intent);
            }
        });

        goBtnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getBaseContext(),Delete_Employee.class);
                startActivity(intent);
            }
        });

        btnExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                System.exit(1);
            }
        });

        image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Home.this,"تطبيق أدارة المؤظفيين",Toast.LENGTH_LONG).show();
            }
        });

    }
}