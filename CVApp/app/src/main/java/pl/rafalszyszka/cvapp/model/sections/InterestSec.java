package pl.rafalszyszka.cvapp.model.sections;

import java.util.ArrayList;

/**
 * Created by Squier on 2016-07-02.
 */
public class InterestSec {

    private ArrayList<String> interests;

    /**
     * Creates interests section for CV
     *
     * @param interests interests array
     */
    public InterestSec(ArrayList<String> interests) {
        this.interests = interests;
    }

    /**
     * Add interest to interests section
     *
     * @param interest interest description
     */
    public void addInterest(String interest) {
        interests.add(interest);
    }

    /**
     * Return interest description by given index
     *
     * @param index index of interest
     * @return interest's description
     */
    public String getInterestByIndex(int index) {
        return interests.get(index);
    }

    public ArrayList<String> getInterests() {
        return interests;
    }

    public void setInterests(ArrayList<String> interests) {
        this.interests = interests;
    }
}
