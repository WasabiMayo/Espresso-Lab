package com.example.wasabi.espressolabexercise;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView balanceTextView;
    EditText editText;
    Button addButton, decreaseButton, infoButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Account myAccount = new Account(0.00);

        balanceTextView = (TextView)findViewById(R.id.balance_textView);
        editText = (EditText)findViewById(R.id.editText);
        addButton = (Button) findViewById(R.id.add_button);
        decreaseButton = (Button)findViewById(R.id.decrease_button);
        infoButton = (Button) findViewById(R.id.account_info_button);

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double addedAmount = Double.parseDouble(editText.getText().toString());
                myAccount.depositMoney(addedAmount);
                balanceTextView.setText("$"+String.valueOf(myAccount.getBalance()));
            }
        });

        decreaseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double addedAmount = Double.parseDouble(editText.getText().toString());
                myAccount.withdrawMoney(addedAmount);
                balanceTextView.setText("$"+String.valueOf(myAccount.getBalance()));
            }
        });

        infoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, InfoActivity.class);
                intent.putExtra("ACCOUNT",myAccount);
                startActivity(intent);
            }
        });

    }
}
