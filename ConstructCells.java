class ConstructCells {
	/* In a regular hexagon, the radius and side are equal */
	static double radius = 2.0;
	/* Center coordinates of the radius */
	static double centerCoordinates[] = {0, 0};
	
	/* Angle calculation for horizontal and verticals */
	static double horizontal = radius*Math.sin(Math.toRadians(60));
	static double vertical =  radius*Math.sin(Math.toRadians(30));

	public static void main(String args[]){
		
		double  carCoordinates[][]	= {
									   {1 , 1},
									   {0 , 1.2},
									   {-2.3 , 0},
									   {0.77 , 0.76},
									   {1 , 1.2}, 
									   {1.73205080, 0},
									   {0 , 1.73205080},
									   {0 , -1.73205080},
									   {-1.73205080, 0},
									   {-0.8320508075688772, 0},
									   {-1.73205080, 0.9},
									  };
		for(int i = 0; i < 11; i++){
			for(double x: carCoordinates[i]){
				System.out.print(x + " and ");
			}
			
			if(ConstructCells.isInside(carCoordinates[i])){
				
				
				System.out.println("lie inside the hexagon.");
			} else{
				System.out.println("lie outside the hexagon.");
			
		  }
		}
	}
	
	double calculateDistance(double point1[], double point2[]){
		
		if(point1.length==0 || point2.length ==0) return 0.0;
		double distance = Math.pow(Math.pow(point1[0]-point2[0],2) +
									Math.pow(point1[1]-point2[1],2), 0.5);
		return distance;
	}
	
	
	
	static boolean isInside(double point1[]){
		double x_c =  Math.abs(ConstructCells.centerCoordinates[0] - point1[0]);
		double y_c =  Math.abs(ConstructCells.centerCoordinates[1] - point1[1]);
		if(x_c > horizontal || y_c > vertical*2) return false; 
		
		/* Dot product */
	return ((2*vertical*horizontal - vertical*x_c *horizontal*y_c) >=0);
	}

}