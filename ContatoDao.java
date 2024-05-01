package br.com.fj21.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.fj21.model.Contato;

public class ContatoDao implements IContatoDao {

	@Override
	public void adiciona(Contato c) {
		// TODO Auto-generated method stub
		Connection connection = null;
		
		try {
			connection = new ConnectionFactory().getConnection();
			
			String sqlStatement	=	"insert	into	contatos	"	+
					"(nome,email,endereco,dataNascimento)	"	+
					"values	(?,?,?,?)";

			PreparedStatement ps = connection.prepareStatement(sqlStatement);	
	
			ps.setString(1, c.getNome());	
			ps.setString(2, c.getEmail());	
			ps.setString(3, c.getEndereco());	
			ps.setNull(4, 0);
			
			ps.execute();
			ps.close();
			
		} catch(SQLException e) {			
			throw new RuntimeException(e);			
		} finally {			
			try {				
				connection.close();				
			} catch(SQLException e) {				
				throw new RuntimeException(e);
			}
		}
	}
	
	@Override
	public List<Contato> listaContatos() {
		// TODO Auto-generated method stub
		Connection connection = null;
		
		List<Contato> contatos = new ArrayList<>();
		
		try {
			connection = new ConnectionFactory().getConnection();
			
			String sqlStatement = "SELECT * FROM contatos";
			
			PreparedStatement stmt = connection.prepareStatement(sqlStatement);
			
			ResultSet rs = stmt.executeQuery(sqlStatement);
			
			while(rs.next()) {
				Contato c = new Contato();
				
				c.setNome(rs.getString(1));
				c.setEmail(rs.getString(2));				
				c.setEndereco(rs.getString(3));
				
				contatos.add(c);
			}

			stmt.close();
			
			return contatos;
			
		} catch(SQLException e) {
			throw new RuntimeException(e);
		} finally {
			try {
				connection.close();
			} catch(SQLException e) {
				throw new RuntimeException(e);
		}
	}
	}
}
