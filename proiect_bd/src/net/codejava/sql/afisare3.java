package net.codejava.sql;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;


public class afisare3 {
	
	public String conectare_informatii(String executa,int nr)
    {
    	
    	String URL;
    	String Username;
    	String Password;
    	Username="sa";
    	Password="12345";
    	URL="jdbc:sqlserver://DESKTOP-8LL24UK\\SQLEXPRESS;databaseName=Gestiune_Licenta";
        String actionare ="    ";
    	
        try {
		Connection connection=DriverManager.getConnection(URL,Username,Password);
		Statement statement = connection.createStatement();
		ResultSet result= statement.executeQuery(executa);
	 
		
		while (result.next()) 
		{   
			
			for(int i=1;i<=nr;i++)
			{
				
			actionare = actionare+result.getString(i);
			
			}
			actionare=actionare+"\n";
			actionare=actionare+"    ";
			
		}
			connection.close();
        } 
        catch (SQLException e)
    	{
		   System.out.println("eroare");
		   e.printStackTrace();
    	}
        return actionare;
    }
	
	public String conectare_informatii2(String executa,int nr)
    {
    	
    	String URL;
    	String Username;
    	String Password;
    	Username="sa";
    	Password="12345";
    	URL="jdbc:sqlserver://DESKTOP-8LL24UK\\SQLEXPRESS;databaseName=Gestiune_Licenta";
        String actionare =" ";
    	
        try {
		Connection connection=DriverManager.getConnection(URL,Username,Password);
		Statement statement = connection.createStatement();
		ResultSet result= statement.executeQuery(executa);
	 
		
		while (result.next()) 
		{   
			
			for(int i=1;i<=nr;i++)
			{
				
			actionare = actionare+result.getString(i);
			
			}
			
		}
			connection.close();
        } 
        catch (SQLException e)
    	{
		   System.out.println("eroare");
		   e.printStackTrace();
    	}
        return actionare;
    }	

	private JFrame frame;
	private JTextField tf1;
	private JTextField tf2;
	private JTextField tf3;
	private JTextField tf4;
	private JTextField tf5;
	private JTextField tf6;

