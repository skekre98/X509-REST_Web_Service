package web.skekre.sslserver;

import java.security.Principal;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.ResponseBody;

@RestController
public class ServerController {
	
	@PreAuthorize("hasAuthority('ROLE_USER')")
    @RequestMapping(value = "/secured", method = {RequestMethod.GET, RequestMethod.POST}, consumes = {"application/json"}, produces = {"application/json"})
	@ResponseBody
    public ResponseEntity<String> secured(@RequestBody Message m) {
    	
        String accountID = "999\n";

        if (m.getDid() == 1) {
          accountID = "101\n";
        } else if (m.getDid() == 2) {
          accountID = "102\n";
        } else if (m.getDid() == 3) {
          accountID = "103\n";
        } else if (m.getDid() == 4) {
          accountID = "104\n";
        } else if (m.getDid() == 5) {
          accountID = "105\n";
        } 

        return new ResponseEntity<String>(accountID, HttpStatus.OK);

    }
								
    
	@PreAuthorize("hasAuthority('ROLE_USER')")	
    @RequestMapping(value = "/user")
    public ResponseEntity<String> user(Model model, Principal principal) {
        UserDetails currentUser = (UserDetails) ((Authentication) principal).getPrincipal();
        model.addAttribute("username", currentUser.getUsername());
        Car car = new Car();
        car.setColor("red");
        car.setMiles(15);
        return new ResponseEntity<String>("Client Certificate Verified!", HttpStatus.OK);
    }
    
}
