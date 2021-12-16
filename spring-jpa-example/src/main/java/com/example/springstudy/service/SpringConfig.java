package com.example.springstudy.service;


import com.example.springstudy.aop.TimeTraceAop;
import com.example.springstudy.repository.JdbcTemplateMemberRepository;
import com.example.springstudy.repository.JpaMemberRepository;
import com.example.springstudy.repository.MemberRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.persistence.EntityManager;
import javax.sql.DataSource;

@Configuration
public class SpringConfig {

    private EntityManager em;
    private final MemberRepository memberRepository;
    private DataSource dataSource;

    public SpringConfig(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

//    @Bean
//    public MemberRepository memberRepository() {
//          return new JdbcTemplateMemberRepository(dataSource);
////        return new JpaMemberRepository(em);
//    }
}
