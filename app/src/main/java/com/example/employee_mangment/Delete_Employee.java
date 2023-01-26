package com.example.employee_mangment;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Delete_Employee extends AppCompatActivity {
    Database db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_employee);

        EditText txtFullName = findViewById(R.id.txt_full_name);

        Button btnDelete = findViewById(R.id.btnDel);

        Button btnBack = findViewById(R.id.btnBack);

        db = new Database(this);
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = txtFullName.getText().toString();

                //Model model = new Model(name);
                boolean res= db.deleteEmployee(name);
                if (res)
                    Toast.makeText(Delete_Employee.this,"تما حذف مؤظف",Toast.LENGTH_LONG).show();
                else
                    Toast.makeText(Delete_Employee.this,"عذرآ... لم يتم حذف مؤظف",Toast.LENGTH_LONG).show();


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