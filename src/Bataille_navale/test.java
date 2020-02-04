package Bataille_navale;

public class test {

	public static void main(String[] args) {
		Board b=new Board("nn",10);
		Destroyer ship = new Destroyer(Orientation.NORTH); 
		b.putShip(ship,3,1);
		b.print();
		
		
		
		

	}

}
