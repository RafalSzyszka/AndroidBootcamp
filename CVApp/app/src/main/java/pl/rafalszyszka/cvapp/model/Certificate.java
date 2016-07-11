package pl.rafalszyszka.cvapp.model;

import java.util.Date;

/**
 * Created by Squier on 2016-07-02.
 */
public class Certificate {

    private Date date;
    private String description;

    /**
     * Creates a certificate
     *
     * @param date        when certificate was earned
     * @param description few words about certificate
     */
    public Certificate(Date date, String description) {
        this.date = date;
        this.description = description;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
