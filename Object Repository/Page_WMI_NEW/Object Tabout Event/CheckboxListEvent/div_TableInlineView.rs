<?xml version="1.0" encoding="UTF-8"?>
<WebElementEntity>
   <description></description>
   <name>div_TableInlineView</name>
   <tag></tag>
   <elementGuidId>3326c523-95ef-4a2d-bb09-353afa4d072d</elementGuidId>
   <selectorMethod>BASIC</selectorMethod>
   <useRalativeImagePath>false</useRalativeImagePath>
   <webElementProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>tag</name>
      <type>Main</type>
      <value>div</value>
   </webElementProperties>
   <webElementProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>id</name>
      <type>Main</type>
      <value>eform_mcb67676_TabContainer_4_body</value>
   </webElementProperties>
   <webElementProperties>
      <isSelected>false</isSelected>
      <matchCondition>equals</matchCondition>
      <name>class</name>
      <type>Main</type>
      <value>ajax__tab_body ajax__scroll_none</value>
   </webElementProperties>
   <webElementProperties>
      <isSelected>false</isSelected>
      <matchCondition>equals</matchCondition>
      <name>text</name>
      <type>Main</type>
      <value>
				
					
                                
						
							

  


    
    
    
    function setContextKey(ajaxExtendercntrlID, interval) {
        
        var callHandler = true;
        var mindiff = 0;
        var callTime = new Date();
        if (document.getElementById('eform_mcb67676_TabContainer_4_TabRef_1_phBO_4_BO_hdnAutocompleteCallTime').value.length > 0) {

            var updateTime = new Date(document.getElementById('eform_mcb67676_TabContainer_4_TabRef_1_phBO_4_BO_hdnAutocompleteCallTime').value);
            var timeDiff = callTime.getTime() - updateTime.getTime();
            mindiff = Math.floor(timeDiff / (1000 * 60));

            if (mindiff >= interval)
                callHandler = true;
            else
                callHandler = false;
        }

        if (callHandler) {

            var cntrl = $find(ajaxExtendercntrlID);
            var contextKey = cntrl.get_contextKey();
            var autoLinkHandlerPage = &quot;AutoLinkHandler.ashx&quot;;
            jQuery.ajax({
                type: 'post',
                data: { prm: contextKey },
                url: autoLinkHandlerPage,
                success: function (data) {
                    try {
                        var returnedData = (data);
                        cntrl.set_contextKey(returnedData);
                        document.getElementById('eform_mcb67676_TabContainer_4_TabRef_1_phBO_4_BO_hdnAutocompleteCallTime').value = new Date();
                    } catch (e) {

                        return false;
                    }
                },
                error: function (jqXHR, textStatus, err) {
                    //do nothing
                }
            });
        }
    }
    


    var prm = Sys.WebForms.PageRequestManager.getInstance();
       prm.add_initializeRequest(initializeRequest);
  
       function initializeRequest(sender, args) {
           if (prm.get_isInAsyncPostBack())
           {
               jqAlert(&quot;Information&quot;, 'Another Request is already in progress.', 'INFO', false);
               args.set_cancel(true);
           }
       }
        
        
        // &lt;EPM45-13138> , &lt;EPM45-13257>
        function disableBackspace() {

            if ((event.keyCode == 8) &amp;&amp; (event.srcElement.nodeName != 'INPUT') &amp;&amp; (event.srcElement.nodeName != 'TEXTAREA') &amp;&amp; (event.srcElement.nodeName != 'DIV')) {
                return false;
            }
        }
        // &lt;/EPM45-13138> , &lt;/EPM45-13257>
       




   .modalBackground
    {
        background-color: filter:alpha(opacity=70);
        opacity: 0.7;
        }




 
  
    
    
    
 


       
      
     
        
        
          
      
        
        
								
									
                    
                        
                            
                                
                                SingleResultView
                                                       
                        
                    
                
								
									
								
									
										
                            
                                  
                            
                        
									
										                                                    
                            
                            

										
                            
                                                         
                            
                        
									
								
									
										
                           
                                  
                            
                        
									                        
                            
                            
	
		
			
				
					
						
							Information:SingleResultView
						
							
								
									
								
									This WMI imparts - Field Events in CheckBoxList for reference object
								
									Configured Events with Set and Section Id, renderas=&quot;checkboxlist&quot;, singleresultview=&quot;true&quot;, disablegridclick=&quot;false&quot;
								
							
						
					
				
			
		
	
		
			
				
					
						
							
						
							
								
									Reference Object Select Option
										
											Value 1
										
											Value 2
										
											Value 3
										
											Value 4
										
											Value 5
										
									
								
									String Field (Value Change)
								
									Lookup Field (overridelookup)
										
										Render As Label
										Render As TextBox
										Render As AjaxDate
										Render As CheckBox
										Render As CheckBox List
										Render As RadioList
										Render As LinkButton
										Render As HtmlEdit
										Render As ChangeDocType
										Render As ChangeDocClass
										Field Render As Grid
										BM Ref New As LinkButton(not in use)
										BM Ref New As DropDown(not in use)
										BM Ref New As CategoryMenu(not in use)
										BM Ref New As CategoryMenu DocType(not in use)
										Reference Object Import
										Reference Object Grid Features
										Reference Object InlineResultView
										Reference Object InlineNew
										Reference Object InlineContentView
										Reference Object SingleResultView
										Reference Object ImportMode Interactive
										Reference Object ImportMode Autocreate
										Reference Object ExtAppURL
										Reference Object AdhocFilter
										Reference Object CustomButton
										Reference Object ImportMode Autocreateandopen
										Render All Field Types
										Render All Multivalue Field Types
										Nested Look up with blank dropdown
										Field Mask
										Render As RadioList with image
										Field Render As Dropdown
										Field Render As Grid with mapping

									
								
							

							
						
					
				
			
		
	

                        
								
									
										                
                    
                        
                            
											
												ReviseReplace
											
										
                        
                        
                            Select a file:
                            
                            
                        
                    
                    
									
								
									 ^ Back to Top
                
								
									
								
									
										
											
										
											
										
									
								
							
       
    




