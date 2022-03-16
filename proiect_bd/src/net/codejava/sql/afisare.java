package net.codejava.sql;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextArea;

import java.awt.Color;
import javax.swing.JMenu;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JMenuBar;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


import javax.swing.JTextField;
import javax.swing.JTextPane;

public class afisare {
 int display = 0;   
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
				
			actionare = actionare+result.getString(i)+"\t";
			
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
	
	public void conectare_informatii2(String executa)
    {
    	
    	String URL;
    	String Username;
    	String Password;
    	Username="sa";
    	Password="12345";
    	URL="jdbc:sqlserver://DESKTOP-8LL24UK\\SQLEXPRESS;databaseName=Gestiune_Licenta";
      
    	
        try {
		Connection connection=DriverManager.getConnection(URL,Username,Password);
		Statement statement = connection.createStatement();
		int result= statement.executeUpdate(executa); 
		if(result > 0)
			System.out.println("S-a executat stergerea/adaugarea/update.ul!");
		else
			System.out.println("Nu se poate executa stergerea/adaugarea/update.ul, fie nu exista obiectul, fie exista dependente legate de acesta!");
		}
			catch (SQLException e)
			{
				System.out.println("eroare");
				e.printStackTrace();
			}
        
       }

	private JFrame frame;
	private JTextField tf1;
	

	/**
	 * Launch the application.
	 */
	public static void newScreen() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					afisare window = new afisare();
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
	public afisare() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setForeground(Color.WHITE);
		frame.getContentPane().setBackground(Color.BLACK);
		frame.setBounds(100, 100, 819, 496);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		//PT STERGERE COMISIE
		tf1 = new JTextField();
		tf1.setBounds(172, 134, 102, 20);
		tf1.setForeground(Color.BLACK);
		tf1.setBackground(Color.WHITE);
		frame.getContentPane().add(tf1);
		tf1.setColumns(10);
		tf1.setVisible(false);
		
