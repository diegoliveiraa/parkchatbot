package com.diegoliveiraa.parkchatbot.entitys;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Entity(name = "vaga")
@Table(name = "tb-vaga")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Vaga {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String numeroVaga;
    private BigDecimal valorMensal;
    private LocalDateTime dataCadastro;

    @OneToOne()
    @JoinColumn(name = "proprietario_id")
    private Morador proprietario;

    @OneToMany(mappedBy = "vaga")
    private List<Aluguel> historicoAlugueis;
}
