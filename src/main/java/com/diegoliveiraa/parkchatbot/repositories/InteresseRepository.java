package com.diegoliveiraa.parkchatbot.repositories;

import com.diegoliveiraa.parkchatbot.entitys.Interesse;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface InteresseRepository extends JpaRepository<Interesse, UUID> {
}
