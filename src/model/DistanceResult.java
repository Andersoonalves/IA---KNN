package model;

public class DistanceResult implements Comparable<DistanceResult> {

	private Person p1;
	private Person p2;
	private double distance;

	public DistanceResult(Person p1, Person p2, double distance) {
		this.p1 = p1;
		this.p2 = p2;
		this.distance = distance;
	}

	public Person getP1() {
		return p1;
	}

	public void setP1(Person p1) {
		this.p1 = p1;
	}

	public Person getP2() {
		return p2;
	}

	public void setP2(Person p2) {
		this.p2 = p2;
	}

	public double getDistance() {
		return distance;
	}

	public void setDistance(int distance) {
		this.distance = distance;
	}

	@Override
	public int compareTo(DistanceResult otherDistanceResult) {
		if (otherDistanceResult.getDistance() > this.distance)
			return -1;
		else if (otherDistanceResult.getDistance() == this.distance)
			return 0;
		return 1;
	}

}
