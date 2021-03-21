package com.sysionng.number2wordsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Number2WordsActivity extends AppCompatActivity implements View.OnClickListener {
    private  EditText etEnterNumber;
    private  EditText etNumberInWords;
    private Button btnConvert;
    private Button btnClear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_number2words);

        initComponents();
    }

    private void initComponents(){
        etEnterNumber = findViewById(R.id.etEnterNumber);
        etNumberInWords = findViewById(R.id.etNumberInWords);
        btnConvert = findViewById(R.id.btnConvert);
        btnClear = findViewById(R.id.btnClear);

        btnConvert.setOnClickListener(this);
        btnClear.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnConvert:
                String numberInput = etEnterNumber.getText().toString().trim();

                if (Number2WordsUtility.GetNumber(numberInput) == -1) {
                    etNumberInWords.setText("Invalid input entered by user");
                }
                else {
                    Number2Words mNumber2Words = new Number2Words(Number2WordsUtility.GetNumber(numberInput));
                    String mNumberInWords = mNumber2Words.ConvertNumber2Words();
                    String firstLetterCapital = mNumberInWords.substring(0, 1).toUpperCase() + mNumberInWords.substring(1);
                    etNumberInWords.setText(firstLetterCapital);
                }
                break;
            case R.id.btnClear:
                etEnterNumber.setText("");
                etNumberInWords.setText("");
                break;
        }
    }
}//