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


@Table(name="trka")
@Entity
public class Trka extends AbstractBaseEntity { 
 
	@Column(name="naziv")
    private String naziv;
        
	@Column(name="cena")
    private int cena;
        
	@Column(name="duzinakm")
    private double duzinaKm;
        
	@ManyToOne(fetch=FetchType.LAZY)
    private Takmicenje takmicenje;
        
    @OneToMany(mappedBy="trka",cascade=CascadeType.REMOVE)
	private List<Takmicar> takmicariList = new ArrayList<Takmicar>();
        

	public Trka() {}

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
      
  	public Takmicenje getTakmicenje(){
    	return takmicenje;
  	}
  
  	public void setTakmicenje(Takmicenje takmicenje){
       	this.takmicenje = takmicenje;	
	}
      
   	public void addTakmicari(Takmicar takmicari){
		this.takmicariList.add(takmicari);
		
		if(takmicari.getTrka() != this){
			takmicari.setTrka(this);
		}
	}
	
	public void removeTakmicari(Takmicar takmicari){
		takmicari.setTrka(null);
		takmicariList.remove(takmicari);
	}
	

}




