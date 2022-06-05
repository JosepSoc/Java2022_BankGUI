package jFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LogInGUI {
	private static JFrame logFrame;
	private static JPanel logPanel;
	private static JLabel log_Userlabel;
	private static JTextField log_UserTF;
	private static JLabel log_Passlabel;
	private static JPasswordField log_PassTF;
	private static JButton logButton;
	private static JLabel errorIng;
	public static int cont;
	
	public static void main(String[] args) {
		cont=0;
		Usuario[] arrUser=new Usuario[3];
		arrUser[0]=(new Usuario("Asdd1234", "12345678", true, "43582-1529-63096", 4000, 3000, 200));
		arrUser[1]=(new Usuario("MauroZar42", "Polaina7", true, "43535-1527-25296", 3000, 5000, 2000));
		arrUser[2]=(new Usuario("Sebastian33", "Alesito9", true, "43525-1569-89892", 6000, 0, 5000));
		login(arrUser);

	}
	public static void guiBanco(Usuario user) {
		BancoGui.main(user);
	}
	public static void login(Usuario[] arrUser) {

		logFrame=new JFrame("Banco UTN S.A.");
		logPanel=new JPanel();
		
		logFrame.setSize(300, 200); 
		logFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		logFrame.add(logPanel);
	
		logPanel.setLayout(null);
		
		
		log_Userlabel=new JLabel("Usuario");
		log_Userlabel.setBounds(10, 20, 80, 25);
		logPanel.add(log_Userlabel);
		log_UserTF=new JTextField(8);
		log_UserTF.setBounds(100, 20, 165, 25);
		logPanel.add(log_UserTF);
		
		log_Passlabel=new JLabel("PIN");
		log_Passlabel.setBounds(10, 50, 80, 25);
		logPanel.add(log_Passlabel);
		log_PassTF=new JPasswordField(8);
		log_PassTF.setBounds(100, 50, 165, 25);
		logPanel.add(log_PassTF);
		
		errorIng=new JLabel("");
		errorIng.setBounds(10, 110, 300, 25);
		logPanel.add(errorIng);
		errorIng.setText("");
		
		
		logButton=new JButton("Ingresar");
		logButton.setBounds(135, 85, 90, 25);
		logPanel.add(logButton);
		logButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				int temppos=0;
				String user = log_UserTF.getText();
				String password = log_PassTF.getText();
				if(user.length()>=8 && user.length()<=20 && password.length()==8) {
					boolean flag=true;
					for(int i=0; i<arrUser.length; i++) {
						if(user.equals(arrUser[i].getNombre()) && password.equals(arrUser[i].getPin()) && arrUser[i].isEstado()==true) {
							flag=true;
							temppos=i;
							break;
						} else {
							flag=false;
						}
					}
					if(flag==false) 
					{
						if(cont<2) 
						{
							cont=cont+1;
							errorIng.setText("Error de credencial");
						} else {
							for(int i=0; i<arrUser.length; i++) 
							{
								if(user.equals(arrUser[i].getNombre())) 
								{
									JOptionPane.showMessageDialog(null, "Su cuenta ha sido suspendida por exceso de intentos", "Info" ,JOptionPane.ERROR_MESSAGE);
									arrUser[i].setEstado(false);
									cont=0;
									break;
								} 
								else 
								{
									JOptionPane.showMessageDialog(null, "Su usuario no existe", "Info" ,JOptionPane.ERROR_MESSAGE);
									break;
								}
								
							}
						 }
					} else 
						{
							logFrame.setVisible(false);
							guiBanco(arrUser[temppos]);
						}
				    } else if(user.length()<8 || user.length()>20){JOptionPane.showMessageDialog(null, "El usuario debe tener entre 8 y 20 caracteres", "Info" ,JOptionPane.ERROR_MESSAGE);
				    } else if(password.length()!=8) {JOptionPane.showMessageDialog(null, "La contraseña debe tener 8 caracteres", "Info" ,JOptionPane.ERROR_MESSAGE);}
		
		   }

		});
		
		
		
		
		
		
		
		logFrame.setVisible(true);
	}

}
