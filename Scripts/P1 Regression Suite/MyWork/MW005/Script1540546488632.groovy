import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable as GlobalVariable

'Login Into Application'
CustomKeywords.'actions.Common.login'()

'Create Document'
CustomKeywords.'actions.Common.createDocument_Correspondence'('Chintan', 'Shah', 'c.s@abc.com', 'Template1')

'Click on My Work link from left menu'
WebUI.click(findTestObject('Page_nGage_Dashboard/My_Work/a_My Work Left Menu'))
WebUI.waitForJQueryLoad(GlobalVariable.G_LongTimeout)
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_nGage_Dashboard/My_Work/iframe_iframe_105'))

'Click Correspondence Generation - Correspondence'
CustomKeywords.'actions.MenuBar.clickTreeMenu'('MY_WORK', 'Processes', 'Correspondence Generation', 'Correspondence')
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_nGage_Dashboard/My_Work/iframe_work_items'))

'Perform right click operation on Correspondence'
CustomKeywords.'actions.MenuBar.rightClickTreeMenu'('MY_WORK', 'Processes', 'Correspondence Generation', 'Correspondence')

'Verify Foldering configuration option is not present in context menu'
CustomKeywords.'actions.ContextMenu.verifyAllOptions'(findTestObject('Page_nGage_Dashboard/contextMenuOptions'), 'Refresh')