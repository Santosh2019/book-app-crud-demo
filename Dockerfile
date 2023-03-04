FROM jeanblanchard/java:8

COPY target/book-app-crud-demo.jar book-app-crud-demo.jar

CMD java -jar book-app-crud-demo.jar.jar
