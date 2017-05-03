package com.federico.velector;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class ActivityAjustes extends AppCompatActivity {

    Button textos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.activity_ajustes);

        textos = (Button)findViewById(R.id.biniciar_ajustes);

        textos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(ActivityAjustes.this,ActivityEjercicio.class);
                startActivity(intent);

            }
        });
    }

    @Override
    public void onBackPressed() {

        finish();
        Intent intent = new Intent(ActivityAjustes.this,ActivityTextos.class);
        intent.addCategory(Intent.CATEGORY_HOME);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);

    }
}
