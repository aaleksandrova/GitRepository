package ua.fidobank.provisions.service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import ua.fidobank.provisions.domain.CashFlowDeal;
import ua.fidobank.provisions.domain.CategoryOfDebt;
import ua.fidobank.provisions.domain.CategoryOfDebtService;
import ua.fidobank.provisions.domain.Client;
import ua.fidobank.provisions.domain.Currency;
import ua.fidobank.provisions.domain.Deal;
import ua.fidobank.provisions.domain.Sequrity;

public class ReadFile {

	public enum Fields {
		CONTRAGENTINN, CONTRAGENTID, CONTRAGENTNAME, CONTRAGENTKLASS, CONTRAGENTPOINTS, CONTRAGENTRESIDENCY, INSIDERS, DEALTYPE, DEALCODE, DEALNUMBER, DEALDATEON, DEALDATETO, DEALTRANSHCODE, DEALTRANSHNO, DEALOVERDUEPRINCIPALDEBT, DEALOVERDUEINTERESTDEBT, DEALOVERDUECOMISSIONDEBT, NEWDEALOVERDUEPRINCIPALDEBT, NEWDEALOVERDUEINTERESTDEBT, NEWDEALOVERDUECOMISSIONDEBT, NEWDEALMAXOVERDUE, NEWDEALOVERDUEENDOFMONTH, DEALCATEGORYOFDEPTSERVICE, DEALCATEGORYOFDEBT, DEALNUMBEROFRESTR, DEALDATEOFLASTRESTR, DEALCATEGORYOFLASTRESTR, DEALISVALIDRESTR, DEALESSENTIALITY, DEALRISK, DEALREVOCABLE, DEALDATEOFLASTRESTR3111, DEALNUMBEROFLASTRESTR, DEALEARNINGSOFFOREIGNCURRENCY, DEALPERIODOFPAYMENTPRINCIPAL, DEALPERIODOFPAYMENTINTEREST, DEALGROUPACCOUNT, DEALACCOUNT, DEALCURRENCYOFDEAL, DEALEXCHENGEOFCURRENCY, DEALSUMMOFPRINCIPAL, DEALSUMMOFPRINCIPALEQ, DEALSUMMOFDISCONT, DEALSUMMOFDISCONTEQ, DEALSUMMWITHOUTOFDISCONT, DEALSUMMWITHOUTOFDISCONTEQ, DEALSUMMOFINTEREST, DEALSUMMOFINTERESTEQ, DEALSUMMOFFEES, DEALSUMMOFFEESEQ, DEALSUMMONBALANCE, DEALSUMMONBALANCEEQ, DEALNOMINALRATE, DEALEFFECTIVERATEPERYEAR, DEALSUMMOFOVERDUE, DEALSUMMOFOVERDUEEQ, DEALAMOUNTOFREMUNERATIONRECEIVEDFORCOMMITMENTSANDGUARANTEES, DEALAMOUNTOFREMUNERATIONRECEIVEDFORCOMMITMENTSANDGUARANTEESEQ, DEALCURRENTVALUEOFASSET, DEALCURRENTVALUEOFASSETEQ, DEALCURRENTVALUEOFCREDIT, DEALCURRENTVALUEOFCREDITEQ, SEQURITYCODE, SEQURITYNUMBER, SEQURITYCURRENCY, SEQURITYEXCHENGECURRENCY, SEQURITYTYPESEQURITY, SEQURITYSUMOFSEQURITY, SEQURITYSUMOFSEQURITYEQ, SEQURITYSUMOFSEQURITYFORDEAL, SEQURITYSUMOFSEQURITYFORDEALEQ, SEQURITYKOEFICIENTLIKVIDNOSTY, SEQURITYDISCONTSUMMA, SEQURITYDISCONTSUMMAEQ, SEQURITYCOSTOFSALES, SEQURITYCOSTOFSALESEQ, SEQURITYSUMFUTURESEQPOTOKOV, SEQURITYSUMFUTURESEQPOTOKOVEQ, SEQURITYSROKREALIZACII, DEALPROVISIONOFPRINCIPAL, DEALPROVISIONOFPRINCIPALEQ, DEALPROVISIONOFEREST, DEALPROVISIONOFERESTEQ, DEALPROVISIONOFERESTLESS30DAYS, DEALPROVISIONOFERESTLESS30DAYSEQ, DEALPROVISIONOFERESTMORE30DAYS, DEALPROVISIONOFERESTMORE30DAYSEQ, DEALPROVISIONLASTPERIOD, DEALPROVISIONLASTPERIODEQ, DEALPROVISIONFACT, DEALPROVISIONFACTEQ, DEALCALCULATEDPROVISION, DEALCALCULATEDPROVISIONEQ, DEALDIFFERENCE, DEALDIFFERENCEEQ, DEALPROVISIONAFTER281220018, DEALPROVISIONAFTER281220018EQ, DEALGROUPEOFTOBO, DEALREGIONALCENTER, DEALNAMEOFTOBO, DEALMIGRACIYA, DEALPRODUCTTUPE, DEALPOSTANOVA82, DEALSECURITYMONITORING, DEALSECURITYOCENKA
	}

