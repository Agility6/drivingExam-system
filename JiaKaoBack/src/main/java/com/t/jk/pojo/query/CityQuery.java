package com.t.jk.pojo.query;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * ClassName: CityQuery
 * Description:
 *
 * @Author agility6
 * @Create 2024/2/2 17:12
 * @Version: 1.0
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class CityQuery extends KeywordQuery {
    private Integer parentId;
}
