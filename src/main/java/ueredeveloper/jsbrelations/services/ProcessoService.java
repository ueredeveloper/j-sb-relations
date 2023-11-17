package ueredeveloper.jsbrelations.services;

import org.springframework.stereotype.Service;

import ueredeveloper.jsbrelations.models.ProcessoModel;

import java.util.List;

@Service
public interface ProcessoService {
    ProcessoModel findById(Long id);

    List<ProcessoModel> getAllProcessos();

    ProcessoModel createProcesso(ProcessoModel processo);

    ProcessoModel updateProcesso(Long id, ProcessoModel processo);

    void deleteProcesso(Long id);
}
