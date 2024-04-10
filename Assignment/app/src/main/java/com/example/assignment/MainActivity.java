package com.example.assignment;

import static androidx.constraintlayout.widget.StateSet.TAG;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
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

    Button loginButton;
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        loginButton = findViewById(R.id.loginButton);
        loginButton.setOnClickListener(clk -> {
            Intent nextPage = new Intent(MainActivity.this, SecondActivity.class);
            startActivity(nextPage);
        });

        // Step 2: Add debug messages in all 6 lifecycle functions
        Log.w(TAG, "In onCreate() - Loading Widgets");
    }
    @Override
    protected void onStart() {
        super.onStart();
        Log.w(TAG, "In onStart()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.w(TAG, "In onResume()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.w(TAG, "In onPause()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.w(TAG, "In onStop()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.w(TAG, "In onDestroy()");
    }
}