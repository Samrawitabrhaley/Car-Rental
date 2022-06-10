package edu.miu.user_service.security.services;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class JwtPayload {

    private Long id;
    private String username;
    private String userType;

}
