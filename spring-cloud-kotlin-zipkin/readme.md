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
or the commands manually within this script. 

---

You can open up the relevant urls for the demo using:
```bash
./openUrls.sh
```

---

And finally when you are finished you can clean your local env up using:
```bash
docker-compose -f docker-compose.yml down
```