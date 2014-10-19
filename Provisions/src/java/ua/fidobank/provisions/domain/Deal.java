package ua.fidobank.provisions.domain;

import java.util.List;

public class Deal {
	private Long clientId;
	private String typeOfActive;
	private Long codeOfDeal;
	private String numberOfDeal;
	private String dateOn;
	private String dateTo;
	private Long codeOfTransaction;
	private String numberOfTransaction;
	private int overduePrincipalDebt;
	private int overdueInterestDebt;
	private int overdueComissionDebt;
	private int newOverduePrincipalDebt;
	private int newOverdueInterestDebt;
	private int newOverdueComissionDebt;
	private int newMaxOverdue;
	private int newOverdueToEndOfMonth;

	private CategoryOfDebtService catOfDebtService;
	private CategoryOfDebtService newCatOfDebtService;
	private CategoryOfDebt catOfDebt;
	private CategoryOfDebt newCatOfDebt;
	private CategoryOfDebt newCatOfDebtAfterRestr;
	private int numberOfRestr;
	private String dateOfLastRestr;
	private CategoryOfDebt catLastRestr;
	private String isValidRestr;
	private int essentiality;
	private Double risk;
	private String revocable;
	private String dateOfLastRestr3111;
	private int numberOfRestr3111;
	private String earningsOfForeignCurrency;
	private String periodOfPaymentPrincipal;
	private String periodOfPaymentInterest;
	private int groupAccount;
	private String account;
	private Currency currencyOfDeal;
	private Double exchengeOfCurrency;
	private Double summOfPrincipal;
	private Double summOfPrincipalEq;
	private Double summOfDiscont;
	private Double summOfDiscontEq;
	private Double summWithoutOfDiscont;
	private Double summWithoutOfDiscontEq;
	private Double summOfInterest;
	private Double summOfInterestEq;
	private Double summOfFees;
	private Double summOfFeesEq;
	private Double summOnBalance;
	private Double summOnBalanceEq;
	private Double nominalRate;
	private Double effectiveRatePerYear;
	private Double summOfOverdue;
	private Double summOfOverdueEq;
	private Double amountOfRemunerationReceivedForCommitmentsAndGuarantees;
	private Double amountOfRemunerationReceivedForCommitmentsAndGuaranteesEq;
	private Double currentValueOfAsset;
	private Double currentValueOfAssetEq;
	private Double currentValueOfCredit;
	private Double currentValueOfCreditEq;
	// //////////////////////////////////////
	public List<Sequrity> sequrities;

	// ///////////////////////////////////////
	private Double provisionOfPrincipal;
	private Double provisionOfPrincipalEq;
	private Double provisionOfInterest;
	private Double provisionOfInterestEq;
	private Double provisionOfInterestLess30Days;
	private Double provisionOfInterestLess30DaysEq;
	private Double provisionOfInterestMore30Days;
	private Double provisionOfInterestMore30DaysEq;
	private Double provisionLastPeriod;
	private Double provisionLastPeriodEq;
	private Double provisionFact;
	private Double provisionFactEq;
	private Double calculatedProvision;
	private Double calculatedProvisionEq;
	private Double difference;
	private Double differenceEq;
	private Double change;
	private Double changeEq;
	private String groupeOfTOBO;
	private String regionalCenter;
	private String nameOfTobo;
	private int migraciya;
	private String productTupe;
	private int postanova82;
	private String securityMonitoring;
	private String securityOcenka;
	/******* новые поля вычисляемые *************/
	private Integer easyCountOfProvisions;
	private Double firstIndicatorOfRisk;
	private Double secondIndicatorOfRisk;
	private Double resIndicatorOfRisk;
	private Double newCalculatedProvisionEq;
	private Double newdifferenceEq;
	private Double totalDiscontSummaOfSecurity;
	/******* новые поля вычисляемые *************/
	private Double newSumOfSequrityForDialEq;
	private Double balanceEqByNewRisk;
	private Double endSumOfSequrity;
	/******* новые поля CashFlow Report *************/
	private Double summaPotoka;
	private Double summaPotokaEq;

	public Deal() {

	}

