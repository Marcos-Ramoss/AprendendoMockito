package br.com.marcos.service;

import java.util.List;

public interface CourseService {

     List<String> recuperarCurso(String estudante);
     void deleteCourse(String curso);




}
