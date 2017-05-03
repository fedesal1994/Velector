package com.federico.velector;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

public class ActivityLogin extends AppCompatActivity {

    ImageView fbbutton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.activity_login);

        fbbutton = (ImageView)findViewById(R.id.fbbutton);

        fbbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent().setClass(ActivityLogin.this, MainActivity.class);
                startActivity(i);

            }
        });
    }

    @Override
    public void onBackPressed() {

        Toast.makeText(getApplicationContext(),"Adios, vuelve pronto :)",Toast.LENGTH_SHORT).show();
        finish();
        Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_HOME);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);

    }
}
