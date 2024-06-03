package pl.edu.wszib.erp.controller;

import pl.edu.wszib.erp.model.Document;
import pl.edu.wszib.erp.service.DocumentsService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/documents")
public class DocumentsController {

    private final DocumentsService service;

    public DocumentsController(DocumentsService service) {
        this.service = service;
    }

    @GetMapping
    public List<Document> list() {
        return service.list();
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
