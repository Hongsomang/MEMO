var http = require('http'); http.createServer(function (req, res) { res.writeHead(200, {'Content-Type': 'text/plain'}); res.end('Hello World\n'); }).listen(8000, '10.156.145.1'); //서버 아이피와 포트번호를 알맞게 설정 
console.log('Server running at http://127.0.0.1:8000/'); 

