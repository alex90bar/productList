FROM adoptopenjdk:11-jre-hotspot
ADD target/product-list-0.0.1-SNAPSHOT.jar product-list.jar
ENTRYPOINT ["java", "-jar", "product-list.jar"]