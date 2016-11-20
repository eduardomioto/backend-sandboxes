##### Introduction
- This folder will be updated soon. 
- Priority Order: [> 4]

##### Installation
- https://golang.org/doc/install
- https://storage.googleapis.com/golang/go1.7.3.windows-amd64.msi
- https://storage.googleapis.com/golang/go1.7.3.linux-amd64.tar.gz

##### Modules
```bat
set GOPATH=C:\work
::: set Go Project Path
mkdir src/github.com/user/hello
::: Create directory src/github.com/user/hello
go install github.com/user/hello
::: Compile 
%GOPATH%\bin\hello
::: Executing	
```
- basic/install.go

###### Reference
- https://code.tutsplus.com/tutorials/what-is-go--cms-21635
- https://devcenter.heroku.com/articles/go-dependencies-via-godep
- https://devcenter.heroku.com/articles/go-websockets
- https://devcenter.heroku.com/articles/que-go
