const express=require('express');
const app=express();
const bodyParser=require('body-parser');
var http = require('http');
app.set('port',process.env.PORT||2220);


app.listen(app.get('port'), function () {
    console.log('Create Server, Port is '+app.get('port'));

});