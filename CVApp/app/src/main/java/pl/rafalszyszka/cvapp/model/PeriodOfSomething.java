package pl.rafalszyszka.cvapp.model;

/**
 * Created by Squier on 2016-07-02.
 */
public class PeriodOfSomething {

    private Period period;
    private String sthName;
    private String sthDetails;

    /**
     * Creates a duration of some event
     *
     * @param period     sth period
     * @param sthName    event's name
     * @param sthDetails event's details
     */
    public PeriodOfSomething(Period period, String sthName, String sthDetails) {
        this.period = period;
        this.sthName = sthName;
        this.sthDetails = sthDetails;
    }

    public Period getPeriod() {
        return period;
    }

    public void setPeriod(Period period) {
        this.period = period;
    }

    public String getSthName() {
        return sthName;
    }

    public void setSthName(String sthName) {
        this.sthName = sthName;
    }

    public String getSthDetails() {
        return sthDetails;
    }

    public void setSthDetails(String sthDetails) {
        this.sthDetails = sthDetails;
    }

    /**
     * Look Constructor
     *
     * @param period
     * @param sthName
     * @param sthDetails
     */
    public void setPeriodOfSomething(Period period, String sthName, String sthDetails) {
        this.sthName = sthName;
        this.period = period;
        this.sthDetails = sthDetails;
    }
}
