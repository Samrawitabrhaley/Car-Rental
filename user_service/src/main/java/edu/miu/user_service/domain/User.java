package edu.miu.user_service.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Set;

@Entity
@Table(name = "users", uniqueConstraints = {
        @UniqueConstraint(columnNames = "username")
})
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String accountId;


    @NotBlank
    private String username;

    @NotBlank
    private String password;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(	name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;

//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "account_id")
//    private Account account;

    @NotBlank
    private String userType;

    public User(String accountId,String username, String password, Set<Role> roles, String userType) {
        this.accountId=accountId;
        this.username = username;
        this.password = password;
        this.roles = roles;
        this.userType = userType;
    }
}
