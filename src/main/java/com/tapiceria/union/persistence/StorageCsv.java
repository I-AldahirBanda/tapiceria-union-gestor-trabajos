package com.tapiceria.union.persistence;

import com.tapiceria.union.model.Trabajo;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;

public class StorageCsv {
    private final Path file;

    public StorageCsv(String path) {
        this.file = Paths.get(path);
    }

    public void ensureFile() throws IOException {
        if (file.getParent() != null) {
            Files.createDirectories(file.getParent());
        }
        if (Files.notExists(file)) {
            Files.createFile(file);
        }
    }

    public List<Trabajo> load() throws IOException {
        ensureFile();
        List<String> lines = Files.readAllLines(file, StandardCharsets.UTF_8);
        List<Trabajo> list = new ArrayList<>();
        for (String l : lines) {
            if (l == null || l.isBlank()) continue;
            // Formato: id;cliente;tipo;fecha;estado
            String[] p = l.split(";", -1);
            if (p.length < 5) continue;
            try {
                int id = Integer.parseInt(p[0]);
                String cliente = p[1];
                String tipo = p[2];
                String fecha = p[3];
                String estado = p[4];
                list.add(new Trabajo(id, cliente, tipo, fecha, estado));
            } catch (NumberFormatException e) {
                // línea corrupta: la ignoramos
            }
        }
        return list;
    }

    public void save(List<Trabajo> list) throws IOException {
        ensureFile();
        List<String> lines = new ArrayList<>();
        for (Trabajo t : list) {
            String row = t.getId() + ";" + t.getCliente() + ";" + t.getTipoMueble() + ";" +
                    t.getFechaEntrega() + ";" + t.getEstado();
            lines.add(row);
        }
        Files.write(file, lines, StandardCharsets.UTF_8, StandardOpenOption.TRUNCATE_EXISTING);
    }
}
