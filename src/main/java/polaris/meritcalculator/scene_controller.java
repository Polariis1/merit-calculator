package polaris.meritcalculator;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class scene_controller {

    // Scene Controll:
    private Parent root;
    private Main main;

    public void setMain(Main main) {
        this.main = main;
    }
    public void setRoot(Parent root) {
        this.root = root;
    }

    public void initialize() {
        System.out.println("controller initialized");
        defaultValues();
    }

    @FXML TextField courseInputTextField; @FXML ComboBox<Integer> pointsComboBox; // -32,768 to 32,767
    @FXML ComboBox<Character> gradeComboBox; @FXML ComboBox<Integer> extraMeritComboBox; // -128 to 127

    // Populating controls with default values.
    public void defaultValues() {

        // Adding points; 50, 100, 150 etc.
        ObservableList<Integer> pointsValues =
                FXCollections.observableArrayList(
                        50, 100, 150, 200
                );
        pointsComboBox.setItems(pointsValues);

        // Adding Grades
        ObservableList<Character> gradeValues =
                FXCollections.observableArrayList(
                        'A', 'B', 'C', 'D', 'E', 'F'
                );
        gradeComboBox.setItems(gradeValues);

    }


    public void addCourse() {

        ArrayList<Course> coursesInfo = new ArrayList<>();

        String courseName = courseInputTextField.getText();
        Integer points = pointsComboBox.getValue();
        Character grade = gradeComboBox.getValue();
        Integer extraMerit = 2;

        if (courseName == null || courseName.isBlank()) {
            System.err.println("Course name is required!");
            return;
        }

        if (points == null || grade == null || extraMerit == null) {
            System.err.println("Please select a value for all combo boxes.");
            return;
        }

        coursesInfo.add(new Course(courseName, points, grade, extraMerit));

        for (Course course : coursesInfo) {
            System.out.println(
                    "Course "+ courseName + " : points " + points + "\n  grade " + grade + "\n   extra merit " + extraMerit
            );
        }

    }

    public void extraMerit() {}




}