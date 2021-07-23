package com.jforce.repository;


import java.util.List;

import com.jforce.model.Personel;

public interface IPersonelDAO {
	
	public void create(Personel personel);
	
	public void update(Personel personel , int personelId);
	
	public void delete(int personelId);
	
	public Personel getPersonelById(int personelId);
	
	public List<Personel> getPersonelList();
}
