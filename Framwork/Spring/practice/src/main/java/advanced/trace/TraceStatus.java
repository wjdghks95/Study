package advanced.trace;

/**
 * 로그의 상태 정보를 나타내는 객체
 */
public class TraceStatus {

    private TraceId traceId; // traceId
    private Long startTimeMs; // 로그 시작 시간
    private String message; // 시작시 사용한 메시지

    public TraceStatus(TraceId traceId, Long startTimeMs, String message) {
        this.traceId = traceId;
        this.startTimeMs = startTimeMs;
        this.message = message;
    }

    public TraceId getTraceId() {
        return traceId;
    }

    public Long getStartTimeMs() {
        return startTimeMs;
    }

    public String getMessage() {
        return message;
    }
}
