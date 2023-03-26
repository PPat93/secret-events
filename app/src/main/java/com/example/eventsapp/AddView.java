package com.example.eventsapp;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
<<<<<<< Updated upstream
import android.util.Log;
=======
>>>>>>> Stashed changes
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.text.HtmlCompat;

import java.util.concurrent.atomic.AtomicBoolean;

public class AddView extends AppCompatActivity {

    Button cancelButton;
    Button okButton;
    EditText passphraseInput;
    TextView receivedPass;
    AlertDialog alertDialog;
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
                    Toast.makeText(AddView.this, "WOHOOO! Let's go!", Toast.LENGTH_SHORT).show();
                    MainActivity.eventsDB.execSQL("UPDATE events SET is_visible = 1 WHERE passphrase = '" + passphrase.trim().toLowerCase() + "';");
                    newPassphraseValue = "";
                    receivedPass.setText("");
                    revealNewPassIntent.putExtra("passphraseAdded", "1");
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

        alertDialog = createAlertDialog(newPassphraseValue);
        AtomicBoolean isEventFound = searchAndActivateEventsDbItem(newPassphraseValue);
        if (isEventFound.get())
            alertDialog.show();
<<<<<<< Updated upstream
        else {
            newPassphraseValue = "";
            receivedPass.setText("");
=======
        } else if (isEventFound == 0) {
            receivedPass.setText(new StringBuilder().append("Unfortunately, ").append(newPassphraseValue).append(" password does not exist. Nice try.").toString());
        } else if (isEventFound == 2) {
            receivedPass.setText(new StringBuilder().append("Already revealed! Don't be so smart.").toString());
>>>>>>> Stashed changes
        }
    }

    protected AtomicBoolean searchAndActivateEventsDbItem(String passphrase) {
//       Retrieved db records are searched for the passphrase that was passed in the AddView input if so,
//       eventFound variable is set to true, else, it remains false. Also, redundant whitespaces of the
//       passphrase are removed and the AtomicBoolean is returned

        AtomicBoolean eventFound = new AtomicBoolean(false);
        eventFound.set(MainActivity.dbRecordsRetrieved.containsKey(passphrase.trim().toLowerCase()));
        return eventFound;
    }
}
