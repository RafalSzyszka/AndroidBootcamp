package pl.rafalszyszka.swapiapp;

import android.os.AsyncTask;
import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by Squier on 2016-07-11.
 */
public class DownloadWebPage extends AsyncTask<String, Void, String> {

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
        JSONContainer.DOWNLOADED_JSON_STRING = s;
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
