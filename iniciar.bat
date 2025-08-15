@echo off
setlocal
REM Vai para a pasta deste .bat
cd /d "%~dp0"

REM Executa o jar
java -jar "registra-servicos.jar"

REM Mantém a janela aberta ao terminar
pause
