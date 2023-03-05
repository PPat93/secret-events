package com.example.eventsapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class AddView extends AppCompatActivity {

    Button cancelButton;
    Button okButton;
    EditText passphraseInput;
    TextView receivedPass;

    private String title = "Added item: ";
    private String description = "Next stop: ";
    private String image = "";
    //private String hour = TODO

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_add);

        cancelButton = findViewById(R.id.cancelButton);
        okButton = findViewById(R.id.okButton);
        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        okButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                receiveNewPass();
            }
        });
    }

    protected String receiveNewPass() {
        passphraseInput = (EditText) findViewById(R.id.passphraseInput);
        receivedPass = (TextView) findViewById(R.id.receivedTitle);
        title += passphraseInput.getText().toString();
        receivedPass.setText(title);
        return title;
    }
}
