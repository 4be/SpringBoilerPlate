package com.abe.templates.services;


import org.junit.jupiter.api.*;

import java.util.LinkedList;
import java.util.Queue;

@DisplayName("A Queue")
public class QueueTest {
        private Queue<String> queue;

        @Nested
        @DisplayName("If new")
        public class WhenNew{

                @BeforeEach
                void startUp(){
                        queue = new LinkedList<>();
                }

                @Test
                @DisplayName("When offer, size must be one")
                void add1(){
                        queue.offer("daniel");
                        Assertions.assertEquals(1,queue.size());
                }

                @Test
                @DisplayName("When offer 2, size must be one")
                void add2(){
                        queue.offer("daniel");
                        queue.offer("eko");
                        Assertions.assertEquals(2,queue.size());
                }



        }

}
