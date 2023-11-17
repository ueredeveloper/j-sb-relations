package ueredeveloper.jsbrelations.services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ueredeveloper.jsbrelations.models.DocumentoModel;
import ueredeveloper.jsbrelations.repositories.DocumentoRepository;

import java.util.List;
import java.util.Optional;

@Service
public class DocumentoServiceImpl implements DocumentoService {

    @Autowired
    private DocumentoRepository documentoRepository;

    @Override
    public DocumentoModel findById(Long id) {
        Optional<DocumentoModel> optionalDocumento = documentoRepository.findById(id);
        return optionalDocumento.orElse(null);
    }

    @Override
    public List<DocumentoModel> getAllDocumentos() {
        return documentoRepository.findAll();
    }

    @Override
    public DocumentoModel createDocumento(DocumentoModel documento) {
        // Additional logic can be added before saving, if needed
        return documentoRepository.save(documento);
    }

    @Override
    public DocumentoModel updateDocumento(Long id, DocumentoModel updatedDocumento) {
        Optional<DocumentoModel> optionalDocumento = documentoRepository.findById(id);
        if (optionalDocumento.isPresent()) {
            DocumentoModel documentoToUpdate = optionalDocumento.get();
            // Update the fields of documentoToUpdate with values from updatedDocumento
            // For example: documentoToUpdate.setNumSEI(updatedDocumento.getNumSEI());
            // Then save the updated document
            return documentoRepository.save(documentoToUpdate);
        }
        return null; // Documento with given ID not found
    }

    public void deleteDocumento(Long id) {
        documentoRepository.deleteById(id);
    }
}

