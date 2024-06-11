package pl.edu.wszib.erp.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import pl.edu.wszib.erp.model.Document;
import pl.edu.wszib.erp.repository.DocumentsRepository;
import pl.edu.wszib.erp.specifications.DocumentSpecifications;

import java.util.ArrayList;

@Service
public class DocumentsService implements CrudService<Document, Long> {

    private final DocumentsRepository repository;

    public DocumentsService(DocumentsRepository repository) {
        this.repository = repository;
    }

    public Page<Document> list(int page, int size, String[] sortColumns, String[] sortDirections, String searchBy) {
        ArrayList<Sort.Order> sortOrders = new ArrayList<>();

        for (int i = 0; i < sortColumns.length; i++) {

            String sortColumn = sortColumns[i];
            Sort.Direction sortDirection =
                    sortDirections.length > i && sortDirections[i].equalsIgnoreCase("desc")
                            ? Sort.Direction.DESC
                            : Sort.Direction.ASC;


            sortOrders.add(new Sort.Order(sortDirection, sortColumn));
        }

        Pageable pageable = PageRequest.of(page, size, Sort.by(sortOrders));

        return repository.findAll(DocumentSpecifications.documentSpecification(searchBy), pageable);
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