package io.github.talelin.latticy.service;

import io.github.talelin.latticy.dto.book.CreateOrUpdateBookDTO;
import io.github.talelin.latticy.dto.student.CreateOrUpdateStudentDTO;
import io.github.talelin.latticy.model.StudentDO;

import java.util.List;

/**
 * @author sy
 */

public interface StudentService {

    StudentDO getById(Long id);

    boolean deleteById(Long id);

    boolean createStudent(CreateOrUpdateStudentDTO validator);

    boolean updateStudent(StudentDO student, CreateOrUpdateStudentDTO validator);

    List<StudentDO> findAll();

    List<StudentDO> getStudentByKeyword(String q);
}
