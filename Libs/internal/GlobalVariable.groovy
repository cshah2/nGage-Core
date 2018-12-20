package internal

import com.kms.katalon.core.configuration.RunConfiguration
import com.kms.katalon.core.testobject.ObjectRepository as ObjectRepository
import com.kms.katalon.core.testdata.TestDataFactory as TestDataFactory
import com.kms.katalon.core.testcase.TestCaseFactory as TestCaseFactory
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase

/**
 * This class is generated automatically by Katalon Studio and should not be modified or deleted.
 */
public class GlobalVariable {
     
    /**
     * <p></p>
     */
    public static Object G_LongTimeout
     
    /**
     * <p></p>
     */
    public static Object G_SmallTimeout
     
    /**
     * <p></p>
     */
    public static Object BaseURL
     
    /**
     * <p></p>
     */
    public static Object Username
     
    /**
     * <p></p>
     */
    public static Object Password
     
    /**
     * <p></p>
     */
    public static Object Database
     
    /**
     * <p>Profile default : Business Model View
Profile 18.2HF : Business Model View
Profile 19.1-AWS-SQL : Business Model View
Profile Feature-Branch : Business Model View
Profile PEDEV : Business Model View</p>
     */
    public static Object DocumentClass
     
    /**
     * <p>Profile default : Multipage viewer with Drag and Drop
Profile 18.2HF : Multipage viewer with Drag and Drop
Profile 19.1-AWS-SQL : Multipage viewer with Drag and Drop
Profile Feature-Branch : Multipage viewer with Drag and Drop
Profile PEDEV : Multipage viewer with Drag and Drop</p>
     */
    public static Object DocumentType
     
    /**
     * <p>Profile default : Document ID Generated in Script
Profile 18.2HF : Document ID Generated in Script
Profile 19.1-AWS-SQL : Document ID Generated in Script
Profile Feature-Branch : Document ID Generated in Script
Profile PEDEV : Document ID Generated in Script</p>
     */
    public static Object DocumentID
     
    /**
     * <p>Profile default : Store number of records displayed in filter
Profile 18.2HF : Store number of records displayed in filter
Profile 19.1-AWS-SQL : Store number of records displayed in filter
Profile Feature-Branch : Store number of records displayed in filter
Profile PEDEV : Store number of records displayed in filter</p>
     */
    public static Object RecordsInFilter
     
    /**
     * <p>Profile default : Name of the search filter to be saved
Profile 18.2HF : Name of the search filter to be saved
Profile 19.1-AWS-SQL : Name of the search filter to be saved
Profile Feature-Branch : Name of the search filter to be saved
Profile PEDEV : Name of the search filter to be saved</p>
     */
    public static Object FilterName
     
    /**
     * <p></p>
     */
    public static Object WMI005
     
    /**
     * <p></p>
     */
    public static Object WMI006
     
    /**
     * <p></p>
     */
    public static Object WMI007
     
    /**
     * <p></p>
     */
    public static Object MW018_DocID
     
    /**
     * <p></p>
     */
    public static Object ChartType
     
    /**
     * <p></p>
     */
    public static Object Standard_Timeout
     
    /**
     * <p></p>
     */
    public static Object Copy_Report_Name
     
    /**
     * <p></p>
     */
    public static Object BaseAdminApiURL
     

