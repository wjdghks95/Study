package chap12;

public class Sample05 {
    public static void main(String[] args) {
        FLOWER flower = FLOWER.ROSE;
        System.out.println(flower.getName());
        NewColor color = NewColor.RED;
        System.out.println(color.getName());
    }
}

enum FLOWER {
    SUNFLOWER("sunflower"), ROSE("rose");

    private final String name;

    FLOWER(String flowerName) {
        this.name = flowerName;
    }

    public String getName() {
        return name;
    }
}

enum NewColor {
    RED("red"), BLUE("blue"), ORANGE("orange");

    private final String name;

    NewColor(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}