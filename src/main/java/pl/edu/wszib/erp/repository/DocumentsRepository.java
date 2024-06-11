package pl.edu.wszib.erp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import pl.edu.wszib.erp.model.Document;


@Repository
public interface DocumentsRepository extends JpaRepository<Document, Long>, JpaSpecificationExecutor<Document> {
}
