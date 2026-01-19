/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.coladoublefx.view;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

import java.util.Collections;
import java.util.List;

public class CanvaColaDouble extends Canvas {

    private List<Double> values = Collections.emptyList();

    private final double margin = 24;
    private final double nodeW = 110;
    private final double nodeH = 48;
    private final double spacing = 36;
    private final double baseY = 110;

    public CanvaColaDouble() {
        setWidth(900);
        setHeight(260);
    }

    public void setValues(List<Double> values) {
        this.values = values == null ? Collections.emptyList() : values;
    }

    public void render() {
        int n = values.size();

        setWidth(Math.max(900,
                margin * 2 + n * nodeW + Math.max(0, n - 1) * spacing + 200));

        GraphicsContext g = getGraphicsContext2D();
        g.setFill(Color.WHITE);
        g.fillRect(0, 0, getWidth(), getHeight());

        g.setFill(Color.BLACK);
        g.setFont(Font.font(16));
        g.fillText("Cola Doble (Deque)", margin, 28);

        g.setFont(Font.font(12));
        g.setFill(Color.GRAY);
        g.fillText("Inicio ⇄ Final | Inserción y eliminación por ambos extremos", margin, 48);

        if (n == 0) {
            g.setFont(Font.font(14));
            g.setFill(Color.BLACK);
            g.fillText("Cola vacía", margin, baseY);
            return;
        }

        drawFrente(g);

        double x = margin;
        for (int i = 0; i < n; i++) {
            drawNode(g, x, baseY, values.get(i) + " °C");

            if (i < n - 1) {
                double midY = baseY + nodeH / 2;
                double x2 = x + nodeW + spacing;

                g.setStroke(Color.DARKGRAY);
                g.setLineWidth(2);
                g.strokeLine(x + nodeW, midY, x2, midY);
                arrowHead(g, x + nodeW, midY, x2, midY);
            }

            if (i == n - 1) {
                g.setFont(Font.font(12));
                g.setFill(Color.BLACK);
                g.fillText("Final", x + 35, baseY + nodeH + 22);
            }

            x += nodeW + spacing;
        }
    }

    private void drawFrente(GraphicsContext g) {
        double fx = margin;
        double fy = baseY - 45;

        g.setFill(Color.DARKGRAY);
        g.setFont(Font.font(12));
        g.fillText("Inicio", fx, fy);

        g.setStroke(Color.DARKGRAY);
        g.setLineWidth(2);
        g.strokeLine(fx + 25, fy + 6, fx + 25, baseY - 8);
        arrowHead(g, fx + 25, baseY - 8, fx + 25, baseY);
    }

    private void drawNode(GraphicsContext g, double x, double y, String text) {
        g.setStroke(Color.BLACK);
        g.setLineWidth(2);
        g.strokeRoundRect(x, y, nodeW, nodeH, 16, 16);

        g.setFill(Color.BLACK);
        g.setFont(Font.font(13));
        g.fillText(text, x + 18, y + 30);
    }

    private void arrowHead(GraphicsContext g, double x1, double y1, double x2, double y2) {
        double angle = Math.atan2(y2 - y1, x2 - x1);
        double len = 10;

        g.strokeLine(x2, y2,
                x2 - len * Math.cos(angle - Math.PI / 8),
                y2 - len * Math.sin(angle - Math.PI / 8));

        g.strokeLine(x2, y2,
                x2 - len * Math.cos(angle + Math.PI / 8),
                y2 - len * Math.sin(angle + Math.PI / 8));
    }
}
