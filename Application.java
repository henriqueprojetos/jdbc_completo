package br.com.caelum.main;

import java.sql.Connection;
import java.sql.SQLException;

import br.com.caelum.dao.ContatoDao;
import br.com.caelum.jdbc.ConnectionFactory;
import br.com.caelum.model.Contato;

public class Application {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try(Connection connection = new ConnectionFactory().getConnection()){
			
			ContatoDao contatoDao = new ContatoDao(connection);
			
			Contato c = new Contato
					("Luis Henrique", "henrique@mail.com,", "Rua Oliveira 175");
			
			contatoDao.adiciona(c);
			
		}catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
