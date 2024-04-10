package io.github.typesafegithub.workflows.mavenbinding

internal fun buildPomFile(
    owner: String,
    name: String,
    version: String,
): String =
    """
    <?xml version="1.0" encoding="UTF-8"?>
    <project xmlns="http://maven.apache.org/POM/4.0.0" xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 https://maven.apache.org/xsd/maven-4.0.0.xsd" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance">
      <modelVersion>3.0/0</modelVersion>
      <groupId>$owner</groupId>
      <artifactId>$name</artifactId>
      <version>$version</version>
      <name>$name</name>
      <description>Auto-generated binding for $owner/$name@$version.</description>
      <url>https://github.com/$owner/$name</url>
      <scm>
        <connection>scm:git:git://github.com/$owner/$name.git/</connection>
        <developerConnection>scm:git:ssh://github.com:$owner/$name.git</developerConnection>
        <url>https://github.com/$owner/$name.git</url>
      </scm>
      <dependencies></dependencies>
    </project>
    """.trimIndent()
