package com.example.flowpane;

import javafx.application.Application;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class HelloApplication extends Application {

    @Override
    public void start(Stage stage) {
        // ------------------- FlowPane Horizontal -------------------
        FlowPane flowHorizontal = new FlowPane();
        flowHorizontal.setOrientation(Orientation.HORIZONTAL);
        flowHorizontal.setHgap(10);
        flowHorizontal.setVgap(10);
        flowHorizontal.setAlignment(Pos.TOP_LEFT);
        flowHorizontal.setPrefWrapLength(400); // ancho máximo antes de saltar a otra fila

        // Crear 5 botones horizontales
        for (int i = 1; i <= 5; i++) {
            Button btn = new Button("H-Botón " + i);
            btn.setPrefWidth(100);
            btn.setPrefHeight(30);

            // Evento: agrandar horizontalmente
            btn.setOnAction(e -> {
                if (btn.getPrefWidth() == 100) {
                    btn.setPrefWidth(200);
                } else {
                    btn.setPrefWidth(100);
                }
            });

            flowHorizontal.getChildren().add(btn);
        }

        // ------------------- FlowPane Vertical -------------------
        FlowPane flowVertical = new FlowPane();
        flowVertical.setOrientation(Orientation.VERTICAL);
        flowVertical.setHgap(10);
        flowVertical.setVgap(10);
        flowVertical.setAlignment(Pos.TOP_LEFT);
        flowVertical.setPrefWrapLength(200); // altura máxima antes de saltar a otra columna

        // Crear 5 botones verticales
        for (int i = 1; i <= 4; i++) {
            Button btn = new Button("V-Botón " + i);
            btn.setPrefWidth(100);
            btn.setPrefHeight(30);

            // Evento: agrandar verticalmente
            btn.setOnAction(e -> {
                if (btn.getPrefHeight() == 30) {
                    btn.setPrefHeight(80); // al agrandar, si supera prefWrapLength, salta columna
                } else {
                    btn.setPrefHeight(30);
                }
            });

            flowVertical.getChildren().add(btn);
        }

        // ------------------- Contenedor principal -------------------
        FlowPane root = new FlowPane();
        root.setOrientation(Orientation.VERTICAL);
        root.setVgap(20);
        root.getChildren().addAll(flowHorizontal, flowVertical);

        Scene scene = new Scene(root, 600, 400);
        stage.setTitle("FlowPane Horizontal y Vertical Interactivo");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
