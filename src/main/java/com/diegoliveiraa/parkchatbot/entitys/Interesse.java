package com.diegoliveiraa.parkchatbot.entitys;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity(name = "interesse")
@Table(name = "tb_interesse")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Interesse {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @ManyToOne
    private Aluguel aluguel;
    @ManyToOne
    private Morador interessado;
    private LocalDateTime dataInteresse;
}