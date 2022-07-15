package hello.typeconverter.converter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.convert.converter.Converter;

/**
 * Converter 인터페이스 구현
 * 숫자 -> 문자
 */
@Slf4j
public class IntegerToStringConverter implements Converter<Integer, String> {

    @Override
    public String convert(Integer source) {
        log.info("convert source={}", source);
        return String.valueOf(source);
    }
}
