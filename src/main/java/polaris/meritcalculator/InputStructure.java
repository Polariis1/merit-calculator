package polaris.meritcalculator;

import java.util.List;
import java.util.Map;

public class InputStructure {
    private int extraMerit;
    private Map<String, List<Course>> courses;

    InputStructure() {}

    InputStructure(int extraMerit, Map<String, List<Course>> courses) {
        this.extraMerit = extraMerit;
        this.courses = courses;
    }

    public int getExtramerit() {
        return extraMerit;
    }
    public void setExtramerit(int extraMerit) {
        this.extraMerit = extraMerit;
    }

    public Map<String, List<Course>> getCourses() {
        return courses;
    }
    public void setCourses(Map<String, List<Course>> courses) {
        this.courses = courses;
    }
}
