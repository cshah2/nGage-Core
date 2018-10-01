import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory as CheckpointFactory
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

//Login Into Application
CustomKeywords.'actions.Common.login'()

//Click on Favorite Documents tab
WebUI.click(findTestObject('Page_nGage_Dashboard/Home/a_Favorite Documents'))
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_nGage_Dashboard/iframe_iframe_103'))

//Validate atleast 1 record is present in the grid.
WebUI.verifyElementPresent(findTestObject('Page_nGage_Dashboard/Home/tableRow_favoriteDocuments_firstRow'), GlobalVariable.G_LongTimeout);

// Sort records in tables based on DOC ID - Descending
CustomKeywords.'actions.Table.clickColumnHeader'(findTestObject('Page_nGage_Dashboard/Home/div_Doc ID'))
CustomKeywords.'actions.Table.clickColumnHeader'(findTestObject('Page_nGage_Dashboard/Home/div_Doc ID'))

//Validate First Row is present in the table
WebUI.verifyElementPresent(findTestObject('Page_nGage_Dashboard/Home/tableRow_favoriteDocuments_firstRow'), GlobalVariable.G_LongTimeout);

//Validate Column data in first row
WebUI.verifyElementText(findTestObject('Page_nGage_Dashboard/Home/column_favoriteDocuments DocumentTitle'), 'MultipageViewer with drag and drop')
WebUI.verifyElementText(findTestObject('Page_nGage_Dashboard/Home/column_favoriteDocuments DocumentType'), 'MultipageViewer with drag and drop')
WebUI.verifyElementText(findTestObject('Page_nGage_Dashboard/Home/column_favoriteDocuments DocID'), GlobalVariable.DocumentID)

//Click on DOCID Column on first row to open the Document 
WebUI.click(findTestObject('Page_nGage_Dashboard/Home/column_favoriteDocuments DocID'))
WebUI.switchToWindowTitle('MultipageViewer with drag and drop')
WebUI.waitForPageLoad(GlobalVariable.G_LongTimeout)

//Verify field values of document
WebUI.verifyElementAttributeValue(findTestObject('Page_WMI/MultiPage_Viewer_DD/input_eform_mcb67676_phBO_3_BO_eidmKey_BM_String'), 'value', 'Automation Test Execution - New document', GlobalVariable.G_LongTimeout)
WebUI.verifyElementAttributeValue(findTestObject('Page_WMI/MultiPage_Viewer_DD/input_eform_mcb67676_phBO_3_BO_eidmKey_FileName'), 'value', 'No File to Upload', GlobalVariable.G_LongTimeout)