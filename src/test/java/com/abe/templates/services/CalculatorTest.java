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
class CalculatorTest {

    final Calculator calculator = new Calculator();

    @BeforeAll
    public static void awalanSemua(){
        System.out.println("awalan Semua");
    }

    @BeforeEach
    public void startUp(){
        System.out.println("Mulai dulu");
    }

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

    @Test
    @Disabled
    void commingSoon(){

    }

    @Test
    void GetEnv(){
        var getStage = System.getenv("stage");
        if(!getStage.equals("dev")){
            throw new TestAbortedException("test dibatalkan karena prod");
        }
    }

    @Test
    void TestAsumtion(){
        assumeTrue("prod".equals(System.getenv("stage")));
    }

    @Test
    @EnabledOnOs({OS.WINDOWS})
    @DisabledOnJre({JRE.JAVA_11})
    void onlyRunInWindows(){

    }


    @Test
    void testPropertiesValue(){
        Properties properties = System.getProperties();
        properties.forEach((key,value)->System.out.println(key+":"+value));
    }


    @Test
    @EnabledIfSystemProperties({
            @EnabledIfSystemProperty(named = "user.language", matches = "id ")
    })
    void checkPropertiesLanguage(){
        System.out.println("its running");

    }

}