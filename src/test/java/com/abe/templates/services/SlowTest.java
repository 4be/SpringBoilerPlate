package com.abe.templates.services;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;

import java.util.concurrent.TimeUnit;

@Execution(ExecutionMode.CONCURRENT)
public class SlowTest {

        @Test
        @DisplayName("5 sec test")
        @Timeout(value = 5, unit = TimeUnit.SECONDS)
        void testingLessthan5Sec() throws InterruptedException {
                Thread.sleep(4999);
        }

        @Test
        @DisplayName("4 sec test")
        @Timeout(value = 4, unit = TimeUnit.SECONDS)
        void testingLessthan4Sec() throws InterruptedException {
                Thread.sleep(3000);
        }

        @Test
        @DisplayName("7 sec test")
        @Timeout(value = 7, unit = TimeUnit.SECONDS)
        void testingLessthan7Sec() throws InterruptedException {
                Thread.sleep(2000);
        }

        @Test
        @DisplayName("9 sec test")
        @Timeout(value = 9, unit = TimeUnit.SECONDS)
        void testingLessthan9Sec() throws InterruptedException {
                Thread.sleep(2000);
        }

        @Test
        @DisplayName("8 sec test")
        @Timeout(value = 8, unit = TimeUnit.SECONDS)
        void testingLessthan8Sec() throws InterruptedException {
                Thread.sleep(2000);
        }

        @Test
        @DisplayName("3 sec test")
        @Timeout(value = 3, unit = TimeUnit.SECONDS)
        void testingLessthan3Sec() throws InterruptedException {
                Thread.sleep(2000);
        }


}
