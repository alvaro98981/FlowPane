package com.example.flowpane;

import javafx.application.Application;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class HelloApplication extends Application {

    @Override
    public void start(Stage stage) {
        // ------------------- Label y FlowPane Horizontal -------------------
        Label labelHorizontal = new Label("FlowPane Horizontal - Haz clic en un botón para agrandarlo");
        labelHorizontal.setFont(Font.font("Arial", 16));
        labelHorizontal.setTextFill(Color.DARKBLUE);

        FlowPane flowHorizontal = new FlowPane();
        flowHorizontal.setOrientation(Orientation.HORIZONTAL);
        flowHorizontal.setHgap(10);
        flowHorizontal.setVgap(10);
        flowHorizontal.setAlignment(Pos.TOP_LEFT);
        flowHorizontal.setPrefWrapLength(400); // ancho máximo antes de saltar a otra fila

        for (int i = 1; i <= 5; i++) {
            Button btn = new Button("H-Botón " + i);
            btn.setPrefWidth(100);
            btn.setPrefHeight(40);
            btn.setStyle("-fx-background-color: lightblue; -fx-border-color: darkblue; -fx-font-weight: bold;");

            btn.setOnAction(e -> {
                if (btn.getPrefWidth() == 100) {
                    btn.setPrefWidth(200); // agrandar
                } else {
                    btn.setPrefWidth(100); // volver a tamaño original
                }
            });

            flowHorizontal.getChildren().add(btn);
        }

        // ------------------- Label y FlowPane Vertical -------------------
        Label labelVertical = new Label("FlowPane Vertical - Haz clic en un botón para agrandarlo");
        labelVertical.setFont(Font.font("Arial", 16));
        labelVertical.setTextFill(Color.DARKGREEN);

        FlowPane flowVertical = new FlowPane();
        flowVertical.setOrientation(Orientation.VERTICAL);
        flowVertical.setHgap(10);
        flowVertical.setVgap(10);
        flowVertical.setAlignment(Pos.TOP_LEFT);
        flowVertical.setPrefWrapLength(200); // altura máxima antes de saltar a otra columna

        for (int i = 1; i <= 5; i++) {
            Button btn = new Button("V-Botón " + i);
            btn.setPrefWidth(120);
            btn.setPrefHeight(40);
            btn.setStyle("-fx-background-color: lightgreen; -fx-border-color: darkgreen; -fx-font-weight: bold;");

            btn.setOnAction(e -> {
                if (btn.getPrefHeight() == 40) {
                    btn.setPrefHeight(80); // agrandar verticalmente
                } else {
                    btn.setPrefHeight(40); // volver a tamaño original
                }
            });

            flowVertical.getChildren().add(btn);
        }

        // ------------------- Contenedor principal -------------------
        VBox root = new VBox(20, labelHorizontal, flowHorizontal, labelVertical, flowVertical);
        root.setAlignment(Pos.CENTER);
        root.setStyle("-fx-padding: 20; -fx-background-color: #f0f8ff;"); // fondo agradable

        Scene scene = new Scene(root, 700, 600);
        stage.setTitle("FlowPane Interactivo y Estético");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
