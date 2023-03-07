package com.abe.templates.services;

import com.abe.templates.generator.SimpleDisplayNameGenerator;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.*;
import org.opentest4j.TestAbortedException;

import java.util.Properties;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assumptions.*;

@Tag("Calculator-test")
@DisplayNameGeneration(SimpleDisplayNameGenerator.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class CalculatorTest {

    final Calculator calculator = new Calculator();

    private int counter = 0;


    //run sebelum test paling awal
    @BeforeAll
    public static void awalanSemua(){
        System.out.println("awalan Semua");
    }

    //run setiap sebelum test berjalan
    @BeforeEach
    public void startUp(){
        System.out.println("Mulai dulu");
    }

    //run setiap test berakhir
    @AfterEach
    void endUp(){
        System.out.println("Akhir dulu");
    }

    @Test
    void addSuccess() {
        var expected =calculator.add(10,10);
        assertEquals(20,expected);
    }

    @Test
    void divideSuccess() {
        var expected =calculator.divide(10,5);
        assertEquals(2,expected);
    }

    @Test
    void divideFailed() {
        assertThrows(IllegalArgumentException.class,()-> calculator.divide(5,0));
    }

    //disable unit test
    @Test
    @Disabled
    void commingSoon(){

    }

    //test get env TestAbortedException
    @Test
    void GetEnv(){
        var getStage = System.getenv("stage");
        if(!getStage.equals("dev")){
            throw new TestAbortedException("test dibatalkan karena prod");
        }
    }

    //test menggunakan asumsi berdasarkan enviroment
    @Test
    void TestAsumtion(){
        assumeTrue("prod".equals(System.getenv("stage")));
    }

    //enable and disable OS / JRE
    @Test
    @EnabledOnOs({OS.WINDOWS})
    @DisabledOnJre({JRE.JAVA_11})
    void onlyRunInWindows(){

    }


    //print tiap properties
    @Test
    @Order(1) //urutan order
    void testPropertiesValue(){
        counter++;
        System.out.println(counter);
//        Properties properties = System.getProperties();
//        properties.forEach((key,value)->System.out.println(key+":"+value));
    }


    //test berjalan jika system properties sesuai dengan kondisi
    @Test
    @EnabledIfSystemProperties({
            @EnabledIfSystemProperty(named = "user.language", matches = "id ")
    })
    void checkPropertiesLanguage(){
        System.out.println("its running");

    }


}