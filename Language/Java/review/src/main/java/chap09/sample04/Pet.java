package chap09.sample04;

public abstract class Pet {
    private boolean wing;
    private int legCount;

    public Pet(boolean wing, int legCount) {
        this.wing = wing;
        this.legCount = legCount;
    }

    public String isWing() {
        String str;
        if (this.wing) {
            str = "날 수 있다";
        }  else {
            str = "날 수 없다";
        }
        return str;
    }

    public int getLegCount() {
        return legCount;
    }

    public abstract void run(String name);
}
