package in.ravidsrk.java8sample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // lamba expressions
        findViewById(R.id.btn_clickme).setOnClickListener(v -> Toast.makeText(MainActivity.this,"Hello Lambda!",Toast.LENGTH_LONG).show());

        // switch string
        String action = "check";

        switch (action) {
            case "check":
                Toast.makeText(MainActivity.this,"Check",Toast.LENGTH_LONG).show();
                break;
            case "test":
                Toast.makeText(MainActivity.this,"Test",Toast.LENGTH_LONG).show();
                break;
        }

        // try(with-resources) {}
        final List<String> lines = new ArrayList<>();
        try (final InputStream is = this.getAssets().open("words.txt");
             final InputStreamReader isr = new InputStreamReader(is, "UTF-8");
             final BufferedReader reader = new BufferedReader(isr)) {
            String line;
            while ( (line = reader.readLine()) != null ) {
                lines.add(line);
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
