package com.diegoliveiraa.parkchatbot.repositories;

import com.diegoliveiraa.parkchatbot.entitys.Morador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface MoradorRepository extends JpaRepository<Morador, UUID> {

    @Override
    void deleteById(UUID uuid);
}
