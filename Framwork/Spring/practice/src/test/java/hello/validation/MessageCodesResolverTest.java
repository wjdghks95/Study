package hello.validation;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.validation.DefaultMessageCodesResolver;
import org.springframework.validation.MessageCodesResolver;

import static org.assertj.core.api.Assertions.*;

/**
 * MessageCodesResolver
 * 객체 오류의 경우 다음 순서로 2가지 생성
 * 1. errorCode + "." + objectName
 * 2. errorCode
 *
 * 필드 오류의 경우 다음 순서로 4가지 메시지 코드 생성
 * 1. errorCode + "." + objectName + "." + field
 * 2. errorCode + "." + field
 * 3. errorCode + "." + fieldType
 * 4. errorCode
 */
public class MessageCodesResolverTest {

    MessageCodesResolver codesResolver = new DefaultMessageCodesResolver();

    @Test
    void messageCodesResolverObject() {
        String[] messageCodes = codesResolver.resolveMessageCodes("required", "item");
        assertThat(messageCodes).containsExactly("required.item", "required");
    }

    @Test
    void messageCodesResolverField() {
        String[] messageCodes = codesResolver.resolveMessageCodes(
                "required", "item", "itemName", String.class);
        assertThat(messageCodes).containsExactly(
                "required.item.itemName",
                "required.itemName",
                "required.java.lang.String",
                "required"
        );
    }
}
