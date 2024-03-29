package chap10;

import java.util.Arrays;

public class Sample15 {
    public static void main(String[] args) {
        Group<Pet> petGroup = new Group<>();
        petGroup.add(new Pet("앵무새"));
        petGroup.add(new Pet("십자매"));

        Group<Wild> wildGroup = new Group<>();
        wildGroup.add(new Wild("까치"));
        wildGroup.add(new Wild("비둘기"));

        System.out.println("애완조 ===");
        getAnimalList(petGroup);
        System.out.println("---");
        getPetList(petGroup);

        System.out.println();
        System.out.println("야생조 ===");
        getAnimalList(wildGroup);
    }

    public static void getAnimalList(Group<? extends Animal> group) {
        Object[] g = group.getGroup();
        for (int i = 0; i < g.length; i++) {
            Animal animal = (Animal) g[i];
            System.out.println(animal.getName());
        }
    }

    public static void getPetList(Group<? super Pet> group) {
        Object[] g = group.getGroup();
        for (int i = 0; i < g.length; i++) {
            Pet pet = (Pet) g[i];
            System.out.println(pet.getName());
        }
    }
}

class Group<G> {
    private int listCount = 0;

    private G[] group =  (G[]) new Object[listCount];

    public void add(G g) {
        group = Arrays.copyOf(group, ++listCount);
        group[listCount - 1] = g;
    }

    public G[] getGroup() {
        return group;
    }
}

class Animal {
    private String name;

    public Animal(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

class Pet extends Animal {

    public Pet(String name) {
        super(name);
    }
}

class Wild extends Animal {

    public Wild(String name) {
        super(name);
    }
}