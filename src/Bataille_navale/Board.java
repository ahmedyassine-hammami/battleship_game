package Bataille_navale;

public class Board implements IBoard {
	
	protected String name;
	public ShipState[][] grille_navire;
	public Boolean[][] grille_frappe;
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
		
		for(int i=0;i<grille_frappe.length;i++) {
			for(int j=0;j<grille_frappe.length;j++) {
				
			}
				
	
	}}
	/* Constructor with default size */
	public Board(String nom) {
		this(nom,10);
	}
	
	
	
	public void set() {
		Boolean False = new Boolean(false);
		this.grille_frappe[1][1]=False;
	}
	
	/* print method */
	public void print() {
		System.out.println();
		System.out.println("Ships : ");
		System.out.println();
		System.out.print("    ");
		for (int l =0;l<grille_navire.length;l++) {
			char c =(char)(65+l);
			System.out.print(" "+c+" ");
		}
		System.out.println();
		
		for(int i=0;i<grille_navire.length;i++) {
			if (i<grille_navire.length-1) System.out.print((i+1)+" | ");
			else System.out.print((i+1)+"| ");
			
			for(int j=0;j<grille_navire.length;j++) {
				if(this.grille_navire[i][j]==null) System.out.print(" . ");
				else System.out.print(" "+this.grille_navire[i][j].ship.label+" ");
			}
			System.out.println();
		}
		System.out.println();
		Boolean True = new Boolean(true);
		System.out.println("Hits : ");
		System.out.println();
		System.out.print("    ");
		for (int l =0;l<grille_navire.length;l++) {
			char c =(char)(65+l);
			System.out.print(" "+c+" ");
		}
		System.out.println();
		
		for(int i=0;i<grille_frappe.length;i++) {
			if (i<grille_frappe.length-1) System.out.print((i+1)+" | ");
			else System.out.print((i+1)+"| ");
			for(int j=0;j<grille_frappe.length;j++) {
				
				if(grille_frappe[i][j]==null) System.out.print(" . ");
				else {
					if(this.grille_frappe[i][j].booleanValue()==true) System.out.print(ColorUtil.colorize(" x ", ColorUtil.Color.RED));
					else System.out.print(ColorUtil.colorize(" x ", ColorUtil.Color.WHITE));
				}
	
			}
			System.out.println();
		}
	}

	@Override
	public int getSize() {
		return this.grille_navire.length;
	}

	@Override
	public void putShip(AbstractShip ship, int x, int y) throws ExceptionShipPosition {
		x--;
		y--;
		switch(ship.orientation) {
		case NORTH :
			{
			boolean test = true;
			int n = x-ship.taille+1;
			if (n<0) 
				throw new ExceptionShipPosition("Size of ship is big");
			else {
				int i=n;
				while(i<x+1) {
					if(this.grille_navire[i][y]!=null) {
						test=false;
						throw new ExceptionShipPosition("Occuped position, Can't put the ship");
						}
					i++;
					}
				i=n;
				
				while(i<x+1 && test) {
					ShipState s = new ShipState();
					s.ship=ship;
					this.grille_navire[i][y]=s;
					i++;
					}
				}
			break;
			}
		case EAST :
			{
			boolean test = true;
			int n = y+ship.taille-1;
			if (n>this.getSize()-1) 
				throw new ExceptionShipPosition("Size of ship is big");
			else {
				int i=y;
				
				while(i<n+1) {
					if(this.grille_navire[x][i]!=null) {
						test=false;
						throw new ExceptionShipPosition("Occuped position, Can't put the ship");
						}
					i++;
					}
				i=y;
				
				while(i<n+1 && test) {
					ShipState s = new ShipState();
					s.ship=ship;
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
		if (n<0) 
			throw new ExceptionShipPosition("Size of ship is big");
		else {
			int i=n;
			while(i<y+1) {
				if(this.grille_navire[x][i]!=null) {
					test=false;
					throw new ExceptionShipPosition("Occuped position, Can't put the ship");
					}
				i++;
				}
			i=n;
			
			while(i<y+1 && test) {
				ShipState s = new ShipState();
				s.ship=ship;
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
		if (n>this.getSize()-1) 
			throw new ExceptionShipPosition("Size of ship is big");
		else {
			int i=x;
			
			while(i<n+1) {
				if(this.grille_navire[i][y]!=null) {
					test=false;
					throw new ExceptionShipPosition("Occuped position, Can't put the ship");
					}
				i++;
				}
			i=x;
			
			while(i<n+1 && test) {
				ShipState s = new ShipState();
				s.ship=ship;
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
		if(this.grille_navire[x-1][y-1]!=null&&this.grille_navire[x-1][y-1].isSunk()) 
			return false;
		return true;
	}

	@Override
	public void setHit(boolean hit, int x, int y) {
		this.grille_frappe[x-1][y-1]=hit;
		
	}

	@Override
	public Boolean getHit(int x, int y) {
		return this.grille_frappe[x-1][y-1];
	}

	@Override
	public Hit sendHit(int x, int y) throws Exception {
		Hit hit = null ;
		Boolean False = new Boolean("False");
		Boolean True = new Boolean("True");
		 
		if(grille_frappe[x-1][y-1]==null) {

			if(grille_navire[x-1][y-1]==null) {
				grille_frappe[x-1][y-1]=False;
				return Hit.MISS ;
				}
			if(grille_navire[x-1][y-1]!=null) {
				grille_frappe[x-1][y-1]=True;
				grille_navire[x-1][y-1].addStrike();
				hit=Hit.STIKE;
				}
			if(grille_navire[x-1][y-1].isSunk()) {
				hit = Hit.fromInt(grille_navire[x-1][y-1].ship.getTaille());
			}
		}
		
		else {
			hit = Hit.MISS ;
			throw new Exception("Position déja frappée");	
		}
		
		
		
		
		


		return hit ;
	}
	

	

	
}
