package com.example.charsheet_v10;

import static com.example.charsheet_v10.MainActivity.charList;
import static com.example.charsheet_v10.MainActivity.myDatabase;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class CharacterList extends AppCompatActivity {

    static ArrayAdapter arrayAdapter;
    static String holdName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_character_list);

        ListView listView = (ListView) findViewById(R.id.listViewCharList);

     //   ArrayAdapter arrayAdapter = new ArrayAdapter(this, R.layout.activity_character_list, charList);
        ArrayAdapter arrayAdapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,charList);
        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getApplicationContext(),CharacterSheet.class);
                holdName = (String) listView.getItemAtPosition(position);
                intent.putExtra("charId",position);
                startActivity(intent);
            }
        });
    }
}