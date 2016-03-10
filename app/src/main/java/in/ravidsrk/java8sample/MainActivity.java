package in.ravidsrk.java8sample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // lamba expressions
        findViewById(R.id.btn_clickme).setOnClickListener(v -> Toast.makeText(MainActivity.this,"Hello Lambda!",Toast.LENGTH_LONG).show());

    }
}
