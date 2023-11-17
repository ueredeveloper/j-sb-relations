package ueredeveloper.jsbrelations.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ueredeveloper.jsbrelations.models.DocumentoModel;

@Repository
public interface DocumentoRepository extends JpaRepository<DocumentoModel, Long> {
    // You can add custom query methods here if needed
}

