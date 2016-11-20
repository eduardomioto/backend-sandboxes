var http = require("http");

http.createServer(function (request, response) { 
	
    response.writeHead(200); 
    
    request.on('readable', function(){
        var chunk = null;
        while(null !== (chunk = request.read())){
            console.log(chunk.toString());   
        };
        
    });
    response.on('end', function(){
        response.end();
    });
    
// Listen on the 8080 port. 
}).listen(8080);

console.log("Listening on port 8080...");