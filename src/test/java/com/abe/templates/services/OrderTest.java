package com.abe.templates.services;


import org.junit.jupiter.api.*;

//untuk membuat object sharing didalam class
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class OrderTest {

        private int counter=0;

        @Test
        @Order(1)
        void test1(){
                counter++;
                System.out.println(counter);
        }

        @Test
        void test2(){
                counter+=10;
                System.out.println(counter);
        }

        @Test
        void test3(){
                System.out.println(counter);
        }

        @Test
        void test4(){
                System.out.println(counter);
        }

}
