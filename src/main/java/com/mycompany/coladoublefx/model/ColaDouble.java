
package com.mycompany.coladoublefx.model;

public class ColaDouble {

    private double[] datos;
    private int frente;
    private int fin;
    private int tamaño;

    public ColaDouble(int capacidad) {
        datos = new double[capacidad];
        frente = 0;
        fin = -1;
        tamaño = 0;
    }

    public boolean isEmpty() {
        return tamaño == 0;
    }

    public boolean isFull() {
        return tamaño == datos.length;
    }

    // INSERTAR AL FINAL
    public void encolarFinal(double valor) {
        if (isFull()) {
            System.out.println("Cola llena");
            return;
        }
        fin = (fin + 1) % datos.length;
        datos[fin] = valor;
        tamaño++;
    }

    // INSERTAR AL INICIO
    public void encolarInicio(double valor) {
        if (isFull()) {
            System.out.println("Cola llena");
            return;
        }
        frente = (frente - 1 + datos.length) % datos.length;
        datos[frente] = valor;
        tamaño++;
    }

    // ELIMINAR DEL INICIO
    public double desencolarInicio() {
        if (isEmpty()) {
            System.out.println("Cola vacía");
            return -1;
        }
        double valor = datos[frente];
        frente = (frente + 1) % datos.length;
        tamaño--;
        return valor;
    }

    // ELIMINAR DEL FINAL
    public double desencolarFinal() {
        if (isEmpty()) {
            System.out.println("Cola vacía");
            return -1;
        }
        double valor = datos[fin];
        fin = (fin - 1 + datos.length) % datos.length;
        tamaño--;
        return valor;
    }

    // VER FRENTE
    public double verFrente() {
        if (isEmpty()) {
            System.out.println("Cola vacía");
            return -1;
        }
        return datos[frente];
    }

    // VER FINAL
    public double verFinal() {
        if (isEmpty()) {
            System.out.println("Cola vacía");
            return -1;
        }
        return datos[fin];
    }

    // MOSTRAR CONTENIDO
    public void mostrar() {
        if (isEmpty()) {
            System.out.println("Cola vacía");
            return;
        }

        System.out.print("Cola doble: ");
        int index = frente;

        for (int i = 0; i < tamaño; i++) {
            System.out.print(datos[index] + "°C  ");
            index = (index + 1) % datos.length;
        }
        System.out.println();
    }
    
    public double[] getDatos() {
        return datos;
    }

    public int getFrente() {
        return frente;
    }

    public int getTamaño() {
        return tamaño;
    }

}
