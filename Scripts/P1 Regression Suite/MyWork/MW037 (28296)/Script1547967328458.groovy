import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static utils.Consts.*

import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable as GlobalVariable
import static utils.DateUtil.*

'Login Into Application'
CustomKeywords.'actions.Common.login'()

'Create new Document'
String BM_Text = 'Automation-'+getCurrentDateTimeMinusDays(0, FORMAT_DATETIME)
CustomKeywords.'actions.Common.createDocument_MyWorkDateTime'(DC_DATEREQUIRED, DT_DATEREQUIRED, '', '', '', '', BM_Text)

'Click on My Work link from left menu'
WebUI.click(findTestObject('Page_nGage_Dashboard/My_Work/a_My Work Left Menu'))
WebUI.waitForJQueryLoad(GlobalVariable.G_LongTimeout)
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_nGage_Dashboard/My_Work/iframe_iframe_105'))

'Go to tree path'
CustomKeywords.'actions.MenuBar.clickTreeMenu'('MY_WORK', 'Processes', 'Date Required', 'Daterequiredsearch')
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_nGage_Dashboard/My_Work/iframe_work_items'))

'Store total no of records message in result table'
String expectedPagination = WebUI.getText(findTestObject('Page_nGage_Dashboard/My_Work/table_pagination_summary'))

'Order records by DocID Column'
CustomKeywords.'actions.Table.clickColumnHeader'(findTestObject('Page_nGage_Dashboard/My_Work/tableHeader_MyWorkSearchResult'), 'Doc ID')
CustomKeywords.'actions.Table.clickColumnHeader'(findTestObject('Page_nGage_Dashboard/My_Work/tableHeader_MyWorkSearchResult'), 'Doc ID')

'Enter DocID value for search'
int docIDColumnNo = CustomKeywords.'actions.Table.getColumnNumber'(findTestObject('Page_nGage_Dashboard/My_Work/tableHeader_MyWorkSearchResult'), 'Doc ID')
String _docID = CustomKeywords.'actions.Table.getCellText'(findTestObject('Page_nGage_Dashboard/My_Work/table_MyWorkSearchResults'), 1, docIDColumnNo)

'Open Search bar'
WebUI.waitForElementVisible(findTestObject('Page_nGage_Dashboard/My_Work/h3_Search Bar'), GlobalVariable.G_LongTimeout)
WebUI.click(findTestObject('Page_nGage_Dashboard/My_Work/h3_Search Bar'))

WebUI.waitForElementVisible(findTestObject('Page_nGage_Dashboard/My_Work/search_DocID'), GlobalVariable.G_LongTimeout)
WebUI.setText(findTestObject('Page_nGage_Dashboard/My_Work/search_DocID'), _docID)

WebUI.selectOptionByLabel(findTestObject('Page_nGage_Dashboard/My_Work/Process_Date Required/select_StartDate_operator'), 'Null', false)
CustomKeywords.'actions.Common.setText_Date'(findTestObject('Page_nGage_Dashboard/My_Work/Process_Date Required/input_StartDate'), P1_MW035_FILTER_START)

'Click on Search button'
WebUI.click(findTestObject('Page_nGage_Dashboard/My_Work/btn_Search'))
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_nGage_Dashboard/My_Work/iframe_work_items'))

'Verify only 1 record is displayed in result grid'
CustomKeywords.'actions.Table.verifyRecordsCount'(findTestObject('Page_nGage_Dashboard/My_Work/table_MyWorkSearchResults'), 1)

int BM_TextColNo = CustomKeywords.'actions.Table.getColumnNumber'(findTestObject('Page_nGage_Dashboard/My_Work/tableHeader_MyWorkSearchResult'), 'BM Text')
CustomKeywords.'actions.Table.verifyCellContainsValue'(findTestObject('Page_nGage_Dashboard/My_Work/table_MyWorkSearchResults'), 1, BM_TextColNo, BM_Text)

'Open Search bar'
WebUI.waitForElementVisible(findTestObject('Page_nGage_Dashboard/My_Work/h3_Search Bar'), GlobalVariable.G_LongTimeout)
WebUI.click(findTestObject('Page_nGage_Dashboard/My_Work/h3_Search Bar'))

'Click on Reset button'
WebUI.waitForElementVisible(findTestObject('Page_nGage_Dashboard/My_Work/btn_Reset'), GlobalVariable.G_LongTimeout)
WebUI.click(findTestObject('Page_nGage_Dashboard/My_Work/btn_Reset'))
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_nGage_Dashboard/My_Work/iframe_work_items'))

'Verify Result grid displys all the records'
WebUI.verifyElementText(findTestObject('Page_nGage_Dashboard/My_Work/table_pagination_summary'), expectedPagination)