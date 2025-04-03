## Run this command to create a Docker image
```sh
docker build <project path> -t <username>/<microservice name>:<any identifier>
# Example:
docker build . -t rudrapratapg/accounts:s4
```

## Run this command to list Docker images
```sh
docker images
```

## Run this command to remove a Docker image
```sh
docker rmi <image id>
```

## Run this command to run the Docker image, -p means port mapping
### container port: Container is going to start at port 8080
### host port: Please expose the container to the outside of docker network at port 8080
```sh
docker run -p <host port>:<container port> <username>/<microservice name>:<any identifier>
# Example:
# Container is going to start at port 8080
docker run -p 8080:8080 rudrapratapg/accounts:s4
```

### To run the container in detached mode add -d
```sh
docker run -d -p 8080:8080 rudrapratapg/accounts:s4
```
## Run this command to list all running containers
```sh
docker ps
```

## Run this command to list all containers
```sh
docker ps -a
```

## Run this command to stop a running container
```sh
docker stop <container id>
# Example:
docker stop 1a2b3c4d5e6f
```

## Run this command to start an existing container
```sh
docker start <container id>
# Example:
docker start 1a2b3c4d5e6f
```

## Run this command to remove a container
```sh
docker rm <container id>
# Example:
docker rm 1a2b3c4d5e6f
```