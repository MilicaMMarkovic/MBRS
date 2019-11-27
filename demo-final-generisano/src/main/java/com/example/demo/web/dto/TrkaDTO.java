package com.example.demo.web.dto;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class TrkaDTO extends AbstractBaseDTO { 

	@NotNull
    @Size(min=0, max=55)
    private String naziv;
    @Min(1)
    @Max(10,000)	
    private int cena;
    @Min(0)
    @Max(55)	
    private double duzinaKm;
    private TakmicenjeDTO takmicenje;	

	public TrkaDTO() {}

	public String getNaziv(){
    	return naziv;
  	}
  
  	public void setNaziv(String naziv){
       	this.naziv = naziv;	
	}	
	public int getCena(){
    	return cena;
  	}
  
  	public void setCena(int cena){
       	this.cena = cena;	
	}	
	public double getDuzinaKm(){
    	return duzinaKm;
  	}
  
  	public void setDuzinaKm(double duzinaKm){
       	this.duzinaKm = duzinaKm;	
	}	
	public TakmicenjeDTO getTakmicenje(){
    	return takmicenje;
  	}
  
  	public void setTakmicenje(TakmicenjeDTO takmicenje){
       	this.takmicenje = takmicenje;	
	}	

}
