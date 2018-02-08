package example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;

@RestController
@SpringBootApplication
@EnableAutoConfiguration
public class SengApplication {

	@Autowired
	private Storage storage;

	@RequestMapping(value = "/search/{term}", method=RequestMethod.GET, produces = "application/json")
    public @ResponseBody ArrayList<Occurrence> search( @PathVariable( "term" ) final String word, final HttpServletRequest request, final HttpServletResponse response) {
        response.setStatus( 200 );
	    return storage.getWordByValue(word);
	}

	@RequestMapping( value = "/add/{word}", method = RequestMethod.POST )
	@ResponseBody
	Boolean add(String word) {
		return storage.addWordByValue( word );
	}

	@RequestMapping( value = "/remove/{word}", method = RequestMethod.DELETE )
	Boolean remove(String word) {
		return storage.removeWordByValue( word );
	}

	public static void main(String[] args) {
		SpringApplication.run(SengApplication.class, args);
	}
}
