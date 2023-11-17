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

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "documento")
public class DocumentoModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column()
	private Long docId;

	@Column()
	private String docNumSEI;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn()
	@JsonIgnoreProperties("procDocumentos") // Ignore serialization of this property in ProcessoModel
	private ProcessoModel docProcId;

	public DocumentoModel() {
		super();

	}

	public DocumentoModel(String docNumSEI) {
		super();
		this.docNumSEI = docNumSEI;
	}

	public DocumentoModel(String docNumSEI, ProcessoModel docProcId) {
		super();
		this.docNumSEI = docNumSEI;
		this.docProcId = docProcId;
	}

	public Long getDocId() {
		return docId;
	}

	public void setDocId(Long docId) {
		this.docId = docId;
	}

	public String getDocNumSEI() {
		return docNumSEI;
	}

	public void setDocNumSEI(String docNumSEI) {
		this.docNumSEI = docNumSEI;
	}

	public ProcessoModel getDocProcId() {
		return docProcId;
	}

	public void setDocProcId(ProcessoModel docProcId) {
		this.docProcId = docProcId;
	}
	
	


}
