package com.example.charsheet_v10;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;

import java.io.IOException;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public static ArrayList<Integer> indexChar = new ArrayList<Integer>();
    public static ArrayList<String> charList = new ArrayList<>();
    public static SharedPreferences sharedPreferences;
    public static SQLiteDatabase myDatabase;
    public void goToCreateChar(View view){
        Intent intent = new Intent(getApplicationContext(), CreateChar.class);
        startActivity(intent);
    }
    public void goToCharacterList(View view){
        Intent intent = new Intent(getApplicationContext(), CharacterList.class);
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sharedPreferences = this.getSharedPreferences("com.example.charsheet_v10", Context.MODE_PRIVATE);
        try {
            charList =(ArrayList<String>) ObjectSerializer.deserialize(sharedPreferences.getString("characters",ObjectSerializer.serialize(new ArrayList<String>())));
        } catch (IOException e) {
            e.printStackTrace();
        }
        myDatabase = this.openOrCreateDatabase("DataBase",MODE_PRIVATE,null);
        myDatabase.execSQL("CREATE TABLE IF NOT EXISTS character (id INT PRIMARY KEY, name VARCHAR," +
                "level INT, race VARCHAR, " +
                "class VARCHAR, subclass VARCHAR, background VARCHAR, alignment VARCHAR, str INT," +
                "dex INT, con INT, int INT, wis INT, cha INT, hp INT, ac INT, initiative INT," +
                "speed INT, bag_id INT, detail_id INT, proficiency_id INT)");
        myDatabase.execSQL("CREATE TABLE IF NOT EXISTS bag (id INT, item_name VARCHAR, item_qty INT)");
        myDatabase.execSQL("CREATE TABLE IF NOT EXISTS detail (id INT, text VARCHAR)");
        myDatabase.execSQL("CREATE TABLE IF NOT EXISTS proficiency (id INT, str_save BOOLEAN," +
                "dex_save BOOLEAN, con_save BOOLEAN, int_save BOOLEAN, wis_save BOOLEAN, cha_save BOOLEAN," +
                "acrobatics BOOLEAN, animal BOOLEAN, arcana BOOLEAN, athletics BOOLEAN, deception BOOLEAN," +
                "history BOOLEAN, insight BOOLEAN, intimidation BOOLEAN, investigation BOOLEAN," +
                "medicine BOOLEAN, nature BOOLEAN, perception BOOLEAN, performance BOOLEAN, " +
                "persuasion BOOLEAN, religion BOOLEAN, sleight BOOLEAN, stealth BOOLEAN, survival BOOLEAN)");

    }
}