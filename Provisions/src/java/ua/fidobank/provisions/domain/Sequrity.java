package ua.fidobank.provisions.domain;

import java.io.Serializable;

public class Sequrity implements Serializable {
	private Long code;
	private Long codeDeal;
	private String number;
	private Currency currency;
	private Double exchengeCurrency;
	private String typeSequrity;
	private Double sumOfSequrity;
	private Double sumOfSequrityEq;
	private Double sumOfSequrityForDial;
	private Double sumOfSequrityForDialEq;
	private Double koeficientLikvidnosty;
	private Double discontSumma;
	private Double discontSummaEq;
	private Double costOfSales;
	private Double costOfSalesEq;
	private Double sumFutureSeqPotokov;
	private Double sumFutureSeqPotokovEq;
	private int srokRealizacii;
	/******* новые поля вычисляемые *************/
	private Double sequrityMultiplyByLiquidity;
	private Double totalAmountOfDealSequrity;
	private Double coeficientSequrity;
	private Double costOfSale;
	private Double newSummOfSequrityEq;

	public Sequrity() {
		
	}
	public Sequrity(Long code, Long codeDeal, String number, Currency currency,
			Double exchengeCurrency, String typeSequrity, Double sumOfSequrity,
			Double sumOfSequrityEq, Double sumOfSequrityForDial,
			Double sumOfSequrityForDialEq, Double koeficientLikvidnosty,
			Double discontSumma, Double discontSummaEq, Double costOfSales,
			Double costOfSalesEq, Double sumFutureSeqPotokov,
			Double sumFutureSeqPotokovEq, int srokRealizacii,
			Double sequrityMultiplyByLiquidity,
			Double totalAmountOfDealSequrity, Double coeficientSequrity,
			Double costOfSale, Double newSummOfSequrityEq) {
		super();
		this.code = code;
		this.codeDeal = codeDeal;
		this.number = number;
		this.currency = currency;
		this.exchengeCurrency = exchengeCurrency;
		this.typeSequrity = typeSequrity;
		this.sumOfSequrity = sumOfSequrity;
		this.sumOfSequrityEq = sumOfSequrityEq;
		this.sumOfSequrityForDial = sumOfSequrityForDial;
		this.sumOfSequrityForDialEq = sumOfSequrityForDialEq;
		this.koeficientLikvidnosty = koeficientLikvidnosty;
		this.discontSumma = discontSumma;
		this.discontSummaEq = discontSummaEq;
		this.costOfSales = costOfSales;
		this.costOfSalesEq = costOfSalesEq;
		this.sumFutureSeqPotokov = sumFutureSeqPotokov;
		this.sumFutureSeqPotokovEq = sumFutureSeqPotokovEq;
		this.srokRealizacii = srokRealizacii;
		this.sequrityMultiplyByLiquidity = sequrityMultiplyByLiquidity;
		this.totalAmountOfDealSequrity = totalAmountOfDealSequrity;
		this.coeficientSequrity = coeficientSequrity;
		this.costOfSale = costOfSale;
		this.newSummOfSequrityEq = newSummOfSequrityEq;
	}
	
	public Long getCodeDeal() {
		return codeDeal;
	}

	public void setCodeDeal(Long codeDeal) {
		this.codeDeal = codeDeal;
	}

	public Long getCode() {
		return code;
	}

