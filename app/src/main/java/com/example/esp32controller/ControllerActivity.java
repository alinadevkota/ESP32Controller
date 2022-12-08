package com.example.esp32controller;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

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
    public static String message="";

    Button btn_up, btn_down, btn_left, btn_right, btn_stop, fist_open, fist_close;
    Button wrist_up, wrist_down, arm_up, arm_down, elbow_up, elbow_down, base_cw, base_acw;
    TextView tv_address;

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

        tv_address = findViewById(R.id.address_id);

        btn_up = findViewById(R.id.btop_id);
        btn_down = findViewById(R.id.bbottom_id);
        btn_left = findViewById(R.id.bleft_id);
        btn_right = findViewById(R.id.bright_id);
        btn_stop = findViewById(R.id.bstop_id);

        fist_open = findViewById(R.id.f_open_id);
        fist_close = findViewById(R.id.f_close_id);
        wrist_up = findViewById(R.id.w_up_id);
        wrist_down = findViewById(R.id.w_down_id);
        arm_up = findViewById(R.id.a_up_id);
        arm_down = findViewById(R.id.a_down_id);
        elbow_up = findViewById(R.id.e_up_id);
        elbow_down = findViewById(R.id.e_down_id);
        base_cw = findViewById(R.id.b_cw_id);
        base_acw = findViewById(R.id.b_acw_id);

        tv_address.setText(address);

        btn_up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                message = "g";
                SockedTransfer socket = new SockedTransfer();
                socket.execute();
            }
        });

        btn_down.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                message = "b";
                SockedTransfer socket = new SockedTransfer();
                socket.execute();
            }
        });

        btn_left.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                message = "l";
                SockedTransfer socket = new SockedTransfer();
                socket.execute();
            }
        });

        btn_right.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                message = "r";
                SockedTransfer socket = new SockedTransfer();
                socket.execute();
            }
        });

        btn_stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                message = "s";
                SockedTransfer socket = new SockedTransfer();
                socket.execute();
            }
        });

        fist_open.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                message = "o";
                SockedTransfer socket = new SockedTransfer();
                socket.execute();
            }
        });

        fist_close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                message = "c";
                SockedTransfer socket = new SockedTransfer();
                socket.execute();
            }
        });

        wrist_up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                message = "0";
                SockedTransfer socket = new SockedTransfer();
                socket.execute();
            }
        });

        wrist_down.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                message = "1";
                SockedTransfer socket = new SockedTransfer();
                socket.execute();
            }
        });

        arm_up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                message = "2";
                SockedTransfer socket = new SockedTransfer();
                socket.execute();
            }
        });

        arm_down.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                message = "3";
                SockedTransfer socket = new SockedTransfer();
                socket.execute();
            }
        });

        elbow_up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                message = "4";
                SockedTransfer socket = new SockedTransfer();
                socket.execute();
            }
        });

        elbow_down.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                message = "5";
                SockedTransfer socket = new SockedTransfer();
                socket.execute();
            }
        });

        base_cw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                message = "6";
                SockedTransfer socket = new SockedTransfer();
                socket.execute();
            }
        });

        base_acw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                message = "7";
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
                stream.writeBytes(message);
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