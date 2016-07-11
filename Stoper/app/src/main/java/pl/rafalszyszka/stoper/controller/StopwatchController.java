package pl.rafalszyszka.stoper.controller;

import android.os.Handler;
import android.view.View;

import java.util.Locale;

import pl.rafalszyszka.stoper.model.Stopwatch;
import pl.rafalszyszka.stoper.view.StopwatchView;

/**
 * Created by Squier on 2016-07-08.
 */
public class StopwatchController {

    private Stopwatch stopwatch;
    private StopwatchView stopwatchView;

    private final Handler handler = new Handler();

    private Runnable startTimer = new Runnable() {
        @Override
        public void run() {
            if (stopwatch.isRunning()) {
                updateStopwatch(stopwatch.getTime());
                handler.postDelayed(this, stopwatch.getRate());
            }
        }
    };

    public StopwatchController(Stopwatch stopwatch, StopwatchView stopwatchView) {
        this.stopwatch = stopwatch;
        this.stopwatchView = stopwatchView;
    }

    public void startClicked() {
        stopwatchView.showStopButton();
        if (stopwatch.isInitial()) {
            stopwatch.start();
            stopwatch.setInitial(false);
            stopwatchView.getNextTimes().setText("");
        } else {
            //dodaje czas pomiedzy zatrzymaniem a ponownym uruchomieniem zeby w wyniku
            //pokazywac tylko czas faktycznie mierzony pomiedzy kliknieciami stop i start
            stopwatch.setStart(stopwatch.getStart() + (System.currentTimeMillis() - stopwatch.getStop()));
            stopwatch.setRunning(true);
        }

        handler.removeCallbacks(startTimer);
        handler.postDelayed(startTimer, 0);
    }

    public void continueRunning() {
        handler.removeCallbacks(startTimer);
        handler.postDelayed(startTimer, 0);
    }

    public void continuePausing() {
        updateStopwatch(stopwatch.getElapsed());
    }

    public void stopClicked() {
        stopwatchView.showStartButton();
        stopwatch.stop();
        updateStopwatch(stopwatch.getElapsed());
        handler.removeCallbacks(startTimer);
    }

    public void resetClicked() {
        stopwatchView.showStartButton();
        stopwatchView.getNextTimes().setText("");
        stopwatchView.getLapTimes().setText("");
        updateStopwatch(0);
        stopwatch.stop();
        stopwatch.setInitial(true);
        stopwatch.setNextCounter(0);
        stopwatch.setLapCounter(0);
        stopwatch.setPrevLapTime(0);
    }

    public void clearClicked() {
        stopwatchView.getNextTimes().setText("");
        stopwatchView.getLapTimes().setText("");
    }

    public void nextClicked() {
        if (stopwatch.isRunning()) {
            //format pokazywania czasu
            CharSequence text = String.format(Locale.ENGLISH, "#%d %s\n", stopwatch.incrementNextCounter(),
                    toTimeString(stopwatch.getTime()));
            stopwatchView.getNextTimes().append(text);
            stopwatchView.getNextTimesScroll().post(new Runnable() {
                @Override
                public void run() {
                    //przewijanie scrola w dół
                    stopwatchView.getNextTimesScroll().fullScroll(View.FOCUS_DOWN);
                }
            });
        }
    }

    public void lapClicked() {
        if (stopwatch.isRunning()) {
            if (stopwatch.getPrevLapTime() == 0) {
                stopwatch.setPrevLapTime(stopwatch.getTime());
                CharSequence text = String.format(Locale.ENGLISH, "#%d %s\n", stopwatch.incrementLapCounter(),
                        toTimeString(stopwatch.getPrevLapTime()));
                stopwatchView.getLapTimes().append(text);
            } else {
                long time = stopwatch.getTime();
                CharSequence text = String.format(Locale.ENGLISH, "#%d %s\n", stopwatch.incrementLapCounter(),
                        toTimeString(time - stopwatch.getPrevLapTime()));
                stopwatch.setPrevLapTime(time);
                stopwatchView.getLapTimes().append(text);
            }
            stopwatchView.getLapTimesScroll().post(new Runnable() {
                @Override
                public void run() {
                    stopwatchView.getLapTimesScroll().fullScroll(View.FOCUS_DOWN);
                }
            });
        }
    }

    private CharSequence toTimeString(long time) {
        int seconds, minutes, milliseconds;
        milliseconds = (int) time % 1000;
        seconds = (int) time / 1000;
        minutes = seconds / 60;
        seconds = seconds % 60;

        return String.format(Locale.ENGLISH, "%02d:%02d:%03d", minutes, seconds, milliseconds);
    }

    private void updateStopwatch(long time) {
        CharSequence _time = toTimeString(time);
        stopwatchView.getSecondsAndMinutes().setText(_time.subSequence(0, 5));
        stopwatchView.getMilliseconds().setText(_time.subSequence(6, 9));
    }

}