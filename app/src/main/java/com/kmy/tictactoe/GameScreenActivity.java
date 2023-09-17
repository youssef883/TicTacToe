package com.kmy.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class GameScreenActivity extends AppCompatActivity {

    TicTacToeBoard ticTacToeBoard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_screen);

        Button playAgainBTN = findViewById(R.id.activity_game_screen_play_again_btn);
        Button homeBTN = findViewById(R.id.activity_game_screen_home_btn);
        TextView playerTurn = findViewById(R.id.activity_game_screen_player_name_tv);

        playAgainBTN.setVisibility(View.GONE);
        homeBTN.setVisibility(View.GONE);

        String[] playerNames = getIntent().getStringArrayExtra("Player_Names");

        if(playerNames != null)
        {
            playerTurn.setText((playerNames[0]+"'s Turn"));
        }

        ticTacToeBoard = findViewById(R.id.ticTacToeBoard);

        ticTacToeBoard.setUpGame(playAgainBTN,homeBTN,playerTurn,playerNames);
    }

    public void playAgainBTN(View view)
    {
        ticTacToeBoard.resetGame();
        ticTacToeBoard.invalidate();
    }

    public void homeBTN(View view)
    {
        Intent intent = new Intent(this, HomeActivity.class);
        startActivity(intent);
    }
}