package br.com.caelum.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.caelum.model.Contato;

public class ContatoDao implements IContatoDao {
	
	private Connection connection = null;
	
	public ContatoDao(Connection connection) {
		this.connection = connection;
	}

	@Override
	public void adiciona(Contato c) {
		// TODO Auto-generated method stub
		try {
			String sqlStatement	=	"insert	into	contatos	"	+
							"(nome,email,endereco,dataNascimento)	"	+
							"values	(?,?,?,?)";

			PreparedStatement ps = this.connection
					.prepareStatement(sqlStatement);
			
			ps.setString(1, c.getNome());
			ps.setString(2, c.getEmail());
			ps.setString(3, c.getEndereço());
			ps.setNull(4, 0);
			
			ps.execute();
			ps.close();
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}		
	}
}
