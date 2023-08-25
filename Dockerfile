FROM jeanblanchard/java:8

COPY target/BookAppCrudDemo-0.0.1-SNAPSHOT.jar BookAppCrudDemo-0.0.1-SNAPSHOT.jar

CMD java -jar BookAppCrudDemo-0.0.1-SNAPSHOT.jar
