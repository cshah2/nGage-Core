import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import common.DocClass
import common.DocType
import internal.GlobalVariable as GlobalVariable

'Login Into Application'
CustomKeywords.'actions.Common.login'()

'Select DocClass and Doc Type'
WebUI.click(findTestObject('Page_nGage_Dashboard/input_btnGlobalNew'))
CustomKeywords.'actions.Common.selectDocClassAndDocTypeForGlobalNew'(DocClass.MASTER_OBJECT_FEATURE.toString(), DocType.FIELD_MASK.toString())

'Click on OK button'
WebUI.click(findTestObject('Page_nGage_Dashboard/Home/input_btnsave'))

'Switch to new Window'
WebUI.switchToWindowIndex(1)
WebUI.waitForPageLoad(GlobalVariable.G_LongTimeout)
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_WMI_NEW/Master_Object_Feature/Field Mask/iframe_ContentPlaceHolder1'))

'Verify Masking at each field present in WMI'
CustomKeywords.'actions.Common.verifyElementMaskedProperty'(findTestObject('Page_WMI_NEW/Master_Object_Feature/Field Mask/input_String Field with Mask'), true, '___-___-____')
CustomKeywords.'actions.Common.verifyElementMaskedProperty'(findTestObject('Page_WMI_NEW/Master_Object_Feature/Field Mask/input_String Field A(no mask)'), false, '')
CustomKeywords.'actions.Common.verifyElementMaskedProperty'(findTestObject('Page_WMI_NEW/Master_Object_Feature/Field Mask/input_String Field B(no mask)'), false, '')

CustomKeywords.'actions.Common.verifyElementMaskedProperty'(findTestObject('Page_WMI_NEW/Master_Object_Feature/Field Mask/input_Str fld(mask at docclass)'), true, '___-___-(____)')
CustomKeywords.'actions.Common.verifyElementMaskedProperty'(findTestObject('Page_WMI_NEW/Master_Object_Feature/Field Mask/input_Str fld(mask at docclass_WMI)'), true, '[___-___-____]')

CustomKeywords.'actions.Common.verifyElementMaskedProperty'(findTestObject('Page_WMI_NEW/Master_Object_Feature/Field Mask/input_Str fld(mask at field)'), true, '___-___-(____)')
CustomKeywords.'actions.Common.verifyElementMaskedProperty'(findTestObject('Page_WMI_NEW/Master_Object_Feature/Field Mask/input_Str fld(mask at field_WMI)'), true, '[___-___-____]')
CustomKeywords.'actions.Common.verifyElementMaskedProperty'(findTestObject('Page_WMI_NEW/Master_Object_Feature/Field Mask/input_Str fld(mask at field_docclass)'), true, '[___-___-____]')
CustomKeywords.'actions.Common.verifyElementMaskedProperty'(findTestObject('Page_WMI_NEW/Master_Object_Feature/Field Mask/input_Str fld(mask at field_docclass_WMI)'), true, '[___-___-____]')