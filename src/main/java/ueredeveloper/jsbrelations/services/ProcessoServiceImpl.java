package ueredeveloper.jsbrelations.services;

import ueredeveloper.jsbrelations.models.ProcessoModel;
import ueredeveloper.jsbrelations.repositories.ProcessoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProcessoServiceImpl implements ProcessoService {

    private final ProcessoRepository processoRepository;

    @Autowired
    public ProcessoServiceImpl(ProcessoRepository processoRepository) {
        this.processoRepository = processoRepository;
    }

    @Override
    public ProcessoModel findById(Long id) {
        return processoRepository.findById(id).orElse(null);
    }

    @Override
    public List<ProcessoModel> getAllProcessos() {
        return processoRepository.findAll();
    }

    @Override
    public ProcessoModel createProcesso(ProcessoModel processo) {
        // Additional logic or validation before saving
        return processoRepository.save(processo);
    }

    @Override
    public ProcessoModel updateProcesso(Long id, ProcessoModel processo) {
        ProcessoModel existingProcesso = processoRepository.findById(id).orElse(null);
        if (existingProcesso != null) {
            // Update existingProcesso properties with processo properties
            // Save the updated entity
            return processoRepository.save(existingProcesso);
        }
        return null;
    }

    @Override
    public void deleteProcesso(Long id) {
        processoRepository.deleteById(id);
    }
}
