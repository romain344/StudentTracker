package com.studenttracker.model;

import java.util.Map;

public class Student {
    private String name;
    private Map<String, Double> materials;

    public Student(String name, Map<String, Double> materials) {
        this.name = name;
        this.materials = materials;
    }

    public Student(String name) {
        this(name, new java.util.HashMap<>());
    }

    public void addMaterial(String material, Double grade) {
        // this is a clase for add material and grade
        materials.put(material, grade);
    }

    public String getName() {
        // the clase for to recover the value for name
        return name;
    }

    public Map<String, Double> getMaterials() {
        return materials;
    }

    public double getAverage() {
        return materials.values().stream()
                .mapToDouble(Double::doubleValue)
                .average()
                .orElse(0.0);
    }

    @Override
    public String toString() {
        if (materials.isEmpty()) return name + " - Moyenne: --";
        return String.format("%s - Moyenne: %.2f", name, getAverage());
    }
}