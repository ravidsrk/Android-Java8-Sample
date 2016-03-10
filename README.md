# AndroidJava8FeaturesSample
Playground for all the Java 8 features supported in Jack compliler.  

```java
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
```
