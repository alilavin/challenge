package com.arisa.spring_data_part.product;

import com.arisa.spring_data_part.category.Category;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class ProductDTO {

    @ApiModelProperty(required = false,hidden = true)
    private Long id;

    @ApiModelProperty(required = true,hidden = false)
    private String name;

    @ApiModelProperty(required = true,hidden = false)
    private String describe;

    @ApiModelProperty(required = true,hidden = false)
    private Category category;
}
