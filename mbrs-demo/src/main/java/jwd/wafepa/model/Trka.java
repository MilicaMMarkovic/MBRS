package jwd.wafepa.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "trka")
public class Trka {

	@Id
	@GeneratedValue
	@Column(name = "id")
	private Long id;

	@ManyToOne(fetch = FetchType.EAGER)
	private Takmicenje takmicenje;

	@Column(name = "duzinaKm")
	private double duzinaKm;

	@Column(name = "naziv")
	private String naziv;

	@Column(name = "cena")
	private Integer cena;

	@OneToMany(mappedBy = "trka", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Takmicar> takmicari = new ArrayList<>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Takmicenje getTakmicenje() {
		return takmicenje;
	}

	public void setTakmicenje(Takmicenje takmicenje) {
		this.takmicenje = takmicenje;
	}

	public double getDuzina_km() {
		return duzinaKm;
	}

	public void setDuzina_km(double duzina_km) {
		this.duzinaKm = duzina_km;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String string) {
		this.naziv = string;
	}

	public Integer getCena() {
		return cena;
	}

	public void setCena(Integer cena) {
		this.cena = cena;
	}

	public Trka() {
		super();
	}

	public Trka(String naziv) {
		super();
		this.naziv = naziv;
	}

	public void addTakmicar(Takmicar takmicar) {
		if (takmicar.getTrka() != this) {
			takmicar.setTrka(this);
		}
		takmicari.add(takmicar);
	}

}
