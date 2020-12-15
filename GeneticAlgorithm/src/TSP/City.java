package TSP;

public class City {
	private int label;
	private double x;
	private double y;
	public City(int label, int x, int y) {
		this.label = label;
		this.x = x;
		this.y = y;
	}
	public double distanceTo(City that) {
		return Math.sqrt(Math.pow(x - that.x, 2) + Math.pow(y - that.y, 2));
	}
	public int getLabel() {
		return label;
	}
	public double getX() {
		return x;
	}
	public double getY() {
		return y;
	}
	
	
}
