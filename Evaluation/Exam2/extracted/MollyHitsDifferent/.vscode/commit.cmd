@echo off
rem Wrapper to run commit.ps1 with ExecutionPolicy bypass
rem Usage: .vscode\commit.cmd [args...]

set SCRIPT_DIR=%~dp0
powershell.exe -NoProfile -ExecutionPolicy Bypass -File "%SCRIPT_DIR%commit.ps1" %*
exit /b %ERRORLEVEL%
