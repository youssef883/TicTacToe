package com.kmy.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class PlayerSetupActivity extends AppCompatActivity {

    private EditText player1 ,player2 ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player_setup);

        player1 = findViewById(R.id.activity_player_submit_edit_txt_payer_1);
        player2 = findViewById(R.id.activity_player_submit_edit_txt_payer_2);
    }

    public void startGameBTN(View view)
    {
        String  p1 = player1.getText().toString();
        String  p2 = player2.getText().toString();

        if(!p1.isEmpty()&& !p2.isEmpty())
        {
            Intent intent = new Intent(this, GameScreenActivity.class);
            intent.putExtra("Player_Names",new String[]{p1,p2});
            startActivity(intent);
        }
        else if(p1.isEmpty())
        {
            if(p2.isEmpty())
            {
                Toast.makeText(PlayerSetupActivity.this,"Two player Name is required",Toast.LENGTH_LONG).show();
            }
            else
            {
                Toast.makeText(PlayerSetupActivity.this,"First player Name is required",Toast.LENGTH_LONG).show();
            }
        }
        else
        {
            Toast.makeText(PlayerSetupActivity.this,"Second player Name is required",Toast.LENGTH_LONG).show();
        }

    }

}