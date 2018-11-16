package com.sdmga.iiuc.rockpaperscissorsgame;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class game extends AppCompatActivity {

    Button b_paper, b_rock, b_scissors;
    ImageView i_computerchoice, i_humanchoice;
    TextView tv_score;

    int HumanScore,ComputerScore=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        b_paper = findViewById(R.id.paper);
        b_rock = findViewById(R.id.rock);
        b_scissors = findViewById(R.id.scissors);

        i_computerchoice = findViewById(R.id.computerchoice);
        i_humanchoice = findViewById(R.id.humanchoice);

        tv_score = (TextView) findViewById(R.id.score);

        b_paper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i_humanchoice.setImageResource(R.drawable.hh);
                String message=play_turn("paper");
                Toast.makeText(game.this,message,Toast.LENGTH_SHORT).show();
                tv_score.setText("Score Human: " + Integer.toString(HumanScore) + " Computer: " + Integer.toString(ComputerScore));
            }
        });
        b_rock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i_humanchoice.setImageResource(R.drawable.gg);
                String message= play_turn("rock");
                Toast.makeText(game.this,message,Toast.LENGTH_SHORT).show();
                tv_score.setText("Score Human: " + Integer.toString(HumanScore) + " Computer: " + Integer.toString(ComputerScore));

            }
        });

        b_scissors.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i_humanchoice.setImageResource(R.drawable.ee);
                String message= play_turn("scissors");
                Toast.makeText(game.this,message,Toast.LENGTH_SHORT).show();
                tv_score.setText("Score Human: " + Integer.toString(HumanScore) + " Computer: " + Integer.toString(ComputerScore));
            }
        });
    }

    public String play_turn(String player_choice) {
        String computer_choice = "";
        Random r = new Random();
        int computer_choice_number = r.nextInt(3) + 1;

        if (computer_choice_number == 1) {

            computer_choice = "rock";
        } else if (computer_choice_number == 2) {

            computer_choice = "scissors";

        } else if (computer_choice_number == 3) {

            computer_choice = "paper";
        }
        if (computer_choice == "rock") {
            i_computerchoice.setImageResource(R.drawable.gg);
        } else if (computer_choice == "scissors") {
            i_computerchoice.setImageResource(R.drawable.ee);
        } else if (computer_choice == "paper") {
            i_computerchoice.setImageResource(R.drawable.hh);
        }
        if(computer_choice==player_choice) {
            return "Draw! Nobody Won.";
        }
        else if(player_choice=="rock" && computer_choice=="scissors"){
            HumanScore++;
            return "Rock crushes scissors.You win!";
        }
        else if(player_choice=="rock" && computer_choice=="paper"){
            ComputerScore++;
            return "Paper covers rock.Computer win!";
        }
        else if(player_choice=="scissors" && computer_choice=="rock"){
            ComputerScore++;
            return "Rock crushes scissors.Computer win!";
        }
        else if(player_choice=="scissors" && computer_choice=="paper") {
            HumanScore++;
            return "Scissors cuts paper.You win!";
        }
        else if(player_choice=="paper" && computer_choice=="rock") {
            HumanScore++;
            return "Paper covers rock.You win!";
        }
        else if(player_choice=="paper" && computer_choice=="scissors") {
            ComputerScore++;
            return "Scissors cuts paper.Computer win!";
        }
        else return "Not sure";
    }
}