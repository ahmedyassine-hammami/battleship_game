package Bataille_navale;

public class Board implements IBoard {
	
	protected String name;
	protected ShipState[][] grille_navire;
	protected Boolean[][] grille_frappe;
	/*getters and setters*/
	public String getName() {
		return name;
	}

	public void setName(String nom) {
		this.name = nom;
	}

	public ShipState[][] getGrille_navire() {
		return grille_navire;
	}

	public void setGrille_navire(ShipState[][] navire) {
		this.grille_navire = navire;
	}

	public Boolean[][] getGrille_frappe() {
		return grille_frappe;
	}

	public void setGrille_frappe(Boolean[][] frappe) {
		this.grille_frappe = frappe;
	}
	
	/* Constructor */

	public Board(String nom, int taille) {
		this.name=nom;
		this.grille_frappe=new Boolean[taille][taille];
		this.grille_navire=new ShipState[taille][taille];
	
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
				if(this.grille_navire[i][j]==null) System.out.print(" . ");
				else System.out.print(" "+this.grille_navire[i][j].ship.label+" ");
			}
			System.out.println();
		}
		Boolean True = new Boolean(true);
		Boolean False = new Boolean(false);
		System.out.println("Grille frappe");
		for(int i=0;i<grille_frappe.length;i++) {
			for(int j=0;j<grille_frappe.length;j++) {
				if(this.grille_frappe[i][j]==null) System.out.print(" . ");
				if(grille_frappe[i][j]==False) System.out.print(ColorUtil.colorize(" x ", ColorUtil.Color.WHITE));
				if(this.grille_frappe[i][j]==True) System.out.print(ColorUtil.colorize(" x ", ColorUtil.Color.RED));
				
				
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
		switch(ship.orientation) {
		case NORTH :
			{
			boolean test = true;
			int n = x-ship.taille+1;
			if (n<0) System.out.println("Longueur du bateau est grande");
			else {
				int i=n;
				while(i<x+1) {
					if(this.grille_navire[i][y]!=null) {
						System.out.println("Position occupée");
						test=false;
						break;
						}
					i++;
					}
				i=n;
				ShipState s = new ShipState();
				s.ship=ship;
				while(i<x+1 && test) {
					this.grille_navire[i][y]=s;
					i++;
					}
				}
			break;
			}
		case EAST :
			{
			boolean test = false;
			int n = y+ship.taille-1;
			if (n>this.getSize()-1) System.out.println("Longueur du bateau est grande");
			else {
				int i=y;
				
				while(i<n+1) {
					if(this.grille_navire[x][i]!=null) {
						System.out.println("Position occupée");
						test=false;
						break;
						}
					i++;
					}
				i=y;
				ShipState s = new ShipState();
				s.ship=ship;
				while(i<n+1 && test) {
					this.grille_navire[x][i]=s;
					i++;
					}
				}
			break;
			}
		case WEST :
		{
			boolean test = true;
		int n = y-ship.taille+1;
		if (n<0) System.out.println("Longueur du bateau est grande");
		else {
			int i=n;
			while(i<y+1) {
				if(this.grille_navire[x][i]!=null) {
					System.out.println("Position occupée");
					test=false;
					break;
					}
				i++;
				}
			i=n;
			ShipState s = new ShipState();
			s.ship=ship;
			while(i<y+1 && test) {
				this.grille_navire[x][i]=s;
				i++;
				}
			}
		break;
		}
		case SOUTH :
		{
		boolean test = true;
		int n = x+ship.taille-1;
		if (n>this.getSize()-1) System.out.println("Longueur du bateau est grande");
		else {
			int i=x;
			while(i<n+1) {
				if(this.grille_navire[i][y]!=null) {
					System.out.println("Position occupée");
					test=false;
					break;
					}
				i++;
				}
			i=n;
			ShipState s = new ShipState();
			s.ship=ship;
			while(i<n+1 && test) {
				this.grille_navire[i][y]=s;
				i++;
				}
			}
		}
		default:
			break;
		
		
		
		}
		
	}

	@Override
	public boolean hasShip(int x, int y) {
		if(this.grille_navire[x-1][y-1]!=null) return true;
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
