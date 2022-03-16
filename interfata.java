package net.codejava.sql;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Image;

import javax.swing.SwingConstants;


public class interfata extends JFrame {
    public String conectare_informatii(String executa,int nr)
    {
    	
    	String URL;
    	String Username;
    	String Password;
    	Username="sa";
    	Password="12345";
    	URL="jdbc:sqlserver://DESKTOP-8LL24UK\\SQLEXPRESS;databaseName=Gestiune_Licenta";
        String actionare ="";
    	
        try {
		Connection connection=DriverManager.getConnection(URL,Username,Password);
		Statement statement = connection.createStatement();
		ResultSet result= statement.executeQuery(executa);
	 
		
		while (result.next()) 
		{
			for(int i=1;i<=nr;i++)
			{
				
			actionare = actionare+result.getString(i)+" ";
			
			}
			actionare=actionare+"\n";
			
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

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					interfata frame = new interfata();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public interfata() {
		getContentPane().setBackground(Color.BLACK);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 787, 530);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 751, 469);
		panel.setBackground(new Color (107, 5, 4));
		getContentPane().add(panel);
		panel.setLayout(null);
		JLabel label = new JLabel("");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBounds(10,0,167,134);
		ImageIcon imageIcon = new ImageIcon(new ImageIcon(this.getClass().getResource("/upb.jpg")).getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT));
		label.setIcon(imageIcon);
		panel.add(label);
		ImageIcon imageIconn = new ImageIcon(new ImageIcon(this.getClass().getResource("/t.jpg")).getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT));
		
		JPanel panell_1 = new JPanel();
		panell_1.setBounds(195, 0, 556, 74);
		panell_1.setBackground(new Color(31, 19, 0));
		panel.add(panell_1);
		
		JButton btnAdmitere_1 = new JButton("Admitere");
		btnAdmitere_1.setForeground(Color.WHITE);
		btnAdmitere_1.setFont(new Font("Times New Roman", Font.BOLD, 13));
		btnAdmitere_1.setBackground(new Color (107, 5, 4));
		
		JButton btnContact = new JButton("Contact");
		btnContact.setForeground(Color.WHITE);
		btnContact.setFont(new Font("Times New Roman", Font.BOLD, 13));
		btnContact.setBackground(new Color (107, 5, 4));
		
		JButton btnSite = new JButton("Site");
		btnSite.setForeground(Color.WHITE);
		btnSite.setFont(new Font("Times New Roman", Font.BOLD, 13));
		btnSite.setBackground(new Color (107, 5, 4));
		
		JButton btnAdmitere = new JButton("Diverse");
		btnAdmitere.setForeground(Color.WHITE);
		btnAdmitere.setFont(new Font("Times New Roman", Font.BOLD, 13));
		btnAdmitere.setBackground(new Color (107, 5, 4));
		GroupLayout gl_panell_1 = new GroupLayout(panell_1);
		gl_panell_1.setHorizontalGroup(
			gl_panell_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panell_1.createSequentialGroup()
					.addGap(74)
					.addComponent(btnAdmitere_1)
					.addGap(28)
					.addComponent(btnContact)
					.addGap(32)
					.addComponent(btnSite)
					.addGap(30)
					.addComponent(btnAdmitere)
					.addGap(96))
		);
		gl_panell_1.setVerticalGroup(
			gl_panell_1.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panell_1.createSequentialGroup()
					.addContainerGap(29, Short.MAX_VALUE)
					.addGroup(gl_panell_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnAdmitere_1)
						.addComponent(btnSite)
						.addComponent(btnContact)
						.addComponent(btnAdmitere))
					.addGap(20))
		);
		panell_1.setLayout(gl_panell_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(195, 74, 556, 395);
		panel_1.setBackground(new Color (177, 9, 6));
		panel.add(panel_1);
		
		JTextArea txt = new JTextArea();
		txt.setForeground(Color.WHITE);
		txt.setBackground(new Color (177, 9, 6));
		txt.setWrapStyleWord(true);
		txt.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		txt.setTabSize(4);
		txt.setText("  Universitatea Politehnica din Bucure\u0219ti este o institu\u021Bie de\r\n\u00EEnv\u0103\u021B\u0103m\u00E2nt superior de stat din Bucure\u0219ti, Rom\u00E2nia, \u00EEnfiin\u021Bat\u0103 \u00EEn \r\nanul 1864. Totodat\u0103, este cea mai mare universitate tehnic\u0103 din \u021Bar\u0103, \r\nav\u00E2nd 15 facult\u0103\u021Bi \u0219i aproximativ 25.000 de studen\u021Bi. Wikipedia");
		txt.setEditable(false);
		
		JLabel labell = new JLabel("");
		labell.setHorizontalAlignment(SwingConstants.CENTER);
		labell.setIcon(imageIconn);
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap(110, Short.MAX_VALUE)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(Alignment.TRAILING, gl_panel_1.createSequentialGroup()
							.addComponent(labell)
							.addGap(226))
						.addGroup(Alignment.TRAILING, gl_panel_1.createSequentialGroup()
							.addComponent(txt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(82))))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(54)
					.addComponent(labell)
					.addGap(18)
					.addComponent(txt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(155, Short.MAX_VALUE))
		);
		panel_1.setLayout(gl_panel_1);
		
		JButton btnNewButton = new JButton("Profesor");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				afisare ecran = new afisare();
				ecran.newScreen();
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 13));
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setBounds(46, 226, 89, 23);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Student1");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg1) {
				afisare2 ecran1 = new afisare2();
				ecran1.newScreen2();
			}
		});
		btnNewButton_1.setForeground(new Color(0, 0, 0));
		btnNewButton_1.setFont(new Font("Times New Roman", Font.BOLD, 13));
		btnNewButton_1.setBackground(Color.WHITE);
		btnNewButton_1.setBounds(46, 268, 89, 23);
		panel.add(btnNewButton_1);
		
		JLabel lblNewLabel = new JLabel("Autentificare:");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 17));
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(38, 190, 111, 14);
		panel.add(lblNewLabel);
		
		JButton btnStudent = new JButton("Student2");
		btnStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
					afisare3 ecran3 = new afisare3();
					ecran3.newScreen2();
				
			}
		});
		btnStudent.setForeground(Color.BLACK);
		btnStudent.setFont(new Font("Times New Roman", Font.BOLD, 13));
		btnStudent.setBackground(Color.WHITE);
		btnStudent.setBounds(46, 309, 89, 23);
		panel.add(btnStudent);
		
		
	}
}