	public Deal(Long clientId, java.lang.String typeOfActive, Long codeOfDeal,
			java.lang.String numberOfDeal, java.lang.String dateOn,
			java.lang.String dateTo, Long codeOfTransaction,
			java.lang.String numberOfTransaction, int overduePrincipalDebt,
			int overdueInterestDebt, int overdueComissionDebt,
			int newOverduePrincipalDebt, int newOverdueInterestDebt,
			int newOverdueComissionDebt, int newMaxOverdue,
			int newOverdueToEndOfMonth, CategoryOfDebtService catOfDebtService,
			CategoryOfDebtService newCatOfDebtService,
			CategoryOfDebt catOfDebt, CategoryOfDebt newCatOfDebt,
			CategoryOfDebt newCatOfDebtAfterRestr, int numberOfRestr,
			java.lang.String dateOfLastRestr, CategoryOfDebt catLastRestr,
			java.lang.String isValidRestr, int essentiality, Double risk,
			java.lang.String revocable, java.lang.String dateOfLastRestr3111,
			int numberOfRestr3111, java.lang.String earningsOfForeignCurrency,
			java.lang.String periodOfPaymentPrincipal,
			java.lang.String periodOfPaymentInterest, int groupAccount,
			java.lang.String account, Currency currencyOfDeal,
			Double exchengeOfCurrency, Double summOfPrincipal,
			Double summOfPrincipalEq, Double summOfDiscont,
			Double summOfDiscontEq, Double summWithoutOfDiscont,
			Double summWithoutOfDiscontEq, Double summOfInterest,
			Double summOfInterestEq, Double summOfFees, Double summOfFeesEq,
			Double summOnBalance, Double summOnBalanceEq, Double nominalRate,
			Double effectiveRatePerYear, Double summOfOverdue,
			Double summOfOverdueEq,
			Double amountOfRemunerationReceivedForCommitmentsAndGuarantees,
			Double amountOfRemunerationReceivedForCommitmentsAndGuaranteesEq,
			Double currentValueOfAsset, Double currentValueOfAssetEq,
			Double currentValueOfCredit, Double currentValueOfCreditEq,
			List<Sequrity> sequrities, Double provisionOfPrincipal,
			Double provisionOfPrincipalEq, Double provisionOfInterest,
			Double provisionOfInterestEq, Double provisionOfInterestLess30Days,
			Double provisionOfInterestLess30DaysEq,
			Double provisionOfInterestMore30Days,
			Double provisionOfInterestMore30DaysEq, Double provisionLastPeriod,
			Double provisionLastPeriodEq, Double provisionFact,
			Double provisionFactEq, Double calculatedProvision,
			Double calculatedProvisionEq, Double difference,
			Double differenceEq, Double change, Double changeEq,
			java.lang.String groupeOfTOBO, java.lang.String regionalCenter,
			java.lang.String nameOfTobo, int migraciya,
			java.lang.String productTupe, int postanova82,
			java.lang.String securityMonitoring,
			java.lang.String securityOcenka, Integer easyCountOfProvisions,
			Double firstIndicatorOfRisk, Double secondIndicatorOfRisk,
			Double resIndicatorOfRisk, Double newCalculatedProvisionEq,
			Double newdifferenceEq, Double totalDiscontSummaOfSecurity,
			Double newSumOfSequrityForDialEq, Double balanceEqByNewRisk,
			Double endSumOfSequrity, Double summaPotoka, Double summaPotokaEq) {
		super();
		this.clientId = clientId;
		this.typeOfActive = typeOfActive;
		this.codeOfDeal = codeOfDeal;
		this.numberOfDeal = numberOfDeal;
		this.dateOn = dateOn;
		this.dateTo = dateTo;
		this.codeOfTransaction = codeOfTransaction;
		this.numberOfTransaction = numberOfTransaction;
		this.overduePrincipalDebt = overduePrincipalDebt;
		this.overdueInterestDebt = overdueInterestDebt;
		this.overdueComissionDebt = overdueComissionDebt;
		this.newOverduePrincipalDebt = newOverduePrincipalDebt;
		this.newOverdueInterestDebt = newOverdueInterestDebt;
		this.newOverdueComissionDebt = newOverdueComissionDebt;
		this.newMaxOverdue = newMaxOverdue;
		this.newOverdueToEndOfMonth = newOverdueToEndOfMonth;
		this.catOfDebtService = catOfDebtService;
		this.newCatOfDebtService = newCatOfDebtService;
		this.catOfDebt = catOfDebt;
		this.newCatOfDebt = newCatOfDebt;
		this.newCatOfDebtAfterRestr = newCatOfDebtAfterRestr;
		this.numberOfRestr = numberOfRestr;
		this.dateOfLastRestr = dateOfLastRestr;
		this.catLastRestr = catLastRestr;
		this.isValidRestr = isValidRestr;
		this.essentiality = essentiality;
		this.risk = risk;
		this.revocable = revocable;
		this.dateOfLastRestr3111 = dateOfLastRestr3111;
		this.numberOfRestr3111 = numberOfRestr3111;
		this.earningsOfForeignCurrency = earningsOfForeignCurrency;
		this.periodOfPaymentPrincipal = periodOfPaymentPrincipal;
		this.periodOfPaymentInterest = periodOfPaymentInterest;
		this.groupAccount = groupAccount;
		this.account = account;
		this.currencyOfDeal = currencyOfDeal;
		this.exchengeOfCurrency = exchengeOfCurrency;
		this.summOfPrincipal = summOfPrincipal;
		this.summOfPrincipalEq = summOfPrincipalEq;
		this.summOfDiscont = summOfDiscont;
		this.summOfDiscontEq = summOfDiscontEq;
		this.summWithoutOfDiscont = summWithoutOfDiscont;
		this.summWithoutOfDiscontEq = summWithoutOfDiscontEq;
		this.summOfInterest = summOfInterest;
		this.summOfInterestEq = summOfInterestEq;
		this.summOfFees = summOfFees;
		this.summOfFeesEq = summOfFeesEq;
		this.summOnBalance = summOnBalance;
		this.summOnBalanceEq = summOnBalanceEq;
		this.nominalRate = nominalRate;
		this.effectiveRatePerYear = effectiveRatePerYear;
		this.summOfOverdue = summOfOverdue;
		this.summOfOverdueEq = summOfOverdueEq;
		this.amountOfRemunerationReceivedForCommitmentsAndGuarantees = amountOfRemunerationReceivedForCommitmentsAndGuarantees;
		this.amountOfRemunerationReceivedForCommitmentsAndGuaranteesEq = amountOfRemunerationReceivedForCommitmentsAndGuaranteesEq;
		this.currentValueOfAsset = currentValueOfAsset;
		this.currentValueOfAssetEq = currentValueOfAssetEq;
		this.currentValueOfCredit = currentValueOfCredit;
		this.currentValueOfCreditEq = currentValueOfCreditEq;
		this.sequrities = sequrities;
		this.provisionOfPrincipal = provisionOfPrincipal;
		this.provisionOfPrincipalEq = provisionOfPrincipalEq;
		this.provisionOfInterest = provisionOfInterest;
		this.provisionOfInterestEq = provisionOfInterestEq;
		this.provisionOfInterestLess30Days = provisionOfInterestLess30Days;
		this.provisionOfInterestLess30DaysEq = provisionOfInterestLess30DaysEq;
		this.provisionOfInterestMore30Days = provisionOfInterestMore30Days;
		this.provisionOfInterestMore30DaysEq = provisionOfInterestMore30DaysEq;
		this.provisionLastPeriod = provisionLastPeriod;
		this.provisionLastPeriodEq = provisionLastPeriodEq;
		this.provisionFact = provisionFact;
		this.provisionFactEq = provisionFactEq;
		this.calculatedProvision = calculatedProvision;
		this.calculatedProvisionEq = calculatedProvisionEq;
		this.difference = difference;
		this.differenceEq = differenceEq;
		this.change = change;
		this.changeEq = changeEq;
		this.groupeOfTOBO = groupeOfTOBO;
		this.regionalCenter = regionalCenter;
		this.nameOfTobo = nameOfTobo;
		this.migraciya = migraciya;
		this.productTupe = productTupe;
		this.postanova82 = postanova82;
		this.securityMonitoring = securityMonitoring;
		this.securityOcenka = securityOcenka;
		this.easyCountOfProvisions = easyCountOfProvisions;
		this.firstIndicatorOfRisk = firstIndicatorOfRisk;
		this.secondIndicatorOfRisk = secondIndicatorOfRisk;
		this.resIndicatorOfRisk = resIndicatorOfRisk;
		this.newCalculatedProvisionEq = newCalculatedProvisionEq;
		this.newdifferenceEq = newdifferenceEq;
		this.totalDiscontSummaOfSecurity = totalDiscontSummaOfSecurity;
		this.newSumOfSequrityForDialEq = newSumOfSequrityForDialEq;
		this.balanceEqByNewRisk = balanceEqByNewRisk;
		this.endSumOfSequrity = endSumOfSequrity;
		this.summaPotoka = summaPotoka;
		this.summaPotokaEq = summaPotokaEq;

	}

