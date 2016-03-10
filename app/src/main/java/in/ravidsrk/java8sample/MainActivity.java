package in.ravidsrk.java8sample;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "Java8Android";
    private Context context;

    // Accessing fields and static variables
    static int outerStaticNum;
    int outerNum;

    // Extension Methods.
    interface Formula {
        double calculate(int a);

        default double sqrt(int a) {
            return Math.sqrt(a);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        context = this;

        //
        // lambda expressions
        //
        findViewById(R.id.btn_clickme).setOnClickListener(v -> Toast.makeText(MainActivity.this, "Hello Lambda!", Toast.LENGTH_LONG).show());

        List<String> names = Arrays.asList("peter", "anna", "mike", "xenia");

        Collections.sort(names, new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                return b.compareTo(a);
            }
        });

        Collections.sort(names, (a, b) -> b.compareTo(a));

        //
        // switch string
        //
        String action = "check";

        switch (action) {
            case "check":
                Toast.makeText(MainActivity.this, "Check", Toast.LENGTH_LONG).show();
                break;
            case "test":
                Toast.makeText(MainActivity.this, "Test", Toast.LENGTH_LONG).show();
                break;
        }

        //
        // try(with-resources) {}
        //
        final List<String> lines = new ArrayList<>();
        try (final InputStream is = context.getAssets().open("words.txt");
             final InputStreamReader isr = new InputStreamReader(is, "UTF-8");
             final BufferedReader reader = new BufferedReader(isr)) {
            String line;
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }

            Log.d(TAG, "Lines"+ lines.size() + "");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //
        // Extension Methods.
        //
        Formula formula = new Formula() {
            @Override
            public double calculate(int a) {
                return sqrt(a * 100);
            }
        };

        formula.calculate(100);
        formula.sqrt(16);

        //
        // Method::references
        //
        int compare = Objects.compare("Test", "test", String::compareToIgnoreCase);
        Log.d(TAG, compare + "");

        List<String> stringCollection = new ArrayList<>();
        stringCollection.add("ddd2");
        stringCollection.add("aaa2");
        stringCollection.add("bbb1");
        stringCollection.add("aaa1");
        stringCollection.add("bbb3");
        stringCollection.add("ccc");
        stringCollection.add("bbb2");
        stringCollection.add("ddd1");
    }
}
