package blankAPI;

//import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class blankController {
	
	@RequestMapping(value = "/{message}", method = RequestMethod.GET)
	@ResponseBody
	public String getRequest(@PathVariable(value= "message") String message)
	{
		System.out.println(message);
		return "Message is "+message+"\n";
	}

}
