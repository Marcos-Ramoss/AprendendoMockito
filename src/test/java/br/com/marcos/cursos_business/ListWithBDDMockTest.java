package br.com.marcos.cursos_business;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.BDDMockito.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.mockito.Mockito.*;

public class ListWithBDDMockTest {

    List<?> list;

    @BeforeEach
    void setup() {
        list = mock(List.class);
    }

    @Test
    void testMocckingList_When_SizeIsCalled_ShouldReturn10() {

        given(list.size()).willReturn(10);
        assertThat( list.size(), is(10));
    }

    @Test
    void testMocckingList_When_SizeIsCalled_ShouldReturnMultipleValues() {

        given(list.size()).willReturn(10).willReturn(20);

        assertThat( list.size(), is(10));
        assertThat( list.size(), is(20));
        assertThat( list.size(), is(20));

    }

    @Test
    void testMocckingList_When_GetIsCalled_ShouldReturnMarcos() {

        var list = mock(List.class);

        given(list.get(0)).willReturn("Marcos");

        assertThat( list.get(0), is("Marcos"));
        assertNull( list.get(1));

    }

    @Test
    void testMocckingList_When_GetIsCalledWithArgumentMatcher_ShouldReturnMarcos() {
        //GIVEN
        var list = mock(List.class);
        given(list.get(anyInt())).willReturn("Marcos");

        //When //Assert
        assertThat(list.get(anyInt()), is("Marcos"));

    }

    @Test
    void testMocckingList_When_ThrowsAnException() {

        var list = mock(List.class);
        given(list.get(anyInt())).willThrow(new RuntimeException("Foo Bar!! "));

        assertThrows(
                RuntimeException.class,
                () -> {
                    list.get(anyInt());
                }, () -> "Shold have throw an RuntimeException");
    }
}
