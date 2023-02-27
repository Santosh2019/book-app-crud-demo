FROM jeanblanchard/java:8

COPY target/book-crud-app.jar book-crud-app.jar

CMD java -jar book-crud-app.jar
