package com.novopay.junidemo;


import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@org.junit.platform.commons.annotation.Testable
@org.junit.jupiter.api.DisplayName("Mockito test")
@org.springframework.boot.test.context.SpringBootTest
public class JUnitMockitoDemo {
    @org.mockito.Mock
    com.novopay.mockitodemo.Calculator calculator;

    @org.junit.jupiter.api.Test
    @org.junit.jupiter.api.DisplayName("Add test")
    public void testAdd(){
        when(calculator.addLong(10l,20l)).thenReturn(40l);
        assertEquals(calculator.addLong(10l,20l),30l);
    }

    @org.junit.jupiter.api.Test
    @org.junit.jupiter.api.DisplayName("Java library using Mockito")
    public void mockList(){
        //Mock creation of
        List mockedList = mock(List.class);

        //using mock object
        mockedList.add("One");
        mockedList.clear();

        //verification
        verify(mockedList).add("One");
        verify(mockedList).clear();

    }


    @org.junit.jupiter.api.Test
    @org.junit.jupiter.api.DisplayName("Verify number of invocation")
    public void invocations(){
        //Mock creation of
        List mockedList = mock(List.class);
        //using mock object
        mockedList.add("Once");

        mockedList.add("Twice");
        mockedList.add("Twice");

        mockedList.add("Three times");
        mockedList.add("Three times");
        mockedList.add("Three times");

        //following verification
        verify(mockedList).add("Once");
        verify(mockedList,times(1)).add("Once");
        verify(mockedList,times(2)).add("Twice");
        verify(mockedList,times(3)).add("Three times");

        verify(mockedList, never()).add("Once");
    }


    @org.junit.jupiter.api.Test
    @org.junit.jupiter.api.DisplayName("Interaction test")
    public void interactionTest(){
        List mockedOne = mock(List.class);
        List mockedTwo = mock(List.class);
        List mockedThree = mock(List.class);

        mockedOne.add("one");

        verify(mockedOne).add("one");
        verify(mockedOne,never()).add("two");

        verifyNoInteractions(mockedTwo,mockedThree);


    }

}
