package com.ioscalc;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.mozilla.javascript.Context;
import org.mozilla.javascript.Scriptable;

public class MainActivity extends AppCompatActivity {

    Button btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btn0,
            btncomma, btnequal, btnplus, btnminus, btnmultiply, btndivide, btnpercent, btnfactorial, btnclear;
    TextView outputTx, inputTx;
    String input, abc;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calculator);
        initialize();
        buttoncontrol();


    }

    private void buttoncontrol() {

        btn1.setOnClickListener(view -> {
            input = inputTx.getText().toString();
            inputTx.setText(input + "1");
        });
        btn2.setOnClickListener(view -> {
            input = inputTx.getText().toString();
            inputTx.setText(input + "2");
        });
        btn3.setOnClickListener(view -> {
            input = inputTx.getText().toString();
            inputTx.setText(input + "3");
        });
        btn4.setOnClickListener(view -> {
            input = inputTx.getText().toString();
            inputTx.setText(input + "4");
        });
        btn5.setOnClickListener(view -> {
            input = inputTx.getText().toString();
            inputTx.setText(input + "5");
        });
        btn6.setOnClickListener(view -> {
            input = inputTx.getText().toString();
            inputTx.setText(input + "6");
        });
        btn7.setOnClickListener(view -> {
            input = inputTx.getText().toString();
            inputTx.setText(input + "7");
        });
        btn8.setOnClickListener(view -> {
            input = inputTx.getText().toString();
            inputTx.setText(input + "8");
        });
        btn9.setOnClickListener(view -> {
            input = inputTx.getText().toString();
            inputTx.setText(input + "9");
        });
        btn0.setOnClickListener(view -> {
            input = inputTx.getText().toString();
            inputTx.setText(input + "0");
        });

        btnclear.setOnClickListener(view -> {

            inputTx.setText("");
            outputTx.setText("");
        });
        btncomma.setOnClickListener(view -> {
            input = inputTx.getText().toString();
            if (input.endsWith("+") || input.endsWith("-") || input.endsWith("×") || input.endsWith("÷") || input.endsWith("%") || input.endsWith("!") || input.endsWith(".")) {
                System.out.println("bum");

            } else
                inputTx.setText(input + ".");
        });

        btnpercent.setOnClickListener(view -> {
            input = inputTx.getText().toString();
            if (input.endsWith("+") || input.endsWith("-") || input.endsWith("×") || input.endsWith("÷") || input.endsWith("%") || input.endsWith("!") || input.endsWith(".")) {

            } else
                inputTx.setText(input + "%");
        });
        btnfactorial.setOnClickListener(view -> {
            input = inputTx.getText().toString();

            if (input.endsWith("+") || input.endsWith("-") || input.endsWith("×") || input.endsWith("÷") || input.endsWith("%") || input.endsWith("!") || input.endsWith(".")) {
                System.out.println("baba");
            } else
                inputTx.setText(input + "!");


        });
        btnplus.setOnClickListener(view -> {
            input = inputTx.getText().toString();

            if (input.endsWith("+") || input.endsWith("-") || input.endsWith("×") || input.endsWith("÷") || input.endsWith("%") || input.endsWith("!") || input.endsWith(".")) {
                System.out.println("baba");
            } else
                inputTx.setText(input + "+");

        });
        btnmultiply.setOnClickListener(view -> {
            input = inputTx.getText().toString();
            if (input.endsWith("+") || input.endsWith("-") || input.endsWith("×") || input.endsWith("÷") || input.endsWith("%") || input.endsWith("!") || input.endsWith(".")) {
                System.out.println("baba");
            } else
                inputTx.setText(input + "×");
        });
        btndivide.setOnClickListener(view -> {
            input = inputTx.getText().toString();
            if (input.endsWith("+") || input.endsWith("-") || input.endsWith("×") || input.endsWith("÷") || input.endsWith("%") || input.endsWith("!") || input.endsWith(".")) {
                System.out.println("baba");
            } else
                inputTx.setText(input + "÷");
        });
        btnminus.setOnClickListener(view -> {
            input = inputTx.getText().toString();
            if (input.endsWith("+") || input.endsWith("-") || input.endsWith("×") || input.endsWith("%") || input.endsWith("÷") || input.endsWith("!") || input.endsWith(".")) {
                System.out.println("bum");
            } else
                inputTx.setText(input + "-");
        });


        btnequal.setOnClickListener(view -> {

            input = inputTx.getText().toString();
            input = input.replaceAll("×", "*");
            input = input.replaceAll("%", "/100");
            input = input.replaceAll("÷", "/");


            Context rhinos = Context.enter();

            rhinos.setOptimizationLevel(-1);
            String finalResult = "";

            try {

                Scriptable scriptable = rhinos.initStandardObjects();
                finalResult =
                        rhinos.evaluateString(scriptable, input,
                                "javascript", 2,
                                null).toString();


            } catch (Exception a) {
                finalResult = "0";
            }

            StringBuilder yenitext = new StringBuilder(finalResult);

            if (yenitext.charAt(yenitext.length() - 1) == '0') {
//                yenitext.replace(0,yenitext.length()-1,"a");
                outputTx.setText(yenitext);
            } else {
                outputTx.setText(yenitext);

            }
//            yenitext.subSequence(0, yenitext.length()-4);

        });


    }


    private void initialize() {

        inputTx = findViewById(R.id.inputtx);
        outputTx = findViewById(R.id.outputtx);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btn5 = findViewById(R.id.btn5);
        btn6 = findViewById(R.id.btn6);
        btn7 = findViewById(R.id.btn7);
        btn8 = findViewById(R.id.btn8);
        btn9 = findViewById(R.id.btn9);
        btn0 = findViewById(R.id.btn0);
        btnclear = findViewById(R.id.btnclear);
        btnfactorial = findViewById(R.id.btnfactorial);
        btnminus = findViewById(R.id.btnminus);
        btnplus = findViewById(R.id.btnplus);
        btndivide = findViewById(R.id.btndivide);
        btnmultiply = findViewById(R.id.btnmultiply);
        btncomma = findViewById(R.id.btncomma);
        btnequal = findViewById(R.id.btnequal);
        btnpercent = findViewById(R.id.btnpercent);

    }


}