package br.com.marcos.cursos_business;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;
import static org.mockito.Mockito.*;


public class ListMockTest {

    @Test
    void testMocckingList_When_SizeIsCalled_ShouldReturn10(){
        //GIVEN
        List<?> list = mock(List.class);
        when(list.size()).thenReturn(10);

        //When //Assert
        assertEquals(10, list.size());

    }

    @Test
    void testMocckingList_When_SizeIsCalled_ShouldReturnMultipleValues(){
        //GIVEN
        List<?> list = mock(List.class);
        when(list.size()).thenReturn(10).thenReturn(20);

        //When //Assert
        assertEquals(10, list.size());
        assertEquals(20, list.size());
        assertEquals(20, list.size());

    }

    @Test
    void testMocckingList_When_GetIsCalled_ShouldReturnMarcos(){
        //GIVEN
        var list = mock(List.class);
        when(list.get(0)).thenReturn("Marcos");

        //When //Assert
        assertEquals("Marcos", list.get(0));
        assertNull(list.get(1));

    }

    @Test
    void testMocckingList_When_GetIsCalledWithArgumentMatcher_ShouldReturnMarcos(){
        //GIVEN
        var list = mock(List.class);
        when(list.get(anyInt())).thenReturn("Marcos");

        //When //Assert
        assertEquals("Marcos", list.get(anyInt()));

    }
}
