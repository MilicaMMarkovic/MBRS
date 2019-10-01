package jwd.wafepa.web.dto;

public class TakmicenjeDTO {

	private Long Id;
	private String naziv;
	private String datum;
	private String organizator;
	private String kontakt;

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public String getDatum() {
		return datum;
	}

	public void setDatum(String datum) {
		this.datum = datum;
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

}
