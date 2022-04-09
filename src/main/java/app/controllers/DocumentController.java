package app.controllers;

import app.dao.DocumentDAO;
import app.entity.Document;
import app.exception.DocumentNotFoundException;
import app.model.DocumentModel;
import app.transformer.DocumentTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/document")
public class DocumentController {

    @Autowired
    private DocumentDAO documentDAO;

    @Autowired
    private DocumentTransformer documentTransformer;

    @GetMapping("/{id}")
    public DocumentModel getDocument(@PathVariable(name = "id") Long id) {
        Optional<Document> user = documentDAO.findById(id);
        Document document = user.orElseThrow(() -> new DocumentNotFoundException(id));
        return documentTransformer.transform(document);
    }

    @PostMapping("/create")
    public Document createDocument(@RequestBody Document user) {
        return documentDAO.save(user);
    }

    @DeleteMapping("/{id}")
    public void deleteDocument(@PathVariable(name = "id") Long id) {
        documentDAO.deleteById(id);
    }

}
