package io.github.talelin.latticy.mapper;

import io.github.talelin.latticy.model.StudentDO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author sy
 */

@Repository
@Mapper
public interface StudentMapper extends BaseMapper<StudentDO> {

    List<StudentDO> selectByStuIDLikeKeyword(@Param("q") String q);

    List<StudentDO> selectByStuID(@Param("stu_id") String stu_id);

    List<StudentDO> selectByStuNameLikeKeyword(@Param("q") String q);

    List<StudentDO> selectByStuName(@Param("stu_name") String stu_name);
}
