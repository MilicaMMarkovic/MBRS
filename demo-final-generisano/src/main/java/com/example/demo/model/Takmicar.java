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


@Table(name="takmicar")
@Entity
public class Takmicar extends AbstractBaseEntity { 
 
	@Column(name="ime")
    private String ime;
        
	@Column(name="prezime")
    private String prezime;
        
	@Column(name="jmbg")
    private String jmbg;
        
	@Column(name="pol")
    private String pol;
        
	@Column(name="kontakt")
    private String kontakt;
        
	@ManyToOne(fetch=FetchType.LAZY)
    private Trka trka;
        

	public Takmicar() {}

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
      
  	public Trka getTrka(){
    	return trka;
  	}
  
  	public void setTrka(Trka trka){
       	this.trka = trka;	
	}
      

}




