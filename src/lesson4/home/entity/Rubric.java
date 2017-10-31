package lesson4.home.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Rubric {

    private String name;
    private List<Rubric> subrubrics;

    public Rubric() {
        subrubrics = new ArrayList<>();
    }

    public Rubric(String name) {
        this.name = name;
        subrubrics = new ArrayList<>();
    }

    public boolean hasSubrubrics() {
        return subrubrics.size() > 0;
    }

    public List<Rubric> getSubrubrics() {
        return subrubrics;
    }

    public void addSubrubric(Rubric rubric) {
        subrubrics.add(rubric);
    }

    public void removeRubric(Rubric rubric) {
        subrubrics.remove(rubric);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rubric rubric = (Rubric) o;
        return Objects.equals(name, rubric.name);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }
}
