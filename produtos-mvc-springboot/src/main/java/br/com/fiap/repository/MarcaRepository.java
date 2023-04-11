package br.com.fiap.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import br.com.fiap.model.MarcaModel;

public class MarcaRepository {
	
	private static final String CREATE = "INSERT INTO TB_MARCA (NOME) VALUES (?)";
	private static final String GET_ALL_MARCAS="SELECT * FROM TB_MARCA";
	private static final String GET_MARCA_BY_ID = "SELECT * FROM TB_MARCA WHERE id=?";
	private static final String UPDATE_MARCA = "UPDATE TB_MARCA SET NOME=? WHERE ID=?";
	private static final String DELETE = "DELETE FROM TB_MARCA WHERE ID=?";
	
	@Autowired
	public JdbcTemplate jdbcTemplate;
	
	public MarcaRepository() {
		super();
	}
	
	//create
	public void create(MarcaModel marca) {
		this.jdbcTemplate.update(CREATE,marca.getNome());
	}
	
	//read
	public List<MarcaModel> getAllMarcas(){
		return jdbcTemplate.query(GET_ALL_MARCAS, new BeanPropertyRowMapper<MarcaModel>(MarcaModel.class));
	}
	
	public MarcaModel getById(long id) {
		return this.jdbcTemplate.queryForObject(GET_MARCA_BY_ID, new BeanPropertyRowMapper<MarcaModel>(MarcaModel.class),id);
	}
	
	
	//update
	public void update(MarcaModel marca) {
		this.jdbcTemplate.update(UPDATE_MARCA,marca.getNome(), marca.getId());
	}
	
	//delete
	public void deleteById(long id) {
		this.jdbcTemplate.update(DELETE,id);
	}
}
