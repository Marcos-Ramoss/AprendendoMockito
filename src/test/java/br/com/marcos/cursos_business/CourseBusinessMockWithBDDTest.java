package br.com.marcos.cursos_business;

import br.com.marcos.service.CourseService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;

import java.util.Arrays;
import java.util.List;

import static org.mockito.BDDMockito.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.*;


public class CourseBusinessMockWithBDDTest {

    CourseService mockService;
    CourseBusiness business;
    List<String> curso;


    @BeforeEach
    void stup() {
        mockService = mock(CourseService.class);
        business = new CourseBusiness(mockService);

    }

    @Test
    void testCoursesRelatedToSpring_When_UsingMock() {

        given(mockService.recuperarCurso("Marcos"))
                .willReturn(curso);

        var filtrarCurso = business.recuperarCurso("Marcos");

        assertThat(filtrarCurso.size(), is(4));
        System.out.println(curso);
    }


    @DisplayName(" Delete courses not related to Spring Using Mockito sould call Method")
    @Test
    void testDeleteCoursesNotRelatedToSpring_CapturingArguments_shold_CallMethod_deleteCourse() {

        curso = Arrays.asList("REST API's RESTFul do 0 à Azure com ASP.NET Core 5 e Docker",
                "Agile Desmistificado com Scrum, XP, Kanban e Trello",
                "REST API's RESTFul do 0 à AWS com Spring Boot 3 Java e Docker"
        );

        given(mockService.recuperarCurso("Marcos"))
                .willReturn(curso);

        ArgumentCaptor<String> argumentCaptor = ArgumentCaptor.forClass(String.class);

        String agileCourse = "Agile Desmistificado com Scrum, XP, Kanban e Trello";

        business.deteteCurso("Marcos");

//        then(mockService).should().deleteCourse(argumentCaptor.capture());
//        assertThat(argumentCaptor.getValue(), is(agileCourse));

        then(mockService).should(times(2)).deleteCourse(argumentCaptor.capture());
        assertThat(argumentCaptor.getAllValues().size(), is(2));

    }


}
