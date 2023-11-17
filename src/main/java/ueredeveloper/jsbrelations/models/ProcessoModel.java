package ueredeveloper.jsbrelations.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "processo")
public class ProcessoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "proc_id")
    private Long processoId;
    
    @Column
    private String procDescricao;

    // Other attributes of ProcessoModel

    @OneToMany(mappedBy = "processo", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<DocumentoModel> documentos;
    
    @OneToMany(mappedBy = "processo", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ProcessoModel> processos;
    
    @ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "proc_principal") // Corrected column name
	private ProcessoModel processo;
    
    public ProcessoModel () {
    	super();
    }
    
	public ProcessoModel(String procDescricao) {
		super();
		this.procDescricao = procDescricao;
	}
	


	public ProcessoModel(String procDescricao, ProcessoModel processo) {
		super();
		this.procDescricao = procDescricao;
		this.processo = processo;
	}

	public Long getProcessoId() {
		return processoId;
	}

	public void setProcessoId(Long processoId) {
		this.processoId = processoId;
	}

	public List<DocumentoModel> getDocumentos() {
		return documentos;
	}

	public void setDocumentos(List<DocumentoModel> documentos) {
		this.documentos = documentos;
	}

	public String getProcDescricao() {
		return procDescricao;
	}

	public void setProcDescricao(String procDescricao) {
		this.procDescricao = procDescricao;
	}
	
	

    // Constructors, getters, setters, and other methods
    
    
}



