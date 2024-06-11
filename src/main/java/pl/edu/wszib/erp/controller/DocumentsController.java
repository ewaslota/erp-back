package pl.edu.wszib.erp.controller;

import org.springframework.data.domain.Page;
import pl.edu.wszib.erp.model.Document;
import pl.edu.wszib.erp.service.DocumentsService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/documents")
public class DocumentsController {

    private final DocumentsService service;

    public DocumentsController(DocumentsService service) {
        this.service = service;
    }

    @GetMapping
    public Page<Document> list(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "25") int size,
            @RequestParam(defaultValue = "title") String[] sortColumns,
            @RequestParam(defaultValue = "asc") String[] sortDirections,
            @RequestParam(defaultValue = "title") String searchBy
    ) {
        return service.list(page, size, sortColumns, sortDirections, searchBy);
    }

    @GetMapping("/{id}")
    public Document get(@PathVariable Long id) {
        return service.get(id);
    }

    @PostMapping
    public Document create(@RequestBody Document document) {
        return service.create(document);
    }

    @PutMapping
    public Document update(@RequestBody Document document) {
        return service.update(document);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
