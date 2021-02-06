package com.example.springsecurity.auth;

import com.example.springsecurity.security.ApplicationUserRole;
import com.example.springsecurity.student.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static com.example.springsecurity.security.ApplicationUserRole.*;

@Repository("fake")
public class FakeApplicationUserDaoService implements ApplicationUserDao {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public Optional<ApplicationUser> selectApplicationUserByUsername(String username) {
        return getApplicationUser().stream().filter(applicationUser -> username.equals(applicationUser.getUsername())).findFirst();
    }

    public List<ApplicationUser> getApplicationUser() {
        List<ApplicationUser> applicationUsers = Arrays.asList(
                new ApplicationUser(STUDENT.grantedAuthorities(), passwordEncoder.encode("password"), "annSmith", true, true, true, true),
                new ApplicationUser(ADMIN.grantedAuthorities(), passwordEncoder.encode("password123"), "linda", true, true, true, true),
                new ApplicationUser(ADMINTRAINEE.grantedAuthorities(), passwordEncoder.encode("password"), "tom", true, true, true, true)
        );
        return applicationUsers;
    }
}
