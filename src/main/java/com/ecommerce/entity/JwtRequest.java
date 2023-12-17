package com.ecommerce.entity;

import lombok.*;

@Data
@Getter
@Setter
public class JwtRequest {

    private String userName;
    private String userPassword;
}
