package com.example.battleship;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainMenuActivity extends AppCompatActivity {

    private Button onlineUsersButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        onlineUsersButton = findViewById(R.id.onlineUsersButton);

        onlineUsersButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startOnlineUsersActivity();
            }
        });
    }

    private void startOnlineUsersActivity() {
        Intent intent = new Intent(MainMenuActivity.this, OnlineUsersActivity.class);
        startActivity(intent);
    }
}
