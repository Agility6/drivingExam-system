package com.t.jk.common.util;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * ClassName: Streams
 * Description:
 *
 * @Author agility6
 * @Create 2024/2/19 00:55
 * @Version: 1.0
 */
public class Streams {

    public static <T, R> List<R> map(List<T> list, Function<T, R> function) {
        return list.stream().map(function).collect(Collectors.toList());
    }
}
