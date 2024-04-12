package org.example.cuoiki_code_tutorial.View;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import static javafx.scene.text.TextAlignment.CENTER;

public class demo extends Application {
    ComboBox<String> dormComboBox = new ComboBox<>();
    ComboBox<String> mealPlanComboBox = new ComboBox<>();
    Label totalChargesLabel = new Label();
    Label dormSelected = new Label();
    Label mealSelected = new Label();

    @Override
    public void start(Stage stage) throws Exception {

        AnchorPane root = new AnchorPane();


        dormComboBox.getItems().addAll("Allen Hall", "Pike Hall", "Farthing Hall", "University Suites");


        mealPlanComboBox.getItems().addAll("7 meals per week", "14 meals per week", "Unlimited meals");


        dormSelected.setLayoutX(20);
        dormSelected.setLayoutY(20);
        dormSelected.setPrefWidth(200);
        dormSelected.setTextAlignment(CENTER);
        dormSelected.setText("Select a dormitory: ");

        dormComboBox.setLayoutX(150);
        dormComboBox.setLayoutY(20);
        dormComboBox.setPrefWidth(200);
        dormComboBox.getSelectionModel().select(0);


        mealSelected.setLayoutX(20);
        mealSelected.setLayoutY(50);
        mealSelected.setPrefWidth(200);
        mealSelected.setTextAlignment(CENTER);
        mealSelected.setText("Select a meal a plan: ");

        mealPlanComboBox.setLayoutX(150);
        mealPlanComboBox.setLayoutY(50);
        mealPlanComboBox.setPrefWidth(200);
        mealPlanComboBox.getSelectionModel().select(0);



        totalChargesLabel.setLayoutX(20);
        totalChargesLabel.setLayoutY(100);
        totalChargesLabel.setPrefWidth(200);
        totalChargesLabel.setTextAlignment(CENTER);





        dormComboBox.valueProperty().addListener((observable, oldValue, newValue) -> updateTotalCharges());
        mealPlanComboBox.valueProperty().addListener((observable, oldValue, newValue) -> updateTotalCharges());

        root.getChildren().addAll(dormComboBox, mealPlanComboBox, totalChargesLabel, mealSelected, dormSelected);

        Scene scene = new Scene(root, 400, 150);
        stage.setScene(scene);
        stage.setTitle("Dorm and Meal Plan Calculator");
        stage.show();
    }

    private void updateTotalCharges() {

        String selectedDorm = dormComboBox.getValue();
        int dormPrice = 0;
        switch (selectedDorm) {
            case "Allen Hall":
                dormPrice = 1800;
                break;
            case "Pike Hall":
                dormPrice = 2200;
                break;
            case "Farthing Hall":
                dormPrice = 2800;
                break;
            case "University Suites":
                dormPrice = 3000;
                break;
        }


        String selectedMealPlan = mealPlanComboBox.getValue();
        int mealPlanPrice = 0;
        switch (selectedMealPlan) {
            case "7 meals per week":
                mealPlanPrice = 600;
                break;
            case "14 meals per week":
                mealPlanPrice = 1100;
                break;
            case "Unlimited meals":
                mealPlanPrice = 1800;
                break;
        }


        int totalCharges = dormPrice + mealPlanPrice;


        totalChargesLabel.setText("Total Charges: $" + totalCharges);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
