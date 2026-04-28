package com.studenttracker.model;

import java.util.Map;

public class Student {
    private String name;
    private Map<String, Grade> materials;

    public Student(String name, Map<String, Grade> materials) {
        this.name = name;
        this.materials = materials;
    }

    public Student(String name) {
        this(name, new java.util.HashMap<>());
    }

    public void addMaterial(String material, double grade, double coefficient) {
        materials.put(material, new Grade(grade, coefficient));
    }

    public String getName() {
        return name;
    }

    public Map<String, Grade> getMaterials() {
        return materials;
    }

    public double getAverage() {
        if (materials.isEmpty()) return 0.0;
        double sumWeighted = materials.values().stream()
                .mapToDouble(g -> g.value * g.coefficient)
                .sum();
        double sumCoefficients = materials.values().stream()
                .mapToDouble(g -> g.coefficient)
                .sum();
        return sumWeighted / sumCoefficients;
    }

    @Override
    public String toString() {
        if (materials.isEmpty()) return name + " - Moyenne: --";
        return String.format("%s - Moyenne: %.2f", name, getAverage());
    }
}