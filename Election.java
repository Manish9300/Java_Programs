import java.io.*;
class InvalidVoterAgeException extends Exception {
	private int age;
	InvalidVoterAgeException(int a) {
		age = a;
	}
	public String toString() {
		return "The voter cannot vote due to age : "+age +" which is invalid.";
	}
}
class Voter {
	String name;
	int age;
	Voter(String n, int a) {
		name = n;
		age = a;
	}
	void voter_validator() throws InvalidVoterAgeException {
		if(this.age>=18 && this.age<=135) {
			System.out.println("Voter can vote. Valid age.");
		} else {
			throw new InvalidVoterAgeException(this.age);
		}
	}
}
class Election {
	public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("Enter voter name: ");
		String name = br.readLine();
		System.out.print("Enter voter age: ");
		int age = Integer.parseInt(br.readLine());
		Voter ob = new Voter(name,age);
		try {
			ob.voter_validator();
		} catch(InvalidVoterAgeException e) {
			System.out.println("InvalidVoterAgeException occurred : " + e);
		}
	}
}