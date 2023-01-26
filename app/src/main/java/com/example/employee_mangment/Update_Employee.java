package com.example.employee_mangment;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Update_Employee extends AppCompatActivity {
    Database db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_employee);

        EditText txtFullName = findViewById(R.id.txt_full_name);
        EditText txtPhoneNo = findViewById(R.id.txt_No_Phone);
        EditText txtAddress = findViewById(R.id.txt_Address);
        EditText txtEmail = findViewById(R.id.txt_Email);

        Button btnUpdateSave = findViewById(R.id.btnUpdateSave);
        Button btnBack = findViewById(R.id.btnBack);

        db = new Database(this);
        btnUpdateSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = txtFullName.getText().toString();
                int phoneNo = Integer.parseInt(txtPhoneNo.getText().toString());
                String address = txtAddress.getText().toString();
                String email = txtEmail.getText().toString();

                Model model = new Model(name,phoneNo,address,email);
                boolean res= db.updateEmployee(model);
                if (res)
                    Toast.makeText(Update_Employee.this,"تما تعديل بيانات مؤظف",Toast.LENGTH_LONG).show();
                else
                    Toast.makeText(Update_Employee.this,"عذرآ... لم يتم تعديل مؤظف",Toast.LENGTH_LONG).show();
            }
        });

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getBaseContext(),Home.class);
                startActivity(intent);
            }
        });
    }
}