package br.com.marcos.cursos_business;

import br.com.marcos.service.CourseService;
import br.com.marcos.service.stubs.CourseServiceStub;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;


public class CourseBusinessMockTest {

    CourseService mockService;
    CourseBusiness business;

    @BeforeEach
    void stup(){
        mockService = mock(CourseService.class);
        business = new CourseBusiness(mockService);
    }

    @Test
    void testCoursesRelatedToSpring_When_UsingMock(){

        var filtrarCurso = business.recuperarCurso("Marcos");

        assertEquals(4, filtrarCurso.size());

    }



}
