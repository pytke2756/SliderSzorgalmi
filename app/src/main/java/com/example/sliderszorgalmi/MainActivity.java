package com.example.sliderszorgalmi;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.android.material.slider.Slider;

public class MainActivity extends AppCompatActivity {

    private RelativeLayout rltvLayout;
    private Slider red;
    private Slider green;
    private Slider blue;
    private TextView rgbValue;
    private String redValue;
    private String greenValue;
    private String blueValue;
    private String rgbValueString;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();

        red.addOnChangeListener(new Slider.OnChangeListener() {
            @Override
            public void onValueChange(@NonNull Slider slider, float value, boolean fromUser) {
                redValue = String.valueOf(Math.round(value));
                setTextAndSetBackgroundColor();
            }
        });

        green.addOnChangeListener(new Slider.OnChangeListener() {
            @Override
            public void onValueChange(@NonNull Slider slider, float value, boolean fromUser) {
                greenValue = String.valueOf(Math.round(value));
                setTextAndSetBackgroundColor();
            }
        });

        blue.addOnChangeListener(new Slider.OnChangeListener() {
            @Override
            public void onValueChange(@NonNull Slider slider, float value, boolean fromUser) {
                blueValue = String.valueOf(Math.round(value));
                setTextAndSetBackgroundColor();
            }
        });
    }

    private void init(){
        rltvLayout = findViewById(R.id.rltv_layout);
        red = findViewById(R.id.red);
        green = findViewById(R.id.green);
        blue = findViewById(R.id.blue);
        rgbValue = findViewById(R.id.rgb_value);
        redValue = "0";
        greenValue = "0";
        blueValue = "0";
    }

    private void setTextAndSetBackgroundColor(){
        int redInt = (int)red.getValue();
        int greenInt = (int)green.getValue();
        int blueInt = (int)blue.getValue();
        rgbValueString = String.format("(%s, %s, %s)", redValue, greenValue, blueValue);
        rgbValue.setText(rgbValueString);
        rltvLayout.setBackgroundColor(Color.rgb(redInt, greenInt, blueInt));
        setTextColor(redInt, greenInt, blueInt);
    }
    private void setTextColor(int red, int green, int blue){
        if (red < 125 && green < 125 && blue < 125){
            rgbValue.setTextColor(Color.WHITE);
        }
        else{
            rgbValue.setTextColor(Color.BLACK);
        }
    }
}