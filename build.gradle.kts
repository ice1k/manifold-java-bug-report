plugins {
  java
  `java-library`
}

apply {
  plugin("java")
  plugin("java-library")
}
repositories { mavenCentral() }
dependencies {
  implementation(libs.manifold.delegate.runtime)
  annotationProcessor(libs.manifold.delegate.codegen)
}

val javaVersion = 21
java {
  withSourcesJar()
  if (hasProperty("release")) withJavadocJar()
  sourceCompatibility = JavaVersion.VERSION_21
  targetCompatibility = JavaVersion.VERSION_21
}

tasks.withType<JavaCompile>().configureEach {
  modularity.inferModulePath.set(true)

  options.apply {
    encoding = "UTF-8"
    isDeprecation = true
    release.set(javaVersion)
    compilerArgs.addAll(listOf("-Xlint:unchecked", "--enable-preview"))
  }
}
