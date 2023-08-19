#!/bin/sh
docker build . -t mykeycloak &&
docker run --name mykeycloak -p 8443:8443 \
        -e KEYCLOAK_ADMIN=eazybank -e KEYCLOAK_ADMIN_PASSWORD=test \
        mykeycloak \
        start-dev