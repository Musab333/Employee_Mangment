package com.example.employee_mangment;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class Display_Employee extends AppCompatActivity {
    Database db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_employee);

        TextView txtname = findViewById(R.id.txtName);
        TextView txtPhomeNo = findViewById(R.id.txtNoPhone);
        TextView txtِTitle = findViewById(R.id.txtِTitle);
        TextView txtِEmail = findViewById(R.id.txtِEmail);
        Button btnShowData = findViewById(R.id.btnShowData);

        db = new Database(this);
        btnShowData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = txtname.getText().toString();
                int phoneNo = Integer.parseInt(txtPhomeNo.getText().toString());
                String address = txtِTitle.getText().toString();
                String email = txtِEmail.getText().toString();

                ArrayList<Model> emps = db.getAllEmployee();
                txtname.setText(name);
                txtPhomeNo.setText(phoneNo);
                txtِTitle.setText(address);
                //Model model = new Model(name,phoneNo,address,email);

            }
        });

        Button btnBack = findViewById(R.id.btnBack2);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getBaseContext(),Home.class);
                startActivity(intent);
            }
        });
    }
}