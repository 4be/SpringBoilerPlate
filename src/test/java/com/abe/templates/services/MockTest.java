package com.abe.templates.services;


import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;

public class MockTest {

        @Test
        void name() {
                List<String> name = Mockito.mock(List.class);

                Mockito.when(name.get(0)).thenReturn("mantap");
                System.out.println(name.get(0));

                Mockito.verify(name,Mockito.times(1)).get(0);
        }


}
