// Include http module, 
var http = require("http");

// Create the server. 
http.createServer(function (request, response) { 
	//Set the Http Code to this response
    response.writeHead(200); 
    
    //Set the response content
    response.write("Hello, this is a basic web application. "); 
    
    //Representing a Long Running Process
    setTimeout(function(){
        
        response.write("Done! "); 
        
        // Send data and end response. 
        response.end(); 
        
    // 5000 milliseconds (5 seconds)    
    }, 5000);

    
    
// Listen on the 8080 port. 
}).listen(8080);

console.log("Listening on port 8080...");