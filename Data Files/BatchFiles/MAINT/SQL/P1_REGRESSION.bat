@echo off

::-------------------------------------------------------------------------
::---------- Kill existing running instances of Katalon Studio ------------
::-------------------------------------------------------------------------
echo kill all existing running instances of katalon studio or chrome driver
TASKKILL /F /IM KATALON.EXE /T
TASKKILL /F /IM CHROMEDRIVER.EXE /T

::-------------------------------------------------------------------------
::---------- Set up Project path and Test Suite and Browser ---------------
::-------------------------------------------------------------------------
set PRJ_PATH=%NGAGE_PROJECTS%\nGage-Core\WebUI.prj
set TEST_SUITE=Test Suites/P1_REGRESSION
set BROWSER=Chrome
set API_KEY=f0588a0f-a994-4ff5-a41f-76b34822b760
set EXECUTE_PROFILE = MAINT (SQL)

::-------------------------------------------------------------------------
::---------- Run Automation Command ---------------------------------------
::-------------------------------------------------------------------------
CALL cmd /c start katalon -noSplash  -runMode=console -consoleLog -projectPath="%PRJ_PATH%" -statusDelay=60 -retry=0 -testSuitePath="%TEST_SUITE%" -executionProfile="%EXECUTE_PROFILE%" -browserType="%BROWSER%" -summaryReport -apiKey=%API_KEY%