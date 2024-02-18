package com.t.jk.pojo.dto;

import com.t.jk.pojo.po.ExamPlaceCourse;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * ClassName: ExamPlaceCourseDto
 * Description: 进行分页查询的时候需要将省份信息携带出来
 *
 * @Author agility6
 * @Create 2024/2/18 20:54
 * @Version: 1.0
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class ExamPlaceCourseDto extends ExamPlaceCourse {
    private Integer provinceId;
    private Integer cityId;
}
