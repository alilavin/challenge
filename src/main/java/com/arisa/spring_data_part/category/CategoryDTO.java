package com.arisa.spring_data_part.category;


import com.arisa.spring_data_part.product.Product;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.util.ArrayList;

@Setter @Getter
public class CategoryDTO {
    @ApiModelProperty(required = false,hidden = true)
    private Long id;

    @ApiModelProperty(required = true,hidden = false)
    private String title;


}
