package polaris.meritcalculator;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

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

    public static final Path jsonFilePath = Path.of("src/main/java/polaris/meritcalculator/data.json");

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

        coursesInfo.add(new Course(points, grade));

        for (Course course : coursesInfo) {
            System.out.println(
                    "Course "+ courseName + " : points " + points + "\n  grade " + grade + "\n   extra merit " + extraMerit
            );
        }

    }

    public void extraMerit() {}


    /*public void checkForJsonData() throws IOException {
        System.out.println("checkForJsonData() called");

        String existingData = readFromJsonFile();

        if (existingData != null) {
            System.out.println("there is data in file!");
            existingData.addAll(mapList);
            mapList.clear();
            mapList.addAll(existingData);
        }
    }*/

/*
    Map<String, String> questionData = new HashMap<>();
    public void addQuestion() throws IOException {
        System.out.println("addQuestion() called");

        questionData = new HashMap<>();
        questionData.put("question", addQuestionTextField.getText().toLowerCase());
        questionData.put("answer", addAnswerTextField.getText().toLowerCase());

        // Clear current list of questions to prevent duplicate questions getting added
        mapList.clear();
        mapList.add(questionData);

        writeToJsonFile(mapList); // Add question & answer to JSON file
        questionsList(); // Updates side menu used for questions.
    }

    public void checkForJsonData() throws IOException {
        System.out.println("checkForJsonData() called");

        List<Map<String, String>> existingData = readFromJsonFile();

        if (existingData != null) {
            System.out.println("there is data in file!");
            existingData.addAll(mapList);
            mapList.clear();
            mapList.addAll(existingData);
        }
    }*/


    public void writeToJsonFile(String dataToWrite) throws IOException {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        readFromJsonFile();

        // Converts data to JSON
        String jsonData = gson.toJson(dataToWrite);

        // Writes the JSON data to a file
        try (FileWriter writer = new FileWriter(String.valueOf(jsonFilePath))) {
            writer.write("{\n\"data\":"+ " " + jsonData + "\n}");
        }
    }
    @FXML
    TextField summaryTextField;

    public void readFromJsonFile() throws IOException {
        File file = new File(String.valueOf(jsonFilePath));
        if (!file.exists()) {
            System.err.println("File does not exist");
            return;
        }

        String jsonContent = Files.readString(jsonFilePath);
        System.out.println("JSON Content: " + jsonContent);

        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        // Deserialize JSON to Java object
        InputStructure input = gson.fromJson(jsonContent, InputStructure.class);

        // Access data
        System.out.println("Extra Merit: " + input.getExtramerit());
        input.getCourses().forEach((key, value) -> {
            value.forEach(course -> {
                System.out.println("Course: " + key);
                System.out.println("Points: " + course.getPoints());
                System.out.println("Grade: " + course.getGrade());
            });
        });
    }



    //Type type = new TypeToken<Map<String, List<Map<String, String>>>>() {}.getType();
        //Map<String, List<Map<String, String>>> existingData = gson.fromJson(br, type);



    }



}