package jwd.wafepa.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "takmicar")
public class Takmicar {

	@Id
	@GeneratedValue
	@Column(name = "id")
	private Long id;

	@Column(name = "imeIPrezime")
	private String imeIPrezime;

	@Column(name = "jmbg")
	private String jmbg;

	@Column(name = "pol")
	private String pol;

	@Column(name = "kontakt")
	private String kontakt;

	@ManyToOne(fetch = FetchType.EAGER)
	private Trka trka = new Trka();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getImeIPrezime() {
		return imeIPrezime;
	}

	public void setImeIPrezime(String imeIPrezime) {
		this.imeIPrezime = imeIPrezime;
	}

	public String getJmbg() {
		return jmbg;
	}

	public void setJmbg(String jmbg) {
		this.jmbg = jmbg;
	}

	public String getPol() {
		return pol;
	}

	public void setPol(String pol) {
		this.pol = pol;
	}

	public String getKontakt() {
		return kontakt;
	}

	public void setKontakt(String kontakt) {
		this.kontakt = kontakt;
	}

	public Trka getTrka() {
		return trka;
	}

	public void setTrka(Trka trka) {
		this.trka = trka;
	}

	public Takmicar() {
		super();
	}

	public Takmicar(String imeIPrezime, String jmbg, String pol, String kontakt, Trka trka) {
		super();
		this.imeIPrezime = imeIPrezime;
		this.jmbg = jmbg;
		this.pol = pol;
		this.kontakt = kontakt;
		this.trka = trka;
	}

}
