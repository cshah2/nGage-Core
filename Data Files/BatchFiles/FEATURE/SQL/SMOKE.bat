TASKKILL /F /IM KATALON.EXE /T
TASKKILL /F /IM CHROMEDRIVER.EXE /T
CALL cmd /c start katalon -noSplash  -runMode=console -consoleLog -projectPath="C:\Users\cshah\git\nGage-Core\WebUI.prj" -statusDelay=60 -retry=0 -testSuitePath="Test Suites/SMOKE" -executionProfile="FEATURE (SQL)" -browserType="Chrome" -summaryReport