var http = require("http");
var fs   = require("fs");

http.createServer(function (request, response) { 
	
    var newFile = fs.createWriteStream('README-copy.md'); 
    file.pipe(newFile);
    
    request.on('end', function(){
       response.end('uploaded'); 
    });
    
// Listen on the 8080 port. 
}).listen(8080);

//Running: curl --upload-file readme.md http://localhost:8080/
