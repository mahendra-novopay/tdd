package com.novopay.junidemo;


import static org.junit.jupiter.api.Assertions.*;

@org.junit.platform.commons.annotation.Testable
@org.junit.jupiter.api.DisplayName("My Test class")
public class JUnitTestDemo {

    private static String someVariable = "";
    @org.junit.jupiter.api.BeforeAll
    public static void initAll(){
        someVariable = "Hi";
    }

    @org.junit.jupiter.api.BeforeEach
    public void beforeEach(){
        someVariable = "Hello";
    }

    @org.junit.jupiter.api.Test
    @org.junit.jupiter.api.DisplayName("Hello world")
    public void sayHelloWorld(){
        String hello = "Hello";
        assertEquals("Hi",someVariable);
    }
    @org.junit.jupiter.api.Test
    @org.junit.jupiter.api.DisplayName("Disabled")
    @org.junit.jupiter.api.Disabled
    public void sayHello(){
        String hello = "Hello";
        assertEquals("Hello",hello);
    }


    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.ValueSource(strings = {"racecar", "radar","able was i ere i saw elba"})
    @org.junit.jupiter.api.DisplayName("Palindrome Test")
    public void doParameterizedTest(String candidate){
        assertTrue(isPalindrome(candidate));
    }

    private boolean isPalindrome(String candidate) {
        String reversed = "";

        for(int i = candidate.length()-1; i>=0; i--){
            reversed+=candidate.charAt(i);
        }
        return candidate.equalsIgnoreCase(reversed);
    }

    @org.junit.jupiter.api.Nested
    @org.junit.jupiter.api.DisplayName("Nested class")
    class Nested{

        @org.junit.jupiter.api.Test
        @org.junit.jupiter.api.DisplayName("Nested test")
        public void nestedTest(){
            assertTrue(true);
        }
    }


    @org.junit.jupiter.api.RepeatedTest(10)
    public void repeatedTest(){
        assertEquals("Hi","Hi");
    }

    @org.junit.jupiter.api.Timeout(value = 100, unit = java.util.concurrent.TimeUnit.MILLISECONDS)
    @org.junit.jupiter.api.Test
    public void timeoutTest(){
        while(true){
            Thread.currentThread().setDaemon(true);
        }
    }


    @org.junit.jupiter.api.condition.EnabledOnOs(org.junit.jupiter.api.condition.OS.MAC)
    @org.junit.jupiter.api.Test
    public void osTest(){
        assertTrue(true);
    }


    @org.junit.jupiter.api.condition.EnabledOnJre(value = org.junit.jupiter.api.condition.JRE.JAVA_8)
    @org.junit.jupiter.api.Test
    public void jreTest(){
        assertTrue(true);
    }


    @org.junit.jupiter.api.condition.EnabledForJreRange(min = org.junit.jupiter.api.condition.JRE.JAVA_8, max= org.junit.jupiter.api.condition.JRE.JAVA_11)
    @org.junit.jupiter.api.Test
    public void jreRangeTest(){
        assertTrue(true);
    }

    @org.junit.jupiter.api.AfterAll
    @org.junit.jupiter.api.DisplayName("Cleanup")
    public static void doCleanUp(){
        assertTrue(true);
    }

}
