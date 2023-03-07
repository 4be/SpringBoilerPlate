package com.abe.templates;


import com.abe.templates.resolver.RandomParameterResolver;
import com.abe.templates.services.Calculator;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.extension.Extensions;

@Extensions({
        @ExtendWith(RandomParameterResolver.class)
})
public class AbstractCalculatorTest {
        protected Calculator calculator = new Calculator();

        @BeforeEach
        void setUp() {
                System.out.println("Mulai dulu ya gan");
        }
}
