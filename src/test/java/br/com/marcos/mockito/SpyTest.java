package br.com.marcos.mockito;

import org.junit.jupiter.api.Test;
import org.mockito.Captor;
import org.mockito.Mock;

import java.util.ArrayList;
import java.util.List;
import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.spy;

public class SpyTest {

    @Test
    void testMock() {

        List<String> mockArrayList = mock(ArrayList.class);

        assertThat(mockArrayList.size(), is(0));

        when(mockArrayList.size()).thenReturn(5);

        mockArrayList.add("Foo-Bar");
        assertThat(mockArrayList.size(), is(5));


    }

    @Test
    void testSpy() {

        List<String> spyArrayList = spy(ArrayList.class);
        assertThat(spyArrayList.size(), is(0));

        spyArrayList.add("Foo-Bar");
        assertThat(spyArrayList.size(), is(1));
        
        spyArrayList.remove("Foo-Bar");
        assertThat(spyArrayList.size(), is(0));

    }

    @Test
    void testSpyV3() {

        List<String> spyArrayList = spy(ArrayList.class);
        assertThat(spyArrayList.size(), is(0));

        when(spyArrayList.size()).thenReturn(5);
        assertThat(spyArrayList.size(), is(5));

    }

    @Test
    void testSpyV4() {

        List<String> spyArrayList = spy(ArrayList.class);
        spyArrayList.add("Foo-Bar");

        verify(spyArrayList).add("Foo-Bar");
        verify(spyArrayList, never()).remove("Foo-Bar");
        verify(spyArrayList, never()).remove(anyString());
        verify(spyArrayList, never()).clear();
    

    }

}
