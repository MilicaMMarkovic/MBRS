package com.example.demo.web.dto;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class TakmicarDTO extends AbstractBaseDTO { 

	@NotNull
    @Size(min=0, max=30)
    private String ime;
	@NotNull
    @Size(min=0, max=30)
    private String prezime;
    @Size(min=0, max=13)
    private String jmbg;
	@NotNull
    @Size(min=0, max=30)
    private String pol;
	@NotNull
    @Size(min=0, max=30)
    private String kontakt;
    private TrkaDTO trka;	

	public TakmicarDTO() {}

	public String getIme(){
    	return ime;
  	}
  
  	public void setIme(String ime){
       	this.ime = ime;	
	}	
	public String getPrezime(){
    	return prezime;
  	}
  
  	public void setPrezime(String prezime){
       	this.prezime = prezime;	
	}	
	public String getJmbg(){
    	return jmbg;
  	}
  
  	public void setJmbg(String jmbg){
       	this.jmbg = jmbg;	
	}	
	public String getPol(){
    	return pol;
  	}
  
  	public void setPol(String pol){
       	this.pol = pol;	
	}	
	public String getKontakt(){
    	return kontakt;
  	}
  
  	public void setKontakt(String kontakt){
       	this.kontakt = kontakt;	
	}	
	public TrkaDTO getTrka(){
    	return trka;
  	}
  
  	public void setTrka(TrkaDTO trka){
       	this.trka = trka;	
	}	

}
