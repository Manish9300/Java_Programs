import java.io.*;
class InvalidVoterAgeException extends Exception {
	private int age;
	InvalidVoterAgeException(int a) {
		age = a;
	}
	public String toString() {
		return "cannot vote due to age : "+age +" which is invalid.";
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
			System.out.println(this.name + " can vote. Valid age.\n");
		} else {
			throw new InvalidVoterAgeException(this.age);
		}
	}
}
class ElectionNew {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int i=0;
		System.out.print("Enter number of applicants: ");
		int num = Integer.parseInt(br.readLine());
		Voter ob[] = new Voter[num];
		for(i=0; i<num; i++) {
			System.out.print("Enter voter name: ");
			String n = br.readLine();
			System.out.print("Enter voter age: ");
			int a = Integer.parseInt(br.readLine());
			ob[i] = new Voter(n,a);
		}
		System.out.println("Displaying information:\n");
		for(i=0; i<num; i++) {
			System.out.println("Voter Name: "+ob[i].name);
			System.out.println("Voter age: "+ob[i].age);
			System.out.println();
		}
		for(i=0; i<num; i++) {
			try {
				ob[i].voter_validator();	
			} catch(InvalidVoterAgeException e) {
				System.out.println("InvalidVoterAgeException occurred : " + ob[i].name + " " + e);
				System.out.println();
			}
		}
	}
}

/*

OUTPUT:

C:\manish\19 SEPT 24>javac ElectionNew.java

C:\manish\19 SEPT 24>java ElectionNew
Enter number of applicants: 7
Enter voter name: Manish
Enter voter age: 18
Enter voter name: Alex
Enter voter age: 7
Enter voter name: Max
Enter voter age: 190
Enter voter name: Tom
Enter voter age: 10
Enter voter name: Jerry
Enter voter age: 145
Enter voter name: George
Enter voter age: 56
Enter voter name: John
Enter voter age: 12
Displaying information:

Voter Name: Manish
Voter age: 18

Voter Name: Alex
Voter age: 7

Voter Name: Max
Voter age: 190

Voter Name: Tom
Voter age: 10

Voter Name: Jerry
Voter age: 145

Voter Name: George
Voter age: 56

Voter Name: John
Voter age: 12

Manish can vote. Valid age.

InvalidVoterAgeException occurred : Alex cannot vote due to age : 7 which is invalid.

InvalidVoterAgeException occurred : Max cannot vote due to age : 190 which is invalid.

InvalidVoterAgeException occurred : Tom cannot vote due to age : 10 which is invalid.

InvalidVoterAgeException occurred : Jerry cannot vote due to age : 145 which is invalid.

George can vote. Valid age.

InvalidVoterAgeException occurred : John cannot vote due to age : 12 which is invalid.

*/