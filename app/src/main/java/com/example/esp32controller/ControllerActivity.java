package com.example.esp32controller;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class ControllerActivity extends AppCompatActivity {
    public static String address="";
    public static String ip="";
    public static int port=0;
    Button btn_test;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_controller);

        if (getIntent().hasExtra("address")){
            address = getIntent().getStringExtra("address");
            String list[] = address.split(":");
            ip = list[0];
            port = Integer.valueOf(list[1]);
        }

        Toast.makeText(getApplicationContext(), address,
                Toast.LENGTH_LONG).show();

        btn_test = findViewById(R.id.btn_test_id);
        btn_test.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SockedTransfer socket = new SockedTransfer();
                socket.execute();
            }
        });
    }

    public void exit()
    {
        System.exit(0);
    }

    public class SockedTransfer extends AsyncTask<Void,Void,Void>
    {

        Socket socket;

        @Override
        protected Void doInBackground(Void... voids) {
            try {
                InetAddress inet = InetAddress.getByName(ip);
                socket = new java.net.Socket(inet, port);
                DataOutputStream stream =  new DataOutputStream(socket.getOutputStream());
                stream.writeBytes("test");
                stream.close();
                socket.close();

            } catch (UnknownHostException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }
    }

}