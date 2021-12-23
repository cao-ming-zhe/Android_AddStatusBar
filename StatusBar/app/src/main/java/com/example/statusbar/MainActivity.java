package com.example.statusbar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.hardware.input.InputManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       Button btn = (Button) this.getDelegate().findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_SCREEN_MODE_CHANGED);
                intent.putExtra(InputManager.ACTION_CURRENT_SCREEN_MODE_CHANGED, InputManager.SCREEN_HB_MODE);
                sendBroadcast(intent);
            }
        });

        Button btn1 = (Button) this.getDelegate().findViewById(R.id.button2);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_SCREEN_MODE_CHANGED);
                intent.putExtra(InputManager.ACTION_CURRENT_SCREEN_MODE_CHANGED, InputManager.SCREEN_TI_MODE);
                sendBroadcast(intent);
            }
        });
    }
}