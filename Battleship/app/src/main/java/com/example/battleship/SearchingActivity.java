package com.example.battleship;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import androidx.appcompat.app.AppCompatActivity;
import com.example.battleship.MatchmakingManager.MatchmakingCallback;

public class SearchingActivity extends AppCompatActivity {

    private MatchmakingManager mMatchmakingManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_searching);

        String userId = "USER_ID"; // Replace with the user's ID
        mMatchmakingManager = new MatchmakingManager(userId);
        mMatchmakingManager.findMatch(new MatchmakingCallback() {
            @Override
            public void onMatchFound(String roomId) {
                startGameActivity(roomId);
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mMatchmakingManager.cancelMatchmaking();
    }

    private void startGameActivity(String roomId) {
        Intent intent = new Intent(SearchingActivity.this, GameActivity.class);
        intent.putExtra("roomId", roomId);
        startActivity(intent);
        finish();
    }
}
