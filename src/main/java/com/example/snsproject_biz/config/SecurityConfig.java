package com.example.snsproject_biz.config;

import jakarta.servlet.DispatcherType;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfig{
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws  Exception{
        http.csrf().disable()
                .authorizeHttpRequests(request -> request
                        .dispatcherTypeMatchers(DispatcherType.FORWARD).permitAll()
                        .requestMatchers(new AntPathRequestMatcher("/auth/register/**")).permitAll()
                        .anyRequest().authenticated()
                ) // 어떤 요청이라도 인증필요
                .formLogin(login -> login
                        .loginPage("/login") // 커스텀 로그인 페이지 지정
                        .loginProcessingUrl("/") // submit 받을 경로
                        .usernameParameter("userid") // submit할 아이디
                        .passwordParameter("pw") // submit할 비밀번호
                        .defaultSuccessUrl("/", true) // 성공시 이동할 경로
                        .permitAll()
                ) // 폼 방식 로그인, 성공시 "/"로 이동(나중에 변경해야함)
                .logout(Customizer.withDefaults()); // 로그아웃은 기본설정

        return http.build();
    }
}
