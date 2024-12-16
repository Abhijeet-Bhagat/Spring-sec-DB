package com.demo.springsec;

import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

@Entity
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Myuser implements UserDetails {

    private static final String DEL = ",";
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Getter
    private String name;

    @Column(unique = true, nullable = false)
    private String email;
    private String password;
    @Getter
    private String authority;

    //dev --> deploying, monitoring, maintenance
    //qa --> monitoring, load_testing, perf_testing

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
       String[] auths = this.authority.split(DEL);
       return Arrays.stream(auths)
               .map(x -> new SimpleGrantedAuthority(x))
               .collect(Collectors.toList());
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
