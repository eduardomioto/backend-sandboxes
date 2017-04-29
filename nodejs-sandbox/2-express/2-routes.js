var request = require('request');
var url = require('url');
var express = require('express');
var app = express();


app.get('/tweets/:username', function (req, response) {
    var username = req.params.username;
    options = {
        protocol: "http:",
        host: 'api.twitter.com',
        pathname: '/1/statuses/user_timeline.json',
        query: {
            screen_name: username,
            count: 10
        }
    }

    var twitterUrl = url.format(options);
    request(twitterUrl).pipe(response);
});

app.listen(8080);