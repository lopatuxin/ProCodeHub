package ru.procodehub.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

/**
 * Конфигурация безопасности приложения.
 * Определяет правила доступа и настройки аутентификации.
 * @author Антон
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig {

    /**
     * Конфигурация фильтра безопасности.
     * Указывает, какие URL-адреса доступны для всех пользователей (например, страница регистрации).
     *
     * @param http HttpSecurity объект для настройки правил доступа.
     * @return SecurityFilterChain для применения настроек безопасности.
     * @throws Exception если произошла ошибка при настройке правил доступа.
     */
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.
                authorizeHttpRequests(auth -> auth
                        .requestMatchers("/register").permitAll()
                );
        return http.build();
    }

    /**
     * Бин для кодирования паролей пользователей.
     * В этом примере используется BCryptPasswordEncoder.
     *
     * @return PasswordEncoder объект для безопасного хранения паролей.
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
