package ua.fidobank.provisions.service;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;

import ua.fidobank.provisions.domain.CategoryOfDebt;
import ua.fidobank.provisions.domain.CategoryOfDebtService;
import ua.fidobank.provisions.domain.Client;
import ua.fidobank.provisions.domain.Deal;
import ua.fidobank.provisions.domain.Sequrity;

public class Service {

	public Map<Long, Client> clients;
	public Map<Long, Deal> deals;
	int li = 0;

	public Service(Map<Long, Client> clients, Map<Long, Deal> deals) {

		this.clients = clients;
		this.deals = deals;
	}

	// public void ReadCashFlow() {
	//
	// }

	public Map<Long, Deal> setNewCategoryOfDebt(Map<Long, Client> clients,
			Map<Long, Deal> deals) {
		for (Deal d : deals.values()) {
			if (d.getEssentiality() == 1) {
				if (d.getNewOverdueToEndOfMonth() < 8) {
					d.setNewCatOfDebt(CategoryOfDebt.I);
					d.setNewCatOfDebtService(CategoryOfDebtService.Високий);
				} else if (d.getNewOverdueToEndOfMonth() < 31
						&& d.getNewOverdueToEndOfMonth() >= 8) {
					d.setNewCatOfDebt(CategoryOfDebt.II);
					d.setNewCatOfDebtService(CategoryOfDebtService.Добрий);
				} else if (d.getNewOverdueToEndOfMonth() < 91
						&& d.getNewOverdueToEndOfMonth() >= 31) {
					d.setNewCatOfDebt(CategoryOfDebt.III);
					d.setNewCatOfDebtService(CategoryOfDebtService.Задовільний);
				} else if (d.getNewOverdueToEndOfMonth() < 181
						&& d.getNewOverdueToEndOfMonth() >= 91) {
					d.setNewCatOfDebt(CategoryOfDebt.IV);
					d.setNewCatOfDebtService(CategoryOfDebtService.Слабкий);
				} else {
					d.setNewCatOfDebt(CategoryOfDebt.V);
					d.setNewCatOfDebtService(CategoryOfDebtService.Незадовільний);
				}

			}
			if (d.getEssentiality() == 0) {
				if (d.getNewOverdueToEndOfMonth() < 8) {
					d.setNewCatOfDebtService(CategoryOfDebtService.Високий);

					for (Client c : clients.values()) {
						try {
							if (c.getId().equals(d.getClientId())) {
								if (c.getFinStatus().equals("1 класс")
										|| c.getFinStatus().equals("2 класс")
										|| c.getFinStatus().equals("3 класс")
										|| c.getFinStatus().equals("4 класс")
										|| c.getFinStatus()
												.equals("Клас А - фінансовий стан добрий")
										|| c.getFinStatus()
												.equals("Клас Б - фінансовий стан задовільний")
										|| c.getFinStatus().equals("")) {
									d.setNewCatOfDebt(CategoryOfDebt.I);

								} else if (c.getFinStatus().equals("5 класс")
										|| c.getFinStatus().equals("6 класс")
										|| c.getFinStatus().equals("7 класс")
										|| c.getFinStatus().equals("8 класс")
										|| c.getFinStatus().equals("9 класс")
										|| c.getFinStatus()
												.equals("Клас В - фінансовий стан незадовільний")
										|| c.getFinStatus()
												.equals("Клас Г - фінансовий стан критичний")) {
									d.setNewCatOfDebt(CategoryOfDebt.II);

								}
							}
						} catch (Exception e) {
							System.err.println(e.toString());
							System.out.println(c.getId());
						}
					}

				} else if (d.getNewOverdueToEndOfMonth() < 31
						&& d.getNewOverdueToEndOfMonth() >= 8) {
					d.setNewCatOfDebtService(CategoryOfDebtService.Добрий);
					for (Client c : clients.values()) {
						if (c.getId().equals(d.getClientId())) {
							if (c.getFinStatus().equals("1 класс")
									|| c.getFinStatus().equals("2 класс")
									|| c.getFinStatus().equals("")) {
								d.setNewCatOfDebt(CategoryOfDebt.I);
							} else if (c.getFinStatus().equals("3 класс")
									|| c.getFinStatus().equals("4 класс")
									|| c.getFinStatus().equals("5 класс")
									|| c.getFinStatus().equals("6 класс")
									|| c.getFinStatus().equals(
											"Клас А - фінансовий стан добрий")
									|| c.getFinStatus()
											.equals("Клас Б - фінансовий стан задовільний")) {
								d.setNewCatOfDebt(CategoryOfDebt.II);
							} else if (c.getFinStatus().equals("7 класс")
									|| c.getFinStatus().equals("8 класс")
									|| c.getFinStatus().equals("9 класс")
									|| c.getFinStatus()
											.equals("Клас В - фінансовий стан незадовільний")
									|| c.getFinStatus()
											.equals("Клас Г - фінансовий стан критичний")) {
								d.setNewCatOfDebt(CategoryOfDebt.III);
							}
						}
					}
				} else if (d.getNewOverdueToEndOfMonth() < 91
						&& d.getNewOverdueToEndOfMonth() >= 31) {
					d.setNewCatOfDebtService(CategoryOfDebtService.Задовільний);
					for (Client c : clients.values()) {
						if (c.getId().equals(d.getClientId())) {
							if (c.getFinStatus().equals("1 класс")
									|| c.getFinStatus().equals("2 класс")
									|| c.getFinStatus().equals("3 класс")
									|| c.getFinStatus().equals("4 класс")
									|| c.getFinStatus().equals("5 класс")
									|| c.getFinStatus().equals(
											"Клас А - фінансовий стан добрий")
									|| c.getFinStatus()
											.equals("Клас Б - фінансовий стан задовільний")
									|| c.getFinStatus().equals("")) {
								d.setNewCatOfDebt(CategoryOfDebt.III);
							} else if (c.getFinStatus().equals("6 класс")
									|| c.getFinStatus().equals("7 класс")
									|| c.getFinStatus().equals("8 класс")
									|| c.getFinStatus().equals("9 класс")
									|| c.getFinStatus()
											.equals("Клас В - фінансовий стан незадовільний")
									|| c.getFinStatus()
											.equals("Клас Г - фінансовий стан критичний")) {
								d.setNewCatOfDebt(CategoryOfDebt.IV);
							}
						}
					}
				} else if (d.getNewOverdueToEndOfMonth() < 181
						&& d.getNewOverdueToEndOfMonth() >= 91) {
					d.setNewCatOfDebtService(CategoryOfDebtService.Слабкий);
					for (Client c : clients.values()) {
						if (c.getId().equals(d.getClientId())) {
							if (c.getFinStatus().equals("1 класс")
									|| c.getFinStatus().equals("2 класс")
									|| c.getFinStatus().equals("3 класс")
									|| c.getFinStatus().equals("4 класс")
									|| c.getFinStatus().equals("5 класс")
									|| c.getFinStatus().equals("6 класс")
									|| c.getFinStatus().equals("7 класс")
									|| c.getFinStatus().equals("8 класс")
									|| c.getFinStatus().equals(
											"Клас А - фінансовий стан добрий")
									|| c.getFinStatus()
											.equals("Клас Б - фінансовий стан задовільний")
									|| c.getFinStatus()
											.equals("Клас В - фінансовий стан незадовільний")
									|| c.getFinStatus().equals("")) {
								d.setNewCatOfDebt(CategoryOfDebt.IV);
							} else if (c.getFinStatus().equals("9 класс")
									|| c.getFinStatus()
											.equals("Клас Г - фінансовий стан критичний")) {
								d.setNewCatOfDebt(CategoryOfDebt.V);
							}
						}
					}
				} else {
					d.setNewCatOfDebtService(CategoryOfDebtService.Незадовільний);
					d.setNewCatOfDebt(CategoryOfDebt.V);
				}
			}
		}

		for (Deal d : deals.values()) {
			if (d.getGroupAccount() < 200) {
				d.setNewCatOfDebtService(d.getCatOfDebtService());
				d.setNewCatOfDebt(d.getCatOfDebt());
			}
		}
		return deals;
	}

