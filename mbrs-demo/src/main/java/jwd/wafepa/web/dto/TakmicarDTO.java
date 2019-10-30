package jwd.wafepa.web.dto;

public class TakmicarDTO {

	private Long id;
	private String imeIPrezime;
	private String jmbg;
	private String pol;
	private String kontakt;
	private String nazivTrke;

	private Long trkaId;

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

	public String getNazivTrke() {
		return nazivTrke;
	}

	public void setNazivTrke(String nazivTrke) {
		this.nazivTrke = nazivTrke;
	}

	public Long getTrkaId() {
		return trkaId;
	}

	public void setTrkaId(Long trkaId) {
		this.trkaId = trkaId;
	}

}