	public Double getSummaPotoka() {
		return summaPotoka;
	}

	public void setSummaPotoka(Double summaPotoka) {
		this.summaPotoka = summaPotoka;
	}

	public Double getSummaPotokaEq() {
		return summaPotokaEq;
	}

	public void setSummaPotokaEq(Double summaPotokaEq) {
		this.summaPotokaEq = summaPotokaEq;
	}

	public Double getNewSumOfSequrityForDialEq() {
		return newSumOfSequrityForDialEq;
	}

	public void setNewSumOfSequrityForDialEq(Double newSumOfSequrityForDialEq) {
		this.newSumOfSequrityForDialEq = newSumOfSequrityForDialEq;
	}

	public Double getBalanceEqByNewRisk() {
		return balanceEqByNewRisk;
	}

	public void setBalanceEqByNewRisk(Double balanceEqByNewRisk) {
		this.balanceEqByNewRisk = balanceEqByNewRisk;
	}

	public Double getEndSumOfSequrity() {
		return endSumOfSequrity;
	}

	public void setEndSumOfSequrity(Double endSumOfSequrity) {
		this.endSumOfSequrity = endSumOfSequrity;
	}

	public List<Sequrity> getSequrities() {
		if (sequrities == null || sequrities.isEmpty()) {
			return null;
		} else {
			return sequrities;
		}
	}

	public void setSequrities(List<Sequrity> sequrities) {
		if (sequrities == null || sequrities.isEmpty()) {
			this.sequrities = null;
		} else {
			this.sequrities = sequrities;
		}
	}

	public Long getClientId() {
		return clientId;
	}

	public void setClientId(Long clientId) {
		this.clientId = clientId;
	}

	public String getTypeOfActive() {
		return typeOfActive;
	}

	public void setTypeOfActive(String typeOfActive) {
		this.typeOfActive = typeOfActive;
	}

	public Long getCodeOfDeal() {
		return codeOfDeal;
	}

	public void setCodeOfDeal(Long codeOfDeal) {
		this.codeOfDeal = codeOfDeal;
	}

	public String getNumberOfDeal() {
		return numberOfDeal;
	}

	public void setNumberOfDeal(String numberOfDeal) {
		this.numberOfDeal = numberOfDeal;
	}

	public String getDateOn() {
		return dateOn;
	}

	public void String(String dateOn) {
		this.dateOn = dateOn;
	}

	public String getDateTo() {
		return dateTo;
	}

	public void setDateTo(String dateTo) {
		this.dateTo = dateTo;
	}

	public Long getCodeOfTransaction() {
		return codeOfTransaction;
	}

	public void setCodeOfTransaction(Long codeOfTransaction) {
		this.codeOfTransaction = codeOfTransaction;
	}