	public void setNewCategoryOfDebtAfterRestr() {
		for (Deal d : deals.values()) {
			if (d.getCatLastRestr() == CategoryOfDebt.I) {
				d.setNewCatOfDebtAfterRestr(d.getNewCatOfDebt());
			} else if (d.getCatLastRestr() == CategoryOfDebt.II) {
				if (d.getNewCatOfDebt() == CategoryOfDebt.II
						|| d.getNewCatOfDebt() == CategoryOfDebt.III
						|| d.getNewCatOfDebt() == CategoryOfDebt.IV
						|| d.getNewCatOfDebt() == CategoryOfDebt.V) {
					d.setNewCatOfDebtAfterRestr(d.getNewCatOfDebt());
				} else {
					if (d.getIsValidRestr() != null) {
						d.setNewCatOfDebtAfterRestr(d.getNewCatOfDebt());
					} else {
						d.setNewCatOfDebtAfterRestr(CategoryOfDebt.II);
					}
				}
			} else if (d.getCatLastRestr() == CategoryOfDebt.III) {
				if (d.getNewCatOfDebt() == CategoryOfDebt.III
						|| d.getNewCatOfDebt() == CategoryOfDebt.IV
						|| d.getNewCatOfDebt() == CategoryOfDebt.V) {
					d.setNewCatOfDebtAfterRestr(d.getNewCatOfDebt());
				} else {
					if (d.getIsValidRestr() != null) {
						d.setNewCatOfDebtAfterRestr(d.getNewCatOfDebt());
					} else {
						d.setNewCatOfDebtAfterRestr(CategoryOfDebt.III);
					}
				}
			} else if (d.getCatLastRestr() == CategoryOfDebt.IV) {
				if (d.getNewCatOfDebt() == CategoryOfDebt.IV
						|| d.getNewCatOfDebt() == CategoryOfDebt.V) {
					d.setNewCatOfDebtAfterRestr(d.getNewCatOfDebt());
				} else {
					if (d.getIsValidRestr() != null) {
						d.setNewCatOfDebtAfterRestr(d.getNewCatOfDebt());
					} else {
						d.setNewCatOfDebtAfterRestr(CategoryOfDebt.IV);
					}
				}
			} else if (d.getCatLastRestr() == CategoryOfDebt.V) {

				if (d.getIsValidRestr() != null) {
					d.setNewCatOfDebtAfterRestr(d.getNewCatOfDebt());
				} else {
					d.setNewCatOfDebtAfterRestr(d.getCatLastRestr());
				}
			} else {
				d.setNewCatOfDebtAfterRestr(d.getNewCatOfDebt());
			}

		}
	}

	public void setVCat90days() {
		for (Deal d : deals.values()) {
			if (d.getCatOfDebt() == CategoryOfDebt.V
					&& d.getNewCatOfDebtAfterRestr() != CategoryOfDebt.V
					&& d.getNewOverdueToEndOfMonth() > 90
					&& (d.getSummOfOverdueEq() / d.getSummOnBalanceEq()) >= 0.5) {
				d.setNewCatOfDebtAfterRestr(CategoryOfDebt.V);
			}
		}
	}

