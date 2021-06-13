package com.example.flightgearandroidapp.views;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.MotionEvent;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.Toast;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.view.View.OnTouchListener;
import android.widget.ImageView;
import android.widget.RelativeLayout;


import com.example.flightgearandroidapp.R;
import com.example.flightgearandroidapp.model.FGPlayer;
import com.example.flightgearandroidapp.view_model.ViewModel;
import java.util.function.Predicate;

public class MainActivity extends AppCompatActivity {

    private TextView ruddertextView, throttleTextView;
    private double rudderProgress, throttleProgress;
    private SeekBar rudderSeekBar, throttleSeekBar;
    private EditText IPEditText, portEditText;
    private Button startButton;
    private JoystickView js;
    private ViewModel vm;



    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        ruddertextView = (TextView) findViewById(R.id.RuddertextView);
        rudderSeekBar = (SeekBar) findViewById(R.id.RudderSeekBar);

        rudderSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                rudderProgress = ((((((float)progress+1)*2)/100)-1) - 0.02);
                if ((float) Math.round(rudderProgress * 100) / 100 == 0.0){
                    rudderProgress = 0;
                }
                else if (((float) Math.round(rudderProgress * 100) / 100) == -1.0){
                    rudderProgress = -1;
                }
                else if (((float) Math.round(rudderProgress * 100) / 100) == 1.0){
                    rudderProgress = 1;
                }
                ruddertextView.setText("" + String.format("%.2f", rudderProgress)  + "");
                if (rudderProgress < 0d){
                    ruddertextView.setTextColor(Color.RED);
                }
                else if (rudderProgress > 0d){
                    ruddertextView.setTextColor(Color.BLUE);
                }
                ruddertextView.setTextSize(29);
                vm.setRudder(rudderProgress);
            }


            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                ruddertextView.setTextColor(Color.BLACK);
                ruddertextView.setTextSize(25);
            }
        });


        throttleTextView = (TextView) findViewById(R.id.ThrottleTextView);
        throttleSeekBar = (SeekBar) findViewById(R.id.ThrottleSeekBar);

        throttleSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                throttleProgress = ((((float)progress+1)/100) - 0.01);

                if ((float) Math.round(throttleProgress * 100) / 100 == 0.0){
                    throttleProgress = 0;
                }
                else if (((float) Math.round(throttleProgress * 100) / 100) == 1.0){
                    throttleProgress = 1;
                }
                throttleTextView.setText("" + String.format("%.2f", throttleProgress) + "");
                throttleTextView.setTextColor(Color.BLUE);
                throttleTextView.setTextSize(29);
                vm.setThrottle(throttleProgress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                throttleTextView.setTextColor(Color.BLACK);
                throttleTextView.setTextSize(25);
            }
        });

        addListenerOnButton();
        initJoystick();
    }



    public void addListenerOnButton() {
        IPEditText = (EditText) findViewById(R.id.editText1);
        portEditText = (EditText) findViewById(R.id.editText2);
        startButton = (Button) findViewById(R.id.button);

        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String ip =IPEditText.getText().toString();
                String value2=portEditText.getText().toString();
                int port=Integer.parseInt(value2);
                vm = new ViewModel(ip, port);
            }
        });
    }

    public void initJoystick() {
        this.js = (JoystickView) findViewById(R.id.myJoystick);
        this.js.onChange = (a,e)->{
            vm.setAileron(a);
            vm.setElevator(e);
        };
    }

}