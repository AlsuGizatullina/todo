package ru.alsu.todo.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Board {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private Long boardId;

    @Column
    private String name;

    @Column
    private String code;
}
