package ashok.recursive;

public class Recursive {

	public void reverseString(String string)
	{
		if(string != null && string.length() > 1)
			reverseString(string.substring(1));
		if(string != null)
			System.out.print(string.substring(0, 1));
	}

	public void wordCount(String string)
	{
		String[] arr = string.split(" ");
	}
	
	public static void main(String[] args) {
		new Recursive().reverseString("Ashok Kumar Dhulipalla");
	}
}
