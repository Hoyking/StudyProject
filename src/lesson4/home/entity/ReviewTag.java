package lesson4.home.entity;

import java.util.Objects;

public class ReviewTag {

    private String name;

    public ReviewTag() {}

    public ReviewTag(String name) {
        this.name = name;
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
        ReviewTag reviewTag = (ReviewTag) o;
        return Objects.equals(name, reviewTag.name);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

}
