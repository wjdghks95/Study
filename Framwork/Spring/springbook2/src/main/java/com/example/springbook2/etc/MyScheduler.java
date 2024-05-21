package com.example.springbook2.etc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scheduling.support.CronTrigger;

import javax.annotation.Resource;

public class MyScheduler {
    @Autowired TaskScheduler scheduler;
    @Resource Runnable specialTask;

    public void startSpecialTaskScheduler() {
        scheduler.schedule(specialTask, new CronTrigger("0 30 4 * * MON-FRI")); // 월, 날짜에 상관없이 매주 월요일부터 금요일 까지 새벽 4시 30분에 동작하도록 설정한 것이다.
    }

    // 이전 메소드 작업이 끝난 후로 부터 1분 후 다음 작업이 실행
    @Scheduled(fixedDelay = 60000)
    public void checkSystemStatus(){}

    // 일정한 시간 간격으로 메소드 실행
    @Scheduled(fixedRate = 60000)
    public void checkSystemStatus2() {}

    // cron 포맷을 사용해 스케줄을 지정할 수 있다.
    @Scheduled(cron = "0 0 12 1 * MON-FRI")
    public void checkSystemStatus3() {}

    // @Async가 부여된 메소드는 자동으로 비동기 방식으로 실행된다.
    @Async
    void complexWork(String s) {}
}
