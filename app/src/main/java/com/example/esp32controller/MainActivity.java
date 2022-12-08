package com.example.esp32controller;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    Button btn_connect, btn_exit;
    EditText et_ip_addr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_connect =findViewById(R.id.btn_connect_id);
        btn_exit = findViewById(R.id.btn_exit_id);
        et_ip_addr = findViewById(R.id.ip_addr_id);

        btn_exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            finish();
            }
        });

        btn_connect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String address = et_ip_addr.getText().toString();
                Intent i = new Intent(getApplicationContext(), ControllerActivity.class);
                i.putExtra("address", address);
                startActivity(i);
            }
        });
    }
}