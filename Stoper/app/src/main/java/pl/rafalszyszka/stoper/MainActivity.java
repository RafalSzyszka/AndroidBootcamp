package pl.rafalszyszka.stoper;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;

import pl.rafalszyszka.stoper.controller.StopwatchController;
import pl.rafalszyszka.stoper.model.Serialize;
import pl.rafalszyszka.stoper.model.Stopwatch;
import pl.rafalszyszka.stoper.view.StopwatchView;

public class MainActivity extends AppCompatActivity {

    private StopwatchController stopwatchController;
    private Stopwatch stopwatch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        StopwatchView stopwatchView = new StopwatchView((TextView) findViewById(R.id.stopwatch_millis),
                (TextView) findViewById(R.id.stopwatch_mins_secs),
                (TextView) findViewById(R.id.nexts), (TextView) findViewById(R.id.laps),
                (ScrollView) findViewById(R.id.nexts_scroll), (ScrollView) findViewById(R.id.laps_scroll),
                (Button) findViewById(R.id.start_button), (Button) findViewById(R.id.stop_button));

        /**
         * Mierzę czas nawet jeśli aplikacja jest wyłączona
         * Dzięki serializacji aplikacja nie działa w tle
         */
        try {
            /* Odzyskuję poprzedni stan stopera */
            stopwatch = (Stopwatch) Serialize.restoreObject("stopwatch.stp", getApplicationContext());

            /*na jego podstawie tworzę kontroler*/
            stopwatchController = new StopwatchController(stopwatch, stopwatchView);
            if(stopwatch.isRunning()) { //jesli przed wysjciem z aplikacji stoper działał, to niech działa
                stopwatchController.continueRunning();
                stopwatchView.showStopButton();
            } else {
                stopwatchController.continuePausing();      //jesli byl zatrzymany, przywraca jego czas
            }
            Toast.makeText(getApplicationContext(), "Restored previous stopwatch", Toast.LENGTH_SHORT).show();
        } catch (IOException | ClassNotFoundException e) {
            stopwatch = new Stopwatch();    //jesli nie istenieje plik z zapisem, tworzy sie nowa instancja
            stopwatchController = new StopwatchController(stopwatch, stopwatchView);
            Toast.makeText(getApplicationContext(), "New Stopwatch", Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        try {   //zapisuje obiekt
            Serialize.saveObject(stopwatch, "stopwatch.stp", getApplicationContext());
            Toast.makeText(getApplicationContext(), "Saved stopwatch state", Toast.LENGTH_SHORT).show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void onStartClick(View view) {
        stopwatchController.startClicked();
    }

    public void onStopClick(View view) {
        stopwatchController.stopClicked();
    }

    public void onResetButtonClick(View view) {
        stopwatchController.resetClicked();
    }

    public void onClearButtonClick(View view) {
        stopwatchController.clearClicked();
    }

    public void onNextButtonClick(View view) {
        stopwatchController.nextClicked();
    }

    public void onLapButtonClick(View view) {
        stopwatchController.lapClicked();
    }
}
