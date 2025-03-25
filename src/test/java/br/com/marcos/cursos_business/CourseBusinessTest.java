package br.com.marcos.cursos_business;

import br.com.marcos.service.CourseService;
import br.com.marcos.service.stubs.CourseServiceStub;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;



public class CourseBusinessTest {

    @Test
    void testCoursesRelatedToSpring_When_UsingAstub(){

        CourseService stubService = new CourseServiceStub();
        CourseBusiness business = new CourseBusiness(stubService);

        var filtrarCurso = business.recuperarCurso("Leandro");

        assertEquals(4, filtrarCurso.size());

    }

    @Test
    void testCoursesRelatedToSpring_When_UsingFooBarStudent(){

        CourseService stubService = new CourseServiceStub();
        CourseBusiness business = new CourseBusiness(stubService);

        var filtrarCurso = business.recuperarCurso("Spring");

        assertEquals(4, filtrarCurso.size());

    }


}
