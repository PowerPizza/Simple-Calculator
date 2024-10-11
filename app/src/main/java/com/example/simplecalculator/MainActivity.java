package com.example.simplecalculator;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    EditText entry_1;
    EditText entry_2;
    TextView output_view;
    String operator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        entry_1 = findViewById(R.id.entry_num1);
        entry_2 = findViewById(R.id.entry_num2);
        output_view = findViewById(R.id.output_text);


        findViewById(R.id.btn_add).setOnClickListener((View v1) -> {
            this.operator = "+";
            calculate();
//            double a = Double.parseDouble(entry_1.getText().toString());
//            double b = Double.parseDouble(entry_2.getText().toString());
//            output_view.setText(String.format(Locale.ENGLISH, "%s", a+b));
        });

        findViewById(R.id.btn_subtract).setOnClickListener((View v1) -> {
            this.operator = "-";
            calculate();
        });

        findViewById(R.id.btn_multiply).setOnClickListener((View v1) -> {
            this.operator = "*";
            calculate();
        });

        findViewById(R.id.btn_divide).setOnClickListener((View v1) -> {
            this.operator = "/";
            calculate();
        });

        findViewById(R.id.btn_remainder).setOnClickListener((View v1) -> {
            this.operator = "%";
            calculate();
        });

        findViewById(R.id.btn_square).setOnClickListener((View v1) -> {
            this.operator = "SQ";
            calculate();
        });

        findViewById(R.id.btn_sq_root).setOnClickListener((View v1) -> {
            this.operator = "SRT";
            calculate();
        });

        findViewById(R.id.btn_factorial).setOnClickListener((View v1) -> {
            this.operator = "FACTORIAL";
            calculate();
        });

        findViewById(R.id.btn_log).setOnClickListener((View v1)->{
            this.operator = "LOG10";
            calculate();
        });

        findViewById(R.id.btn_ln).setOnClickListener((View v1)->{
            this.operator = "LN";
            calculate();
        });

    }

    public double to_double(String n){
        try {
            return Double.parseDouble(n);
        }
        catch (Exception ignored){
            return 0;
        }
    }
    public double factorial(double n){
        if (n == 0 || n == 1){
            return n;
        }
        return n * factorial(n-1);
    }

    public void calculate(){
        double a;
        double b;
        a = this.to_double(entry_1.getText().toString());
        b = this.to_double(entry_2.getText().toString());
        
        switch (operator){
            case "+":
                output_view.setText(String.format(Locale.ENGLISH, "%s", a+b));
                break;
            case "-":
                output_view.setText(String.format(Locale.ENGLISH, "%s", a-b));
                break;
            case "*":
                output_view.setText(String.format(Locale.ENGLISH, "%s", a*b));
                break;
            case "/":
                output_view.setText(String.format(Locale.ENGLISH, "%s", a/b));
                break;
            case "%":
                output_view.setText(String.format(Locale.ENGLISH, "%s", a%b));
                break;
            case "SQ":
                output_view.setText(String.format(Locale.ENGLISH, "%s", Math.pow(a, b)));
                break;
            case "SRT":
                output_view.setText(String.format(Locale.ENGLISH, "√%s = %.5f\n√%s = %.5f", a, Math.sqrt(a), b, Math.sqrt(b)));
                break;
            case "FACTORIAL":
                output_view.setText(String.format(Locale.ENGLISH, "%s! = %s\n%s! = %s", a, this.factorial(a), b, this.factorial(b)));
                break;
            case "LOG10":
                output_view.setText(String.format(Locale.ENGLISH, "log(%s) = %s\nlog(%s) = %s", a, Math.log10(a), b, Math.log10(b)));
                break;
            case "LN":
                output_view.setText(String.format(Locale.ENGLISH, "ln(%s) = %s\nln(%s) = %s", a, Math.log(a), b, Math.log(b)));
                break;
        }
    }
}