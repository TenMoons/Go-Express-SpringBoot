package io.github.talelin.latticy.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.util.Date;

/**
 * tb_student的数据模型
 * @author sy
 */

@TableName("tb_student")
@Data
public class StudentDO {
    /**
     * id，主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    /**
     * 学号
     */
    private String stuId;
    /**
     * 姓名
     */
    private String stuName;

    @JsonIgnore
    private Date createTime;

    @JsonIgnore
    private Date updateTime;

    @JsonIgnore
    @TableLogic
    private Date deleteTime;
}
