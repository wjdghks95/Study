package chap12;

public class Sample07 {
    public static void main(String[] args) {
        CITY returnCity = CITY.valueOf(4);
        System.out.println(returnCity.getDestination());
    }
}

enum CITY {
    SEOUL("서울", 0), DAEJEON("대전", 1), DAEGU("대구", 2), PUSAN("부산", 3), JEJU("제주", 4), GWANGJU("광주", 5);

    private final String destination;
    private final int seq;

    CITY(String destination, int seq) {
        this.destination = destination;
        this.seq = seq;
    }

    public String getDestination() {
        return destination;
    }

    public static CITY valueOf(int selectNum) {
        CITY returnCity = null;
        for (CITY city : CITY.values()) {
            if (city.ordinal() == selectNum) {
                returnCity = city;
                break;
            }
        }
        return returnCity;
    }
}
