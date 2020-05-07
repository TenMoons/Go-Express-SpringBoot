package io.github.talelin.latticy.service.impl;

import io.github.talelin.latticy.dto.student.CreateOrUpdateStudentDTO;
import io.github.talelin.latticy.mapper.StudentMapper;
import io.github.talelin.latticy.model.StudentDO;
import io.github.talelin.latticy.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author sy
 */

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentMapper studentMapper;

    @Override
    public StudentDO getById(Long id) {
        StudentDO student = studentMapper.selectById(id);
        return student;
    }

    @Override
    public boolean deleteById(Long id) {
        return studentMapper.deleteById(id) > 0;
    }

    @Override
    public boolean createStudent(CreateOrUpdateStudentDTO validator) {
        StudentDO student = new StudentDO();
        student.setStuId(validator.getStuId());
        student.setStuName(validator.getStuName());
        return studentMapper.insert(student) > 0;
    }

    @Override
    public boolean updateStudent(StudentDO student, CreateOrUpdateStudentDTO validator) {
        student.setStuId(validator.getStuId());
        student.setStuName(validator.getStuName());
        return studentMapper.updateById(student) > 0;
    }

    @Override
    public List<StudentDO> findAll() {
        List<StudentDO> students = studentMapper.selectList(null);
        return students;
    }

    @Override
    public List<StudentDO> getStudentByKeyword(String q) {
        List<StudentDO> students = studentMapper.selectByStuNameLikeKeyword(q);
        return students;
    }
}
