@echo off
echo.
jar -cfvm main.jar manifest.txt main.class utilities.class Server.class Client.class ConsoleColors.class beautification.class
jar -cfvm linux-JAR.jar manifest.txt main.class utilities.class Server.class Client.class ConsoleColors.class beautification.class
