package com.codebaik.easycalculator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    int intResult;
    String valueString1, valueString2;
    double[] doubleResult = new double[10];
    String operator;
    Button btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btn0, btnPlus, btnSub, btnTime, btnDiv, btnResult, btnClear;
    TextView tvInput, tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // initiate
        valueString1 = "";
        valueString2 = "";

// assign
        btn0 = findViewById(R.id.btn0);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btn5 = findViewById(R.id.btn5);
        btn6 = findViewById(R.id.btn6);
        btn7 = findViewById(R.id.btn7);
        btn8 = findViewById(R.id.btn8);
        btn9 = findViewById(R.id.btn9);
        btnPlus = findViewById(R.id.btnPlus);
        btnSub = findViewById(R.id.btnSub);
        btnTime = findViewById(R.id.btnTime);
        btnDiv = findViewById(R.id.btnDiv);
        btnResult = findViewById(R.id.btnResult);
        btnClear = findViewById(R.id.btnClear);
        tvInput = findViewById(R.id.tvInput);
        tvResult = findViewById(R.id.tvResult);

//        onClickListener
        btn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!tvInput.getText().equals("0") && !tvInput.getText().equals("")) {
                    addValue("0");
                    tvInput.append("0");
                }
            }
        });

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addValue("1");
                tvInput.append("1");
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addValue("2");
                tvInput.append("2");
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addValue("3");
                tvInput.append("3");
            }
        });
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addValue("4");
                tvInput.append("4");
            }
        });
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addValue("5");
                tvInput.append("5");
            }
        });
        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addValue("6");
                tvInput.append("6");
            }
        });
        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addValue("7");
                tvInput.append("7");
            }
        });
        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addValue("8");
                tvInput.append("8");
            }
        });
        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addValue("9");
                tvInput.append("9");
            }
        });

        btnPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                operator("+");
            }
        });
        btnSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                operator("-");
            }
        });
        btnTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                operator("x");
            }
        });
        btnDiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                operator("/");
            }
        });
        btnResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (valueString1==null || operator==null || valueString2==null) {
                    Toast.makeText(MainActivity.this, "empty input", Toast.LENGTH_SHORT).show();
                } else {
                    hitung();
                }
            }
        });
        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clearAll();
            }
        });
    }

    void operator(String opt) {
        if (operator == null) {
            operator = opt;
            tvInput.append(" " + opt + " ");
        }

    }

    void clearAll() {
        valueString1 = "";
        valueString2 = "";
        operator = null;
        intResult = 0;
        doubleResult = new double[10];
        tvInput.setText("");
        tvResult.setText("");
    }

    void addValue(String numb) {
        if (!tvResult.getText().equals("")) {
            clearAll();

        }
        if (operator == null) {
            valueString1 += numb;
        } else {
            valueString2 += numb;
        }

    }

    void hitung() {
        System.out.println("hitung : " + valueString1 + operator + valueString2);

        intResult = 0;

        //validate
        if (!valueString1.equals("") && !operator.equals("") && !valueString2.equals("")) {
            if (operator.equals("+")) {
                intResult = Integer.parseInt(valueString1) + Integer.parseInt(valueString2);
            } else if (operator.equals("-")) {
                intResult = Integer.parseInt(valueString1) - Integer.parseInt(valueString2);
            } else if (operator.equals("x")) {
                intResult = Integer.parseInt(valueString1) * Integer.parseInt(valueString2);
            } else if (operator.equals("/")) {
                doubleResult[0] = (double) Integer.parseInt(valueString1) / Integer.parseInt(valueString2);
            }
        }

        if (intResult != 0) {
            tvResult.setText(String.valueOf(intResult));
        } else {
            tvResult.setText(Double.toString(doubleResult[0]));
        }
    }

}