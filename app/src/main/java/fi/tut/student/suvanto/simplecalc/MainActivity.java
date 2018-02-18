package fi.tut.student.suvanto.simplecalc;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.GridLayout;
import android.widget.TextView;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private EditText plus1;
    private EditText plus2;
    private EditText minus1;
    private EditText minus2;
    private EditText multi1;
    private EditText multi2;
    private EditText div1;
    private EditText div2;

    private TextView plusresult;
    private TextView minusresult;
    private TextView multiresult;
    private TextView divresult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        plus1 = findViewById(R.id.et_plus1);
        plus2 = findViewById(R.id.et_plus2);
        minus1 = findViewById(R.id.et_minus1);
        minus2 = findViewById(R.id.et_minus2);
        multi1 = findViewById(R.id.et_multi1);
        multi2 = findViewById(R.id.et_multi2);
        div1 = findViewById(R.id.et_div1);
        div2 = findViewById(R.id.et_div2);

        plusresult = findViewById(R.id.tv_plusresult);
        minusresult = findViewById(R.id.tv_minusresult);
        multiresult = findViewById(R.id.tv_multiresult);
        divresult = findViewById(R.id.tv_divresult);
    }

    /**
     * Clear all number entry fields and results.
     * @param view The view.
     */
    public void clearFields(View view) {

        plus1.setText("");
        plus2.setText("");
        minus1.setText("");
        minus2.setText("");
        multi1.setText("");
        multi2.setText("");
        div1.setText("");
        div2.setText("");

        plusresult.setText("");
        minusresult.setText("");
        multiresult.setText("");
        divresult.setText("");
    }

    /**
     * Sum the two values.
     * @param view The view.
     */
    public void plus(View view) {
        String str1 = plus1.getText().toString();
        String str2 = plus2.getText().toString();
        if (!str1.isEmpty() && !str2.isEmpty()) {
            Double double1 = Double.parseDouble(str1);
            Double double2 = Double.parseDouble(str2);
            Double result = double1+double2;
            plusresult.setText(String.format("%.4f", result));
            log_message(String.format("%0$.4f + %1$.4f = %2$.4f\n", double1, double2, result));
        }
    }

    /**
     * Subtract the two values.
     * @param view The view.
     */
    public void minus(View view) {
        String str1 = minus1.getText().toString();
        String str2 = minus2.getText().toString();
        if (!str1.isEmpty() && !str2.isEmpty()) {
            Double double1 = Double.parseDouble(str1);
            Double double2 = Double.parseDouble(str2);
            Double result = double1-double2;
            minusresult.setText(String.format("%.4f", result));
            log_message(String.format("%0$.4f - %1$.4f = %2$.4f\n", double1, double2, result));
        }
    }

    /**
     * Multiply the two values.
     * @param view The view.
     */
    public void multi(View view) {
        String str1 = multi1.getText().toString();
        String str2 = multi2.getText().toString();
        if (!str1.isEmpty() && !str2.isEmpty()) {
            Double double1 = Double.parseDouble(str1);
            Double double2 = Double.parseDouble(str2);
            Double result = double1*double2;
            multiresult.setText(String.format("%.4f", result));
            log_message(String.format("%0$.4f * %1$.4f = %2$.4f\n", double1, double2, result));
        }
    }

    /**
     * Divide the two values.
     * @param view The view.
     */
    public void div(View view) {
        String str1 = div1.getText().toString();
        String str2 = div2.getText().toString();
        if (!str1.isEmpty() && !str2.isEmpty()) {
            Double double1 = Double.parseDouble(str1);
            Double double2 = Double.parseDouble(str2);
            Double result = double1/double2;
            divresult.setText(String.format("%.4f", result));
            log_message(String.format("%0$.4f / %1$.4f = %2$.4f\n", double1, double2, result));
        }
    }

    /**
     * Show the log.
     * @param view The view.
     */
    public void showLog(View view) {
        Intent intent = new Intent(this, LogActivity.class);
        startActivity(intent);
    }


    /**
     * Add a message to the log file.
     * @param logmsg The message.
     */
    private void log_message(String logmsg) {
        String filename = "simplecalc.log";
        FileOutputStream outputStream;
        try {
            outputStream = openFileOutput(filename, MODE_APPEND);
            outputStream.write(logmsg.getBytes());
            outputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}