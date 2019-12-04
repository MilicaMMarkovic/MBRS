package com.example.demo.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Table(name="takmicenje")
@Entity
public class Takmicenje extends AbstractBaseEntity { 
 
	@Column(name="naziv", unique=true)
    private String naziv;
        
    @OneToMany(mappedBy="takmicenje",cascade=CascadeType.REMOVE)
	private List<Trka> trkeList = new ArrayList<Trka>();
        
	@Column(name="datum")
    private String datum;
        
	@Column(name="organizator")
    private String organizator;
        
	@Column(name="kontakt")
    private String kontakt;
        

	public Takmicenje() {}

  	public String getNaziv(){
    	return naziv;
  	}
  
  	public void setNaziv(String naziv){
       	this.naziv = naziv;	
	}
      
   	public void addTrke(Trka trke){
		this.trkeList.add(trke);
		
		if(trke.getTakmicenje() != this){
			trke.setTakmicenje(this);
		}
	}
	
	public void removeTrke(Trka trke){
		trke.setTakmicenje(null);
		trkeList.remove(trke);
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




