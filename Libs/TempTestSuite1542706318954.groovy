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


suiteProperties.put('id', 'Test Suites/Temp Suite')

suiteProperties.put('name', 'Temp Suite')

suiteProperties.put('description', 'Smoke Test suite for RunTime UI.')
 

DriverCleanerCollector.getInstance().addDriverCleaner(new com.kms.katalon.core.webui.contribution.WebUiDriverCleaner())
DriverCleanerCollector.getInstance().addDriverCleaner(new com.kms.katalon.core.mobile.contribution.MobileDriverCleaner())
DriverCleanerCollector.getInstance().addDriverCleaner(new com.kms.katalon.core.cucumber.keyword.internal.CucumberDriverCleaner())



RunConfiguration.setExecutionSettingFile("C:\\Users\\ppatil\\git\\nGage-Core\\Reports\\Temp Suite\\20181120_043158\\execution.properties")

TestCaseMain.beforeStart()

TestCaseMain.startTestSuite('Test Suites/Temp Suite', suiteProperties, [new TestCaseBinding('Test Cases/P1 Regression Suite/MyWork/MW001', 'Test Cases/P1 Regression Suite/MyWork/MW001',  null), new TestCaseBinding('Test Cases/P1 Regression Suite/MyWork/MW002', 'Test Cases/P1 Regression Suite/MyWork/MW002',  null), new TestCaseBinding('Test Cases/P1 Regression Suite/MyWork/MW003', 'Test Cases/P1 Regression Suite/MyWork/MW003',  null), new TestCaseBinding('Test Cases/P1 Regression Suite/MyWork/MW004', 'Test Cases/P1 Regression Suite/MyWork/MW004',  null), new TestCaseBinding('Test Cases/P1 Regression Suite/MyWork/MW005', 'Test Cases/P1 Regression Suite/MyWork/MW005',  null), new TestCaseBinding('Test Cases/P1 Regression Suite/MyWork/MW006', 'Test Cases/P1 Regression Suite/MyWork/MW006',  null), new TestCaseBinding('Test Cases/P1 Regression Suite/MyWork/MW007', 'Test Cases/P1 Regression Suite/MyWork/MW007',  null), new TestCaseBinding('Test Cases/P1 Regression Suite/MyWork/MW008', 'Test Cases/P1 Regression Suite/MyWork/MW008',  null), new TestCaseBinding('Test Cases/P1 Regression Suite/MyWork/MW011', 'Test Cases/P1 Regression Suite/MyWork/MW011',  null), new TestCaseBinding('Test Cases/P1 Regression Suite/MyWork/MW012', 'Test Cases/P1 Regression Suite/MyWork/MW012',  null), new TestCaseBinding('Test Cases/P1 Regression Suite/MyWork/MW013', 'Test Cases/P1 Regression Suite/MyWork/MW013',  null), new TestCaseBinding('Test Cases/P1 Regression Suite/MyWork/MW014', 'Test Cases/P1 Regression Suite/MyWork/MW014',  null), new TestCaseBinding('Test Cases/P1 Regression Suite/MyWork/MW015', 'Test Cases/P1 Regression Suite/MyWork/MW015',  null), new TestCaseBinding('Test Cases/P1 Regression Suite/MyWork/MW016', 'Test Cases/P1 Regression Suite/MyWork/MW016',  null), new TestCaseBinding('Test Cases/P1 Regression Suite/MyWork/MW017', 'Test Cases/P1 Regression Suite/MyWork/MW017',  null), new TestCaseBinding('Test Cases/P1 Regression Suite/MyWork/MW018', 'Test Cases/P1 Regression Suite/MyWork/MW018',  null), new TestCaseBinding('Test Cases/P1 Regression Suite/MyWork/MW019', 'Test Cases/P1 Regression Suite/MyWork/MW019',  null), new TestCaseBinding('Test Cases/P1 Regression Suite/MyWork/MW021', 'Test Cases/P1 Regression Suite/MyWork/MW021',  null), new TestCaseBinding('Test Cases/P1 Regression Suite/MyWork/MW022', 'Test Cases/P1 Regression Suite/MyWork/MW022',  null), new TestCaseBinding('Test Cases/P1 Regression Suite/MyWork/MW023', 'Test Cases/P1 Regression Suite/MyWork/MW023',  null), new TestCaseBinding('Test Cases/P1 Regression Suite/MyWork/MW024', 'Test Cases/P1 Regression Suite/MyWork/MW024',  null), new TestCaseBinding('Test Cases/P1 Regression Suite/MyWork/MW025', 'Test Cases/P1 Regression Suite/MyWork/MW025',  null), new TestCaseBinding('Test Cases/P1 Regression Suite/MyWork/MW026', 'Test Cases/P1 Regression Suite/MyWork/MW026',  null), new TestCaseBinding('Test Cases/P1 Regression Suite/MyWork/MW027', 'Test Cases/P1 Regression Suite/MyWork/MW027',  null), new TestCaseBinding('Test Cases/P1 Regression Suite/MyWork/MW028', 'Test Cases/P1 Regression Suite/MyWork/MW028',  null), new TestCaseBinding('Test Cases/P1 Regression Suite/MyWork/MW029', 'Test Cases/P1 Regression Suite/MyWork/MW029',  null), new TestCaseBinding('Test Cases/P1 Regression Suite/MyWork/MW030', 'Test Cases/P1 Regression Suite/MyWork/MW030',  null), new TestCaseBinding('Test Cases/P1 Regression Suite/MyWork/MW031', 'Test Cases/P1 Regression Suite/MyWork/MW031',  null), new TestCaseBinding('Test Cases/P1 Regression Suite/MyWork/MW032', 'Test Cases/P1 Regression Suite/MyWork/MW032',  null), new TestCaseBinding('Test Cases/P1 Regression Suite/MyWork/MW033', 'Test Cases/P1 Regression Suite/MyWork/MW033',  null), new TestCaseBinding('Test Cases/P1 Regression Suite/MyWork/MW034', 'Test Cases/P1 Regression Suite/MyWork/MW034',  null)])
