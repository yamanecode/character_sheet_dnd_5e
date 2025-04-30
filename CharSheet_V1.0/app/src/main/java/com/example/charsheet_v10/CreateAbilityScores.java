package com.example.charsheet_v10;

import static com.example.charsheet_v10.CreateChar.charBackgroundFinal;
import static com.example.charsheet_v10.CreateChar.charClassFinal;
import static com.example.charsheet_v10.CreateChar.charSubclassFinal;
import static com.example.charsheet_v10.CreateChar.charAligmentFinal;
import static com.example.charsheet_v10.CreateChar.charRaceFinal;
import static com.example.charsheet_v10.CreateChar.charNameFinal;
import static com.example.charsheet_v10.MainActivity.charList;
import static com.example.charsheet_v10.MainActivity.indexChar;
import static com.example.charsheet_v10.MainActivity.myDatabase;
import static com.example.charsheet_v10.MainActivity.sharedPreferences;
import static java.lang.Math.floor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.lang.Object;
import java.lang.Math;
import java.util.ArrayList;

public class CreateAbilityScores extends AppCompatActivity {

    EditText textWatcherStr;
    EditText textWatcherDex;
    EditText textWatcherCon;
    EditText textWatcherInt;
    EditText textWatcherWis;
    EditText textWatcherCha;
    public void changeASMod (EditText view) {
      if (view.getId() ==  R.id.createStrScore){
          EditText editText = (EditText) view;
              int score = Integer.parseInt(editText.getText().toString());
              int mod;
              if (score <= 0){
                  mod = -5;
              }
              else{
                  mod = (int) floor((score-10)/2);
              }
              TextView editTextv = (TextView) findViewById(R.id.createStrMod);
              editTextv.setText(Integer.toString(mod));
      }
      if (view.getId() ==  R.id.createDexScore){
            EditText editText = (EditText) view;
            int score = Integer.parseInt(editText.getText().toString());
            int mod;
            if (score <= 0){
                mod = -5;
            }
            else{
                mod = (int) floor((score-10)/2);
            }
            TextView editTextv = (TextView) findViewById(R.id.createDexMod);
            editTextv.setText(Integer.toString(mod));
      }
      if (view.getId() ==  R.id.createConScore){
            EditText editText = (EditText) view;
            int score = Integer.parseInt(editText.getText().toString());
            int mod;
            if (score <= 0){
                mod = -5;
            }
            else{
                mod = (int) floor((score-10)/2);
            }
            TextView editTextv = (TextView) findViewById(R.id.createConMod);
            editTextv.setText(Integer.toString(mod));
      }
      if (view.getId() ==  R.id.createIntScore){
            EditText editText = (EditText) view;
            int score = Integer.parseInt(editText.getText().toString());
            int mod;
            if (score <= 0){
                mod = -5;
            }
            else{
                mod = (int) floor((score-10)/2);
            }
            TextView editTextv = (TextView) findViewById(R.id.createIntMod);
            editTextv.setText(Integer.toString(mod));
      }
      if (view.getId() ==  R.id.createWisScore){
            EditText editText = (EditText) view;
            int score = Integer.parseInt(editText.getText().toString());
            int mod;
            if (score <= 0){
                mod = -5;
            }
            else{
                mod = (int) floor((score-10)/2);
            }
            TextView editTextv = (TextView) findViewById(R.id.createWisMod);
            editTextv.setText(Integer.toString(mod));
      }
      if (view.getId() ==  R.id.createChaScore){
            EditText editText = (EditText) view;
            int score = Integer.parseInt(editText.getText().toString());
            int mod;
            if (score <= 0){
                mod = -5;
            }
            else{
                mod = (int) floor((score-10)/2);
            }
            TextView editTextv = (TextView) findViewById(R.id.createChaMod);
            editTextv.setText(Integer.toString(mod));
      }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_ability_scores);

