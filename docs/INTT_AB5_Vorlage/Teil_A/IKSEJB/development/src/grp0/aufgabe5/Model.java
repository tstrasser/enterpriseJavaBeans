package grp0.aufgabe5b;

import java.util.List;
import java.util.Vector;

import javax.ejb.Remote;

@Remote
public interface Model {
// public interface IKSRemoteInterface


	/**
	 * F�gt neue Lieferung hinzu
	 * 
	 * @param lieferung
	 */
	public void addLieferung(Lieferung lieferung);

	/**
	 * Holt alle Lieferungen
	 * 
	 * @return Vector<LieferungBean>
	 */
	public List<Lieferung> getLieferung();

	/**
	 * Holt Lieferung mit bestimmter ID
	 * 
	 * @param ID
	 * 
	 * @return Lieferung
	 */
	public Lieferung getLieferungById(int id);

	/**
	 * Holt Lieferung mit bestimmter Lieferanten_ID
	 * 
	 * @param ID
	 * 
	 * @return Lieferung-Liste
	 */
	public List<Lieferung> getLieferungByLieferantenId(int lieferanten_id);

	/**
	 * Holt Lieferung mit bestimmter mitarbeiter_ID
	 * 
	 * @param ID
	 * 
	 * @return Lieferung-Liste
	 */
	public List<Lieferung> getLieferungByMitarbeiterId(int mitarbeiter_id);

	/**
	 * Holt alle Lieferungen anhand bestimmter Qualit�tsmerkmale
	 * 
	 * @param bedingung
	 *            gr��er, kleiner oder gleich treshold (1, -1, 0)
	 * @param treshold
	 *            Treshold
	 * 
	 * @return Vector<LieferungBean>
	 */
	public List<Lieferung> getLieferungByQualityTreshold(int bedingung,
			int treshold);

	/*
	 * ==============================
	 * ab hier zus�tzliche Methoden, f�r die Einhaltung des "Vertrages" der
	 * IKS-Model-Klasse aus Aufgabe 4
	 */
	
	public String halloWelt();

  //***TODO*** weitere Methodensignaturen f�r die Businessfunktionen
  // "Holen aller Lieferungen" und "Eine Lieferung in die DB einf�gen"

}
