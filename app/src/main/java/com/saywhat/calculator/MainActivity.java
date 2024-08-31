package com.saywhat.calculator;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    // Declaring Final Strings
    private final String SAVED_OPERATION = "pendingOp";
    private final String SAVED_OPERAND = "op1";
    // declare show variables
    private EditText newNumber, result;
    private TextView displayOperation;

    // variables to data operations
    private Double op1 = null;
    private String pendOp = "=";

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        newNumber = findViewById(R.id.newNumber);
        result = findViewById(R.id.result);
        displayOperation = findViewById(R.id.operation);

        // number buttons
        Button zeroButton = findViewById(R.id.zeroButton);
        Button oneButton = findViewById(R.id.oneButton);
        Button twoButton = findViewById(R.id.twoButton);
        Button threeButton = findViewById(R.id.threeButton);
        Button fourButton = findViewById(R.id.fourButton);
        Button fiveButton = findViewById(R.id.fiveButton);
        Button sixButton = findViewById(R.id.sixButton);
        Button sevenButton = findViewById(R.id.sevenButton);
        Button eightButton = findViewById(R.id.eightButton);
        Button nineButton = findViewById(R.id.nineButton);
        Button dotButton = findViewById(R.id.dotButton);

        //operation buttons
        Button buttonEqual = findViewById(R.id.equalButton);
        Button divideButton = findViewById(R.id.divideButton);
        Button mulButton = findViewById(R.id.mulButton);
        Button minusButton = findViewById(R.id.minusButton);
        Button addButton = findViewById(R.id.addButton);
        Button modButton = findViewById(R.id.modButton);
        Button bracketButton = findViewById(R.id.bracketButton);

        // scientific op only
        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {

            // scientific operations buttons
            Button sinButton = findViewById(R.id.sinButton);
            Button cosButton = findViewById(R.id.cosButton);
            Button tanButton = findViewById(R.id.tanButton);
            Button rootButton = findViewById(R.id.rootButton);
            Button factorButton = findViewById(R.id.factorButton);
            Button piButton = findViewById(R.id.piButton);
            Button squareButton = findViewById(R.id.squareButton);
            Button logButton = findViewById(R.id.logButton);

            // scientific operations
            // Square Button
            squareButton.setOnClickListener(v -> {
                try {
                    int num = Integer.parseInt(result.getText().toString());
                    double base = Math.pow(num, 2);
                    newNumber.setText(Double.toString(base));
//                    result.setText(Double.toString(base));
                    displayOperation.setText("n²");
                    op1 = base;
                } catch (Exception ex) {
                    Toast.makeText(getApplicationContext(), "Enter a number before proceeding!", Toast.LENGTH_SHORT).show();
                }
            });

// Pi Button
            piButton.setOnClickListener(v -> {
                try {
                    double num = Double.parseDouble(result.getText().toString());
                    double base = num * Math.PI;
                    newNumber.setText(Double.toString(base));
//                    result.setText(Double.toString(base));
                    displayOperation.setText("×π");
                    op1 = base;
                } catch (Exception ex) {
                    double piValue = Math.PI;
//                    newNumber.setText(Double.toString(piValue));
                    result.setText(Double.toString(piValue));
                    displayOperation.setText("π");
                    op1 = piValue;
                }
            });

// Square Root Button
            rootButton.setOnClickListener(v -> {
                try {
                    double num = Double.parseDouble(result.getText().toString());
                    double base = Math.sqrt(num);
                    newNumber.setText(Double.toString(base));
//                    result.setText(Double.toString(base));
                    displayOperation.setText("√");
                    op1 = base;
                } catch (Exception ex) {
                    Toast.makeText(getApplicationContext(), "Enter a number first!", Toast.LENGTH_SHORT).show();
                }
            });

// Sin Button
            sinButton.setOnClickListener(v -> {
                try {
                    double num = Double.parseDouble(result.getText().toString());
                    double base = Math.sin(Math.toRadians(num));
                    newNumber.setText(Double.toString(base));
//                    result.setText(Double.toString(base));
                    displayOperation.setText("sin");
                    op1 = base;
                } catch (Exception ex) {
                    Toast.makeText(MainActivity.this, "Syntax Error", Toast.LENGTH_SHORT).show();
                }
            });

// Cos Button
            cosButton.setOnClickListener(v -> {
                try {
                    double num = Double.parseDouble(result.getText().toString());
                    double base = Math.cos(Math.toRadians(num));
                    newNumber.setText(Double.toString(base));
//                    result.setText(Double.toString(base));
                    displayOperation.setText("cos");
                    op1 = base;
                } catch (Exception ex) {
                    Toast.makeText(MainActivity.this, "Syntax Error", Toast.LENGTH_SHORT).show();
                }
            });

// Tan Button
            tanButton.setOnClickListener(v -> {
                try {
                    double num = Double.parseDouble(result.getText().toString());
                    double base = Math.tan(Math.toRadians(num));
                    newNumber.setText(Double.toString(base));
//                    result.setText(Double.toString(base));
                    displayOperation.setText("tan");
                    op1 = base;
                } catch (Exception ex) {
                    Toast.makeText(MainActivity.this, "Syntax Error", Toast.LENGTH_SHORT).show();
                }
            });

            // Log Button
            logButton.setOnClickListener(v -> {
                try {
                    double num = Double.parseDouble(result.getText().toString());
                    double base = Math.log(num);
                    newNumber.setText(Double.toString(base));
//                    result.setText(Double.toString(base));
                    displayOperation.setText("log");
                    op1 = base;
                } catch (Exception ex) {
                    Toast.makeText(MainActivity.this, "Syntax Error", Toast.LENGTH_SHORT).show();
                }
            });

            // Factorial Button
            factorButton.setOnClickListener(v -> {
                try {
                    int num = Integer.parseInt(result.getText().toString());
                    double facRes = 1;
                    for (int i = 1; i <= num; i++) facRes *= i;
                    newNumber.setText(Double.toString(facRes));
//                    result.setText(Double.toString(facRes));
                    displayOperation.setText("n!");
                    op1 = facRes;
                } catch (Exception ex) {
                    Toast.makeText(MainActivity.this, "Syntax Error", Toast.LENGTH_SHORT).show();
                }
            });

        }
        // add onClick for number button
        View.OnClickListener onClickNumber = v -> {
            Button btn = (Button) v;
            result.append(btn.getText().toString());
        };

        // assigned onClick for number buttons
        zeroButton.setOnClickListener(onClickNumber);
        oneButton.setOnClickListener(onClickNumber);
        twoButton.setOnClickListener(onClickNumber);
        threeButton.setOnClickListener(onClickNumber);
        fourButton.setOnClickListener(onClickNumber);
        fiveButton.setOnClickListener(onClickNumber);
        sixButton.setOnClickListener(onClickNumber);
        sevenButton.setOnClickListener(onClickNumber);
        eightButton.setOnClickListener(onClickNumber);
        nineButton.setOnClickListener(onClickNumber);
        dotButton.setOnClickListener(onClickNumber);

        // add onClick for operation button
        View.OnClickListener onClickOperation = v -> {
            Button btn = (Button) v;
            String operation = btn.getText().toString();
            String value = result.getText().toString();
            try {
                Double doubleVal = Double.valueOf(value);
                performOperation(doubleVal, operation);
            } catch (NumberFormatException ex) {
                result.setText("");
            }
            pendOp = operation;
            displayOperation.setText(pendOp);
        };

        // assign onClick for operation button
        buttonEqual.setOnClickListener(onClickOperation);
        divideButton.setOnClickListener(onClickOperation);
        minusButton.setOnClickListener(onClickOperation);
        addButton.setOnClickListener(onClickOperation);
        mulButton.setOnClickListener(onClickOperation);
        modButton.setOnClickListener(onClickOperation);
        Button clearText = findViewById(R.id.clearButton);

        clearText.setOnClickListener(v -> {
            newNumber.setText("");
            result.setText("");
            displayOperation.setText("");
            op1 = null;
        });

        modButton.setOnClickListener(onClickOperation);


        Button negButton = findViewById(R.id.negButton);
        negButton.setOnClickListener(v -> {
            String str = result.getText().toString();
            if (str.isEmpty()) {
                result.setText("-");
            } else {
                try {
                    double doubleVal = Double.parseDouble(str);
                    doubleVal *= -1;
                    op1 = doubleVal;
                    result.setText(Double.toString(doubleVal));
                } catch (NumberFormatException ex) {
                    result.setText("");
                }
            }
        });
        bracketButton.setOnClickListener(v -> {
            try {
                String str;
                str = result.getText().toString();
                str = str.substring(0, str.length() - 1);
                result.setText(str);
            } catch (Exception ignored) {

            }
        });
