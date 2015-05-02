package action;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class IndexController {

    @RequestMapping(method = RequestMethod.GET)
	public String index() {
		return "login";
	}

    @RequestMapping(method = RequestMethod.GET,value = "about")
    public String about(){
        return "about";
    }

    @RequestMapping(value = "error",method = {RequestMethod.GET,RequestMethod.POST})
    public String error(){
        return "error";
    }
}