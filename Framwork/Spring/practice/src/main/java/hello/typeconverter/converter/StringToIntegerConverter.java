package hello.typeconverter.converter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.convert.converter.Converter;

/**
 * Converter 인터페이스 구현
 * 문자 -> 숫자
 */
@Slf4j
public class StringToIntegerConverter implements Converter<String, Integer> {

    @Override
    public Integer convert(String source) {
        log.info("covert source={}", source);
        return Integer.valueOf(source);
    }
}
