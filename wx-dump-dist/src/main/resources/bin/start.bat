@echo off & setlocal enabledelayedexpansion

cd %~dp0

set LOG_HOME=%~dp0/../logs

set SERVER_NAME=wx-dump-admin

set CLASS_PATH=".;..\conf;..\lib\*;..\ext-lib\*"

set JAVA_OPTS=-server -Xmx2g -Xms2g -Xmn1g -Xss256k -XX:+DisableExplicitGC  -XX:LargePageSizeInBytes=128m
for /f tokens^=2-5^ delims^=^" %%j in ('java -fullversion 2^>^&1') do set "version=%%j"
echo %version%| findstr "^1.8" >nul && (
   set "JAVA_OPTS=%JAVA_OPTS%  -XX:+UseConcMarkSweepGC -XX:+CMSParallelRemarkEnabled -XX:+UseFastAccessorMethods -XX:+UseCMSInitiatingOccupancyOnly -XX:CMSInitiatingOccupancyFraction=70"
)
echo %version%| findstr "^11" >nul && (
    set "JAVA_OPTS=%JAVA_OPTS%
)
echo %version%| findstr "^17" >nul && (
   set "JAVA_OPTS=%JAVA_OPTS%
)

set MAIN_CLASS=com.xcs.wx.WxDumpApplication

echo Starting the %SERVER_NAME% ...

java %JAVA_OPTS% -Dfile.encoding=UTF-8 -Dspring.thymeleaf.prefix=file:../html/ -Dlog.home=%LOG_HOME% -classpath %CLASS_PATH% %MAIN_CLASS%

pause
