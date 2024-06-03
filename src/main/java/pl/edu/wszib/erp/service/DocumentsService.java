package pl.edu.wszib.erp.service;

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

    @Override
    public Document get(Long id) {
        return repository.findById(id)
                .get();
    }

    @Override
    public Document create(Document document) {
        return repository.save(document);
    }

    @Override
    public Document update(Document document) {
        return repository.save(document);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
