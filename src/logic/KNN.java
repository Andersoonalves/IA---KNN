package logic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import model.DistanceResult;
import model.Person;
import solve.SupervisedMachineLearning;

public class KNN implements SupervisedMachineLearning {
	private List<Person> results = new ArrayList<Person>();

	public List<Person> getResults() {
		return Collections.unmodifiableList(results);
	}

	public static byte K = 5;

	// classifica uma pessoa (sobreviveu ou noo)
	public Person solve(Person newPersonToBeClassifield) {
		if (!(this.results.size() == 0)) {
			List<Person> kpersons = this.getDistance(newPersonToBeClassifield);
			int survived = 0;
			for (Person p : kpersons) {
				if (p.isSurvived()) {
					survived++;
				}
			}
			if (survived > Math.floor(kpersons.size() / 2)) {
				newPersonToBeClassifield.setSurvived(true);
			} else
				newPersonToBeClassifield.setSurvived(false);

		}
		return newPersonToBeClassifield;
	}

	private List<Person> getDistance(Person newPerson) {
		List<DistanceResult> distanceResults = new ArrayList<DistanceResult>();

		for (Person listPerson : this.results) {
			double distance;
			double firstSquare = Math.pow(
					(newPerson.getAge() - listPerson.getAge()), 2);
			double secondSquare = Math.pow(
					newPerson.getPclass() - listPerson.getPclass(), 2);
			distance = Math.sqrt(firstSquare + secondSquare);

			DistanceResult distanceResult = new DistanceResult(newPerson,
					listPerson, distance);
			distanceResults.add(distanceResult);
		}

		Collections.sort(distanceResults);
		List<Person> kPersons = new ArrayList<Person>();

		for (int i = 0; i < K; i++)
			kPersons.add(distanceResults.get(i).getP2());
		return kPersons;
	}

	public void addPerson(Person person) {
		this.results.add(person);
	}

	public void removePerson(Person person) {
		this.results.remove(person);
	}
}
