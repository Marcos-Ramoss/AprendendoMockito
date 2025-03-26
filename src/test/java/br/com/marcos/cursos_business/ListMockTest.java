package br.com.marcos.cursos_business;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.mockito.Mockito.*;


public class ListMockTest {

    List<?> list;

    @BeforeEach
    void setup() {
        list = mock(List.class);
    }

    @Test
    void testMocckingList_When_SizeIsCalled_ShouldReturn10() {

        when(list.size()).thenReturn(10);
        assertEquals(10, list.size());

    }

    @Test
    void testMocckingList_When_SizeIsCalled_ShouldReturnMultipleValues() {

        when(list.size()).thenReturn(10).thenReturn(20);

        assertEquals(10, list.size());
        assertEquals(20, list.size());
        assertEquals(20, list.size());

    }

    @Test
    void testMocckingList_When_GetIsCalled_ShouldReturnMarcos() {

        var list = mock(List.class);
        when(list.get(0)).thenReturn("Marcos");

        //When //Assert
        assertEquals("Marcos", list.get(0));
        assertNull(list.get(1));

    }

    @Test
    void testMocckingList_When_GetIsCalledWithArgumentMatcher_ShouldReturnMarcos() {

        var list = mock(List.class);
        when(list.get(anyInt())).thenReturn("Marcos");
        assertEquals("Marcos", list.get(anyInt()));

    }

    @Test
    void testMocckingList_When_ThrowsAnException() {

        var list = mock(List.class);
        when(list.get(anyInt())).thenThrow(new RuntimeException("Foo Bar!! "));

        assertThrows(
                RuntimeException.class,
                () -> {
                    list.get(anyInt());
                }, () -> "Shold have throw an RuntimeException");
    }
}
