
public class Vector2D {
	private double x, y;
	
	public Vector2D(double x, double y) {
		this.x = x;
		this.y = y;
	}
	
	public void add(Vector2D other) {
		x += other.x;
		y += other.y;
	}
	
	public void sub(Vector2D other) {
		x -= other.x;
		y -= other.y;
	}
	
	public void mult(double scale) {
		x *= scale;
		y *= scale;
	}
	
	public void div(double scale) {
		x /= scale;
		y /= scale;
	}
	
	public static Vector2D cross(Vector2D a, Vector2D b) {
		
	}
	
	public static Vector2D dot(Vector2D a, Vector2D b) {
		
	}
	
	public static double angleBetween(Vector2D a, Vector2D b) {
		
	}
}
