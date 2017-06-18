package br.univel.util;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import br.univel.model.Pet;

public class PetModel extends AbstractTableModel {

	private List<Pet> lista;
	
	public PetModel() {
		this((List<Pet>)null);
		
		for (int i = 0; i < 10; i++) {
			Pet c = new Pet();
			
			this.lista.add(c);
		}		
	}
	
	public PetModel(List<Pet> _lista) {
		if (_lista == null) {
			this.lista = new ArrayList<>();
		} else {
			this.lista = _lista;
		}
	}
	
	@Override
	public int getColumnCount() {
		return 4;
	}

	@Override
	public int getRowCount() {
		return lista.size();
	}

	@Override
	public String getColumnName(int column) {
		switch (column) {
		case 0:
			return "Id";
		case 1:
			return "Nome";
		case 2:
			return "Especie";
		case 3: 
			return "Nome Dono";
		}
		return super.getColumnName(column);
	}

	@Override
	public Object getValueAt(int row, int column) {
		
		Pet c = this.lista.get(row);
		
		switch (column) {
		case 0:
			return c.getId();
		case 1:
			return c.getNome();
		case 2:
			return c.getEspecie();
		case 3:
		    return c.getNome_dono();
		}
		
		// return "inexistente";
		throw new RuntimeException("Coluna " + column +
				" solicitada, não existe.");
	}

	public void adicionar(Pet c) {
		this.lista.add(c);

		// Dispara um evento para a JTable
		// atualizar sua estrutura/tela.
		super.fireTableDataChanged();
	}

	public Pet getPet(int idx) {
		return lista.get(idx);
	}

	public void remover(Pet PetSelecionado) {
		this.lista.remove(PetSelecionado);
		super.fireTableDataChanged();
	}
	
	
	
	
}
