package ueredeveloper.jsbrelations.controllers;

import org.springframework.beans.factory.annotation.Autowired;
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
import ueredeveloper.jsbrelations.models.ProcessoModel;
import ueredeveloper.jsbrelations.services.ProcessoService;

@RestController
@RequestMapping("/processo")
public class ProcessoController {

	private final ProcessoService processoService;

	@Autowired
	public ProcessoController(ProcessoService processoService) {
		this.processoService = processoService;
	}

	@GetMapping("/{id}")
	public ResponseEntity<ProcessoModel> getProcessoById(@PathVariable Long id) {
		ProcessoModel processo = processoService.findById(id);
		if (processo != null) {
			return ResponseEntity.ok(processo);
		}
		return ResponseEntity.notFound().build();
	}

	@PostMapping("/create")
	public ResponseEntity<ProcessoModel> createProcesso(@RequestBody ProcessoModel processo) {
		ProcessoModel createdProcesso = processoService.createProcesso(processo);
		return ResponseEntity.ok(createdProcesso);
	}

	@PutMapping("/{id}")
	public ResponseEntity<ProcessoModel> updateDocumento(@PathVariable Long id, @RequestBody ProcessoModel processo) {
		ProcessoModel updateProcesso = processoService.updateProcesso(id, processo);
		if (updateProcesso != null) {
			return ResponseEntity.ok(updateProcesso);
		}
		return ResponseEntity.notFound().build();
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteDocumento(@PathVariable Long id) {
		processoService.deleteProcesso(id);
		return ResponseEntity.noContent().build();
	}
}
