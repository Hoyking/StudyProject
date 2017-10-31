package lesson4.home.entity;

import java.util.Objects;

public class NewsTag {

    private String name;

    public NewsTag() {}

    public NewsTag(String name) {
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
        NewsTag newsTag = (NewsTag) o;
        return Objects.equals(name, newsTag.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

}
