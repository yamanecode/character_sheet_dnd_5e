package com.example.charsheet_v10;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class CreateChar extends AppCompatActivity {

    EditText textWatcherCreateCharName;
    static String charNameFinal;
    static String charRaceFinal;
    static String charClassFinal;
    static String charSubclassFinal;
    static String charBackgroundFinal;
    static String charAligmentFinal;
    public void goToCreateAbilityScores(View view){
        EditText editText = findViewById(R.id.createCharName);
        charNameFinal = editText.getText().toString();
        Spinner spinner = (Spinner) findViewById(R.id.spinnerRace);
        charRaceFinal = spinner.getSelectedItem().toString();
        spinner = (Spinner) findViewById(R.id.spinnerClass);
        charClassFinal = spinner.getSelectedItem().toString();
        editText = findViewById(R.id.createCharBackground);
        charBackgroundFinal = editText.getText().toString();
        editText = findViewById(R.id.createCharSubclass);
        charSubclassFinal = editText.getText().toString();
        editText = findViewById(R.id.createCharAligment);
        charAligmentFinal = editText.getText().toString();


        Intent intent = new Intent(getApplicationContext(), CreateAbilityScores.class);
        startActivity(intent);
    }
    public void goToCharacterList(View view){
        Intent intent = new Intent(getApplicationContext(), CharacterList.class);
        startActivity(intent);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_char);

        textWatcherCreateCharName = findViewById(R.id.createCharName);
        textWatcherCreateCharName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }
}