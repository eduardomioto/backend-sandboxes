var foo = function(){
    console.log("foo!");
}

var bar = function(){
    console.log("bar!");
}

var baz = function(){
    console.log("baz!");
}

//Make the function public
modules.exports = foo;
modules.exports = bar;
