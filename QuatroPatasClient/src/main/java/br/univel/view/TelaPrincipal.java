package br.univel.view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Hashtable;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.UnsupportedLookAndFeelException;

import br.univel.dao.PetDao;
import br.univel.model.Pet;
import br.univel.util.PetModel;

public class TelaPrincipal extends TelaPrincipalBase {

	private static final long serialVersionUID = 2707804257241816694L;

	private Pet PetSelecionado;

	private PetModel modelo;

	public TelaPrincipal() throws NamingException {
		super();
		txfId.setEditable(false);
		limparCampos();
		configurarBotoes();
		configuraTabela();

	}

	private static PetDao lookupRemoteStateless() throws NamingException {
		final Hashtable<String, String> jndiProperties = new Hashtable<>();

		jndiProperties.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");

		final Context context = new InitialContext(jndiProperties);

		return (PetDao) context.lookup("ejb:/QuatroPatasServer/PetDaoImpl!" + PetDao.class.getName());
	}

	private void configuraTabela() throws NamingException {

		PetDao dao = lookupRemoteStateless();
		List<Pet> lista = dao.buscarTodos();

		this.modelo = new PetModel(lista);
		super.table.setModel(modelo);

		super.table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getClickCount() == 2) {
					int idx = table.getSelectedRow();
					if (idx < 0) {
						System.out.println("Não há linha selecionada");
					} else {
						System.out.println("Linha " + idx);
						carregarLinha(idx);
					}
				}
			}
		});

	}

	protected void carregarLinha(int idx) {
		Pet c = this.modelo.getPet(idx);
		txfId.setText(String.valueOf(c.getId()));
		txfNome.setText(c.getNome());
		txfEspecie.setText(c.getEspecie());
		txfNomeDono.setText(c.getNome_dono());
		this.PetSelecionado = c;
		this.labelAlerta.setText(CARREGADO_PARA_ALTERACAO);
		super.btnExcluir.setEnabled(true);

	}

	private void configurarBotoes() {
		super.btnNovo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Clicou Novo");
				novo();
			}
		});
		super.btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Clicou Salvar");
				try {
					salvar();
				} catch (NamingException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		super.btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Clicou Excluir");
				try {
					excluir();
				} catch (NamingException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
	}

	protected void excluir() throws NamingException {
		PetDao dao = lookupRemoteStateless();
		System.out.println("A");
		dao.remover(this.PetSelecionado);
		System.out.println("B");
		this.modelo.remover(this.PetSelecionado);
		System.out.println("C");
		limparCampos();
	}

	protected void salvar() throws NamingException {
		PetDao dao = lookupRemoteStateless();

		if (PetSelecionado == null) {
			Pet c = new Pet();

			// String strId = txfId.getText().trim();
			String strNome = txfNome.getText().trim();
			String strEspecie = txfEspecie.getText().trim();
			String strNomeDono = txfNomeDono.getText().trim();

			// Long intId = Long.parseLong(strId);

			// c.setId(intId);
			c.setNome(strNome);
			c.setEspecie(strEspecie);
			c.setNome_dono(strNomeDono);

			dao.salvar(c);
			this.modelo.adicionar(c);

			limparCampos();

		} else {

			// String strId = txfId.getText().trim();
			String strNome = txfNome.getText().trim();
			String strEspecie = txfEspecie.getText().trim();
			String strNomeDono = txfNomeDono.getText().trim();

			// Long intId = Long.parseLong(strId);

			// this.PetSelecionado.setId(intId);
			this.PetSelecionado.setNome(strNome);
			this.PetSelecionado.setEspecie(strEspecie);
			this.PetSelecionado.setNome_dono(strNomeDono);

			dao.inserir(this.PetSelecionado);

			limparCampos();
			this.modelo.fireTableDataChanged();
		}

	}

	protected void novo() {
		this.PetSelecionado = null;

		limparCampos();
	}

	private void limparCampos() {

		super.labelAlerta.setText("");
		super.txfId.setText("");
		super.txfNome.setText("");
		super.txfEspecie.setText("");
		super.txfNomeDono.setText("");

		super.btnExcluir.setEnabled(false);
	}

	public static void main(String[] args) {

		try {

			for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}

		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e1) {
			e1.printStackTrace();
		}

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaPrincipal frame = new TelaPrincipal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
