chcp 65001
@echo off
setlocal enabledelayedexpansion

cd %~dp0

set LOG_HOME=%~dp0/../logs

set SERVER_NAME=wx-dump-admin

set CLASS_PATH=".;..\conf;..\lib\*;..\ext-lib\*"

set JAVA_OPTS=-server
set JAVA_OPTS=%JAVA_OPTS% -Xmx4g -Xms4g
set JAVA_OPTS=%JAVA_OPTS% -XX:MaxMetaspaceSize=512m
set JAVA_OPTS=%JAVA_OPTS% -XX:+UseG1GC
set JAVA_OPTS=%JAVA_OPTS% -XX:InitiatingHeapOccupancyPercent=45
set JAVA_OPTS=%JAVA_OPTS% -XX:+ParallelRefProcEnabled
set JAVA_OPTS=%JAVA_OPTS% -XX:+HeapDumpOnOutOfMemoryError
set JAVA_OPTS=%JAVA_OPTS% -XX:HeapDumpPath=%LOG_HOME%\heapdump.hprof
set JAVA_OPTS=%JAVA_OPTS% -Dfile.encoding=UTF-8
set JAVA_OPTS=%JAVA_OPTS% -XX:-OmitStackTraceInFastThrow

echo Starting the %SERVER_NAME% ...

java %JAVA_OPTS% -Dspring.thymeleaf.prefix=file:../html/ -Dlog.home=%LOG_HOME% -classpath %CLASS_PATH% com.xcs.wx.WxDumpApplication

pause
