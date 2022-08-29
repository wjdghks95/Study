package chap17;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Sample09 {
    public static void main(String[] args) {
        List<Board> boardList = new ArrayList<>();
        IntStream.rangeClosed(1, 100)
                .forEach(i -> {
                    boardList.add(new Board(i, "title_" + i, "user" +i, LocalDateTime.now()));
                });
        boardList.forEach(System.out::println);
    }
}

class Board {
    int no;
    String title;
    String user;
    LocalDateTime createDate;

    public Board(int no, String title, String user, LocalDateTime createDate) {
        this.no = no;
        this.title = title;
        this.user = user;
        this.createDate = createDate;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    @Override
    public String toString() {
        return "Board{" +
                "no=" + no +
                ", title='" + title + '\'' +
                ", user='" + user + '\'' +
                ", createDate=" + createDate +
                '}';
    }

    public void setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
    }
}