dummy

    
        Enter  Values. *
        
        * Duplicate values will be ignored.
        
       
               
    




						
					
                            
				
					
                                
						
							

  


    
    
    
    function setContextKey(ajaxExtendercntrlID, interval) {
        
        var callHandler = true;
        var mindiff = 0;
        var callTime = new Date();
        if (document.getElementById('eform_mcb67676_TabContainer_4_TabRef_2_phBO_5_BO_hdnAutocompleteCallTime').value.length > 0) {

            var updateTime = new Date(document.getElementById('eform_mcb67676_TabContainer_4_TabRef_2_phBO_5_BO_hdnAutocompleteCallTime').value);
            var timeDiff = callTime.getTime() - updateTime.getTime();
            mindiff = Math.floor(timeDiff / (1000 * 60));

            if (mindiff >= interval)
                callHandler = true;
            else
                callHandler = false;
        }

        if (callHandler) {

            var cntrl = $find(ajaxExtendercntrlID);
            var contextKey = cntrl.get_contextKey();
            var autoLinkHandlerPage = &quot;AutoLinkHandler.ashx&quot;;
            jQuery.ajax({
                type: 'post',
                data: { prm: contextKey },
                url: autoLinkHandlerPage,
                success: function (data) {
                    try {
                        var returnedData = (data);
                        cntrl.set_contextKey(returnedData);
                        document.getElementById('eform_mcb67676_TabContainer_4_TabRef_2_phBO_5_BO_hdnAutocompleteCallTime').value = new Date();
                    } catch (e) {

                        return false;
                    }
                },
                error: function (jqXHR, textStatus, err) {
                    //do nothing
                }
            });
        }
    }
    


    var prm = Sys.WebForms.PageRequestManager.getInstance();
       prm.add_initializeRequest(initializeRequest);
  
       function initializeRequest(sender, args) {
           if (prm.get_isInAsyncPostBack())
           {
               jqAlert(&quot;Information&quot;, 'Another Request is already in progress.', 'INFO', false);
               args.set_cancel(true);
           }
       }
        
        
        // &lt;EPM45-13138> , &lt;EPM45-13257>
        function disableBackspace() {

            if ((event.keyCode == 8) &amp;&amp; (event.srcElement.nodeName != 'INPUT') &amp;&amp; (event.srcElement.nodeName != 'TEXTAREA') &amp;&amp; (event.srcElement.nodeName != 'DIV')) {
                return false;
            }
        }
        // &lt;/EPM45-13138> , &lt;/EPM45-13257>
       




   .modalBackground
    {
        background-color: filter:alpha(opacity=70);
        opacity: 0.7;
        }




 
  
    
    
    
 


       
      
     
        
        
          
      
        
        
								
									
                    
                        
                            
                                
                                InlineView
                                                       
                        
                    
                
								
									
								
									
										
                            
                                  
                            
                        
									                                                    
                            
                            
	
		
			
                                    
                                        
                                            
                                                                                                    
                                                                                                                                                
                                                
                                                
                                                
                                                
                                                 
                                                
                                                                                                          
                                                
                                                 
                                                     
                                                
                                                
				1
				2
				3
				4
				5
				6
				7
				8
				9
				10
				11
				12
				13
				14
				15
				16
				17
				18
				19
				20
				21
				22
				23
				24
				25
				26
				27
				28
				29
				30
				31
				32
				33
				34
				35
				36
				37
				38
				39
				40
				41
				42
				43
				44
				45
				46
				47
				48
				49
				50
				51
				52
				53
				54
				55
				56
				57
				58
				59
				60
				61
				62
				63
				64
				65
				66
				67
				68
				69
				70
				71
				72
				73
				74
				75
				76
				77
				78
				79
				80
				81
				82
				83
				84
				85
				86
				87
				88
				89
				90
				91
				92
				93

			
                                                 of 93
                                                >
                                                >>

                                                                                            
                                            
                                        
                                    
                                
		
			params   Doc IDCurrent Revision #Doc Type NameDoc User DateDoc Create DateBM StringBM String1BM IntBM Int MVBM Small Int MVDoc Created ByBM DateTimeBM DateBM string2BM String MVCustomer NameBM Small IntBM Text
		
			/Sav.1820.HF.UI/WMI/wmi.aspx?id=&amp;opwm=&amp;opm=WebDialog&amp;loc=REFRENCEDOC&amp;did=7738644F46317734662F4C5542554173522F6F5977413D3D&amp;pdwid=New&amp;aid=0&amp;dtid=100002&amp;dcid=100001&amp;rdocid=7738644F46317734662F4C5542554173522F6F5977413D3D&amp;|REFRENCEDOC|100003||100002|100001100002|||Render As TextBox  -  01/08/2019|||||1000031000021000030Render As TextBox07-22-2016 05:28:00 AM07-22-2016 05:28:00 AMChintan Shah - 12-27-2018 06:53:48 AM 5734000  Chintan Shah 11-11-2018    56
		
			/Sav.1820.HF.UI/WMI/wmi.aspx?id=&amp;opwm=&amp;opm=WebDialog&amp;loc=REFRENCEDOC&amp;did=59357563575756746845357175525754624F6D4B4B413D3D&amp;pdwid=New&amp;aid=0&amp;dtid=100006&amp;dcid=100001&amp;rdocid=59357563575756746845357175525754624F6D4B4B413D3D&amp;|REFRENCEDOC|100008||100006|100001100006|||Render As RadioList  -  01/02/2019|||||1000081000061000080Render As RadioList07-25-2016 03:42:00 AM07-25-2016 03:42:00 AM  7000  Chintan Shah01-01-1980 12:00:00 AM12-27-2017     
		
			/Sav.1820.HF.UI/WMI/wmi.aspx?id=&amp;opwm=&amp;opm=WebDialog&amp;loc=REFRENCEDOC&amp;did=776F3430504D57366642366579636469337548456A673D3D&amp;pdwid=New&amp;aid=0&amp;dtid=100001&amp;dcid=100001&amp;rdocid=776F3430504D57366642366579636469337548456A673D3D&amp;|REFRENCEDOC|100009||100001|100001100001|||Render As Label  -  01/25/2018|||||1000091000011000090Render As Label07-25-2016 05:55:00 AM07-25-2016 05:55:00 AMshow 11902  Reema07-25-2016 05:55:00 AM     You selected Option 1
		
			/Sav.1820.HF.UI/WMI/wmi.aspx?id=&amp;opwm=&amp;opm=WebDialog&amp;loc=REFRENCEDOC&amp;did=5A3777765266396D6A6F6F746B57777175612B532B773D3D&amp;pdwid=New&amp;aid=0&amp;dtid=100008&amp;dcid=100001&amp;rdocid=5A3777765266396D6A6F6F746B57777175612B532B773D3D&amp;|REFRENCEDOC|100014||100008|100001100008|||Render As HtmlEdit  -  06/11/2018|||||1000141000081000140Render As HtmlEdit07-25-2016 10:02:00 AM07-25-2016 10:02:00 AM
