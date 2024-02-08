package com.t.jk.pojo.query;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.annotation.Priority;

/**
 * ClassName: ExamPlaceQuery
 * Description:
 *
 * @Author agility6
 * @Create 2024/2/6 16:44
 * @Version: 1.0
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class ExamPlaceQuery extends KeywordQuery {
    private Integer provinceId;
    private Integer cityId;
}
