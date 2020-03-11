package ru.project.chooselang.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.Set;

/**
 * User representation class
 * @author skwardlow
 * @version 1.0
 * @see UserDetails
 * @see Table
 * @see NoArgsConstructor
 * @see Entity
 */

@Getter
@Setter
@Entity
@Table(name = "usr")
@NoArgsConstructor
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    private String firstName;
    private String lastName;
    private String email;
    protected String username;
    protected String password;
    private boolean active;
    private String iconUrl;


    @ElementCollection(targetClass = Role.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "user_role",joinColumns = @JoinColumn(name = "user_id"))
    @Enumerated(EnumType.STRING)
    private Set<Role> roles;

    /**
     *
     * @param firstName
     * @param lastName
     * @param email
     * @param username
     * @param password
     */

    public User(String firstName, String lastName, String email, String username, String password){
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.username = username;
        this.password = password;
    }

    /**
     *
     * @return
     */

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return getRoles();
    }

    /**
     *
     * @return
     */

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    /**
     *
     * @return
     */

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    /**
     *
     * @return
     */

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    /**
     *
     * @return
     */

    @Override
    public boolean isEnabled() {
        return true;
    }

    /**
     *
     * @return
     */

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", active=" + active +
                ", iconUrl='" + iconUrl + '\'' +
                ", roles=" + roles +
                '}';
    }
}
