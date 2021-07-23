package com.jforce.repository.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.jforce.model.Personel;
import com.jforce.repository.IPersonelDAO;

@Repository("personelDAOImpl")
public class PersonelDAOImpl implements IPersonelDAO {

	private JdbcTemplate jdbcTemplate = new JdbcTemplate();

	@Override
	public void create(Personel personel) {

		String query = "INSERT INTO spring_jdbc.personel (firstName,lastName,experinceYear)" + "VALUES(?,?,?)";
		int result;
		try {
			result = jdbcTemplate.update(query,
					new Object[] { personel.getFirstName(), personel.getLastName(), personel.getExperinceYear() });
			if (result > 0) {
				System.out.println("Kayıt Eklendi :)");
			} else {
				System.out.println("Kayıt Eklenemedi :(");
			}
		} catch (Exception e) {
			System.out.println("Hata : " + e.getMessage());
		}
	}

	@Override
	public void update(Personel personel, int id) {
		String query = "UPDATE spring_jdbc.personel SET firstName=? , lastName=? WHERE id=?";
		int result;
		try {
			result = jdbcTemplate.update(query, new Object[] { personel.getFirstName(), personel.getLastName(), id });
			if (result > 0) {
				System.out.println("Kayıt Güncellendi.");
			} else {
				System.out.println("Kayıt Güncellenemedi! - Verilen id ' ye denk gelen personel olmayabilir.");
			}

		} catch (Exception e) {
			System.out.println("HATA : " + e.getMessage());
		}
	}

	@Override
	public void delete(int personelId) {

		String query = "DELETE FROM spring_jdbc.personel WHERE id =?";
		int result;

		try {
			result = jdbcTemplate.update(query, new Object[] { personelId });
			if (result > 0) {
				System.out.println("Kayıt Silindi");
			} else {
				System.out.println("Kayıt silinemedi - verilen id 'ye denk gelen personel olmayabilir.");
			}
		} catch (Exception e) {
			System.out.println("Hata : " + e.getMessage());
		}
	}

	@SuppressWarnings("deprecation")
	@Override
	public Personel getPersonelById(int personelId) {

		String query = "SELECT * FROM spring_jdbc.personel WHERE id=?";
		Personel personel = null;

		try {
			personel = jdbcTemplate.queryForObject(query, new Object[] { personelId }, new RowMapper<Personel>() {

				@Override
				public Personel mapRow(ResultSet rs, int rowNum) throws SQLException {
					Personel personel = new Personel();
					personel.setPersonelId(rs.getInt("id"));
					personel.setFirstName(rs.getString("firstName"));
					personel.setLastName(rs.getString("lastName"));
					personel.setExperinceYear(rs.getInt("experinceYear"));
					return personel;
				}

			});
		} catch (Exception e) {
			System.out.println("Hata  :" + e.getMessage());
		}
		return personel;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Personel> getPersonelList() {
		String query = "SELECT * FROM spring_jdbc.personel";
		List<Personel> personelList=new ArrayList<Personel>();
		try {
			personelList=jdbcTemplate.query(query, new RowMapper() {

				@Override
				public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
					Personel personel = new Personel();
					personel.setPersonelId(rs.getInt("id"));
					personel.setFirstName(rs.getString("firstName"));
					personel.setLastName(rs.getString("lastName"));
					personel.setExperinceYear(rs.getInt("experinceYear"));
					return personel;
				}
				
			});
		} catch (Exception e) {
			System.out.println("Hata : " + e.getMessage());
			}
		return personelList;
	}

	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate.setDataSource(dataSource);
	}

}
