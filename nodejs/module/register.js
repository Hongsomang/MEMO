var express=require('express');
var mysql=require('mysql');
var sql=require('./db');
var connetion=mysql.createConnetion(sql);
module.exports=function (email,pwd) {
    connetion.connect();
    connetion.query('insert into user(email,pwd) values (?,?)',[email,pwd],function (err,row) {
        if(err){
            console.log(err);
            res.status(400).send({
                err:err
            });
            res.end();
        }
        else {
            console.log("signin:"+rows);
            res.status(201)
                .end("send");

        }

    });
}