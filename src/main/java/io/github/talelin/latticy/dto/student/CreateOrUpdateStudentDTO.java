package io.github.talelin.latticy.dto.student;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

/**
 * @author sy
 */

@Data
public class CreateOrUpdateStudentDTO {

    @NotEmpty(message = "必须传入学生学号")
    @Size(min = 9, max = 9, message = "学号为9个字符")
    private String stuId;

    @NotEmpty(message = "必须传入学生姓名")
    @Size(max = 20, message = "姓名不得超过20字符")
    private String stuName;
}
