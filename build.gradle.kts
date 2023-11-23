plugins {
    id("java")
    id("com.bmuschko.tomcat") version "2.5"
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")



    implementation("org.springframework:spring-core:5.3.14")
    implementation("org.springframework:spring-context:5.3.14")
    implementation("org.springframework:spring-webmvc:5.3.9")

    implementation("org.springframework:spring-beans:5.3.14")
    implementation("org.springframework:spring-aop:5.3.14")
    implementation("org.springframework:spring-web:5.3.14")
    implementation("org.apache.tomcat.embed:tomcat-embed-core:8.5.16")
    implementation("org.apache.tomcat.embed:tomcat-embed-logging-juli:8.5.2")
    implementation("org.apache.tomcat.embed:tomcat-embed-jasper:8.5.16")
    implementation("com.fasterxml.jackson.core:jackson-databind:2.16.0")
    compileOnly("org.projectlombok:lombok:1.18.30")
    annotationProcessor("org.projectlombok:lombok:1.18.30")


}

tasks.test {
    useJUnitPlatform()
}