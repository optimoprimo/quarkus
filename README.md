# Proyecto de Prueba para despliegues openshift

## Estrategia docker

````cmd
    oc new-app --name=ejemplo-quarkus --code=https://github.com/optimoprimo/quarkus
````

## Estrategia source

````cmd
    oc import-image openjdk-17:1.11 --from registry.access.redhat.com/ubi8/openjdk-17:1.11 --confirm
    oc new-app --name=ejemplo-quarkus --code=https://github.com/optimoprimo/quarkus --strategy=source -i=openjdk-17:1.11
````

## Mediante libreria de openshift

````cmd
    mvn clean package -D"quarkus.kubernetes.deploy"=true -D"quarkus.kubernetes-client.master-url"=SERVER -D"quarkus.kubernetes-client.token"=TOKEN
````