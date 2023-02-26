FROM openjdk

WORKDIR /usr/src/app

COPY . usr/src/app

CMD ["java", "-jar", "book-crud-app.jar"]
