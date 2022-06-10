package edu.miu.user_service.payload.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Set;

@AllArgsConstructor
@Setter
@Getter
public class SignupRequest {

    @NotBlank
    @Size(max = 40)
    private String username;

    @NotBlank
    @Size(min = 6, max = 20)
    private String password;

    private Set<String> roles;

   // private Account account;

    private String userType;


}
