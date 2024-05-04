plugins {
    alias(ihub.plugins.boot)
    alias(ihub.plugins.javaagent)
//    alias(ihub.plugins.shadow)
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-web")
}

iHubJavaagent {
    javaagent = "pub.ihub.integration:ihub-agent-trace-plugin"
}

//byteBuddy {
////extensions.configure(AbstractByteBuddyTaskExtension::class.java) {
//    transformation {
//        plugin = IHubPlugin::class.java
//    }
//    println(transformations)
//    discovery = Discovery.UNIQUE
//    discoverySet = files("META-INF/net.bytebuddy/build.plugins")
//    adjustment = Adjustment.ACTIVE
//}

//tasks.withType(AbstractByteBuddyTask::class.java).configureEach {
//    tasks.getByName("classes").dependsOn(this)
//}
