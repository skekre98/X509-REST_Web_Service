# X509-REST_Web_Service
A REST Web Service that provides X509 mutual certificate authentication. This web service has an HTTPS endpoint that runs through SSL certificate verification and can recieve and output data in JSON format. The X509 is handled through Spring security and a RESTful API was used to handle the GET and POST requests for the data. The server in this case has also been modified to only allow verified clients. This application can be packaged and launched through maven with the command ```mvn spring-boot:run```. You should then be able to see your successfully run web service on [https://localhost:8443/user](https://localhost:8443/user).


## RESTful API
A RESTful API explicitly takes advantage of HTTP methodologies defined by the RFC 2616 protocol. They use GET to retrieve a resource; PUT to change the state of or update a resource, which can be an object, file or block; POST to create that resource; and DELETE to remove it.
```java
@RequestMapping(value = "/secured", method = {RequestMethod.GET, RequestMethod.POST}, consumes = {"application/json"})
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
```
Spring annotations such as @RequestMapping and @ResponseBody allow us to use REST for our designated methods.

## X509 Certificate Authentication
Allow us to verify the identity of a communication peer when using the HTTPS (HTTP over SSL) protocol.
While a secure connection is established, the client verifies the server according to its certificate (issued by a trusted certificate authority). 
