package com.example.wasabi.espressolabexercise;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class InfoActivity extends AppCompatActivity {

    TextView usernameTextView, emailTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        Account receivedAccount = (Account) getIntent().getSerializableExtra("ACCOUNT");

        usernameTextView = (TextView)findViewById(R.id.username_textView);
        emailTextView = (TextView)findViewById(R.id.email_textView);

        usernameTextView.setText(receivedAccount.getUsername());
        emailTextView.setText(receivedAccount.getEmail());
    }
}
