package com.example.assignment_1;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class SenderInformationClass extends AppCompatActivity {

    private EditText etName;
    private EditText etEmail;
    private EditText etPhone;
    private EditText etCountry;
    private EditText etAddress;
    private Button btnNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sender_information_form);

        etName = findViewById(R.id.et_name);
        etEmail = findViewById(R.id.et_email);
        etPhone = findViewById(R.id.et_phone);
        etCountry = findViewById(R.id.et_country);
        etAddress = findViewById(R.id.et_address);
        btnNext = findViewById(R.id.btn_next);

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = etName.getText().toString().trim();
                String email = etEmail.getText().toString().trim();
                String phone = etPhone.getText().toString().trim();
                String country = etCountry.getText().toString().trim();
                String address = etAddress.getText().toString().trim();

                if (name.isEmpty() || email.isEmpty() || phone.isEmpty() || address.isEmpty() || country.isEmpty()) {
                    Toast.makeText(SenderInformationClass.this, "Please fill all fields", Toast.LENGTH_SHORT).show();
                    return;
                }

                if(phone.length() < 11 && !phone.matches("\\d+")){
                    Toast.makeText(SenderInformationClass.this, "Invalid Phone number", Toast.LENGTH_SHORT).show();
                    return;
                }

                Intent intent = new Intent(SenderInformationClass.this, ReceiverInformationActivity.class);
                intent.putExtra("sender_name", name);
                intent.putExtra("sender_email", email);
                intent.putExtra("sender_phone", phone);
                intent.putExtra("sender_country", country);
                intent.putExtra("sender_address", address);
                startActivity(intent);
            }
        });
    }
}
