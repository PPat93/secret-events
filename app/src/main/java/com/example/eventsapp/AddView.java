package com.example.eventsapp;

import android.content.Intent;
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
    private Integer confirm = 0;
    private String newPassphraseValue = "";
    private String description = "Next stop: ";
    private String image = "";
    //private String hour = TODO

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_add);
        confirm = 0;
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

    protected void receiveNewPass() {
        passphraseInput = findViewById(R.id.passphraseInput);
        receivedPass =  findViewById(R.id.receivedTitle);
        newPassphraseValue += passphraseInput.getText().toString();
        String displayPass = title + newPassphraseValue;
        receivedPass.setText(displayPass);
        Intent revealNewPassIntent = new Intent(this, MainActivity.class);
        revealNewPassIntent.putExtra("newPass", newPassphraseValue);

        if (confirm == 1) {
            MainActivity.events.add(new Event(newPassphraseValue, "Plac bohaterów getta 3, Kraków ", R.drawable.testimg3));
            startActivity(revealNewPassIntent);
        } else
            confirm = 1;
    }
}
