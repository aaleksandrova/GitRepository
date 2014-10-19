package ua.fidobank.provisions;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import repository.ManagerDao;
import ua.fidobank.provisions.domain.Client;
import ua.fidobank.provisions.domain.Deal;
import ua.fidobank.provisions.service.ReadFile;
import ua.fidobank.provisions.service.Service;

public class Program {

	public static void main(String[] args) throws IOException {

		Map<Long, Client> clients = new HashMap<Long, Client>();
		Map<Long, Deal> deals = new HashMap<Long, Deal>();
		ReadFile read = new ReadFile();
		read.Read(clients, deals);
		read.ReadCashFlow(clients, deals);

		System.out.println("¬ходные данные");

		System.out.println();

		Service service = new Service(clients, deals);

		// service.printMap(deals);

		System.out.println("setNewCategoryOfDebt()");
		service.setNewCategoryOfDebt(clients, deals);

		System.out.println();

		System.out.println("setNewCategoryOfDebtAfterRestr()");
		service.setNewCategoryOfDebtAfterRestr();

		System.out.println();

		System.out.println("setVCat90days()");
		service.setVCat90days();

		System.out.println();

		System.out.println("setWorseCategoryOfDebt()");
		for (Client c : clients.values()) {
			service.setWorseCategoryOfDebt(c.deals);
		}

		System.out.println();

		System.out.println("setIndicatorsOfRisk()");
		service.setIndicatorsOfRisk();

		System.out.println();

		System.out.println("setIndicatorEasyCountOfProvisions()");
		service.setIndicatorEasyCountOfProvisions();

		System.out.println();

		System.out.println("calculateTotalDiscontSummaOfSecurity()");
		service.calculateTotalDiscontSummaOfSecurity();

		System.out.println();

		System.out.println("calculateNewProvision()");
		service.calculateNewProvision();

		System.out.println();

		System.out.println("calcTotalAmountOfProvision()");
		service.calcTotalAmountOfProvision();
		System.out.println();

		service.MinusProv();

		String csv = "d:/output1308_2.csv";

		service.fileWriter(csv);

	//	ManagerDao manegerDao = new ManagerDao();

		// manegerDao.AddClient(clients.get(26450L));
		// manegerDao.AddDeal(deals.get(2161933L));

//		manegerDao.AddClient(clients);
		// manegerDao.saveList(read.getSequrities());

		// Client c = manegerDao.getClient();
		//
		// for (Sequrity s : c.deals.get(2178888L).sequrities) {
		// if (s.getCode()==2162109) {
		// s.setNumber("new");
		// System.out.println(s);
		// }
		// // System.out.println(s);
		// }

		// manegerDao.UpdateClient(c);

		// service.printMap(deals);

//		manegerDao.end();
	}

}