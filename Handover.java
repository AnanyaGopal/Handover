
class Cell{
	
	long nodeID;
	double centerLat;
	double centerLong;
	float radius;
	// In a regular hexagon, distance from center to edge = side
	// In a regular Hexagon, distance from center to Side = sqrt(3) %2 *side;
	
	double calculateArea(double side){
		
		double cellArea = (Math.pow(3, 0.5)/4)*side*side*6;
		System.out.print(cellArea);
		return cellArea;
		
	}
	
	/* Check if the cars coordinates are in a fog*/
	int checkPresence(double x, double y, int NodeID){
		
		double LatLong[] = getCenter(NodeID);
		 
		// Equation to calculate distance between two sets of points.
		double distance = Math.pow((Math.pow(LatLong[0]-x,2)+Math.pow(LatLong[1] - y, 2)),0.5);
		System.out.print(distance);
		
		if(distance < Handover.radiuss) return 1; 
		
		return 0;
	}
	
	
	/* Function that fetches Latitude Longitudes on the basis of Node IDs */
	double[] getCenter(int NodeID){
		double latLong[] = new double[2];
		try{  
			// Read file 
			while(rs.next()){ 
				System.out.println(rs.getString(1)+ "-"+rs.getString(2));
				latLong[0] = Double.parseDouble(rs.getString(1));
				latLong[1] = Double.parseDouble(rs.getString(2));
			}
			con.close();  
		}
		catch(Exception e){
			System.out.println(e);
		} 
		
		return latLong;
		
	
	}
	
}
public class Handover {

	/**
	 * @param args
	 */
	static final double radiuss = 10;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Cell C1 = new Cell();
		C1.getCenter(100);
		int presence = C1.checkPresence(32,82,100);
		if(presence == 1){
			System.out.println("Car is in Fog Node area");
		}else {
			System.out.println("Car is not in Fog Node area");
		}	
	}	

}