	public String getNumberOfTransaction() {
		return numberOfTransaction;
	}

	public void setNumberOfTransaction(String numberOfTransaction) {
		this.numberOfTransaction = numberOfTransaction;
	}

	public int getOverduePrincipalDebt() {
		return overduePrincipalDebt;
	}

	public void setOverduePrincipalDebt(int overduePrincipalDebt) {
		this.overduePrincipalDebt = overduePrincipalDebt;
	}

	public int getOverdueInterestDebt() {
		return overdueInterestDebt;
	}

	public void setOverdueInterestDebt(int overdueInterestDebt) {
		this.overdueInterestDebt = overdueInterestDebt;
	}

	public int getOverdueComissionDebt() {
		return overdueComissionDebt;
	}

	public void setOverdueComissionDebt(int overdueComissionDebt) {
		this.overdueComissionDebt = overdueComissionDebt;
	}

	public int getNewOverduePrincipalDebt() {
		return newOverduePrincipalDebt;
	}

	public void setNewOverduePrincipalDebt(int newOverduePrincipalDebt) {
		this.newOverduePrincipalDebt = newOverduePrincipalDebt;
	}

	public int getNewOverdueInterestDebt() {
		return newOverdueInterestDebt;
	}

	public void setNewOverdueInterestDebt(int newOverdueInterestDebt) {
		this.newOverdueInterestDebt = newOverdueInterestDebt;
	}

	public int getNewOverdueComissionDebt() {
		return newOverdueComissionDebt;
	}

	public void setNewOverdueComissionDebt(int newOverdueComissionDebt) {
		this.newOverdueComissionDebt = newOverdueComissionDebt;
	}

	public int getNewMaxOverdue() {
		return newMaxOverdue;
	}

	public void setNewMaxOverdue(int newMaxOverdue) {
		this.newMaxOverdue = newMaxOverdue;
	}

	public int getNewOverdueToEndOfMonth() {
		return newOverdueToEndOfMonth;
	}

	public void setNewOverdueToEndOfMonth(int newOverdueToEndOfMonth) {
		this.newOverdueToEndOfMonth = newOverdueToEndOfMonth;
	}

	public CategoryOfDebtService getCatOfDebtService() {
		return catOfDebtService;
	}

	public void setCatOfDebtService(CategoryOfDebtService catOfDebtService) {
		this.catOfDebtService = catOfDebtService;
	}

	public CategoryOfDebtService getNewCatOfDebtService() {
		return newCatOfDebtService;
	}

	public void setNewCatOfDebtService(CategoryOfDebtService newCatOfDebtService) {
		this.newCatOfDebtService = newCatOfDebtService;
	}

	public CategoryOfDebt getCatOfDebt() {
		return catOfDebt;
	}

	public void setCatOfDebtService(CategoryOfDebt catOfDebt) {
		this.catOfDebt = catOfDebt;
	}

	public int getNumberOfRestr() {
		return numberOfRestr;
	}

	public void setNumberOfRestr(int numberOfRestr) {
		this.numberOfRestr = numberOfRestr;
	}

	public String getDateOfLastRestr() {
		return dateOfLastRestr;
	}

	public void setDateOfLastRestr(String dateOfLastRestr) {
		this.dateOfLastRestr = dateOfLastRestr;
	}

	public CategoryOfDebt getCatLastRestr() {
		return catLastRestr;
	}

	public void setCatLastRestr(CategoryOfDebt catLastRestr) {
		this.catLastRestr = catLastRestr;
	}

	public String getIsValidRestr() {
		return isValidRestr;
	}

	public void setIsValidRestr(String isValidRestr) {
		this.isValidRestr = isValidRestr;
	}

	public int getEssentiality() {
		return essentiality;
	}

	public void setEssentiality(int essentiality) {
		this.essentiality = essentiality;
	}

	public Double getRisk() {
		return risk;
	}

	public void setRisk(Double risk) {
		this.risk = risk;
	}

	public String getRevocable() {
		return revocable;
	}

	public void setRevocable(String revocable) {
		this.revocable = revocable;
	}

	public String getDateOfLastRestr3111() {
		return dateOfLastRestr3111;
	}

	public void setDateOfLastRestr3111(String dateOfLastRestr3111) {
		this.dateOfLastRestr3111 = dateOfLastRestr3111;
	}

	public int getNumberOfRestr3111() {
		return numberOfRestr3111;
	}

	public void setNumberOfRestr3111(int numberOfRestr3111) {
		this.numberOfRestr3111 = numberOfRestr3111;
	}

	public String getEarningsOfForeignCurrency() {
		return earningsOfForeignCurrency;
	}

	public void setEarningsOfForeignCurrency(String earningsOfForeignCurrency) {
		this.earningsOfForeignCurrency = earningsOfForeignCurrency;
	}

	public String getPeriodOfPaymentPrincipal() {
		return periodOfPaymentPrincipal;
	}

	public void setPeriodOfPaymentPrincipal(String periodOfPaymentPrincipal) {
		this.periodOfPaymentPrincipal = periodOfPaymentPrincipal;
	}

	public String getPeriodOfPaymentInterest() {
		return periodOfPaymentInterest;
	}

	public void setPeriodOfPaymentInterest(String periodOfPaymentInterest) {
		this.periodOfPaymentInterest = periodOfPaymentInterest;
	}

