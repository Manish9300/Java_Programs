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
	int voter_id;
	Voter(String n, int a, int vid) {
		name = n;
		age = a;
		voter_id = vid;
	}
	void voter_validator() throws InvalidVoterAgeException {
		if(this.age>=18 && this.age<=135) {
			System.out.println(this.name + " can vote. Valid age.\n");
		} else {
			throw new InvalidVoterAgeException(this.age);
		}
	}
}
class Election3 {
	static boolean checkValid(int vid, Voter arr[]) {
		int i = 0;
		int flag = 0;
		for (i=0; i<arr.length; i++) {
			if(arr[i].voter_id == vid) {
				flag = 1;
				break;
			}
		}
		if(flag == 1) {
			System.out.println("Voter Found");
			System.out.println("Voter is "+ arr[i].name);
			try {
				arr[i].voter_validator();
			} catch (InvalidVoterAgeException e) {
				System.out.println("InvalidVoterAgeException occurred : " + arr[i].name + " " + e);
				System.out.println();
			}
			return true;
		} else {
			return false;
		}
	}
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
			System.out.print("Enter voter id: ");
			int vid = Integer.parseInt(br.readLine());
			ob[i] = new Voter(n,a,vid);
		}
		System.out.print("Enter voter id to check validation: ");
		int n = Integer.parseInt(br.readLine());
		if(!(checkValid(n, ob))) {
			System.out.println("Voter Not Found");
		}	
	}
}

/*
OUTPUT:

C:\manish\19 SEPT 24>javac Election3.java

C:\manish\19 SEPT 24>java Election3
Enter number of applicants: 5
Enter voter name: Manish
Enter voter age: 18
Enter voter id: 10001
Enter voter name: Tom
Enter voter age: 190
Enter voter id: 10002
Enter voter name: Jerry
Enter voter age: 7
Enter voter id: 10003
Enter voter name: Max
Enter voter age: 23
Enter voter id: 10004
Enter voter name: Alex
Enter voter age: 10
Enter voter id: 10005
Enter voter id to check validation: 10003
Voter Found
Voter is Jerry
InvalidVoterAgeException occurred : Jerry cannot vote due to age : 7 which is invalid.


C:\manish\19 SEPT 24>java Election3
Enter number of applicants: 5
Enter voter name: Manish
Enter voter age: 18
Enter voter id: 10001
Enter voter name: Tom
Enter voter age: 190
Enter voter id: 10002
Enter voter name: Jerry
Enter voter age: 7
Enter voter id: 10003
Enter voter name: Max
Enter voter age: 23
Enter voter id: 10004
Enter voter name: Alex
Enter voter age: 10
Enter voter id: 10005
Enter voter id to check validation: 10002
Voter Found
Voter is Tom
InvalidVoterAgeException occurred : Tom cannot vote due to age : 190 which is invalid.


C:\manish\19 SEPT 24>java Election3
Enter number of applicants: 5
Enter voter name: Manish
Enter voter age: 18
Enter voter id: 10001
Enter voter name: Tom
Enter voter age: 190
Enter voter id: 10002
Enter voter name: Jerry
Enter voter age: 7
Enter voter id: 10003
Enter voter name: Max
Enter voter age: 23
Enter voter id: 10004
Enter voter name: Alex
Enter voter age: 10
Enter voter id: 10005
Enter voter id to check validation: 10010
Voter Not Found

*/