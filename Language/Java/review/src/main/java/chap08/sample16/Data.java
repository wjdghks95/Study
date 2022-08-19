package chap08.sample16;

import java.util.Objects;

public class Data {
    private String name;

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
        Data data = (Data) o;
        return Objects.equals(name, data.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
