var fs = require('fs');
var http = require("http");

http.createServer(function (request, response) { 

    var file    = fs.createReadStream('README.md');

    response.writeHead(200); 
    
    file.on('readable', function(){
      var chunk = null;
      while(null !== (chunk = file.read())){
          console.log(chunk.toString());   
      };  
    });
    
    response.on('end', function(){
        response.end();
    });
    
// Listen on the 8080 port. 
}).listen(8080);

console.log("Listening on port 8080...");