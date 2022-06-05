package jFrame;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class BancoGui {

	public static void main(Usuario user) {
		JFrame bankF=new JFrame("Menu de cuentas");
		bankF.setResizable(false);
		JPanel bankPanel=new JPanel();
		
		JLabel temp=new JLabel("");
		bankPanel.add(temp);
		temp.setVisible(false);
		
		
		bankF.getRootPane().setBorder(BorderFactory.createMatteBorder(4, 4, 4, 4, Color.RED));
		bankPanel.setBackground(Color.white);

		bankF.setSize(800, 380); 
		bankF.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		bankF.add(bankPanel);
		
		JLabel tCuenta=new JLabel("                 Menu de cuentas");
		tCuenta.setBackground(Color.red);
		tCuenta.setOpaque(true);
		tCuenta.setForeground(Color.white);
		tCuenta.setBounds(5, 20, 200, 30);
		bankPanel.add(tCuenta);
		
		JLabel tOpe=new JLabel("                     Operaciones");
		tOpe.setOpaque(true);
		tOpe.setBackground(Color.red);
		tOpe.setForeground(Color.white);
		tOpe.setBounds(5, 130, 200, 30);
		bankPanel.add(tOpe);
		
		//Estetica
		Color colorp1=new Color(217, 243, 245);
		JLabel fill=new JLabel();
		fill.setOpaque(true);
		fill.setBackground(colorp1);
		fill.setBounds(250, 40, 100, 30);
		bankPanel.add(fill);
		
		
		//Botonera
		JLabel lTransfer=new JLabel("Monto a transferir: ");
		JTextField transfertxt=new JTextField("");
		JButton transferButton=new JButton("Transferir");
		
		JLabel lSaldo=new JLabel();
		
		JButton extractButton=new JButton("Extraer");
		JTextField extracttxt=new JTextField("");
		JLabel lExtract=new JLabel("Monto a extraer: ");
		
		JLabel lDeposit=new JLabel("Monto a depositar: ");
		JTextField deposittxt=new JTextField("");
		JButton depositButton=new JButton("Depositar");
		
		JLabel lExito=new JLabel("¡Se ha realizado con exito su operación!");
		lExito.setBounds(415, 230, 300, 20);
		lExito.setVisible(false);
		bankPanel.add(lExito);
		

		
		
		JRadioButton cAhorro=new JRadioButton("Caja de ahorro");
		cAhorro.setBounds(5, 50, 200, 30);
		cAhorro.setBackground(colorp1);
		bankPanel.add(cAhorro);
		cAhorro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				temp.setText("0");
				lSaldo.setText("");
			}
		});
		
		JRadioButton cCorriente=new JRadioButton("Cuenta corriente");
		cCorriente.setBounds(5, 80, 200, 30);
		cCorriente.setBackground(colorp1);
		bankPanel.add(cCorriente);
		cCorriente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				temp.setText("1");
				lSaldo.setText("");
			}
		});

		ButtonGroup cajas=new ButtonGroup();
		cajas.add(cCorriente); cajas.add(cAhorro);
		
		
		
		
		
		
		lSaldo.setBounds(250, 80, 400, 30);
		lSaldo.setVisible(false);
		bankPanel.add(lSaldo);
		
		
		
		JRadioButton saldo=new JRadioButton("Saldo");
		saldo.setBounds(5, 160, 200, 30);
		saldo.setBackground(colorp1);
		bankPanel.add(saldo);
		saldo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				if(temp.getText()=="") {JOptionPane.showMessageDialog(null, "Debe ingresar un tipo de cuenta para conocer su saldo", "Info" ,JOptionPane.ERROR_MESSAGE);}
				else 
				{
					int temp2=Integer.parseInt(temp.getText());
					if(temp2==0) {lSaldo.setText("Su saldo actual en esta cuenta es de: "+user.getcAhorro());}
					else if(temp2==1) {lSaldo.setText("Su saldo actual en esta cuenta es de: "+user.getcCorriente());}
				}

				
				
				lSaldo.setVisible(true);
				lExito.setVisible(false);
				extracttxt.setVisible(false);
				extractButton.setVisible(false);
				lExtract.setVisible(false);
				transferButton.setVisible(false);
				lTransfer.setVisible(false);
				transfertxt.setVisible(false);
				lDeposit.setVisible(false);
				deposittxt.setVisible(false);
				depositButton.setVisible(false);
			}
		});
		
		
		
		lTransfer.setVisible(false);
		lTransfer.setBounds(300, 150, 400, 30);
		bankPanel.add(lTransfer);
		
		transfertxt.setBounds(420, 150, 300, 30);
		transfertxt.setVisible(false);
		bankPanel.add(transfertxt);	
		
		transferButton.setBounds(500, 200, 100, 20);
		transferButton.setVisible(false);
		bankPanel.add(transferButton);
		transferButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e)
			{
				if(temp.getText()=="") {JOptionPane.showMessageDialog(null, "Debe ingresar un tipo de cuenta para la transferencia", "Info" ,JOptionPane.ERROR_MESSAGE);}
				else 
				{
					int temp2=Integer.parseInt(temp.getText());
					int monto=Integer.parseInt(transfertxt.getText());
					if(temp2==0) 
					{
						if(user.getcAhorro()>=monto) 
						{
							user.setcCorriente(user.getcCorriente()+monto);
							user.setcAhorro(user.getcAhorro()-monto);
							lExito.setVisible(true);
						}
						else {JOptionPane.showMessageDialog(null, "No dispone de suficiente dinero en la cuenta", "Info" ,JOptionPane.ERROR_MESSAGE);}
					} else if(temp2==1) 
					{
						if(user.getcCorriente()>=monto) 
						{
							user.setcAhorro(user.getcAhorro()+monto);
							user.setcCorriente(user.getcCorriente()-monto);
							lExito.setVisible(true);
						}
						else {JOptionPane.showMessageDialog(null, "No dispone de suficiente dinero en la cuenta", "Info" ,JOptionPane.ERROR_MESSAGE);}
					}
				}
			}
		});
		
		JRadioButton transferencia=new JRadioButton("Transferencia");
		transferencia.setBounds(5, 190, 200, 30);
		transferencia.setBackground(colorp1);
		bankPanel.add(transferencia);
		transferencia.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0)
			{
				lTransfer.setVisible(true);
				transferButton.setVisible(true);
				transfertxt.setVisible(true);
				lSaldo.setVisible(false);
				extracttxt.setVisible(false);
				extractButton.setVisible(false);
				lExtract.setVisible(false);
				lDeposit.setVisible(false);
				deposittxt.setVisible(false);
				depositButton.setVisible(false);
				lExito.setVisible(false);

				
			}
		});
		
		extractButton.setBounds(500, 200, 100, 20);
		extractButton.setVisible(false);
		extractButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e)
			{	
				if(temp.getText()=="") {JOptionPane.showMessageDialog(null, "Debe ingresar un tipo de cuenta para la extracción", "Info" ,JOptionPane.ERROR_MESSAGE);}
				else 
				{
					int temp2=Integer.parseInt(temp.getText());
					int monto=Integer.parseInt(extracttxt.getText());
					if(temp2==0) 
					{
						if(user.getcAhorro()>=monto) 
						{
							user.setEfectivo(user.getEfectivo()+monto);
							user.setcAhorro(user.getcAhorro()-monto);
							lExito.setVisible(true);
						}
						else {JOptionPane.showMessageDialog(null, "No dispone de suficiente dinero en la cuenta", "Info" ,JOptionPane.ERROR_MESSAGE);}
					} else if(temp2==1) 
					{
						if(user.getcCorriente()>=monto) 
						{
							user.setEfectivo(user.getEfectivo()+monto);
							user.setcCorriente(user.getcCorriente()-monto);
							lExito.setVisible(true);
						}
						else {JOptionPane.showMessageDialog(null, "No dispone de suficiente dinero en la cuenta", "Info" ,JOptionPane.ERROR_MESSAGE);}
					}
				}
			}
		});		

		bankPanel.add(extractButton);
		
		extracttxt.setBounds(420, 150, 300, 30);
		extracttxt.setVisible(false);
		bankPanel.add(extracttxt);
		
		lExtract.setBounds(300, 150, 400, 30);
		lExtract.setVisible(false);
		bankPanel.add(lExtract);
		
		
		
		
		
		
		JRadioButton radBextraccion=new JRadioButton("Extraccion");
		radBextraccion.setBounds(5, 220, 200, 30);
		radBextraccion.setBackground(colorp1);
		bankPanel.add(radBextraccion);
		radBextraccion.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				extracttxt.setVisible(true);
				extractButton.setVisible(true);
				lExtract.setVisible(true);
				lTransfer.setVisible(false);
				lSaldo.setVisible(false);
				transferButton.setVisible(false);
				transfertxt.setVisible(false);
				lDeposit.setVisible(false);
				deposittxt.setVisible(false);
				depositButton.setVisible(false);
				lExito.setVisible(false);
				
				
			}
		});
		

		lDeposit.setVisible(false);
		lDeposit.setBounds(300, 150, 400, 30);
		bankPanel.add(lDeposit);
		
		deposittxt.setBounds(420, 150, 300, 30);
		deposittxt.setVisible(false);
		bankPanel.add(deposittxt);	
		
		depositButton.setBounds(500, 200, 100, 20);
		depositButton.setVisible(false);
		bankPanel.add(depositButton);
		depositButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(temp.getText()=="") {JOptionPane.showMessageDialog(null, "Debe ingresar un tipo de cuenta para el deposito", "Info" ,JOptionPane.ERROR_MESSAGE);}
				else 
				{
					int temp2=Integer.parseInt(temp.getText());
					int monto=Integer.parseInt(deposittxt.getText());
					if(temp2==0) 
					{
						if(user.getEfectivo()>=monto) 
						{
							user.setcAhorro(user.getcAhorro()+monto);
							user.setEfectivo(user.getEfectivo()-monto);
							lExito.setVisible(true);
						}
						else {JOptionPane.showMessageDialog(null, "No ingreso el dinero suficiente", "Info" ,JOptionPane.ERROR_MESSAGE);}
					} else if(temp2==1) 
					{
						if(user.getEfectivo()>=monto) 
						{
							user.setcCorriente(user.getcCorriente()+monto);
							user.setEfectivo(user.getEfectivo()-monto);
							lExito.setVisible(true);
						}
						else {JOptionPane.showMessageDialog(null, "No ingreso el dinero suficiente", "Info" ,JOptionPane.ERROR_MESSAGE);}
					}
				}
				
			}
		});
		
		
		
		JRadioButton depositos=new JRadioButton("Depositos");
		depositos.setBounds(5, 250, 200, 30);
		depositos.setBackground(colorp1);
		bankPanel.add(depositos);
		depositos.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				lDeposit.setVisible(true);
				deposittxt.setVisible(true);
				depositButton.setVisible(true);
				extracttxt.setVisible(false);
				extractButton.setVisible(false);
				lExtract.setVisible(false);
				lTransfer.setVisible(false);
				transferButton.setVisible(false);
				transfertxt.setVisible(false);
				lSaldo.setVisible(false);
				lExito.setVisible(false);
			}
	
	   });
		
		ButtonGroup opciones=new ButtonGroup();
		opciones.add(saldo); opciones.add(transferencia); opciones.add(radBextraccion); opciones.add(depositos);
		
		
		JButton salir=new JButton("Salir");
		salir.setBounds(5, 300, 200, 20);
		salir.setBackground(colorp1);
		bankPanel.add(salir);
		salir.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				System.exit(0);
			}
			
			
			
		});

		
		JLabel boxtitle=new JLabel("Información de la cuenta N°:  "+user.getCodCuenta());
		boxtitle.setBounds(350, 40, 400, 30);
		boxtitle.setOpaque(true);
		boxtitle.setBackground(colorp1);
		bankPanel.add(boxtitle);
		

		
		
		
		
	
		bankPanel.setLayout(null);
		
		bankF.setVisible(true);
		
	}

}
