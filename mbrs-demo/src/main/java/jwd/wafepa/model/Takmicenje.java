package jwd.wafepa.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "takmicenje")
public class Takmicenje {

	@Id
	@GeneratedValue
	@Column(name = "id")
	private Long id;

	@Column(name = "datum")
	private String datum;

	@Column(name = "naziv")
	private String naziv;

	@Column(name = "organizator")
	private String organizator;

	@Column(name = "kontakt")
	private String kontakt;

	@OneToMany(mappedBy = "takmicenje", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Trka> trke = new ArrayList<>();

	public void addTrka(Trka trka) {
		if (trka.getTakmicenje() != this) {
			trka.setTakmicenje(this);
		}
		trke.add(trka);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDatum() {
		return datum;
	}

	public void setDatum(String datum) {
		this.datum = datum;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public String getOrganizator() {
		return organizator;
	}

	public void setOrganizator(String organizator) {
		this.organizator = organizator;
	}

	public String getKontakt() {
		return kontakt;
	}

	public void setKontakt(String kontakt) {
		this.kontakt = kontakt;
	}

	public List<Trka> getTrke() {
		return trke;
	}

	public void setTrke(List<Trka> trke) {
		this.trke = trke;
	}

	public Takmicenje() {
		super();
	}

	public Takmicenje(String naziv) {
		super();
		this.naziv = naziv;
	}

	public Takmicenje(String datum, String naziv, String organizator, String kontakt, List<Trka> trke) {
		super();
		this.datum = datum;
		this.naziv = naziv;
		this.organizator = organizator;
		this.kontakt = kontakt;
		this.trke = trke;
	}

	public Takmicenje(String datum, String naziv, String organizator, String kontakt) {
		super();
		this.datum = datum;
		this.naziv = naziv;
		this.organizator = organizator;
		this.kontakt = kontakt;
	}

}
