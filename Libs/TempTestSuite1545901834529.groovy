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


suiteProperties.put('id', 'Test Suites/Temp')

suiteProperties.put('name', 'Temp')

suiteProperties.put('description', '')
 

DriverCleanerCollector.getInstance().addDriverCleaner(new com.kms.katalon.core.webui.contribution.WebUiDriverCleaner())
DriverCleanerCollector.getInstance().addDriverCleaner(new com.kms.katalon.core.mobile.contribution.MobileDriverCleaner())
DriverCleanerCollector.getInstance().addDriverCleaner(new com.kms.katalon.core.cucumber.keyword.internal.CucumberDriverCleaner())



RunConfiguration.setExecutionSettingFile("C:\\Users\\ppatil\\git\\nGage-Core\\Reports\\Temp\\20181227_041034\\execution.properties")

TestCaseMain.beforeStart()

TestCaseMain.startTestSuite('Test Suites/Temp', suiteProperties, [new TestCaseBinding('Test Cases/P1 Regression Suite/WMI Menu/ReferenceObjectFeature/WMI_RO034', 'Test Cases/P1 Regression Suite/WMI Menu/ReferenceObjectFeature/WMI_RO034',  null), new TestCaseBinding('Test Cases/P1 Regression Suite/WMI Menu/ReferenceObjectFeature/WMI_RO035', 'Test Cases/P1 Regression Suite/WMI Menu/ReferenceObjectFeature/WMI_RO035',  null), new TestCaseBinding('Test Cases/P1 Regression Suite/WMI Menu/ReferenceObjectFeature/WMI_RO036', 'Test Cases/P1 Regression Suite/WMI Menu/ReferenceObjectFeature/WMI_RO036',  null), new TestCaseBinding('Test Cases/P1 Regression Suite/WMI Menu/ReferenceObjectFeature/WMI_RO037', 'Test Cases/P1 Regression Suite/WMI Menu/ReferenceObjectFeature/WMI_RO037',  null), new TestCaseBinding('Test Cases/P1 Regression Suite/WMI Menu/ReferenceObjectFeature/WMI_RO038', 'Test Cases/P1 Regression Suite/WMI Menu/ReferenceObjectFeature/WMI_RO038',  null), new TestCaseBinding('Test Cases/P1 Regression Suite/WMI Menu/ReferenceObjectFeature/WMI_RO039', 'Test Cases/P1 Regression Suite/WMI Menu/ReferenceObjectFeature/WMI_RO039',  null), new TestCaseBinding('Test Cases/P1 Regression Suite/WMI Menu/ReferenceObjectFeature/WMI_RO040', 'Test Cases/P1 Regression Suite/WMI Menu/ReferenceObjectFeature/WMI_RO040',  null), new TestCaseBinding('Test Cases/P1 Regression Suite/WMI Menu/ReferenceObjectFeature/WMI_RO041', 'Test Cases/P1 Regression Suite/WMI Menu/ReferenceObjectFeature/WMI_RO041',  null), new TestCaseBinding('Test Cases/P1 Regression Suite/WMI Menu/ReferenceObjectFeature/WMI_RO042', 'Test Cases/P1 Regression Suite/WMI Menu/ReferenceObjectFeature/WMI_RO042',  null), new TestCaseBinding('Test Cases/P1 Regression Suite/WMI Menu/ReferenceObjectFeature/WMI_RO043', 'Test Cases/P1 Regression Suite/WMI Menu/ReferenceObjectFeature/WMI_RO043',  null), new TestCaseBinding('Test Cases/P1 Regression Suite/WMI Menu/ReferenceObjectFeature/WMI_RO044', 'Test Cases/P1 Regression Suite/WMI Menu/ReferenceObjectFeature/WMI_RO044',  null), new TestCaseBinding('Test Cases/P1 Regression Suite/WMI Menu/ReferenceObjectFeature/WMI_RO045', 'Test Cases/P1 Regression Suite/WMI Menu/ReferenceObjectFeature/WMI_RO045',  null), new TestCaseBinding('Test Cases/P1 Regression Suite/WMI Menu/ReferenceObjectFeature/WMI_RO049', 'Test Cases/P1 Regression Suite/WMI Menu/ReferenceObjectFeature/WMI_RO049',  null), new TestCaseBinding('Test Cases/P1 Regression Suite/WMI Menu/ReferenceObjectFeature/WMI_RO050', 'Test Cases/P1 Regression Suite/WMI Menu/ReferenceObjectFeature/WMI_RO050',  null), new TestCaseBinding('Test Cases/P1 Regression Suite/WMI Menu/ReferenceObjectFeature/WMI_RO052', 'Test Cases/P1 Regression Suite/WMI Menu/ReferenceObjectFeature/WMI_RO052',  null), new TestCaseBinding('Test Cases/P1 Regression Suite/WMI Menu/ReferenceObjectFeature/WMI_RO053', 'Test Cases/P1 Regression Suite/WMI Menu/ReferenceObjectFeature/WMI_RO053',  null), new TestCaseBinding('Test Cases/P1 Regression Suite/WMI Menu/ReferenceObjectFeature/WMI_RO054', 'Test Cases/P1 Regression Suite/WMI Menu/ReferenceObjectFeature/WMI_RO054',  null), new TestCaseBinding('Test Cases/P1 Regression Suite/WMI Menu/ReferenceObjectFeature/WMI_RO055', 'Test Cases/P1 Regression Suite/WMI Menu/ReferenceObjectFeature/WMI_RO055',  null), new TestCaseBinding('Test Cases/P1 Regression Suite/WMI Menu/ReferenceObjectFeature/WMI_RO056', 'Test Cases/P1 Regression Suite/WMI Menu/ReferenceObjectFeature/WMI_RO056',  null), new TestCaseBinding('Test Cases/P1 Regression Suite/WMI Menu/ReferenceObjectFeature/WMI_RO057', 'Test Cases/P1 Regression Suite/WMI Menu/ReferenceObjectFeature/WMI_RO057',  null), new TestCaseBinding('Test Cases/P1 Regression Suite/WMI Menu/ReferenceObjectFeature/WMI_RO058', 'Test Cases/P1 Regression Suite/WMI Menu/ReferenceObjectFeature/WMI_RO058',  null), new TestCaseBinding('Test Cases/P1 Regression Suite/WMI Menu/ReferenceObjectFeature/WMI_RO059', 'Test Cases/P1 Regression Suite/WMI Menu/ReferenceObjectFeature/WMI_RO059',  null)])
