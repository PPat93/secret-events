package com.example.eventsapp;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.text.HtmlCompat;

import java.util.Objects;

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
        passphraseInput = findViewById(R.id.passphraseInput);
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

    //    creates a dialog - after a successful reveal it is displayed. Button yes allows to update db with visibility and new order number
    protected AlertDialog createAlertDialog(String passphrase) {

        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this)
                .setIcon(R.drawable.baseline_event_24)
                .setTitle("More fun?")
                .setMessage(HtmlCompat.fromHtml("Are you sure to add new <b>" + passphrase + "</b> phrase and to have even more fun?", HtmlCompat.FROM_HTML_MODE_LEGACY))
                .setPositiveButton("YES!", (dialogInterface, i) -> {
                    int sizeOfRevealedEventsPlusOne = MainListActivity.events.size() + 1;
                    Toast.makeText(AddView.this, "WOHOOO! Let's go!", Toast.LENGTH_SHORT).show();
                    MainListActivity.eventsDB.execSQL("UPDATE events SET is_visible = 1 WHERE passphrase = '" + passphrase.trim().toLowerCase() + "';");
                    MainListActivity.eventsDB.execSQL("UPDATE events SET order_number = '" + sizeOfRevealedEventsPlusOne + "' WHERE passphrase = '" + passphrase.trim().toLowerCase() + "';");
                    newPassphraseValue = "";
                    receivedPass.setText("");
                    MainListActivity.runFanfaresAnim = true;
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
        newPassphraseValue = passphraseInput.getText().toString();
        revealNewPassIntent = new Intent(this, MainListActivity.class);

        alertDialog = createAlertDialog(newPassphraseValue);
        int isEventFound = searchAndActivateEventsDbItem(newPassphraseValue);
        if (isEventFound == 1) {
            receivedPass.setText("");
            alertDialog.show();
        } else if (isEventFound == 0) {
            receivedPass.setText(new StringBuilder().append("Unfortunately, \"").append(newPassphraseValue).append("\" password does not exist. Nice try.").toString());
        } else if (isEventFound == 2) {
            receivedPass.setText(new StringBuilder().append("Already revealed! Don't be so smart.").toString());
        }
    }

    protected int searchAndActivateEventsDbItem(String passphrase) {
//        if isEventFoundLocal = 0 - item not found, if 1 - item found and good to activate, if 2 - already revealed
        int isEventFoundLocal = 0;
        String sanitizedPassphrase = passphrase.trim().toLowerCase();

        boolean doesEventExist = MainListActivity.dbRecordsRetrieved.containsKey(sanitizedPassphrase);

        if (doesEventExist) {
            if (Objects.equals(MainListActivity.dbRecordsRetrieved.get(sanitizedPassphrase).get(4), "1"))
                isEventFoundLocal = 2;
            else
                isEventFoundLocal = 1;
        }
        return isEventFoundLocal;
    }
}
