TASKKILL /F /IM KATALON.EXE /T
TASKKILL /F /IM CHROMEDRIVER.EXE /T
CALL cmd /c start katalon -noSplash  -runMode=console -consoleLog -projectPath="C:\Users\cshah\git\nGage-Core\WebUI.prj" -statusDelay=60 -retry=0 -testSuitePath="Test Suites/P1 Modules/MY_WORK_SIMPLIFIED" -executionProfile="MAINT (MYSQL)" -browserType="Chrome" -summaryReport