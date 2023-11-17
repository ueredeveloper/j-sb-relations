package ueredeveloper.jsbrelations.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ueredeveloper.jsbrelations.models.DocumentoModel;
import ueredeveloper.jsbrelations.services.DocumentoService;

@RestController
@RequestMapping("/documento")
public class DocumentoController {

    private final DocumentoService documentoService;

    @Autowired
    public DocumentoController(DocumentoService documentoService) {
        this.documentoService = documentoService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<DocumentoModel> getDocumentoById(@PathVariable Long id) {
        DocumentoModel documento = documentoService.findById(id);
        if (documento != null) {
            return ResponseEntity.ok(documento);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping("/create")
    public ResponseEntity<DocumentoModel> createDocumento(@RequestBody DocumentoModel documento) {
        DocumentoModel createdDocumento = documentoService.createDocumento(documento);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdDocumento);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DocumentoModel> updateDocumento(@PathVariable Long id, @RequestBody DocumentoModel documento) {
        DocumentoModel updatedDocumento = documentoService.updateDocumento(id, documento);
        if (updatedDocumento != null) {
            return ResponseEntity.ok(updatedDocumento);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDocumento(@PathVariable Long id) {
        documentoService.deleteDocumento(id);
        return ResponseEntity.noContent().build();
    }
}