	public enum FieldsCF {
		CASHFLOWCONTRAGENTID, CASHFLOWCONTRAGENTNAME, CASHFLOWDEALTRANSHCODE, CASHFLOWDEALSUMMAPOTOKA, CASHFLOWDEALSUMMAPROCENTOV, CASHFLOWDEALSUMMATELA, CASHFLOWDEALKORREKCIYA, CASHFLOWDEALDISKONSUMMA
	}

	List<Sequrity> allSequrities = new ArrayList<Sequrity>(150000);
	List<CashFlowDeal> cashFlowDeals = new ArrayList<CashFlowDeal>();

	public List<Sequrity> getSequrities() {
		return allSequrities;
	}

	public void setSequrities(List<Sequrity> sequrities) {
		this.allSequrities = sequrities;
	}

	public List<CashFlowDeal> getCahFlowDeals() {
		return cashFlowDeals;
	}

	public void setCahFlowDeals(List<CashFlowDeal> cashFlowDeals) {
		this.cashFlowDeals = cashFlowDeals;
	}

	BufferedReader br = null;
	BufferedReader br1 = null;
	String delim = ";";
	boolean expectDelim = false;
	String prevToken = "";

	public void Read(Map<Long, Client> clients, Map<Long, Deal> deals)
			throws IOException {
		// System.out.println(clients);
		try {

			String line;

			br = new BufferedReader(new FileReader("D:/test2108.csv"));

			// int i1 = 0;
			while ((line = br.readLine()) != null) {
				// System.out.println("Line => " + i1);
				// if (++i1 % 5000 == 0) {
				// System.out.println("Flush memory for iteration " + i1);
				// System.gc();
				// }

				StringTokenizer stringTokenizer = new StringTokenizer(line,
						delim, true);
				// поля контрагента
				String _inn = null;
				Long _id = null;
				String _name = null;
				String _finStatus = "";
				int _points = 0;
				String _residency = null;
				String _insiders = null;
				Map<Long, Deal> _deals = null;
				// поля сделки I
				String _typeOfActive = null;
				Long _codeOfDeal = null;
				String _numberOfDeal = null;
				String _dateOn = null;
				String _dateTo = null;
				Long _codeOfTransaction = null;
				String _numberOfTransaction = null;
				int _overduePrincipalDebt = 0;
				int _overdueInterestDebt = 0;
				int _overdueComissionDebt = 0;
				int _newOverduePrincipalDebt = 0;
				int _newOverdueInterestDebt = 0;
				int _newOverdueComissionDebt = 0;
				int _newMaxOverdue = 0;
				int _newOverdueToEndOfMonth = 0;
				CategoryOfDebtService _catOfDebtService = null;
				CategoryOfDebtService _newCatOfDebtService = null;
				CategoryOfDebt _catOfDebt = null;
				CategoryOfDebt _newCatOfDebt = null;
				CategoryOfDebt _newCatOfDebtAfterRestr = null;
				int _numberOfRestr = 0;
				String _dateOfLastRestr = null;
				CategoryOfDebt _catLastRestr = null;
				String _isValidRestr = null;
				int _essentiality = 0;
				Double _risk = null;
				String _revocable = null;
				String _dateOfLastRestr3111 = null;
				int _numberOfRestr3111 = 0;
				String _earningsOfForeignCurrency = null;
				String _periodOfPaymentPrincipal = null;
				String _periodOfPaymentInterest = null;
				int _groupAccount = 0;
				String _account = null;
				Currency _currencyOfDeal = null;
				Double _exchengeOfCurrency = null;
				Double _summOfPrincipal = null;
				Double _summOfPrincipalEq = null;
				Double _summOfDiscont = null;
				Double _summOfDiscontEq = null;
				Double _summWithoutOfDiscont = null;
				Double _summWithoutOfDiscontEq = null;
				Double _summOfInterest = null;
				Double _summOfInterestEq = null;
				Double _summOfFees = null;
				Double _summOfFeesEq = null;
				Double _summOnBalance = null;
				Double _summOnBalanceEq = null;
				Double _nominalRate = null;
				Double _effectiveRatePerYear = null;
				Double _summOfOverdue = null;
				Double _summOfOverdueEq = null;
				Double _amountOfRemunerationReceivedForCommitmentsAndGuarantees = null;
				Double _amountOfRemunerationReceivedForCommitmentsAndGuaranteesEq = null;
				Double _currentValueOfAsset = null;
				Double _currentValueOfAssetEq = null;
				Double _currentValueOfCredit = null;
				Double _currentValueOfCreditEq = null;
				List<Sequrity> _sequrities = null;
				// /////////////////////
				Long _code = null;
				String _number = null;
				Currency _currency = null;
				Double _exchengeCurrency = null;
				String _typeSequrity = null;
				Double _sumOfSequrity = null;
				Double _sumOfSequrityEq = null;
				Double _sumOfSequrityForDeal = null;
				Double _sumOfSequrityForDealEq = null;
				Double _koeficientLikvidnosty = null;
				Double _discontSumma = 0d;
				Double _discontSummaEq = 0d;
				Double _costOfSales = null;
				Double _costOfSalesEq = null;
				Double _sumFutureSeqPotokov = null;
				Double _sumFutureSeqPotokovEq = null;
				int _srokRealizacii = 0;
				/******* новые поля вычисляемые *************/
				Double _sequrityMultiplyByLiquidity = 0d;
				Double _totalAmountOfDealSequrity = null;
				Double _coeficientSequrity = null;
				Double _costOfSale = null;
				Double _newSummOfSequrityEq = null;

				// /////////////////////////
				Double _provisionOfPrincipal = null;
				Double _provisionOfPrincipalEq = null;
				Double _provisionOfInterest = null;
				Double _provisionOfInterestEq = null;
				Double _provisionOfInterestLess30Days = null;
				Double _provisionOfInterestLess30DaysEq = null;
				Double _provisionOfInterestMore30Days = null;
				Double _provisionOfInterestMore30DaysEq = null;
				Double _provisionLastPeriod = null;
				Double _provisionLastPeriodEq = null;
				Double _provisionFact = null;
				Double _provisionFactEq = null;
				Double _calculatedProvision = null;
				Double _calculatedProvisionEq = null;
				Double _difference = null;
				Double _differenceEq = null;
				Double _change = null;
				Double _changeEq = null;
				String _groupeOfTOBO = null;
				String _regionalCenter = null;
				String _nameOfTobo = null;
				int _migraciya = 0;
				String _productTupe = null;
				int _postanova82 = 0;
				String _securityMonitoring = null;
				String _securityOcenka = null;
				/******* новые поля вычисляемые *************/
				Integer _easyCountOfProvisions = null;
				Double _firstIndicatorOfRisk = null;
				Double _secondIndicatorOfRisk = null;
				Double _resIndicatorOfRisk = null;
				Double _newCalculatedProvisionEq = null;
				Double _newdifferenceEq = null;
				Double _totalDiscontSummaOfSecurity = null;
				/******* новые поля вычисляемые *************/
				Double _newSumOfSequrityForDialEq = null;
				Double _balanceEqByNewRisk = null;
				Double _endSumOfSequrity = null;
				/******* новые поля CashFlow Report *************/

				Double _summaPotoka = null;
				Double _summaPotokaEq = null;

				for (Fields field : Fields.values())

					while (stringTokenizer.hasMoreTokens()) {
						String token = stringTokenizer.nextToken();
						if (delim.equals(token)) {
							if (expectDelim && prevToken != null) {
								expectDelim = false;
								break;
							} else {
								token = null;
							}
						}

						prevToken = token;
						expectDelim = true;

						if (token == null) {
							break;
						} else {
							switch (field) {

							case CONTRAGENTINN:
								_inn = token.toString();

								break;
							case CONTRAGENTID:
								_id = Long.parseLong(token.toString());

								break;
							case CONTRAGENTNAME:
								_name = token.toString();

								break;
							case CONTRAGENTKLASS:
								_finStatus = token.toString();

								break;
							case CONTRAGENTPOINTS:
								_points = Integer.parseInt(token.toString());
								break;
							case CONTRAGENTRESIDENCY:
								_residency = token.toString();

								break;
							case INSIDERS:
								_insiders = token.toString();
								break;

							case DEALTYPE:
								_typeOfActive = token.toString();
								break;
							case DEALCODE:
								_codeOfDeal = Long.parseLong(token.toString());
								break;
							case DEALNUMBER:
								_numberOfDeal = token.toString();
								break;
							case DEALDATEON:
								_dateOn = token.toString();
								break;
							case DEALDATETO:
								_dateTo = token.toString();
								break;
							case DEALTRANSHCODE:
								_codeOfTransaction = Long.parseLong(token
										.toString());
								break;
							case DEALTRANSHNO:
								_numberOfTransaction = token.toString();
								break;
							case DEALOVERDUEPRINCIPALDEBT:
								_overduePrincipalDebt = Integer.parseInt(token
										.toString());
								break;
							case DEALOVERDUEINTERESTDEBT:
								_overdueInterestDebt = Integer.parseInt(token
										.toString());
								break;
							case DEALOVERDUECOMISSIONDEBT:
								_overdueComissionDebt = Integer.parseInt(token
										.toString());
								break;
							case NEWDEALOVERDUEPRINCIPALDEBT:
								_newOverduePrincipalDebt = Integer
										.parseInt(token.toString());
								break;
							case NEWDEALOVERDUEINTERESTDEBT:
								_newOverdueInterestDebt = Integer
										.parseInt(token.toString());
								break;
							case NEWDEALOVERDUECOMISSIONDEBT:
								_newOverdueComissionDebt = Integer
										.parseInt(token.toString());
								break;
							case NEWDEALMAXOVERDUE:
								_newMaxOverdue = Integer.parseInt(token
										.toString());
								break;
							case NEWDEALOVERDUEENDOFMONTH:
								_newOverdueToEndOfMonth = Integer
										.parseInt(token.toString());
								break;
							case DEALCATEGORYOFDEPTSERVICE:
								_catOfDebtService = CategoryOfDebtService
										.valueOf(token.toString());
								break;
							case DEALCATEGORYOFDEBT:
								_catOfDebt = CategoryOfDebt.valueOf(token
										.toString());
								break;
							case DEALNUMBEROFRESTR:
								_numberOfRestr = Integer.parseInt(token
										.toString());
								break;
							case DEALDATEOFLASTRESTR:
								_dateOfLastRestr = token.toString();
								break;
							case DEALCATEGORYOFLASTRESTR:
								_catLastRestr = CategoryOfDebt.valueOf(token
										.toString());
								break;
							case DEALISVALIDRESTR:
								_isValidRestr = token.toString();
								break;
							case DEALESSENTIALITY:
								_essentiality = Integer.parseInt(token
										.toString());
								break;
							case DEALRISK:
								_risk = Double.parseDouble(token.toString()
										.replaceAll(" ", "").replace(',', '.'));
								break;
							case DEALREVOCABLE:
								_revocable = token.toString();
								break;
							case DEALDATEOFLASTRESTR3111:
								_dateOfLastRestr3111 = token.toString();
								break;
							case DEALNUMBEROFLASTRESTR:
								_numberOfRestr3111 = Integer.parseInt(token
										.toString());
								break;
							case DEALEARNINGSOFFOREIGNCURRENCY:
								_earningsOfForeignCurrency = token.toString();
								break;
							case DEALPERIODOFPAYMENTPRINCIPAL:
								_periodOfPaymentPrincipal = token.toString();
								break;
							case DEALPERIODOFPAYMENTINTEREST:
								_periodOfPaymentInterest = token.toString();
								break;
							case DEALGROUPACCOUNT:
								_groupAccount = Integer.parseInt(token
										.toString());
								break;
							case DEALACCOUNT:
								_account = token.toString();
								break;
							case DEALCURRENCYOFDEAL:
								_currencyOfDeal = Currency.valueOf(token
										.toString());
								break;
							case DEALEXCHENGEOFCURRENCY:
								_exchengeOfCurrency = Double.parseDouble(token
										.toString().replaceAll(" ", "")
										.replace(',', '.'));
								break;
							case DEALSUMMOFPRINCIPAL:
								_summOfPrincipal = Double.parseDouble(token
										.toString().replaceAll(" ", "")
										.replace(',', '.'));
								break;
							case DEALSUMMOFPRINCIPALEQ:

								_summOfPrincipalEq = Double.parseDouble(token
										.toString().replaceAll(" ", "")
										.replace(',', '.'));
								break;
							case DEALSUMMOFDISCONT:
								_summOfDiscont = Double.parseDouble(token
										.toString().replaceAll(" ", "")
										.replace(',', '.'));
								break;

							case DEALSUMMOFDISCONTEQ:
								_summOfDiscontEq = Double.parseDouble(token
										.toString().replaceAll(" ", "")
										.replace(',', '.'));
								break;
							case DEALSUMMWITHOUTOFDISCONT:
								_summWithoutOfDiscont = Double
										.parseDouble(token.toString()
												.replaceAll(" ", "")
												.replace(',', '.'));
								break;
							case DEALSUMMWITHOUTOFDISCONTEQ:
								_summWithoutOfDiscontEq = Double
										.parseDouble(token.toString()
												.replaceAll(" ", "")
												.replace(',', '.'));
								break;
							case DEALSUMMOFINTEREST:
								_summOfInterest = Double.parseDouble(token
										.toString().replaceAll(" ", "")
										.replace(',', '.'));
								break;
							case DEALSUMMOFINTERESTEQ:
								_summOfInterestEq = Double.parseDouble(token
										.toString().replaceAll(" ", "")
										.replace(',', '.'));
								break;
							case DEALSUMMOFFEES:
								_summOfFees = Double.parseDouble(token
										.toString().replaceAll(" ", "")
										.replace(',', '.'));
								break;
							case DEALSUMMOFFEESEQ:
								_summOfFeesEq = Double.parseDouble(token
										.toString().replaceAll(" ", "")
										.replace(',', '.'));
								break;
							case DEALSUMMONBALANCE:
								_summOnBalance = Double.parseDouble(token
										.toString().replaceAll(" ", "")
										.replace(',', '.'));
								break;
							case DEALSUMMONBALANCEEQ:
								_summOnBalanceEq = Double.parseDouble(token
										.toString().replaceAll(" ", "")
										.replace(',', '.'));
								break;
							case DEALNOMINALRATE:
								_nominalRate = Double.parseDouble(token
										.toString().replaceAll(" ", "")
										.replace(',', '.'));
								break;
							case DEALEFFECTIVERATEPERYEAR:
								_effectiveRatePerYear = Double
										.parseDouble(token.toString()
												.replaceAll(" ", "")
												.replace(',', '.'));
								break;
							case DEALSUMMOFOVERDUE:
								_summOfOverdue = Double.parseDouble(token
										.toString().replaceAll(" ", "")
										.replace(',', '.'));
								break;
							case DEALSUMMOFOVERDUEEQ:
								_summOfOverdueEq = Double.parseDouble(token
										.toString().replaceAll(" ", "")
										.replace(',', '.'));
								break;
							case DEALAMOUNTOFREMUNERATIONRECEIVEDFORCOMMITMENTSANDGUARANTEES:
								_amountOfRemunerationReceivedForCommitmentsAndGuarantees = Double
										.parseDouble(token.toString()
												.replaceAll(" ", "")
												.replace(',', '.'));
								break;
							case DEALAMOUNTOFREMUNERATIONRECEIVEDFORCOMMITMENTSANDGUARANTEESEQ:
								_amountOfRemunerationReceivedForCommitmentsAndGuaranteesEq = Double
										.parseDouble(token.toString()
												.replaceAll(" ", "")
												.replace(',', '.'));
								break;
							case DEALCURRENTVALUEOFASSET:
								_currentValueOfAsset = Double.parseDouble(token
										.toString().replaceAll(" ", "")
										.replace(',', '.'));
								break;
							case DEALCURRENTVALUEOFASSETEQ:
								_currentValueOfAssetEq = Double
										.parseDouble(token.toString()
												.replaceAll(" ", "")
												.replace(',', '.'));
								break;
							case DEALCURRENTVALUEOFCREDIT:
								_currentValueOfCredit = Double
										.parseDouble(token.toString()
												.replaceAll(" ", "")
												.replace(',', '.'));
								break;
							case DEALCURRENTVALUEOFCREDITEQ:
								_currentValueOfCreditEq = Double
										.parseDouble(token.toString()
												.replaceAll(" ", "")
												.replace(',', '.'));
								break;
							// //////////////////////////////////////////////////////
							case SEQURITYCODE:
								_code = Long.parseLong(token.toString());
								break;
							case SEQURITYNUMBER:
								_number = token.toString();
								break;
							case SEQURITYCURRENCY:
								_currency = Currency.valueOf(token.toString());
								break;
							case SEQURITYEXCHENGECURRENCY:
								_exchengeCurrency = Double.parseDouble(token
										.toString().replaceAll(" ", "")
										.replace(',', '.'));
								break;
							case SEQURITYTYPESEQURITY:
								_typeSequrity = token.toString();
								break;
							case SEQURITYSUMOFSEQURITY:
								_sumOfSequrity = Double.parseDouble(token
										.toString().replaceAll(" ", "")
										.replace(',', '.'));
								break;
							case SEQURITYSUMOFSEQURITYEQ:
								_sumOfSequrityEq = Double.parseDouble(token
										.toString().replaceAll(" ", "")
										.replace(',', '.'));
								break;
							case SEQURITYSUMOFSEQURITYFORDEAL:
								_sumOfSequrityForDeal = Double
										.parseDouble(token.toString()
												.replaceAll(" ", "")
												.replace(',', '.'));
								break;
							case SEQURITYSUMOFSEQURITYFORDEALEQ:
								_sumOfSequrityForDealEq = Double
										.parseDouble(token.toString()
												.replaceAll(" ", "")
												.replace(',', '.'));
								break;
							case SEQURITYKOEFICIENTLIKVIDNOSTY:
								_koeficientLikvidnosty = Double
										.parseDouble(token.toString()
												.replaceAll(" ", "")
												.replace(',', '.'));
								break;
							case SEQURITYDISCONTSUMMA:
								_discontSumma = Double.parseDouble(token
										.toString().replaceAll(" ", "")
										.replace(',', '.'));
								break;
							case SEQURITYDISCONTSUMMAEQ:
								_discontSummaEq = Double.parseDouble(token
										.toString().replaceAll(" ", "")
										.replace(',', '.'));
								break;
							case SEQURITYCOSTOFSALES:
								_costOfSales = Double.parseDouble(token
										.toString().replaceAll(" ", "")
										.replace(',', '.'));
								break;
							case SEQURITYCOSTOFSALESEQ:
								_costOfSalesEq = Double.parseDouble(token
										.toString().replaceAll(" ", "")
										.replace(',', '.'));
								break;
							case SEQURITYSUMFUTURESEQPOTOKOV:
								_sumFutureSeqPotokov = Double.parseDouble(token
										.toString().replaceAll(" ", "")
										.replace(',', '.'));
								break;
							case SEQURITYSUMFUTURESEQPOTOKOVEQ:
								_sumFutureSeqPotokovEq = Double
										.parseDouble(token.toString()
												.replaceAll(" ", "")
												.replace(',', '.'));
								break;
							case SEQURITYSROKREALIZACII:
								_srokRealizacii = Integer.parseInt(token
										.toString());
								break;
							// ////////////////////////////////////////////////
							case DEALPROVISIONOFPRINCIPAL:
								_provisionOfPrincipal = Double
										.parseDouble(token.toString()
												.replaceAll(" ", "")
												.replace(',', '.'));
								break;
							case DEALPROVISIONOFPRINCIPALEQ:
								_provisionOfPrincipalEq = Double
										.parseDouble(token.toString()
												.replaceAll(" ", "")
												.replace(',', '.'));
								break;
							case DEALPROVISIONOFEREST:
								_provisionOfInterest = Double.parseDouble(token
										.toString().replaceAll(" ", "")
										.replace(',', '.'));
								break;
							case DEALPROVISIONOFERESTEQ:
								_provisionOfInterestEq = Double
										.parseDouble(token.toString()
												.replaceAll(" ", "")
												.replace(',', '.'));
								break;
							case DEALPROVISIONOFERESTLESS30DAYS:
								_provisionOfInterestLess30Days = Double
										.parseDouble(token.toString()
												.replaceAll(" ", "")
												.replace(',', '.'));
								break;
							case DEALPROVISIONOFERESTLESS30DAYSEQ:
								_provisionOfInterestLess30DaysEq = Double
										.parseDouble(token.toString()
												.replaceAll(" ", "")
												.replace(',', '.'));
								break;
							case DEALPROVISIONOFERESTMORE30DAYS:
								_provisionOfInterestMore30Days = Double
										.parseDouble(token.toString()
												.replaceAll(" ", "")
												.replace(',', '.'));
								break;
							case DEALPROVISIONOFERESTMORE30DAYSEQ:
								_provisionOfInterestMore30DaysEq = Double
										.parseDouble(token.toString()
												.replaceAll(" ", "")
												.replace(',', '.'));
								break;
							case DEALPROVISIONLASTPERIOD:
								_provisionLastPeriod = Double.parseDouble(token
										.toString().replaceAll(" ", "")
										.replace(',', '.'));
								break;
							case DEALPROVISIONLASTPERIODEQ:
								_provisionLastPeriodEq = Double
										.parseDouble(token.toString()
												.replaceAll(" ", "")
												.replace(',', '.'));
								break;
							case DEALPROVISIONFACT:
								_provisionFact = Double.parseDouble(token
										.toString().replaceAll(" ", "")
										.replace(',', '.'));
								break;
							case DEALPROVISIONFACTEQ:
								_provisionFactEq = Double.parseDouble(token
										.toString().replaceAll(" ", "")
										.replace(',', '.'));
								break;
							case DEALCALCULATEDPROVISION:
								_calculatedProvision = Double.parseDouble(token
										.toString().replaceAll(" ", "")
										.replace(',', '.'));
								break;
							case DEALCALCULATEDPROVISIONEQ:
								_calculatedProvisionEq = Double
										.parseDouble(token.toString()
												.replaceAll(" ", "")
												.replace(',', '.'));
								break;
							case DEALDIFFERENCE:
								_difference = Double.parseDouble(token
										.toString().replaceAll(" ", "")
										.replace(',', '.'));
								break;
							case DEALDIFFERENCEEQ:
								_differenceEq = Double.parseDouble(token
										.toString().replaceAll(" ", "")
										.replace(',', '.'));
								break;
							case DEALPROVISIONAFTER281220018:
								_change = Double.parseDouble(token.toString()
										.replaceAll(" ", "").replace(',', '.'));
								break;
							case DEALPROVISIONAFTER281220018EQ:
								_changeEq = Double.parseDouble(token.toString()
										.replaceAll(" ", "").replace(',', '.'));
								break;
							case DEALGROUPEOFTOBO:
								_groupeOfTOBO = token.toString();
								break;
							case DEALREGIONALCENTER:
								_regionalCenter = token.toString();
								break;
							case DEALNAMEOFTOBO:
								_nameOfTobo = token.toString();
								break;
							case DEALMIGRACIYA:
								_migraciya = Integer.parseInt(token.toString());
								break;
							case DEALPRODUCTTUPE:
								_productTupe = token.toString();
								break;
							case DEALPOSTANOVA82:
								_postanova82 = Integer.parseInt(token
										.toString());
								break;
							case DEALSECURITYMONITORING:
								_securityMonitoring = token.toString();
								break;
							case DEALSECURITYOCENKA:
								_securityOcenka = token.toString();
								break;

							default:
								break;

							}

						}
					}
				Client c = new Client(_inn, _id, _name, _finStatus, _points,
						_residency, _insiders, _deals);
				Sequrity s = null;
				if (_code != null) {
					s = new Sequrity(_code, _codeOfTransaction, _number,
							_currency, _exchengeCurrency, _typeSequrity,
							_sumOfSequrity, _sumOfSequrityEq,
							_sumOfSequrityForDeal, _sumOfSequrityForDealEq,
							_koeficientLikvidnosty, _discontSumma,
							_discontSummaEq, _costOfSales, _costOfSalesEq,
							_sumFutureSeqPotokov, _sumFutureSeqPotokovEq,
							_srokRealizacii, _sequrityMultiplyByLiquidity,
							_totalAmountOfDealSequrity, _coeficientSequrity,
							_costOfSale, _newSummOfSequrityEq);
					allSequrities.add(s);
				}
				Deal d = new Deal(
						_id,
						_typeOfActive,
						_codeOfDeal,
						_numberOfDeal,
						_dateOn,
						_dateTo,
						_codeOfTransaction,
						_numberOfTransaction,
						_overduePrincipalDebt,
						_overdueInterestDebt,
						_overdueComissionDebt,
						_newOverduePrincipalDebt,
						_newOverdueInterestDebt,
						_newOverdueComissionDebt,
						_newMaxOverdue,
						_newOverdueToEndOfMonth,
						_catOfDebtService,
						_newCatOfDebtService,
						_catOfDebt,
						_newCatOfDebt,
						_newCatOfDebtAfterRestr,
						_numberOfRestr,
						_dateOfLastRestr,
						_catLastRestr,
						_isValidRestr,
						_essentiality,
						_risk,
						_revocable,
						_dateOfLastRestr3111,
						_numberOfRestr3111,
						_earningsOfForeignCurrency,
						_periodOfPaymentPrincipal,
						_periodOfPaymentInterest,
						_groupAccount,
						_account,
						_currencyOfDeal,
						_exchengeOfCurrency,
						_summOfPrincipal,
						_summOfPrincipalEq,
						_summOfDiscont,
						_summOfDiscontEq,
						_summWithoutOfDiscont,
						_summWithoutOfDiscontEq,
						_summOfInterest,
						_summOfInterestEq,
						_summOfFees,
						_summOfFeesEq,
						_summOnBalance,
						_summOnBalanceEq,
						_nominalRate,
						_effectiveRatePerYear,
						_summOfOverdue,
						_summOfOverdueEq,
						_amountOfRemunerationReceivedForCommitmentsAndGuarantees,
						_amountOfRemunerationReceivedForCommitmentsAndGuaranteesEq,
						_currentValueOfAsset, _currentValueOfAssetEq,
						_currentValueOfCredit, _currentValueOfCreditEq,
						_sequrities, _provisionOfPrincipal,
						_provisionOfPrincipalEq, _provisionOfInterest,
						_provisionOfInterestEq, _provisionOfInterestLess30Days,
						_provisionOfInterestLess30DaysEq,
						_provisionOfInterestMore30Days,
						_provisionOfInterestMore30DaysEq, _provisionLastPeriod,
						_provisionLastPeriodEq, _provisionFact,
						_provisionFactEq, _calculatedProvision,
						_calculatedProvisionEq, _difference, _differenceEq,
						_change, _changeEq, _groupeOfTOBO, _regionalCenter,
						_nameOfTobo, _migraciya, _productTupe, _postanova82,
						_securityMonitoring, _securityOcenka,
						_easyCountOfProvisions, _firstIndicatorOfRisk,
						_secondIndicatorOfRisk, _resIndicatorOfRisk,
						_newCalculatedProvisionEq, _newdifferenceEq,
						_totalDiscontSummaOfSecurity,
						_newSumOfSequrityForDialEq, _balanceEqByNewRisk,
						_endSumOfSequrity, _summaPotoka, _summaPotokaEq);

				if (clients.containsKey(c.getId()) == false) {
					if (deals.containsKey(d.getCodeOfTransaction()) == false) {
						if (d.getGroupAccount() != 912) {
							c.deals = new HashMap<Long, Deal>();
							c.deals.put(_codeOfTransaction, d);
							clients.put(_id, c);

						}
					}
				} else {
					if (deals.containsKey(d.getCodeOfTransaction()) == false) {
						if (d.getGroupAccount() != 912) {
							clients.get(c.getId()).deals.put(
									_codeOfTransaction, d);
						}
					}
				}

				if (deals.containsKey(d.getCodeOfTransaction()) == false) {
					if (d.getGroupAccount() != 912) {

						if (_code != null) {
							d.sequrities = new ArrayList<Sequrity>();
							d.sequrities.add(s);
						}
					deals.put(_codeOfTransaction, d);
					}
				} else {
					if (d.getGroupAccount() != 912) {
						if (_code != null) {
							deals.get(d.getCodeOfTransaction()).sequrities
									.add(s);
						}
					}
				}
			}
			System.out.println("Входные данные0" + deals.size());

			System.out.println("Входные данные1");
			for (int i = 0; i < allSequrities.size(); i++) {
				allSequrities.get(i).setTotalAmountOfDealSequrity(0.0);

			}

			/*
			 * HashMap<Long, Double> hm = new HashMap<Long, Double>(); for
			 * (Sequrity i : sequrities1) {
			 * 
			 * Double oldAmount = 0d; if (hm.containsKey(i.getCode())) {
			 * oldAmount = hm.get(i.getCode()); } hm.put(i.getCode(),
			 * i.getSequrityMultiplyByLiquidity() + oldAmount);
			 * 
			 * } System.out.println("size hm " + hm.size());
			 * System.out.println("hm " + hm.entrySet());
			 * 
			 * for (Sequrity s : sequrities1) {
			 * s.setTotalAmountOfDealSequrity(hm.get(s.getCode())); }
			 * System.out.println(sequrities1.size());
			 */

			for (Sequrity s : allSequrities) {
				if (s.getCode() != null) {
					s.setTotalAmountOfDealSequrity(s.getSumOfSequrityEq()
							* s.getKoeficientLikvidnosty());
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null)
					br.close();

			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}

		// /////////////////////////////
	}

	public void ReadCashFlow(Map<Long, Client> clients, Map<Long, Deal> deals)
			throws IOException {

		// read report cash flow /////////////////////////////////////////////
		try {

			String line;

			br1 = new BufferedReader(new FileReader("D:/CF_2108.csv"));

			while ((line = br1.readLine()) != null) {

				StringTokenizer stringTokenizerCashFlow = new StringTokenizer(
						line, delim, true);

				Long _id = null;
				String _name = null;
				Long _codeOfTransaction = null;
				Double _summaPotoka = null;
				Double _summaProcentov = null;
				Double _summaTela = null;
				Double _korrekciya = null;
				Double _diskonSumma = null;
				for (FieldsCF field : FieldsCF.values())

					while (stringTokenizerCashFlow.hasMoreTokens()) {
						String token = stringTokenizerCashFlow.nextToken();
						if (delim.equals(token)) {
							if (expectDelim && prevToken != null) {
								expectDelim = false;
								break;
							} else {
								token = null;
							}
						}

						prevToken = token;
						expectDelim = true;

						if (token == null) {
							break;
						} else {
							switch (field) {

							case CASHFLOWCONTRAGENTID:
								_id = Long.parseLong(token.toString());
								break;
							case CASHFLOWCONTRAGENTNAME:
								_name = token.toString();

								break;
							case CASHFLOWDEALTRANSHCODE:
								_codeOfTransaction = Long.parseLong(token
										.toString());
								break;
							case CASHFLOWDEALSUMMAPOTOKA:
								_summaPotoka = Double.parseDouble(token
										.toString());
								break;

							case CASHFLOWDEALSUMMAPROCENTOV:
								_summaProcentov = Double.parseDouble(token
										.toString());
								break;
							case CASHFLOWDEALSUMMATELA:
								_summaTela = Double.parseDouble(token
										.toString());
								break;
							case CASHFLOWDEALKORREKCIYA:
								_korrekciya = Double.parseDouble(token
										.toString());
								break;
							case CASHFLOWDEALDISKONSUMMA:
								_diskonSumma = Double.parseDouble(token
										.toString());
								break;
							default:
								break;

							}
						}
					}
				CashFlowDeal cf = new CashFlowDeal(_id, _name,
						_codeOfTransaction, _summaPotoka, _summaProcentov,
						_summaTela, _korrekciya, _diskonSumma);
				cashFlowDeals.add(cf);
				// System.out.println("CF: "+ cf.toString());
			}

			System.out.println("cashFlowDeals.size()" + cashFlowDeals.size());

			for (CashFlowDeal c : cashFlowDeals) {
				// System.out.println(" c.getCodeOfTransaction() : "
				// +c.getCodeOfTransaction());
				for (Deal d : deals.values()) {
					if (d.getCodeOfTransaction().equals(
							c.getCodeOfTransaction())) {
						d.setSummaPotoka(c.getSummaPotoka());
						d.setSummaPotokaEq(d.getSummaPotoka()
								* d.getExchengeOfCurrency());

					}
				}

			}

		}

		catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (br1 != null)
					br1.close();

			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}

	}
}
