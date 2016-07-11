package pl.rafalszyszka.swapiapp;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

/**
 * Created by Squier on 2016-07-11.
 */
public class PeopleActivity extends AppCompatActivity {

    private ArrayList<Button> buttons;
    private JSONObject people;
    private LinearLayout linearLayout;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        linearLayout = new LinearLayout(this);

        downloadJsonFile("http://swapi.co/api/people/");



    }

    private void downloadJsonFile(String URL) {
        ConnectivityManager connMgr = (ConnectivityManager)
                getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
        if (networkInfo != null && networkInfo.isConnected()) {
            new DownloadPeople().execute(URL);
        } else {
            Toast.makeText(getApplicationContext(), "No network connection available.", Toast.LENGTH_SHORT).show();
        }
    }

    public class DownloadPeople extends AsyncTask<String, Void, String> {

        private static final String DEBUG_TAG = "DWP";

        @Override
        protected String doInBackground(String... urls) {
            try {
                return downloadUrl(urls[0]);
            } catch (IOException e) {
                e.printStackTrace();
                return "Unable to retrieve web page. Check your network connection.";
            }
        }

        @Override
        protected void onPostExecute(String s) {
            try {
                people = new JSONObject(s);
                String next = people.getString("next");
                JSONArray person = people.getJSONArray("results");

                while (!next.equals(null)) {
                    for (int i = 0; i < person.length(); i++) {
                        Button button = new Button(getApplicationContext());
                        button.setText(person.getJSONObject(i).getString("name"));

                        linearLayout.addView(button);
                    }
                    next = null;
                }
                setContentView(linearLayout);

            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        private String downloadUrl(String myUrl) throws IOException {
            InputStream is = null;
            try {
                URL url = new URL(myUrl);
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                conn.setReadTimeout(10000 /* milliseconds */);
                conn.setConnectTimeout(15000 /* milliseconds */);
                conn.setRequestMethod("GET");
                conn.setDoInput(true);
                // Starts the query
                conn.connect();
                int response = conn.getResponseCode();
                Log.d(DEBUG_TAG, "The response is: " + response);
                is = conn.getInputStream();

                // Convert the InputStream into a string
                return readIt(is);

                // Makes sure that the InputStream is closed after the app is
                // finished using it.
            } finally {
                if (is != null) {
                    is.close();
                }
            }

        }

        // Reads an InputStream and converts it to a String.
        public String readIt(InputStream stream) throws IOException {
            Reader reader = new InputStreamReader(stream, "UTF-8");
            BufferedReader bufferedReader = new BufferedReader(reader);
            StringBuilder sb = new StringBuilder();

            String read = bufferedReader.readLine();
            while (read != null) {
                sb.append(read);
                read = bufferedReader.readLine();
            }
            return sb.toString();
        }
    }

}

