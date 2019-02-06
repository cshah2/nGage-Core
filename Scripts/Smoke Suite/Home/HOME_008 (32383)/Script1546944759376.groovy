import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory as CheckpointFactory
import com.kms.katalon.core.configuration.RunConfiguration
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as MobileBuiltInKeywords
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testcase.TestCaseFactory as TestCaseFactory
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testdata.TestDataFactory as TestDataFactory
import com.kms.katalon.core.testobject.ObjectRepository as ObjectRepository
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WSBuiltInKeywords
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUiBuiltInKeywords
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable
import utils.Consts

'Login Into Application'
CustomKeywords.'actions.Common.login'()

String filePath = RunConfiguration.getProjectDir().replace('/', '\\')+'\\Data Files\\FileUploads\\50 Pages PDF file.pdf'

'Create new document'
CustomKeywords.'actions.Common.createDocument_WMIMenuBovVertical'(Consts.SMOKE_HOME008_BMSTRING, filePath)

'Go to Recent Documents tab'
CustomKeywords.'actions.MenuBar.clickTreeMenu'('HOME', 'Recent Documents')
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_nGage_Dashboard/iframe_iframe_103'))

'Validate atleast 1 record is present in the grid.'
int rowCount = CustomKeywords.'actions.Table.getRowsCount'(findTestObject('Page_nGage_Dashboard/Home/table_MyDocumentResults'))
WebUI.verifyGreaterThanOrEqual(rowCount, 1)

'Sort Record in grid by DocID Descending'
CustomKeywords.'actions.Table.clickColumnHeader'(findTestObject('Page_nGage_Dashboard/Home/tableHeader_RecentDocuments'), 'Doc ID')
CustomKeywords.'actions.Table.clickColumnHeader'(findTestObject('Page_nGage_Dashboard/Home/tableHeader_RecentDocuments'), 'Doc ID')

'Verify Column values for 1st Record in Grid.'
WebUI.verifyElementText(findTestObject('Page_nGage_Dashboard/Home/column_RecentDocuments DocumentTitle'), 'WMI Menu BOV Vertical')
WebUI.verifyElementText(findTestObject('Page_nGage_Dashboard/Home/column_RecentDocuments DocumentType'), 'WMI Menu BOV Vertical')
WebUI.verifyElementText(findTestObject('Page_nGage_Dashboard/Home/column_RecentDocuments LastAction'), 'Created')

int colNo_DocID = CustomKeywords.'actions.Table.getColumnNumber'(findTestObject('Page_nGage_Dashboard/Home/tableHeader_RecentDocuments'), 'Doc ID')

'Open Document'
CustomKeywords.'actions.Table.clickCell'(findTestObject('Page_nGage_Dashboard/Home/table_MyDocumentResults'), 1, colNo_DocID)

'Switch to window'
//WebUI.switchToWindowTitle('WMI Menu BOV Vertical')
WebUI.switchToWindowIndex(1)
WebUI.waitForPageLoad(GlobalVariable.G_LongTimeout)
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_WMI/WMI_Menu_BOV_Vertical/iframe_westContainerFrame'))

'Verify values of the fields'
WebUI.waitForElementPresent(findTestObject('Page_WMI/WMI_Menu_BOV_Vertical/input_eform_String_Input_Field'), GlobalVariable.G_LongTimeout)
WebUI.waitForElementVisible(findTestObject('Page_WMI/WMI_Menu_BOV_Vertical/input_eform_String_Input_Field'), GlobalVariable.G_LongTimeout)
WebUI.verifyElementAttributeValue(findTestObject('Page_WMI/WMI_Menu_BOV_Vertical/input_eform_String_Input_Field'), 'value', Consts.SMOKE_HOME008_BMSTRING, GlobalVariable.G_LongTimeout)

'Verify Content is displayed'
WebUI.verifyElementVisible(findTestObject('Page_WMI/WMI_Menu_BOV_Vertical/iframe_westContainerFrame'))

'Verify Page size of PDF File'
WebUI.waitForElementVisible(findTestObject('Page_WMI/WMI_Menu_BOV_Vertical/span_Page Number'), GlobalVariable.G_LongTimeout)
WebUI.verifyElementText(findTestObject('Page_WMI/WMI_Menu_BOV_Vertical/span_Page Number'), 'Page 1/50')