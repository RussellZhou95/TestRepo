package org.example;

import org.apache.logging.log4j.util.Strings;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.jms.core.JmsTemplate;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@WebMvcTest
public class IntegrationTest {




    public static Stream<Arguments> provideStringsForIsBlank() {
        return Stream.of(
                Arguments.of(null,true),
                Arguments.of("",true),
                Arguments.of(" ",true),
                Arguments.of("abc",false)
        );
    }

    @ParameterizedTest(name = "isBlank({0}) = {1}")
    @MethodSource("provideStringsForIsBlank")
    void letsTest(String input, boolean expected) {
        assertEquals(expected, Strings.isBlank(input));
    }
}
