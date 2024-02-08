package com.t.jk.pojo.dto;

import lombok.Data;

import java.util.List;

/**
 * ClassName: ProvinceDto
 * Description:
 *
 * @Author agility6
 * @Create 2024/2/8 14:44
 * @Version: 1.0
 */
@Data
public class ProvinceDto {
    private Integer id;
    private String name;
    private String plate;
    private List<CityDto> children;
}
