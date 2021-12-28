package com.example.statusbar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.hardware.input.InputManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private int userLevel = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       Button btn = (Button) this.getDelegate().findViewById(R.id.hbButton);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_SCREEN_MODE_CHANGED);
                intent.putExtra(InputManager.ACTION_CURRENT_SCREEN_MODE_CHANGED, InputManager.SCREEN_HB_MODE);
                sendBroadcast(intent);
            }
        });

        Button tiBtn = (Button) this.getDelegate().findViewById(R.id.tiButton);
        tiBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_SCREEN_MODE_CHANGED);
                intent.putExtra(InputManager.ACTION_CURRENT_SCREEN_MODE_CHANGED, InputManager.SCREEN_TI_MODE);
                sendBroadcast(intent);
            }
        });


        Button userBtn = (Button) this.getDelegate().findViewById(R.id.userButton);
        userBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent("android.intent.action.USER_CHANGE");
                intent.putExtra("android.intent.CURRENT_USER_LEVEL_CHANGED", userLevel);
                switch (userLevel){
                    case 0:
                        intent.putExtra("android.intent.CURRENT_USER_NAME_CHANGED", "danisc1111111111111333321211111111111111111111111");
                        intent.putExtra("android.intent.CURRENT_USER_VISIBILITY_CHANGED", View.VISIBLE);
                        break;
                    case 1:
                        intent.putExtra("android.intent.CURRENT_USER_NAME_CHANGED", "OPER");
                        intent.putExtra("android.intent.CURRENT_USER_VISIBILITY_CHANGED", View.VISIBLE);
                        break;
                    case 2:
                        intent.putExtra("android.intent.CURRENT_USER_NAME_CHANGED", "LUCY");
                        intent.putExtra("android.intent.CURRENT_USER_VISIBILITY_CHANGED", View.VISIBLE);
                        break;
                    case 3:
                        intent.putExtra("android.intent.CURRENT_USER_NAME_CHANGED", "LUCY");
                        intent.putExtra("android.intent.CURRENT_USER_VISIBILITY_CHANGED", View.INVISIBLE);
                        break;
                }

                userLevel++;
                if(userLevel > 3)
                    userLevel = 0;

                sendBroadcast(intent);
            }
        });
    }
}