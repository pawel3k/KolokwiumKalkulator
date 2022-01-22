import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import java.util.Scanner;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class Kalkulator  extends JFrame implements ActionListener {
	
	JButton losuj;
	JTextField pole_a;
	JTextField pole_dodaj_odejmij;
	JTextField pole_b;
	JTextField pole_wynik;
	JButton sprawdz;
	JTextField gratulacje;
	
	public Random losowy = new Random();
	int liczba = losowy.nextInt(10) + 1;
	
	public Random losowy2 = new Random();
	int liczba2 = losowy2.nextInt(10) + 1;
	
	public Random losowy3 = new Random();
	int znakDzialania = losowy3.nextInt(2) + 1;
	
	
	public static void main(String[] args) {
		Kalkulator frame = new Kalkulator();
		frame.initUI();

	}
	
	private void initUI() {
		
		losuj = new JButton("Losuj byczq!");
		losuj.addActionListener(this);
		
		pole_a = new JTextField();
		pole_dodaj_odejmij = new JTextField();
		pole_b = new JTextField();
		pole_wynik = new JTextField();
		gratulacje = new JTextField();
		
		sprawdz = new JButton("Sprawdz siê kiddosie!");
		sprawdz.addActionListener(this);
		
		this.add(losuj);
		
		this.add(pole_a);
		this.add(pole_dodaj_odejmij);
		this.add(pole_b);
		this.add(pole_wynik);
		this.add(gratulacje);
		
		this.add(sprawdz);

		this.setLayout(new GridLayout(4, 1));
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setSize(500, 500);
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(losuj.equals(e.getSource())) {
			losuj();
		} else if(sprawdz.equals(e.getSource())) {
			sprawdz();
		}	
	}

	private void sprawdz() {
		
		String wynik = pole_wynik.getText();
		int liczbaWynik = Integer.parseInt(wynik);
		
		String liczba1 = pole_a.getText();
		int pole_liczba1 = Integer.parseInt(liczba1);
		
		String liczba2 = pole_b.getText();
		int pole_liczba2 = Integer.parseInt(liczba2);
		
		if(pole_dodaj_odejmij.getText().equals("Dodaj")) {
			if(liczbaWynik == pole_liczba1 + pole_liczba2) {
				gratulacje.setText(liczbaWynik + " to poprawny wynik dzia³ania.");
			}else {
				gratulacje.setText(liczbaWynik + " nie jest wynikiem tego dzia³ania. Naucz sie liczyæ :P");
			}
		} else if(pole_dodaj_odejmij.getText().equals("Odejmij")) {
			if(liczbaWynik == pole_liczba1 - pole_liczba2) {
				gratulacje.setText(liczbaWynik + " to poprawny wynik dzia³ania.");
			}else {
				gratulacje.setText( liczbaWynik + " nie jest wynikiem tego dzia³ania.");
			
			}
		}
	}

	private void losuj() {
		
		int pierwszePole = liczba;
		pole_a.setText(String.valueOf(pierwszePole));
		
		if(znakDzialania == 1) {
			pole_dodaj_odejmij.setText("Dodaj");
		} else {
			pole_dodaj_odejmij.setText("Odejmij");
		}
		
		int drugiePole = liczba2;
		pole_b.setText(String.valueOf(drugiePole));
		
	}

}