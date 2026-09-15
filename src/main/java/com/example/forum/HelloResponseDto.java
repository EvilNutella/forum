package com.example.forum;

import lombok.Data;

@Data // геттеры, сеттеры + equals, hash-code, toString + RequiredArgsConstructor
public class HelloResponseDto {
    private final String message;
}

/* Из-за static это поле принадлежит не конкретному объекту
        (ответу для отдельного пользователя), а всему классу в целом.
        В веб-приложении Spring это приведет к тому, что все пользователи
        будут видеть сообщение последнего авторизовавшегося или отправившего
        запрос человека, так как данные будут постоянно перезаписываться
        в одной общей ячейке памяти. */

// RequiredArgsConstructor - Не final поля не будут включены к сгенерированный конструктор
//        AllArgsConstructor - Вообще все поля будут включены в конструтор
//        NoArgsConstructor - будет ссгенерирован Конструктор вообще без параметров