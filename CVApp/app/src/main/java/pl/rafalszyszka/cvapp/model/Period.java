package pl.rafalszyszka.cvapp.model;

import java.util.Date;

/**
 * Created by Squier on 2016-07-02.
 */
public class Period {

    private Date start;     //When sth started
    private Date end;       //When sth ended

    public Period(Date start, Date end) {
        this.start = start;
        this.end = end;
    }

    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    public Date getEnd() {
        return end;
    }

    public void setEnd(Date end) {
        this.end = end;
    }
}
