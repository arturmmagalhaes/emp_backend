package com.backend.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.backend.domain.Empreendimento;

@Repository
public interface EmpreendimentoRepository extends JpaRepository<Empreendimento, Long>{
}
