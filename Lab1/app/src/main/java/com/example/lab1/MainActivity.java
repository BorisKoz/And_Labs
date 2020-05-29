package com.example.lab1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

        private TextView TopBox, GreetingBox, DateBox;
        private EditText FirstNameBox, SecondNameBox,BirthDateBox;
        @Override
        protected void onCreate(Bundle savedInstanceState){
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            GreetingBox =findViewById(R.id.Greeting);
            TopBox =findViewById(R.id.textTop);
            DateBox =findViewById(R.id.textDate);
            FirstNameBox =findViewById(R.id.FirstNameBox);
            SecondNameBox =findViewById(R.id.LastNameBox);
            BirthDateBox=findViewById(R.id.BirthDateBox);
            final View btn1;
            final View btn2;
            btn1=findViewById(R.id.btn_1);
            btn2=findViewById(R.id.btn_2);
            btn1.setOnClickListener(this);
            btn2.setOnClickListener(this);
        }
        @Override
        public void onClick(View v) {
            switch(v.getId()){
                case R.id.btn_1:
                    GenerateGreeting();
                    break;
                case R.id.btn_2:
                    GenerateDate();
                    break;
            }
        }

    private void GenerateGreeting() {
        String msg=getString(R.string.user,
                FirstNameBox.getText().toString(),
                SecondNameBox.getText().toString());
        GreetingBox.setText(msg);
    }
        private void GenerateDate() {
            String msg = getString(R.string.date,
                    BirthDateBox.getText().toString());
            DateBox.setText(msg);
        }



}