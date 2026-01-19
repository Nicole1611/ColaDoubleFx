/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.coladoublefx.controller;

import com.mycompany.coladoublefx.model.ColaDouble;
import com.mycompany.coladoublefx.view.CanvaColaDouble;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;

import java.util.ArrayList;
import java.util.List;

public class ColaDoubleController {

    @FXML private TextField txtTemperatura;
    @FXML private Label lblEstado;
    @FXML private StackPane canvasPane;

    private ColaDouble cola;
    private CanvaColaDouble canvas;

    @FXML
    public void initialize() {
        cola = new ColaDouble(8);
        canvas = new CanvaColaDouble();
        canvasPane.getChildren().add(canvas);
        refreshCanvas();
    }

    // INSERTAR AL FINAL
    @FXML
    private void encolarFinal() {
        try {
            double temp = Double.parseDouble(txtTemperatura.getText());
            cola.encolarFinal(temp);
            lblEstado.setText("Insertado al final");
            refreshCanvas();
        } catch (NumberFormatException e) {
            lblEstado.setText("Valor inválido");
        }
        txtTemperatura.clear();
    }

    // INSERTAR AL INICIO
    @FXML
    private void encolarInicio() {
        try {
            double temp = Double.parseDouble(txtTemperatura.getText());
            cola.encolarInicio(temp);
            lblEstado.setText("Insertado al inicio");
            refreshCanvas();
        } catch (NumberFormatException e) {
            lblEstado.setText("Valor inválido");
        }
        txtTemperatura.clear();
    }

    // ELIMINAR DEL INICIO
    @FXML
    private void desencolarInicio() {
        if (cola.isEmpty()) {
            lblEstado.setText("Cola vacía");
            return;
        }
        double t = cola.desencolarInicio();
        lblEstado.setText("Eliminado del inicio: " + t + " °C");
        refreshCanvas();
    }

    // ELIMINAR DEL FINAL
    @FXML
    private void desencolarFinal() {
        if (cola.isEmpty()) {
            lblEstado.setText("Cola vacía");
            return;
        }
        double t = cola.desencolarFinal();
        lblEstado.setText("Eliminado del final: " + t + " °C");
        refreshCanvas();
    }

    @FXML
    private void verFrente() {
        lblEstado.setText(
            cola.isEmpty()
                ? "Cola vacía"
                : "Frente: " + cola.verFrente() + " °C"
        );
    }

    @FXML
    private void mostrarIsEmpty() {
        lblEstado.setText(
            cola.isEmpty() ? "Cola vacía" : "Cola con datos"
        );
    }

    private void refreshCanvas() {
        canvas.setValues(obtenerValores());
        canvas.render();
    }

    private List<Double> obtenerValores() {
        List<Double> lista = new ArrayList<>();
        double[] datos = cola.getDatos();
        int index = cola.getFrente();

        for (int i = 0; i < cola.getTamaño(); i++) {
            lista.add(datos[index]);
            index = (index + 1) % datos.length;
        }
        return lista;
    }
}