	public void setCode(Long code) {
		this.code = code;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public Currency getCurrency() {
		return currency;
	}

	public void setCurrency(Currency currency) {
		this.currency = currency;
	}

	public Double getExchengeCurrency() {
		return exchengeCurrency;
	}

	public void setExchengeCurrency(Double exchengeCurrency) {
		this.exchengeCurrency = exchengeCurrency;
	}

	public String getTypeSequrity() {
		return typeSequrity;
	}

	public void setTypeSequrity(String typeSequrity) {
		this.typeSequrity = typeSequrity;
	}

	public Double getSumOfSequrity() {
		return sumOfSequrity;
	}

	public void setSumOfSequrity(Double sumOfSequrity) {
		this.sumOfSequrity = sumOfSequrity;
	}

	public Double getSumOfSequrityEq() {
		return sumOfSequrityEq;
	}

	public void setSumOfSequrityEq(Double sumOfSequrityEq) {
		this.sumOfSequrityEq = sumOfSequrityEq;
	}

	public Double getSumOfSequrityForDial() {
		return sumOfSequrityForDial;
	}

	public void setSumOfSequrityForDial(Double sumOfSequrityForDial) {
		this.sumOfSequrityForDial = sumOfSequrityForDial;
	}

	public Double getSumOfSequrityForDialEq() {
		return sumOfSequrityForDialEq;
	}

	public void setSumOfSequrityForDialEq(Double sumOfSequrityForDialEq) {
		this.sumOfSequrityForDialEq = sumOfSequrityForDialEq;
	}

	public Double getKoeficientLikvidnosty() {
		return koeficientLikvidnosty;
	}

	public void setKoeficientLikvidnosty(Double koeficientLikvidnosty) {
		this.koeficientLikvidnosty = koeficientLikvidnosty;
	}

	public Double getDiscontSumma() {
		return discontSumma;
	}

	public void setDiscontSumma(Double discontSumma) {
		this.discontSumma = discontSumma;
	}

	public Double getDiscontSummaEq() {
		return discontSummaEq;
	}

	public void setDiscontSummaEq(Double discontSummaEq) {
		this.discontSummaEq = discontSummaEq;
	}

	public Double getCostOfSales() {
		return costOfSales;
	}

	public void setCostOfSales(Double costOfSales) {
		this.costOfSales = costOfSales;
	}

	public Double getCostOfSalesEq() {
		return costOfSalesEq;
	}

	public void setCostOfSalesEq(Double costOfSalesEq) {
		this.costOfSalesEq = costOfSalesEq;
	}

	public Double getSumFutureSeqPotokov() {
		return sumFutureSeqPotokov;
	}

	public void setSumFutureSeqPotokov(Double sumFutureSeqPotokov) {
		this.sumFutureSeqPotokov = sumFutureSeqPotokov;
	}

	public Double getSumFutureSeqPotokovEq() {
		return sumFutureSeqPotokovEq;
	}

	public void setSumFutureSeqPotokovEq(Double sumFutureSeqPotokovEq) {
		this.sumFutureSeqPotokovEq = sumFutureSeqPotokovEq;
	}

	public int getSrokRealizacii() {
		return srokRealizacii;
	}

	public void setSrokRealizacii(int srokRealizacii) {
		this.srokRealizacii = srokRealizacii;
	}

	public Double getSequrityMultiplyByLiquidity() {
		return sequrityMultiplyByLiquidity;
	}

	public void setSequrityMultiplyByLiquidity(
			Double sequrityMultiplyByLiquidity) {
		this.sequrityMultiplyByLiquidity = sequrityMultiplyByLiquidity;
	}

	public Double getTotalAmountOfDealSequrity() {
		return totalAmountOfDealSequrity;
	}

	public void setTotalAmountOfDealSequrity(Double totalAmountOfDealSequrity) {
		this.totalAmountOfDealSequrity = totalAmountOfDealSequrity;
	}

	public Double getCoeficientSequrity() {
		return coeficientSequrity;
	}

	public void setCoeficientSequrity(Double coeficientSequrity) {
		this.coeficientSequrity = coeficientSequrity;
	}

	public Double getCostOfSale() {
		return costOfSale;
	}

	public void setCostOfSale(Double costOfSale) {
		this.costOfSale = costOfSale;
	}

	public Double getNewSummOfSequrityEq() {
		return newSummOfSequrityEq;
	}

	public void setNewSummOfSequrityEq(Double newSummOfSequrityEq) {
		this.newSummOfSequrityEq = newSummOfSequrityEq;
	}


	@Override
	public String toString() {
		return "Sequrity [code=" + code + ", codeDeal=" + codeDeal
				+ ", number=" + number + ", currency=" + currency
				+ ", exchengeCurrency=" + exchengeCurrency + ", typeSequrity="
				+ typeSequrity + ", sumOfSequrity=" + sumOfSequrity
				+ ", sumOfSequrityEq=" + sumOfSequrityEq
				+ ", sumOfSequrityForDial=" + sumOfSequrityForDial
				+ ", sumOfSequrityForDialEq=" + sumOfSequrityForDialEq
				+ ", koeficientLikvidnosty=" + koeficientLikvidnosty
				+ ", discontSumma=" + discontSumma + ", discontSummaEq="
				+ discontSummaEq + ", costOfSales=" + costOfSales
				+ ", costOfSalesEq=" + costOfSalesEq + ", sumFutureSeqPotokov="
				+ sumFutureSeqPotokov + ", sumFutureSeqPotokovEq="
				+ sumFutureSeqPotokovEq + ", srokRealizacii=" + srokRealizacii
				+ ", sequrityMultiplyByLiquidity="
				+ sequrityMultiplyByLiquidity + ", totalAmountOfDealSequrity="
				+ totalAmountOfDealSequrity + ", coeficientSequrity="
				+ coeficientSequrity + ", costOfSale=" + costOfSale
				+ ", newSummOfSequrityEq=" + newSummOfSequrityEq + "]";
	}

}
