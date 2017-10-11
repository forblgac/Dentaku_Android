package com.example.light.twitter;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    EditText editText;
    Button button;

    View.OnClickListener buttonListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            recentOperator = R.id.button_eql;
            result = 0;
            isOperatorKeyPushed = false;

            textView.setText("");
            editText.setText("");
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = (TextView) findViewById(R.id.textview);
        editText = (EditText) findViewById(R.id.edittext);
        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(buttonListener);

        findViewById(R.id.button_1).setOnClickListener(buttonNumberListener);
        findViewById(R.id.button_2).setOnClickListener(buttonNumberListener);
        findViewById(R.id.button_3).setOnClickListener(buttonNumberListener);
        findViewById(R.id.button_4).setOnClickListener(buttonNumberListener);
        findViewById(R.id.button_5).setOnClickListener(buttonNumberListener);
        findViewById(R.id.button_6).setOnClickListener(buttonNumberListener);
        findViewById(R.id.button_7).setOnClickListener(buttonNumberListener);
        findViewById(R.id.button_8).setOnClickListener(buttonNumberListener);
        findViewById(R.id.button_9).setOnClickListener(buttonNumberListener);
        findViewById(R.id.button_0).setOnClickListener(buttonNumberListener);
        findViewById(R.id.button_dot).setOnClickListener(buttonNumberListener);
        findViewById(R.id.button_pls).setOnClickListener(buttonOperatorListener);
        findViewById(R.id.button_min).setOnClickListener(buttonOperatorListener);
        findViewById(R.id.button_mul).setOnClickListener(buttonOperatorListener);
        findViewById(R.id.button_div).setOnClickListener(buttonOperatorListener);
        findViewById(R.id.button_eql).setOnClickListener(buttonOperatorListener);

    }

    int recentOperator = R.id.button_eql;
    double result;
    boolean isOperatorKeyPushed;

    View.OnClickListener buttonNumberListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Button button = (Button) view;

            if (isOperatorKeyPushed) {
                editText.setText(button.getText());
            } else {
                editText.append(button.getText());
            }

            isOperatorKeyPushed = false;
        }
    };

    View.OnClickListener buttonOperatorListener = new View.OnClickListener(){
        @Override
        public void onClick(View view) {
            Button operatorButton = (Button) view;
            double value = Double.parseDouble(editText.getText().toString());
            if (recentOperator == R.id.button_eql) {
                result = value;
            } else{
                result = calc(recentOperator, result, value);
                editText.setText(String.valueOf(result));
            }
            recentOperator = operatorButton.getId();
            textView.setText(operatorButton.getText());
            isOperatorKeyPushed = true;
        }

        double calc(int operator, double value1, double value2) {
            switch (operator) {
                case R.id.button_pls:
                    return value1 + value2;
                case R.id.button_min:
                    return value1 - value2;
                case R.id.button_mul:
                    return value1 * value2;
                case R.id.button_div:
                    return value1 / value2;
                default:
                    return value1;

            }
        }
    };
}