hide
 999  ManojG01-29-1980 12:00:00 AM     
bbbbbbbaabbxyzpqr12356666

		
			/Sav.1820.HF.UI/WMI/wmi.aspx?id=&amp;opwm=&amp;opm=WebDialog&amp;loc=REFRENCEDOC&amp;did=47776F397849415A78685A36484D56764467646233673D3D&amp;pdwid=New&amp;aid=0&amp;dtid=100007&amp;dcid=100001&amp;rdocid=47776F397849415A78685A36484D56764467646233673D3D&amp;|REFRENCEDOC|100020||100007|100001100007|||BM Render As LinkButton  -  07/26/2016|||||1000201000071000200Render As LinkButton07-26-2016 10:28:00 AM07-26-2016 10:28:00 AM     Reema       
		
	

                            
                                                         
                            
                        
								
									
										
											
                                        
                                         Render As TextBox  -  01/08/2019 
                                    
										
											
												
                                        
                                            
                                             
                                             
                                             
                                            
                                             
                                                                                   
                                    
											
										
									
										
                           
                                  
                            
                        
									                        
                            
                            
	
		
			
				
					
						
							Information:InlineView
						
							
								
									
								
									This WMI imparts - Field Events in CheckBoxList for reference object
								
									Configured Events with Set and Section Id, renderas=&quot;checkboxlist&quot;, inlineresultview=&quot;true&quot;, disablegridclick=&quot;false&quot;
								
							
						
					
				
			
		
	
		
			
				
					
						
							
						
							
								
									Reference Object Select Option (inlineView)
										
											Value 1
										
											Value 2
										
											Value 3
										
											Value 4
										
											Value 5
										
									
								
									String Field (Value Change)
								
									Lookup Field (overridelookup)
										
										Render As Label
										Render As TextBox
										Render As AjaxDate
										Render As CheckBox
										Render As CheckBox List
										Render As RadioList
										Render As LinkButton
										Render As HtmlEdit
										Render As ChangeDocType
										Render As ChangeDocClass
										Field Render As Grid
										BM Ref New As LinkButton(not in use)
										BM Ref New As DropDown(not in use)
										BM Ref New As CategoryMenu(not in use)
										BM Ref New As CategoryMenu DocType(not in use)
										Reference Object Import
										Reference Object Grid Features
										Reference Object InlineResultView
										Reference Object InlineNew
										Reference Object InlineContentView
										Reference Object SingleResultView
										Reference Object ImportMode Interactive
										Reference Object ImportMode Autocreate
										Reference Object ExtAppURL
										Reference Object AdhocFilter
										Reference Object CustomButton
										Reference Object ImportMode Autocreateandopen
										Render All Field Types
										Render All Multivalue Field Types
										Nested Look up with blank dropdown
										Field Mask
										Render As RadioList with image
										Field Render As Dropdown
										Field Render As Grid with mapping

									
								
							

							
						
					
				
			
		
	

                        
								
									
										                
                    
                        
                            
											
												ReviseReplace
											
										
                        
                        
                            Select a file:
                            
                            
                        
                    
                    
									
								
									 ^ Back to Top
                
								
									
								
									
										
											
										
											
										
									
								
							
       
    




