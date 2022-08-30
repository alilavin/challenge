package com.arisa.spring_data_part;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@OpenAPIDefinition(
        info = @Info(
                title = "Arisa Car",
                version = "1.0.0 beta",
                description = "First make a Category after that you can make a product",
                contact = @Contact(
                        name = "Ali Nourmohammadi",
                        email = "ali.nourmohammadi83@gmail.com"
                ),
                license = @License(
                        url = "http://www.arisa.com",
                        name = "Arisa"
                )
        )

)
@SpringBootApplication
public class SpringDataPartApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringDataPartApplication.class, args);
    }

}
