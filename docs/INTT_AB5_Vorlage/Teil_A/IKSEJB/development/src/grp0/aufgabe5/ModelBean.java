package grp0.aufgabe5b;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;
import java.util.logging.Logger;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 * Stateless Session Bean für den Zugriff auf die Entitiy Bean "Lieferung".
 * Enthält Methoden zum Speichern einer Lieferung, sowie zum holen aller oder
 * bestimmter Lieferungen und anhand bestimmter Qualitäts-Tresholds
 * 
 */
@Stateless
public class ModelBean implements Model {
//public class IKSBean implements IKSRemoteInterface


	/**
	 * The logger. It is a static constant (static variables have to be final !)
	 */
	protected static final Logger logger = Logger
			.getLogger(ModelBean.class.getName());

	/** EntityManager für IKS. */
	@PersistenceContext(unitName = "NameOfPersistenceUnit") 
	EntityManager entityManager = null;
	

	/**
	 * Übergebene Lieferung zur Datenbank hinzufügen
	 */
	public void addLieferung(Lieferung lieferung) {
		logger.info("addLieferung..");
		this.entityManager.merge(lieferung);
	}
  
	/**
	 * Holt alle Lieferungen
	 */
	public List<Lieferung> getLieferung() {
		logger.info("getLieferung() holt alle Lieferungen");
		// Benutzung einer in der Entity-Bean definierten Named Query anstatt 
    // der hartcodierten Query...
		// Query query =
		// this.entityManager.createQuery("select o from Lieferung o");
		Query query = this.entityManager.createNamedQuery("***TODO***");
		logger.info("query findAllLieferungen ausgeführt.");
		List<Lieferung> Lieferungen =  query.getResultList();
		return Lieferungen;
	}

	/**
	 * Holt alle Lieferungen deren QM-Summe kleiner (bedingung = -1), gleich (0)
	 * oder größer (1) dem treshold ist
	 * @param bedingung
	 * @param treshold
	 */
	public List<Lieferung> getLieferungByQualityTreshold(int bedingung,
			int treshold) {
		//Liste mit den Bedingungen, identifiziert anhand Integer, 
		//benennt im String die NamedQuery der Lieferung-Klasse
		HashMap<Integer, String> bedingungen = new HashMap<Integer, String>();
		bedingungen.put(-1, "findByQMltTreshold");
		bedingungen.put(0, "findByQMeqTreshold");
		bedingungen.put(1, "findByQMgtTreshold");
		
		//Query erstellen anhand der Bedingung
		Query query = this.entityManager.createNamedQuery(bedingungen.get(bedingung));
		query.setParameter("treshold", treshold);
		List<Lieferung> Lieferungen = query.getResultList();
		return Lieferungen;
	}



	public Lieferung getLieferungById(int id) {
		logger.info("Hole Lieferung mit id: " + id);
		// wieder anstatt der hartcodierten Query " select o from Lieferung o where...."
    Query query = this.entityManager.createNamedQuery("***TODO***");
		query.setParameter("lieferungId", id);
		Lieferung ergLieferung = (Lieferung) query.getSingleResult();
		return ergLieferung;
	}


	public List<Lieferung> getLieferungByLieferantenId(int lieferanten_id) {
		// wieder anstatt der hartcodierten Query " select o from Lieferung o where...."
		Query query = this.entityManager.createNamedQuery("***TODO***");
		query.setParameter("lieferantenId", lieferanten_id);
		List<Lieferung> Lieferungen = query.getResultList();
		return Lieferungen;
	}


	public List<Lieferung> getLieferungByMitarbeiterId(int mitarbeiter_id) {
		// wieder anstatt der hartcodierten Query " select o from Lieferung o where...."
		Query query = this.entityManager.createNamedQuery("***TODO***");
		query.setParameter("mitarbeiterId", mitarbeiter_id);
		List<Lieferung> Lieferungen = query.getResultList();
		return Lieferungen;
	}


//Mehtoden zum Einhalten des "alten" Vertrages der Model-Klasse aus Teil A
	public Vector<Lieferung> getAllLieferungen() {
		logger.info("getAllLieferungen()");
		List<Lieferung> listAll = this.getLieferung();
		logger.info("getLieferung() ausgeführt");
		Iterator<Lieferung> it = listAll.iterator();
		Vector<Lieferung> vecAll = new Vector<Lieferung>();
		while (it.hasNext()) {
			vecAll.add(it.next());
		}
		return vecAll;
	}

	public String halloWelt() {
		return "Hallo Welt";
	}

	public String insertLieferung(Lieferung toInsert) {
		logger.info("insertLieferung()");
		logger.info("InsertLieferung" + toInsert.getLieferanten_id());
		this.addLieferung(toInsert);
		return "Lieferung eingefügt";
	}

}
