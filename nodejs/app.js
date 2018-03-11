var express=require('express');
var app=express();
var bodyParser=require('body-parser');
var http = require('http');
app.set('port',process.env.PORT||2220);
app.use(bodyParser.urlencoded({extended:true}));
app.use(bodyParser.json());
var register_modules=require('./module/register');
app.post('/account/resister/signup',function (req,res) {
    var email=req.body.email;
    var pwd=req.body.pwd;
    console.log(email+":"+pwd);
    register_modules.register(email,pwd,function (err,result) {
       if(err){
           console.log(err);
           res.send(400);
       }
       if(result=='good'){
           console.log("성공");
           res.send(200);
       }
       else if(result==null){
           res.send(404);
           console.log("회원가입 실패");
       }
    });
});

app.listen(app.get('port'), function () {
    console.log('Create Server, Port is '+app.get('port'));

});