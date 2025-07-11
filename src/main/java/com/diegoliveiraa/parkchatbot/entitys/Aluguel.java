package com.diegoliveiraa.parkchatbot.entitys;

import com.diegoliveiraa.parkchatbot.dtos.aluguel.requests.AluguelOfferRequestDTO;
import com.diegoliveiraa.parkchatbot.enums.AluguelStatus;
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

    @Enumerated(EnumType.STRING)
    private AluguelStatus status;

    public Aluguel(AluguelOfferRequestDTO dto) {
        this.valorMensal = dto.valorMensal();
    }
}