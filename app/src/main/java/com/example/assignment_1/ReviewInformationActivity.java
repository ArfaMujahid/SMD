package com.example.assignment_1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class ReviewInformationActivity extends AppCompatActivity {

    private TextView tvSenderName;
    private TextView tvSenderCountry;
    private TextView tvSenderAddress;
    private TextView tvSenderContactInfo;
    private TextView tvReceiverName;
    private TextView tvReceiverCountry;
    private TextView tvReceiverAddress;
    private TextView tvReceiverContactInfo;
    private FloatingActionButton floatingActionButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_review_information);

        tvSenderName = findViewById(R.id.tv_name_sender);
        tvSenderCountry = findViewById(R.id.tv_country_sender);
        tvSenderAddress = findViewById(R.id.tv_address_sender);
        tvSenderContactInfo = findViewById(R.id.tv_contact_info_sender);
        tvReceiverName = findViewById(R.id.tv_name_receiver);
        tvReceiverCountry = findViewById(R.id.tv_country_receiver);
        tvReceiverAddress = findViewById(R.id.tv_address_receiver);
        tvReceiverContactInfo = findViewById(R.id.tv_contact_info_receiver);

        Intent intent = getIntent();
        String senderName = intent.getStringExtra("sender_name");
        String senderCountry = intent.getStringExtra("sender_country");
        String senderAddress = intent.getStringExtra("sender_address");
        String senderContactInfo = intent.getStringExtra("sender_contact_info");
        String receiverName = intent.getStringExtra("receiver_name");
        String receiverCountry = intent.getStringExtra("receiver_country");
        String receiverAddress = intent.getStringExtra("receiver_address");
        String receiverContactInfo = intent.getStringExtra("receiver_contact_info");

        if (senderName != null) {
            tvSenderName.setText(senderName);
        }
        if (senderCountry != null) {
            tvSenderCountry.setText(senderCountry);
        }
        if (senderAddress != null) {
            tvSenderAddress.setText(senderAddress);
        }
        if (senderContactInfo != null) {
            tvSenderContactInfo.setText(senderContactInfo);
        }
        if (receiverName != null) {
            tvReceiverName.setText(receiverName);
        }
        if (receiverCountry != null) {
            tvReceiverCountry.setText(receiverCountry);
        }
        if (receiverAddress != null) {
            tvReceiverAddress.setText(receiverAddress);
        }
        if (receiverContactInfo != null) {
            tvReceiverContactInfo.setText(receiverContactInfo);
        }

        floatingActionButton = findViewById(R.id.floatingActionButton);

        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ReviewInformationActivity.this, SenderInformationClass.class);
                startActivity(intent);
            }
        });
    }
}
