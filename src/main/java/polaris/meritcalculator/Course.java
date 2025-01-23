package polaris.meritcalculator;

public class Course {
    public int points;
    public char grade;

    Course() {}
    Course(int points, char grade) {
        this.points = points;
        this.grade = grade;
    }

    public void setPoints(int points) {
        this.points = points;
    }
    public void setGrade(char grade) {
        this.grade = grade;
    }

    public int getPoints() {
        return points;
    }
    public char getGrade() {
        return grade;
    }

}
