package ueredeveloper.jsbrelations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import ueredeveloper.jsbrelations.models.DocumentoModel;
import ueredeveloper.jsbrelations.models.ProcessoModel;
import ueredeveloper.jsbrelations.repositories.DocumentoRepository;
import ueredeveloper.jsbrelations.repositories.ProcessoRepository;

import java.util.Arrays;

@Component
public class DataLoader implements CommandLineRunner {

    private final DocumentoRepository documentoRepository;
    private final ProcessoRepository processoRepository;

    @Autowired
    public DataLoader(DocumentoRepository documentoRepository, ProcessoRepository processoRepository) {
        this.documentoRepository = documentoRepository;
        this.processoRepository = processoRepository;
    }

    @Override
    public void run(String... args) {
        createInitialDocumentos();
    }

    private void createInitialDocumentos() {
        DocumentoModel documento1 = new DocumentoModel();
        documento1.setNumSEI("SEI-001");

        DocumentoModel documento2 = new DocumentoModel();
        documento2.setNumSEI("SEI-002");

        DocumentoModel documento3 = new DocumentoModel();
        documento3.setNumSEI("SEI-003");

        documentoRepository.saveAll(Arrays.asList(documento1, documento2, documento3));
        
        ProcessoModel proc1 = new ProcessoModel();
        proc1.setProcDescricao("197.555.888/2015");
        
        processoRepository.save(proc1);
        
        DocumentoModel doc4 = new DocumentoModel();
        doc4.setProcesso(new ProcessoModel("197", proc1));
        
       documentoRepository.save(doc4);
    }
}

