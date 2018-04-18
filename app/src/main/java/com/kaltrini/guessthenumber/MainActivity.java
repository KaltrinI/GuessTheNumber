package com.kaltrini.guessthenumber;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText nr;
    LinearLayout sr;
    TextView txtFix;
    TextView txtGuess;
    Button btnGuess;
    Game game;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nr=findViewById(R.id.editNumber);
        sr=findViewById(R.id.lista);
        txtFix=findViewById(R.id.fixed);
        txtGuess=findViewById(R.id.guessed);
        game=new Game();
        btnGuess=findViewById(R.id.btnGuess);

        btnGuess.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String nmb=nr.getText().toString();
                if (nmb.length()!=3)
                {
                    Toast.makeText(MainActivity.this,"The input should consist of 3 digits",Toast.LENGTH_LONG).show();
                    return ;
                }

                Check(nmb);

            }
        });

    }


    public void Check(String number){

        int fix=0;
        int guess=0;
        //first
        if (game.getComb().charAt(0) == number.charAt(0))
            fix++;

        if (game.getComb().charAt(0) == number.charAt(1)||game.getComb().charAt(0) == number.charAt(2))
            guess++;


        //second
        if (game.getComb().charAt(1) == number.charAt(1))
            fix++;

        if (game.getComb().charAt(1) == number.charAt(0)||game.getComb().charAt(1) == number.charAt(2))
            guess++;

        //third
        if (game.getComb().charAt(2) == number.charAt(2))
            fix++;

        if (game.getComb().charAt(2) == number.charAt(1)||game.getComb().charAt(2) == number.charAt(0))
            guess++;


        if (fix == 3) {
           Toast.makeText(MainActivity.this,"Congratulations ! New Game has begun",Toast.LENGTH_LONG).show();
           sr.removeAllViews();
           txtFix.setText("");
           txtGuess.setText("");
           game.NewGame();
        }
        else
        {
            txtFix.setText(String.format("%d fixed",fix));
            txtGuess.setText(String.format("%d guessed",guess));

            TextView tr=new TextView(this);
            tr.setTextSize(30);
            tr.setText(number);
            sr.addView(tr);
        }


    }
}
