package com.example.mylaba1;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

    private EditText editNumber;
    Button myButton;
    TextView myTextView;
    ImageView myImage;

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editNumber = (EditText) findViewById(R.id.editNumber);
        myButton = (Button) findViewById(R.id.buttoninfo);
        myTextView = (TextView) findViewById(R.id.textinfo);
        myImage = (ImageView) findViewById(R.id.imagekari);

        /*myButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myTextView.setText("СКОРОБАГАТЬКО КАРИНА ОЛЕКСАНДРІВНА\n" + "ФАКУЛЬТЕТ КІБЕРНЕТИКИ\n" + "3 КУРС\n" + "ГРУПА ТТП-3\n");
            }\
        });*/

        myButton.setOnTouchListener(new View.OnTouchListener() {

            @SuppressLint("ResourceType")
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN: myTextView.setText("СКОРОБАГАТЬКО КАРИНА ОЛЕКСАНДРІВНА\n" + "ФАКУЛЬТЕТ КІБЕРНЕТИКИ\n" + "3 КУРС\n" + "ГРУПА ТТП-3\n");
                    myImage.setImageResource(R.drawable.kari);
                    myImage.invalidate();
                    break;
                    case MotionEvent.ACTION_UP: myTextView.setText("***");
                    myImage.setImageResource(R.id.imagekari);
                    break;
                }
                return false;
            }
        });

    }

    public void sendData(View view){
        Intent intent = new Intent(this, LastActivity.class);
        intent.putExtra("number", editNumber.getText().toString());
        startActivity(intent);
    }

}