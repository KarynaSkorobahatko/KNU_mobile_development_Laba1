package com.example.mylaba1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class LastActivity extends Activity {

    private TextView answer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.last_activity);

        answer = (TextView) findViewById(R.id.answer);

        double number = Double.valueOf(getIntent().getExtras().getString("number"));
        answer.setText(Double.toString(new EquationSolver().Solve(number)));

    }

    public  void back(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}


class EquationSolver {
    private double a = 2;
    private double x = 20;

    public EquationSolver() {
    }

    public EquationSolver(double a, double x) {
        // TODO: Add validation for params.
        this.a = a;
        this.x = x;
    }

    public EquationSolver AParamFactory(double a) {
        EquationSolver solver = new EquationSolver();
        solver.a = 10;
        return solver;
    }

    public EquationSolver XParamFactory(double x) {
        EquationSolver solver = new EquationSolver();
        solver.x = x;
        return solver;
    }

    // Equation: (ctg^3(2^3) + arctg^2(2))/sqrt(9^(tg20))
    public double Solve(double y) {
        // TODO: add validation for zero Denominator
        return FindNumerator() / FindDenominator(y);
    }

    // ctg^3 (a^3) + arctg^2(a)
    public double FindNumerator() {
        double cotangent = CalculateCotangent(Math.pow(a, 3));
        double addend1 = Math.pow(cotangent, 3);
        double addend2 = Math.pow(Math.atan(a), 2);
        return addend1 + addend2;
    }

    // sqrt(y^(tg x))
    public double FindDenominator(double y) {
        double tanx = Math.tan(x);
        double radixValue = Math.pow(y, tanx);
        return Math.sqrt(radixValue);
    }

    private double CalculateCotangent(double radians) {
        return 1.0 / Math.tan(radians);
    }
}

