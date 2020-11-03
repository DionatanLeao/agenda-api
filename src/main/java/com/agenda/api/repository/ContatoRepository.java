package com.agenda.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.agenda.api.entity.Contato;

@Repository
public interface ContatoRepository extends JpaRepository<Contato, Integer> {

}
