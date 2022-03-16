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


public class afisare2 {
	
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
	private JTextField tf4;

	/**
	 * Launch the application.
	 */
	public static void newScreen2() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					afisare2 window = new afisare2();
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
	public afisare2() {
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
		
		//FIELD
		tf1 = new JTextField();
		tf1.setBounds(162, 11, 113, 20);
		panel_1.add(tf1);
		tf1.setForeground(Color.BLACK);
		tf1.setBackground(Color.WHITE);
		tf1.setColumns(10);
		tf1.setVisible(false);
		
		tf2 = new JTextField();
		tf2.setBounds(150, 11, 105, 20);
		panel_1.add(tf2);
		tf2.setForeground(Color.BLACK);
		tf2.setBackground(Color.WHITE);
		tf2.setColumns(10);
		tf2.setVisible(false);
		
		tf4 = new JTextField();
		tf4.setBounds(145, 11, 105, 20);
		panel_1.add(tf4);
		tf4.setForeground(Color.BLACK);
		tf4.setBackground(Color.WHITE);
		tf4.setColumns(10);
		tf4.setVisible(false);
		
		//BUTOANE
		JButton b7 = new JButton("EXECUTA");
		b7.setBounds(39, 44, 113, 27);
		panel_1.add(b7);
		b7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea1.setVisible(true);
				textArea1.setText("");
				String salvare ="SELECT Nume,Prenume,Titulatura,Materia from [Gestiune_Licenta].[dbo].[Legatura_Profesori_Facultati] A inner join [Gestiune_Licenta].[dbo].[Profesori] B on A.ID_Profesor=B.ID_Profesor group by Nume,Prenume,Titulatura,Materia having count(*)>1";
				textArea1.append("\n    Prin metoda simpla:\n");
				textArea1.append("\n    Acestia sunt profesorii care predau la mai mult de o facultate:\n");
				textArea1.append("    Nume\tPrenume\tTitulatura\tMaterie\n");
				System.out.println(salvare);
				textArea1.append(conectare_informatii(salvare,4));
				  
			}
		});
		b7.setFont(new Font("Times New Roman", Font.BOLD, 16));
		b7.setVisible(false);
		


		JButton b9 = new JButton("EXECUTA");
		b9.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			textArea1.setVisible(true);
			textArea1.setText("");
			String salvare ="SELECT Nume,Prenume,CNP from [Gestiune_Licenta].[dbo].[Studenti] A inner join [Gestiune_Licenta].[dbo].[Proiect_Licenta] B on A.ID_Proiect=B.ID_Proiect where Data_Prezentare>'2022-04-13'";
			textArea1.append("\n    Prin metoda simpla:\n");
			textArea1.append("\n    Studentii care sustin licenta dupa data 2022-04-13:\n");
			textArea1.append("    Nume\tPrenume\tCNP\n");
			System.out.println(salvare);
			textArea1.append(conectare_informatii(salvare,3));
			  
		}
	});
		b9.setFont(new Font("Times New Roman", Font.BOLD, 16));
		b9.setBounds(39, 44, 113, 27);
		panel_1.add(b9);
		b9.setVisible(false);
		
		

		JButton bb2 = new JButton("EXECUTA");
		bb2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			    textArea1.setVisible(true);
				textArea1.setText("");
				String nume = tf1.getText();
				String salvare ="SELECT distinct A.Nume,A.Prenume,A.CNP from [Gestiune_Licenta].[dbo].[Studenti] A inner join [Gestiune_Licenta].[dbo].[Profesori] B on A.ID_Profesor_Coordonator=B.ID_Profesor inner join [Gestiune_Licenta].[dbo].[Legatura_Profesori_Facultati] C on C.ID_Profesor=B.ID_Profesor inner join [Gestiune_Licenta].[dbo].[Facultati] D on D.ID_Facultate=C.ID_Facultate where D.Nume_Facultate='"+nume+"'";
				textArea1.append("\n    Prin metoda simpla:\n");
				textArea1.append("\n    Acestia sunt studentii care au profesori coordonatori de la \n facultatea "+nume+":\n");
				textArea1.append("    Nume\tPrenume\tCNP\n");
				System.out.println(salvare);
				textArea1.append(conectare_informatii(salvare,3));
			}
		});
		bb2.setFont(new Font("Times New Roman", Font.BOLD, 16));
		bb2.setBounds(39, 44, 113, 27);
		panel_1.add(bb2);
		bb2.setVisible(false);
		
	
		
		JButton bb4 = new JButton("EXECUTA");
		bb4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea1.setVisible(true);
				textArea1.setText("");
				String tema = tf2.getText();
				String salvare ="SELECT A.Nume,A.Prenume,A.Titulatura,A.Materia from [Gestiune_Licenta].[dbo].[Profesori] A inner join [Gestiune_Licenta].[dbo].[Studenti] B on B.ID_Profesor_Coordonator =A.ID_Profesor inner join [Gestiune_Licenta].[dbo].[Proiect_Licenta] C on C.ID_Proiect=B.ID_Proiect where Tema_Proiect!='"+tema+"'";
				textArea1.append("\n    Prin metoda simpla:\n");
				textArea1.append("\n    Acestia sunt profesorii care coordoneaza studenti ce vor \nprezenta proiecte de licenta cu o tema diferita fata de tema\n "+tema+":\n");
				textArea1.append("    Nume\tPrenume\tTitulatura\tMaterie\n");
				System.out.println(salvare);
				textArea1.append(conectare_informatii(salvare,4));
				  
			}
		});
		bb4.setFont(new Font("Times New Roman", Font.BOLD, 16));
		bb4.setBounds(39, 44, 113, 27);
		panel_1.add(bb4);
		bb4.setVisible(false);
		
		
		JButton bb6 = new JButton("EXECUTA");
		bb6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea1.setVisible(true);
				textArea1.setText("");
				String salvare ="SELECT Nume,Prenume,Titulatura,Materia from [Gestiune_Licenta].[dbo].[Profesori] A inner join [Gestiune_Licenta].[dbo].[Comisie] B on A.Nr_Comisie=B.Nr_Comisie where B.Nr_Profesori>2 order by B.Nr_profesori";
				textArea1.append("\n    Prin metoda simpla:\n");
				textArea1.append("\n    Acestia sunt profesorii care fac parte din comisii cu \n Nr_Profesori > 2 si ordonati dupa numarul profesorilor:\n");
				textArea1.append("    Nume\tPrenume\tCNP\n");
				System.out.println(salvare);
				textArea1.append(conectare_informatii(salvare,3));
				  
			}
		});
		bb6.setFont(new Font("Times New Roman", Font.BOLD, 16));
		bb6.setBounds(39, 44, 113, 27);
		panel_1.add(bb6);
		bb6.setVisible(false);
		
		
		JButton bb8 = new JButton("EXECUTA");
		bb8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea1.setVisible(true);
				textArea1.setText("");
				String sala = tf4.getText();
				String salvare ="SELECT Nume,Prenume,Titulatura,Materia from [Gestiune_Licenta].[dbo].[Profesori] A inner join [Gestiune_Licenta].[dbo].[Comisie] B on A.Nr_Comisie=B.Nr_Comisie where Sala_Prezentare='"+sala+"' order by Nume";
				textArea1.append("\n    Prin metoda simpla:\n");
				String nr_comisie="Select Nr_Comisie from [Gestiune_Licenta].[dbo].[Comisie] where Sala_Prezentare='"+sala+"'";
				String comisie=conectare_informatii2(nr_comisie,1);
				textArea1.append("\n    Acestia sunt profesorii in ordine alfabetica care apartin \n comisiei"+comisie+":\n");
				textArea1.append("    Nume\tPrenume\tTitulatura\tMaterie\n");
				System.out.println(salvare);
				textArea1.append(conectare_informatii(salvare,4));
				  
			}
		});
		bb8.setFont(new Font("Times New Roman", Font.BOLD, 16));
		bb8.setBounds(39, 44, 113, 27);
		panel_1.add(bb8);
		bb8.setVisible(false);
		
		
		
		//AREAS
	
		JTextArea t8 = new JTextArea();
		t8.setBounds(42, 11, 110, 21);
		panel_1.add(t8);
		t8.setText("Nume_Facultate:");
		t8.setForeground(Color.WHITE);
		t8.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		t8.setBackground(new Color(107, 5, 4));
		t8.setVisible(false);
		
		JTextArea tt4 = new JTextArea();
		tt4.setBounds(41, 11, 86, 21);
		panel_1.add(tt4);
		tt4.setText("Tema_Proiect:");
		tt4.setForeground(Color.WHITE);
		tt4.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		tt4.setBackground(new Color(107, 5, 4));
		tt4.setVisible(false);
		
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
		
		JButton b1 = new JButton("SEARCH");
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				

				textArea1.setText("");
				textArea1.setVisible(true);
				b7.setVisible(true);


				b9.setVisible(false);


				bb2.setVisible(false);
				tf1.setVisible(false);
				t8.setVisible(false);


				bb4.setVisible(false);
				tf2.setVisible(false);
				tt4.setVisible(false);


				bb6.setVisible(false);


				bb8.setVisible(false);
				tf4.setVisible(false);
				tt3.setVisible(false);
			}
		});
		b1.setFont(new Font("Times New Roman", Font.BOLD, 16));
		
		JTextArea t1 = new JTextArea();
		t1.setWrapStyleWord(true);
		t1.setText("Aflati toti profesorii care predau la mai mult de o facultate.");
		t1.setForeground(Color.WHITE);
		t1.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		t1.setEditable(false);
		t1.setBackground(new Color (107, 5, 4));
		
		JTextArea t2 = new JTextArea();
		t2.setWrapStyleWord(true);
		t2.setText("Aflati toti studentii care sustin licenta dupa data 2022-04-13.");
		t2.setForeground(Color.WHITE);
		t2.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		t2.setEditable(false);
		t2.setBackground(new Color(107, 5, 4));
		
		JTextArea t3 = new JTextArea();
		t3.setWrapStyleWord(true);
		t3.setText("Aflati toti studentii care au profesori coordonatori de la o\n anumita facultate.");
		t3.setForeground(Color.WHITE);
		t3.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		t3.setEditable(false);
		t3.setBackground(new Color(107, 5, 4));
		
		JTextArea t4 = new JTextArea();
		t4.setWrapStyleWord(true);
		t4.setText("Aflati toti profesorii care coordoneaza studenti ce vor prezenta\r\nproiecte de licenta care alta tema decat cea data.");
		t4.setForeground(Color.WHITE);
		t4.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		t4.setEditable(false);
		t4.setBackground(new Color(107, 5, 4));
		
		JTextArea t5 = new JTextArea();
		t5.setWrapStyleWord(true);
		t5.setText("Aflati toti profesorii care fac parte din comisii cu Nr_Profesori >2\r\n si ordonati-i dupa acesta. \r\n");
		t5.setForeground(Color.WHITE);
		t5.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		t5.setEditable(false);
		t5.setBackground(new Color(107, 5, 4));
		
		JTextArea t6 = new JTextArea();
		t6.setWrapStyleWord(true);
		t6.setText("Aflati toti profesorii in ordine alfabetica care apartin unei anumite\r\n comisii. ");
		t6.setForeground(Color.WHITE);
		t6.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		t6.setEditable(false);
		t6.setBackground(new Color(107, 5, 4));
		
		JButton b2 = new JButton("SEARCH");
		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				textArea1.setText("");
				textArea1.setVisible(true);
				b7.setVisible(false);


				b9.setVisible(true);


				bb2.setVisible(false);
				tf1.setVisible(false);
				t8.setVisible(false);


				bb4.setVisible(false);
				tf2.setVisible(false);
				tt4.setVisible(false);


				bb6.setVisible(false);


				bb8.setVisible(false);
				tf4.setVisible(false);
				tt3.setVisible(false);
			}
		});
		b2.setFont(new Font("Times New Roman", Font.BOLD, 16));
		
		JButton b3 = new JButton("SEARCH");
		b3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
	
				textArea1.setText("");
				textArea1.setVisible(true);
				b7.setVisible(false);


				b9.setVisible(false);


				bb2.setVisible(true);
				tf1.setVisible(true);
				t8.setVisible(true);


				bb4.setVisible(false);
				tf2.setVisible(false);
				tt4.setVisible(false);


				bb6.setVisible(false);


				bb8.setVisible(false);
				tf4.setVisible(false);
				tt3.setVisible(false);
			}
		});
		b3.setFont(new Font("Times New Roman", Font.BOLD, 16));
		
		JButton b4 = new JButton("SEARCH");
		b4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				textArea1.setText("");
				textArea1.setVisible(true);
				b7.setVisible(false);


				b9.setVisible(false);


				bb2.setVisible(false);
				tf1.setVisible(false);
				t8.setVisible(false);


				bb4.setVisible(true);
				tf2.setVisible(true);
				tt4.setVisible(true);


				bb6.setVisible(false);


				bb8.setVisible(false);
				tf4.setVisible(false);
				tt3.setVisible(false);
			}
		});
		b4.setFont(new Font("Times New Roman", Font.BOLD, 16));
		
		JButton b5 = new JButton("SEARCH");
		b5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			
				textArea1.setText("");
				textArea1.setVisible(true);
				b7.setVisible(false);


				b9.setVisible(false);


				bb2.setVisible(false);
				tf1.setVisible(false);
				t8.setVisible(false);


				bb4.setVisible(false);
				tf2.setVisible(false);
				tt4.setVisible(false);


				bb6.setVisible(true);


				bb8.setVisible(false);
				tf4.setVisible(false);
				tt3.setVisible(false);
			}
		});
		b5.setFont(new Font("Times New Roman", Font.BOLD, 16));
		
		JButton b6 = new JButton("SEARCH");
		b6.setFont(new Font("Times New Roman", Font.BOLD, 16));
		b6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			
				textArea1.setText("");
				b7.setVisible(false);


				b9.setVisible(false);


				bb2.setVisible(false);
				tf1.setVisible(false);
				t8.setVisible(false);


				bb4.setVisible(false);
				tf2.setVisible(false);
				tt4.setVisible(false);


				bb6.setVisible(false);


				bb8.setVisible(true);
				tf4.setVisible(true);
				tt3.setVisible(true);
			}
		});
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(30)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(t1, GroupLayout.PREFERRED_SIZE, 335, GroupLayout.PREFERRED_SIZE)
								.addComponent(t2, GroupLayout.DEFAULT_SIZE, 598, Short.MAX_VALUE)
								.addComponent(t4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(t3, GroupLayout.PREFERRED_SIZE, 598, Short.MAX_VALUE)))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(144)
							.addComponent(b2, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(147)
							.addComponent(b3, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(143)
							.addComponent(b1, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(147)
							.addComponent(b4, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(145)
							.addComponent(b5, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(22)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(t6, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(t5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(146)
							.addComponent(b6, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(20)
					.addComponent(t1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(b1, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(t2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(b2, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(t3, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(b3, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(t4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(b4, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(t5, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
					.addGap(4)
					.addComponent(b5, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
					.addGap(13)
					.addComponent(t6, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(b6, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
					.addGap(60))
		);
		panel.setLayout(gl_panel);
	}
}
