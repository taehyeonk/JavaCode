package exam01;

public class Earth {
	static final double EARTH_RADIUS = 6400;
	static final double EARTH_SURFAC_AREA;
	
	static {
		EARTH_SURFAC_AREA = 4 * Math.PI * EARTH_RADIUS * EARTH_RADIUS;
	}
}
