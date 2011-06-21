package grp0.aufgabe5bClient;

import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.rmi.PortableRemoteObject;
import grp0.aufgabe5b.*;

public class IKSBeanTestClient {

	/**
	 * Fügt eine neue Lieferung mit hartcodierten Daten hinzu
	 * 
	 * @param bm
	 */
	public static void testAddLieferung(Model bm) {
		System.out.print("Neue Lieferung hinzufügen...");
		Lieferung newLieferung = new Lieferung();
		newLieferung.setLieferanten_id(4177);
		newLieferung.setLieferzeit("2009-04-15 04:23:00");
		newLieferung.setProduktionsdatum("2009-04-13");
		newLieferung.setQM1(2);
		newLieferung.setQM2(3);
		newLieferung.setQM3(1);
		newLieferung.setMitarbeiter_id(666);
		bm.addLieferung(newLieferung);
		System.out.println("... done");
	}

	/**
	 * Testet das Holen aller Lieferungen, gibt ein paar Informationen der
	 * Lieferungen aus
	 * 
	 * @param bm
	 */
	public static void testGetLieferung(Model bm) {
		System.out.println("Alle Lieferungen holen und ausgeben");
		List<Lieferung> listAllLieferungen = bm.getLieferung();
		Iterator<Lieferung> it = listAllLieferungen.iterator();
		Lieferung cur = new Lieferung();
		while (it.hasNext()) {
			cur = it.next();
			System.out.println("Lieferung_id: " + cur.getLieferung_id()
					+ "\tlieferant: " + cur.getLieferanten_id()
					+ "\t Eingang: " + cur.getLieferzeit());
		}
	}

	/**
	 * Holt eine bestimmte Lieferung anhand übergebener ID
	 * 
	 * @param bm
	 * @param id
	 */
	public static void testGetLieferungById(Model bm, int id) {
		System.out.print("Hole Lieferung mit ID " + id + "...");
		Lieferung cur = new Lieferung();
		cur = bm.getLieferungById(id);
		System.out.println("... done:");
		System.out.println("Lieferung_id: " + cur.getLieferung_id()
				+ "; lieferant: " + cur.getLieferanten_id() + "; Eingang: "
				+ cur.getLieferzeit());
	}

	
	/**
	 * Testet weitere Businessfunktionen
	 * @param bm
	 */
	public static void testSonstiges(Model bm) {
		// Testfilter
		int lieferanten_id = 777;
		int mitarbeiter_id = 6;
		int gtQualityTreshold = 6; 

		System.out.println("=== Alle Lieferungen mit Lieferant "
				+ lieferanten_id);
		Lieferung cur = new Lieferung();
		List<Lieferung> listAllLieferungen = bm
				.getLieferungByLieferantenId(lieferanten_id);
		Iterator<Lieferung> it = listAllLieferungen.iterator();
		while (it.hasNext()) {
			cur = it.next();
			System.out.println("Lieferung_id: " + cur.getLieferung_id()
					+ "; lieferant: " + cur.getLieferanten_id() + "; Eingang: "
					+ cur.getLieferzeit());
		}

		System.out.println("=== Alle Lieferungen mit Mitarbeiter_id "
				+ mitarbeiter_id);
		listAllLieferungen = bm.getLieferungByMitarbeiterId(mitarbeiter_id);
		it = listAllLieferungen.iterator();
		while (it.hasNext()) {
			cur = it.next();
			System.out.println("Lieferung_id: " + cur.getLieferung_id()
					+ "; lieferant: " + cur.getLieferanten_id() + "; Eingang: "
					+ cur.getLieferzeit());
		}

		System.out.println("=== Alle Lieferungen mit Summe der QM > 6");
		listAllLieferungen = bm.getLieferungByQualityTreshold(1, gtQualityTreshold);
		it = listAllLieferungen.iterator();
		while (it.hasNext()) {
			cur = it.next();
			System.out.println("Lieferung_id: " + cur.getLieferung_id()
					+ "; lieferant: " + cur.getLieferanten_id() + "; Eingang: "
					+ cur.getLieferzeit());
		}
	}

	/**
	 * Testet die Bean, in den alle Lieferungen angezeigt werden
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			// Model-Interface holen:
			Hashtable<String, String> props = new Hashtable<String, String>();
			props.put(Context.INITIAL_CONTEXT_FACTORY,
					"org.jnp.interfaces.NamingContextFactory");
			props.put(Context.URL_PKG_PREFIXES, "org.jboss.naming.client");
			props.put(Context.PROVIDER_URL, "jnp://localhost:1099");
			props.put("j2ee.clientName", "IKSClient");

			InitialContext initialContext = new InitialContext(props);

			Object obj = initialContext
			// Wenn deployment via EAR
					// .lookup("java:comp/env/ejb/Model");
					// oder wenn ejb alleine deployt werden
					.lookup("ModelBean/remote");
			Model bm = (Model) PortableRemoteObject.narrow(obj, Model.class);

			// Basic tests
			testAddLieferung(bm);
			testGetLieferung(bm);
			testGetLieferungById(bm, 2);
			//testSonstiges(bm);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