		JButton b1 = new JButton("STERGERE");
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String comisie = tf1.getText();
				System.out.println(comisie);
				String salvare ="DELETE FROM [Gestiune_Licenta].[dbo].[Comisie] WHERE Nr_Comisie="+comisie+";";
				System.out.println(salvare);
				conectare_informatii2(salvare);
			}
		});
		b1.setBackground(Color.WHITE);
		b1.setFont(new Font("Times New Roman", Font.BOLD, 13));
		b1.setBounds(74, 223, 104, 23);
		frame.getContentPane().add(b1);
		b1.setVisible(false);
		
		JTextPane t1 = new JTextPane();
		t1.setEditable(false);
		t1.setFont(new Font("Times New Roman", Font.BOLD, 16));
		t1.setText("Stergeti comisia cu numarul:");
		t1.setBounds(74, 96, 200, 20);
		frame.getContentPane().add(t1);
		t1.setVisible(false);
		
		JTextPane t2 = new JTextPane();
		t2.setFont(new Font("Times New Roman", Font.BOLD, 13));
		t2.setEditable(false);
		t2.setText("Nr_Comisie");
		t2.setBounds(74, 134, 75, 20);
		frame.getContentPane().add(t2);
		t2.setVisible(false);
		
		JTextArea textArea_1 = new JTextArea();
		textArea_1.setBounds(43, 49, 718, 322);
		textArea_1.setForeground(Color.WHITE);
		textArea_1.setBackground(new Color (107, 5, 4));
		frame.getContentPane().add(textArea_1);
		
		//PT STERGERE PROIECT_LICENTA
		
		JTextField tf2 = new JTextField();
		tf2.setBounds(172, 134, 177, 20);
		tf2.setForeground(Color.BLACK);
		tf2.setBackground(Color.WHITE);
		frame.getContentPane().add(tf2);
		tf2.setColumns(10);
		tf2.setVisible(false);
		
		JButton b2 = new JButton("STERGERE");
		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String proiect = tf2.getText();
				System.out.println(proiect);
				String salvare ="DELETE FROM [Gestiune_Licenta].[dbo].[Proiect_Licenta] WHERE Titlul_Proiect='"+proiect+"'";
				System.out.println(salvare);
				conectare_informatii2(salvare);
			}
		});
		b2.setBackground(Color.WHITE);
		b2.setFont(new Font("Times New Roman", Font.BOLD, 13));
		b2.setBounds(74, 223, 104, 23);
		frame.getContentPane().add(b2);
		b2.setVisible(false);
		
		JTextPane t3 = new JTextPane();
		t3.setEditable(false);
		t3.setFont(new Font("Times New Roman", Font.BOLD, 16));
		t3.setText("Stergeti proiectul de licenta cu titlul:");
		t3.setBounds(74, 96, 275, 20);
		frame.getContentPane().add(t3);
		t3.setVisible(false);
		
		JTextPane t4 = new JTextPane();
		t4.setFont(new Font("Times New Roman", Font.BOLD, 13));
		t4.setEditable(false);
		t4.setText("Titlu_Proiect");
		t4.setBounds(74, 134, 88, 20);
		frame.getContentPane().add(t4);
		t4.setVisible(false);
		
		//PT STERGERE STUDENTI
		
		JTextField tf3 = new JTextField();
		tf3.setBounds(148, 134, 126, 20);
		tf3.setForeground(Color.BLACK);
		tf3.setBackground(Color.WHITE);
		frame.getContentPane().add(tf3);
		tf3.setColumns(10);
		tf3.setVisible(false);
		
		JButton b3 = new JButton("STERGERE");
		b3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String cnp = tf3.getText();
				System.out.println(cnp);
				String salvare ="DELETE FROM [Gestiune_Licenta].[dbo].[Studenti] WHERE CNP='"+cnp+"'";
				System.out.println(salvare);
				conectare_informatii2(salvare);
			}
		});
		b3.setBackground(Color.WHITE);
		b3.setFont(new Font("Times New Roman", Font.BOLD, 13));
		b3.setBounds(74, 223, 104, 23);
		frame.getContentPane().add(b3);
		b3.setVisible(false);
		
		JTextPane t5 = new JTextPane();
		t5.setEditable(false);
		t5.setFont(new Font("Times New Roman", Font.BOLD, 16));
		t5.setText("Stergeti studentul cu CNP-ul:");
		t5.setBounds(74, 96, 212, 20);
		frame.getContentPane().add(t5);
		t5.setVisible(false);
		
		JTextPane t6 = new JTextPane();
		t6.setFont(new Font("Times New Roman", Font.BOLD, 13));
		t6.setEditable(false);
		t6.setText("CNP");
		t6.setBounds(74, 134, 47, 20);
		frame.getContentPane().add(t6);
		t6.setVisible(false);
		
		//PT ADAUGARE COMISIE
		JTextField tf4 = new JTextField();
		tf4.setBounds(185, 134, 75, 20);
		tf4.setForeground(Color.BLACK);
		tf4.setBackground(Color.WHITE);
		frame.getContentPane().add(tf4);
		tf4.setColumns(10);
		tf4.setVisible(false);
		
		JTextField tf5 = new JTextField();
		tf5.setBounds(185, 169, 75, 20);
		tf5.setForeground(Color.BLACK);
		tf5.setBackground(Color.WHITE);
		frame.getContentPane().add(tf5);
		tf5.setColumns(10);
		tf5.setVisible(false);
		
		JTextField tf6 = new JTextField();
		tf6.setBounds(185, 204, 75, 20);
		tf6.setForeground(Color.BLACK);
		tf6.setBackground(Color.WHITE);
		frame.getContentPane().add(tf6);
		tf6.setColumns(10);
		tf6.setVisible(false);
		
		JButton b4 = new JButton("ADAUGARE");
		b4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String nr_comisie = tf4.getText();
				String nr_profesori= tf5.getText();
				String nr_sala = tf6.getText();
				String salvare ="INSERT INTO [Gestiune_Licenta].[dbo].[Comisie] VALUES("+nr_comisie+","+nr_profesori+",'"+nr_sala+"')";
				conectare_informatii2(salvare);
			}
		});
		b4.setBackground(Color.WHITE);
		b4.setFont(new Font("Times New Roman", Font.BOLD, 13));
		b4.setBounds(74, 256, 104, 23);
		frame.getContentPane().add(b4);
		b4.setVisible(false);
		
		JTextPane t7 = new JTextPane();
		t7.setEditable(false);
		t7.setFont(new Font("Times New Roman", Font.BOLD, 16));
		t7.setText("Adaugati comisia:");
		t7.setBounds(74, 96, 151, 20);
		frame.getContentPane().add(t7);
		t7.setVisible(false);
		
		JTextPane t8 = new JTextPane();
		t8.setFont(new Font("Times New Roman", Font.BOLD, 13));
		t8.setEditable(false);
		t8.setText("Nr_Comisie");
		t8.setBounds(74, 134, 88, 20);
		frame.getContentPane().add(t8);
		t8.setVisible(false);
		
		JTextPane t9 = new JTextPane();
		t9.setFont(new Font("Times New Roman", Font.BOLD, 13));
		t9.setEditable(false);
		t9.setText("Nr_Profesori");
		t9.setBounds(74, 169, 88, 20);
		frame.getContentPane().add(t9);
		t9.setVisible(false);
		
		JTextPane t10 = new JTextPane();
		t10.setFont(new Font("Times New Roman", Font.BOLD, 13));
		t10.setEditable(false);
		t10.setText("Sala_Prezentare");
		t10.setBounds(74, 204, 98, 20);
		frame.getContentPane().add(t10);
		t10.setVisible(false);
		
		//PT ADAUGARE PROIECT_LICENTA
		JTextField tf7 = new JTextField();
		tf7.setBounds(185, 134, 185, 20);
		tf7.setForeground(Color.BLACK);
		tf7.setBackground(Color.WHITE);
		frame.getContentPane().add(tf7);
		tf7.setColumns(10);
		tf7.setVisible(false);
		
		JTextField tf8 = new JTextField();
		tf8.setBounds(185, 169, 185, 20);
		tf8.setForeground(Color.BLACK);
		tf8.setBackground(Color.WHITE);
		frame.getContentPane().add(tf8);
		tf8.setColumns(10);
		tf8.setVisible(false);
		
		JTextField tf9 = new JTextField();
		tf9.setBounds(185, 204, 185, 20);
		tf9.setForeground(Color.BLACK);
		tf9.setBackground(Color.WHITE);
		frame.getContentPane().add(tf9);
		tf9.setColumns(10);
		tf9.setVisible(false);
		
		JTextField tf10 = new JTextField();
		tf10.setBounds(185, 239, 185, 20);
		tf10.setForeground(Color.BLACK);
		tf10.setBackground(Color.WHITE);
		frame.getContentPane().add(tf10);
		tf10.setColumns(10);
		tf10.setVisible(false);
		
		JButton b5 = new JButton("ADAUGARE");
		b5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String tema = tf7.getText();
				String titlu = tf8.getText();
				String id = tf9.getText();
				String data = tf10.getText();
				String salvare ="INSERT INTO [Gestiune_Licenta].[dbo].[Proiect_Licenta] VALUES('"+tema+"','"+titlu+"',"+id+",'"+data+"')";
				conectare_informatii2(salvare);
			}
		});
		b5.setBackground(Color.WHITE);
		b5.setFont(new Font("Times New Roman", Font.BOLD, 13));
		b5.setBounds(74, 274, 104, 23);
		frame.getContentPane().add(b5);
		b5.setVisible(false);
		
		JTextPane tt1 = new JTextPane();
		tt1.setEditable(false);
		tt1.setFont(new Font("Times New Roman", Font.BOLD, 16));
		tt1.setText("Adaugati proiectul de licenta:");
		tt1.setBounds(74, 96, 220, 20);
		frame.getContentPane().add(tt1);
		tt1.setVisible(false);
		
		JTextPane tt2 = new JTextPane();
		tt2.setFont(new Font("Times New Roman", Font.BOLD, 13));
		tt2.setEditable(false);
		tt2.setText("Tema_Proiect");
		tt2.setBounds(74, 134, 88, 20);
		frame.getContentPane().add(tt2);
		tt2.setVisible(false);
		
		JTextPane tt3 = new JTextPane();
		tt3.setFont(new Font("Times New Roman", Font.BOLD, 13));
		tt3.setEditable(false);
		tt3.setText("Titlul_Proiect");
		tt3.setBounds(74, 169, 88, 20);
		frame.getContentPane().add(tt3);
		tt3.setVisible(false);
		
		JTextPane tt4 = new JTextPane();
		tt4.setFont(new Font("Times New Roman", Font.BOLD, 13));
		tt4.setEditable(false);
		tt4.setText("ID_Proiect");
		tt4.setBounds(74, 204, 98, 20);
		frame.getContentPane().add(tt4);
		tt4.setVisible(false);
		
		JTextPane tt5 = new JTextPane();
		tt5.setFont(new Font("Times New Roman", Font.BOLD, 13));
		tt5.setEditable(false);
		tt5.setText("Data_Prezentare");
		tt5.setBounds(74, 239, 98, 20);
		frame.getContentPane().add(tt5);
		tt5.setVisible(false);
		
		//PT ADAUGARE STUDENT
		JTextField tff1 = new JTextField();
		tff1.setBounds(190, 134, 180, 20);
		tff1.setForeground(Color.BLACK);
		tff1.setBackground(Color.WHITE);
		frame.getContentPane().add(tff1);
		tff1.setColumns(10);
		tff1.setVisible(false);
		
		JTextField tff2 = new JTextField();
		tff2.setBounds(190, 172, 180, 20);
		tff2.setForeground(Color.BLACK);
		tff2.setBackground(Color.WHITE);
		frame.getContentPane().add(tff2);
		tff2.setColumns(10);
		tff2.setVisible(false);
		
		JTextField tff3 = new JTextField();
		tff3.setBounds(190, 210, 180, 20);
		tff3.setForeground(Color.BLACK);
		tff3.setBackground(Color.WHITE);
		frame.getContentPane().add(tff3);
		tff3.setColumns(10);
		tff3.setVisible(false);
		
		JTextField tff4 = new JTextField();
		tff4.setBounds(190, 248, 180, 20);
		tff4.setForeground(Color.BLACK);
		tff4.setBackground(Color.WHITE);
		frame.getContentPane().add(tff4);
		tff4.setColumns(10);
		tff4.setVisible(false);
		
		JTextField tff5 = new JTextField();
		tff5.setBounds(190, 286, 180, 20);
		tff5.setForeground(Color.BLACK);
		tff5.setBackground(Color.WHITE);
		frame.getContentPane().add(tff5);
		tff5.setColumns(10);
		tff5.setVisible(false);
		
		JButton b6 = new JButton("ADAUGARE");
		b6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String nume = tff1.getText();
				String prenume= tff2.getText();
				String cnp = tff3.getText();
				String titlu = tff4.getText();
				String nume_prof = tff5.getText();
				String salvare ="INSERT INTO [Gestiune_Licenta].[dbo].[Studenti] VALUES('"+nume+"','"+prenume+"','"+cnp+"',(SELECT ID_Proiect FROM [Gestiune_Licenta].[dbo].[Proiect_Licenta] WHERE Titlul_Proiect='"+titlu+"'),(SELECT ID_Profesor FROM [Gestiune_Licenta].[dbo].[Profesori] WHERE Nume='"+nume_prof+"'))";
				System.out.println(salvare);
				conectare_informatii2(salvare);
			}
		});
		b6.setBackground(Color.WHITE);
		b6.setFont(new Font("Times New Roman", Font.BOLD, 13));
		b6.setBounds(74, 324, 104, 23);
		frame.getContentPane().add(b6);
		b6.setVisible(false);
		
		JTextPane tt6 = new JTextPane();
		tt6.setEditable(false);
		tt6.setFont(new Font("Times New Roman", Font.BOLD, 16));
		tt6.setText("Adaugati student:");
		tt6.setBounds(74, 96, 296, 20);
		frame.getContentPane().add(tt6);
		tt6.setVisible(false);
		
		JTextPane tt7 = new JTextPane();
		tt7.setFont(new Font("Times New Roman", Font.BOLD, 13));
		tt7.setEditable(false);
		tt7.setText("Nume");
		tt7.setBounds(74, 134, 88, 20);
		frame.getContentPane().add(tt7);
		tt7.setVisible(false);
		
		JTextPane tt8 = new JTextPane();
		tt8.setFont(new Font("Times New Roman", Font.BOLD, 13));
		tt8.setEditable(false);
		tt8.setText("Prenume");
		tt8.setBounds(74, 172, 88, 20);
		frame.getContentPane().add(tt8);
		tt8.setVisible(false);
		
		JTextPane tt9 = new JTextPane();
		tt9.setFont(new Font("Times New Roman", Font.BOLD, 13));
		tt9.setEditable(false);
		tt9.setText("CNP");
		tt9.setBounds(74, 210, 88, 20);
		frame.getContentPane().add(tt9);
		tt9.setVisible(false);
		
		JTextPane ttt1 = new JTextPane();
		ttt1.setFont(new Font("Times New Roman", Font.BOLD, 13));
		ttt1.setEditable(false);
		ttt1.setText("Titlul_Proiect");
		ttt1.setBounds(74, 248, 88, 20);
		frame.getContentPane().add(ttt1);
		ttt1.setVisible(false);
		
		JTextPane ttt2 = new JTextPane();
		ttt2.setFont(new Font("Times New Roman", Font.BOLD, 13));
		ttt2.setEditable(false);
		ttt2.setText("Nume_PrfCrd");
		ttt2.setBounds(74, 286, 88, 20);
		frame.getContentPane().add(ttt2);
		ttt2.setVisible(false);
		
		//PT UPDATE COMISIE
		
		JTextField tff6 = new JTextField();
		tff6.setBounds(509, 96, 100, 20);
		tff6.setForeground(Color.BLACK);
		tff6.setBackground(Color.WHITE);
		frame.getContentPane().add(tff6);
		tff6.setColumns(10);
		tff6.setVisible(false);
		
		JTextField tff7 = new JTextField();
		tff7.setBounds(185, 134, 88, 20);
		tff7.setForeground(Color.BLACK);
		tff7.setBackground(Color.WHITE);
		frame.getContentPane().add(tff7);
		tff7.setColumns(10);
		tff7.setVisible(false);
		
		JButton b7 = new JButton("UPDATE NR_PRF");
		b7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String nr_sala = tff6.getText();
				String nr_profesori = tff7.getText();
				String salvare ="UPDATE [Gestiune_Licenta].[dbo].[Comisie] SET Nr_Profesori="+nr_profesori+" WHERE Sala_Prezentare='"+nr_sala+"'";
				System.out.println(salvare);
				conectare_informatii2(salvare);
			}
		});
		b7.setBackground(Color.WHITE);
		b7.setFont(new Font("Times New Roman", Font.BOLD, 13));
		b7.setBounds(293, 134, 142, 23);
		frame.getContentPane().add(b7);
		b7.setVisible(false);
		
		JTextPane ttt3 = new JTextPane();
		ttt3.setEditable(false);
		ttt3.setFont(new Font("Times New Roman", Font.BOLD, 16));
		ttt3.setText("Update comisiei cu sala de prezentare unica:");
		ttt3.setBounds(74, 96, 312, 20);
		frame.getContentPane().add(ttt3);
		ttt3.setVisible(false);
		
		JTextPane ttt4 = new JTextPane();
		ttt4.setFont(new Font("Times New Roman", Font.BOLD, 13));
		ttt4.setEditable(false);
		ttt4.setText("Sala_Prezentare");
		ttt4.setBounds(396, 96, 103, 20);
		frame.getContentPane().add(ttt4);
		ttt4.setVisible(false);
		
		JTextPane ttt5 = new JTextPane();
		ttt5.setFont(new Font("Times New Roman", Font.BOLD, 13));
		ttt5.setEditable(false);
		ttt5.setText("Nr_Profesori");
		ttt5.setBounds(74, 134, 98, 20);
		frame.getContentPane().add(ttt5);
		ttt5.setVisible(false);
			
		
		//PT UPDATE PROIECT_LICENTA
		
		JTextField tff8 = new JTextField();
		tff8.setBounds(478, 96, 269, 20);
		tff8.setForeground(Color.BLACK);
		tff8.setBackground(Color.WHITE);
		frame.getContentPane().add(tff8);
		tff8.setColumns(10);
		tff8.setVisible(false);
		
		JTextField tff9 = new JTextField();
		tff9.setBounds(185, 134, 177, 20);
		tff9.setForeground(Color.BLACK);
		tff9.setBackground(Color.WHITE);
		frame.getContentPane().add(tff9);
		tff9.setColumns(10);
		tff9.setVisible(false);
		
		JTextField tfff1 = new JTextField();
		tfff1.setBounds(185, 169, 177, 20);
		tfff1.setForeground(Color.BLACK);
		tfff1.setBackground(Color.WHITE);
		frame.getContentPane().add(tfff1);
		tfff1.setColumns(10);
		tfff1.setVisible(false);
		
		
		JButton b8 = new JButton("UPDATE TEMA");
		b8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String titlu = tff8.getText();
				String tema= tff9.getText();
				String salvare = "UPDATE [Gestiune_Licenta].[dbo].[Proiect_Licenta] SET Tema_Proiect='"+tema+"' WHERE Titlul_Proiect='"+titlu+"'";
				System.out.println(salvare);
				conectare_informatii2(salvare);
			}
		});
		b8.setBackground(Color.WHITE);
		b8.setFont(new Font("Times New Roman", Font.BOLD, 13));
		b8.setBounds(380, 134, 126, 23);
		frame.getContentPane().add(b8);
		b8.setVisible(false);
		
		JButton b9 = new JButton("UPDATE DATA");
		b9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String titlu = tff8.getText();
				String data = tfff1.getText();
				String salvare = "UPDATE [Gestiune_Licenta].[dbo].[Proiect_Licenta] SET Data_Prezentare='"+data+"' WHERE Titlul_Proiect='"+titlu+"'";
				System.out.println(salvare);
				conectare_informatii2(salvare);
			}
		});
		b9.setBackground(Color.WHITE);
		b9.setFont(new Font("Times New Roman", Font.BOLD, 13));
		b9.setBounds(380, 169, 126, 23);
		frame.getContentPane().add(b9);
		b9.setVisible(false);
		
		JTextPane ttt7 = new JTextPane();
		ttt7.setEditable(false);
		ttt7.setFont(new Font("Times New Roman", Font.BOLD, 16));
		ttt7.setText("Update proiectului de licenta cu titlul unic:");
		ttt7.setBounds(74, 96, 296, 20);
		frame.getContentPane().add(ttt7);
		ttt7.setVisible(false);
		
		JTextPane ttt8 = new JTextPane();
		ttt8.setFont(new Font("Times New Roman", Font.BOLD, 13));
		ttt8.setEditable(false);
		ttt8.setText("Titlul_Proiect");
		ttt8.setBounds(380, 96, 88, 20);
		frame.getContentPane().add(ttt8);
		ttt8.setVisible(false);
		
		JTextPane ttt9 = new JTextPane();
		ttt9.setFont(new Font("Times New Roman", Font.BOLD, 13));
		ttt9.setEditable(false);
		ttt9.setText("Tema_Proiect");
		ttt9.setBounds(74, 134, 88, 20);
		frame.getContentPane().add(ttt9);
		ttt9.setVisible(false);
		
		JTextPane tttt1 = new JTextPane();
		tttt1.setFont(new Font("Times New Roman", Font.BOLD, 13));
		tttt1.setEditable(false);
		tttt1.setText("Data_Prezentare");
		tttt1.setBounds(74, 169, 98, 20);
		frame.getContentPane().add(tttt1);
		tttt1.setVisible(false);
		
		
		//PT UPDATE STUDENT
		
		JTextField tfff2 = new JTextField();
		tfff2.setBounds(395, 96, 142, 20);
		tfff2.setForeground(Color.BLACK);
		tfff2.setBackground(Color.WHITE);
		frame.getContentPane().add(tfff2);
		tfff2.setColumns(10);
		tfff2.setVisible(false);
		
		JTextField tfff3 = new JTextField();
		tfff3.setBounds(185, 134, 143, 20);
		tfff3.setForeground(Color.BLACK);
		tfff3.setBackground(Color.WHITE);
		frame.getContentPane().add(tfff3);
		tfff3.setColumns(10);
		tfff3.setVisible(false);
		
		JTextField tfff4 = new JTextField();
		tfff4.setBounds(185, 172, 143, 20);
		tfff4.setForeground(Color.BLACK);
		tfff4.setBackground(Color.WHITE);
		frame.getContentPane().add(tfff4);
		tfff4.setColumns(10);
		tfff4.setVisible(false);
		
		JTextField tfff5 = new JTextField();
		tfff5.setBounds(185, 210, 220, 20);
		tfff5.setForeground(Color.BLACK);
		tfff5.setBackground(Color.WHITE);
		frame.getContentPane().add(tfff5);
		tfff5.setColumns(10);
		tfff5.setVisible(false);
		
		JTextField tfff6 = new JTextField();
		tfff6.setBounds(185, 248, 143, 20);
		tfff6.setForeground(Color.BLACK);
		tfff6.setBackground(Color.WHITE);
		frame.getContentPane().add(tfff6);
		tfff6.setColumns(10);
		tfff6.setVisible(false);
		
		JButton bb1 = new JButton("UPDATE NUME");
		bb1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String cnp = tfff2.getText();
				String nume= tfff3.getText();
				String salvare = "UPDATE [Gestiune_Licenta].[dbo].[Studenti] SET Nume='"+nume+"' WHERE CNP='"+cnp+"'";
				System.out.println(salvare);
				conectare_informatii2(salvare);
			}
		});
		bb1.setBackground(Color.WHITE);
		bb1.setFont(new Font("Times New Roman", Font.BOLD, 13));
		bb1.setBounds(423, 134, 151, 23);
		frame.getContentPane().add(bb1);
		bb1.setVisible(false);
		
		JButton bb2 = new JButton("UPDATE PRENUME");
		bb2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String cnp = tfff2.getText();
				String prenume = tfff4.getText();
				String salvare = "UPDATE [Gestiune_Licenta].[dbo].[Studenti] SET Prenume='"+prenume+"' WHERE CNP='"+cnp+"'";
				System.out.println(salvare);
				conectare_informatii2(salvare);
			}
		});
		bb2.setBackground(Color.WHITE);
		bb2.setFont(new Font("Times New Roman", Font.BOLD, 13));
		bb2.setBounds(423, 172, 151, 23);
		frame.getContentPane().add(bb2);
		bb2.setVisible(false);
		
		JButton bb3 = new JButton("UPDATE PROIECT");
		bb3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String cnp = tfff2.getText();
				String titlu = tfff5.getText();
				String salvare = "UPDATE [Gestiune_Licenta].[dbo].[Studenti] SET ID_Proiect='(SELECT ID_Proiect FROM [Gestiune_Licenta].[dbo].[Proiect_Licenta] WHERE Titlul_Proiect='"+titlu+"')' WHERE CNP='"+cnp+"'";
				System.out.println(salvare);
				conectare_informatii2(salvare);
			}
		});
		bb3.setBackground(Color.WHITE);
		bb3.setFont(new Font("Times New Roman", Font.BOLD, 13));
		bb3.setBounds(423, 210, 151, 23);
		frame.getContentPane().add(bb3);
		bb3.setVisible(false);
		
		JButton bb4 = new JButton("UPDATE PRF_CRD");
		bb4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String cnp = tfff2.getText();
				String nume_prof = tfff6.getText();
				String salvare = "UPDATE [Gestiune_Licenta].[dbo].[Studenti] SET ID_Profesor_Coordonator='(SELECT ID_Profesor FROM [Gestiune_Licenta].[dbo].[Profesori] WHERE Nume='"+nume_prof+"')' WHERE CNP='"+cnp+"'";
				System.out.println(salvare);
				conectare_informatii2(salvare);
			}
		});
		bb4.setBackground(Color.WHITE);
		bb4.setFont(new Font("Times New Roman", Font.BOLD, 13));
		bb4.setBounds(423, 248, 151, 23);
		frame.getContentPane().add(bb4);
		bb4.setVisible(false);
		
		JTextPane tttt2 = new JTextPane();
		tttt2.setFont(new Font("Times New Roman", Font.BOLD, 16));
		tttt2.setEditable(false);
		tttt2.setText("Update studentului cu CNP-ul unic:");
		tttt2.setBounds(74, 96, 254, 20);
		frame.getContentPane().add(tttt2);
		tttt2.setVisible(false);
		
		JTextPane tttt3 = new JTextPane();
		tttt3.setFont(new Font("Times New Roman", Font.BOLD, 13));
		tttt3.setEditable(false);
		tttt3.setText("CNP");
		tttt3.setBounds(339, 96, 47, 20);
		frame.getContentPane().add(tttt3);
		tttt3.setVisible(false);
		
		JTextPane tttt4 = new JTextPane();
		tttt4.setFont(new Font("Times New Roman", Font.BOLD, 13));
		tttt4.setEditable(false);
		tttt4.setText("Nume");
		tttt4.setBounds(74, 134, 98, 20);
		frame.getContentPane().add(tttt4);
		tttt4.setVisible(false);
		
		JTextPane tttt5 = new JTextPane();
		tttt5.setFont(new Font("Times New Roman", Font.BOLD, 13));
		tttt5.setEditable(false);
		tttt5.setText("Prenume");
		tttt5.setBounds(74, 172, 98, 20);
		frame.getContentPane().add(tttt5);
		tttt5.setVisible(false);
		
		JTextPane tttt6 = new JTextPane();
		tttt6.setFont(new Font("Times New Roman", Font.BOLD, 13));
		tttt6.setEditable(false);
		tttt6.setText("Titlul_Proiect");
		tttt6.setBounds(74, 210, 98, 20);
		frame.getContentPane().add(tttt6);
		tttt6.setVisible(false);
		
		JTextPane tttt7 = new JTextPane();
		tttt7.setFont(new Font("Times New Roman", Font.BOLD, 13));
		tttt7.setEditable(false);
		tttt7.setText("Nume_Prf_Crd");
		tttt7.setBounds(74, 248, 98, 20);
		frame.getContentPane().add(tttt7);
		tttt7.setVisible(false);
		
		// MENIU
		JMenuBar menuBar = new JMenuBar();
		menuBar.setForeground(Color.BLACK);
		menuBar.setBackground(Color.BLACK);
		frame.setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("Comisii");
		mnNewMenu.setFont(new Font("Times New Roman", Font.BOLD, 16));
		mnNewMenu.setBackground(Color.BLACK);
		mnNewMenu.setForeground(Color.WHITE);
		menuBar.add(mnNewMenu);
		
		
		JButton button_10 = new JButton("Display");
		button_10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			    
			
				textArea_1.setVisible(true);
				display = display + 1;
				if( display >= 2){
					textArea_1.setText(null);
					display = 0; }
				tf1.setVisible(false);
				b1.setVisible(false);
				t1.setVisible(false);
				t2.setVisible(false);
				tf2.setVisible(false);
				b2.setVisible(false);
				t3.setVisible(false);
				t4.setVisible(false);
				tf3.setVisible(false);
				b3.setVisible(false);
				t5.setVisible(false);
				t6.setVisible(false);
				tf4.setVisible(false);
				tf5.setVisible(false);
				tf6.setVisible(false);
				b4.setVisible(false);
				t7.setVisible(false);
				t8.setVisible(false);
				t9.setVisible(false);
				t10.setVisible(false);
				tf7.setVisible(false);
				tf8.setVisible(false);
				tf9.setVisible(false);
				tf10.setVisible(false);
				b5.setVisible(false);
				tt1.setVisible(false);
				tt2.setVisible(false);
				tt3.setVisible(false);
				tt4.setVisible(false);
				tt5.setVisible(false);
				tff1.setVisible(false);
				tff2.setVisible(false);
				tff3.setVisible(false);
				tff4.setVisible(false);
				tff5.setVisible(false);
				b6.setVisible(false);
				tt6.setVisible(false);
				tt7.setVisible(false);
				tt8.setVisible(false);
				tt9.setVisible(false);
				ttt1.setVisible(false);
				ttt2.setVisible(false);
				tff6.setVisible(false);
				tff7.setVisible(false);
				b7.setVisible(false);
				ttt3.setVisible(false);
				ttt4.setVisible(false);
				ttt5.setVisible(false);
				tff8.setVisible(false);
				tff9.setVisible(false);
				tfff1.setVisible(false);
				b8.setVisible(false);
				b9.setVisible(false);
				ttt7.setVisible(false);
				ttt8.setVisible(false);
				ttt9.setVisible(false);
				tttt1.setVisible(false);
				tfff2.setVisible(false);
				tfff3.setVisible(false);
				tfff4.setVisible(false);
				tfff5.setVisible(false);
				tfff6.setVisible(false);
				bb1.setVisible(false);
				bb2.setVisible(false);
				bb3.setVisible(false);
				bb4.setVisible(false);
				tttt2.setVisible(false);
				tttt3.setVisible(false);
				tttt4.setVisible(false);
				tttt5.setVisible(false);
				tttt6.setVisible(false);
				tttt7.setVisible(false);
				String salvare = conectare_informatii("SELECT Nr_Comisie, Nr_Profesori, Sala_Prezentare from [Gestiune_Licenta].[dbo].[Comisie]",3);
				textArea_1.append("\n    Aveti urmatoarele informatii despre Comisii:\n");
				textArea_1.append("    Nr_Comisie\tNr_Profesori\tSala_Prezentare\n");
				textArea_1.append(salvare);
				
			}
		});
		button_10.setForeground(Color.WHITE);
		button_10.setFont(new Font("Times New Roman", Font.BOLD, 16));
		button_10.setBackground(Color.GRAY);
		mnNewMenu.add(button_10);
		
		JButton btnNewButton_1 = new JButton(" Erase  ");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg1) {
				
				textArea_1.setVisible(false);
				tf1.setVisible(true);
				b1.setVisible(true);
				t1.setVisible(true);
				t2.setVisible(true);
				tf2.setVisible(false);
				b2.setVisible(false);
				t3.setVisible(false);
				t4.setVisible(false);
				tf3.setVisible(false);
				b3.setVisible(false);
				t5.setVisible(false);
				t6.setVisible(false);
				tf4.setVisible(false);
				tf5.setVisible(false);
				tf6.setVisible(false);
				b4.setVisible(false);
				t7.setVisible(false);
				t8.setVisible(false);
				t9.setVisible(false);
				t10.setVisible(false);
				tf7.setVisible(false);
				tf8.setVisible(false);
				tf9.setVisible(false);
				tf10.setVisible(false);
				b5.setVisible(false);
				tt1.setVisible(false);
				tt2.setVisible(false);
				tt3.setVisible(false);
				tt4.setVisible(false);
				tt5.setVisible(false);
				tff1.setVisible(false);
				tff2.setVisible(false);
				tff3.setVisible(false);
				tff4.setVisible(false);
				tff5.setVisible(false);
				b6.setVisible(false);
				tt6.setVisible(false);
				tt7.setVisible(false);
				tt8.setVisible(false);
				tt9.setVisible(false);
				ttt1.setVisible(false);
				ttt2.setVisible(false);
				tff6.setVisible(false);
				tff7.setVisible(false);
				b7.setVisible(false);
				ttt3.setVisible(false);
				ttt4.setVisible(false);
				ttt5.setVisible(false);
				tff8.setVisible(false);
				tff9.setVisible(false);
				tfff1.setVisible(false);
				b8.setVisible(false);
				b9.setVisible(false);
				ttt7.setVisible(false);
				ttt8.setVisible(false);
				ttt9.setVisible(false);
				tttt1.setVisible(false);
				tfff2.setVisible(false);
				tfff3.setVisible(false);
				tfff4.setVisible(false);
				tfff5.setVisible(false);
				tfff6.setVisible(false);
				bb1.setVisible(false);
				bb2.setVisible(false);
				bb3.setVisible(false);
				bb4.setVisible(false);
				tttt2.setVisible(false);
				tttt3.setVisible(false);
				tttt4.setVisible(false);
				tttt5.setVisible(false);
				tttt6.setVisible(false);
				tttt7.setVisible(false);
			}
		});
		btnNewButton_1.setBackground(Color.GRAY);
		btnNewButton_1.setForeground(Color.WHITE);
		btnNewButton_1.setFont(new Font("Times New Roman", Font.BOLD, 16));
		mnNewMenu.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Add      ");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			    
			
				textArea_1.setVisible(false);
				tf1.setVisible(false);
				b1.setVisible(false);
				t1.setVisible(false);
				t2.setVisible(false);
				tf2.setVisible(false);
				b2.setVisible(false);
				t3.setVisible(false);
				t4.setVisible(false);
				tf3.setVisible(false);
				b3.setVisible(false);
				t5.setVisible(false);
				t6.setVisible(false);
				tf4.setVisible(true);
				tf5.setVisible(true);
				tf6.setVisible(true);
				b4.setVisible(true);
				t7.setVisible(true);
				t8.setVisible(true);
				t9.setVisible(true);
				t10.setVisible(true);
				tf7.setVisible(false);
				tf8.setVisible(false);
				tf9.setVisible(false);
				tf10.setVisible(false);
				b5.setVisible(false);
				tt1.setVisible(false);
				tt2.setVisible(false);
				tt3.setVisible(false);
				tt4.setVisible(false);
				tt5.setVisible(false);
				tff1.setVisible(false);
				tff2.setVisible(false);
				tff3.setVisible(false);
				tff4.setVisible(false);
				tff5.setVisible(false);
				b6.setVisible(false);
				tt6.setVisible(false);
				tt7.setVisible(false);
				tt8.setVisible(false);
				tt9.setVisible(false);
				ttt1.setVisible(false);
				ttt2.setVisible(false);
				tff6.setVisible(false);
				tff7.setVisible(false);
				b7.setVisible(false);
				ttt3.setVisible(false);
				ttt4.setVisible(false);
				ttt5.setVisible(false);
				tff8.setVisible(false);
				tff9.setVisible(false);
				tfff1.setVisible(false);
				b8.setVisible(false);
				b9.setVisible(false);
				ttt7.setVisible(false);
				ttt8.setVisible(false);
				ttt9.setVisible(false);
				tttt1.setVisible(false);
				tfff2.setVisible(false);
				tfff3.setVisible(false);
				tfff4.setVisible(false);
				tfff5.setVisible(false);
				tfff6.setVisible(false);
				bb1.setVisible(false);
				bb2.setVisible(false);
				bb3.setVisible(false);
				bb4.setVisible(false);
				tttt2.setVisible(false);
				tttt3.setVisible(false);
				tttt4.setVisible(false);
				tttt5.setVisible(false);
				tttt6.setVisible(false);
				tttt7.setVisible(false);
			}
		});
		btnNewButton_2.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnNewButton_2.setBackground(Color.GRAY);
		btnNewButton_2.setForeground(Color.WHITE);
		mnNewMenu.add(btnNewButton_2);
		
		JButton btnJoin = new JButton("Update");
		btnJoin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			    
			
				textArea_1.setVisible(false);
				tf1.setVisible(false);
				b1.setVisible(false);
				t1.setVisible(false);
				t2.setVisible(false);
				tf2.setVisible(false);
				b2.setVisible(false);
				t3.setVisible(false);
				t4.setVisible(false);
				tf3.setVisible(false);
				b3.setVisible(false);
				t5.setVisible(false);
				t6.setVisible(false);
				tf4.setVisible(false);
				tf5.setVisible(false);
				tf6.setVisible(false);
				b4.setVisible(false);
				t7.setVisible(false);
				t8.setVisible(false);
				t9.setVisible(false);
				t10.setVisible(false);
				tf7.setVisible(false);
				tf8.setVisible(false);
				tf9.setVisible(false);
				tf10.setVisible(false);
				b5.setVisible(false);
				tt1.setVisible(false);
				tt2.setVisible(false);
				tt3.setVisible(false);
				tt4.setVisible(false);
				tt5.setVisible(false);
				tff1.setVisible(false);
				tff2.setVisible(false);
				tff3.setVisible(false);
				tff4.setVisible(false);
				tff5.setVisible(false);
				b6.setVisible(false);
				tt6.setVisible(false);
				tt7.setVisible(false);
				tt8.setVisible(false);
				tt9.setVisible(false);
				ttt1.setVisible(false);
				ttt2.setVisible(false);
				tff6.setVisible(true);
				tff7.setVisible(true);
				b7.setVisible(true);
				ttt3.setVisible(true);
				ttt4.setVisible(true);
				ttt5.setVisible(true);
				tff8.setVisible(false);
				tff9.setVisible(false);
				tfff1.setVisible(false);
				b8.setVisible(false);
				b9.setVisible(false);
				ttt7.setVisible(false);
				ttt8.setVisible(false);
				ttt9.setVisible(false);
				tttt1.setVisible(false);
				tfff2.setVisible(false);
				tfff3.setVisible(false);
				tfff4.setVisible(false);
				tfff5.setVisible(false);
				tfff6.setVisible(false);
				bb1.setVisible(false);
				bb2.setVisible(false);
				bb3.setVisible(false);
				bb4.setVisible(false);
				tttt2.setVisible(false);
				tttt3.setVisible(false);
				tttt4.setVisible(false);
				tttt5.setVisible(false);
				tttt6.setVisible(false);
				tttt7.setVisible(false);
				
			}
		});
		btnJoin.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnJoin.setBackground(Color.GRAY);
		btnJoin.setForeground(Color.WHITE);
		mnNewMenu.add(btnJoin);
		
		JMenu mnNewMenu_1 = new JMenu("Proiecte Licenta");
		mnNewMenu_1.setFont(new Font("Times New Roman", Font.BOLD, 16));
		mnNewMenu_1.setBackground(Color.BLACK);
		mnNewMenu_1.setForeground(Color.WHITE);
		menuBar.add(mnNewMenu_1);
		
		JButton button = new JButton("Display");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg1) {
				
				textArea_1.setVisible(true);
				display = display + 1;
				if( display >= 2){
					textArea_1.setText(null);
					display = 0; }
				tf1.setVisible(false);
				b1.setVisible(false);
				t1.setVisible(false);
				t2.setVisible(false);
				tf2.setVisible(false);
				b2.setVisible(false);
				t3.setVisible(false);
				t4.setVisible(false);
				tf3.setVisible(false);
				b3.setVisible(false);
				t5.setVisible(false);
				t6.setVisible(false);
				b4.setVisible(false);
				t7.setVisible(false);
				t8.setVisible(false);
				t9.setVisible(false);
				t10.setVisible(false);
				tf7.setVisible(false);
				tf8.setVisible(false);
				tf9.setVisible(false);
				tf10.setVisible(false);
				b5.setVisible(false);
				tt1.setVisible(false);
				tt2.setVisible(false);
				tt3.setVisible(false);
				tt4.setVisible(false);
				tt5.setVisible(false);
				tff1.setVisible(false);
				tff2.setVisible(false);
				tff3.setVisible(false);
				tff4.setVisible(false);
				tff5.setVisible(false);
				b6.setVisible(false);
				tt6.setVisible(false);
				tt7.setVisible(false);
				tt8.setVisible(false);
				tt9.setVisible(false);
				ttt1.setVisible(false);
				ttt2.setVisible(false);
				tff6.setVisible(false);
				tff7.setVisible(false);
				b7.setVisible(false);
				ttt3.setVisible(false);
				ttt4.setVisible(false);
				ttt5.setVisible(false);
				tff8.setVisible(false);
				tff9.setVisible(false);
				tfff1.setVisible(false);
				b8.setVisible(false);
				b9.setVisible(false);
				ttt7.setVisible(false);
				ttt8.setVisible(false);
				ttt9.setVisible(false);
				tttt1.setVisible(false);
				tfff2.setVisible(false);
				tfff3.setVisible(false);
				tfff4.setVisible(false);
				tfff5.setVisible(false);
				tfff6.setVisible(false);
				bb1.setVisible(false);
				bb2.setVisible(false);
				bb3.setVisible(false);
				bb4.setVisible(false);
				tttt2.setVisible(false);
				tttt3.setVisible(false);
				tttt4.setVisible(false);
				tttt5.setVisible(false);
				tttt6.setVisible(false);
				tttt7.setVisible(false);
				String salvare1 = conectare_informatii("SELECT Tema_Proiect, Titlul_Proiect, Data_Prezentare from [Gestiune_Licenta].[dbo].[Proiect_Licenta]",3);
				textArea_1.append("\n    Aveti urmatoarele informatii despre Proiecte_Licenta:\n");
				textArea_1.append("    Tema_Proiect\t               Titlu_Proiect\t\tData_Prezentare\n");
				textArea_1.append(salvare1);
				
				
			}
		});
		button.setForeground(Color.WHITE);
		button.setFont(new Font("Times New Roman", Font.BOLD, 16));
		button.setBackground(Color.GRAY);
		mnNewMenu_1.add(button);
		
		JButton button_2 = new JButton(" Erase  ");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg1) {
				
				textArea_1.setVisible(false);
				tf1.setVisible(false);
				b1.setVisible(false);
				t1.setVisible(false);
				t2.setVisible(false);
				tf2.setVisible(true);
				b2.setVisible(true);
				t3.setVisible(true);
				t4.setVisible(true);
				tf3.setVisible(false);
				b3.setVisible(false);
				t5.setVisible(false);
				t6.setVisible(false);
				tf4.setVisible(false);
				tf5.setVisible(false);
				tf6.setVisible(false);
				b4.setVisible(false);
				t7.setVisible(false);
				t8.setVisible(false);
				t9.setVisible(false);
				t10.setVisible(false);
				tf7.setVisible(false);
				tf8.setVisible(false);
				tf9.setVisible(false);
				tf10.setVisible(false);
				b5.setVisible(false);
				tt1.setVisible(false);
				tt2.setVisible(false);
				tt3.setVisible(false);
				tt4.setVisible(false);
				tt5.setVisible(false);
				tff1.setVisible(false);
				tff2.setVisible(false);
				tff3.setVisible(false);
				tff4.setVisible(false);
				tff5.setVisible(false);
				b6.setVisible(false);
				tt6.setVisible(false);
				tt7.setVisible(false);
				tt8.setVisible(false);
				tt9.setVisible(false);
				ttt1.setVisible(false);
				ttt2.setVisible(false);
				tff6.setVisible(false);
				tff7.setVisible(false);
				b7.setVisible(false);
				ttt3.setVisible(false);
				ttt4.setVisible(false);
				ttt5.setVisible(false);
				tff8.setVisible(false);
				tff9.setVisible(false);
				tfff1.setVisible(false);
				b8.setVisible(false);
				b9.setVisible(false);
				ttt7.setVisible(false);
				ttt8.setVisible(false);
				ttt9.setVisible(false);
				tttt1.setVisible(false);
				tfff2.setVisible(false);
				tfff3.setVisible(false);
				tfff4.setVisible(false);
				tfff5.setVisible(false);
				tfff6.setVisible(false);
				bb1.setVisible(false);
				bb2.setVisible(false);
				bb3.setVisible(false);
				bb4.setVisible(false);
				tttt2.setVisible(false);
				tttt3.setVisible(false);
				tttt4.setVisible(false);
				tttt5.setVisible(false);
				tttt6.setVisible(false);
				tttt7.setVisible(false);
				
			}
		});
		button_2.setForeground(Color.WHITE);
		button_2.setFont(new Font("Times New Roman", Font.BOLD, 16));
		button_2.setBackground(Color.GRAY);
		mnNewMenu_1.add(button_2);
		
		JButton button_3 = new JButton("Add      ");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			    
			
				textArea_1.setVisible(false);
				tf1.setVisible(false);
				b1.setVisible(false);
				t1.setVisible(false);
				t2.setVisible(false);
				tf2.setVisible(false);
				b2.setVisible(false);
				t3.setVisible(false);
				t4.setVisible(false);
				tf3.setVisible(false);
				b3.setVisible(false);
				t5.setVisible(false);
				t6.setVisible(false);
				tf4.setVisible(false);
				tf5.setVisible(false);
				tf6.setVisible(false);
				b4.setVisible(false);
				t7.setVisible(false);
				t8.setVisible(false);
				t9.setVisible(false);
				t10.setVisible(false);
				tf7.setVisible(true);
				tf8.setVisible(true);
				tf9.setVisible(true);
				tf10.setVisible(true);
				b5.setVisible(true);
				tt1.setVisible(true);
				tt2.setVisible(true);
				tt3.setVisible(true);
				tt4.setVisible(true);
				tt5.setVisible(true);
				tff1.setVisible(false);
				tff2.setVisible(false);
				tff3.setVisible(false);
				tff4.setVisible(false);
				tff5.setVisible(false);
				b6.setVisible(false);
				tt6.setVisible(false);
				tt7.setVisible(false);
				tt8.setVisible(false);
				tt9.setVisible(false);
				ttt1.setVisible(false);
				ttt2.setVisible(false);
				tff6.setVisible(false);
				tff7.setVisible(false);
				b7.setVisible(false);
				ttt3.setVisible(false);
				ttt4.setVisible(false);
				ttt5.setVisible(false);
				tff8.setVisible(false);
				tff9.setVisible(false);
				tfff1.setVisible(false);
				b8.setVisible(false);
				b9.setVisible(false);
				ttt7.setVisible(false);
				ttt8.setVisible(false);
				ttt9.setVisible(false);
				tttt1.setVisible(false);
				tfff2.setVisible(false);
				tfff3.setVisible(false);
				tfff4.setVisible(false);
				tfff5.setVisible(false);
				tfff6.setVisible(false);
				bb1.setVisible(false);
				bb2.setVisible(false);
				bb3.setVisible(false);
				bb4.setVisible(false);
				tttt2.setVisible(false);
				tttt3.setVisible(false);
				tttt4.setVisible(false);
				tttt5.setVisible(false);
				tttt6.setVisible(false);
				tttt7.setVisible(false);
			}
		});
		button_3.setForeground(Color.WHITE);
		button_3.setFont(new Font("Times New Roman", Font.BOLD, 16));
		button_3.setBackground(Color.GRAY);
		mnNewMenu_1.add(button_3);
		
		JButton btnUpdate = new JButton("Update");
		 btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			    
			
				textArea_1.setVisible(false);
				tf1.setVisible(false);
				b1.setVisible(false);
				t1.setVisible(false);
				t2.setVisible(false);
				tf2.setVisible(false);
				b2.setVisible(false);
				t3.setVisible(false);
				t4.setVisible(false);
				tf3.setVisible(false);
				b3.setVisible(false);
				t5.setVisible(false);
				t6.setVisible(false);
				tf4.setVisible(false);
				tf5.setVisible(false);
				tf6.setVisible(false);
				b4.setVisible(false);
				t7.setVisible(false);
				t8.setVisible(false);
				t9.setVisible(false);
				t10.setVisible(false);
				tf7.setVisible(false);
				tf8.setVisible(false);
				tf9.setVisible(false);
				tf10.setVisible(false);
				b5.setVisible(false);
				tt1.setVisible(false);
				tt2.setVisible(false);
				tt3.setVisible(false);
				tt4.setVisible(false);
				tt5.setVisible(false);
				tff1.setVisible(false);
				tff2.setVisible(false);
				tff3.setVisible(false);
				tff4.setVisible(false);
				tff5.setVisible(false);
				b6.setVisible(false);
				tt6.setVisible(false);
				tt7.setVisible(false);
				tt8.setVisible(false);
				tt9.setVisible(false);
				ttt1.setVisible(false);
				ttt2.setVisible(false);
				tff6.setVisible(false);
				tff7.setVisible(false);
				b7.setVisible(false);
				ttt3.setVisible(false);
				ttt4.setVisible(false);
				ttt5.setVisible(false);
				tff8.setVisible(true);
				tff9.setVisible(true);
				tfff1.setVisible(true);
				b8.setVisible(true);
				b9.setVisible(true);
				ttt7.setVisible(true);
				ttt8.setVisible(true);
				ttt9.setVisible(true);
				tttt1.setVisible(true);
				tfff2.setVisible(false);
				tfff3.setVisible(false);
				tfff4.setVisible(false);
				tfff5.setVisible(false);
				tfff6.setVisible(false);
				bb1.setVisible(false);
				bb2.setVisible(false);
				bb3.setVisible(false);
				bb4.setVisible(false);
				tttt2.setVisible(false);
				tttt3.setVisible(false);
				tttt4.setVisible(false);
				tttt5.setVisible(false);
				tttt6.setVisible(false);
				tttt7.setVisible(false);
				
			}
		});
		btnUpdate.setForeground(Color.WHITE);
		btnUpdate.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnUpdate.setBackground(Color.GRAY);
		mnNewMenu_1.add(btnUpdate);
		
		JMenu mnNewMenu_2 = new JMenu("Studenti");
		mnNewMenu_2.setBackground(Color.BLACK);
		mnNewMenu_2.setForeground(Color.WHITE);
		mnNewMenu_2.setFont(new Font("Times New Roman", Font.BOLD, 16));
		menuBar.add(mnNewMenu_2);
		
		JButton button_4 = new JButton("Display");
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg2) {
				
				textArea_1.setVisible(true);
				display = display + 1;
				if( display >= 2){
					textArea_1.setText(null);
					display = 0; }
				tf1.setVisible(false);
				b1.setVisible(false);
				t1.setVisible(false);
				t2.setVisible(false);
				tf2.setVisible(false);
				b2.setVisible(false);
				t3.setVisible(false);
				t4.setVisible(false);
				tf3.setVisible(false);
				b3.setVisible(false);
				t5.setVisible(false);
				t6.setVisible(false);
				b4.setVisible(false);
				t7.setVisible(false);
				t8.setVisible(false);
				t9.setVisible(false);
				t10.setVisible(false);
				tf7.setVisible(false);
				tf8.setVisible(false);
				tf9.setVisible(false);
				tf10.setVisible(false);
				b5.setVisible(false);
				tt1.setVisible(false);
				tt2.setVisible(false);
				tt3.setVisible(false);
				tt4.setVisible(false);
				tt5.setVisible(false);
				tff1.setVisible(false);
				tff2.setVisible(false);
				tff3.setVisible(false);
				tff4.setVisible(false);
				tff5.setVisible(false);
				b6.setVisible(false);
				tt6.setVisible(false);
				tt7.setVisible(false);
				tt8.setVisible(false);
				tt9.setVisible(false);
				ttt1.setVisible(false);
				ttt2.setVisible(false);
				tff6.setVisible(false);
				tff7.setVisible(false);
				b7.setVisible(false);
				ttt3.setVisible(false);
				ttt4.setVisible(false);
				ttt5.setVisible(false);
				tff8.setVisible(false);
				tff9.setVisible(false);
				tfff1.setVisible(false);
				b8.setVisible(false);
				b9.setVisible(false);
				ttt7.setVisible(false);
				ttt8.setVisible(false);
				ttt9.setVisible(false);
				tttt1.setVisible(false);
				tfff2.setVisible(false);
				tfff3.setVisible(false);
				tfff4.setVisible(false);
				tfff5.setVisible(false);
				tfff6.setVisible(false);
				bb1.setVisible(false);
				bb2.setVisible(false);
				bb3.setVisible(false);
				bb4.setVisible(false);
				tttt2.setVisible(false);
				tttt3.setVisible(false);
				tttt4.setVisible(false);
				tttt5.setVisible(false);
				tttt6.setVisible(false);
				tttt7.setVisible(false);
				String salvare2 = conectare_informatii("SELECT Nume, Prenume, CNP from [Gestiune_Licenta].[dbo].[Studenti]",3);
				textArea_1.append("\n    Aveti urmatoarele informatii despre Studenti:\n");
				textArea_1.append("    Nume\tPrenume\tCNP\n");
				textArea_1.append(salvare2);
			}
		});
		button_4.setForeground(Color.WHITE);
		button_4.setFont(new Font("Times New Roman", Font.BOLD, 16));
		button_4.setBackground(Color.GRAY);
		mnNewMenu_2.add(button_4);
		
		JButton button_1 = new JButton(" Erase  ");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg1) {
				
				textArea_1.setVisible(false);
				tf1.setVisible(false);
				b1.setVisible(false);
				t1.setVisible(false);
				t2.setVisible(false);
				tf2.setVisible(false);
				b2.setVisible(false);
				t3.setVisible(false);
				t4.setVisible(false);
				tf3.setVisible(true);
				b3.setVisible(true);
				t5.setVisible(true);
				t6.setVisible(true);
				b4.setVisible(false);
				t7.setVisible(false);
				t8.setVisible(false);
				t9.setVisible(false);
				t10.setVisible(false);
				tf7.setVisible(false);
				tf8.setVisible(false);
				tf9.setVisible(false);
				tf10.setVisible(false);
				b5.setVisible(false);
				tt1.setVisible(false);
				tt2.setVisible(false);
				tt3.setVisible(false);
				tt4.setVisible(false);
				tt5.setVisible(false);
				tff1.setVisible(false);
				tff2.setVisible(false);
				tff3.setVisible(false);
				tff4.setVisible(false);
				tff5.setVisible(false);
				b6.setVisible(false);
				tt6.setVisible(false);
				tt7.setVisible(false);
				tt8.setVisible(false);
				tt9.setVisible(false);
				ttt1.setVisible(false);
				ttt2.setVisible(false);
				tff6.setVisible(false);
				tff7.setVisible(false);
				b7.setVisible(false);
				ttt3.setVisible(false);
				ttt4.setVisible(false);
				ttt5.setVisible(false);
				tff8.setVisible(false);
				tff9.setVisible(false);
				tfff1.setVisible(false);
				b8.setVisible(false);
				b9.setVisible(false);
				ttt7.setVisible(false);
				ttt8.setVisible(false);
				ttt9.setVisible(false);
				tttt1.setVisible(false);
				tfff2.setVisible(false);
				tfff3.setVisible(false);
				tfff4.setVisible(false);
				tfff5.setVisible(false);
				tfff6.setVisible(false);
				bb1.setVisible(false);
				bb2.setVisible(false);
				bb3.setVisible(false);
				bb4.setVisible(false);
				tttt2.setVisible(false);
				tttt3.setVisible(false);
				tttt4.setVisible(false);
				tttt5.setVisible(false);
				tttt6.setVisible(false);
				tttt7.setVisible(false);
				
			}
		});
		mnNewMenu_2.add(button_1);
		button_1.setForeground(Color.WHITE);
		button_1.setFont(new Font("Times New Roman", Font.BOLD, 16));
		button_1.setBackground(Color.GRAY);
		
		JButton button_5 = new JButton("Add      ");
		button_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			    
			
				textArea_1.setVisible(false);
				tf1.setVisible(false);
				b1.setVisible(false);
				t1.setVisible(false);
				t2.setVisible(false);
				tf2.setVisible(false);
				b2.setVisible(false);
				t3.setVisible(false);
				t4.setVisible(false);
				tf3.setVisible(false);
				b3.setVisible(false);
				t5.setVisible(false);
				t6.setVisible(false);
				tf4.setVisible(false);
				tf5.setVisible(false);
				tf6.setVisible(false);
				b4.setVisible(false);
				t7.setVisible(false);
				t8.setVisible(false);
				t9.setVisible(false);
				t10.setVisible(false);
				tf7.setVisible(false);
				tf8.setVisible(false);
				tf9.setVisible(false);
				tf10.setVisible(false);
				b5.setVisible(false);
				tt1.setVisible(false);
				tt2.setVisible(false);
				tt3.setVisible(false);
				tt4.setVisible(false);
				tt5.setVisible(false);
				tff1.setVisible(true);
				tff2.setVisible(true);
				tff3.setVisible(true);
				tff4.setVisible(true);
				tff5.setVisible(true);
				b6.setVisible(true);
				tt6.setVisible(true);
				tt7.setVisible(true);
				tt8.setVisible(true);
				tt9.setVisible(true);
				ttt1.setVisible(true);
				ttt2.setVisible(true);
				tff6.setVisible(false);
				tff7.setVisible(false);
				b7.setVisible(false);
				ttt3.setVisible(false);
				ttt4.setVisible(false);
				ttt5.setVisible(false);
				tff8.setVisible(false);
				tff9.setVisible(false);
				tfff1.setVisible(false);
				b8.setVisible(false);
				b9.setVisible(false);
				ttt7.setVisible(false);
				ttt8.setVisible(false);
				ttt9.setVisible(false);
				tttt1.setVisible(false);
				tfff2.setVisible(false);
				tfff3.setVisible(false);
				tfff4.setVisible(false);
				tfff5.setVisible(false);
				tfff6.setVisible(false);
				bb1.setVisible(false);
				bb2.setVisible(false);
				bb3.setVisible(false);
				bb4.setVisible(false);
				tttt2.setVisible(false);
				tttt3.setVisible(false);
				tttt4.setVisible(false);
				tttt5.setVisible(false);
				tttt6.setVisible(false);
				tttt7.setVisible(false);
			}
		});
		button_5.setForeground(Color.WHITE);
		button_5.setFont(new Font("Times New Roman", Font.BOLD, 16));
		button_5.setBackground(Color.GRAY);
		mnNewMenu_2.add(button_5);
		
		JButton btnUpdate_1 = new JButton("Update");
		btnUpdate_1 .addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			    
			
				textArea_1.setVisible(false);
				tf1.setVisible(false);
				b1.setVisible(false);
				t1.setVisible(false);
				t2.setVisible(false);
				tf2.setVisible(false);
				b2.setVisible(false);
				t3.setVisible(false);
				t4.setVisible(false);
				tf3.setVisible(false);
				b3.setVisible(false);
				t5.setVisible(false);
				t6.setVisible(false);
				tf4.setVisible(false);
				tf5.setVisible(false);
				tf6.setVisible(false);
				b4.setVisible(false);
				t7.setVisible(false);
				t8.setVisible(false);
				t9.setVisible(false);
				t10.setVisible(false);
				tf7.setVisible(false);
				tf8.setVisible(false);
				tf9.setVisible(false);
				tf10.setVisible(false);
				b5.setVisible(false);
				tt1.setVisible(false);
				tt2.setVisible(false);
				tt3.setVisible(false);
				tt4.setVisible(false);
				tt5.setVisible(false);
				tff1.setVisible(false);
				tff2.setVisible(false);
				tff3.setVisible(false);
				tff4.setVisible(false);
				tff5.setVisible(false);
				b6.setVisible(false);
				tt6.setVisible(false);
				tt7.setVisible(false);
				tt8.setVisible(false);
				tt9.setVisible(false);
				ttt1.setVisible(false);
				ttt2.setVisible(false);
				tff6.setVisible(false);
				tff7.setVisible(false);
				b7.setVisible(false);
				ttt3.setVisible(false);
				ttt4.setVisible(false);
				ttt5.setVisible(false);
				tff8.setVisible(false);
				tff9.setVisible(false);
				tfff1.setVisible(false);
				b8.setVisible(false);
				b9.setVisible(false);
				ttt7.setVisible(false);
				ttt8.setVisible(false);
				ttt9.setVisible(false);
				tttt1.setVisible(false);
				tfff2.setVisible(true);
				tfff3.setVisible(true);
				tfff4.setVisible(true);
				tfff5.setVisible(true);
				tfff6.setVisible(true);
				bb1.setVisible(true);
				bb2.setVisible(true);
				bb3.setVisible(true);
				bb4.setVisible(true);
				tttt2.setVisible(true);
				tttt3.setVisible(true);
				tttt4.setVisible(true);
				tttt5.setVisible(true);
				tttt6.setVisible(true);
				tttt7.setVisible(true);
			}
		});
		btnUpdate_1.setForeground(Color.WHITE);
		btnUpdate_1.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnUpdate_1.setBackground(Color.GRAY);
		mnNewMenu_2.add(btnUpdate_1);

	}
}
