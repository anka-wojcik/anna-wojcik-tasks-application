call runcrud.bat
if "%ERRORLEVEL%" == "0" goto openbrowser
echo.
echo Cannot compile runcrud.bat file - breaking work.
goto fail

:openbrowser
wait runcrud.bat
start microsoft-edge:http://localhost:8080/crud/v1/task/getTasks
if "%ERRORLEVEL%" == "0" goto end
echo Cannot open browser.
goto fail

goto end

:fail
echo.
echo There were errors.

:end
echo.
echo Work is finished.