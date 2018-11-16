package com.sdmga.iiuc.rockpaperscissorsgame;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button btn;
    Button btn1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn=(Button)findViewById(R.id.b1);
        btn1=(Button)findViewById(R.id.b2);


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent54 = new Intent( getApplicationContext() , menuebar.class);
                startActivity(intent54);
            }
        });

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent54 = new Intent( getApplicationContext() , game.class);
                startActivity(intent54);
            }
        });


    }
}
