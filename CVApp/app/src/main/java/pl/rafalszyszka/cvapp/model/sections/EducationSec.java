package pl.rafalszyszka.cvapp.model.sections;

import java.util.ArrayList;

import pl.rafalszyszka.cvapp.model.Period;
import pl.rafalszyszka.cvapp.model.PeriodOfSomething;

/**
 * Created by Squier on 2016-07-02.
 */
public class EducationSec {

    /**
     * Info about school:
     * schools name
     * duration of education
     * school details eg: faculty
     */
    private ArrayList<PeriodOfSomething> educationPeriods;

    /**
     * Creates empty object
     */
    public EducationSec() {
    }

    /**
     * Creates Education section for CV
     *
     * @param educationPeriods array for education periods
     */
    public EducationSec(ArrayList<PeriodOfSomething> educationPeriods) {
        this.educationPeriods = educationPeriods;
    }

    /**
     * Add education period to education section
     *
     * @param educationPeriod school's description
     */
    public void addEducationPeriod(PeriodOfSomething educationPeriod) {
        educationPeriods.add(educationPeriod);
    }

    /**
     * Add education period to education section
     *
     * @param educationPeriod period
     * @param schoolName      schools name
     * @param schoolDetails   schools details
     */
    public void addEducationPeriod(Period educationPeriod, String schoolName, String schoolDetails) {
        educationPeriods.add(new PeriodOfSomething(educationPeriod, schoolName, schoolDetails));
    }

    /**
     * Returns single education period description
     *
     * @param index education's period index
     * @return schools description
     */
    public PeriodOfSomething getEducationPeriodByIndex(int index) {
        return educationPeriods.get(index);
    }
}
