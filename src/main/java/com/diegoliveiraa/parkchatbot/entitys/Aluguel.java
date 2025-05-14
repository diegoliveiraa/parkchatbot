package com.diegoliveiraa.parkchatbot.entitys;

import com.diegoliveiraa.parkchatbot.dtos.aluguel.AluguelRequestDTO;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity(name = "aluguel")
@Table(name = "tb_aluguel")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Aluguel {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne
    private Vaga vaga;
    @ManyToOne
    private Morador proprietario;
    @ManyToOne
    private Morador inquilino;

    private BigDecimal valorMensal;

    private LocalDateTime inicio;
    private LocalDateTime fim;

    private boolean ativo;

    public Aluguel(AluguelRequestDTO dto) {
        this.valorMensal = dto.valorMensal();
        this.inicio = dto.inicio();
        this.fim = dto.fim();
    }
}