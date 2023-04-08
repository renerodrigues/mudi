package br.com.alura.mvc.mudi;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {
        @Autowired
        private DataSource dataSource;

        @Bean
        public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
                http.authorizeHttpRequests()
                                .requestMatchers("/home/**")
                                .permitAll()
                                .anyRequest().authenticated()
                                .and()
                                .formLogin(form -> form
                                                .loginPage("/login")
                                                .defaultSuccessUrl("/usuario/pedido", true)
                                                .permitAll())
                                .logout(logout -> logout.logoutUrl("/logout")
                                                .logoutSuccessUrl("/home"))
                                // .csrf(withDefaults()); //.disable();
                                .csrf().disable();
                return http.build();
        }

        @Bean
        AuthenticationManager authenticationManager(
                        AuthenticationConfiguration authenticationConfiguration) throws Exception {
                return authenticationConfiguration.getAuthenticationManager();
        }

        @Autowired
        void registerProvider(AuthenticationManagerBuilder auth) throws Exception {
                BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
                auth.jdbcAuthentication()
                                .dataSource(dataSource)
                                .passwordEncoder(encoder);
        }

}