package com.novopay.junidemo;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;


@org.junit.platform.commons.annotation.Testable
@org.junit.jupiter.api.DisplayName("AssertJ Demo")
public class JUnitAssertJDemo {
    private static  final List<String> list = new ArrayList<>();
    private static final Map<String, String> map = new HashMap<>();

    @org.junit.jupiter.api.BeforeAll
    public static void initAll(){
        list.addAll(java.util.Arrays.asList("abc","xyz","123"));
        map.put("123","abc");
        map.put("124","xyz");
        map.put("125","dfdfdsf");
    }

    @org.junit.jupiter.api.Test
    @org.junit.jupiter.api.DisplayName("Assertionj example")
    public void assertJ(){
        //Regular JUnit style
        assertEquals("abc","123");

        //AssertJ style
        assertThat("abc").isEqualTo("123");
    }


    @org.junit.jupiter.api.Test
    @org.junit.jupiter.api.DisplayName("Assertion chaining ")
    public void assertionChaining(){
        //Junit style
        assertNotNull(list);
        assertTrue(list.isEmpty());

        //AssertJ style
        assertThat(list).isNull();
    }

}
