package com.example.assignment_1;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class ReceiverInformationActivity extends AppCompatActivity {

    private EditText etName;
    private EditText etEmail;
    private EditText etPhone;
    private EditText etCountry;
    private EditText etAddress;
    private Button btnNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receiver_information_form);

        etName = findViewById(R.id.et_name);
        etEmail = findViewById(R.id.et_email);
        etPhone = findViewById(R.id.et_phone);
        etCountry = findViewById(R.id.et_country);
        etAddress = findViewById(R.id.et_address);
        btnNext = findViewById(R.id.btn_next);

        Intent intent = getIntent();
        final String senderName = intent.getStringExtra("sender_name");
        final String senderEmail = intent.getStringExtra("sender_email");
        final String senderPhone = intent.getStringExtra("sender_phone");
        final String senderCountry = intent.getStringExtra("sender_country");
        final String senderAddress = intent.getStringExtra("sender_address");

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = etName.getText().toString().trim();
                String email = etEmail.getText().toString().trim();
                String phone = etPhone.getText().toString().trim();
                String country = etCountry.getText().toString().trim();
                String address = etAddress.getText().toString().trim();

                if (name.isEmpty() || email.isEmpty() || phone.isEmpty() || address.isEmpty() || country.isEmpty()) {
                    Toast.makeText(ReceiverInformationActivity.this, "Please fill all fields", Toast.LENGTH_SHORT).show();
                    return;
                }

                if(phone.length() < 11 && !phone.matches("\\d+")){
                    Toast.makeText(ReceiverInformationActivity.this, "Invalid Phone number", Toast.LENGTH_SHORT).show();
                    return;
                }

                Intent reviewIntent = new Intent(ReceiverInformationActivity.this, ReviewInformationActivity.class);
                reviewIntent.putExtra("sender_name", senderName);
                reviewIntent.putExtra("sender_email", senderEmail);
                reviewIntent.putExtra("sender_phone", senderPhone);
                reviewIntent.putExtra("sender_country", senderCountry);
                reviewIntent.putExtra("sender_address", senderAddress);
                reviewIntent.putExtra("receiver_name", name);
                reviewIntent.putExtra("receiver_email", email);
                reviewIntent.putExtra("receiver_phone", phone);
                reviewIntent.putExtra("receiver_country", country);
                reviewIntent.putExtra("receiver_address", address);
                startActivity(reviewIntent);
            }
        });
    }
}
