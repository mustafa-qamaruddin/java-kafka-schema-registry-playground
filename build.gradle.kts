plugins {
    id("java")
}

group = "org.qubits"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()

    maven {
        url = uri("https://packages.confluent.io/maven")
    }
}

dependencies {
    implementation(project(":producer"))
    implementation(project(":consumer"))
    implementation(project(":schemas-manager"))
}

subprojects {
    apply(plugin = "java")

    group = "org.qubits"

    repositories {
        mavenCentral()

        maven {
            url = uri("https://packages.confluent.io/maven")
        }
    }

    tasks.test {
        useJUnitPlatform()
    }

    dependencies {
        compileOnly("org.projectlombok:lombok:1.18.30")
        annotationProcessor("org.projectlombok:lombok:1.18.30")

        implementation("org.apache.kafka:kafka-clients:3.5.1")
        implementation("org.apache.avro:avro:1.11.2")
        implementation("io.confluent:kafka-avro-serializer:7.5.0")

        implementation("org.slf4j:slf4j-api:2.0.7")
        implementation("ch.qos.logback:logback-classic:1.4.8")

        testImplementation(platform("org.junit:junit-bom:5.9.1"))
        testImplementation("org.junit.jupiter:junit-jupiter")
    }
}

tasks.test {
    useJUnitPlatform()
}