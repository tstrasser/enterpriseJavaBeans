package grp0.aufgabe5b;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity()
@Table(name = "***Tabellenname***")
@NamedQueries( {
		@NamedQuery(name = "findAllLieferungen", query = "select o from Lieferung o"),
		@NamedQuery(name = "findByLieferungId", query = "select o from Lieferung o where o.lieferung_id = :lieferungId"),
		@NamedQuery(name = "findByLieferantenId", query = "select o from Lieferung o where o.lieferanten_id = :lieferantenId"),
		@NamedQuery(name = "findByMitarbeiterId", query = "select o from Lieferung o where o.mitarbeiter_id = :mitarbeiterId"),
		@NamedQuery(name = "findByQMgtTreshold", query = "select o from Lieferung o where o.QM1 + o.QM2 + o.QM3 > :treshold"),
		@NamedQuery(name = "findByQMltTreshold", query = "select o from Lieferung o where o.QM1 + o.QM2 + o.QM3 < :treshold"),
		@NamedQuery(name = "findByQMeqTreshold", query = "select o from Lieferung o where o.QM1 + o.QM2 + o.QM3 = :treshold") })
public class Lieferung implements Serializable {
	static final long serialVersionUID = 1L;

	private Integer lieferung_id;
	private Integer lieferanten_id;
	private String lieferzeit;
	private String produktionsdatum;
	private Integer QM1;
	private Integer QM2;
	private Integer QM3;
	private Integer mitarbeiter_id;

	/**
	 * @return the lieferung_id
	 */
	@Column()
	@Id()
	@GeneratedValue()
	public Integer getLieferung_id() {
		return lieferung_id;
	}

	/**
	 * @param lieferung_id
	 *            the lieferung_id to set
	 */
	public void setLieferung_id(Integer lieferung_id) {
		this.lieferung_id = lieferung_id;
	}

	/**
	 * @return the lieferanten_id
	 */
	@Column()
	public Integer getLieferanten_id() {
		return lieferanten_id;
	}

	/**
	 * @param lieferanten_id
	 *            the lieferanten_id to set
	 */
	public void setLieferanten_id(Integer lieferanten_id) {
		this.lieferanten_id = lieferanten_id;
	}

	/**
	 * @return the lieferzeit
	 */
	@Column()
	public String getLieferzeit() {
		return lieferzeit;
	}

	/**
	 * @param lieferzeit
	 *            the lieferzeit to set
	 */
	public void setLieferzeit(String lieferzeit) {
		this.lieferzeit = lieferzeit;
	}

	/**
	 * @return the produktionsdatum
	 */
	@Column()
	public String getProduktionsdatum() {
		return produktionsdatum;
	}

	/**
	 * @param produktionsdatum
	 *            the produktionsdatum to set
	 */
	public void setProduktionsdatum(String produktionsdatum) {
		this.produktionsdatum = produktionsdatum;
	}

	/**
	 * @return the qM1
	 */
	@Column()
	public Integer getQM1() {
		return QM1;
	}

	/**
	 * @param qm1
	 *            the qM1 to set
	 */
	public void setQM1(Integer qm1) {
		QM1 = qm1;
	}

	/**
	 * @return the qM2
	 */
	@Column()
	public Integer getQM2() {
		return QM2;
	}

	/**
	 * @param qm2
	 *            the qM2 to set
	 */
	public void setQM2(Integer qm2) {
		QM2 = qm2;
	}

	/**
	 * @return the qM3
	 */
	@Column()
	public Integer getQM3() {
		return QM3;
	}

	/**
	 * @param qm3
	 *            the qM3 to set
	 */
	public void setQM3(Integer qm3) {
		QM3 = qm3;
	}

	/**
	 * @return the mitarbeiter_id
	 */
	@Column()
	public Integer getMitarbeiter_id() {
		return mitarbeiter_id;
	}

	/**
	 * @param mitarbeiter_id
	 *            the mitarbeiter_id to set
	 */
	public void setMitarbeiter_id(Integer mitarbeiter_id) {
		this.mitarbeiter_id = mitarbeiter_id;
	}

}
