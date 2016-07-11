package pl.rafalszyszka.stoper.view;

import android.view.View;
import android.widget.Button;
import android.widget.ScrollView;
import android.widget.TextView;

/**
 * Created by Squier on 2016-07-08.
 */
public class StopwatchView {

    private TextView milliseconds;
    private TextView secondsAndMinutes;

    private TextView nextTimes;
    private TextView lapTimes;

    private ScrollView nextTimesScroll;
    private ScrollView lapTimesScroll;

    private Button start, stop;

    public StopwatchView(TextView milliseconds, TextView secondsAndMinutes, TextView nextTimes,
                         TextView lapTimes, ScrollView nextTimesScroll, ScrollView lapTimesScroll,
                         Button start, Button stop) {
        this.milliseconds = milliseconds;
        this.secondsAndMinutes = secondsAndMinutes;
        this.nextTimes = nextTimes;
        this.lapTimes = lapTimes;
        this.nextTimesScroll = nextTimesScroll;
        this.lapTimesScroll = lapTimesScroll;
        this.start = start;
        this.stop = stop;
    }

    public TextView getMilliseconds() {
        return milliseconds;
    }

    public TextView getSecondsAndMinutes() {
        return secondsAndMinutes;
    }

    public TextView getNextTimes() {
        return nextTimes;
    }

    public TextView getLapTimes() {
        return lapTimes;
    }


    public ScrollView getNextTimesScroll() {
        return nextTimesScroll;
    }

    public ScrollView getLapTimesScroll() {
        return lapTimesScroll;
    }

    public void showStopButton() {
        start.setVisibility(View.INVISIBLE);
        stop.setVisibility(View.VISIBLE);
    }

    public void showStartButton() {
        start.setVisibility(View.VISIBLE);
        stop.setVisibility(View.GONE);
    }
}
