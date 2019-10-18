package com.example.task4;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends Activity {
    private ImageView image1;
    private ImageView image2;
    private SeekBar seekBar;
    private long duration;
    private TextView animDuration;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        animDuration = (TextView) findViewById(R.id.animDur);
        seekBar = (SeekBar) findViewById(R.id.duration);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                animDuration.setText(Double.valueOf(progress)/1000 +"seconds" );
                duration = progress;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    public void acyncAnim(View view) {
        image1 = findViewById(R.id.image1);
        image2 = findViewById(R.id.image2);
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.animation);
        animation.setDuration(duration);
        image1.startAnimation(animation);

    }

    public void syncAnim(View view) {
        image1 = findViewById(R.id.image1);
        image2 = findViewById(R.id.image2);
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.animation);
        animation.setDuration(duration);
        image1.startAnimation(animation);
        image2.startAnimation(animation);
    }
}
