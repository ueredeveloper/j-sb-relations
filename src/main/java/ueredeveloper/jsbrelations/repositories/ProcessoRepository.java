package ueredeveloper.jsbrelations.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ueredeveloper.jsbrelations.models.ProcessoModel;

@Repository
public interface ProcessoRepository extends JpaRepository<ProcessoModel, Long> {
    // You can add custom query methods here if needed
}

