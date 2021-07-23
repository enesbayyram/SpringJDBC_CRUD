package com.jforce.test;


import java.util.List;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.jforce.model.Personel;
import com.jforce.repository.IPersonelDAO;
import com.jforce.repository.impl.PersonelDAOImpl;

public class Test {

	public static void main(String[] args) {
		
		ConfigurableApplicationContext applicationContext = new ClassPathXmlApplicationContext("application-context.xml");
			
			
		Personel personel1 = new Personel("Aysun", "Meral", 4);
		Personel personel2 = new Personel("Murat", "Karakuş", 6);
		Personel personel3 = new Personel("Mustafa", "Yazıcı", 2);
		Personel personel4= new Personel("Yasin", "Yazıcı", 3);
		Personel personel5= new Personel("Eren", "Akar", 5);
		Personel personel6= new Personel("Berk", "Savaç", 4);
		Personel personel7= new Personel("Diyar", "Yüksel", 4);
		Personel personel8= new Personel("Berkay", "Baloğlu", 4);
		Personel personel9= new Personel("Muhammet Sinan", "Başarslan", 3);
		
		
		
		IPersonelDAO personelDAO = applicationContext.getBean("personelDAOImpl",PersonelDAOImpl.class);
		
//		personelDAO.create(personel1);
//		personelDAO.create(personel2);
//		personelDAO.create(personel3);
//		personelDAO.create(personel4);
//		personelDAO.create(personel5);
//		personelDAO.create(personel6);
//		personelDAO.create(personel7);
//		personelDAO.create(personel8);
//		personelDAO.create(personel9);
//		
//		personelDAO.update(personel, 2);
//		personelDAO.delete(2);
		
//		Personel personel =personelDAO.getPersonelById(1);
//		System.out.println(personel);
		
		List<Personel> personelList = personelDAO.getPersonelList();
		for (Personel personel : personelList) {
			System.out.println(personel);
		}
		
		applicationContext.close();
	}
}
