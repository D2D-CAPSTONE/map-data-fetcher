#!/bin/sh
set -e

APP_HOME=$(cd "$(dirname "$0")"; pwd -P)
WRAPPER_JAR="$APP_HOME/gradle/wrapper/gradle-wrapper.jar"
WRAPPER_DOWNLOADER_JAVA="$APP_HOME/gradle/wrapper/GradleWrapperDownloader.java"

if [ ! -f "$WRAPPER_JAR" ]; then
  if [ -f "$WRAPPER_DOWNLOADER_JAVA" ]; then
    echo "Downloading Gradle wrapper jar..."
    javac "$WRAPPER_DOWNLOADER_JAVA"
    java -cp "$APP_HOME/gradle/wrapper" GradleWrapperDownloader
  else
    echo "Missing $WRAPPER_DOWNLOADER_JAVA"
    exit 1
  fi
fi

exec java -Dorg.gradle.appname=gradlew -classpath "$WRAPPER_JAR" org.gradle.wrapper.GradleWrapperMain "$@"
