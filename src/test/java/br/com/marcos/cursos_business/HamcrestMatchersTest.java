package br.com.marcos.cursos_business;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import static  org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

public class HamcrestMatchersTest {

    @Test
    void testHamcrestMatchersTest(){
        //Given
        List<Integer> scores = Arrays.asList(99, 100, 101, 105);
        //when e Then
        assertThat(scores, hasSize(4));    // assertion que defini o tamanho da lista
        assertThat(scores, hasItems(100, 101));   // assertion que verifica se possuem os item na lista
        assertThat(scores, everyItem(greaterThan(98)));   // assertion para garantir que os numeros sejam maiores que 98
        assertThat(scores, everyItem(lessThan(106)));   // assertion para garantir que os numeros sejam menores que 106

        // check Strings
        assertThat("", is(emptyString())); // assertions para verificar string vazia
        assertThat(null, is(emptyOrNullString())); // assertions para verificar string vazia

        //arrays
        Integer [] myArray = {1,2,3};
        assertThat(myArray, arrayWithSize(3));
        assertThat(myArray, arrayContaining(1,2,3));
        assertThat(myArray, arrayContainingInAnyOrder(3,2,1));



    }
}
