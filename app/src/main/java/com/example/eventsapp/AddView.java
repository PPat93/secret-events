package com.example.eventsapp;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.text.HtmlCompat;

public class AddView extends AppCompatActivity {

    Button cancelButton;
    Button okButton;
    EditText passphraseInput;
    TextView receivedPass;
    AlertDialog alertDialog;
    private String title;
    private String newPassphraseValue = "";
    Intent revealNewPassIntent;

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
                passphraseInput = findViewById(R.id.passphraseInput);
                if (!passphraseInput.getText().toString().equals(""))
                    receiveNewPass();
            }
        });
    }

    protected AlertDialog createAlertDialog(String passphrase) {

        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this)
                .setIcon(R.drawable.baseline_event_24)
                .setTitle("More fun?")
                .setMessage(HtmlCompat.fromHtml("Are you sure to add new <b>" + passphrase + "</b> phrase and to have even more fun?", HtmlCompat.FROM_HTML_MODE_LEGACY))
                .setPositiveButton("YES!", (dialogInterface, i) -> {
                    searchAndActivateEventsDbItem(passphrase);
                    Toast.makeText(AddView.this, "WOHOOO! Let's go!", Toast.LENGTH_SHORT).show();
                    newPassphraseValue = "";
                    receivedPass.setText("");
                    startActivity(revealNewPassIntent);
                })
                .setNegativeButton("No :(", (dialogInterface, i) -> {
                    Toast.makeText(AddView.this, "That'sad :(", Toast.LENGTH_SHORT).show();
                    newPassphraseValue = "";
                    receivedPass.setText("");
                });

        return alertDialogBuilder.create();
    }

    protected void receiveNewPass() {

        passphraseInput = findViewById(R.id.passphraseInput);
        receivedPass = findViewById(R.id.receivedTitle);
        newPassphraseValue += passphraseInput.getText().toString();
        receivedPass.setText(new StringBuilder().append("Password entered: ").append(newPassphraseValue).toString());
        revealNewPassIntent = new Intent(this, MainActivity.class);
        revealNewPassIntent.putExtra("newPass", newPassphraseValue);

        alertDialog = createAlertDialog(newPassphraseValue);
        alertDialog.show();
    }

    //  Update visibility of the event whose password was found
    protected void searchAndActivateEventsDbItem(String passphrase) {

        MainActivity.dbRecordsRetrieved.forEach(singleRecord -> {

            if (singleRecord.get(1).equals(passphrase.trim())) {
                int currentIndex = MainActivity.dbRecordsRetrieved.indexOf(singleRecord);
                MainActivity.eventsDB.execSQL("UPDATE events SET is_visible = TRUE WHERE id = " + currentIndex + ";");
            }
        });
    }
}
