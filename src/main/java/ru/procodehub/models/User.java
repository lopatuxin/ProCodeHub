package ru.procodehub.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * Класс, представляющий сущность "Пользователь".
 * Пользователь - это зарегистрированный пользователь образовательной платформы.
 * Класс описывает основные характеристики пользователя.
 * @author Антон
 */
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;

    private String password;

    private String email;

    @Enumerated(EnumType.STRING)
    private UserRole userRole;
}
