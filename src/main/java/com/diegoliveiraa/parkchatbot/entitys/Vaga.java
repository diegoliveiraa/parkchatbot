package com.diegoliveiraa.parkchatbot.entitys;

import com.diegoliveiraa.parkchatbot.dtos.vaga.VagaRequestDTO;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Entity(name = "vaga")
@Table(name = "tb_vaga")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Vaga {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "vaga_id", nullable = false, updatable = false)
    private UUID id;
    private String numeroVaga;
    private LocalDateTime dataCadastro;

    @OneToOne()
    @JoinColumn(name = "proprietario_id")
    private Morador proprietario;

    @OneToMany(mappedBy = "vaga")
    private List<Aluguel> historicoAlugueis;

    public Vaga(VagaRequestDTO dto) {
        this.numeroVaga = dto.numeroVaga();

    }
}
