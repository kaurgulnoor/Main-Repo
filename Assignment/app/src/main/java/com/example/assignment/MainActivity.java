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
import androidx.lifecycle.MutableLiveData;

import com.example.assignment.databinding.ActivityMainBinding;


/**
 * @author kaurgulnoor
 *
 */
public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding variableBinding;
    /**
     * This hold the text at the center of the field
     */
    TextView myText = null;
    /**
     * This holds the text field at the center of the screen where the password is to be inputed
     */
    EditText et = null;
    Button btn = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        variableBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(variableBinding.getRoot());

        MutableLiveData<Boolean> isSelected = new MutableLiveData<>();

        myText = findViewById(R.id.textView3);
        et = findViewById(R.id.editTextNumberPassword);
        btn = findViewById(R.id.button);

        btn.setOnClickListener( clk -> {
            String password = et.getText().toString();
            checkPasswordComplexity(password);
        });
    }

    /**
     *This method checks to see of the password meets all the conditions
     * by checking each character in the inputed password
     * @param pw is the string to be checked
     *           returns true if all conditions are met
     */
    public boolean checkPasswordComplexity(String pw){
        boolean foundUpperCase, foundLowerCase, foundNumber, foundSpecial;
        foundUpperCase = foundLowerCase = foundNumber = foundSpecial = false;
        for (int i = 0; i < pw.length(); i++) {
            char c = pw.charAt(i);

            if (Character.isUpperCase(c)) {
                foundUpperCase = true;
            } else if (Character.isLowerCase(c)) {
                foundLowerCase = true;
            } else if (Character.isDigit(c)) {
                foundNumber = true;
            } else if (isSpecialCharacter(c)) {
                foundSpecial = true;
            }
        }
        int duration = Toast.LENGTH_SHORT;
        if (!foundUpperCase) {
            Toast.makeText( getApplicationContext(), "Your password is missing an uppercase letter!", Toast.LENGTH_SHORT).show();
            return false;
        } else if (!foundLowerCase) {
            Toast.makeText(getApplicationContext(), "Your password is missing a lowercase letter!", Toast.LENGTH_SHORT).show();
            return false;
        } else if (!foundNumber) {
            Toast.makeText( getApplicationContext(), "Your password is missing a Number!", Toast.LENGTH_SHORT).show();
            return false;
        } else if (!foundSpecial) {
            Toast.makeText( getApplicationContext(), "Your password is missing a special character!", Toast.LENGTH_SHORT).show();
            return false;
        } else {
            return true;
        }
    }

    /**
     * Checks if the character is a special character.
     *
     * @param c The character to be checked.
     * @return  true if the character is one of &#35;&#36;&#37;&#94;&amp;*!&#64;?, false otherwise.
     */
    public static boolean isSpecialCharacter(char c){
        switch(c){
            case '#':
            case '$':
            case '%':
            case '^':
            case '&':
            case '*':
            case '!':
            case '@':
            case '?':
                return true;
            default:
                return false;
        }
    }
}