package Bataille_navale;

public class Board implements IBoard {
	
	protected String name;
	protected char[][] grille_navire;
	protected boolean[][] grille_frappe;
	/*getters and setters*/
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
	
	/* Constructor */

	public Board(String nom, int taille) {
		this.name=nom;
		this.grille_frappe=new boolean[taille][taille];
		this.grille_navire=new char[taille][taille];
	
	}
	/* Constructor with default size */
	public Board(String nom) {
		this(nom,10);
	}
	
	
	/* print method */
	public void print() {
		System.out.println("Grille navire");
		for(int i=0;i<grille_navire.length;i++) {
			for(int j=0;j<grille_navire.length;j++) {
				if(this.grille_navire[i][j]==0) System.out.print(" . ");
				else System.out.print(" "+this.grille_navire[i][j]+" ");
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

	@Override
	public int getSize() {
		return this.grille_navire.length;
	}

	@Override
	public void putShip(AbstractShip ship, int x, int y) {
		x--;
		y--;
		if (ship.orientation==Orientation.NORTH) {
		
			int n = x-ship.taille+1;
			if (n<0) System.out.println("Longueur du bateau est grande");
			else {
				int i=n;
				while(i<x+1) {
					this.grille_navire[i][y]=ship.label;
					i++;
				}
				
				
			}
		
		
		
		}
		
	}

	@Override
	public boolean hasShip(int x, int y) {
		if(this.grille_navire[x-1][y-1]!=0) return true;
		return false;
	}

	@Override
	public void setHit(boolean hit, int x, int y) {
		this.grille_frappe[x-1][y-1]=hit;
		
	}

	@Override
	public Boolean getHit(int x, int y) {
		return this.grille_frappe[x-1][y-1];
	}
	
}
