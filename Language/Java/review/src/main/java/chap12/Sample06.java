package chap12;

public class Sample06 {
    public static void main(String[] args) {
        System.out.println(BIRD.SPARROW.getName());
        BIRD2 bird2 = new BIRD2("앵무새", 27);
        System.out.println(bird2.getName());
        System.out.println(BIRD3.SPARROW.getName());
    }
}

enum BIRD {
    SPARROW("참새", 33), PARROT("앵무새", 27);

    private final String name;
    private final int count;

    BIRD(String name, int count) {
        this.name = name;
        this.count = count;
    }

    public String getName() {
        return name;
    }

    public int getCount() {
        return count;
    }
}

class BIRD2 {
    private String name;
    private int count;

    public BIRD2(String name, int count) {
        this.name = name;
        this.count = count;
    }

    public String getName() {
        return name;
    }

    public int getCount() {
        return count;
    }
}

class BIRD3 {
    static class SPARROW {
        private static String name = "참새";
        private static int count = 33;

        public SPARROW(String name, int count) {
            this.name = name;
            this.count = count;
        }

        public static String getName() {
            return name;
        }

        public static int getCount() {
            return count;
        }
    }

    static class PARROT {
        private static String name = "앵무새";
        private static int count = 27;

        public PARROT(String name, int count) {
            this.name = name;
            this.count = count;
        }

        public static String getName() {
            return name;
        }

        public static int getCount() {
            return count;
        }
    }
}