	/**
	 * Launch the application.
	 */
	public static void newScreen2() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					afisare3 window = new afisare3();
					window.frame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public afisare3() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBackground(Color.GRAY);
		frame.getContentPane().setFont(new Font("Times New Roman", Font.BOLD, 16));
		frame.getContentPane().setForeground(Color.WHITE);
		frame.getContentPane().setBackground(Color.BLACK);
		frame.setBounds(100, 100, 787, 505);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(31, 19, 0));
		panel_2.setBounds(0, 0, 367, 62);
		frame.getContentPane().add(panel_2);
		
		JTextArea txtrInformatiiPentruStudenti = new JTextArea();
		txtrInformatiiPentruStudenti.setForeground(Color.WHITE);
		txtrInformatiiPentruStudenti.setFont(new Font("Times New Roman", Font.BOLD, 16));
		txtrInformatiiPentruStudenti.setText("INFORMATII PENTRU STUDENTI");
		txtrInformatiiPentruStudenti.setBackground(new Color(31, 19, 0));
		txtrInformatiiPentruStudenti.setEditable(false);
		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addGap(41)
					.addComponent(txtrInformatiiPentruStudenti, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(59, Short.MAX_VALUE))
		);
		gl_panel_2.setVerticalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panel_2.createSequentialGroup()
					.addContainerGap(24, Short.MAX_VALUE)
					.addComponent(txtrInformatiiPentruStudenti, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE))
		);
		panel_2.setLayout(gl_panel_2);
		
		JTextArea tt1 = new JTextArea();
		tt1.setBounds(43, 49, 718, 322);
		tt1.setText("Nume_Facultate:");
		tt1.setForeground(Color.WHITE);
		tt1.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		tt1.setBackground(new Color(107, 5, 4));
		
		
		////////////////////////////////////////////////////////////////////////
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 61, 367, 405);
		panel_1.setBackground(new Color (177, 9, 6));
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JTextArea textArea1 = new JTextArea();
		textArea1.setBounds(10, 82, 347, 312);
		panel_1.add(textArea1);
		textArea1.setForeground(Color.WHITE);
		textArea1.setBackground(new Color(107, 5, 4));
		textArea1.setVisible(false);
		
		JTextArea textArea2 = new JTextArea();
		textArea2.setBounds(10, 131, 336, 263);
		panel_1.add(textArea2);
		textArea2.setForeground(Color.WHITE);
		textArea2.setBackground(new Color(107, 5, 4));
		textArea2.setVisible(false);
		
		//FIELD
		tf1 = new JTextField();
		tf1.setBounds(162, 11, 86, 20);
		panel_1.add(tf1);
		tf1.setForeground(Color.BLACK);
		tf1.setBackground(Color.WHITE);
		tf1.setColumns(10);
		tf1.setVisible(false);
		
		tf2 = new JTextField();
		tf2.setBounds(174, 11, 86, 20);
		panel_1.add(tf2);
		tf2.setForeground(Color.BLACK);
		tf2.setBackground(Color.WHITE);
		tf2.setColumns(10);
		tf2.setVisible(false);
		
		
		tf3 = new JTextField();
		tf3.setBounds(174, 42, 86, 20);
		panel_1.add(tf3);
		tf3.setForeground(Color.BLACK);
		tf3.setBackground(Color.WHITE);
		tf3.setColumns(10);
		tf3.setVisible(false);
		
		tf4 = new JTextField();
		tf4.setBounds(137, 11, 123, 20);
		panel_1.add(tf4);
		tf4.setForeground(Color.BLACK);
		tf4.setBackground(Color.WHITE);
		tf4.setColumns(10);
		tf4.setVisible(false);
		
		tf5 = new JTextField();
		tf5.setForeground(Color.BLACK);
		tf5.setColumns(10);
		tf5.setBackground(Color.WHITE);
		tf5.setBounds(153, 11, 155, 20);
		panel_1.add(tf5);
		tf5.setVisible(false);
		
		tf6 = new JTextField();
		tf6.setForeground(Color.BLACK);
		tf6.setColumns(10);
		tf6.setBackground(Color.WHITE);
		tf6.setBounds(153, 11, 86, 20);
		panel_1.add(tf6);
		tf6.setVisible(false);
		
		//BUTOANE
		
		JButton b8 = new JButton("EXECUTA");
		b8.setBounds(185, 44, 113, 27);
		panel_1.add(b8);
		b8.setVerticalAlignment(SwingConstants.TOP);
		b8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea1.setVisible(true);
				textArea1.setText("");
				String salvare ="SELECT Nume,Prenume,Titulatura,Materia from [Gestiune_Licenta].[dbo].[Profesori] where ID_Profesor in(select ID_Profesor from [Gestiune_Licenta].[dbo].[Legatura_Profesori_Facultati] group by ID_Profesor having count(*)>1)";
				textArea1.append("\n    Prin metoda complexa:\n");
				textArea1.append("\n    Acestia sunt profesorii care predau la mai mult de o facultate:\n");
				textArea1.append("    Nume\tPrenume\tTitulatura\tMaterie\n");
				System.out.println(salvare);
				textArea1.append(conectare_informatii(salvare,4));
			}
		});
		b8.setFont(new Font("Times New Roman", Font.BOLD, 16));
		b8.setVisible(false);

	
		
		
		JButton bb1 = new JButton("EXECUTA");
		bb1.setVerticalAlignment(SwingConstants.TOP);
		bb1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea1.setVisible(true);
				textArea1.setText("");
				String data = tf1.getText();
				String salvare ="SELECT Nume,Prenume,CNP from [Gestiune_Licenta].[dbo].[Studenti] where ID_Proiect in ( select ID_Proiect from [Gestiune_Licenta].[dbo].[Proiect_Licenta] where Data_Prezentare='"+data+"')";
				textArea1.append("\n    Prin metoda complexa:\n");
				textArea1.append("\n    Acestia sunt studentii care sustin licenta la data de "+data+":\n");
				textArea1.append("    Nume\tPrenume\tCNP\n");
				System.out.println(salvare);
				textArea1.append(conectare_informatii(salvare,3));
				  
			}
		});
		bb1.setFont(new Font("Times New Roman", Font.BOLD, 16));
		bb1.setBounds(185, 44, 113, 27);
		panel_1.add(bb1);
		bb1.setVisible(false);
		
		
		
		JButton bb3 = new JButton("EXECUTA");
		bb3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				textArea2.setVisible(true);
				textArea2.setText("");
				String nume = tf2.getText();
				String prenume = tf3.getText();
				String salvare ="SELECT Nume,Prenume,CNP from [Gestiune_Licenta].[dbo].[Studenti] where ID_Profesor_Coordonator  in ( select ID_Profesor from [Gestiune_Licenta].[dbo].[Profesori] where Nume='"+nume+"' and Prenume = '"+prenume+"')";
				textArea2.append("\n    Prin metoda complexa:\n");
				textArea2.append("\n    Acestia sunt studentii care au profesorul coordonator dat:\n");
				textArea2.append("    Nume\tPrenume\tCNP\n");
				System.out.println(salvare);
				textArea2.append(conectare_informatii(salvare,3));
				  
			}
		});
		bb3.setVerticalAlignment(SwingConstants.TOP);
		bb3.setFont(new Font("Times New Roman", Font.BOLD, 16));
		bb3.setBounds(185, 82, 113, 27);
		panel_1.add(bb3);
		bb3.setVisible(false);
		
	
		
		JButton bb5 = new JButton("EXECUTA");
		bb5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea1.setVisible(true);
				textArea1.setText("");
				String tema = tf4.getText();
				String salvare ="SELECT Nume, Prenume, Titulatura,Materia from [Gestiune_Licenta].[dbo].[Profesori] where ID_Profesor in( select ID_Profesor_Coordonator from [Gestiune_Licenta].[dbo].[Studenti] where ID_Proiect in ( select ID_Proiect from [Gestiune_Licenta].[dbo].[Proiect_Licenta] where Tema_Proiect='"+tema+"'))";
				textArea1.append("\n    Prin metoda complexa:\n");
				textArea1.append("\n    Acestia sunt profesorii care coordoneaza studenti \n ce vor prezenta proiecte de licenta cu tema "+tema+":\n");
				textArea1.append("    Nume\tPrenume\tTitulatura\tMaterie\n");
				System.out.println(salvare);
				textArea1.append(conectare_informatii(salvare,4));
				  
			}
		});
		bb5.setVerticalAlignment(SwingConstants.TOP);
		bb5.setFont(new Font("Times New Roman", Font.BOLD, 16));
		bb5.setBounds(185, 44, 113, 27);
		panel_1.add(bb5);
		bb5.setVisible(false);
		
	
		
		JButton bb7 = new JButton("EXECUTA");
		bb7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea1.setVisible(true);
				textArea1.setText("");
				String facultate = tf5.getText();
				String salvare ="SELECT  A.Nume,A.Prenume,A.CNP from [Gestiune_Licenta].[dbo].[Studenti] A where ID_Profesor_Coordonator in(select ID_Profesor from  [Gestiune_Licenta].[dbo].[Profesori] where ID_Profesor in( select ID_Profesor from [Gestiune_Licenta].[dbo].[Legatura_Profesori_Facultati] where ID_Facultate in (Select ID_Facultate from [Gestiune_Licenta].[dbo].[Facultati] where Nume_Facultate='"+facultate+"')and Titulatura='laborant') )";
				textArea1.append("\n    Prin metoda complexa:\n");
				textArea1.append("\n    Acestia sunt studentii care au profesori coordonatori la \n licenta cu titulatura='laborant' si din cadrul facultatii \n"+facultate+":\n");
				textArea1.append("    Nume\tPrenume\tCNP\n");
				System.out.println(salvare);
				textArea1.append(conectare_informatii(salvare,3));
				  
			}
		});
		bb7.setVerticalAlignment(SwingConstants.TOP);
		bb7.setFont(new Font("Times New Roman", Font.BOLD, 16));
		bb7.setBounds(185, 44, 113, 27);
		panel_1.add(bb7);
		bb7.setVisible(false);
		
		
		JButton bb9 = new JButton("EXECUTA");
		bb9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea1.setVisible(true);
				textArea1.setText("");
				String sala = tf6.getText();
				String salvare ="SELECT Nume,Prenume,Titulatura,Materia from [Gestiune_Licenta].[dbo].[Profesori] A inner join [Gestiune_Licenta].[dbo].[Comisie] B on A.Nr_Comisie=B.Nr_Comisie where Sala_Prezentare='"+sala+"' order by Nume";
				textArea1.append("\n    Prin metoda complexa:\n");
				String nr_comisie="Select Nr_Comisie from [Gestiune_Licenta].[dbo].[Comisie] where Sala_Prezentare='"+sala+"'";
				String comisie=conectare_informatii2(nr_comisie,1);
				textArea1.append("\n    Acestia sunt profesorii in ordine alfabetica care apartin \n comisiei"+comisie+":\n");
				textArea1.append("    Nume\tPrenume\tTitulatura\tMaterie\n");
				System.out.println(salvare);
				textArea1.append(conectare_informatii(salvare,4));
				  
			}
		});
		bb9.setVerticalAlignment(SwingConstants.TOP);
		bb9.setFont(new Font("Times New Roman", Font.BOLD, 16));
		bb9.setBounds(185, 44, 113, 27);
		panel_1.add(bb9);
		bb9.setVisible(false);
		
		//AREAS
		JTextArea t7 = new JTextArea();
		t7.setBounds(44, 11, 99, 21);
		panel_1.add(t7);
		t7.setText("Data_Prezentare:");
		t7.setForeground(Color.WHITE);
		t7.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		t7.setBackground(new Color(107, 5, 4));
		t7.setVisible(false);
		
		JTextArea t8 = new JTextArea();
		t8.setBounds(42, 11, 110, 21);
		panel_1.add(t8);
		t8.setText("Nume_Prof_Crd:");
		t8.setForeground(Color.WHITE);
		t8.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		t8.setBackground(new Color(107, 5, 4));
		t8.setVisible(false);
		
		JTextArea t9 = new JTextArea();
		t9.setText("Prenume_Prof_Crd:");
		t9.setForeground(Color.WHITE);
		t9.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		t9.setBackground(new Color(107, 5, 4));
		t9.setBounds(39, 42, 123, 21);
		panel_1.add(t9);
		t9.setVisible(false);
		
		JTextArea tt4 = new JTextArea();
		tt4.setBounds(41, 11, 86, 21);
		panel_1.add(tt4);
		tt4.setText("Tema_Proiect:");
		tt4.setForeground(Color.WHITE);
		tt4.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		tt4.setBackground(new Color(107, 5, 4));
		tt4.setVisible(false);
		
		JTextArea tt2 = new JTextArea();
		tt2.setText("Nume_Facultate:");
		tt2.setForeground(Color.WHITE);
		tt2.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		tt2.setBackground(new Color(107, 5, 4));
		tt2.setBounds(39, 11, 104, 21);
		panel_1.add(tt2);
		tt2.setVisible(false);
		
		JTextArea tt3 = new JTextArea();
		tt3.setBounds(39, 11, 96, 21);
		panel_1.add(tt3);
		tt3.setWrapStyleWord(true);
		tt3.setText("Sala_Prezentare:");
		tt3.setForeground(Color.WHITE);
		tt3.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		tt3.setBackground(new Color(107, 5, 4));
		tt3.setVisible(false);
		
		////////////////////////////////////////////////////////////////////////
		JPanel panel = new JPanel();
		panel.setBounds(366, 0, 405, 466);
		panel.setBackground(new Color (107, 5, 4));
		frame.getContentPane().add(panel);
		
		
		JTextArea t2 = new JTextArea();
		t2.setWrapStyleWord(true);
		t2.setText("Aflati toti studentii care sustin proiectul de licenta la o data anume.");
		t2.setForeground(Color.WHITE);
		t2.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		t2.setEditable(false);
		t2.setBackground(new Color(107, 5, 4));
		
		JTextArea t3 = new JTextArea();
		t3.setWrapStyleWord(true);
		t3.setText("Aflati toti studentii care au un anumit profesor coordonator.");
		t3.setForeground(Color.WHITE);
		t3.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		t3.setEditable(false);
		t3.setBackground(new Color(107, 5, 4));
		
		JTextArea t4 = new JTextArea();
		t4.setWrapStyleWord(true);
		t4.setText("Aflati toti profesorii care coordoneaza studenti ce vor prezenta\r\nproiecte de licenta cu o anumita tema.");
		t4.setForeground(Color.WHITE);
		t4.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		t4.setEditable(false);
		t4.setBackground(new Color(107, 5, 4));
		
		JTextArea t5 = new JTextArea();
		t5.setWrapStyleWord(true);
		t5.setText("Aflati studentii care au profesori coordonatori la licenta cu \r\ntitulatura='laborant' si din cardul unei anumite facultati.");
		t5.setForeground(Color.WHITE);
		t5.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		t5.setEditable(false);
		t5.setBackground(new Color(107, 5, 4));
		
		
		JButton b2 = new JButton("SEARCH");
		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				textArea2.setVisible(false);
				textArea1.setText("");
				textArea1.setVisible(true);
				
				b8.setVisible(false);

				tf1.setVisible(true);
				bb1.setVisible(true);
				t7.setVisible(true);

				tf2.setVisible(false);
				tf3.setVisible(false);
				bb3.setVisible(false);
				t8.setVisible(false);
				t9.setVisible(false);

				tf4.setVisible(false);
				bb5.setVisible(false);
				tt4.setVisible(false);

				tf5.setVisible(false);
				bb7.setVisible(false);
				tt2.setVisible(false);

				tf6.setVisible(false);
				bb9.setVisible(false);
				tt3.setVisible(false);
			}
		});
		b2.setFont(new Font("Times New Roman", Font.BOLD, 16));
		
		JButton b3 = new JButton("SEARCH");
		b3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				textArea2.setText("");
				textArea2.setVisible(true);
				textArea1.setText("");
				textArea1.setVisible(false);
				b8.setVisible(false);

				tf1.setVisible(false);
				bb1.setVisible(false);
				t7.setVisible(false);

				tf2.setVisible(true);
				tf3.setVisible(true);
				bb3.setVisible(true);
				t8.setVisible(true);
				t9.setVisible(true);

				tf4.setVisible(false);
				bb5.setVisible(false);
				tt4.setVisible(false);

				tf5.setVisible(false);
				bb7.setVisible(false);
				tt2.setVisible(false);

				tf6.setVisible(false);
				bb9.setVisible(false);
				tt3.setVisible(false);
			}
		});
		b3.setFont(new Font("Times New Roman", Font.BOLD, 16));
		
		JButton b4 = new JButton("SEARCH");
		b4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				textArea2.setVisible(false);
				textArea1.setText("");
				textArea1.setVisible(true);
				b8.setVisible(false);

				tf1.setVisible(false);
				bb1.setVisible(false);
				t7.setVisible(false);

				tf2.setVisible(false);
				tf3.setVisible(false);
				bb3.setVisible(false);
				t8.setVisible(false);
				t9.setVisible(false);

				tf4.setVisible(true);
				bb5.setVisible(true);
				tt4.setVisible(true);

				tf5.setVisible(false);
				bb7.setVisible(false);
				tt2.setVisible(false);

				tf6.setVisible(false);
				bb9.setVisible(false);
				tt3.setVisible(false);
			}
		});
		b4.setFont(new Font("Times New Roman", Font.BOLD, 16));
		
		JButton b5 = new JButton("SEARCH");
		b5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				textArea2.setVisible(false);
				textArea1.setText("");
				textArea1.setVisible(true);
				b8.setVisible(false);

				tf1.setVisible(false);
				bb1.setVisible(false);
				t7.setVisible(false);

				tf2.setVisible(false);
				tf3.setVisible(false);
				bb3.setVisible(false);
				t8.setVisible(false);
				t9.setVisible(false);

				tf4.setVisible(false);
				bb5.setVisible(false);
				tt4.setVisible(false);

				tf5.setVisible(true);
				bb7.setVisible(true);
				tt2.setVisible(true);

				tf6.setVisible(false);
				bb9.setVisible(false);
				tt3.setVisible(false);
			}
		});
		b5.setFont(new Font("Times New Roman", Font.BOLD, 16));
		
	
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(30)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								
								.addComponent(t2, GroupLayout.DEFAULT_SIZE, 384, Short.MAX_VALUE)
								.addComponent(t3, GroupLayout.PREFERRED_SIZE, 341, GroupLayout.PREFERRED_SIZE)
								.addComponent(t4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(t5, GroupLayout.PREFERRED_SIZE, 366, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(144)
							.addComponent(b2, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(147)
							.addComponent(b3, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(143))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(147)
							.addComponent(b4, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(146)
							.addComponent(b5, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(146)))
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(20)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(t2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(b2, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(t3, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(b3, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(t4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(b4, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
					.addGap(11)
					.addComponent(t5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(b5, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGap(82))
		);
		panel.setLayout(gl_panel);
	}
}
