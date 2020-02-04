package Bataille_navale;


public abstract class AbstractShip {
	protected char label ;
	protected String name ;
	protected int taille ;
	protected Orientation orientation ;
	
	
	/* Getters and Setters*/
	
	
	public char getLabel() {
		return label;
	}
	public void setLabel(char label) {
		this.label = label;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getTaille() {
		return taille;
	}
	public void setTaille(int taille) {
		this.taille = taille;
	}
	public Orientation getOrientation() {
		return orientation;
	}
	public void setOrientation(Orientation orientation) {
		this.orientation = orientation;
	}
	/* Constructeur value*/
	public AbstractShip(String nom, char label, int taille ,Orientation o)
	{
		this.name= nom ;
		this.label=label ;
		this.orientation=o;
		this.taille=taille ;
		
	}
}
