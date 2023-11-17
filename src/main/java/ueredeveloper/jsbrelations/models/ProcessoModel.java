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

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "processo")
public class ProcessoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column()
    private Long procId;
    
    @Column()
    private String procDescricao;

    // Other attributes of ProcessoModel

    @OneToMany(mappedBy = "docProcId", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnoreProperties("docProcId") // Ignore serialization of this property in DocumentoModel
    private List<DocumentoModel> procDocumentos;
    
    @OneToMany(mappedBy = "procPrincipal", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnoreProperties("procPrincipal") // Ignore serialization of this property in DocumentoModel
    private List<ProcessoModel> procProcessos;
    
    @ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "procPrincipal") // Corrected column name
	private ProcessoModel procPrincipal;
    
    public ProcessoModel () {
    	super();
    }
    
	public ProcessoModel(String procDescricao) {
		super();
		this.procDescricao = procDescricao;
	}
	
	public ProcessoModel(String procDescricao, ProcessoModel procPrincipal) {
		super();
		this.procDescricao = procDescricao;
		this.procPrincipal = procPrincipal;
	}

	public Long getProcId() {
		return procId;
	}

	public void setProcId(Long procId) {
		this.procId = procId;
	}

	public String getProcDescricao() {
		return procDescricao;
	}

	public void setProcDescricao(String procDescricao) {
		this.procDescricao = procDescricao;
	}


	public List<DocumentoModel> getProcDocumentos() {
		return procDocumentos;
	}

	public void setProcDocumentos(List<DocumentoModel> procDocumentos) {
		this.procDocumentos = procDocumentos;
	}

	public List<ProcessoModel> getProcProcessos() {
		return procProcessos;
	}

	public void setProcProcessos(List<ProcessoModel> procProcessos) {
		this.procProcessos = procProcessos;
	}

	public ProcessoModel getProcPrincipal() {
		return procPrincipal;
	}

	public void setProcPrincipal(ProcessoModel procPrincipal) {
		this.procPrincipal = procPrincipal;
	}

	
}



