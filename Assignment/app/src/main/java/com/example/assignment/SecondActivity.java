package com.example.assignment;


import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class SecondActivity extends AppCompatActivity {

    private static final String TAG = "SecondActivity";
    private EditText phoneNumberEditText;
    private SharedPreferences sharedPreferences;
    private ImageView imageView;
    private static final String FILENAME = "flag.png";
    private static final String PREFS_NAME = "MyData";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        phoneNumberEditText = findViewById(R.id.editTextPhone);
        imageView = findViewById(R.id.imageView2);

        // Load the saved phone number, if any
        SharedPreferences prefs = getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        String savedPhoneNumber = prefs.getString("PhoneNumber", "");
        phoneNumberEditText.setText(savedPhoneNumber);

        // Check if the picture file exists, and if so, load it into the ImageView
        File pictureFile = new File(getFilesDir(), FILENAME);
        if (pictureFile.exists()) {
            Bitmap bitmap = loadImageFromStorage(pictureFile.getAbsolutePath());
            imageView.setImageBitmap(bitmap);
        }
    }
    @Override
    protected void onPause() {
        super.onPause();
        // Save the value of the phone number currently entered in the EditText using SharedPreferences
        String phoneNumber = phoneNumberEditText.getText().toString();

        // Verify phone number format (for example: 10 digits)
        if (phoneNumber.length() != 10) {
            Log.e(TAG, "Invalid phone number format: " + phoneNumber);
            Toast.makeText(this, "Invalid phone number format", Toast.LENGTH_SHORT).show();
            return;
        }

        // Save the phone number to SharedPreferences
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("PhoneNumber", phoneNumber);
        editor.apply();
        Log.d(TAG, "Phone number saved to SharedPreferences: " + phoneNumber);
    }
    private Bitmap loadImageFromStorage(String path) {
        try {
            File file = new File(path);
            return BitmapFactory.decodeStream(new FileInputStream(file));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    // Method to save the bitmap to internal storage
    private void saveBitmapToStorage(Bitmap bitmap) {
        FileOutputStream fOut = null;
        try {
            fOut = openFileOutput(FILENAME, Context.MODE_PRIVATE);
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, fOut);
            fOut.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fOut != null) {
                try {
                    fOut.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}