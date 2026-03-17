@echo off
setlocal

set APP_HOME=%~dp0
set WRAPPER_JAR=%APP_HOME%gradle\wrapper\gradle-wrapper.jar
set WRAPPER_DOWNLOADER_JAVA=%APP_HOME%gradle\wrapper\GradleWrapperDownloader.java
set WRAPPER_MAIN=org.gradle.wrapper.GradleWrapperMain

if exist "%WRAPPER_JAR%" goto runWrapper

if exist "%WRAPPER_DOWNLOADER_JAVA%" (
  echo Downloading Gradle wrapper jar...
  javac "%WRAPPER_DOWNLOADER_JAVA%"
  if errorlevel 1 goto error
  java -cp "%APP_HOME%gradle\wrapper" GradleWrapperDownloader
  if errorlevel 1 goto error
) else (
  echo Missing "%WRAPPER_DOWNLOADER_JAVA%"
  goto error
)

:runWrapper
java "-Dorg.gradle.appname=gradlew" -classpath "%WRAPPER_JAR%" %WRAPPER_MAIN% %*
if errorlevel 1 goto error
goto end

:error
echo Gradle wrapper execution failed.
exit /b 1

:end
endlocal
