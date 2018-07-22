package com.cryptenet.thanatos.demo_calculator;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Toolbar toolbar;
    private EditText etInput1, etInput2, etSelected;
    private TextView tvResult;
    private Button btn0, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btnAdd, btnSubtract,
            btnMultiply, btnDivide, btnAC;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
    }

    @SuppressLint("ClickableViewAccessibility")
    private void init() {
        viewBinder();

        setSupportActionBar(toolbar);

        etSelected = etInput1;

        etInput1.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                etSelected = etInput1;
                return false;
            }
        });

        etInput2.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                etSelected = etInput2;
                return false;
            }
        });

        btn0.setOnClickListener(this);
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
        btn5.setOnClickListener(this);
        btn6.setOnClickListener(this);
        btn7.setOnClickListener(this);
        btn8.setOnClickListener(this);
        btn9.setOnClickListener(this);
        btnAdd.setOnClickListener(this);
        btnSubtract.setOnClickListener(this);
        btnMultiply.setOnClickListener(this);
        btnDivide.setOnClickListener(this);
        btnAC.setOnClickListener(this);
    }

    private void viewBinder() {
        toolbar = findViewById(R.id.toolbar);

        etInput1 = findViewById(R.id.et_hint_1);
        etInput2 = findViewById(R.id.et_hint_2);

        tvResult = findViewById(R.id.tv_result);

        btn0 = findViewById(R.id.btn_0);
        btn1 = findViewById(R.id.btn_1);
        btn2 = findViewById(R.id.btn_2);
        btn3 = findViewById(R.id.btn_3);
        btn4 = findViewById(R.id.btn_4);
        btn5 = findViewById(R.id.btn_5);
        btn6 = findViewById(R.id.btn_6);
        btn7 = findViewById(R.id.btn_7);
        btn8 = findViewById(R.id.btn_8);
        btn9 = findViewById(R.id.btn_9);
        btnAdd = findViewById(R.id.btn_add);
        btnSubtract = findViewById(R.id.btn_subtract);
        btnMultiply = findViewById(R.id.btn_multiply);
        btnDivide = findViewById(R.id.btn_divide);
        btnAC = findViewById(R.id.btn_ac);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_0:
                etSelected.getText().append("0");
                return;
            case R.id.btn_1:
                etSelected.getText().append("1");
                return;
            case R.id.btn_2:
                etSelected.getText().append("2");
                return;
            case R.id.btn_3:
                etSelected.getText().append("3");
                return;
            case R.id.btn_4:
                etSelected.getText().append("4");
                return;
            case R.id.btn_5:
                etSelected.getText().append("5");
                return;
            case R.id.btn_6:
                etSelected.getText().append("6");
                return;
            case R.id.btn_7:
                etSelected.getText().append("7");
                return;
            case R.id.btn_8:
                etSelected.getText().append("8");
                return;
            case R.id.btn_9:
                etSelected.getText().append("9");
                return;
        }

        if (v.getId() == R.id.btn_ac) {
            etInput1.setText("");
            etInput2.setText("");

            etInput1.requestFocus();
            etInput2.clearFocus();

            etSelected = etInput1;

            tvResult.setText(R.string.tv_result);
            return;
        }

        if (etInput1.getText().toString().length() > 0
                && etInput2.getText().toString().length() > 0) {
            double input1 = Double.parseDouble(etInput1.getText().toString());
            double input2 = Double.parseDouble(etInput2.getText().toString());
            double result = 0;

            switch (v.getId()) {
                case R.id.btn_add:
                    result = input1 + input2;
                    break;
                case R.id.btn_subtract:
                    result = input1 - input2;
                    break;
                case R.id.btn_multiply:
                    result = input1 * input2;
                    break;
                case R.id.btn_divide:
                    result = input1 / input2;
                    break;
            }

            tvResult.setText(String.valueOf(result));
        }
    }
}
