package polaris.meritcalculator;

public class Course {
    public String courseName;
    public int points;
    public char grade;
    public int extraMerit;

    Course() {}
    Course(String course, int points, char grade, int extraMerit) {
        this.courseName = course;
        this.points = points;
        this.grade = grade;
        this.extraMerit = extraMerit;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }
    public void setPoints(int points) {
        this.points = points;
    }
    public void setGrade(char grade) {
        this.grade = grade;
    }
    public void setExtraMerit(int extraMerit) {
        this.extraMerit = extraMerit;
    }


    public String getCourseName() {
        return courseName;
    }
    public int getPoints() {
        return points;
    }
    public char getGrade() {
        return grade;
    }
    public int getExtraMerit() {
        return extraMerit;
    }


}
