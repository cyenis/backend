#!/usr/bin/env bash

mvn clean install -DskipTests

docker build -t adidas/backend:latest .

docker run -p 8080:8080 adidas/backend:latest

