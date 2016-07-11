package pl.rafalszyszka.cvapp.model.sections;

/**
 * Created by Squier on 2016-07-02.
 */
public class ProfileSec {

    /**
     * A short description about some person
     */
    private String profile;

    public ProfileSec(String profile) {
        this.profile = profile;
    }

    /**
     * Change the profile
     *
     * @param newProfile new profile
     */
    public void editProfile(String newProfile) {
        profile = newProfile;
    }

    /**
     * Return person's profile
     *
     * @return persons profile
     */
    public String getProfile() {
        return profile;
    }
}
