import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.openqa.selenium.WebDriver
import org.openqa.selenium.remote.server.DriverFactory

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import common.DocClass
import common.DocType
import internal.GlobalVariable as GlobalVariable

'Login Into Application'
CustomKeywords.'actions.Common.login'()

'Click on New button to Create a new WMI Segment Document'
WebUI.click(findTestObject('Page_nGage_Dashboard/input_btnGlobalNew'))

'select DocClass Wmi Segment and DocType Wmi Segment Master Reference Object'
CustomKeywords.'actions.Common.selectDocClassAndDocTypeForGlobalNew'(DocClass.WMI_SEGMENT.toString(), DocType.WMI_SEGMENT_MASTER_REFERENCE_OBJECT.toString())

'click on Ok button'
WebUI.click(findTestObject('Page_nGage_Dashboard/Home/input_btnsave'))

'Switch to window and wait for page load'
WebUI.switchToWindowIndex(1)
WebUI.waitForPageLoad(GlobalVariable.G_LongTimeout)

'Mouse hover on standard actions button and Click on Save button'
WebUI.mouseOver(findTestObject('Object Repository/Page_WMI_NEW/WMI_Menu_BOV/buttonStandardActions'))
WebUI.click(findTestObject('Page_WMI_NEW/WMISegment/button_Save'))

'Close Window() and If Error Present Document will not get Close'
CustomKeywords.'actions.Window.clickElementAndWaitForWindowClose'(findTestObject('Page_WMI_NEW/WMISegment/button_Close'), GlobalVariable.G_LongTimeout)

'Switch to parent window'
WebUI.switchToWindowIndex(0)
WebUI.click(findTestObject('Page_nGage_Dashboard/Home/span_ui-button-icon-primary ui'))

'Navigate to Recent Documents'
CustomKeywords.'actions.MenuBar.clickTreeMenu'('HOME', 'Recent Documents')
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_nGage_Dashboard/iframe_iframe_103'))

'Sort records DocID Descending'
CustomKeywords.'actions.Table.clickColumnHeader'(findTestObject('Page_nGage_Dashboard/Home/tableHeader_RecentDocuments'), 'Doc ID')
CustomKeywords.'actions.Table.clickColumnHeader'(findTestObject('Page_nGage_Dashboard/Home/tableHeader_RecentDocuments'), 'Doc ID')

int docTypeColumnPosition =CustomKeywords.'actions.Table.getColumnNumber'(findTestObject('Page_nGage_Dashboard/Home/tableHeader_RecentDocuments'),'Doc Type')
String columnNameDocType = CustomKeywords.'actions.Table.getCellText'(findTestObject('Object Repository/Page_nGage_Dashboard/Home/table_MyDocumentResults'), 1,docTypeColumnPosition)

'verify document is saved'
WebUI.verifyMatch('WMI Segment Master Reference Object', columnNameDocType, false)

'Open saved doc from recent document'
CustomKeywords.'actions.Table.clickCell'(findTestObject('Object Repository/Page_nGage_Dashboard/Home/table_MyDocumentResults'), 1, 7)
WebUI.switchToWindowIndex(1)
WebUI.waitForPageLoad(GlobalVariable.G_LongTimeout)

'MouseHover on History menu and Verify that Audit History is not displayed under History menu'
WebUI.mouseOver(findTestObject('Page_WMI_NEW/WMISegment/button_History'))
String pageSource = CustomKeywords.'actions.Common.getPageSource'()
if(pageSource.contains('Audit History')) {
	KeywordUtil.markFailedAndStop('Element Found in page source')
}
