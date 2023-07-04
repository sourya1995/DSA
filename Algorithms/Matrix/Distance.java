package Algorithms.Matrix;

import java.util.ArrayList;

class Point {
	private int x;
	private int y;

	Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

	int getX() {
		return x;
	}

	void setX(int x) {
		this.x = x;
	}

	int getY() {
		return y;
	}

	void setY(int y) {
		this.y = y;
	}

    double calculateDistance(Point p) {
        double distance;
        distance = Math.sqrt(Math.pow((p.x - this.x), 2) + Math.pow((p.y - this.y), 2));
        return distance;
    }

    double calculateSumOfDistances(ArrayList<Point> points) {
        double distanceSum;
        distanceSum = 0;
        for(int i = 0; i < points.size(); i++) {
            distanceSum += this.calculateDistance(points.get(i));
        }
        return distanceSum;
    }
};

public class Distance {
    public static Point shortestDistanceTravelled(int gridSize, ArrayList<Point> startingPoints){
        Point currentPoint = new Point(0, 0);
        Point minPoint = new Point(0, 0);

        double minDistance = currentPoint.calculateSumOfDistances(startingPoints);
        double distance;

        for(int i = 0; i< gridSize; i++){
            for(int j = 0; j < gridSize; j++){
                currentPoint.setX(i);
                currentPoint.setY(j);

                distance = currentPoint.calculateSumOfDistances(startingPoints);

                if(distance < minDistance){
                    minDistance = distance;
                    minPoint.setX(currentPoint.getX());
                    minPoint.setY(currentPoint.getY());
                }
            }
        }
        return minPoint;
    }
}
