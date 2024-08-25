plugins {
    id("java")
}

group = "celebi"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    // https://mvnrepository.com/artifact/org.testng/testng
    testImplementation("org.testng:testng:7.9.0")

    // https://mvnrepository.com/artifact/io.rest-assured/rest-assured
    testImplementation("io.rest-assured:rest-assured:5.5.0")

    // https://mvnrepository.com/artifact/io.qameta.allure/allure-testng
    testImplementation("io.qameta.allure:allure-testng:2.20.0")

}

tasks.test {
    useTestNG {
        suites("src/test/resources/testng.xml")

    }
//    systemProperty("env", project.hasProperty("env") ? project . property ("env") : "prod")
    systemProperty("env",project.findProperty("env") as String? ?: "prod")
}