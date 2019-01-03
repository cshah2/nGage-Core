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


suiteProperties.put('id', 'Test Suites/P1 Regression')

suiteProperties.put('name', 'P1 Regression')

suiteProperties.put('description', '')
 

DriverCleanerCollector.getInstance().addDriverCleaner(new com.kms.katalon.core.webui.contribution.WebUiDriverCleaner())
DriverCleanerCollector.getInstance().addDriverCleaner(new com.kms.katalon.core.mobile.contribution.MobileDriverCleaner())
DriverCleanerCollector.getInstance().addDriverCleaner(new com.kms.katalon.core.cucumber.keyword.internal.CucumberDriverCleaner())



RunConfiguration.setExecutionSettingFile("C:\\Users\\amirvankar\\git\\nGage-Core\\Reports\\P1 Regression\\20190103_092953\\execution.properties")

TestCaseMain.beforeStart()

TestCaseMain.startTestSuite('Test Suites/P1 Regression', suiteProperties, [new TestCaseBinding('Test Cases/P1 Regression Suite/WMI Menu/BusinessModelView/BMV001', 'Test Cases/P1 Regression Suite/WMI Menu/BusinessModelView/BMV001',  null), new TestCaseBinding('Test Cases/P1 Regression Suite/WMI Menu/BusinessModelView/BMV002', 'Test Cases/P1 Regression Suite/WMI Menu/BusinessModelView/BMV002',  null), new TestCaseBinding('Test Cases/P1 Regression Suite/WMI Menu/BusinessModelView/BMV003', 'Test Cases/P1 Regression Suite/WMI Menu/BusinessModelView/BMV003',  null), new TestCaseBinding('Test Cases/P1 Regression Suite/WMI Menu/BusinessModelView/BMV004', 'Test Cases/P1 Regression Suite/WMI Menu/BusinessModelView/BMV004',  null), new TestCaseBinding('Test Cases/P1 Regression Suite/WMI Menu/BusinessModelView/BMV005', 'Test Cases/P1 Regression Suite/WMI Menu/BusinessModelView/BMV005',  null), new TestCaseBinding('Test Cases/P1 Regression Suite/WMI Menu/BusinessModelView/BMV006', 'Test Cases/P1 Regression Suite/WMI Menu/BusinessModelView/BMV006',  null), new TestCaseBinding('Test Cases/P1 Regression Suite/WMI Menu/BusinessModelView/BMV007', 'Test Cases/P1 Regression Suite/WMI Menu/BusinessModelView/BMV007',  null), new TestCaseBinding('Test Cases/P1 Regression Suite/WMI Menu/BusinessModelView/BMV008', 'Test Cases/P1 Regression Suite/WMI Menu/BusinessModelView/BMV008',  null), new TestCaseBinding('Test Cases/P1 Regression Suite/WMI Menu/BusinessModelView/BMV009', 'Test Cases/P1 Regression Suite/WMI Menu/BusinessModelView/BMV009',  null), new TestCaseBinding('Test Cases/P1 Regression Suite/WMI Menu/BusinessModelView/BMV010', 'Test Cases/P1 Regression Suite/WMI Menu/BusinessModelView/BMV010',  null), new TestCaseBinding('Test Cases/P1 Regression Suite/WMI Menu/BusinessModelView/BMV011', 'Test Cases/P1 Regression Suite/WMI Menu/BusinessModelView/BMV011',  null), new TestCaseBinding('Test Cases/P1 Regression Suite/WMI Menu/BusinessModelView/BMV012', 'Test Cases/P1 Regression Suite/WMI Menu/BusinessModelView/BMV012',  null), new TestCaseBinding('Test Cases/P1 Regression Suite/WMI Menu/BusinessModelView/BMV013', 'Test Cases/P1 Regression Suite/WMI Menu/BusinessModelView/BMV013',  null), new TestCaseBinding('Test Cases/P1 Regression Suite/WMI Menu/BusinessModelView/BMV014', 'Test Cases/P1 Regression Suite/WMI Menu/BusinessModelView/BMV014',  null), new TestCaseBinding('Test Cases/P1 Regression Suite/WMI Menu/BusinessModelView/BMV015', 'Test Cases/P1 Regression Suite/WMI Menu/BusinessModelView/BMV015',  null), new TestCaseBinding('Test Cases/P1 Regression Suite/WMI Menu/BusinessModelView/WMI_BM016', 'Test Cases/P1 Regression Suite/WMI Menu/BusinessModelView/WMI_BM016',  null), new TestCaseBinding('Test Cases/P1 Regression Suite/WMI Menu/BusinessModelView/WMI_BM017', 'Test Cases/P1 Regression Suite/WMI Menu/BusinessModelView/WMI_BM017',  null), new TestCaseBinding('Test Cases/P1 Regression Suite/WMI Menu/BusinessModelView/WMI_BM018', 'Test Cases/P1 Regression Suite/WMI Menu/BusinessModelView/WMI_BM018',  null), new TestCaseBinding('Test Cases/P1 Regression Suite/WMI Menu/BusinessModelView/WMI_BM019', 'Test Cases/P1 Regression Suite/WMI Menu/BusinessModelView/WMI_BM019',  null)])
