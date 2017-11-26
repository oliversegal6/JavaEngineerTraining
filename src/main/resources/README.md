### Setup ENV

```
JAVA_HOME=/home/oliversegal/Work/jdk1.8.0_151
GRADLE_HOME=/home/oliversegal/Work/gradle-4.2.1
MAVEN_HOME=/home/oliversegal/Work/apache-maven-3.5.2

PATH=${PATH}:${JAVA_HOME}/bin:${GRADLE_HOME}/bin:${MAVEN_HOME}/bin
export JAVA_HOME GRADLE_HOME MAVEN_HOME PATH
```

### Add Ali Miror
```
<mirror>
      <!--This sends everything else to /public -->
      <id>nexus</id>
      <mirrorOf>*</mirrorOf> 
      <url>http://maven.aliyun.com/nexus/content/groups/public/</url>
    </mirror>
    <mirror>
      <!--This is used to direct the public snapshots repo in the 
          profile below over to a different nexus group -->
      <id>nexus-public-snapshots</id>
      <mirrorOf>public-snapshots</mirrorOf> 
      <url>http://maven.aliyun.com/nexus/content/repositories/snapshots/</url>
    </mirror>
```