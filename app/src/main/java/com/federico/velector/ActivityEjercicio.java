package com.federico.velector;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.LayoutAnimationController;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class ActivityEjercicio extends AppCompatActivity {

    private LinearLayout layoutsuperior;
    private FrameLayout layoutprincipal;
    TextView textshow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        this.supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_ejercicio);

        layoutprincipal = (FrameLayout)findViewById(R.id.layout_principal);
        layoutsuperior = (LinearLayout)findViewById(R.id.layout_superior);
        textshow = (TextView)findViewById(R.id.textoshow);

        Toast.makeText(getApplicationContext(),"Toca la pantalla para iniciar",Toast.LENGTH_SHORT).show();

        layoutprincipal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (layoutsuperior.getVisibility() == View.GONE) {
                    animar(true);
                    layoutsuperior.setVisibility(View.VISIBLE);
                }

                else if (layoutsuperior.getVisibility() == View.VISIBLE) {
                    Toast.makeText(getApplicationContext(),"Toca otra vez para pausar",Toast.LENGTH_SHORT).show();
                    animar(false);
                    layoutsuperior.setVisibility(View.GONE);
                }
            }
        });

    }

    private void animar(boolean mostrar)
    {
        AnimationSet set = new AnimationSet(true);
        Animation animation = null;
        if (mostrar) {
            //desde la esquina superior derecha a la superior izquierda (X0,X1,YO,Y1)
            animation = new TranslateAnimation(Animation.RELATIVE_TO_SELF, 1.0f, Animation.RELATIVE_TO_SELF, 0.0f,
                    Animation.RELATIVE_TO_SELF, 0.0f, Animation.RELATIVE_TO_SELF, 0.0f);
        }
        else {
            //desde la esquina superior izquierda a la esquina superior derecha (X0,X1,YO,Y1)
            animation = new TranslateAnimation(Animation.RELATIVE_TO_SELF, 0.0f, Animation.RELATIVE_TO_SELF, 1.0f,
                    Animation.RELATIVE_TO_SELF, 0.0f, Animation.RELATIVE_TO_SELF, 0.0f);
        }
        //duración en milisegundos
        animation.setDuration(500);
        set.addAnimation(animation);
        LayoutAnimationController controller = new LayoutAnimationController(set, 0.25f);

        layoutsuperior.setLayoutAnimation(controller);
        layoutsuperior.startAnimation(animation);
    }

    @Override
    public void onBackPressed() {

        finish();
        Intent intent = new Intent(ActivityEjercicio.this,ActivityAjustes.class);
        intent.addCategory(Intent.CATEGORY_HOME);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);

    }

}
