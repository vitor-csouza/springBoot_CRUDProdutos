package br.com.fiap.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import br.com.fiap.model.ProdutoModel;

@Repository
public class ProdutoRepository {
	
	private static final String GET_ALL = "SELECT * FROM TB_PRODUTO";
	private static final String SAVE = "INSERT INTO TB_PRODUTO (NOME, SKU, DESCRICAO, PRECO, CARACTERISTICAS) VALUES (?, ?, ?, ?, ?)";
	private static final String GET = "SELECT * FROM TB_PRODUTO WHERE ID=?";
	private static final String UPDATE = "UPDATE TB_PRODUTO SET NOME=?, SKU=?, DESCRICAO=?, CARACTERISTICAS=?, PRECO=? WHERE ID=?";
	private static final String DELETE = "DELETE FROM TB_PRODUTO WHERE ID=?";
	
	@Autowired
	public JdbcTemplate jdbcTemplate;
	
	public ProdutoRepository() {
		super();
	}
	
	
	public List<ProdutoModel> findAll() {
		List<ProdutoModel> produtos = this.jdbcTemplate.query(GET_ALL, 
				new BeanPropertyRowMapper<ProdutoModel>(ProdutoModel.class));
		return produtos;
	}
	

	public ProdutoModel findById(long id) {
		ProdutoModel produto = this.jdbcTemplate.queryForObject(GET, 
				new BeanPropertyRowMapper<ProdutoModel>(ProdutoModel.class), id);
		return produto;
	}

	
	public void update(ProdutoModel produtoModel) {
		this.jdbcTemplate.update(UPDATE, 
				produtoModel.getNome(), 
				produtoModel.getSku(), 
				produtoModel.getDescricao(), 
				produtoModel.getCaracteristicas(), 
				produtoModel.getPreco(),
				produtoModel.getId());
	}

	public void save(ProdutoModel produtoModel) {
		this.jdbcTemplate.update(SAVE, produtoModel.getNome(), produtoModel.getSku(), produtoModel.getDescricao(), produtoModel.getPreco(), produtoModel.getCaracteristicas());
	}
	public void deleteById(long id) {
		this.jdbcTemplate.update(DELETE, id);
	}
	
}
