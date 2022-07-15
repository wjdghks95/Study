package hello.exception.exhandler.advice;

import hello.exception.exception.UserException;
import hello.exception.exception.ViewException;
import hello.exception.exhandler.ErrorResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.ModelAndView;


/**
 * ExceptionHandlerExceptionResolver 동작
 * @ExceptionHandler
 * 처리하고 싶은 예외 지정
 * 생략 시 메서드 파라미터의 예외가 지정
 *
 * @ControllerAdvice
 * 대상으로 지정한 여러 컨트롤러에 @ExceptionHandler , @InitBinder 기능을 부여
 * 대상을 지정하지 않으면 모든 컨트롤러에 적용
 */
@Slf4j
@RestControllerAdvice
public class ExControllerAdvice {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(IllegalArgumentException.class)
    public ErrorResult illegalExHandler(IllegalArgumentException e) {
        log.error("[exceptionHandle] ex", e);
        return new ErrorResult("BAD", e.getMessage());
    }

    @ExceptionHandler
    public ResponseEntity<ErrorResult> userExHandle(UserException e) {
        log.error("[exceptionHandle] ex", e);
        ErrorResult errorResult = new ErrorResult("USER-EX", e.getMessage());
        return new ResponseEntity<>(errorResult, HttpStatus.BAD_REQUEST);
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler
    public ErrorResult exHandle(Exception e) {
        log.error("[exceptionHandle] ex", e);
        return new ErrorResult("EX", "내부 오류");
    }

    @ExceptionHandler(ViewException.class)
    public ModelAndView ex(ViewException e) {
        log.info("exception e", e);
        return new ModelAndView("error");
    }
}
