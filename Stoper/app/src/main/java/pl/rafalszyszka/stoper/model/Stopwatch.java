package pl.rafalszyszka.stoper.model;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * Created by Squier on 2016-07-05.
 */
public class Stopwatch implements Serializable {

    private long start;
    private long stop;
    private long prevLapTime;
    private int rate;
    private int lapCounter;
    private int nextCounter;
    private boolean running;
    private boolean initial;

    public Stopwatch() {
        start = 0;
        stop = 0;
        prevLapTime = 0;
        lapCounter = 0;
        nextCounter = 0;
        rate = 0;
        running = false;
        initial = true;
    }

    public int incrementNextCounter() {
        return ++nextCounter;
    }

    public void start() {
        start = System.currentTimeMillis();
        running = true;
    }

    public void stop() {
        stop = System.currentTimeMillis();
        running = false;
    }

    public long getTime() {
        return System.currentTimeMillis() - getStart();
    }

    public long getStart() {
        return start;
    }

    public long getStop() {
        return stop;
    }

    public boolean isRunning() {
        return running;
    }

    public long getElapsed() {
        return stop - start;
    }

    public void setStart(long start) {
        this.start = start;
    }

    public void setStop(long stop) {
        this.stop = stop;
    }

    public void setRunning(boolean running) {
        this.running = running;
    }

    public boolean isInitial() {
        return initial;
    }

    public void setInitial(boolean initial) {
        this.initial = initial;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    public long getPrevLapTime() {
        return prevLapTime;
    }

    public void setPrevLapTime(long prevLapTime) {
        this.prevLapTime = prevLapTime;
    }

    public int getLapCounter() {
        return lapCounter;
    }

    public void setLapCounter(int lapCounter) {
        this.lapCounter = lapCounter;
    }

    public int getNextCounter() {
        return nextCounter;
    }

    public void setNextCounter(int nextCounter) {
        this.nextCounter = nextCounter;
    }

    public int incrementLapCounter() {
        return ++lapCounter;
    }
}
