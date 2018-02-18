package fi.tut.student.suvanto.simplecalc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class LogActivity extends AppCompatActivity {

    private String filename = "simplecalc.log";
    private TextView logview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log);

        logview = findViewById(R.id.tv_log);

        FileInputStream inputStream;
        StringBuilder log = new StringBuilder();

        try {
            inputStream = openFileInput(filename);
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                log.append(line);
                log.append("\n");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        logview.setText(log.toString());
    }

    public void clearLog(View view) {
        try {
            deleteFile(filename);
            logview.setText("");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
