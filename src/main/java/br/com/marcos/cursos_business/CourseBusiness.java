package br.com.marcos.cursos_business;

import br.com.marcos.service.CourseService;

import java.util.ArrayList;
import java.util.List;

// System Under Test
public class CourseBusiness {

    private CourseService service;

    public CourseBusiness(CourseService service) {
        this.service = service;
    }

    public List<String> recuperarCurso(String estudante){

        var filtrarCurso = new ArrayList<String>();
        if("Foo Bar".equals(estudante))
            return  filtrarCurso;

        var todosCursos = service.recuperarCurso(estudante);

        for (String curso : todosCursos) {
            if (curso.contains("Spring")) {
                filtrarCurso.add(curso);
            }

        }
        return filtrarCurso;
    }
}
