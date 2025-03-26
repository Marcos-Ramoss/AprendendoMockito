package br.com.marcos.mockito;

import br.com.marcos.cursos_business.CourseBusiness;
import br.com.marcos.service.CourseService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;


@ExtendWith(MockitoExtension.class)
public class CourseBusinessInjectMockWithBDDTest {

    @Mock
    CourseService mockService;

    @InjectMocks
    CourseBusiness business;

    @Captor
    ArgumentCaptor<String> argumentCaptor ;


    List<String> curso;


    @BeforeEach
    void stup() {
        curso = Arrays.asList("REST API's RESTFul do 0 à Azure com ASP.NET Core 5 e Docker",
                "Agile Desmistificado com Scrum, XP, Kanban e Trello",
                "REST API's RESTFul do 0 à AWS com Spring Boot 3 Java e Docker"
        );
    }

    @Test
    void testCoursesRelatedToSpring_When_UsingMock() {

        given(mockService.recuperarCurso("Marcos"))
                .willReturn(curso);

        var filtrarCurso = business.recuperarCurso("Marcos");


        assertThat(filtrarCurso.size(), is(1));
        System.out.println(curso);
    }


    @DisplayName(" Delete courses not related to Spring Using Mockito sould call Method")
    @Test
    void testDeleteCoursesNotRelatedToSpring_CapturingArguments_shold_CallMethod_deleteCourse() {

        given(mockService.recuperarCurso("Marcos"))
                .willReturn(curso);

        String agileCourse = "Agile Desmistificado com Scrum, XP, Kanban e Trello";

        business.deteteCurso("Marcos");

        then(mockService).should(times(2)).deleteCourse(argumentCaptor.capture());
        assertThat(argumentCaptor.getAllValues().size(), is(2));

    }


}
