package ru.procodehub.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Класс, представляющий сущность "Студент".
 * Студент - это пользователь, зарегистрированный на образовательной платформе.
 * Класс описывает основные характеристики студента.
 * @author Антон
 */
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstname;

    private String lastname;

    @OneToOne
    private User user;
}
