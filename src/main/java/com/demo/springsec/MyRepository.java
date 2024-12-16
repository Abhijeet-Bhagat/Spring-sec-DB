package com.demo.springsec;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MyRepository extends JpaRepository<Myuser, Integer> {

    Myuser findByEmail(String uname);
}
