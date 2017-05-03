package com.federico.velector;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import static com.federico.velector.R.id.content_main;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener,
        Fragment_Inicio.OnFragmentInteractionListener,
        FragmentEstadisticas.OnFragmentInteractionListener,
        Fragment_Beneficios.OnFragmentInteractionListener,
        Fragment_Compartir.OnFragmentInteractionListener{

    private long mLastPress = 0;    // Cuándo se pulsó atrás por última vez
    private long mTimeLimit = 2000; // Límite de tiempo entre pulsaciones, en ms
    boolean fragmentinicio = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        Fragment_Inicio fragment_inicio = new Fragment_Inicio();
        FragmentManager manager = getSupportFragmentManager();
        manager.beginTransaction().
                replace(R.id.content_main, fragment_inicio).commit();
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            if (fragmentinicio) {
                Toast toast = Toast.makeText(getApplicationContext(), R.string.presionaotravezparasalir, Toast.LENGTH_SHORT);
                long currentTime = System.currentTimeMillis();
                if (currentTime - mLastPress > mTimeLimit) {
                    toast.show();
                    mLastPress = currentTime;
                } else {
                    toast.cancel();
                    super.onBackPressed();
                }
            } else{
                Fragment fragment = new Fragment_Inicio();
                getSupportFragmentManager().beginTransaction()
                        .replace(content_main,fragment)
                        .commit();
                getSupportActionBar().setTitle("Inicio");
                fragmentinicio = true;
            }
        }
    }

    /*@Override
    public void onBackPressed() {
        Toast onBackPressedToast = Toast.makeText(this,
                R.string.presionaotravezparasalir, Toast.LENGTH_SHORT);
        long currentTime = System.currentTimeMillis();

        if (currentTime - mLastPress > mTimeLimit) {
            onBackPressedToast.show();
            mLastPress = currentTime;
        } else {
            onBackPressedToast.cancel();
            super.onBackPressed();
        }

    }*/

     /*@Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            if (back_pressed_time + 2000 > System.currentTimeMillis()) {
                SharedPreferences prefs = getSharedPreferences("MisPreferencias", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = prefs.edit();
                if (prefs.getBoolean("SesionActiva", false) == false) {
                    editor.putString("Nombre", "");
                    editor.putString("Correo", "");
                    editor.putString("Contrasena", "");
                    editor.putString("Imagen", "");
                    editor.putInt("Edad", 0);
                    editor.putBoolean("Logeado", false);
                    editor.putBoolean("SesionActiva", false);
                    editor.putBoolean("agregarEventos", false);
                    editor.commit();
                }
                finish();
                super.onBackPressed();
            } else
                Toast.makeText(getBaseContext(), getResources().getString(R.string.presione_salir), Toast.LENGTH_SHORT).show();
            back_pressed_time = System.currentTimeMillis();
        }
    }*/

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        boolean fragmentstep = false;
        Fragment fragment = null;

        if (id == R.id.nav_inicio) {
            fragment = new Fragment_Inicio();
            fragmentstep = true;
            fragmentinicio = true;

        } else if (id == R.id.nav_estadisticas) {
            fragment = new FragmentEstadisticas();
            fragmentstep = true;
            fragmentinicio = false;

        } else if (id == R.id.nav_beneficios) {
            fragment = new Fragment_Beneficios();
            fragmentstep = true;
            fragmentinicio = false;

        } else if (id == R.id.nav_share) {
            fragment = new Fragment_Compartir();
            fragmentstep = true;
            fragmentinicio = false;

        } else if (id == R.id.nav_salir) {
            Intent i = new Intent().setClass(MainActivity.this, ActivityLogin.class);
            startActivity(i);
        }

        if (fragmentstep){
            getSupportFragmentManager().beginTransaction()
                    .replace(content_main,fragment)
                    .commit();
            item.setCheckable(true);
            getSupportActionBar().setTitle(item.getTitle());
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }


    /*@Override
    public void onBackPressed() {
        Toast onBackPressedToast = Toast.makeText(this,
                R.string.presionaotravezparasalir, Toast.LENGTH_SHORT);
        long currentTime = System.currentTimeMillis();

        if (currentTime - mLastPress > mTimeLimit) {
            onBackPressedToast.show();
            mLastPress = currentTime;
        } else {
            onBackPressedToast.cancel();
            super.onBackPressed();
        }

    }*/

    /*@Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            if (back_pressed_time + 2000 > System.currentTimeMillis()) {
                SharedPreferences prefs = getSharedPreferences("MisPreferencias", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = prefs.edit();
                if (prefs.getBoolean("SesionActiva", false) == false) {
                    editor.putString("Nombre", "");
                    editor.putString("Correo", "");
                    editor.putString("Contrasena", "");
                    editor.putString("Imagen", "");
                    editor.putInt("Edad", 0);
                    editor.putBoolean("Logeado", false);
                    editor.putBoolean("SesionActiva", false);
                    editor.putBoolean("agregarEventos", false);
                    editor.commit();
                }
                finish();
                super.onBackPressed();
            } else
                Toast.makeText(getBaseContext(), getResources().getString(R.string.presione_salir), Toast.LENGTH_SHORT).show();
            back_pressed_time = System.currentTimeMillis();
        }
    }*/

}
