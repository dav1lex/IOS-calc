package com.ioscalc;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import org.mozilla.javascript.Context;
import org.mozilla.javascript.Scriptable;

public class MainActivity extends AppCompatActivity {

    Button[] numberButtons;
    Button btncomma, btnequal, btnplus, btnminus, btnmultiply, btndivide, btnpercent, btnfactorial, btnclear;
    TextView outputTx, inputTx;
    String input;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calculator);
        initialize();
        setNumberButtonListeners();
        setOperatorButtonListeners();
    }

    private void setNumberButtonListeners() {
        View.OnClickListener numberClickListener = view -> {
            Button button = (Button) view;
            input = inputTx.getText().toString();
            inputTx.setText(input + button.getText().toString());
        };
        for (Button button : numberButtons) {
            button.setOnClickListener(numberClickListener);
        }
    }

    private void setOperatorButtonListeners() {
        btnclear.setOnClickListener(view -> {
            inputTx.setText("");
            outputTx.setText("");
        });

        btncomma.setOnClickListener(view -> appendOperator("."));
        btnpercent.setOnClickListener(view -> appendOperator("%"));
        btnfactorial.setOnClickListener(view -> appendOperator("!"));
        btnplus.setOnClickListener(view -> appendOperator("+"));
        btnminus.setOnClickListener(view -> appendOperator("-"));
        btnmultiply.setOnClickListener(view -> appendOperator("×"));
        btndivide.setOnClickListener(view -> appendOperator("÷"));

        btnequal.setOnClickListener(view -> calculateResult());
    }

    private void appendOperator(String operator) {
        input = inputTx.getText().toString();
        if (!input.endsWith("+") && !input.endsWith("-") && !input.endsWith("×") && !input.endsWith("÷") && !input.endsWith("%") && !input.endsWith("!") && !input.endsWith(".")) {
            inputTx.setText(input + operator);
        }
    }

    private void calculateResult() {
        input = inputTx.getText().toString();
        input = input.replaceAll("×", "*");
        input = input.replaceAll("%", "/100");
        input = input.replaceAll("÷", "/");

        Context rhinos = Context.enter();
        rhinos.setOptimizationLevel(-1);

        String finalResult;
        try {
            Scriptable scriptable = rhinos.initStandardObjects();
            Object result = rhinos.evaluateString(scriptable, input, "javascript", 2, null);
            double doubleResult = Double.parseDouble(result.toString());

            if (doubleResult == Math.floor(doubleResult)) {
                finalResult = String.valueOf((int) doubleResult);
            } else {
                finalResult = String.valueOf(doubleResult);
            }
        } catch (Exception e) {
            finalResult = "Error";
        } finally {
            Context.exit();
        }

        outputTx.setText(finalResult);
    }

    private void initialize() {
        inputTx = findViewById(R.id.inputtx);
        outputTx = findViewById(R.id.outputtx);

        numberButtons = new Button[]{
                findViewById(R.id.btn0), findViewById(R.id.btn1), findViewById(R.id.btn2),
                findViewById(R.id.btn3), findViewById(R.id.btn4), findViewById(R.id.btn5),
                findViewById(R.id.btn6), findViewById(R.id.btn7), findViewById(R.id.btn8),
                findViewById(R.id.btn9)
        };

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
