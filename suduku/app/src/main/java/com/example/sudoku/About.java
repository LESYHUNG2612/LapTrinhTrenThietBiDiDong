package com.example.sudoku;


import android.app.Activity;

import android.os.Bundle;
import android.view.View;


public class About extends Activity {

    @Override

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.about);  // Call layout about.xml
        View newButton = findViewById(R.id.new_game_button);
        newButton.setOnClickListener(this);
        View continueButton = findViewById(R.id.continue_button);
        continueButton.setOnClickListener(this);
        View aboutButton = findViewById(R.id.about_button);
        aboutButton.setOnClickListener(this);
        View exitButton = findViewById(R.id.exit_button);
        exitButton.setOnClickListener(this);
    }

}