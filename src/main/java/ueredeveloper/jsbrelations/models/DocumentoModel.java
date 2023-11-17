package ueredeveloper.jsbrelations.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "documento")
public class DocumentoModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "doc_id")
	private Long docId;

	@Column(name = "num_sei")
	private String numSEI;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "proc_id") // Corrected column name
	private ProcessoModel processo;

	public DocumentoModel() {
		super();

	}

	public DocumentoModel(String numSEI) {
		super();
		this.numSEI = numSEI;
	}

	public Long getDocId() {
		return docId;
	}

	public void setDocId(Long docId) {
		this.docId = docId;
	}

	public String getNumSEI() {
		return numSEI;
	}

	public void setNumSEI(String numSEI) {
		this.numSEI = numSEI;
	}

	public ProcessoModel getProcesso() {
		return processo;
	}

	public void setProcesso(ProcessoModel processo) {
		this.processo = processo;
	}

	

}