	public void printMap(Map<Long, Deal> deals) {
		java.util.Iterator<Entry<Long, Deal>> it = deals.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry<Long, Deal> pairs = it.next();

			System.out.println(pairs.getKey() + " = " + pairs.getValue());

		}
	}

	public Map<Long, Deal> setWorseCategoryOfDebt(Map<Long, Deal> deals) {
		for (Deal d : deals.values()) {
			for (Deal d1 : deals.values()) {

				if (d.getNewCatOfDebtAfterRestr().ordinal() < d1
						.getNewCatOfDebtAfterRestr().ordinal())
					d.setNewCatOfDebtAfterRestr(d1.getNewCatOfDebtAfterRestr());
			}

		}
		return deals;
	}

	public void setIndicatorsOfRisk() {

		for (Deal d : deals.values()) {
			if (d.getNewCatOfDebtAfterRestr() != d.getCatOfDebt()) {
				if (d.getEssentiality() == 1) {
					if (d.getNewCatOfDebtAfterRestr() == CategoryOfDebt.I) {
						d.setResIndicatorOfRisk(0.02);
					} else if (d.getNewCatOfDebtAfterRestr() == CategoryOfDebt.II) {
						d.setResIndicatorOfRisk(0.1);
					} else if (d.getNewCatOfDebtAfterRestr() == CategoryOfDebt.III) {
						d.setResIndicatorOfRisk(0.4);
					} else if (d.getNewCatOfDebtAfterRestr() == CategoryOfDebt.IV) {
						d.setResIndicatorOfRisk(0.8);
					} else if (d.getNewCatOfDebtAfterRestr() == CategoryOfDebt.V) {
						d.setResIndicatorOfRisk(1.0);
					}
				}
				if (d.getEssentiality() == 0) {

					if (d.getNewCatOfDebtAfterRestr() == CategoryOfDebt.I) {
						d.setFirstIndicatorOfRisk(0.01);
						d.setSecondIndicatorOfRisk(0.06);
						for (Client c : clients.values()) {
							if (c.getId().equals(d.getClientId())) {

								d.setResIndicatorOfRisk(0.06 - (0.05 * (double) c
										.getPoints() / 100));
							}
						}
					} else if (d.getNewCatOfDebtAfterRestr() == CategoryOfDebt.II) {
						d.setFirstIndicatorOfRisk(0.07);
						d.setSecondIndicatorOfRisk(0.2);
						for (Client c : clients.values()) {
							if (c.getId().equals(d.getClientId())) {

								d.setResIndicatorOfRisk(0.2 - (0.13 * (double) c
										.getPoints() / 100));
							}
						}

					} else if (d.getNewCatOfDebtAfterRestr() == CategoryOfDebt.III) {
						d.setFirstIndicatorOfRisk(0.21);
						d.setSecondIndicatorOfRisk(0.5);
						for (Client c : clients.values()) {
							if (c.getId().equals(d.getClientId())) {

								d.setResIndicatorOfRisk(0.5 - (0.29 * (double) c
										.getPoints() / 100));
							}
						}

					} else if (d.getNewCatOfDebtAfterRestr() == CategoryOfDebt.IV) {
						d.setFirstIndicatorOfRisk(0.51);
						d.setSecondIndicatorOfRisk(0.99);
						for (Client c : clients.values()) {
							if (c.getId().equals(d.getClientId())) {

								d.setResIndicatorOfRisk(0.99 - (0.48 * (double) c
										.getPoints() / 100));
							}
						}
					} else if (d.getNewCatOfDebtAfterRestr() == CategoryOfDebt.V) {
						d.setFirstIndicatorOfRisk(1.0);
						d.setSecondIndicatorOfRisk(1.0);
						d.setResIndicatorOfRisk(1.0);
					}

				}
			}
		}
	}

	public void setIndicatorEasyCountOfProvisions() {
		for (Deal d : deals.values()) {
			if (d.getResIndicatorOfRisk() != null && d.getEssentiality() == 0) {
				if (d.getEffectiveRatePerYear() == null
						|| d.getEffectiveRatePerYear().equals("0")) {
					d.setEasyCountOfProvisions(1);
				}
			}
		}
	}

	public void calculateTotalDiscontSummaOfSecurity() {
		for (Deal d : deals.values()) {
			if (d.getResIndicatorOfRisk() != null
					&& d.getEasyCountOfProvisions() != null) {
				d.setTotalDiscontSummaOfSecurity(0.0);
				if (d.sequrities != null) {
					for (Sequrity s : d.sequrities) {
//						System.out.println(d);
						
//						System.out.println(s);
						if (s!=null) {
							d.setTotalDiscontSummaOfSecurity(d
									.getTotalDiscontSummaOfSecurity()
									+ s.getDiscontSummaEq());
						}
						
					}
				}
			}
		}
	}

	public void calculateNewProvision() {
		for (Deal d : deals.values()) {
			if (d.getResIndicatorOfRisk() != null) {
				if (d.getEssentiality() == 1) {
					d.setNewCalculatedProvisionEq(d.getSummOnBalanceEq()
							* d.getResIndicatorOfRisk());
					d.setNewdifferenceEq(d.getNewCalculatedProvisionEq()
							- d.getProvisionFactEq());
				} else if (d.getEssentiality() == 0) {
					if (d.getEasyCountOfProvisions() != null) {
						d.setNewCalculatedProvisionEq(d.getSummOnBalanceEq()
								- (d.getSummOnBalanceEq()
										* (1.0 - d.getResIndicatorOfRisk()) + d
											.getTotalDiscontSummaOfSecurity()));
						d.setNewdifferenceEq(d.getNewCalculatedProvisionEq()
								- d.getProvisionFactEq());
					} else {
						if(d.sequrities!=null){
						for (Sequrity s : d.sequrities) {
							if (s.getKoeficientLikvidnosty() != null) {
								s.setSequrityMultiplyByLiquidity(s
										.getSumOfSequrityForDialEq()
										* s.getKoeficientLikvidnosty());
							} else {
								s.setSequrityMultiplyByLiquidity(0d);
							}
							if (s.getSequrityMultiplyByLiquidity() > 0d) {
								s.setCoeficientSequrity(s
										.getSequrityMultiplyByLiquidity()
										/ s.getTotalAmountOfDealSequrity());
							} else {
								s.setCoeficientSequrity(1d);
							}
							s.setCostOfSale(s.getCoeficientSequrity()
									* s.getCostOfSales());
							s.setNewSummOfSequrityEq(s
									.getSequrityMultiplyByLiquidity()
									- s.getCostOfSale());
						}}
						d.setNewSumOfSequrityForDialEq(0d);
						if(d.sequrities!=null){
						for (Sequrity s : d.sequrities) {
							d.setNewSumOfSequrityForDialEq(d
									.getNewSumOfSequrityForDialEq()
									+ s.getNewSummOfSequrityEq());
						}}
						if (d.getSummaPotokaEq() != null) {
							d.setBalanceEqByNewRisk(d.getSummaPotokaEq()
									* d.getResIndicatorOfRisk());
						} else {
							d.setBalanceEqByNewRisk(0d);
						}
						d.setEndSumOfSequrity((d.getBalanceEqByNewRisk() > d
								.getNewSumOfSequrityForDialEq() ? d
								.getNewSumOfSequrityForDialEq() : d
								.getBalanceEqByNewRisk())
								/ (d.getEffectiveRatePerYear() / 100 + 1));
						d.setTotalDiscontSummaOfSecurity(d
								.getEndSumOfSequrity());
						d.setNewCalculatedProvisionEq(d.getSummOnBalanceEq()
								- (d.getCurrentValueOfAssetEq()
										* (1.0 - d.getResIndicatorOfRisk()) + d
											.getTotalDiscontSummaOfSecurity()));
						d.setNewdifferenceEq(d.getNewCalculatedProvisionEq()
								- d.getProvisionFactEq());
					}
				}
				// }
			} else {
				d.setNewCalculatedProvisionEq(d.getCalculatedProvisionEq());
				d.setNewdifferenceEq(d.getDifferenceEq());
			}
		}

		for (Deal d : deals.values()) {
			if (d.getNewCalculatedProvisionEq() < 0) {
				d.setNewCalculatedProvisionEq(0d);
				d.setNewdifferenceEq(d.getNewCalculatedProvisionEq()
						- d.getProvisionFactEq());
			}
		}

		for (Deal d : deals.values()) {
			if (d.getSummOnBalanceEq() == 0d) {
				d.setNewCalculatedProvisionEq(0d);
				d.setNewdifferenceEq(d.getDifferenceEq());
			}
		}
	}

	public void calcTotalAmountOfProvision() {
		double sum = 0;
		double changes = 0;
		for (Deal d : deals.values()) {

			sum += d.getNewCalculatedProvisionEq();
			changes += d.getNewdifferenceEq();
		}

		System.out.println("Total provision: " + sum);
		System.out.println("Total chages: " + changes);
	}

	public void MinusProv() {
		for (Deal d : deals.values()) {
			if (d.getNewCalculatedProvisionEq() < 0) {
				System.out.println(d.toString());
			}
		}
	}

	public void fileWriter(String sFileName) {
		File file = new File(sFileName);
		StringBuilder strBuilder = new StringBuilder();
		System.out.println("Стринг билдер new");

		System.out.println("new file");
		try {
			if (!file.exists()) {
				file.createNewFile();
			}
			PrintWriter pw = new PrintWriter(file.getAbsoluteFile());
			String str = "inn;	id;	name;	finStatus;	points;	residency;	insiders;	tupeOfActive;	codeOfDial;	numberOfDial;	dateOn;	dateTo;	codeOfTransaction;	numberOfTransaction;	overduePrincipalDebt;	overdueInterestDebt;	overdueComissionDebt;	newOverduePrincipalDebt;	newOverdueInterestDebt;	newOverdueComissionDebt;	newMaxOverdue;	newOverdueToEndOfMonth;	catOfDebtService;	newCatOfDebtService;	catOfDebt;	newCatOfDebt;	newCatOfDebtAfterRestr;	numberOfRestr;	dateOfLastRestr;	catLastRestr;	isValidRestr;	essentiality;	risk;	revocable;	dateOfLastRestr3111;	numberOfRestr3111;	earningsOfForeignCurrency;	periodOfPaymentPrincipal;	periodOfPaymentInterest;	groupAccount;	account;	currencyOfDial;	exchengeOfCurrency;	summOfPrincipal;	summOfPrincipalEq;	summOfDiscont;	summOfDiscontEq;	summWithoutOfDiscont;	summWithoutOfDiscontEq;	summOfInterest;	summOfInterestEq;	summOfFees;	summOfFeesEq;	summOnBalance;	summOnBalanceEq;	nominalRate;	effectiveRatePerYear;	summOfOverdue;	summOfOverdueEq;	amountOfRemunerationReceivedForCommitmentsAndGuarantees;	amountOfRemunerationReceivedForCommitmentsAndGuaranteesEq;	currentValueOfAsset;	currentValueOfAssetEq;	currentValueOfCredit;	currentValueOfCreditEq;	code;	number;	currency;	exchengeCurrency;	typeSequrity;	sumOfSequrity;	sumOfSequrityEq;	sumOfSequrityForDial;	sumOfSequrityForDialEq;	koeficientLikvidnosty;	discontSumma;	discontSummaEq;	costOfSales;	costOfSalesEq;	sumFutureSeqPotokov;	sumFutureSeqPotokovEq;	srokRealizacii;	sequrityMultiplyByLiquidity;	totalAmountOfDealSequrity;	coeficientSequrity;	costOfSale;	newSummOfSequrityEq;	newSumOfSequrityForDialEq;	balanceEqByNewRisk;	summaPotoka; summaPotokaEq; endSumOfSequrity;totalDiscontSummaOfSecurity;	provisionOfPrincipal;	provisionOfPrincipalEq;	provisionOfInterest;	provisionOfInterestEq;	provisionOfInterestLess30Days;	provisionOfInterestLess30DaysEq;	provisionOfInterestMore30Days;	provisionOfInterestMore30DaysEq;	provisionLastPeriod;	provisionLastPeriodEq;	provisionFact;	provisionFactEq;	calculatedProvision;	calculatedProvisionEq;	difference;	differenceEq;	provisionAfter281220018;	provisionAfter281220018Eq;	groupeOfTOBO;	regionalCenter;	nameOfTobo;	migraciya;	productTupe;	postanova82;	securityMonitoring;	securityOcenka;	easyCountOfProvisions;	firstIndicatorOfRisk;	secondIndicatorOfRisk;	resIndicatorOfRisk;	newCalculatedProvisionEq;	newdifferenceEq;";
			String str1 = "0;	1;	2;	3;	4;	5;	6;	7;	8;	9;	10;	11;	12;	13;	14;	15;	16;	17;	18;	19;	20;	21;	22;	23;	24;	25;	26;	27;	28;	29;	30;	31;	32;	33;	34;	35;	36;	37;	38;	39;	40;	41;	42;	43;	44;	45;	46;	47;	48;	49;	50;	51;	52;	53;	54;	55;	56;	57;	58;	59;	60;	61;	62;	63;	64;	65;	66;	67;	68;	69;	70;	71;	72;	73;	74;	75;	76;	77;	78;	79;	80;	81;	82;	83;	84;	85;	86;	87;	88;	89;	90;	91;	92;	93;	94;	95;	96;	97;	98;	99;	100;	101;	102;	103;	104;	105;	106;	107;	108;	109;	110;	111;	112;	113;	114;	115;	116;	117;	118;	119;	120;	121;	122;	123;	124;";
			String str2 = "Ид. код контрагента;	Код контрагента;	Наименование контрагента;	Фин. сост.;	Балл;	Резидентность;	Принадлежность к инсайдерам банка;	Тип актива (тип показателя);	Код сделки;	Номер сделки;	Дата С сделки;	Дата ПО сделки;	Код транша;	Номер транша;	Макс. срок просрочки по телу;	Макс. срок просрочки по %%;	Макс. срок просрочки по комиссиям;	Макс. срок просрочки по телу;	Макс. срок просрочки по %%;	Макс. срок просрочки по комиссиям;	МАКС;	МАКС 01.09.2014;	Обслуживание долга;	Обслуживание долга после пересчета;	Категория качества;	Категория качества после пересчета;	Категория качества после пересчета с учетом ресрукуризации;	Количество реструктуризаций;	Последняя дата реструктуризации;	Категория на момент реструктуризации;	Проверка;	Существенность;	Показатель риска;	Отзывность;	Дата последней реструктуризации;	Общее количество реструктуризаций;	Поступление валютной выручки;	Периодичность оплаты осн. долга;	Периодичность оплаты %%;	Группа;	Счет учета основной задолженности;	Валюта задолженности;	Курс валюты задолженности;	Сумма основной задолженности;	Сумма основной задолженности, экв.;	Сумма дисконта/премии;	Сумма дисконта/премии, экв.;	Сумма долга (без дисконта/премии);	Сумма долга (без дисконта/премии), экв.;	Сумма %%;	Сумма %%, экв.;	Сумма комиссий;	Сумма комиссий, экв.;	Балансовая стоимость;	Балансовая стоимость, экв.;	Номинальная ставка;	ЭПС годовая;	Сумма просрочки;	Сумма просрочки, экв.;	Сума полученных вознаграждений для обязательств и гарантий;	Сума полученных вознаграждений для обязательств и гарантий, экв.;	Текущая стоимость актива ТВа;	Текущая стоимость актива ТВа, экв.;	Текущая стоимость кредита ТВк;	Текущая стоимость кредита ТВк, экв.;	Код договора обеспечения;	Номер договора обеспечения;	Валюта обеспечения;	Курс валюты обеспечения;	Вид обеспечения;	Сумма обеспечения;	Сумма обеспечения, экв.;	Сумма обеспечения для сделки;	Сумма обеспечения для сделки, экв.;	Коэффициент ликвидности;	Дисконтированная стоимость обеспечения ТВз;	Дисконтированная стоимость обеспечения ТВз, экв.;	Затраты на реализацию;	Затраты на реализацию, экв.;	Сумма будущих ожидаемых потоков от обеспечения;	Сумма будущих ожидаемых потоков от обеспечения, экв.;	Срок реализации обеспечения;	Cсумма обеспечения * Кт ликвидности;	Общая сумма обеспечения;	К-т обеспечения;	Делим расходы на реализацию;	Вычитаю расходы на реализацию;	Сумма обеспечения для сделки, экв.;	БС * КТ РИСКА;	Сумма потока; Сумма потока экв.; Принимаемая сумма обеспечения;	Дисконтированная стоимость обеспечения ТВз, экв. (после пересчета);	Сумма резерва по телу;	Сумма резерва по телу, экв.;	Сумма резерва по %%;	Сумма резерва по %%, экв.;	Сумма резерва неполученных процентов до 30 дней;	Сумма резерва неполученных процентов до 30 дней, экв.;	Сумма резерва неполученных процентов свыше 30 дней;	Сумма резерва неполученных процентов свыше 30 дней, экв.;	Резерв за предыдущий период;	Резерв за предыдущий период, экв.;	Резерв, факт;	Резерв, факт, экв.;	Резерв, расчет;	Резерв, расчет, экв.;	Отклонение;	Отклонение, экв.;	Резерв после 28.12.2008 г., вал.;	Резерв после 28.12.2008 г., грн. экв.;	Группа ТВБВ;	Региональный центр;	ТОБО;	Миграция;	Цель (указана не для всех сделок);	По 82-му постановлению НБУ;	Залоги (мониторинг);	Залоги (оценка);	Признак упрощенного расчета;	Коэфициент риска от;	Коэфициент риска до;	Итоговый коэфициент риска;	Резерв, расчет экв. (после пересчета);	Отклонение, экв. (после пересчета);";

			pw.print(str);
			pw.print("\n");
			pw.print(str1);
			pw.print("\n");
			pw.print(str2);
			pw.print("\n");

			try {
				for (Deal d : deals.values()) {
					for (Client c : clients.values()) {
						if (c.getId().equals(d.getClientId())) {
							strBuilder.append(c.getInn()).append(';');
							strBuilder.append(c.getId().toString()).append(';');
							strBuilder.append(c.getName()).append(';');
							strBuilder.append(c.getFinStatus()).append(';');
							strBuilder.append(c.getPoints()).append(';');
							strBuilder.append(c.getResidency()).append(';');
							strBuilder.append(c.getInsiders()).append(';');
						}

					}
					strBuilder.append(d.getTypeOfActive()).append(';');
					strBuilder.append(d.getCodeOfDeal().toString()).append(';');
					strBuilder.append(d.getNumberOfDeal()).append(';');
					strBuilder.append(d.getDateOn()).append(';');
					strBuilder.append(d.getDateTo()).append(';');
					strBuilder.append(d.getCodeOfTransaction().toString())
							.append(';');
					strBuilder.append(d.getNumberOfTransaction()).append(';');
					strBuilder.append(d.getOverduePrincipalDebt()).append(';');
					strBuilder.append(d.getOverdueInterestDebt()).append(';');
					strBuilder.append(d.getOverdueComissionDebt()).append(';');
					strBuilder.append(d.getNewOverduePrincipalDebt()).append(
							';');
					strBuilder.append(d.getNewOverdueInterestDebt())
							.append(';');
					strBuilder.append(d.getNewOverdueComissionDebt()).append(
							';');
					strBuilder.append(d.getNewMaxOverdue()).append(';');
					strBuilder.append(d.getNewOverdueToEndOfMonth())
							.append(';');
					strBuilder.append(d.getCatOfDebtService()).append(';');
					strBuilder.append(d.getNewCatOfDebtService()).append(';');
					strBuilder.append(d.getCatOfDebt()).append(';');
					strBuilder.append(d.getNewCatOfDebt()).append(';');
					strBuilder.append(d.getNewCatOfDebtAfterRestr())
							.append(';');
					strBuilder.append(d.getNumberOfRestr()).append(';');
					strBuilder.append(d.getDateOfLastRestr()).append(';');
					strBuilder.append(d.getCatLastRestr()).append(';');
					strBuilder.append(d.getIsValidRestr()).append(';');
					strBuilder.append(d.getEssentiality()).append(';');
					strBuilder.append(
							String.format(Locale.FRANCE, "%5.2f", d.getRisk()))
							.append(';');
					strBuilder.append(d.getRevocable()).append(';');
					strBuilder.append(d.getDateOfLastRestr3111()).append(';');
					strBuilder.append(d.getNumberOfRestr3111()).append(';');
					strBuilder.append(d.getEarningsOfForeignCurrency()).append(
							';');
					strBuilder.append(d.getPeriodOfPaymentPrincipal()).append(
							';');
					strBuilder.append(d.getPeriodOfPaymentInterest()).append(
							';');
					strBuilder.append(d.getGroupAccount()).append(';');
					strBuilder.append(d.getAccount()).append(';');
					strBuilder.append(d.getCurrencyOfDeal()).append(';');
					strBuilder.append(
							String.format(Locale.FRANCE, "%5.2f",
									d.getExchengeOfCurrency())).append(';');
					strBuilder.append(
							String.format(Locale.FRANCE, "%5.2f",
									d.getSummOfPrincipal())).append(';');
					strBuilder.append(
							String.format(Locale.FRANCE, "%5.2f",
									d.getSummOfPrincipalEq())).append(';');
					strBuilder.append(
							String.format(Locale.FRANCE, "%5.2f",
									d.getSummOfDiscont())).append(';');
					strBuilder.append(
							String.format(Locale.FRANCE, "%5.2f",
									d.getSummOfDiscontEq())).append(';');
					strBuilder.append(
							String.format(Locale.FRANCE, "%5.2f",
									d.getSummWithoutOfDiscont())).append(';');
					strBuilder.append(
							String.format(Locale.FRANCE, "%5.2f",
									d.getSummWithoutOfDiscontEq())).append(';');
					strBuilder.append(
							String.format(Locale.FRANCE, "%5.2f",
									d.getSummOfInterest())).append(';');
					strBuilder.append(
							String.format(Locale.FRANCE, "%5.2f",
									d.getSummOfInterestEq())).append(';');
					strBuilder.append(
							String.format(Locale.FRANCE, "%5.2f",
									d.getSummOfFees())).append(';');
					strBuilder.append(
							String.format(Locale.FRANCE, "%5.2f",
									d.getSummOfFeesEq())).append(';');
					strBuilder.append(
							String.format(Locale.FRANCE, "%5.2f",
									d.getSummOnBalance())).append(';');
					strBuilder.append(
							String.format(Locale.FRANCE, "%5.2f",
									d.getSummOnBalanceEq())).append(';');
					strBuilder.append(
							String.format(Locale.FRANCE, "%5.2f",
									d.getNominalRate())).append(';');
					strBuilder.append(
							String.format(Locale.FRANCE, "%5.2f",
									d.getEffectiveRatePerYear())).append(';');
					strBuilder.append(
							String.format(Locale.FRANCE, "%5.2f",
									d.getSummOfOverdue())).append(';');
					strBuilder.append(
							String.format(Locale.FRANCE, "%5.2f",
									d.getSummOfOverdueEq())).append(';');
					strBuilder
							.append(String.format(
									Locale.FRANCE,
									"%5.2f",
									d.getAmountOfRemunerationReceivedForCommitmentsAndGuarantees()))
							.append(';');
					strBuilder
							.append(String.format(
									Locale.FRANCE,
									"%5.2f",
									d.getAmountOfRemunerationReceivedForCommitmentsAndGuaranteesEq()))
							.append(';');
					strBuilder.append(
							String.format(Locale.FRANCE, "%5.2f",
									d.getCurrentValueOfAsset())).append(';');
					strBuilder.append(
							String.format(Locale.FRANCE, "%5.2f",
									d.getCurrentValueOfAssetEq())).append(';');
					strBuilder.append(
							String.format(Locale.FRANCE, "%5.2f",
									d.getCurrentValueOfCredit())).append(';');
					strBuilder.append(
							String.format(Locale.FRANCE, "%5.2f",
									d.getCurrentValueOfCreditEq())).append(';');

					if (d.sequrities == null
							/*&& d.sequrities.get(0).getCode() == null*/) {

						strBuilder.append(";;;;;0;0;0;0;;0;0;0;0;0;0;;;;;;;");
						// //////////////////////////////////////////////////////////////

						/******* новые поля вычисляемые *************/

						strBuilder.append(
								String.format(Locale.FRANCE, "%5.2f",
										d.getNewSumOfSequrityForDialEq()))
								.append(';');
						strBuilder.append(
								String.format(Locale.FRANCE, "%5.2f",
										d.getBalanceEqByNewRisk())).append(';');
						strBuilder.append(
								String.format(Locale.FRANCE, "%5.2f",
										d.getSummaPotoka())).append(';');
						strBuilder.append(
								String.format(Locale.FRANCE, "%5.2f",
										d.getSummaPotokaEq())).append(';');
						strBuilder.append(
								String.format(Locale.FRANCE, "%5.2f",
										d.getEndSumOfSequrity())).append(';');
						strBuilder.append(
								String.format(Locale.FRANCE, "%5.2f",
										d.getTotalDiscontSummaOfSecurity()))
								.append(';');
						/******* новые поля вычисляемые *************/
						strBuilder.append(
								String.format(Locale.FRANCE, "%5.2f",
										d.getProvisionOfPrincipal())).append(
								';');
						strBuilder.append(
								String.format(Locale.FRANCE, "%5.2f",
										d.getProvisionOfPrincipalEq())).append(
								';');
						strBuilder.append(
								String.format(Locale.FRANCE, "%5.2f",
										d.getProvisionOfInterest()))
								.append(';');
						strBuilder.append(
								String.format(Locale.FRANCE, "%5.2f",
										d.getProvisionOfInterestEq())).append(
								';');
						strBuilder.append(
								String.format(Locale.FRANCE, "%5.2f",
										d.getProvisionOfInterestLess30Days()))
								.append(';');
						strBuilder
								.append(String.format(Locale.FRANCE, "%5.2f",
										d.getProvisionOfInterestLess30DaysEq()))
								.append(';');
						strBuilder.append(
								String.format(Locale.FRANCE, "%5.2f",
										d.getProvisionOfInterestMore30Days()))
								.append(';');
						strBuilder
								.append(String.format(Locale.FRANCE, "%5.2f",
										d.getProvisionOfInterestMore30DaysEq()))
								.append(';');
						strBuilder.append(
								String.format(Locale.FRANCE, "%5.2f",
										d.getProvisionLastPeriod()))
								.append(';');
						strBuilder.append(
								String.format(Locale.FRANCE, "%5.2f",
										d.getProvisionLastPeriodEq())).append(
								';');
						strBuilder.append(
								String.format(Locale.FRANCE, "%5.2f",
										d.getProvisionFact())).append(';');
						strBuilder.append(
								String.format(Locale.FRANCE, "%5.2f",
										d.getProvisionFactEq())).append(';');
						strBuilder.append(
								String.format(Locale.FRANCE, "%5.2f",
										d.getCalculatedProvision()))
								.append(';');
						strBuilder.append(
								String.format(Locale.FRANCE, "%5.2f",
										d.getCalculatedProvisionEq())).append(
								';');
						strBuilder.append(
								String.format(Locale.FRANCE, "%5.2f",
										d.getDifference())).append(';');
						strBuilder.append(
								String.format(Locale.FRANCE, "%5.2f",
										d.getDifferenceEq())).append(';');
						strBuilder.append(
								String.format(Locale.FRANCE, "%5.2f",
										d.getChange())).append(';');
						strBuilder.append(
								String.format(Locale.FRANCE, "%5.2f",
										d.getChangeEq())).append(';');
						strBuilder.append(d.getGroupeOfTOBO()).append(';');
						strBuilder.append(d.getRegionalCenter()).append(';');
						strBuilder.append(d.getNameOfTobo()).append(';');
						strBuilder.append(d.getMigraciya()).append(';');
						strBuilder.append(d.getProductTupe()).append(';');
						strBuilder.append(d.getPostanova82()).append(';');
						strBuilder.append(d.getSecurityMonitoring())
								.append(';');
						strBuilder.append(d.getSecurityOcenka()).append(';');
						/******* новые поля вычисляемые *************/
						strBuilder.append(d.getEasyCountOfProvisions()).append(
								';');
						strBuilder.append(
								String.format(Locale.FRANCE, "%5.2f",
										d.getFirstIndicatorOfRisk())).append(
								';');
						strBuilder.append(
								String.format(Locale.FRANCE, "%5.2f",
										d.getSecondIndicatorOfRisk())).append(
								';');
						strBuilder.append(
								String.format(Locale.FRANCE, "%5.2f",
										d.getResIndicatorOfRisk())).append(';');
						strBuilder.append(
								String.format(Locale.FRANCE, "%5.2f",
										d.getNewCalculatedProvisionEq()))
								.append(';');
						strBuilder.append(
								String.format(Locale.FRANCE, "%5.2f",
										d.getNewdifferenceEq())).append(';');

						strBuilder.append('\n');
						// /////////////////////////////////////////////////////////////////
					} else {
						// System.out.println(d.sequrities);
						if (d.sequrities.size() > 0) {
							System.out.println(d.sequrities.get(0));
							strBuilder.append(d.sequrities.get(0).getCode())
									.append(';');
							strBuilder.append(d.sequrities.get(0).getNumber())
									.append(';');
							strBuilder
									.append(d.sequrities.get(0).getCurrency())
									.append(';');
							strBuilder.append(
									String.format(Locale.FRANCE, "%5.2f",
											d.sequrities.get(0)
													.getExchengeCurrency()))
									.append(';');
							strBuilder.append(
									d.sequrities.get(0).getTypeSequrity())
									.append(';');
							strBuilder.append(
									String.format(Locale.FRANCE, "%5.2f",
											d.sequrities.get(0)
													.getSumOfSequrity()))
									.append(';');
							strBuilder.append(
									String.format(Locale.FRANCE, "%5.2f",
											d.sequrities.get(0)
													.getSumOfSequrityEq()))
									.append(';');
							strBuilder
									.append(String.format(Locale.FRANCE,
											"%5.2f", d.sequrities.get(0)
													.getSumOfSequrityForDial()))
									.append(';');
							strBuilder
									.append(String
											.format(Locale.FRANCE,
													"%5.2f",
													d.sequrities
															.get(0)
															.getSumOfSequrityForDialEq()))
									.append(';');
							strBuilder
									.append(String
											.format(Locale.FRANCE,
													"%5.2f",
													d.sequrities
															.get(0)
															.getKoeficientLikvidnosty()))
									.append(';');
							strBuilder.append(
									String.format(Locale.FRANCE, "%5.2f",
											d.sequrities.get(0)
													.getDiscontSumma()))
									.append(';');
							strBuilder.append(
									String.format(Locale.FRANCE, "%5.2f",
											d.sequrities.get(0)
													.getDiscontSummaEq()))
									.append(';');
							strBuilder.append(
									String.format(Locale.FRANCE, "%5.2f",
											d.sequrities.get(0)
													.getCostOfSales())).append(
									';');
							strBuilder.append(
									String.format(Locale.FRANCE, "%5.2f",
											d.sequrities.get(0)
													.getCostOfSalesEq()))
									.append(';');
							strBuilder.append(
									String.format(Locale.FRANCE, "%5.2f",
											d.sequrities.get(0)
													.getSumFutureSeqPotokov()))
									.append(';');
							strBuilder
									.append(String
											.format(Locale.FRANCE,
													"%5.2f",
													d.sequrities
															.get(0)
															.getSumFutureSeqPotokovEq()))
									.append(';');
							strBuilder.append(
									d.sequrities.get(0).getSrokRealizacii())
									.append(';');
							/******* новые поля вычисляемые *************/
							strBuilder
									.append(String
											.format(Locale.FRANCE,
													"%5.2f",
													d.sequrities
															.get(0)
															.getSequrityMultiplyByLiquidity()))
									.append(';');
							strBuilder
									.append(String
											.format(Locale.FRANCE,
													"%5.2f",
													d.sequrities
															.get(0)
															.getTotalAmountOfDealSequrity()))
									.append(';');
							strBuilder.append(
									String.format(Locale.FRANCE, "%5.2f",
											d.sequrities.get(0)
													.getCoeficientSequrity()))
									.append(';');
							strBuilder
									.append(String.format(Locale.FRANCE,
											"%5.2f", d.sequrities.get(0)
													.getCostOfSale())).append(
											';');
							strBuilder.append(
									String.format(Locale.FRANCE, "%5.2f",
											d.sequrities.get(0)
													.getNewSummOfSequrityEq()))
									.append(';');

							// //////////////////////////////////////////////////////////////
							/******* новые поля вычисляемые *************/

							strBuilder.append(
									String.format(Locale.FRANCE, "%5.2f",
											d.getNewSumOfSequrityForDialEq()))
									.append(';');
							strBuilder.append(
									String.format(Locale.FRANCE, "%5.2f",
											d.getBalanceEqByNewRisk())).append(
									';');
							strBuilder.append(
									String.format(Locale.FRANCE, "%5.2f",
											d.getSummaPotoka())).append(';');
							strBuilder.append(
									String.format(Locale.FRANCE, "%5.2f",
											d.getSummaPotokaEq())).append(';');
							strBuilder.append(
									String.format(Locale.FRANCE, "%5.2f",
											d.getEndSumOfSequrity())).append(
									';');
							strBuilder
									.append(String.format(Locale.FRANCE,
											"%5.2f",
											d.getTotalDiscontSummaOfSecurity()))
									.append(';');
							/******* новые поля вычисляемые *************/

							strBuilder.append(
									String.format(Locale.FRANCE, "%5.2f",
											d.getProvisionOfPrincipal()))
									.append(';');
							strBuilder.append(
									String.format(Locale.FRANCE, "%5.2f",
											d.getProvisionOfPrincipalEq()))
									.append(';');
							strBuilder.append(
									String.format(Locale.FRANCE, "%5.2f",
											d.getProvisionOfInterest()))
									.append(';');
							strBuilder.append(
									String.format(Locale.FRANCE, "%5.2f",
											d.getProvisionOfInterestEq()))
									.append(';');
							strBuilder
									.append(String.format(
											Locale.FRANCE,
											"%5.2f",
											d.getProvisionOfInterestLess30Days()))
									.append(';');
							strBuilder
									.append(String.format(
											Locale.FRANCE,
											"%5.2f",
											d.getProvisionOfInterestLess30DaysEq()))
									.append(';');
							strBuilder
									.append(String.format(
											Locale.FRANCE,
											"%5.2f",
											d.getProvisionOfInterestMore30Days()))
									.append(';');
							strBuilder
									.append(String.format(
											Locale.FRANCE,
											"%5.2f",
											d.getProvisionOfInterestMore30DaysEq()))
									.append(';');
							strBuilder.append(
									String.format(Locale.FRANCE, "%5.2f",
											d.getProvisionLastPeriod()))
									.append(';');
							strBuilder.append(
									String.format(Locale.FRANCE, "%5.2f",
											d.getProvisionLastPeriodEq()))
									.append(';');
							strBuilder.append(
									String.format(Locale.FRANCE, "%5.2f",
											d.getProvisionFact())).append(';');
							strBuilder.append(
									String.format(Locale.FRANCE, "%5.2f",
											d.getProvisionFactEq()))
									.append(';');
							strBuilder.append(
									String.format(Locale.FRANCE, "%5.2f",
											d.getCalculatedProvision()))
									.append(';');
							strBuilder.append(
									String.format(Locale.FRANCE, "%5.2f",
											d.getCalculatedProvisionEq()))
									.append(';');
							strBuilder.append(
									String.format(Locale.FRANCE, "%5.2f",
											d.getDifference())).append(';');
							strBuilder.append(
									String.format(Locale.FRANCE, "%5.2f",
											d.getDifferenceEq())).append(';');
							strBuilder.append(
									String.format(Locale.FRANCE, "%5.2f",
											d.getChange())).append(';');
							strBuilder.append(
									String.format(Locale.FRANCE, "%5.2f",
											d.getChangeEq())).append(';');
							strBuilder.append(d.getGroupeOfTOBO()).append(';');
							strBuilder.append(d.getRegionalCenter())
									.append(';');
							strBuilder.append(d.getNameOfTobo()).append(';');
							strBuilder.append(d.getMigraciya()).append(';');
							strBuilder.append(d.getProductTupe()).append(';');
							strBuilder.append(d.getPostanova82()).append(';');
							strBuilder.append(d.getSecurityMonitoring())
									.append(';');
							strBuilder.append(d.getSecurityOcenka())
									.append(';');
							/******* новые поля вычисляемые *************/
							strBuilder.append(d.getEasyCountOfProvisions())
									.append(';');
							strBuilder.append(
									String.format(Locale.FRANCE, "%5.2f",
											d.getFirstIndicatorOfRisk()))
									.append(';');
							strBuilder.append(
									String.format(Locale.FRANCE, "%5.2f",
											d.getSecondIndicatorOfRisk()))
									.append(';');
							strBuilder.append(
									String.format(Locale.FRANCE, "%5.2f",
											d.getResIndicatorOfRisk())).append(
									';');
							strBuilder.append(
									String.format(Locale.FRANCE, "%5.2f",
											d.getNewCalculatedProvisionEq()))
									.append(';');
							strBuilder.append(
									String.format(Locale.FRANCE, "%5.2f",
											d.getNewdifferenceEq()))
									.append(';');

							strBuilder.append('\n');
							// /////////////////////////////////////////////////////////////////
							for (int j = 1; j < d.sequrities.size(); j++) {
								strBuilder
										.append(";;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;");
								strBuilder
										.append(d.sequrities.get(j).getCode())
										.append(';');
								strBuilder.append(
										d.sequrities.get(j).getNumber())
										.append(';');
								strBuilder.append(
										d.sequrities.get(j).getCurrency())
										.append(';');
								strBuilder
										.append(String.format(Locale.FRANCE,
												"%5.2f", d.sequrities.get(j)
														.getExchengeCurrency()))
										.append(';');
								strBuilder.append(
										d.sequrities.get(j).getTypeSequrity())
										.append(';');
								strBuilder.append(
										String.format(Locale.FRANCE, "%5.2f",
												d.sequrities.get(j)
														.getSumOfSequrity()))
										.append(';');
								strBuilder.append(
										String.format(Locale.FRANCE, "%5.2f",
												d.sequrities.get(j)
														.getSumOfSequrityEq()))
										.append(';');
								strBuilder
										.append(String
												.format(Locale.FRANCE,
														"%5.2f",
														d.sequrities
																.get(j)
																.getSumOfSequrityForDial()))
										.append(';');
								strBuilder
										.append(String
												.format(Locale.FRANCE,
														"%5.2f",
														d.sequrities
																.get(j)
																.getSumOfSequrityForDialEq()))
										.append(';');
								strBuilder
										.append(String
												.format(Locale.FRANCE,
														"%5.2f",
														d.sequrities
																.get(j)
																.getKoeficientLikvidnosty()))
										.append(';');
								strBuilder.append(
										String.format(Locale.FRANCE, "%5.2f",
												d.sequrities.get(j)
														.getDiscontSumma()))
										.append(';');
								strBuilder.append(
										String.format(Locale.FRANCE, "%5.2f",
												d.sequrities.get(j)
														.getDiscontSummaEq()))
										.append(';');
								strBuilder.append(
										String.format(Locale.FRANCE, "%5.2f",
												d.sequrities.get(j)
														.getCostOfSales()))
										.append(';');
								strBuilder.append(
										String.format(Locale.FRANCE, "%5.2f",
												d.sequrities.get(j)
														.getCostOfSalesEq()))
										.append(';');
								strBuilder
										.append(String
												.format(Locale.FRANCE,
														"%5.2f",
														d.sequrities
																.get(j)
																.getSumFutureSeqPotokov()))
										.append(';');
								strBuilder
										.append(String
												.format(Locale.FRANCE,
														"%5.2f",
														d.sequrities
																.get(j)
																.getSumFutureSeqPotokovEq()))
										.append(';');
								strBuilder
										.append(d.sequrities.get(j)
												.getSrokRealizacii()).append(
												';');
								/******* новые поля вычисляемые *************/
								strBuilder
										.append(String
												.format(Locale.FRANCE,
														"%5.2f",
														d.sequrities
																.get(j)
																.getSequrityMultiplyByLiquidity()))
										.append(';');
								strBuilder
										.append(String
												.format(Locale.FRANCE,
														"%5.2f",
														d.sequrities
																.get(j)
																.getTotalAmountOfDealSequrity()))
										.append(';');
								strBuilder
										.append(String
												.format(Locale.FRANCE,
														"%5.2f",
														d.sequrities
																.get(j)
																.getCoeficientSequrity()))
										.append(';');
								strBuilder.append(
										String.format(Locale.FRANCE, "%5.2f",
												d.sequrities.get(j)
														.getCostOfSale()))
										.append(';');
								strBuilder
										.append(String
												.format(Locale.FRANCE,
														"%5.2f",
														d.sequrities
																.get(j)
																.getNewSummOfSequrityEq()))
										.append(';');
								strBuilder
										.append(";;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;");

								strBuilder.append('\n');
							}
						}
					}
					pw.print(strBuilder.toString());
					li++;
					System.out.println(li);
					strBuilder.delete(0, strBuilder.length());
				}

			} finally {
				pw.close();
			}
		} catch (IOException e) {
			throw new RuntimeException(e);
		}

	}

}
