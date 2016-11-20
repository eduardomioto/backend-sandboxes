var http = require("http");
var fs   = require("fs");

http.createServer(function (request, response) { 
	
    var file    = fs.createReadStream('README.md');
    var newFile = fs.createWriteStream('README-copy.md'); 
    file.pipe(newFile);
    
    response.writeHead(200); 
    //Dp the same logic of previous file but much shorter. Prefer use pipe in readable events.
    request.pipe(response);
    
// Listen on the 8080 port. 
}).listen(8080);



console.log("Listening on port 8080...");