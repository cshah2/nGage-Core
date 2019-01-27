import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static utils.Consts.*

import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable as GlobalVariable

'Login Into Application'
CustomKeywords.'actions.Common.login'()

'Create 2 Docuement'
CustomKeywords.'actions.Common.createDocument_ClosureAction'(SMOKE_MYWORK009_CUSTOMERNAME1, SMOKE_MYWORK009_CUSTOMERDETAIL1)
CustomKeywords.'actions.Common.createDocument_ClosureAction'(SMOKE_MYWORK009_CUSTOMERNAME1, SMOKE_MYWORK009_CUSTOMERDETAIL1)

'Click on My Work link from left menu'
WebUI.click(findTestObject('Page_nGage_Dashboard/My_Work/a_My Work Left Menu'))
WebUI.waitForJQueryLoad(GlobalVariable.G_LongTimeout)
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_nGage_Dashboard/My_Work/iframe_iframe_105'))

'Click on Tree Menu'
CustomKeywords.'actions.MenuBar.clickTreeMenu'('MY_WORK', 'Processes', 'Closure Action', 'Activity A')
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_nGage_Dashboard/My_Work/iframe_work_items'))

'Verify atleast 2 records are displayed in table'
int rowCount = CustomKeywords.'actions.Table.getRowsCount'(findTestObject('Page_nGage_Dashboard/My_Work/table_MyWorkSearchResults'))
WebUI.verifyGreaterThanOrEqual(rowCount, 2)

'click first check box'
WebUI.click(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/input_FirstCheckBox'))

'Click on Select All icon'
WebUI.click(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/input_SelectAllCheckBoxes'))
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/iframe_iframe_105'))

'verify all records checked'
CustomKeywords.'actions.Table.verifyAllRecordsAreChecked'(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/table_MyWorkSearchResults'))
