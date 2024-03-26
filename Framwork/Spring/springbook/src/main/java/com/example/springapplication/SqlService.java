package com.example.springapplication;

public interface SqlService {
    String getSql(String key);

    public class SqlRetrievalFailureException extends RuntimeException {
        public SqlRetrievalFailureException(String message) {
            super(message);
        }

        public SqlRetrievalFailureException(String message, Throwable cause) {
            super(message, cause);
        }

        public SqlRetrievalFailureException(Throwable cause) {
            super(cause);
        }
    }
}