       //STR
        textWatcherStr = findViewById(R.id.createStrScore);
        textWatcherStr.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                EditText editText = findViewById(R.id.createStrScore);
                editText.setFilters( new InputFilter[]{ new MinMaxFilter( "0" , "20" )}) ;
            }
            @Override
            public void afterTextChanged(Editable s) {
                if(s.toString().trim().length()>0 && !s.toString().equals("-")) {
                    changeASMod (findViewById(R.id.createStrScore));
                }
            }
        });
        //DEX
        textWatcherDex = findViewById(R.id.createDexScore);
        textWatcherDex.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                EditText editText = findViewById(R.id.createDexScore);
                editText.setFilters( new InputFilter[]{ new MinMaxFilter( "0" , "20" )}) ;
            }
            @Override
            public void afterTextChanged(Editable s) {
                if(s.toString().trim().length()>0 && !s.toString().equals("-")) {
                    changeASMod (findViewById(R.id.createDexScore));
                }
            }
        });
        //CON
        textWatcherCon = findViewById(R.id.createConScore);
        textWatcherCon.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                EditText editText = findViewById(R.id.createConScore);
                editText.setFilters( new InputFilter[]{ new MinMaxFilter( "0" , "20" )}) ;
            }
            @Override
            public void afterTextChanged(Editable s) {
                if(s.toString().trim().length()>0 && !s.toString().equals("-")) {
                    changeASMod (findViewById(R.id.createConScore));
                }
            }
        });
        //INT
        textWatcherInt = findViewById(R.id.createIntScore);
        textWatcherInt.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                EditText editText = findViewById(R.id.createIntScore);
                editText.setFilters( new InputFilter[]{ new MinMaxFilter( "0" , "20" )}) ;
            }
            @Override
            public void afterTextChanged(Editable s) {
                if(s.toString().trim().length()>0 && !s.toString().equals("-")) {
                    changeASMod (findViewById(R.id.createIntScore));
                }
            }
        });
        //WIS
        textWatcherWis = findViewById(R.id.createWisScore);
        textWatcherWis.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                EditText editText = findViewById(R.id.createWisScore);
                editText.setFilters( new InputFilter[]{ new MinMaxFilter( "0" , "20" )}) ;
            }
            @Override
            public void afterTextChanged(Editable s) {
                if(s.toString().trim().length()>0 && !s.toString().equals("-")) {
                    changeASMod (findViewById(R.id.createWisScore));
                }
            }
        });
        //CHA
        textWatcherCha = findViewById(R.id.createChaScore);
        textWatcherCha.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                EditText editText = findViewById(R.id.createChaScore);
                editText.setFilters( new InputFilter[]{ new MinMaxFilter( "0" , "20" )}) ;
            }
            @Override
            public void afterTextChanged(Editable s) {
                if(s.toString().trim().length()>0 && !s.toString().equals("-")) {
                    changeASMod (findViewById(R.id.createChaScore));
                }
            }
        });
    }
    public void goToFinishSheet(View view){
        EditText editText;
        String holdString;
        indexChar.add(indexChar.size());
        charList.add(charNameFinal);
        try {
            sharedPreferences.edit().putString("characters",ObjectSerializer.serialize(charList)).apply();
        } catch (IOException e) {
            e.printStackTrace();
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("bag_id",indexChar.size());
        contentValues.put("detail_id",indexChar.size());
        contentValues.put("proficiency_id",indexChar.size());
        contentValues.put("name", ""+charNameFinal);
        contentValues.put("race", ""+charRaceFinal);
        contentValues.put("class", ""+charClassFinal);
        contentValues.put("subclass", ""+charSubclassFinal);
        contentValues.put("background", ""+charBackgroundFinal);
        contentValues.put("alignment", ""+charAligmentFinal);
        editText = findViewById(R.id.createStrScore);
        holdString = editText.getText().toString();
        contentValues.put("str", ""+holdString);
        editText = findViewById(R.id.createDexScore);
        holdString = editText.getText().toString();
        contentValues.put("dex", ""+holdString);
        TextView textView = findViewById(R.id.createDexMod);
        holdString = textView.getText().toString();
        contentValues.put("ac", 11+Integer.parseInt(holdString));
        contentValues.put("initiative",Integer.parseInt(holdString));
        editText = findViewById(R.id.createConScore);
        holdString = editText.getText().toString();
        contentValues.put("con", ""+holdString);
        editText = findViewById(R.id.createIntScore);
        holdString = editText.getText().toString();
        contentValues.put("int", ""+holdString);
        editText = findViewById(R.id.createWisScore);
        holdString = editText.getText().toString();
        contentValues.put("wis", ""+holdString);
        editText = findViewById(R.id.createChaScore);
        holdString = editText.getText().toString();
        contentValues.put("cha", ""+holdString);
        contentValues.put("hp", "0");
        contentValues.put("speed", 30);
        contentValues.put("level", 1);

        myDatabase.insert("character",null,contentValues);

        try {
            charList =(ArrayList<String>) ObjectSerializer.deserialize(sharedPreferences.getString("characters",ObjectSerializer.serialize(new ArrayList<String>())));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(intent);
    }

}