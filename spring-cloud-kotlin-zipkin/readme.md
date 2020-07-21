# spring-cloud-kotlin-zipkin

###### Overview: 
This application demonstrates how to set up zipkin tracing in a spring boot kotlin app.

Full blog post: <TODO>

###### Pre-req:
- The ability to run a kotlin application (IDE or CMD Line)
- Maven
- Docker compose  ([docs](https://docs.docker.com/compose/install/))

###### Quick start:

The demo creates three docker containers. A Zipkin server to receive tracing data 
and two mockserver apis to mock out downstream services. 

To create and run the docker containers you can use:
```bash
docker-compose -f docker-compose.yml up -d
```

---

You can open up the relevant urls for the demo using:
```bash
./openUrls.sh
```
Or just copy the links into your browser 

---

BONUS: use apache bench mark to fill up zipkin with some spans
```bash
 ab -n 500 -c 200 "http://localhost:8080/tax?name=michael"
```

---

And finally when you are finished you can clean your local env up using:
```bash
docker-compose -f docker-compose.yml down
```