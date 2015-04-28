package com.example.sd.androidclient;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;


public class ControlActivity extends ActionBarActivity {
    Button buttonFwd, buttonBwd;

    public static String address = "";
    public static int port = 0;
    public static String ledState = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_control);

        Intent i = getIntent();
        address = i.getStringExtra("Address");
        port = i.getIntExtra("Port", 8080);
        ledState = "00";

        Log.d("ControlActivity", "Address "+address+" Port "+port);

        // Clock-Wise Button Click
        ((Button) findViewById(R.id.button3)).setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        // PRESSED
                        Log.d("ControlActivity", "Clock-Wise button down");

                        (new MyClientTask(address, port, "00 01 "+ledState)).execute();

                        return true;
                    case MotionEvent.ACTION_UP:
                        // RELEASED
                        Log.d("ControlActivity", "Clock-Wise button up");

                        (new MyClientTask(address, port, "00 00 "+ledState)).execute();

                        return true; // if you want to handle the touch event
                }
                return false;
            }
        });

        // Counter Clock-Wise Button Click
        ((Button) findViewById(R.id.button4)).setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        // PRESSED
                        Log.d("ControlActivity", "Counter Clock-Wise button down");

                        (new MyClientTask(address, port, "00 02 "+ledState)).execute();

                        return true;
                    case MotionEvent.ACTION_UP:
                        // RELEASED
                        Log.d("ControlActivity", "Counter Clock-Wise button up");

                        (new MyClientTask(address, port, "00 00 "+ledState)).execute();

                        return true; // if you want to handle the touch event
                }
                return false;
            }
        });

        // Forward (Shoulder Down) Button Click
        ((Button) findViewById(R.id.button)).setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        // PRESSED
                        Log.d("ControlActivity", "Forward button down");

                        (new MyClientTask(address, port, "80 00 "+ledState)).execute();

                        return true;
                    case MotionEvent.ACTION_UP:
                        // RELEASED
                        Log.d("ControlActivity", "Forward button up");

                        (new MyClientTask(address, port, "00 00 "+ledState)).execute();

                        return true; // if you want to handle the touch event
                }
                return false;
            }
        });

        // Backward (Shoulder Up) Button Click
        ((Button) findViewById(R.id.button2)).setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        // PRESSED
                        Log.d("ControlActivity", "Backward button down");

                        (new MyClientTask(address, port, "40 00 "+ledState)).execute();

                        return true;
                    case MotionEvent.ACTION_UP:
                        // RELEASED
                        Log.d("ControlActivity", "Backward button up");

                        (new MyClientTask(address, port, "00 00 "+ledState)).execute();

                        return true; // if you want to handle the touch event
                }
                return false;
            }
        });


        // Elbow Down Button Click
        ((Button) findViewById(R.id.button5)).setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        // PRESSED
                        Log.d("ControlActivity", "Elbow Down button down");

                        (new MyClientTask(address, port, "20 00 "+ledState)).execute();

                        return true;
                    case MotionEvent.ACTION_UP:
                        // RELEASED
                        Log.d("ControlActivity", "Elbow Down button up");

                        (new MyClientTask(address, port, "00 00 "+ledState)).execute();

                        return true; // if you want to handle the touch event
                }
                return false;
            }
        });

        // Elbow Up Button Click
        ((Button) findViewById(R.id.button6)).setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        // PRESSED
                        Log.d("ControlActivity", "Elbow Up button down");

                        (new MyClientTask(address, port, "10 00 "+ledState)).execute();

                        return true;
                    case MotionEvent.ACTION_UP:
                        // RELEASED
                        Log.d("ControlActivity", "Elbow Up button up");

                        (new MyClientTask(address, port, "00 00 "+ledState)).execute();

                        return true; // if you want to handle the touch event
                }
                return false;
            }
        });

        // Wrist Down Button Click
        ((Button) findViewById(R.id.button8)).setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        // PRESSED
                        Log.d("ControlActivity", "Wrist Down button down");

                        (new MyClientTask(address, port, "08 00 "+ledState)).execute();

                        return true;
                    case MotionEvent.ACTION_UP:
                        // RELEASED
                        Log.d("ControlActivity", "Wrist Down button up");

                        (new MyClientTask(address, port, "00 00 "+ledState)).execute();

                        return true; // if you want to handle the touch event
                }
                return false;
            }
        });

        // Wrist Up Button Click
        ((Button) findViewById(R.id.button7)).setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        // PRESSED
                        Log.d("ControlActivity", "Wrist Up button down");

                        (new MyClientTask(address, port, "04 00 "+ledState)).execute();

                        return true;
                    case MotionEvent.ACTION_UP:
                        // RELEASED
                        Log.d("ControlActivity", "Wrist Up button up");

                        (new MyClientTask(address, port, "00 00 "+ledState)).execute();

                        return true; // if you want to handle the touch event
                }
                return false;
            }
        });

        // OPEN (Grip Open) Button Click
        ((Button) findViewById(R.id.button9)).setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        // PRESSED
                        Log.d("ControlActivity", "Gip Open button down");

                        (new MyClientTask(address, port, "02 00 "+ledState)).execute();

                        return true;
                    case MotionEvent.ACTION_UP:
                        // RELEASED
                        Log.d("ControlActivity", "Grip Open button up");

                        (new MyClientTask(address, port, "00 00 "+ledState)).execute();

                        return true; // if you want to handle the touch event
                }
                return false;
            }
        });

        // Close (Grip Close) Button Click
        ((Button) findViewById(R.id.button10)).setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        // PRESSED
                        Log.d("ControlActivity", "Gip Close button down");

                        (new MyClientTask(address, port, "01 00 "+ledState)).execute();

                        return true;
                    case MotionEvent.ACTION_UP:
                        // RELEASED
                        Log.d("ControlActivity", "Grip Close button up");

                        (new MyClientTask(address, port, "00 00 "+ledState)).execute();

                        return true; // if you want to handle the touch event
                }
                return false;
            }
        });


        // LED Button Click
        ((Button) findViewById(R.id.button11)).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View arg0) {

                Log.d("ControlActivity", "LED button press");

                if (ledState.equals("00")) {
                     //Turn on Led
                     ledState = "01";
                    ((Button) findViewById(R.id.button11)).setText("LED OFF");
                } else {
                    //Turn off Led
                    ledState = "00";
                    ((Button) findViewById(R.id.button11)).setText("LED ON");
                }

                (new MyClientTask(address, port, "00 00 "+ledState)).execute();

            }
        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_control, menu);
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

    public class MyClientTask extends AsyncTask<Void, Void, Void> {

        String dstAddress;
        int dstPort;
        String dstCmd;
        String response;

        MyClientTask(String addr, int port, String cmd) {
            dstAddress = addr;
            dstPort = port;
            dstCmd = cmd;
        }

        @Override
        protected Void doInBackground(Void... arg0) {

            try {
                Socket socket = new Socket(dstAddress, dstPort);
                InputStream inputStream = socket.getInputStream();
                OutputStream outStream = socket.getOutputStream();
                ByteArrayOutputStream byteArrayOutputStream =
                        new ByteArrayOutputStream(1024);
                byte[] buffer = new byte[1024];
                int bytesRead;

                bytesRead = inputStream.read(buffer);
                byteArrayOutputStream.write(buffer, 0, bytesRead);
                Log.d("MainActivity", "Text received = " + byteArrayOutputStream.toString("UTF-8"));

                byte[] buffer2 = dstCmd.getBytes();
                outStream.write(buffer2, 0, dstCmd.length());

                socket.close();
                response = byteArrayOutputStream.toString("UTF-8");

            } catch (Exception e) {
                response = "Can not connect= " + e.getMessage();
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            super.onPostExecute(result);
        }

    }
}
