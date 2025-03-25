package br.com.marcos.cursos_business;

import br.com.marcos.service.CourseService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.mockito.BDDMockito.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.mockito.Mockito.*;


public class CourseBusinessMockWithBDDTest {

    CourseService mockService;
    CourseBusiness business;
    List<String> curso;


    @BeforeEach
    void stup() {
        mockService = mock(CourseService.class);
        business = new CourseBusiness(mockService);

        curso = Arrays.asList("REST API's RESTFul do 0 à Azure com ASP.NET Core 5 e Docker",
                "Agile Desmistificado com Scrum, XP, Kanban e Trello",
                "Spotify Engineering Culture Desmistificado",
                "REST API's RESTFul do 0 à AWS com Spring Boot 3 Java e Docker",
                "Docker do Zero à Maestria - Contêinerização Desmistificada",
                "Docker para Amazon AWS Implante Apps Java e .NET com Travis CI",
                "Microsserviços do 0 com Spring Cloud, Spring Boot e Docker",
                "Arquitetura de Microsserviços do 0 com ASP.NET, .NET 6 e C#",
                "REST API's RESTFul do 0 à AWS com Spring Boot 3 Kotlin e Docker",
                "Kotlin para DEV's Java: Aprenda a Linguagem Padrão do Android",
                "Microsserviços do 0 com Spring Cloud, Kotlin e Docker"
        );
    }

    @Test
    void testCoursesRelatedToSpring_When_UsingMock() {

        given(mockService.recuperarCurso("Leandro"))
                .willReturn(curso);

        var filtrarCurso = business.recuperarCurso("Leandro");

        assertThat(filtrarCurso.size(), is(4));
    }


    @DisplayName(" Delete courses not related to Spring Using Mockito sould call Method")
    @Test
    void testDeleteCoursesNotRelatedToSpring_UsingMockitoVerify_shold_CallMethod_deleteCourse(){

        given(mockService.recuperarCurso("Leandro"))
                .willReturn(curso);

        business.deteteCurso("Leandro");

        verify(mockService, times(2))
            .deleteCourse("Kotlin para DEV's Java: Aprenda a Linguagem Padrão do Android");

        verify(mockService, atLeast(2))
                .deleteCourse("Docker para Amazon AWS Implante Apps Java e .NET com Travis CI");

        verify(mockService)
                .deleteCourse("Agile Desmistificado com Scrum, XP, Kanban e Trello");

        // never() garante que o metodo não sera chamado!
        verify(mockService, never())
                .deleteCourse("REST API's RESTFul do 0 à AWS com Spring Boot 3 Java e Docker");

    }


}
