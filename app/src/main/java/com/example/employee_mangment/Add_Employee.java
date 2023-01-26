package com.example.employee_mangment;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Add_Employee extends AppCompatActivity {

    Database db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_employee);

        Button BtnBack = findViewById(R.id.btnBack);
        Button btnSave = findViewById(R.id.btnUpdateSave);

        EditText txtFullName = findViewById(R.id.txt_full_name);
        EditText txtPhoneNo = findViewById(R.id.txt_No_Phone);
        EditText txtAddress = findViewById(R.id.txt_Address);
        EditText txtEmail = findViewById(R.id.txt_Email);

        db = new Database(this);
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = txtFullName.getText().toString();
                int phoneNo = Integer.parseInt(txtPhoneNo.getText().toString());
                String address = txtAddress.getText().toString();
                String email = txtEmail.getText().toString();
                String n = "";


                Model model = new Model(name,phoneNo,address,email);
                boolean res= db.insertEmployee(model);
                if (res)
                    Toast.makeText(Add_Employee.this,"تما أضافة مؤظف جديد",Toast.LENGTH_LONG).show();
                else
                    Toast.makeText(Add_Employee.this,"عذرآ... لم يتم أضافة مؤظف",Toast.LENGTH_LONG).show();

            }
        });

        BtnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getBaseContext(),Home.class);
                startActivity(intent);
            }
        });
    }
}