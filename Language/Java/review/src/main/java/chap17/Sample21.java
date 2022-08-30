package chap17;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;

public class Sample21 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        System.out.println(Arrays.stream(arr).count());
        System.out.println(Arrays.stream(arr).min().getAsInt());
        System.out.println(Arrays.stream(arr).max().getAsInt());
        System.out.println(Arrays.stream(arr).sum());
        System.out.println(Arrays.stream(arr).average().getAsDouble());

        List<Score> scores = Arrays.asList(
                new Score("빵형", 61, 71, 81, 61),
                new Score("타노스", 62, 72, 82, 52),
                new Score("상도", 100, 100, 61, 92)
        );
        Optional<Score> min = scores.stream()
                .min(Comparator.comparing(Score::getEng));
        Optional<Score> max = scores.stream().max(Comparator.comparing(Score::getEng));
        System.out.println(min.get().toString());
        System.out.println(max.get().toString());
    }
}

class Score {
    private String name;
    private int kor;
    private int eng;
    private int mat;
    private int msg;

    public Score(String name, int kor, int eng, int mat, int msg) {
        this.name = name;
        this.kor = kor;
        this.eng = eng;
        this.mat = mat;
        this.msg = msg;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getKor() {
        return kor;
    }

    public void setKor(int kor) {
        this.kor = kor;
    }

    public int getEng() {
        return eng;
    }

    public void setEng(int eng) {
        this.eng = eng;
    }

    public int getMat() {
        return mat;
    }

    public void setMat(int mat) {
        this.mat = mat;
    }

    public int getMsg() {
        return msg;
    }

    public void setMsg(int msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "Score{" +
                "name='" + name + '\'' +
                ", kor=" + kor +
                ", eng=" + eng +
                ", mat=" + mat +
                ", msg=" + msg +
                '}';
    }
}