plugins {
	application
	java
	checkstyle
	jacoco
	id("org.springframework.boot") version "3.5.0-SNAPSHOT"
	id("io.spring.dependency-management") version "1.1.7"
	id("io.freefair.lombok") version "8.6"
	id("com.github.ben-manes.versions") version "0.50.0"
}

group = "hexlet.code"
version = "0.0.1-SNAPSHOT"

java {
	toolchain {
		languageVersion = JavaLanguageVersion.of(21)
	}
}
application {
	mainClass.set("hexlet.code.AppApplication")
}
repositories {
	mavenCentral()
	maven { url = uri("https://repo.spring.io/milestone") }
	maven { url = uri("https://repo.spring.io/snapshot") }
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter:3.3.2")
	implementation("org.springframework.boot:spring-boot-starter-web:3.3.4")

	// Зависимость нужна для работы механизма Spring Data JPA
	implementation("org.springframework.boot:spring-boot-starter-data-jpa:3.3.4")
	implementation("org.springframework.boot:spring-boot-starter-validation:3.3.4")

	implementation("org.openapitools:jackson-databind-nullable:0.2.6")
	implementation("org.mapstruct:mapstruct:1.6.0.Beta1")
	annotationProcessor("org.mapstruct:mapstruct-processor:1.6.0.Beta1")
	// Для работы с БД
	runtimeOnly("com.h2database:h2:2.2.224")
	// Для работы с тестами
	testImplementation("org.springframework.boot:spring-boot-starter-test:3.3.3")
	testImplementation("org.springframework.security:spring-security-test:6.3.3")
	testRuntimeOnly("org.junit.platform:junit-platform-launcher:1.11.2")
	testImplementation(platform("org.junit:junit-bom:5.10.1"))
	testImplementation("org.junit.jupiter:junit-jupiter:5.11.1")
}


jacoco {
	toolVersion = "0.8.10"
}

tasks.withType<Test> {
	useJUnitPlatform()
}

tasks.jacocoTestReport {
	reports { xml.required.set(true) }
}