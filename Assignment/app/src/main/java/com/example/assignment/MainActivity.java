package com.example.assignment;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.assignment.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding variableBinding;
    private MainViewModel viewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ImageButton imageButton = findViewById(R.id.imageButton);
        variableBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(variableBinding.getRoot());

        // Initialize ViewModel
        viewModel = new MainViewModel();

        // Set onClickListener for the button using lambda function
        variableBinding.button.setOnClickListener(v -> {
            // Code here executes on the main thread after the user presses the button
            String editString = variableBinding.editTextText.getText().toString();
            variableBinding.textView.setText("Your edited text has: " + editString);
        });

        // Register observer for isSelected MutableLiveData<Boolean>
        viewModel.getIsSelected().observe(this, selected -> {
            // Update the checked state of the buttons
            variableBinding.checkBox.setChecked(selected);
            variableBinding.switch1.setChecked(selected);
            variableBinding.radioButton.setChecked(selected);
        });

        // Set OnCheckedChangeListener for CheckBox using lambda function
        variableBinding.checkBox.setOnCheckedChangeListener((btn, isChecked) ->
                viewModel.getIsSelected().setValue(isChecked));

        // Set OnCheckedChangeListener for Switch using lambda function
        variableBinding.switch1.setOnCheckedChangeListener((btn, isChecked) ->
                viewModel.getIsSelected().setValue(isChecked));

        // Set OnCheckedChangeListener for RadioButton using lambda function
        variableBinding.radioButton.setOnCheckedChangeListener((btn, isChecked) ->
                viewModel.getIsSelected().setValue(isChecked));

        imageButton.setOnClickListener(v -> {
            // Get width and height of the ImageButton
            int width = imageButton.getWidth();
            int height = imageButton.getHeight();

            // Show Toast message with width and height
            Toast.makeText(MainActivity.this, "The width = " + width + " and height = " + height, Toast.LENGTH_SHORT).show();
        });
    }
}