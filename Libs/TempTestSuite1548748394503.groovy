import com.kms.katalon.core.logging.KeywordLogger
import com.kms.katalon.core.exception.StepFailedException
import com.kms.katalon.core.reporting.ReportUtil
import com.kms.katalon.core.main.TestCaseMain
import com.kms.katalon.core.testdata.TestDataColumn
import groovy.lang.MissingPropertyException
import com.kms.katalon.core.testcase.TestCaseBinding
import com.kms.katalon.core.driver.internal.DriverCleanerCollector
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.configuration.RunConfiguration
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import internal.GlobalVariable as GlobalVariable

Map<String, String> suiteProperties = new HashMap<String, String>();


suiteProperties.put('id', 'Test Suites/TempSuite')

suiteProperties.put('name', 'TempSuite')

suiteProperties.put('description', '')
 

DriverCleanerCollector.getInstance().addDriverCleaner(new com.kms.katalon.core.webui.contribution.WebUiDriverCleaner())
DriverCleanerCollector.getInstance().addDriverCleaner(new com.kms.katalon.core.mobile.contribution.MobileDriverCleaner())
DriverCleanerCollector.getInstance().addDriverCleaner(new com.kms.katalon.core.cucumber.keyword.internal.CucumberDriverCleaner())



RunConfiguration.setExecutionSettingFile("C:\\Users\\ppatil\\git\\nGage-Core\\Reports\\TempSuite\\20190129_025314\\execution.properties")

TestCaseMain.beforeStart()

TestCaseMain.startTestSuite('Test Suites/TempSuite', suiteProperties, [new TestCaseBinding('Test Cases/P1 Regression Suite/WMI Menu/ReferenceObjectFeature/WMI_RO023 (28608)', 'Test Cases/P1 Regression Suite/WMI Menu/ReferenceObjectFeature/WMI_RO023 (28608)',  null), new TestCaseBinding('Test Cases/P1 Regression Suite/WMI Menu/ReferenceObjectFeature/WMI_RO024 (28610)', 'Test Cases/P1 Regression Suite/WMI Menu/ReferenceObjectFeature/WMI_RO024 (28610)',  null), new TestCaseBinding('Test Cases/P1 Regression Suite/WMI Menu/ReferenceObjectFeature/WMI_RO025 (28611)', 'Test Cases/P1 Regression Suite/WMI Menu/ReferenceObjectFeature/WMI_RO025 (28611)',  null), new TestCaseBinding('Test Cases/P1 Regression Suite/WMI Menu/ReferenceObjectFeature/WMI_RO026 (28612)', 'Test Cases/P1 Regression Suite/WMI Menu/ReferenceObjectFeature/WMI_RO026 (28612)',  null)])
