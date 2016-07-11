package pl.rafalszyszka.cvapp.model;

import pl.rafalszyszka.cvapp.model.sections.CertificatesSec;
import pl.rafalszyszka.cvapp.model.sections.EducationSec;
import pl.rafalszyszka.cvapp.model.sections.InterestSec;
import pl.rafalszyszka.cvapp.model.sections.LanguagesSec;
import pl.rafalszyszka.cvapp.model.sections.ProfileSec;
import pl.rafalszyszka.cvapp.model.sections.SkillsSec;
import pl.rafalszyszka.cvapp.model.sections.WorkExperienceSec;

/**
 * Created by Squier on 2016-07-02.
 */
public class CurriculumVitae {

    private ProfileSec profile;
    private WorkExperienceSec workExperience;
    private EducationSec education;
    private CertificatesSec certificates;
    private LanguagesSec languages;
    private SkillsSec skills;
    private InterestSec interests;

    /**
     * Creates a CV instance
     *
     * @param profile        person's profile
     * @param workExperience person's work experience
     * @param education      person's education
     * @param certificates   person's certificates
     * @param languages      person's languages
     * @param skills         person's skills
     * @param interests      person's interests
     */
    public CurriculumVitae(ProfileSec profile, WorkExperienceSec workExperience,
                           EducationSec education, CertificatesSec certificates,
                           LanguagesSec languages, SkillsSec skills, InterestSec interests) {
        this.profile = profile;
        this.workExperience = workExperience;
        this.education = education;
        this.certificates = certificates;
        this.languages = languages;
        this.skills = skills;
        this.interests = interests;
    }

    public ProfileSec getProfile() {
        return profile;
    }

    public void setProfile(ProfileSec profile) {
        this.profile = profile;
    }

    public WorkExperienceSec getWorkExperience() {
        return workExperience;
    }

    public void setWorkExperience(WorkExperienceSec workExperience) {
        this.workExperience = workExperience;
    }

    public EducationSec getEducation() {
        return education;
    }

    public void setEducation(EducationSec education) {
        this.education = education;
    }

    public CertificatesSec getCertificates() {
        return certificates;
    }

    public void setCertificates(CertificatesSec certificates) {
        this.certificates = certificates;
    }

    public LanguagesSec getLanguages() {
        return languages;
    }

    public void setLanguages(LanguagesSec languages) {
        this.languages = languages;
    }

    public SkillsSec getSkills() {
        return skills;
    }

    public void setSkills(SkillsSec skills) {
        this.skills = skills;
    }

    public InterestSec getInterests() {
        return interests;
    }

    public void setInterests(InterestSec interests) {
        this.interests = interests;
    }
}
