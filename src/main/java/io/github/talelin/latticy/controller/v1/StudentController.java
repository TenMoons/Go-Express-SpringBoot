package io.github.talelin.latticy.controller.v1;

import io.github.talelin.autoconfigure.exception.NotFoundException;
import io.github.talelin.core.annotation.GroupMeta;
import io.github.talelin.latticy.dto.student.CreateOrUpdateStudentDTO;
import io.github.talelin.latticy.model.BookDO;
import io.github.talelin.latticy.model.StudentDO;
import io.github.talelin.latticy.service.StudentService;
import io.github.talelin.latticy.vo.CreatedVO;
import io.github.talelin.latticy.vo.DeletedVO;
import io.github.talelin.latticy.vo.UpdatedVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Positive;
import java.util.List;

/**
 * @author sy
 */

@RestController
@RequestMapping("/v1/student")
@Validated
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/{id}")
    public StudentDO getStudent(@PathVariable(value = "id") @Positive(message = "id必须为正整数") Long id) {
        StudentDO student = studentService.getById(id);
        if (student == null) {
            throw new NotFoundException("未查询到该学生信息");
        }
        return student;
    }

    @GetMapping("")
    public List<StudentDO> getStudents() {
        List<StudentDO> students = studentService.findAll();
        return students;
    }


    @GetMapping("/search")
    public List<StudentDO> searchStudent(@RequestParam(value = "q", required = false, defaultValue = "") String q) {
        List<StudentDO> students = studentService.getStudentByKeyword("%" + q + "%");
        return students;
    }

    @PostMapping("")
    public CreatedVO createStudent(@RequestBody @Validated CreateOrUpdateStudentDTO validator) {
        studentService.createStudent(validator);
        return new CreatedVO("添加学生信息成功");
    }

    @PutMapping("/{id}")
    public UpdatedVO updateStudent(@PathVariable("id") @Positive(message = "id必须为正整数") Long id) {
        return new UpdatedVO("更新学生信息成功");
    }

    @DeleteMapping("/{id}")
    @GroupMeta(permission = "删除学生", module = "学生", mount = true)
    public DeletedVO deleteStudent(@PathVariable("id") @Positive(message = "{id}") Long id) {
        return new DeletedVO("删除学生信息成功");
    }
}
