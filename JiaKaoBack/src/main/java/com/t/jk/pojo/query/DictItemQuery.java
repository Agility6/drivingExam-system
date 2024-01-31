package com.t.jk.pojo.query;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * ClassName: DictItemQuery
 * Description:
 *
 * @Author agility6
 * @Create 2024/1/31 22:36
 * @Version: 1.0
 */

@EqualsAndHashCode(callSuper = true)
@Data
public class DictItemQuery extends KeywordQuery {

    private Integer typeId;

}
