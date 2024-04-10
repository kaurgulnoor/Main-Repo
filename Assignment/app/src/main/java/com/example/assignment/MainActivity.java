package com.example.assignment;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;


public class MainActivity extends AppCompatActivity {

    private Button button;
    private Button button2;
    private Switch switch1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        button = findViewById(R.id.button);
        button2 = findViewById(R.id.button2);
        switch1 = findViewById(R.id.switch1);

        // Set initial focus
        button.requestFocus();
    }
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        switch (keyCode) {
            case KeyEvent.KEYCODE_DPAD_DOWN:
                // If button has focus, focus on switch
                if (button.hasFocus()) {
                    switch1.requestFocus();
                    return true;
                }
                break;
            case KeyEvent.KEYCODE_DPAD_RIGHT:
                // If button has focus, focus on button2
                if (button.hasFocus()) {
                    button2.requestFocus();
                    return true;
                }
                break;
            case KeyEvent.KEYCODE_DPAD_LEFT:
                // If button2 has focus, focus on button
                if (button2.hasFocus()) {
                    button.requestFocus();
                    return true;
                }
                break;
        }
        return super.onKeyDown(keyCode, event);
    }
}