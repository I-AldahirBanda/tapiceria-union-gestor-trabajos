package com.tapiceria.union;

import com.tapiceria.union.model.Trabajo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static final Scanner sc = new Scanner(System.in);
    private static final List<Trabajo> trabajos = new ArrayList<>();
    private static int nextId = 1;

    public static void main(String[] args) {
        System.out.println("Tapicería UNIÓN - Gestor de Trabajos (Beta)");
        loopMenu();
    }

    private static void loopMenu() {
        while (true) {
            System.out.println("\n===== MENÚ =====");
            System.out.println("1) Nuevo trabajo");
            System.out.println("2) Listar trabajos");
            System.out.println("3) Cambiar estado");
            System.out.println("4) Eliminar trabajo");
            System.out.println("0) Salir");
            System.out.print("Opción: ");
            String op = sc.nextLine().trim();

            switch (op) {
                case "1": crearTrabajo(); break;
                case "2": listarTrabajos(); break;
                case "3": cambiarEstado(); break;
                case "4": eliminarTrabajo(); break;
                case "0": System.out.println("Adiós."); return;
                default: System.out.println("Opción inválida.");
            }
        }
    }

    private static void crearTrabajo() {
        try {
            System.out.print("Cliente: ");
            String cliente = sc.nextLine().trim();
            System.out.print("Tipo de mueble: ");
            String tipo = sc.nextLine().trim();
            System.out.print("Fecha entrega (YYYY-MM-DD): ");
            String fecha = sc.nextLine().trim();

            if (cliente.isEmpty() || tipo.isEmpty() || !fecha.matches("\\d{4}-\\d{2}-\\d{2}")) {
                System.out.println("Datos inválidos. Intenta de nuevo.");
                return;
            }

            Trabajo t = new Trabajo(nextId++, cliente, tipo, fecha, "Pendiente");
            trabajos.add(t);
            System.out.println("Creado: " + t);
        } catch (Exception e) {
            System.out.println("Error al crear trabajo: " + e.getMessage());
        }
    }

    private static void listarTrabajos() {
        if (trabajos.isEmpty()) {
            System.out.println("No hay trabajos registrados.");
            return;
        }
        System.out.println("Listado de trabajos:");
        trabajos.forEach(System.out::println);
    }

    private static void cambiarEstado() {
        System.out.print("ID a actualizar: ");
        String s = sc.nextLine().trim();
        int id = parseId(s);
        if (id < 0) return;

        Trabajo t = findById(id);
        if (t == null) {
            System.out.println("No encontrado.");
            return;
        }
        System.out.print("Nuevo estado (Pendiente|En proceso|Terminado): ");
        String estado = sc.nextLine().trim();
        if (!estado.matches("Pendiente|En proceso|Terminado")) {
            System.out.println("Estado inválido.");
            return;
        }
        t.setEstado(estado);
        System.out.println("Actualizado: " + t);
    }

    private static void eliminarTrabajo() {
        System.out.print("ID a eliminar: ");
        String s = sc.nextLine().trim();
        int id = parseId(s);
        if (id < 0) return;

        Trabajo t = findById(id);
        if (t == null) {
            System.out.println("No encontrado.");
            return;
        }
        trabajos.remove(t);
        System.out.println("Eliminado: " + t);
    }

    private static int parseId(String s) {
        try { return Integer.parseInt(s); }
        catch (NumberFormatException e) {
            System.out.println("ID inválido.");
            return -1;
        }
    }

    private static Trabajo findById(int id) {
        return trabajos.stream().filter(x -> x.getId() == id).findFirst().orElse(null);
    }
}
