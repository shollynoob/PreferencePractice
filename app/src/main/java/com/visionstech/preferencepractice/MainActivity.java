package com.visionstech.preferencepractice;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText name, age;
    SharedPreferences myprefs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myprefs = getPreferences(MODE_PRIVATE);

        init();
    }

    private void init(){
        name = (EditText) findViewById(R.id.editTextname);
        age = (EditText) findViewById(R.id.editTextage);
        readPrefences();
    }

    public void onReset(View view) {
        SharedPreferences.Editor editor = myprefs.edit();
        editor.clear();
        editor.commit();
        readPrefences();
    }

    public void onSave(View view) {
        String textName = name.getText().toString();
        int textAge = Integer.parseInt(age.getText().toString());

        SharedPreferences.Editor editor = myprefs.edit();
        editor.putString("keyname", textName);
        editor.putInt("keyage", textAge);
        editor.commit();
    }
    public void onsaved(){

        String textName = name.getText().toString();
        int textAge = Integer.parseInt(age.getText().toString());

        SharedPreferences.Editor editor = myprefs.edit();
        editor.putString("keyname", textName);
        editor.putInt("keyage", textAge);
        editor.commit();

    }

    public void readPrefences(){
        String st1= myprefs.getString("keyname", "");
        name.setText(st1);

        int val = myprefs.getInt("keyage", 0);
        age.setText(String.valueOf(val));
    }

    @Override
    public void onBackPressed() {
        onsaved();
        super.onBackPressed();
    }
}
