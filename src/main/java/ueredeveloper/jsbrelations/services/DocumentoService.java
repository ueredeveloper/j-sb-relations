package ueredeveloper.jsbrelations.services;

import java.util.List;

import ueredeveloper.jsbrelations.models.DocumentoModel;

public interface DocumentoService {

	
    DocumentoModel findById(Long id);

    List<DocumentoModel> getAllDocumentos(); // This signature needs to match

    DocumentoModel createDocumento(DocumentoModel documento);

    DocumentoModel updateDocumento(Long id, DocumentoModel documento);

    void deleteDocumento(Long id);
}

