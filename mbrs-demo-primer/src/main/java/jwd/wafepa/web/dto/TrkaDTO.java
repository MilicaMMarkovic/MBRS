package jwd.wafepa.web.dto;

public class TrkaDTO {

	private Long id;
	private double duzinaKm;
	private String naziv;
	private Integer cena;
	private String nazivTakmicenja;
	private Long takmicenjeId;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public double getDuzinaKm() {
		return duzinaKm;
	}

	public void setDuzinaKm(double duzinaKm) {
		this.duzinaKm = duzinaKm;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public Integer getCena() {
		return cena;
	}

	public void setCena(Integer cena) {
		this.cena = cena;
	}

	public String getNazivTakmicenja() {
		return nazivTakmicenja;
	}

	public void setNazivTakmicenja(String nazivTakmicenja) {
		this.nazivTakmicenja = nazivTakmicenja;
	}

	public Long getTakmicenjeId() {
		return takmicenjeId;
	}

	public void setTakmicenjeId(Long takmicenjeId) {
		this.takmicenjeId = takmicenjeId;
	}

}
