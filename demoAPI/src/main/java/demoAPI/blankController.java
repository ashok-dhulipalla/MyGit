package demoAPI;

//import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class blankController {
	
	@RequestMapping(value = "/{message}", method = RequestMethod.GET)
	@ResponseBody
	public String getRequest(@PathVariable(value= "message") String message)
	{
		System.out.println(message);
		return "This is Ashok Kumar Dhulipalla. Message is "+message+"\n";
	}
	
	@RequestMapping(value = "/message", method = RequestMethod.POST)
	@ResponseBody
	public String postRequest()
	{
		System.out.println("---------------------------");
		return "{\r\n" + 
				"    \"userId\": 1,\r\n" + 
				"    \"id\": 1,\r\n" + 
				"    \"title\": \"sunt aut facere repellat provident occaecati excepturi optio reprehenderit\",\r\n" + 
				"    \"body\": \"quia et suscipit\\nsuscipit recusandae consequuntur expedita et cum\\nreprehenderit molestiae ut ut quas totam\\nnostrum rerum est autem sunt rem eveniet architecto\"\r\n" + 
				"  }";
	}

}
