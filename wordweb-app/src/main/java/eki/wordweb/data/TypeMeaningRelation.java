package eki.wordweb.data;

import java.util.List;

import eki.common.constant.Complexity;
import eki.common.data.AbstractDataObject;
import eki.common.data.Classifier;

public class TypeMeaningRelation extends AbstractDataObject implements ComplexityType {

	private static final long serialVersionUID = 1L;

	private Long meaningId;

	private Long wordId;

	private String word;

	private String wordLang;

	private Integer homonymNr;

	private String aspectCode;

	private Classifier aspect;

	private Complexity complexity;

	private List<String> lexValueStateCodes;

	private List<Classifier> lexValueStates;

	private List<String> lexRegisterCodes;

	private List<Classifier> lexRegisters;

	private List<String> lexGovernmentValues;

	private String meaningRelTypeCode;

	private Classifier meaningRelType;

	public Long getMeaningId() {
		return meaningId;
	}

	public void setMeaningId(Long meaningId) {
		this.meaningId = meaningId;
	}

	public Long getWordId() {
		return wordId;
	}

	public void setWordId(Long wordId) {
		this.wordId = wordId;
	}

	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
	}

	public String getWordLang() {
		return wordLang;
	}

	public void setWordLang(String wordLang) {
		this.wordLang = wordLang;
	}

	public Integer getHomonymNr() {
		return homonymNr;
	}

	public void setHomonymNr(Integer homonymNr) {
		this.homonymNr = homonymNr;
	}

	public String getAspectCode() {
		return aspectCode;
	}

	public void setAspectCode(String aspectCode) {
		this.aspectCode = aspectCode;
	}

	public Classifier getAspect() {
		return aspect;
	}

	public void setAspect(Classifier aspect) {
		this.aspect = aspect;
	}

	public Complexity getComplexity() {
		return complexity;
	}

	public void setComplexity(Complexity complexity) {
		this.complexity = complexity;
	}

	public List<String> getLexValueStateCodes() {
		return lexValueStateCodes;
	}

	public void setLexValueStateCodes(List<String> lexValueStateCodes) {
		this.lexValueStateCodes = lexValueStateCodes;
	}

	public List<Classifier> getLexValueStates() {
		return lexValueStates;
	}

	public void setLexValueStates(List<Classifier> lexValueStates) {
		this.lexValueStates = lexValueStates;
	}

	public List<String> getLexRegisterCodes() {
		return lexRegisterCodes;
	}

	public void setLexRegisterCodes(List<String> lexRegisterCodes) {
		this.lexRegisterCodes = lexRegisterCodes;
	}

	public List<Classifier> getLexRegisters() {
		return lexRegisters;
	}

	public void setLexRegisters(List<Classifier> lexRegisters) {
		this.lexRegisters = lexRegisters;
	}

	public List<String> getLexGovernmentValues() {
		return lexGovernmentValues;
	}

	public void setLexGovernmentValues(List<String> lexGovernmentValues) {
		this.lexGovernmentValues = lexGovernmentValues;
	}

	public String getMeaningRelTypeCode() {
		return meaningRelTypeCode;
	}

	public void setMeaningRelTypeCode(String meaningRelTypeCode) {
		this.meaningRelTypeCode = meaningRelTypeCode;
	}

	public Classifier getMeaningRelType() {
		return meaningRelType;
	}

	public void setMeaningRelType(Classifier meaningRelType) {
		this.meaningRelType = meaningRelType;
	}

}