    static {
        def allVariables = [:]        
        allVariables.put('default', ['G_LongTimeout' : 120, 'G_SmallTimeout' : 30, 'BaseURL' : 'http://savphlpetest64/Sav.Main.UI', 'Username' : 'cshah_admin', 'Password' : 'Password1234!', 'Database' : 'IPM_EPM50MASTER_502_AUTOMATION', 'DocumentClass' : '100005', 'DocumentType' : '100153', 'DocumentID' : '', 'RecordsInFilter' : '', 'FilterName' : '', 'WMI005' : [('Field1') : '50', ('Field2') : 'WMI005_Auto_test', ('Field3') : 'Value 2', ('Field4') : '20', ('Field5') : '08-10-2018', ('Field6') : '60.129', ('Field7') : '25', ('Field8') : 'Text Field', ('Field9') : '08-10-2018 12:00:00 AM', ('Field10') : 'String Field', ('Field11') : 'Last Name', ('Field4_View') : '$20.00'], 'WMI006' : [('Field1') : '40', ('Field2') : 'WMI006_Auto_test', ('Field3') : 'Value 3', ('Field4') : '10', ('Field5') : '08-16-2018', ('Field6') : '70.854', ('Field7') : '60', ('Field8') : 'Text Field', ('Field9') : '08-16-2018 12:00:00 AM', ('Field10') : 'String Field', ('Field11') : 'Middle Name', ('Field4_View') : '$10.00'], 'WMI007' : [('Field1') : '90', ('Field2') : 'WMI007_Auto_test', ('Field3') : 'Value 1', ('Field4') : '30', ('Field5') : '08-20-2018', ('Field6') : '90.113', ('Field7') : '30', ('Field8') : 'Text Field', ('Field9') : '08-20-2018 12:00:00 AM', ('Field10') : 'String Field', ('Field11') : 'First Name', ('Field4_View') : '$30.00'], 'MW018_DocID' : '', 'ChartType' : [('PIE') : '//*[name() = \'g\' and contains(@class,\'nv-slice\')]', ('V_BAR') : '//*[name()=\'rect\' and not(@height = \'0\') and contains(@class, \'nv-bar\')]', ('H_BAR') : '//*[name()=\'rect\' and not(@width = \'0\')]'], 'Standard_Timeout' : 60, 'Copy_Report_Name' : '', 'BaseAdminApiURL' : 'http://savphlpetest64/Sav.Maint.AdminApi'])
        allVariables.put('18.2HF', allVariables['default'] + ['G_LongTimeout' : 120, 'G_SmallTimeout' : 30, 'BaseURL' : 'http://savphlpetest64/Sav.1820.HF.UI', 'Username' : 'cshah_admin', 'Password' : 'Password1234!', 'Database' : 'IPM_EPM50MASTER_502_AUTOMATION', 'DocumentClass' : '100005', 'DocumentType' : '100153', 'DocumentID' : '', 'RecordsInFilter' : '', 'FilterName' : '', 'WMI005' : [('Field1') : '50', ('Field2') : 'WMI005_Auto_test', ('Field3') : 'Value 2', ('Field4') : '20', ('Field5') : '08-10-2018', ('Field6') : '60.129', ('Field7') : '25', ('Field8') : 'Text Field', ('Field9') : '08-10-2018 12:00:00 AM', ('Field10') : 'String Field', ('Field11') : 'Last Name', ('Field4_View') : '$20.00'], 'WMI006' : [('Field1') : '40', ('Field2') : 'WMI006_Auto_test', ('Field3') : 'Value 3', ('Field4') : '10', ('Field5') : '08-16-2018', ('Field6') : '70.854', ('Field7') : '60', ('Field8') : 'Text Field', ('Field9') : '08-16-2018 12:00:00 AM', ('Field10') : 'String Field', ('Field11') : 'Middle Name', ('Field4_View') : '$10.00'], 'WMI007' : [('Field1') : '90', ('Field2') : 'WMI007_Auto_test', ('Field3') : 'Value 1', ('Field4') : '30', ('Field5') : '08-20-2018', ('Field6') : '90.113', ('Field7') : '30', ('Field8') : 'Text Field', ('Field9') : '08-20-2018 12:00:00 AM', ('Field10') : 'String Field', ('Field11') : 'First Name', ('Field4_View') : '$30.00'], 'MW018_DocID' : '', 'ChartType' : [('PIE') : '//*[name() = \'g\' and contains(@class,\'nv-slice\')]', ('V_BAR') : '//*[name()=\'rect\' and not(@height = \'0\') and contains(@class, \'nv-bar\')]', ('H_BAR') : '//*[name()=\'rect\' and not(@width = \'0\')]'], 'Standard_Timeout' : 60, 'Copy_Report_Name' : '', 'BaseAdminApiURL' : 'http://savphlpedev64/Sav.Maint.AdminApi'])
        allVariables.put('19.1-AWS-SQL', allVariables['default'] + ['G_LongTimeout' : 120, 'G_SmallTimeout' : 30, 'BaseURL' : 'http://savphlpedev64/Sav.191Features.Runtime', 'Username' : 'cshah_admin', 'Password' : 'Password1234!', 'Database' : 'AWS_SQLSERVER_QA', 'DocumentClass' : '100005', 'DocumentType' : '100153', 'DocumentID' : '', 'RecordsInFilter' : '', 'FilterName' : '', 'WMI005' : [('Field1') : '50', ('Field2') : 'WMI005_Auto_test', ('Field3') : 'Value 2', ('Field4') : '20', ('Field5') : '08-10-2018', ('Field6') : '60.129', ('Field7') : '25', ('Field8') : 'Text Field', ('Field9') : '08-10-2018 12:00:00 AM', ('Field10') : 'String Field', ('Field11') : 'Last Name', ('Field4_View') : '$20.00'], 'WMI006' : [('Field1') : '40', ('Field2') : 'WMI006_Auto_test', ('Field3') : 'Value 3', ('Field4') : '10', ('Field5') : '08-16-2018', ('Field6') : '70.854', ('Field7') : '60', ('Field8') : 'Text Field', ('Field9') : '08-16-2018 12:00:00 AM', ('Field10') : 'String Field', ('Field11') : 'Middle Name', ('Field4_View') : '$10.00'], 'WMI007' : [('Field1') : '90', ('Field2') : 'WMI007_Auto_test', ('Field3') : 'Value 1', ('Field4') : '30', ('Field5') : '08-20-2018', ('Field6') : '90.113', ('Field7') : '30', ('Field8') : 'Text Field', ('Field9') : '08-20-2018 12:00:00 AM', ('Field10') : 'String Field', ('Field11') : 'First Name', ('Field4_View') : '$30.00'], 'MW018_DocID' : '', 'ChartType' : [('PIE') : '//*[name() = \'g\' and contains(@class,\'nv-slice\')]', ('V_BAR') : '//*[name()=\'rect\' and not(@height = \'0\') and contains(@class, \'nv-bar\')]', ('H_BAR') : '//*[name()=\'rect\' and not(@width = \'0\')]'], 'Standard_Timeout' : 60, 'Copy_Report_Name' : '', 'BaseAdminApiURL' : 'http://savphlpedev64/Sav.Maint.AdminApi'])
        allVariables.put('Feature-Branch', allVariables['default'] + ['G_LongTimeout' : 120, 'G_SmallTimeout' : 30, 'BaseURL' : 'http://savphlpedev64/Sav.191Features.Runtime', 'Username' : 'cshah_admin', 'Password' : 'Password1234!', 'Database' : 'IPM_EPM50MASTER_502_AUTOMATION', 'DocumentClass' : '100005', 'DocumentType' : '100153', 'DocumentID' : '', 'RecordsInFilter' : '', 'FilterName' : '', 'WMI005' : [('Field1') : '50', ('Field2') : 'WMI005_Auto_test', ('Field3') : 'Value 2', ('Field4') : '20', ('Field5') : '08-10-2018', ('Field6') : '60.129', ('Field7') : '25', ('Field8') : 'Text Field', ('Field9') : '08-10-2018 12:00:00 AM', ('Field10') : 'String Field', ('Field11') : 'Last Name', ('Field4_View') : '$20.00'], 'WMI006' : [('Field1') : '40', ('Field2') : 'WMI006_Auto_test', ('Field3') : 'Value 3', ('Field4') : '10', ('Field5') : '08-16-2018', ('Field6') : '70.854', ('Field7') : '60', ('Field8') : 'Text Field', ('Field9') : '08-16-2018 12:00:00 AM', ('Field10') : 'String Field', ('Field11') : 'Middle Name', ('Field4_View') : '$10.00'], 'WMI007' : [('Field1') : '90', ('Field2') : 'WMI007_Auto_test', ('Field3') : 'Value 1', ('Field4') : '30', ('Field5') : '08-20-2018', ('Field6') : '90.113', ('Field7') : '30', ('Field8') : 'Text Field', ('Field9') : '08-20-2018 12:00:00 AM', ('Field10') : 'String Field', ('Field11') : 'First Name', ('Field4_View') : '$30.00'], 'MW018_DocID' : '', 'ChartType' : [('PIE') : '//*[name() = \'g\' and contains(@class,\'nv-slice\')]', ('V_BAR') : '//*[name()=\'rect\' and not(@height = \'0\') and contains(@class, \'nv-bar\')]', ('H_BAR') : '//*[name()=\'rect\' and not(@width = \'0\')]'], 'Standard_Timeout' : 60, 'Copy_Report_Name' : '', 'BaseAdminApiURL' : 'http://savphlpedev64/Sav.Maint.AdminApi'])
        allVariables.put('PEDEV', allVariables['default'] + ['G_LongTimeout' : 120, 'G_SmallTimeout' : 30, 'BaseURL' : 'http://savphlpedev64/Sav.Maint.UI', 'Username' : 'cshah_admin', 'Password' : 'Password1234!', 'Database' : 'IPM_EPM50MASTER_502_AUTOMATION', 'DocumentClass' : '100005', 'DocumentType' : '100153', 'DocumentID' : '', 'RecordsInFilter' : '', 'FilterName' : '', 'WMI005' : [('Field1') : '50', ('Field2') : 'WMI005_Auto_test', ('Field3') : 'Value 2', ('Field4') : '20', ('Field5') : '08-10-2018', ('Field6') : '60.129', ('Field7') : '25', ('Field8') : 'Text Field', ('Field9') : '08-10-2018 12:00:00 AM', ('Field10') : 'String Field', ('Field11') : 'Last Name', ('Field4_View') : '$20.00'], 'WMI006' : [('Field1') : '40', ('Field2') : 'WMI006_Auto_test', ('Field3') : 'Value 3', ('Field4') : '10', ('Field5') : '08-16-2018', ('Field6') : '70.854', ('Field7') : '60', ('Field8') : 'Text Field', ('Field9') : '08-16-2018 12:00:00 AM', ('Field10') : 'String Field', ('Field11') : 'Middle Name', ('Field4_View') : '$10.00'], 'WMI007' : [('Field1') : '90', ('Field2') : 'WMI007_Auto_test', ('Field3') : 'Value 1', ('Field4') : '30', ('Field5') : '08-20-2018', ('Field6') : '90.113', ('Field7') : '30', ('Field8') : 'Text Field', ('Field9') : '08-20-2018 12:00:00 AM', ('Field10') : 'String Field', ('Field11') : 'First Name', ('Field4_View') : '$30.00'], 'MW018_DocID' : '', 'ChartType' : [('PIE') : '//*[name() = \'g\' and contains(@class,\'nv-slice\')]', ('V_BAR') : '//*[name()=\'rect\' and not(@height = \'0\') and contains(@class, \'nv-bar\')]', ('H_BAR') : '//*[name()=\'rect\' and not(@width = \'0\')]'], 'Standard_Timeout' : 60, 'Copy_Report_Name' : '', 'BaseAdminApiURL' : 'http://savphlpedev64/Sav.Maint.AdminApi'])
        
        String profileName = RunConfiguration.getExecutionProfile()
        
        def selectedVariables = allVariables[profileName]
        G_LongTimeout = selectedVariables['G_LongTimeout']
        G_SmallTimeout = selectedVariables['G_SmallTimeout']
        BaseURL = selectedVariables['BaseURL']
        Username = selectedVariables['Username']
        Password = selectedVariables['Password']
        Database = selectedVariables['Database']
        DocumentClass = selectedVariables['DocumentClass']
        DocumentType = selectedVariables['DocumentType']
        DocumentID = selectedVariables['DocumentID']
        RecordsInFilter = selectedVariables['RecordsInFilter']
        FilterName = selectedVariables['FilterName']
        WMI005 = selectedVariables['WMI005']
        WMI006 = selectedVariables['WMI006']
        WMI007 = selectedVariables['WMI007']
        MW018_DocID = selectedVariables['MW018_DocID']
        ChartType = selectedVariables['ChartType']
        Standard_Timeout = selectedVariables['Standard_Timeout']
        Copy_Report_Name = selectedVariables['Copy_Report_Name']
        BaseAdminApiURL = selectedVariables['BaseAdminApiURL']
        
    }
}