//        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
//        SharedPreferences.Editor editor = sharedPreferences.edit();
//        boolean isFirstRun = sharedPreferences.getBoolean("IS_FIRST_RUN", true);

//        if (isFirstRun) {
//            // dialog builder
//            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
//
//            builder.setMessage("→ New Material Ui Introduced. " +
//                    "\n→ Minor Bugs Fixed " +
//                    "\n→ Added New Functions " +
//                    "\n→ With New Refreshing Look " +
//                    "\n→ Dev CraazY");
//            builder.setMessage("Update Info!");
//            builder.setCancelable(false);
//            builder.setPositiveButton("Ok", (dialog, which) -> dialog.cancel());
//            AlertDialog alertDialog = builder.create();
//            alertDialog.show();
//            editor.putBoolean("IS_FIRST_RUN", false);
//            editor.apply();
//        }
    }


    @SuppressLint("SetTextI18n")
    private void performOperation(Double value, String operation) {
        if (null == op1) {
            op1 = value;
        } else {
            if (pendOp.equals("=")) {
                pendOp = operation;
            }
            switch (pendOp) {
                case "=":
                    op1 = value;
                    break;
                case "÷":
                    if (value == 0) {
                        op1 = 0.0;
                    } else {
                        op1 /= value;
                    }
                    break;
                case "×":
                    op1 *= value;
                    break;
                case "-":
                    op1 -= value;
                    break;
                case "+":
                    op1 += value;
                    break;
                case "%":
                    op1 %= value;
                    break;
            }
        }
        newNumber.setText(Double.toString(op1));
        result.setText("");
    }


    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        pendOp = savedInstanceState.getString(SAVED_OPERATION);
        op1 = savedInstanceState.getDouble(SAVED_OPERAND);
        if (Objects.equals(pendOp, "=")) {
            displayOperation.setText("");
        } else {
            displayOperation.setText(pendOp);
        }
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        outState.putString(SAVED_OPERATION, pendOp);
        if (op1 != null) {
            outState.putDouble(SAVED_OPERAND, op1);
        }
        super.onSaveInstanceState(outState);
    }
}