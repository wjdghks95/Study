package com.example.demo.domain.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.domain.Pageable;

@Getter @Setter
public class PageDto {
    private final int PAGENUM = 5; // 페이지 몇개로 구성할건지
    private int pageSize; // 페이지당 몇개 표시할건지
    private int startPage;
    private int endPage;
    private int curPage; // 현재 페이지
    private boolean prev, next;

    private long total;

    public PageDto() {
    }

    public PageDto(long total, Pageable pageable) {
        this.total = total;
        this.curPage = pageable.getPageNumber();
        this.pageSize = pageable.getPageSize();

        this.endPage = (int) (Math.ceil((curPage+1) / 5.0)) * 5; // 일단 endPage를 5단위로 세팅, view는 1부터 시작이므로 curPage+1
        this.startPage = this.endPage - (PAGENUM - 1); // 5단위 endPage에서 9를 빼면 시작페이지 구할 수 있음

        int realEnd = (int) (Math.ceil((total * 1.0) / pageSize));

        if (realEnd < this.endPage) { // 페이지가 5단위로 나누어 떨어지지 않을때 real endPage
            this.endPage = realEnd;
        }

        this.prev = (curPage+1) > 1; // view에서는 1부터 시작이므로
        this.next = (curPage+1) < realEnd; // view에서는 1부터 시작이므로
    }
}
