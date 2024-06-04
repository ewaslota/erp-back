package pl.edu.wszib.erp.service;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import pl.edu.wszib.erp.model.Document;
import pl.edu.wszib.erp.repository.DocumentsRepository;

import java.util.List;

@Service
public class DocumentsService implements CrudService<Document, Long> {

    private final DocumentsRepository repository;

    public DocumentsService(DocumentsRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Document> list() {
        return repository.findAll();
    }

    public List<Document> list(String sortBy, String sortOrder) {
        return repository.findAll(
                Sort.by(
                        sortOrder.equals("asc") ?
                                Sort.Direction.ASC :
                                Sort.Direction.DESC,
                                    sortBy
                )
        );
    }

    @Override
    public Document get(Long id) {
        return repository.findById(id)
                .get();
    }

    @Override
    public Document create(Document document) {
        document.setId(null);
        return repository.save(document);
    }

    @Override
    public Document update(Document document) {
        Document existing = get(document.getId());
        existing.setId(document.getId());
        existing.setTitle(document.getTitle());
        existing.setDescription(document.getDescription());
        existing.setCreatedAt(document.getCreatedAt());
        existing.setUpdatedAt(document.getUpdatedAt());
        return repository.save(existing);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }
}