	public int getGroupAccount() {
		return groupAccount;
	}

	public void setGroupAccount(int groupAccount) {
		this.groupAccount = groupAccount;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public Currency getCurrencyOfDeal() {
		return currencyOfDeal;
	}

	public void setCurrencyOfDeal(Currency currencyOfDeal) {
		this.currencyOfDeal = currencyOfDeal;
	}

	public Double getExchengeOfCurrency() {
		return exchengeOfCurrency;
	}

	public void setExchengeOfCurrency(Double exchengeOfCurrency) {
		this.exchengeOfCurrency = exchengeOfCurrency;
	}

	public Double getSummOfPrincipal() {
		return summOfPrincipal;
	}

	public void setSummOfPrincipal(Double summOfPrincipal) {
		this.summOfPrincipal = summOfPrincipal;
	}

	public Double getSummOfPrincipalEq() {
		return summOfPrincipalEq;
	}

	public void setSummOfPrincipalEq(Double summOfPrincipalEq) {
		this.summOfPrincipalEq = summOfPrincipalEq;
	}

	public Double getSummOfDiscont() {
		return summOfDiscont;
	}

	public void setSummOfDiscont(Double summOfDiscont) {
		this.summOfDiscont = summOfDiscont;
	}

	public Double getSummOfDiscontEq() {
		return summOfDiscontEq;
	}

	public void setSummOfDiscontEq(Double summOfDiscontEq) {
		this.summOfDiscontEq = summOfDiscontEq;
	}

	public Double getSummWithoutOfDiscont() {
		return summWithoutOfDiscont;
	}

	public void setSummWithoutOfDiscont(Double summWithoutOfDiscont) {
		this.summWithoutOfDiscont = summWithoutOfDiscont;
	}

	public Double getSummWithoutOfDiscontEq() {
		return summWithoutOfDiscontEq;
	}

	public void setSummWithoutOfDiscontEq(Double summWithoutOfDiscontEq) {
		this.summWithoutOfDiscontEq = summWithoutOfDiscontEq;
	}

	public Double getSummOfInterest() {
		return summOfInterest;
	}

	public void setSummOfInterest(Double summOfInterest) {
		this.summOfInterest = summOfInterest;
	}

	public Double getSummOfInterestEq() {
		return summOfInterestEq;
	}

	public void setSummOfInterestEq(Double summOfInterestEq) {
		this.summOfInterestEq = summOfInterestEq;
	}

	public Double getSummOfFees() {
		return summOfFees;
	}

	public void setSummOfFees(Double summOfFees) {
		this.summOfFees = summOfFees;
	}

	public Double getSummOfFeesEq() {
		return summOfFeesEq;
	}

	public void setSummOfFeesEq(Double summOfFeesEq) {
		this.summOfFeesEq = summOfFeesEq;
	}

	public Double getSummOnBalance() {
		return summOnBalance;
	}

	public void setSummOnBalance(Double summOnBalance) {
		this.summOnBalance = summOnBalance;
	}

	public Double getSummOnBalanceEq() {
		return summOnBalanceEq;
	}

	public void setSummOnBalanceEq(Double summOnBalanceEq) {
		this.summOnBalanceEq = summOnBalanceEq;
	}

	public Double getNominalRate() {
		return nominalRate;
	}

	public void setNominalRate(Double nominalRate) {
		this.nominalRate = nominalRate;
	}

	public Double getEffectiveRatePerYear() {
		return effectiveRatePerYear;
	}

	public void setEffectiveRatePerYear(Double effectiveRatePerYear) {
		this.effectiveRatePerYear = effectiveRatePerYear;
	}

	public Double getSummOfOverdue() {
		return summOfOverdue;
	}

	public void setSummOfOverdue(Double summOfOverdue) {
		this.summOfOverdue = summOfOverdue;
	}

	public Double getSummOfOverdueEq() {
		return summOfOverdueEq;
	}

	public void setSummOfOverdueEq(Double summOfOverdueEq) {
		this.summOfOverdueEq = summOfOverdueEq;
	}

	public Double getAmountOfRemunerationReceivedForCommitmentsAndGuarantees() {
		return amountOfRemunerationReceivedForCommitmentsAndGuarantees;
	}

	public void setAmountOfRemunerationReceivedForCommitmentsAndGuarantees(
			Double amountOfRemunerationReceivedForCommitmentsAndGuarantees) {
		this.amountOfRemunerationReceivedForCommitmentsAndGuarantees = amountOfRemunerationReceivedForCommitmentsAndGuarantees;
	}

	public Double getAmountOfRemunerationReceivedForCommitmentsAndGuaranteesEq() {
		return amountOfRemunerationReceivedForCommitmentsAndGuaranteesEq;
	}

	public void setAmountOfRemunerationReceivedForCommitmentsAndGuaranteesEq(
			Double amountOfRemunerationReceivedForCommitmentsAndGuaranteesEq) {
		this.amountOfRemunerationReceivedForCommitmentsAndGuaranteesEq = amountOfRemunerationReceivedForCommitmentsAndGuaranteesEq;
	}

	public Double getCurrentValueOfAsset() {
		return currentValueOfAsset;
	}

	public void setCurrentValueOfAsset(Double currentValueOfAsset) {
		this.currentValueOfAsset = currentValueOfAsset;
	}

	public Double getCurrentValueOfAssetEq() {
		return currentValueOfAssetEq;
	}

	public void setCurrentValueOfAssetEq(Double currentValueOfAssetEq) {
		this.currentValueOfAssetEq = currentValueOfAssetEq;
	}

	public Double getCurrentValueOfCredit() {
		return currentValueOfCredit;
	}

	public void setCurrentValueOfCredit(Double currentValueOfCredit) {
		this.currentValueOfCredit = currentValueOfCredit;
	}

	public Double getCurrentValueOfCreditEq() {
		return currentValueOfCreditEq;
	}

	public void setCurrentValueOfCreditEq(Double currentValueOfCreditEq) {
		this.currentValueOfCreditEq = currentValueOfCreditEq;
	}

	public Double getProvisionOfPrincipal() {
		return provisionOfPrincipal;
	}

	public void setProvisionOfPrincipal(Double provisionOfPrincipal) {
		this.provisionOfPrincipal = provisionOfPrincipal;
	}

	public Double getProvisionOfPrincipalEq() {
		return provisionOfPrincipalEq;
	}

	public void setProvisionOfPrincipalEq(Double provisionOfPrincipalEq) {
		this.provisionOfPrincipalEq = provisionOfPrincipalEq;
	}

	public Double getProvisionOfInterest() {
		return provisionOfInterest;
	}

	public void setProvisionOfInterest(Double provisionOfInterest) {
		this.provisionOfInterest = provisionOfInterest;
	}

	public Double getProvisionOfInterestEq() {
		return provisionOfInterestEq;
	}

	public void setProvisionOfInterestEq(Double provisionOfInterestEq) {
		this.provisionOfInterestEq = provisionOfInterestEq;
	}

	public Double getProvisionOfInterestLess30Days() {
		return provisionOfInterestLess30Days;
	}

	public void setProvisionOfInterestLess30Days(
			Double provisionOfInterestLess30Days) {
		this.provisionOfInterestLess30Days = provisionOfInterestLess30Days;
	}

	public Double getProvisionOfInterestLess30DaysEq() {
		return provisionOfInterestLess30DaysEq;
	}

	public void setProvisionOfInterestLess30DaysEq(
			Double provisionOfInterestLess30DaysEq) {
		this.provisionOfInterestLess30DaysEq = provisionOfInterestLess30DaysEq;
	}

	public Double getProvisionOfInterestMore30Days() {
		return provisionOfInterestMore30Days;
	}

	public void setProvisionOfInterestMore30Days(
			Double provisionOfInterestMore30Days) {
		this.provisionOfInterestMore30Days = provisionOfInterestMore30Days;
	}

	public Double getProvisionOfInterestMore30DaysEq() {
		return provisionOfInterestMore30DaysEq;
	}

	public void setProvisionOfInterestMore30DaysEq(
			Double provisionOfInterestMore30DaysEq) {
		this.provisionOfInterestMore30DaysEq = provisionOfInterestMore30DaysEq;
	}

	public Double getProvisionLastPeriod() {
		return provisionLastPeriod;
	}

	public void setProvisionLastPeriod(Double provisionLastPeriod) {
		this.provisionLastPeriod = provisionLastPeriod;
	}

	public Double getProvisionLastPeriodEq() {
		return provisionLastPeriodEq;
	}

	public void setProvisionLastPeriodEq(Double provisionLastPeriodEq) {
		this.provisionLastPeriodEq = provisionLastPeriodEq;
	}

	public Double getProvisionFact() {
		return provisionFact;
	}

	public void setProvisionFact(Double provisionFact) {
		this.provisionFact = provisionFact;
	}

	public Double getProvisionFactEq() {
		return provisionFactEq;
	}

	public void setProvisionFactEq(Double provisionFactEq) {
		this.provisionFactEq = provisionFactEq;
	}

	public Double getCalculatedProvision() {
		return calculatedProvision;
	}

	public void setCalculatedProvision(Double calculatedProvision) {
		this.calculatedProvision = calculatedProvision;
	}

	public Double getCalculatedProvisionEq() {
		return calculatedProvisionEq;
	}

	public void setCalculatedProvisionEq(Double calculatedProvisionEq) {
		this.calculatedProvisionEq = calculatedProvisionEq;
	}

	public Double getDifference() {
		return difference;
	}

	public void setDifference(Double difference) {
		this.difference = difference;
	}

	public Double getDifferenceEq() {
		return differenceEq;
	}

	public void setDifferenceEq(Double differenceEq) {
		this.differenceEq = differenceEq;
	}

	public Double getChange() {
		return change;
	}

	public void setChange(Double change) {
		this.change = change;
	}

	public Double getChangeEq() {
		return changeEq;
	}

	public void setChangeEq(Double changeEq) {
		this.changeEq = changeEq;
	}

	public String getGroupeOfTOBO() {
		return groupeOfTOBO;
	}

	public void setGroupeOfTOBO(String groupeOfTOBO) {
		this.groupeOfTOBO = groupeOfTOBO;
	}

	public String getRegionalCenter() {
		return regionalCenter;
	}

	public void setRegionalCenter(String regionalCenter) {
		this.regionalCenter = regionalCenter;
	}

	public String getNameOfTobo() {
		return nameOfTobo;
	}

	public void setNameOfTobo(String nameOfTobo) {
		this.nameOfTobo = nameOfTobo;
	}

	public int getMigraciya() {
		return migraciya;
	}

	public void setMigraciya(int migraciya) {
		this.migraciya = migraciya;
	}

	public String getProductTupe() {
		return productTupe;
	}

	public void setProductTupe(String productTupe) {
		this.productTupe = productTupe;
	}

	public int getPostanova82() {
		return postanova82;
	}

	public void setPostanova82(int postanova82) {
		this.postanova82 = postanova82;
	}

	public String getSecurityMonitoring() {
		return securityMonitoring;
	}

	public void setSecurityMonitoring(String securityMonitoring) {
		this.securityMonitoring = securityMonitoring;
	}

	public String getSecurityOcenka() {
		return securityOcenka;
	}

	public void setSecurityOcenka(String securityOcenka) {
		this.securityOcenka = securityOcenka;
	}

	public void setDateOn(String dateOn) {
		this.dateOn = dateOn;
	}

	public void setCatOfDebt(CategoryOfDebt catOfDebt) {
		this.catOfDebt = catOfDebt;
	}

	public CategoryOfDebt getNewCatOfDebt() {
		return newCatOfDebt;
	}

	public void setNewCatOfDebt(CategoryOfDebt newCatOfDebt) {
		this.newCatOfDebt = newCatOfDebt;
	}

	public CategoryOfDebt getNewCatOfDebtAfterRestr() {
		return newCatOfDebtAfterRestr;
	}

	public void setNewCatOfDebtAfterRestr(CategoryOfDebt newCatOfDebtAfterRestr) {
		this.newCatOfDebtAfterRestr = newCatOfDebtAfterRestr;
	}

	public Integer getEasyCountOfProvisions() {
		return easyCountOfProvisions;
	}

	public void setEasyCountOfProvisions(Integer easyCountOfProvisions) {
		this.easyCountOfProvisions = easyCountOfProvisions;
	}

	public Double getFirstIndicatorOfRisk() {
		return firstIndicatorOfRisk;
	}

	public void setFirstIndicatorOfRisk(Double firstIndicatorOfRisk) {
		this.firstIndicatorOfRisk = firstIndicatorOfRisk;
	}

	public Double getSecondIndicatorOfRisk() {
		return secondIndicatorOfRisk;
	}

	public void setSecondIndicatorOfRisk(Double secondIndicatorOfRisk) {
		this.secondIndicatorOfRisk = secondIndicatorOfRisk;
	}

	public Double getResIndicatorOfRisk() {
		return resIndicatorOfRisk;
	}

	public void setResIndicatorOfRisk(Double resIndicatorOfRisk) {
		this.resIndicatorOfRisk = resIndicatorOfRisk;
	}

	public Double getNewCalculatedProvisionEq() {
		return newCalculatedProvisionEq;
	}

	public void setNewCalculatedProvisionEq(Double newCalculatedProvisionEq) {
		this.newCalculatedProvisionEq = newCalculatedProvisionEq;
	}

	public Double getNewdifferenceEq() {
		return newdifferenceEq;
	}

	public void setNewdifferenceEq(Double newdifferenceEq) {
		this.newdifferenceEq = newdifferenceEq;
	}

	public Double getTotalDiscontSummaOfSecurity() {
		return totalDiscontSummaOfSecurity;
	}

	public void setTotalDiscontSummaOfSecurity(
			Double totalDiscontSummaOfSecurity) {
		this.totalDiscontSummaOfSecurity = totalDiscontSummaOfSecurity;
	}

	@Override
	public String toString() {
		return "Deal [clientId="
				+ clientId
				+ ", typeOfActive="
				+ typeOfActive
				+ ", codeOfDeal="
				+ codeOfDeal
				+ ", numberOfDeal="
				+ numberOfDeal
				+ ", dateOn="
				+ dateOn
				+ ", dateTo="
				+ dateTo
				+ ", codeOfTransaction="
				+ codeOfTransaction
				+ ", numberOfTransaction="
				+ numberOfTransaction
				+ ", overduePrincipalDebt="
				+ overduePrincipalDebt
				+ ", overdueInterestDebt="
				+ overdueInterestDebt
				+ ", overdueComissionDebt="
				+ overdueComissionDebt
				+ ", newOverduePrincipalDebt="
				+ newOverduePrincipalDebt
				+ ", newOverdueInterestDebt="
				+ newOverdueInterestDebt
				+ ", newOverdueComissionDebt="
				+ newOverdueComissionDebt
				+ ", newMaxOverdue="
				+ newMaxOverdue
				+ ", newOverdueToEndOfMonth="
				+ newOverdueToEndOfMonth
				+ ", catOfDebtService="
				+ catOfDebtService
				+ ", newCatOfDebtService="
				+ newCatOfDebtService
				+ ", catOfDebt="
				+ catOfDebt
				+ ", newCatOfDebt="
				+ newCatOfDebt
				+ ", newCatOfDebtAfterRestr="
				+ newCatOfDebtAfterRestr
				+ ", numberOfRestr="
				+ numberOfRestr
				+ ", dateOfLastRestr="
				+ dateOfLastRestr
				+ ", catLastRestr="
				+ catLastRestr
				+ ", isValidRestr="
				+ isValidRestr
				+ ", essentiality="
				+ essentiality
				+ ", risk="
				+ risk
				+ ", revocable="
				+ revocable
				+ ", dateOfLastRestr3111="
				+ dateOfLastRestr3111
				+ ", numberOfRestr3111="
				+ numberOfRestr3111
				+ ", earningsOfForeignCurrency="
				+ earningsOfForeignCurrency
				+ ", periodOfPaymentPrincipal="
				+ periodOfPaymentPrincipal
				+ ", periodOfPaymentInterest="
				+ periodOfPaymentInterest
				+ ", groupAccount="
				+ groupAccount
				+ ", account="
				+ account
				+ ", currencyOfDeal="
				+ currencyOfDeal
				+ ", exchengeOfCurrency="
				+ exchengeOfCurrency
				+ ", summOfPrincipal="
				+ summOfPrincipal
				+ ", summOfPrincipalEq="
				+ summOfPrincipalEq
				+ ", summOfDiscont="
				+ summOfDiscont
				+ ", summOfDiscontEq="
				+ summOfDiscontEq
				+ ", summWithoutOfDiscont="
				+ summWithoutOfDiscont
				+ ", summWithoutOfDiscontEq="
				+ summWithoutOfDiscontEq
				+ ", summOfInterest="
				+ summOfInterest
				+ ", summOfInterestEq="
				+ summOfInterestEq
				+ ", summOfFees="
				+ summOfFees
				+ ", summOfFeesEq="
				+ summOfFeesEq
				+ ", summOnBalance="
				+ summOnBalance
				+ ", summOnBalanceEq="
				+ summOnBalanceEq
				+ ", nominalRate="
				+ nominalRate
				+ ", effectiveRatePerYear="
				+ effectiveRatePerYear
				+ ", summOfOverdue="
				+ summOfOverdue
				+ ", summOfOverdueEq="
				+ summOfOverdueEq
				+ ", amountOfRemunerationReceivedForCommitmentsAndGuarantees="
				+ amountOfRemunerationReceivedForCommitmentsAndGuarantees
				+ ", amountOfRemunerationReceivedForCommitmentsAndGuaranteesEq="
				+ amountOfRemunerationReceivedForCommitmentsAndGuaranteesEq
				+ ", currentValueOfAsset=" + currentValueOfAsset
				+ ", currentValueOfAssetEq=" + currentValueOfAssetEq
				+ ", currentValueOfCredit=" + currentValueOfCredit
				+ ", currentValueOfCreditEq=" + currentValueOfCreditEq
				+ ", sequrities=" + sequrities + ", provisionOfPrincipal="
				+ provisionOfPrincipal + ", provisionOfPrincipalEq="
				+ provisionOfPrincipalEq + ", provisionOfInterest="
				+ provisionOfInterest + ", provisionOfInterestEq="
				+ provisionOfInterestEq + ", provisionOfInterestLess30Days="
				+ provisionOfInterestLess30Days
				+ ", provisionOfInterestLess30DaysEq="
				+ provisionOfInterestLess30DaysEq
				+ ", provisionOfInterestMore30Days="
				+ provisionOfInterestMore30Days
				+ ", provisionOfInterestMore30DaysEq="
				+ provisionOfInterestMore30DaysEq + ", provisionLastPeriod="
				+ provisionLastPeriod + ", provisionLastPeriodEq="
				+ provisionLastPeriodEq + ", provisionFact=" + provisionFact
				+ ", provisionFactEq=" + provisionFactEq
				+ ", calculatedProvision=" + calculatedProvision
				+ ", calculatedProvisionEq=" + calculatedProvisionEq
				+ ", difference=" + difference + ", differenceEq="
				+ differenceEq + ", change=" + change + ", changeEq="
				+ changeEq + ", groupeOfTOBO=" + groupeOfTOBO
				+ ", regionalCenter=" + regionalCenter + ", nameOfTobo="
				+ nameOfTobo + ", migraciya=" + migraciya + ", productTupe="
				+ productTupe + ", postanova82=" + postanova82
				+ ", securityMonitoring=" + securityMonitoring
				+ ", securityOcenka=" + securityOcenka
				+ ", easyCountOfProvisions=" + easyCountOfProvisions
				+ ", firstIndicatorOfRisk=" + firstIndicatorOfRisk
				+ ", secondIndicatorOfRisk=" + secondIndicatorOfRisk
				+ ", resIndicatorOfRisk=" + resIndicatorOfRisk
				+ ", newCalculatedProvisionEq=" + newCalculatedProvisionEq
				+ ", newdifferenceEq=" + newdifferenceEq
				+ ", totalDiscontSummaOfSecurity="
				+ totalDiscontSummaOfSecurity + ", newSumOfSequrityForDialEq="
				+ newSumOfSequrityForDialEq + ", balanceEqByNewRisk="
				+ balanceEqByNewRisk + ", endSumOfSequrity=" + endSumOfSequrity
				+ ", summaPotoka=" + summaPotoka + ", summaPotokaEq="
				+ summaPotokaEq + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime
				* result
				+ ((codeOfTransaction == null) ? 0 : codeOfTransaction
						.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Deal other = (Deal) obj;
		if (codeOfTransaction == null) {
			if (other.codeOfTransaction != null)
				return false;
		} else if (!codeOfTransaction.equals(other.codeOfTransaction)
				&& !account.equals(other.account))
			return false;
		return true;
	}

}
