package ueredeveloper.jsbrelations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import ueredeveloper.jsbrelations.models.DocumentoModel;
import ueredeveloper.jsbrelations.repositories.DocumentoRepository;
import ueredeveloper.jsbrelations.services.DocumentoServiceImpl;

@ExtendWith(MockitoExtension.class)
@DataJpaTest
public class DocumentServiceSaveDocTest {

    @Mock
    private DocumentoRepository documentoRepository;

    @InjectMocks
    private DocumentoServiceImpl documentoService;

    @Test
    public void testSaveDocumento() {
        // Mocking a DocumentoModel object
        DocumentoModel documento = new DocumentoModel();
        documento.setDocNumSEI("ABC123");

        // Mocking the repository's save method to return the saved object
        when(documentoRepository.save(any(DocumentoModel.class))).thenReturn(documento);

        // Calling the service's save method
        DocumentoModel savedDocumento = documentoService.createDocumento(documento);

        // Verifying if the repository's save method was called once
        verify(documentoRepository, times(1)).save(any(DocumentoModel.class));

        // Asserting that the returned DocumentoModel object matches the mocked one
        assertEquals(documento.getDocNumSEI(), savedDocumento.getDocNumSEI());
    }
}
