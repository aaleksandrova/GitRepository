package ua.fidobank.provisions.domain;

public class CashFlowDeal {
	private Long id;
	private String name;
	private Long codeOfTransaction;
	private Double summaPotoka;
	private Double summaProcentov;
	private Double summaTela;
	private Double korrekciya;
	private Double diskonSumma;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Long getCodeOfTransaction() {
		return codeOfTransaction;
	}
	public void setCodeOfTransaction(Long codeOfTransaction) {
		this.codeOfTransaction = codeOfTransaction;
	}
	public Double getSummaPotoka() {
		return summaPotoka;
	}
	public void setSummaPotoka(Double summaPotoka) {
		this.summaPotoka = summaPotoka;
	}
	public Double getSummaProcentov() {
		return summaProcentov;
	}
	public void setSummaProcentov(Double summaProcentov) {
		this.summaProcentov = summaProcentov;
	}
	public Double getSummaTela() {
		return summaTela;
	}
	public void setSummaTela(Double summaTela) {
		this.summaTela = summaTela;
	}
	public Double getKorrekciya() {
		return korrekciya;
	}
	public void setKorrekciya(Double korrekciya) {
		this.korrekciya = korrekciya;
	}
	public Double getDiskonSumma() {
		return diskonSumma;
	}
	public void setDiskonSumma(Double diskonSumma) {
		this.diskonSumma = diskonSumma;
	}
	@Override
	public String toString() {
		return "CashFlowDeal [id=" + id + ", name=" + name
				+ ", codeOfTransaction=" + codeOfTransaction + ", summaPotoka="
				+ summaPotoka + ", summaProcentov=" + summaProcentov
				+ ", summaTela=" + summaTela + ", korrekciya=" + korrekciya
				+ ", diskonSumma=" + diskonSumma + "]";
	}
	public CashFlowDeal(Long id, String name, Long codeOfTransaction,
			Double summaPotoka, Double summaProcentov, Double summaTela,
			Double korrekciya, Double diskonSumma) {
	
		this.id = id;
		this.name = name;
		this.codeOfTransaction = codeOfTransaction;
		this.summaPotoka = summaPotoka;
		this.summaProcentov = summaProcentov;
		this.summaTela = summaTela;
		this.korrekciya = korrekciya;
		this.diskonSumma = diskonSumma;
	}
	
	
}
