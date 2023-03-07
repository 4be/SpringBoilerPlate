package com.abe.templates.services;

import com.abe.templates.AbstractCalculatorTest;
import com.abe.templates.resolver.RandomParameterResolver;
import org.junit.Assert;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.extension.Extensions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.internal.matchers.ArrayEquals;

import java.util.List;
import java.util.Random;

public class RandomCalculatorTest extends AbstractCalculatorTest {

        public static List<Integer> listAngka(){
                return List.of(1,2,5,7,8,4);
        }

        @DisplayName("Test calculator with Method Resource")
        @ParameterizedTest(name = "{displayName} dengan parameter {0}")
        @MethodSource(value = {"listAngka"})
        void testAddwithList(Integer x) {
                int expected = x+x;
                int res= calculator.add(x,x);
                Assert.assertEquals(expected,res);

        }

        @DisplayName("Test Calculator Random")
        @Test
        void testRandom(Random random) {
                int a = random.nextInt();
                int b = random.nextInt();
                int res = calculator.add(a,b);
                int expex = a+b;
                Assert.assertEquals(expex,res);

        }

        @DisplayName("Test Calculator random repeat 5")
        @RepeatedTest(value = 5,name = "{displayName} repition {currentRepetition} of {totalRepetitions}")
        void testRandom5(Random random) {
                int a = random.nextInt();
                int b = random.nextInt();
                int res = calculator.add(a,b);
                int expex = a+b;
                Assert.assertEquals(expex,res);

        }

        @DisplayName("Test calculator parameter")
        @ParameterizedTest(name = "{displayName} with data {0}")
        @ValueSource(ints = {1,2,4,5,6})
        void testParameter(int value) {
                int expected = value + value;
                int result = calculator.add(value,value);
                Assert.assertEquals(expected,result);

        }
}
