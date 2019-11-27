package com.example.demo.web.dto;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class TakmicenjeDTO extends AbstractBaseDTO { 

	@NotNull
    @Size(min=0, max=150)
    private String naziv;
	@NotNull
    @Size(min=0, max=35)
    private String datum;
	@NotNull
    @Size(min=0, max=135)
    private String organizator;
	@NotNull
    @Size(min=0, max=50)
    private String kontakt;

	public TakmicenjeDTO() {}

	public String getNaziv(){
    	return naziv;
  	}
  
  	public void setNaziv(String naziv){
       	this.naziv = naziv;	
	}	
	public String getDatum(){
    	return datum;
  	}
  
  	public void setDatum(String datum){
       	this.datum = datum;	
	}	
	public String getOrganizator(){
    	return organizator;
  	}
  
  	public void setOrganizator(String organizator){
       	this.organizator = organizator;	
	}	
	public String getKontakt(){
    	return kontakt;
  	}
  
  	public void setKontakt(String kontakt){
       	this.kontakt = kontakt;	
	}	

}
