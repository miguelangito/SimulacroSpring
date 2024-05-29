package com.riwi.simulacro.api.dto.request;

import org.springframework.context.support.BeanDefinitionDsl.Role;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserRequest {

    private String userName;
    private String password;
    private String email;
    private String fullName;
    private Role role;
}
