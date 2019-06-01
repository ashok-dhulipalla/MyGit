package ashok.recursive;

import java.util.HashMap;
import java.util.Map;

public class ReverseString {

	public String reverseString(String string)
	{
		if(string.isEmpty())
			return string;
		return reverseString(string.substring(1)) + string.charAt(0);
	}
	
	public static void main(String[] args) {
		System.out.println(new ReverseString().reverseString("Thank you for watching. Please like and share."));
	}
}
