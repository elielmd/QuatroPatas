package br.univel.view;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class TelaPrincipalBase extends JFrame {

	private static final long serialVersionUID = 628950292772124235L;
	protected static final String CARREGADO_PARA_ALTERACAO = "Carregado para alteração";
	private JPanel contentPane;
	protected JTextField txfId;
	protected JTextField txfNome;
	protected JTextField txfEspecie;
	protected JTable table;
	protected JButton btnNovo;
	protected JButton btnSalvar;
	protected JButton btnExcluir;
	protected JLabel labelAlerta;
	protected JTextField txfNomeDono;
	protected JLabel lbNomeDono;

	public TelaPrincipalBase() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[] { 0, 0 };
		gbl_contentPane.rowHeights = new int[] { 0, 0, 0, 0 };
		gbl_contentPane.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
		gbl_contentPane.rowWeights = new double[] { 0.0, 0.0, 1.0, Double.MIN_VALUE };
		contentPane.setLayout(gbl_contentPane);

		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.insets = new Insets(0, 0, 5, 0);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 0;
		contentPane.add(panel, gbc_panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[] { 0, 0, 0, 0 };
		gbl_panel.rowHeights = new int[] { 0, 0, 0, 0, 0 };
		gbl_panel.columnWeights = new double[] { 0.0, 1.0, 1.0, Double.MIN_VALUE };
		gbl_panel.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		panel.setLayout(gbl_panel);

		JLabel lblId = new JLabel("Id");
		GridBagConstraints gbc_lblId = new GridBagConstraints();
		gbc_lblId.anchor = GridBagConstraints.EAST;
		gbc_lblId.insets = new Insets(0, 0, 5, 5);
		gbc_lblId.gridx = 0;
		gbc_lblId.gridy = 0;
		panel.add(lblId, gbc_lblId);

		txfId = new JTextField();
		GridBagConstraints gbc_txfId = new GridBagConstraints();
		gbc_txfId.anchor = GridBagConstraints.WEST;
		gbc_txfId.insets = new Insets(0, 0, 5, 5);
		gbc_txfId.gridx = 1;
		gbc_txfId.gridy = 0;
		panel.add(txfId, gbc_txfId);
		txfId.setColumns(5);

		labelAlerta = new JLabel(CARREGADO_PARA_ALTERACAO);
		labelAlerta.setForeground(Color.RED);
		GridBagConstraints gbc_labelAlerta = new GridBagConstraints();
		gbc_labelAlerta.anchor = GridBagConstraints.WEST;
		gbc_labelAlerta.insets = new Insets(0, 0, 5, 0);
		gbc_labelAlerta.gridx = 2;
		gbc_labelAlerta.gridy = 0;
		panel.add(labelAlerta, gbc_labelAlerta);

		JLabel lblNome = new JLabel("Nome");
		GridBagConstraints gbc_lblNome = new GridBagConstraints();
		gbc_lblNome.anchor = GridBagConstraints.EAST;
		gbc_lblNome.insets = new Insets(0, 0, 5, 5);
		gbc_lblNome.gridx = 0;
		gbc_lblNome.gridy = 1;
		panel.add(lblNome, gbc_lblNome);

		txfNome = new JTextField();
		GridBagConstraints gbc_txfNome = new GridBagConstraints();
		gbc_txfNome.gridwidth = 2;
		gbc_txfNome.insets = new Insets(0, 0, 5, 0);
		gbc_txfNome.fill = GridBagConstraints.HORIZONTAL;
		gbc_txfNome.gridx = 1;
		gbc_txfNome.gridy = 1;
		panel.add(txfNome, gbc_txfNome);
		txfNome.setColumns(10);

		JLabel lblEspecie = new JLabel("Especie");
		GridBagConstraints gbc_lblEspecie = new GridBagConstraints();
		gbc_lblEspecie.anchor = GridBagConstraints.EAST;
		gbc_lblEspecie.insets = new Insets(0, 0, 5, 5);
		gbc_lblEspecie.gridx = 0;
		gbc_lblEspecie.gridy = 2;
		panel.add(lblEspecie, gbc_lblEspecie);

		txfEspecie = new JTextField();
		GridBagConstraints gbc_txfEspecie = new GridBagConstraints();
		gbc_txfEspecie.insets = new Insets(0, 0, 5, 0);
		gbc_txfEspecie.fill = GridBagConstraints.HORIZONTAL;
		gbc_txfEspecie.gridwidth = 2;
		gbc_txfEspecie.gridx = 1;
		gbc_txfEspecie.gridy = 2;
		panel.add(txfEspecie, gbc_txfEspecie);
		txfEspecie.setColumns(15);

		lbNomeDono = new JLabel("Dono");
		GridBagConstraints gbc_lbNomeDono = new GridBagConstraints();
		gbc_lbNomeDono.insets = new Insets(0, 0, 0, 5);
		gbc_lbNomeDono.anchor = GridBagConstraints.EAST;
		gbc_lbNomeDono.gridx = 0;
		gbc_lbNomeDono.gridy = 3;
		panel.add(lbNomeDono, gbc_lbNomeDono);

		txfNomeDono = new JTextField();
		GridBagConstraints gbc_txfNomeDono = new GridBagConstraints();
		gbc_txfNomeDono.gridwidth = 2;
		gbc_txfNomeDono.fill = GridBagConstraints.HORIZONTAL;
		gbc_txfNomeDono.gridx = 1;
		gbc_txfNomeDono.gridy = 3;
		panel.add(txfNomeDono, gbc_txfNomeDono);
		txfNomeDono.setColumns(10);

		JPanel panel_1 = new JPanel();
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.insets = new Insets(0, 0, 5, 0);
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridx = 0;
		gbc_panel_1.gridy = 1;
		contentPane.add(panel_1, gbc_panel_1);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[] { 0, 0, 0, 0 };
		gbl_panel_1.rowHeights = new int[] { 0, 0 };
		gbl_panel_1.columnWeights = new double[] { 1.0, 0.0, 0.0, Double.MIN_VALUE };
		gbl_panel_1.rowWeights = new double[] { 0.0, Double.MIN_VALUE };
		panel_1.setLayout(gbl_panel_1);

		btnNovo = new JButton("Novo");
		GridBagConstraints gbc_btnNovo = new GridBagConstraints();
		gbc_btnNovo.anchor = GridBagConstraints.EAST;
		gbc_btnNovo.insets = new Insets(0, 0, 0, 5);
		gbc_btnNovo.gridx = 0;
		gbc_btnNovo.gridy = 0;
		panel_1.add(btnNovo, gbc_btnNovo);

		btnSalvar = new JButton("Salvar");
		GridBagConstraints gbc_btnSalvar = new GridBagConstraints();
		gbc_btnSalvar.insets = new Insets(0, 0, 0, 5);
		gbc_btnSalvar.gridx = 1;
		gbc_btnSalvar.gridy = 0;
		panel_1.add(btnSalvar, gbc_btnSalvar);

		btnExcluir = new JButton("Excluir");
		GridBagConstraints gbc_btnExcluir = new GridBagConstraints();
		gbc_btnExcluir.gridx = 2;
		gbc_btnExcluir.gridy = 0;
		panel_1.add(btnExcluir, gbc_btnExcluir);

		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 2;
		contentPane.add(scrollPane, gbc_scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);
	}

}
