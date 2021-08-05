package com.example.calculatorgeek;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button btnOpen;
    private TextView tvResult;
    private Integer firstValue, secondValue;
    private String operation;
    private Boolean isResultSuccess = false;
    private String text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvResult = findViewById(R.id.tv_result);
        btnOpen = findViewById(R.id.btn_open);
        text = tvResult.getText().toString();
        Toast.makeText(this,text,Toast.LENGTH_SHORT).show();
        if (text.equals("0")){
            btnOpen.setVisibility(View.INVISIBLE);
        }

        btnOpen = findViewById(R.id.btn_open);
        openAc();

    }




    private void openAc() {
        btnOpen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,
                        ResultActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
                intent.putExtra("tvResult", text);
                startActivity(intent);
            }
        });
    }

    public void onClickNumber(View view) {
        switch (view.getId()) {
            case R.id.btn_one:
                if (isResultSuccess) {
                    tvResult.setText("");
                    isResultSuccess = false;
                }
                if (tvResult.getText().toString().equals("0")) {
                    tvResult.setText("1");
                } else {
                    tvResult.append("1");
                }
                break;

            case R.id.btn_two:
                if (isResultSuccess) {
                    tvResult.setText("");
                    isResultSuccess = false;
                }
                if (tvResult.getText().equals("0")) {
                    tvResult.setText("2");
                } else {
                    tvResult.append("2");
                }
                break;

            case R.id.btn_three:
                if (tvResult.getText().toString().equals("0")) {
                    tvResult.setText("3");
                } else {
                    tvResult.append("3");
                }
                break;

            case R.id.btn_four:
                if (tvResult.getText().toString().equals("0")) {
                    tvResult.setText("4");
                } else {
                    tvResult.append("4");
                }
                break;

            case R.id.btn_five:
                if (tvResult.getText().toString().equals("0")) {
                    tvResult.setText("5");
                } else {
                    tvResult.append("5");
                }
                break;

            case R.id.btn_six:
                if (tvResult.getText().toString().equals("0")) {
                    tvResult.setText("6");
                } else {
                    tvResult.append("6");
                }
                break;

            case R.id.btn_seven:
                if (tvResult.getText().toString().equals("0")) {
                    tvResult.setText("7");
                } else {
                    tvResult.append("7");
                }
                break;

            case R.id.btn_eight:
                if (tvResult.getText().toString().equals("0")) {
                    tvResult.setText("8");
                } else {
                    tvResult.append("8");
                }
                break;
            case R.id.btn_nine:
                if (tvResult.getText().toString().equals("0")) {
                    tvResult.setText("9");
                } else {
                    tvResult.append("9");
                }
                break;
            case R.id.btn_zero:
                if (tvResult.getText().toString().equals("0")) {
                    tvResult.setText("0");
                } else {
                    tvResult.append("0");
                }
                break;

            case R.id.btn_clear:
                tvResult.setText("0");
                btnOpen.setVisibility(View.INVISIBLE);
                break;
        }
    }

    public void onClickOperation(View view) {
        switch (view.getId()) {
            case R.id.btn_plus:
                firstValue = Integer.parseInt(tvResult.getText().toString());
                tvResult.setText(firstValue + "+");
                operation = "+";
                break;
            case R.id.btn_minus:
                firstValue = Integer.parseInt(tvResult.getText().toString());
                tvResult.setText(firstValue + "-");
                operation = "-";
                break;
            case R.id.btn_multiply:
                firstValue = Integer.parseInt(tvResult.getText().toString());
                tvResult.setText(firstValue + "×");
                operation = "×";
                break;
            case R.id.btn_divide:
                firstValue = Integer.parseInt(tvResult.getText().toString());
                tvResult.setText(firstValue + "÷");
                operation = "÷";
                break;
            case R.id.btn_equal:
                secondValue = Integer.parseInt(tvResult.getText().toString()
                        .replace(firstValue + operation, ""));
                switch (operation) {
                    case "+":
                        tvResult.setText(firstValue + operation + secondValue + "\n=" + (firstValue + secondValue));
                        break;
                    case "-":
                        tvResult.setText(firstValue + operation + secondValue + "\n=" + (firstValue - secondValue));
                        break;
                    case "×":
                        tvResult.setText(firstValue + operation + secondValue + "\n=" + (firstValue * secondValue));
                        break;
                    case "÷":
                        tvResult.setText(firstValue + operation + secondValue + "\n=" + (firstValue / secondValue));
                        break;
                }
                btnOpen.setVisibility(View.VISIBLE);
                text = tvResult.getText().toString();

        }
    }
}