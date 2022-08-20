package chap09.sample04;

public class Sample04 {
    public static void main(String[] args) {
        Pet cat = new Cat(false, 4);
        cat.run(getPetName(cat));
        Pet parrot = new Parrot(true, 2);
        parrot.run(getPetName(parrot));

        Parrot pr = (Parrot) parrot;
        pr.fly(getPetName(pr));
    }

    public static String getPetName(Pet pet) {
        String str = "";

        if (pet instanceof Cat) {
            str = "고양이";
        } else if (pet instanceof Parrot) {
            str = "앵무새";
        }

        return str;
    }
}
