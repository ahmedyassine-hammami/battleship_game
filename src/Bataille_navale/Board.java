package Bataille_navale;

public class Board {
	protected String name;
	protected char[][] grille_navire;
	protected boolean[][] grille_frappe;
	
	public String getName() {
		return name;
	}

	public void setName(String nom) {
		this.name = nom;
	}

	public char[][] getGrille_navire() {
		return grille_navire;
	}

	public void setGrille_navire(char[][] navire) {
		this.grille_navire = navire;
	}

	public boolean[][] getGrille_frappe() {
		return grille_frappe;
	}

	public void setGrille_frappe(boolean[][] frappe) {
		this.grille_frappe = frappe;
	}
	
	
	

	public Board(String nom, int taille) {
		this.name=nom;
		this.grille_frappe=new boolean[taille][taille];
		this.grille_navire=new char[taille][taille];
	
	}
	
	public Board(String nom) {
		this(nom,10);
	}
	
	public void print() {
		System.out.println("Grille navire");
		for(int i=0;i<grille_navire.length;i++) {
			for(int j=0;j<grille_navire.length;j++) {
				if(this.grille_navire[i][j]==0) System.out.print(" . ");
				else System.out.print(this.grille_navire[i][j]);
			}
			System.out.println();
		}
		System.out.println("Grille frappe");
		for(int i=0;i<grille_frappe.length;i++) {
			for(int j=0;j<grille_frappe.length;j++) {
				if(this.grille_frappe[i][j]==false) System.out.print(" . ");
				else System.out.print(" x ");
			}
			System.out.println();
		}
		
		
		
		
		
		
	}

}
