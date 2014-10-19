package repository;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import ua.fidobank.provisions.domain.Client;
import ua.fidobank.provisions.domain.Deal;
import ua.fidobank.provisions.domain.Sequrity;

public class ManagerDao {

	public static SessionFactory factory;

	@SuppressWarnings("deprecation")
	public ManagerDao() {
		if (factory == null) {
			try {
				factory = new Configuration().configure().buildSessionFactory();
			} catch (HibernateException ex) {
				ex.printStackTrace();
			}
		}
	}

	/*
	 * public void AddClient(Client c) { Session session =
	 * factory.openSession(); Transaction tr = null; try { tr =
	 * session.beginTransaction(); session.save(c);
	 * 
	 * // Map<Long, Deal> deals = c.getDeals(); // //
	 * java.util.Iterator<Entry<Long, Deal>> it = deals.entrySet() //
	 * .iterator(); // while (it.hasNext()) { // Map.Entry<Long, Deal> pairs =
	 * it.next(); // if
	 * (pairs.getValue().getSequrities()!=null&&pairs.getValue()
	 * .getSequrities().size() != 0) { // for (Sequrity s :
	 * pairs.getValue().getSequrities()) { // // //if (s.getCode() != null) { //
	 * System.out.println("Saving sequrity " + s); // session.save(s); // //} //
	 * } // } // }
	 * 
	 * //System.out.println("Saving client " + c); tr.commit(); } catch
	 * (Exception ex) { ex.printStackTrace(); tr.rollback(); }
	 * 
	 * finally { session.close(); } }
	 */
	public void AddClient(Map<Long, Client> clients) {
		Session session = factory.openSession();
		Transaction tr = null;
		int li = 0;
		try {
			tr = session.beginTransaction();
			java.util.Iterator<Entry<Long, Client>> it = clients.entrySet()
					.iterator();
			while (it.hasNext()) {
				Map.Entry<Long, Client> pairs = it.next();
				Client temp = pairs.getValue();
				System.out.println("li -> " + li);
				session.save(temp);

				if (li % 50 == 0) {
					session.flush();
					session.clear();
					
				}
				li++;
			}
			tr.commit();

		} catch (Exception ex) {
			ex.printStackTrace();
			tr.rollback();
		}

		finally {
			session.close();
		}
	}

	public void UpdateClient(Client c) {
		Session session = factory.openSession();
		Transaction tr = null;
		try {
			tr = session.beginTransaction();
			session.update(c);
			System.out.println("Updating client " + c);
			tr.commit();
		} catch (Exception ex) {
			ex.printStackTrace();
			tr.rollback();
		}

		finally {
			session.close();
		}
	}

	public void AddDeal(Deal d) {
		Session session = factory.openSession();
		Transaction tr = null;
		try {
			tr = session.beginTransaction();
			session.save(d);
			System.out.println("Saving deal " + d);
			tr.commit();
		} catch (Exception ex) {
			ex.printStackTrace();
			tr.rollback();
		}

		finally {
			session.close();
		}
	}

	public void AddSequrity(Sequrity s) {
		Session session = factory.openSession();
		Transaction tr = null;
		try {
			tr = session.beginTransaction();
			session.save(s);
			System.out.println("Saving sequrity " + s);
			tr.commit();
		} catch (Exception ex) {
			ex.printStackTrace();
			tr.rollback();
		}

		finally {
			session.close();
		}
	}

	/*
	 * public void saveMap(Map<Long, Client> clients) {
	 * java.util.Iterator<Entry<Long, Client>> it = clients.entrySet()
	 * .iterator(); while (it.hasNext()) { Map.Entry<Long, Client> pairs =
	 * it.next();
	 * 
	 * this.AddClient(pairs.getValue());
	 * 
	 * } }
	 */
	public void saveList(List<Sequrity> sequriies) {
		for (Sequrity s : sequriies) {
			this.AddSequrity(s);
		}
	}

	public Client getClient() {
		Session session = factory.openSession();
		Transaction tr = null;
		Client myClient = null;
		try {
			tr = session.beginTransaction();
			myClient = (Client) session.createQuery("FROM Client").list()
					.get(0);
			System.out.println("Getting client " + myClient);
			tr.commit();
		} catch (Exception ex) {
			ex.printStackTrace();
			tr.rollback();
		}

		finally {
			session.close();
		}
		return myClient;
	}

	public void end() {
		factory.close();
	}
}