dummy

    
        Enter  Values. *
        
        * Duplicate values will be ignored.
        
       
               
    




						
					
                            
				
			</value>
   </webElementProperties>
   <webElementProperties>
      <isSelected>false</isSelected>
      <matchCondition>equals</matchCondition>
      <name>xpath</name>
      <type>Main</type>
      <value>id(&quot;eform_mcb67676_TabContainer_4_body&quot;)</value>
   </webElementProperties>
   <webElementProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>ref_element</name>
      <type>Main</type>
      <value>Object Repository/Page_WMI_NEW/Object Tabout Event/CheckboxListEvent/iframe_Close Window_ContentPla</value>
   </webElementProperties>
   <webElementXpaths>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>xpath:attributes</name>
      <value>//div[@id='eform_mcb67676_TabContainer_4_body']</value>
   </webElementXpaths>
   <webElementXpaths>
      <isSelected>false</isSelected>
      <matchCondition>equals</matchCondition>
      <name>xpath:idRelative</name>
      <value>//div[@id='eform_mcb67676_TabContainer_4']/div[2]</value>
   </webElementXpaths>
   <webElementXpaths>
      <isSelected>false</isSelected>
      <matchCondition>equals</matchCondition>
      <name>xpath:neighbor</name>
      <value>(.//*[normalize-space(text()) and normalize-space(.)='InlineView'])[1]/following::div[1]</value>
   </webElementXpaths>
   <webElementXpaths>
      <isSelected>false</isSelected>
      <matchCondition>equals</matchCondition>
      <name>xpath:neighbor</name>
      <value>(.//*[normalize-space(text()) and normalize-space(.)='SingleResultView'])[1]/following::div[1]</value>
   </webElementXpaths>
   <webElementXpaths>
      <isSelected>false</isSelected>
      <matchCondition>equals</matchCondition>
      <name>xpath:position</name>
      <value>//tr[5]/td/div/div[2]</value>
   </webElementXpaths>
</WebElementEntity>
