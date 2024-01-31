package com.t.jk.pojo.query;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.Data;

/**
 * ClassName: KeywordQuery
 * Description:
 *
 * @Author agility6
 * @Create 2024/1/31 14:59
 * @Version: 1.0
 */

@Data
public class KeywordQuery extends PageQuery {

    private String keyword;
}
