// Include http module, 
var http = require("http");

// Create the server. 
http.createServer(function (request, response) { 
	
    
    //Set the Http Code to this response
    response.writeHead(200); 
    
    //Set the response content
    response.write("Hello, this is a basic web application"); 

    // Send data and end response. 
	response.end(); 
    
    
// Listen on the 8080 port. 
}).listen(8080);

console.log("Listening on port 8080...");