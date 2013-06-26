package model;

public class Person {

	private boolean survived;
	private int pclass;
	private float age;

	public Person(boolean survived, int pclass, float age) {
		this.survived = survived;
		this.pclass = pclass;
		this.age = age;
	}

	public float getAge() {
		return age;
	}

	public void setAge(float age) {
		this.age = age;
	}

	public int getPclass() {
		return pclass;
	}

	public void setPclass(int pclass) {
		this.pclass = pclass;
	}

	public boolean isSurvived() {
		return survived;
	}

	public void setSurvived(boolean survived) {
		this.survived = survived;
	}

}
