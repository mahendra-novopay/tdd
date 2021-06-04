package com.novopay.junidemo;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@org.junit.platform.commons.annotation.Testable
@org.junit.jupiter.api.DisplayName("Spring Boot testing using Mockito")
@org.springframework.boot.test.context.SpringBootTest(webEnvironment = org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT)
public class JUnitMockitoSpringBootDemo {

    @org.springframework.boot.web.server.LocalServerPort
    private int port;

    @org.springframework.boot.test.mock.mockito.MockBean
    com.novopay.repositories.UserRespository userRespository;

    @org.junit.jupiter.api.Test
    @org.junit.jupiter.api.DisplayName("User test")
    public void userTest(){
        when(userRespository.findAll()).
                thenReturn(java.util.stream.Stream.of(new com.novopay.domain.User(1l,"dfdf"), new com.novopay.domain.User(2l,"ddf")).collect(java.util.stream.Collectors.toList()));
        //assertEquals(1,userRespository.findAll().size());

        com.novopay.domain.User newuser = new com.novopay.domain.User(1l,"dfdf");
        com.novopay.repositories.UserRespository respository = mock(com.novopay.repositories.UserRespository.class);

        when(respository.getById(org.mockito.Mockito.anyLong())).thenReturn(newuser);
        assertEquals("dfdf",newuser.getName());
    }



}
