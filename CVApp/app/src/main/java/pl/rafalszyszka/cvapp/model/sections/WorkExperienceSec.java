package pl.rafalszyszka.cvapp.model.sections;

import java.util.ArrayList;

import pl.rafalszyszka.cvapp.model.Period;
import pl.rafalszyszka.cvapp.model.PeriodOfSomething;

/**
 * Created by Squier on 2016-07-02.
 */
public class WorkExperienceSec {

    /**
     * Info about jobs
     * job type
     * duration of work
     * position's details
     */
    private ArrayList<PeriodOfSomething> jobPeriods;

    public WorkExperienceSec() {
    }

    /**
     * Creates Work Experience section for CV
     *
     * @param jobPeriods
     */
    public WorkExperienceSec(ArrayList<PeriodOfSomething> jobPeriods) {
        this.jobPeriods = jobPeriods;
    }

    /**
     * Add a job to work experience section
     *
     * @param jobPeriod
     */
    public void addJobPeriod(PeriodOfSomething jobPeriod) {
        jobPeriods.add(jobPeriod);
    }

    /**
     * Add a job to work experience section
     *
     * @param jobPeriod  job's duration
     * @param jobType    job type/name
     * @param jobDetails job's details
     */
    public void addJobPeriod(Period jobPeriod, String jobType, String jobDetails) {
        jobPeriods.add(new PeriodOfSomething(jobPeriod, jobType, jobDetails));
    }

    /**
     * Returns single job description by given index
     *
     * @param index job's index
     * @return job's description
     */
    public PeriodOfSomething getJobPeriodByIndex(int index) {
        return jobPeriods.get(index);
    }

    public ArrayList<PeriodOfSomething> getJobPeriods() {
        return jobPeriods;
    }

    public void setJobPeriods(ArrayList<PeriodOfSomething> jobPeriods) {
        this.jobPeriods = jobPeriods;
    }
}
