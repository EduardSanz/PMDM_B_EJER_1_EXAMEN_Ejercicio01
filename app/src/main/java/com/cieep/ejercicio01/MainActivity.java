package com.cieep.ejercicio01;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView lblCanalAnterior;
    private TextView lblCanalActual;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lblCanalActual = findViewById(R.id.lblCanalActual);
        lblCanalAnterior = findViewById(R.id.lblCanalAnterior);
        lblCanalAnterior.setText("");
        lblCanalActual.setText("");


    }

    public void cambiarCanal(View view) {
        Button btn = (Button) view;
        lblCanalAnterior.setText(lblCanalActual.getText().toString());
        lblCanalActual.setText(btn.getText().toString());
    }


    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("ACTUAL", lblCanalActual.getText().toString());
        outState.putString("ANTERIOR", lblCanalAnterior.getText().toString());
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        String actual = savedInstanceState.getString("ACTUAL");
        String antorior = savedInstanceState.getString("ANTERIOR");
        lblCanalActual.setText(actual);
        lblCanalAnterior.setText(antorior);
    }
}