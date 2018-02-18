package fi.tut.student.suvanto.simplecalc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.GridLayout;
import android.widget.TextView;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private GridLayout calculationGrid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        calculationGrid = findViewById(R.id.calc_grid);
    }

    /*!

     */
    public void clearFields(View view) {
        for (int i = 0; i < calculationGrid.getChildCount(); i++) {
            View child = calculationGrid.getChildAt(i);

            if (child instanceof EditText) {
                ((EditText) child).getText().clear();
            }
        }

        ((TextView) findViewById(R.id.tv_plusresult)).setText("");
        ((TextView) findViewById(R.id.tv_minusresult)).setText("");
        ((TextView) findViewById(R.id.tv_multiresult)).setText("");
        ((TextView) findViewById(R.id.tv_divresult)).setText("");

    }

    public void plus(View view) {
        EditText num1 = findViewById(R.id.et_plus1);
        EditText num2 = findViewById(R.id.et_plus2);
        TextView result = findViewById(R.id.tv_plusresult);
        String str1 = num1.getText().toString();
        String str2 = num2.getText().toString();
        if (!str1.isEmpty() && !str2.isEmpty()) {
            result.setText(String.format("%.4f", Double.parseDouble(str1) + Double.parseDouble(str2)));
        }
    }

    public void minus(View view) {
        EditText num1 = findViewById(R.id.et_minus1);
        EditText num2 = findViewById(R.id.et_minus2);
        TextView result = findViewById(R.id.tv_minusresult);
        String str1 = num1.getText().toString();
        String str2 = num2.getText().toString();
        if (!str1.isEmpty() && !str2.isEmpty()) {
            result.setText(String.format("%.4f", Double.parseDouble(str1) - Double.parseDouble(str2)));
        }
    }

    public void multi(View view) {
        EditText num1 = findViewById(R.id.et_multi1);
        EditText num2 = findViewById(R.id.et_multi2);
        TextView result = findViewById(R.id.tv_multiresult);
        String str1 = num1.getText().toString();
        String str2 = num2.getText().toString();
        if (!str1.isEmpty() && !str2.isEmpty()) {
            result.setText(String.format("%.4f", Double.parseDouble(str1) * Double.parseDouble(str2)));
        }
    }

    public void div(View view) {
        EditText num1 = findViewById(R.id.et_div1);
        EditText num2 = findViewById(R.id.et_div2);
        TextView result = findViewById(R.id.tv_divresult);
        String str1 = num1.getText().toString();
        String str2 = num2.getText().toString();
        if (!str1.isEmpty() && !str2.isEmpty()) {
            result.setText(String.format("%.4f", Double.parseDouble(str1) / Double.parseDouble(str2)));
        }
    }
}