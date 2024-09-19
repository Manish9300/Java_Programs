import java.io.*;
class NoMatchFoundException extends Exception {
	private String str;
	NoMatchFoundException(String s) {
		str = s;
	}
	public String toString() {
		return str + " not found.";
	}
}
class ExceptionDemo {
	static void search_city(String str, String arr[]) throws NoMatchFoundException {
		int i = 0;
		System.out.println("Called search_city("+ str + ")");
		int flag = 0;
		for (i=0; i<arr.length; i++) {
			if(arr[i].equalsIgnoreCase(str)) {
				flag = 1;
				break;
			}
		}
		if(flag == 1) {
			System.out.println("City found in array.");
		} else {
			throw new NoMatchFoundException(str);
		}
	}
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("Enter number of cities : ");
		int num = Integer.parseInt(br.readLine());
		String city_name[] = new String[num];
		int i = 0;
		for (i=0; i<num; i++) {
			System.out.print("Enter city name: ");	
			city_name[i] = br.readLine();
		}
		System.out.print("Cities: ");
		for(i=0; i<city_name.length; i++) {
			System.out.print(city_name[i] + " ");
		}
		System.out.print("\nEnter city to search: ");
		String city = br.readLine();
		try {
			search_city(city, city_name);
		} catch(NoMatchFoundException e) {
			System.out.println("NoMatchFoundException occured: " + e);
		}
	}
}































