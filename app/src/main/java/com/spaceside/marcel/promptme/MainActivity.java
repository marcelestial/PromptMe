package com.spaceside.marcel.promptme;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button getPromptsButton = (Button) findViewById(R.id.button);
        Button characterButton = (Button) findViewById(R.id.button2);

        getPromptsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), CharacterSelectActivity.class);
                startActivity(intent);
            }
        });

        characterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), PromptActivity.class);
                startActivity(intent);
            }
        });
    }
}
