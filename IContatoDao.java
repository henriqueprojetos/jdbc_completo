package br.com.fj21.dao;

import java.util.List;

import br.com.fj21.model.Contato;

public interface IContatoDao {
	public void adiciona(Contato c);
	public List<Contato> listaContatos();
}
