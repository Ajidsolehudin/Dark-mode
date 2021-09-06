package com.ajidsolehudin.darkmode;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.appcompat.widget.SwitchCompat;

import android.os.Build;
import android.os.Bundle;
import android.widget.CompoundButton;

public class MainActivity extends AppCompatActivity {
    //1
    public static boolean isNightMode = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //2
        SwitchCompat switchCompat = findViewById(R.id.switch_dark);
        switchCompat.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                isNightMode = isChecked;

                int delayTime =120;

                buttonView.postDelayed(new Runnable() {
                    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
                    @Override
                    public void run() {
                        if (isNightMode){
                            getDelegate().setLocalNightMode(AppCompatDelegate.MODE_NIGHT_YES);

                        } else {
                            getDelegate().setLocalNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                        }
                    }
                }, delayTime);


            }
        });
    }
}