package sample;

import javafx.animation.FadeTransition;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

import javax.swing.*;


public class Main extends Application {


    @Override
    public void start(Stage primaryStage) throws Exception{
        //Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("ListView and Rectangle(FadeTransition)"); // заголовок формы

        // наш Лист(список)
        ListView<Double> listView = new ListView<>(); // состоит из Double
        // поэтому добавляем коллекцию дробных значений
        ObservableList<Double> items = FXCollections.observableArrayList(
                0.0, 0.02, 0.04, 0.06, 0.08,
                0.1, 0.12, 0.14, 0.16, 0.18,
                0.2, 0.22, 0.24, 0.26, 0.28,
                0.3, 0.32, 0.34, 0.36, 0.38,
                0.4, 0.42, 0.44, 0.46, 0.48,
                0.5, 0.52, 0.54, 0.56, 0.58,   // проще сделать через цикл, да балбес (Т.Т)
                0.6, 0.62, 0.64, 0.66, 0.68,
                0.7, 0.72, 0.74, 0.76, 0.78,
                0.8, 0.82, 0.84, 0.86, 0.88,
                0.9, 0.92, 0.94, 0.96, 0.98,
                1.0
        );
        listView.setItems(items); // и запихиваем коллекцию в наш лист
        listView.setPrefSize(100,400); // задаём рамеры

        // квадрат
        Rectangle rectangle = new Rectangle(400, 400, Color.DARKBLUE);
        rectangle.setTranslateX(100);

        //любда вырожение, действие на выбор в списке
        listView.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            FadeTransition ft = new FadeTransition(Duration.seconds(1.5), rectangle); // прозрачность с анимацией, продолжительность и объект над которым происходит анимация
            if(oldValue==null){ // если предыдущее значение равно null
                ft.setFromValue(1); // поэтому оно равно 1
            } else {
                ft.setFromValue(oldValue.doubleValue()); // предыдущее значение
            }
            ft.setToValue(newValue.doubleValue()); // до какой степени должно измениться
            ft.play(); // начать анимацию
        });

        //добавление панели
        Pane root = new Pane();
        root.getChildren().addAll(listView, rectangle);
        // добавление на сцены | на форму
        Scene scene = new Scene(root, 500, 400);
        primaryStage.setScene(scene);  // размер формы и сцена
        primaryStage.show(); // отобразить
    }


    public static void main(String[] args) {
        launch(args);
    }
}