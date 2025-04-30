package com.example.charsheet_v10;

import static com.example.charsheet_v10.CharacterList.holdName;
import static com.example.charsheet_v10.MainActivity.charList;
import static com.example.charsheet_v10.MainActivity.indexChar;
import static com.example.charsheet_v10.MainActivity.myDatabase;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.EditText;
import android.widget.Spinner;

public class CharacterSheet extends AppCompatActivity {

    private int getIndex(Spinner spinner, String myString){
        for (int i=0;i<spinner.getCount();i++){
            if (spinner.getItemAtPosition(i).toString().equalsIgnoreCase(myString)){
                return i;
            }
        }

        return 0;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_character_sheet);

        Spinner spinner;

        Cursor c = myDatabase.rawQuery("SELECT * FROM character WHERE name = ?",new String[]{holdName});

        int nameIndex = c.getColumnIndex("name");
        int raceIndex = c.getColumnIndex("race");
        int classIndex = c.getColumnIndex("class");
        int subclassIndex = c.getColumnIndex("subclass");
        int bgIndex = c.getColumnIndex("background");
        int alIndex = c.getColumnIndex("alignment");
        int strIndex = c.getColumnIndex("str");
        int dexIndex = c.getColumnIndex("dex");
        int conIndex = c.getColumnIndex("con");
        int intIndex = c.getColumnIndex("int");
        int wisIndex = c.getColumnIndex("wis");
        int chaIndex = c.getColumnIndex("cha");
        EditText editText;
        c.moveToFirst();
        editText = findViewById(R.id.sheetCharName);
        editText.setText(c.getString(nameIndex));
        spinner = findViewById(R.id.spinnerSheetRace);
        spinner.setSelection(getIndex(spinner, c.getString(raceIndex)));
        spinner = findViewById(R.id.spinnerSheetClass);
        spinner.setSelection(getIndex(spinner, c.getString(classIndex)));
        editText = findViewById(R.id.sheetCharSubclass);
        editText.setText(c.getString(subclassIndex));
        editText = findViewById(R.id.sheetCharBackground);
        editText.setText(c.getString(bgIndex));
        editText = findViewById(R.id.sheetCharAligment);
        editText.setText(c.getString(alIndex));
        editText = findViewById(R.id.sheetStrScore);
        editText.setText(c.getString(strIndex));
        editText = findViewById(R.id.sheetDexScore);
        editText.setText(c.getString(dexIndex));
        editText = findViewById(R.id.sheetConScore);
        editText.setText(c.getString(conIndex));
        editText = findViewById(R.id.sheetIntScore);
        editText.setText(c.getString(intIndex));
        editText = findViewById(R.id.sheetWisScore);
        editText.setText(c.getString(wisIndex));
        editText = findViewById(R.id.sheetChaScore);
        editText.setText(c.getString(chaIndex));

    }
}