package pl.rafalszyszka.cvapp.model.sections;

import java.util.ArrayList;

/**
 * Created by Squier on 2016-07-02.
 */
public class SkillsSec {

    /**
     * Skill's description
     */
    private ArrayList<String> skills;

    /**
     * Creates skills section
     *
     * @param skills skills section
     */
    public SkillsSec(ArrayList<String> skills) {
        this.skills = skills;
    }

    /**
     * Add skill to skills section
     *
     * @param skill skill's description
     */
    public void addSkill(String skill) {
        skills.add(skill);
    }

    /**
     * Return skill by given index
     *
     * @param index index of skill
     * @return skill's description
     */
    public String getSkillByIndex(int index) {
        return skills.get(index);
    }

    public ArrayList<String> getSkills() {
        return skills;
    }

    public void setSkills(ArrayList<String> skills) {
        this.skills = skills;
    }
}
