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

###### Running

- 0-hello-world.go
```shell
go run hello-world.go
go build hello-world.go
./hello-world
```

- 1-values.go
```shell
go run values.go
```

- 2-variables.go
```shell
go run variables.go
```

- 3-constants.go
```
go run constant.go 
```

- 4-for.go
```
go run for.go 
```


###### Reference
- [1] https://gobyexample.com/
- [2] https://github.com/golang/example
- [3] https://devcenter.heroku.com/articles/go-dependencies-via-godep
- [4] https://devcenter.heroku.com/articles/go-websockets
- [5] https://devcenter.heroku.com/articles/que-go
- [7] https://code.tutsplus.com/categories/go 
- [8] https://golang.org/ref/spec
- [9] https://golang.org/doc/go1.7
