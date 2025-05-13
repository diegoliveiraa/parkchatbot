package com.diegoliveiraa.parkchatbot.repositories;

import com.diegoliveiraa.parkchatbot.entitys.Aluguel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface AluguelRepository extends JpaRepository<Aluguel, UUID> {
}
