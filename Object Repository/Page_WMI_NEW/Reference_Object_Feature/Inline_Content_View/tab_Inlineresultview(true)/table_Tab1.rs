<?xml version="1.0" encoding="UTF-8"?>
<WebElementEntity>
   <description></description>
   <name>table_Tab1</name>
   <tag></tag>
   <elementGuidId>49a7a6ed-90f9-41f0-b449-9eb25fc037b1</elementGuidId>
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
      <isSelected>true</isSelected>
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




 
  
    
    
    
 


       
      
     
        
        
          
      
        
        
								
									
                    
                        
                            
                                
                                1) InlineContentView-inlineresultview(true)
                                                       
                        
                    
                
								
									
								
									
										
                            
                                  
                            
                        
									
										                                                    
                            
                            
											
												
													
                                    
                                        
                                            
                                                                                                    
                                                                                                                                                
                                                
                                                
                                                
                                                
                                                 
                                                
                                                                                                          
                                                
                                                 
                                                     
                                                
                                                
														1
														2
														3
														4
														5
														6

													
                                                 of 6
                                                >
                                                >>

                                                                                            
                                            
                                        
                                    
                                
												
													params   Doc IDCurrent Revision #Doc Type NameDoc User DateDoc Create DateBM StringBM String1BM IntBM Int MVBM Small Int MVDoc Created ByBM DateTimeBM DateBM string2BM String MVCustomer NameBM Small IntBM Text
												
													/Sav.Main.UI/WMI/wmi.aspx?id=&amp;opwm=&amp;opm=WebDialog&amp;loc=REFRENCEDOC&amp;did=4745713754655732714655613044315964316C6279773D3D&amp;pdwid=New&amp;aid=0&amp;dtid=100034&amp;dcid=100004&amp;rdocid=4745713754655732714655613044315964316C6279773D3D&amp;|REFRENCEDOC|101119||100034|100004100034||| Reference Object InlineContentView  -  05/12/2017 |||||1011191000341011190Reference Object InlineContentView08-18-2016 10:18:00 AM08-18-2016 10:18:00 AMtest    ManojG       
												
													/Sav.Main.UI/WMI/wmi.aspx?id=&amp;opwm=&amp;opm=WebDialog&amp;loc=REFRENCEDOC&amp;did=6E6E48664F6A78564930664956612F763147796D5A513D3D&amp;pdwid=New&amp;aid=0&amp;dtid=100034&amp;dcid=100004&amp;rdocid=6E6E48664F6A78564930664956612F763147796D5A513D3D&amp;|REFRENCEDOC|101120||100034|100004100034||| Reference Object InlineContentView  -  03/22/2017 |||||1011201000341011200Reference Object InlineContentView08-18-2016 10:25:00 AM08-18-2016 10:25:00 AM     Amol       
												
													/Sav.Main.UI/WMI/wmi.aspx?id=&amp;opwm=&amp;opm=WebDialog&amp;loc=REFRENCEDOC&amp;did=476943395473476F666D357557436B443250526347673D3D&amp;pdwid=New&amp;aid=0&amp;dtid=100034&amp;dcid=100004&amp;rdocid=476943395473476F666D357557436B443250526347673D3D&amp;|REFRENCEDOC|101128||100034|100004100034||| Reference Object InlineContentView  -  09/08/2017 |||||1011281000341011280Reference Object InlineContentView08-19-2016 07:16:00 AM08-19-2016 07:16:00 AMtest    Amol       
												
													/Sav.Main.UI/WMI/wmi.aspx?id=&amp;opwm=&amp;opm=WebDialog&amp;loc=REFRENCEDOC&amp;did=78753150307A7853644133576C486C683244546F30413D3D&amp;pdwid=New&amp;aid=0&amp;dtid=100034&amp;dcid=100004&amp;rdocid=78753150307A7853644133576C486C683244546F30413D3D&amp;|REFRENCEDOC|101167||100034|100004100034||| Reference Object InlineContentView  -  03/17/2017 |||||1011671000341011670Reference Object InlineContentView08-23-2016 07:01:00 AM08-23-2016 07:02:00 AM     ManojG       
												
													/Sav.Main.UI/WMI/wmi.aspx?id=&amp;opwm=&amp;opm=WebDialog&amp;loc=REFRENCEDOC&amp;did=5A6134684C657774496636317A2B55585165454342673D3D&amp;pdwid=New&amp;aid=0&amp;dtid=100034&amp;dcid=100004&amp;rdocid=5A6134684C657774496636317A2B55585165454342673D3D&amp;|REFRENCEDOC|101224||100034|100004100034||| Reference Object InlineContentView  -  09/08/2017 |||||1012241000341012240Reference Object InlineContentView08-26-2016 07:47:00 AM08-26-2016 07:47:00 AM     Amol       
												
											
										
                            
                                                         
                            
                        
									
								
									
										
											
												
                                        
                                         Reference Object InlineContentView  -  05/12/2017 
                                    
											
										
											
												
                                        
                                            
                                             
                                             
                                             
                                            
                                             
                                                                                   
                                    
											
										
									
										
                           
                                  
                            
                        
									
										                        
                            
                            
											
												
													
														BM String
													
														BM Float MV
															
																
															
																

																
															
														
													
														BM Small Int MV
															
																
															
																

																
															
														
													
														BM Currency
													
														BM Date
													
														BM Text MV
															
																
															
																

																
															
														
													
														BM DateTime MV
															
																
															
																

																
															
														
													
														BM Float
													
														BM Small Int
													
														BM Text
													
														BM DateTime
													
														BM Int MV
															
																
															
																

																
															
														
													
												
													
														BM String MV
															
																
															
																

																
															
														
													
														BM Currency MV
															
																
															
																

																
															
														
													
														BM Date MV
															
																
															
																

																
															
														
													
														BM Int
													
														BM String WL
															
															Value 1
															Value 2
															Value 3
															Value 4
															Value 5

														
													
														BM String Mask
													
														BM String WL MV
															
																
																	
																	Value 1
																	Value 2
																	Value 3
																	Value 4
																	Value 5

																
															
																

																
															
														
													
														BM String Nested Field
															
															N/A
															No
															Yes

														
													
														BM String Lookup Field
													
												
											
										
                        
									
								
									
										                
                    
                        
                            
											
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




 
  
    
    
    
 


       
      
     
        
        
          
      
        
        
								
									
                    
                        
                            
                                
                                2) InlineContentView-inlineresultview(false)
                                                       
                        
                    
                
								
									
								
									
										
                            
                                  
                            
                        
									
										                                                    
                            
                            
											
												
													
                                    
                                        
                                            
                                                                                                    
                                                                                                                                                
                                                
                                                
                                                
                                                
                                                 
                                                
                                                                                                          
                                                
                                                 
                                                     
                                                
                                                
														1
														2
														3
														4
														5
														6

													
                                                 of 6
                                                >
                                                >>

                                                                                            
                                            
                                        
                                    
                                
												
													params   Doc IDCurrent Revision #Doc Type NameDoc User DateDoc Create DateBM StringBM String1BM IntBM Int MVBM Small Int MVDoc Created ByBM DateTimeBM DateBM string2BM String MVCustomer NameBM Small IntBM Text
												
													/Sav.Main.UI/WMI/wmi.aspx?id=&amp;opwm=&amp;opm=IE&amp;loc=REFRENCEDOC&amp;did=4745713754655732714655613044315964316C6279773D3D&amp;pdwid=New&amp;aid=0&amp;dtid=100034&amp;dcid=100004&amp;rdocid=4745713754655732714655613044315964316C6279773D3D&amp;|REFRENCEDOC|101119||100034|100004100034||| Reference Object InlineContentView  -  05/12/2017 ||||IE|1011191000341011190Reference Object InlineContentView08-18-2016 10:18:00 AM08-18-2016 10:18:00 AMtest    ManojG       
												
													/Sav.Main.UI/WMI/wmi.aspx?id=&amp;opwm=&amp;opm=IE&amp;loc=REFRENCEDOC&amp;did=6E6E48664F6A78564930664956612F763147796D5A513D3D&amp;pdwid=New&amp;aid=0&amp;dtid=100034&amp;dcid=100004&amp;rdocid=6E6E48664F6A78564930664956612F763147796D5A513D3D&amp;|REFRENCEDOC|101120||100034|100004100034||| Reference Object InlineContentView  -  03/22/2017 ||||IE|1011201000341011200Reference Object InlineContentView08-18-2016 10:25:00 AM08-18-2016 10:25:00 AM     Amol       
												
													/Sav.Main.UI/WMI/wmi.aspx?id=&amp;opwm=&amp;opm=IE&amp;loc=REFRENCEDOC&amp;did=476943395473476F666D357557436B443250526347673D3D&amp;pdwid=New&amp;aid=0&amp;dtid=100034&amp;dcid=100004&amp;rdocid=476943395473476F666D357557436B443250526347673D3D&amp;|REFRENCEDOC|101128||100034|100004100034||| Reference Object InlineContentView  -  09/08/2017 ||||IE|1011281000341011280Reference Object InlineContentView08-19-2016 07:16:00 AM08-19-2016 07:16:00 AMtest    Amol       
												
													/Sav.Main.UI/WMI/wmi.aspx?id=&amp;opwm=&amp;opm=IE&amp;loc=REFRENCEDOC&amp;did=78753150307A7853644133576C486C683244546F30413D3D&amp;pdwid=New&amp;aid=0&amp;dtid=100034&amp;dcid=100004&amp;rdocid=78753150307A7853644133576C486C683244546F30413D3D&amp;|REFRENCEDOC|101167||100034|100004100034||| Reference Object InlineContentView  -  03/17/2017 ||||IE|1011671000341011670Reference Object InlineContentView08-23-2016 07:01:00 AM08-23-2016 07:02:00 AM     ManojG       
												
													/Sav.Main.UI/WMI/wmi.aspx?id=&amp;opwm=&amp;opm=IE&amp;loc=REFRENCEDOC&amp;did=5A6134684C657774496636317A2B55585165454342673D3D&amp;pdwid=New&amp;aid=0&amp;dtid=100034&amp;dcid=100004&amp;rdocid=5A6134684C657774496636317A2B55585165454342673D3D&amp;|REFRENCEDOC|101224||100034|100004100034||| Reference Object InlineContentView  -  09/08/2017 ||||IE|1012241000341012240Reference Object InlineContentView08-26-2016 07:47:00 AM08-26-2016 07:47:00 AM     Amol       
												
											
										
                            
                                                         
                            
                        
									
								
									
										
                           
                                  
                            
                        
									
										                        
                            
                            

										
                        
									
								
									 ^ Back to Top
                
								
									
								
									
										
											
										
											
										
									
								
							
       
    




dummy

    
        Enter  Values. *
        
        * Duplicate values will be ignored.
        
       
               
    




						
					
                            
				
					
                                
						
							

  


    
    
    
    function setContextKey(ajaxExtendercntrlID, interval) {
        
        var callHandler = true;
        var mindiff = 0;
        var callTime = new Date();
        if (document.getElementById('eform_mcb67676_TabContainer_4_TabRef_3_phBO_6_BO_hdnAutocompleteCallTime').value.length > 0) {

            var updateTime = new Date(document.getElementById('eform_mcb67676_TabContainer_4_TabRef_3_phBO_6_BO_hdnAutocompleteCallTime').value);
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
                        document.getElementById('eform_mcb67676_TabContainer_4_TabRef_3_phBO_6_BO_hdnAutocompleteCallTime').value = new Date();
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




 
  
    
    
    
 


       
      
     
        
        
          
      
        
        
								
									
                    
                        
                            
                                
                                3) InlineContentView-inlineresultview(true), drag and drop functionality
                                                       
                        
                    
                
								
									
								
									
										
                            
                                  
                            
                        
									
										                                                    
                            
                            
											
												
													
                                    
                                        
                                            
                                                                                                    
                                                                                                                                                
                                                
                                                
                                                
                                                
                                                 
                                                
                                                                                                          
                                                
                                                 
                                                     
                                                
                                                
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

													
                                                 of 10
                                                >
                                                >>

                                                                                            
                                            
                                        
                                    
                                
												
													params   Doc IDCurrent Revision #Doc Type NameDoc User DateDoc Create DateBM StringBM String1BM IntBM Int MVBM Small Int MVDoc Created ByBM DateTimeBM DateBM string2BM String MVCustomer NameBM Small IntBM Text
												
													/Sav.Main.UI/WMI/wmi.aspx?id=&amp;opwm=&amp;opm=WebDialog&amp;loc=REFRENCEDOC&amp;did=6F4A62655661316331774439424250384577557259773D3D&amp;pdwid=New&amp;aid=0&amp;dtid=100003&amp;dcid=100001&amp;rdocid=6F4A62655661316331774439424250384577557259773D3D&amp;|REFRENCEDOC|101109||100003|100001100003||| Render As AjaxDate  -  03/22/2017 |||||1011091000031011090Render As AjaxDate08-18-2016 06:04:00 AM08-18-2016 06:05:00 AM     Amol08-18-2016 06:04:00 AM08-18-2016     
												
													/Sav.Main.UI/WMI/wmi.aspx?id=&amp;opwm=&amp;opm=WebDialog&amp;loc=REFRENCEDOC&amp;did=3361622B397070322F70653242444A377777576B36413D3D&amp;pdwid=New&amp;aid=0&amp;dtid=100003&amp;dcid=100001&amp;rdocid=3361622B397070322F70653242444A377777576B36413D3D&amp;|REFRENCEDOC|101118||100003|100001100003||| Render As AjaxDate  -  03/17/2017 |||||1011181000031011180Render As AjaxDate08-18-2016 10:13:00 AM08-18-2016 10:13:00 AM12    ManojG     1 
												
													/Sav.Main.UI/WMI/wmi.aspx?id=&amp;opwm=&amp;opm=WebDialog&amp;loc=REFRENCEDOC&amp;did=665261526F476A537A3963727249734D79332F3238413D3D&amp;pdwid=New&amp;aid=0&amp;dtid=100003&amp;dcid=100001&amp;rdocid=665261526F476A537A3963727249734D79332F3238413D3D&amp;|REFRENCEDOC|101139||100003|100001100003||| Render As AjaxDate  -  03/22/2017 |||||1011391000031011390Render As AjaxDate08-22-2016 07:33:00 AM08-22-2016 07:33:00 AM1223    Amol       
												
													/Sav.Main.UI/WMI/wmi.aspx?id=&amp;opwm=&amp;opm=WebDialog&amp;loc=REFRENCEDOC&amp;did=397757715966307567333151564874663359757379673D3D&amp;pdwid=New&amp;aid=0&amp;dtid=100003&amp;dcid=100001&amp;rdocid=397757715966307567333151564874663359757379673D3D&amp;|REFRENCEDOC|101146||100003|100001100003||| Render As AjaxDate  -  03/22/2017 |||||1011461000031011460Render As AjaxDate08-22-2016 10:34:00 AM08-22-2016 10:34:00 AM     Amol08-22-2016 10:34:00 AM10-12-2030     
												
													/Sav.Main.UI/WMI/wmi.aspx?id=&amp;opwm=&amp;opm=WebDialog&amp;loc=REFRENCEDOC&amp;did=44714D35673862474B417359347353745774374F52773D3D&amp;pdwid=New&amp;aid=0&amp;dtid=100003&amp;dcid=100001&amp;rdocid=44714D35673862474B417359347353745774374F52773D3D&amp;|REFRENCEDOC|101175||100003|100001100003||| Render As AjaxDate  -  03/22/2017 |||||1011751000031011750Render As AjaxDate08-23-2016 08:21:00 AM08-23-2016 08:21:00 AM     Amol08-23-2016 08:21:00 AM08-23-2016     
												
											
										
                            
                                                         
                            
                        
									
								
									
										
											
												
                                        
                                         Render As AjaxDate  -  03/22/2017 
                                    
											
										
											
												
                                        
                                            
                                             
                                             
                                             
                                            
                                             
                                                                                   
                                    
											
										
									
										
                           
                                  
                            
                        
									
										                        
                            
                            
											
												
													
														BM String
													
														BM Float MV
															
																
															
																

																
															
														
													
														BM Small Int MV
															
																
															
																

																
															
														
													
														BM Currency
													
														BM Date
													
														BM Text MV
															
																
															
																

																
															
														
													
														BM DateTime MV
															
																
															
																

																
															
														
													
														BM Float
													
														BM Small Int
													
														BM Text
													
														BM DateTime
													
														BM Int MV
															
																
															
																

																
															
														
													
														BM String MV
															
																
															
																

																
															
														
													
														BM Currency MV
															
																
															
																

																
															
														
													
														BM Date MV
															
																
															
																
																	08-12-2016
																	09-24-2016

																
															
														
													
														BM Int
													
														BM String WL
															
															Value 1
															Value 2
															Value 3
															Value 4
															Value 5

														
													
														BM String WL1
															
															images/bullet_green.ico
															images/bullet_red.ico
															images/bullet_yellow.ico

														
													
														BM String WL2
															
															images/bullet_green.ico
															images/bullet_red.ico
															images/bullet_yellow.ico

														
													
														BM String Mask
													
														BM String WL MV
															
																
																	
																	Value 1
																	Value 2
																	Value 3
																	Value 4
																	Value 5

																
															
																

																
															
														
													
														BM String Nested Field
															
															N/A
															No
															Yes

														
													
														BM String Lookup Field
															
															No
															Yes

														
													
														BM Str Mask
													
														BM Text mask
													
														BM Small Int Mask
													
														BM Str Mask D
													
														BM Curr Mask
													
												
													
														BM Str Mask B
													
														BM Long Int Mask
													
														BM Date mask
													
														BM Str Mask A
													
														BM Float mask
													
														BM DateTime mask
													
														BM Str Mask E
													
														BM Str Mask F
													
														BM Str Mask G
													
														BM Str Mask H
													
														BM Str Mask I
													
														BM Str Mask J
													
														BM Str Mask K
													
														BM Str Mask L
													
														BM Str Mask M
													
														BM Str Mask N
													
														BM Str Mask O
													
														BM Str Mask Q
													
														BM Str Mask P
													
														BM Str WL A
															

														
													
														BM Str WL B
															

														
													
														Max Currency
													
														BM String1
													
														BM string2
													
														Ext Name Field
													
														Datetimefld refgrid*
													
														Max Float
													
												
											
										
                        
									
								
									
										                
                    
                        
                            
											
												ReviseReplace
											
										
                        
                        
                            
                            
                            
											
												Select or drop file:
												
                                        Drop file here
                                    
												                                       
                                        
                                        
                                    
											
										
										
                        
                    
                    
									
								
									 ^ Back to Top
                
								
									
								
									
										
											
										
											
										
									
								
							
       
    




dummy

    
        Enter  Values. *
        
        * Duplicate values will be ignored.
        
       
               
    




						
					
                            
				
					
                                
						
							

  


    
    
    
    function setContextKey(ajaxExtendercntrlID, interval) {
        
        var callHandler = true;
        var mindiff = 0;
        var callTime = new Date();
        if (document.getElementById('eform_mcb67676_TabContainer_4_TabRef_4_phBO_7_BO_hdnAutocompleteCallTime').value.length > 0) {

            var updateTime = new Date(document.getElementById('eform_mcb67676_TabContainer_4_TabRef_4_phBO_7_BO_hdnAutocompleteCallTime').value);
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
                        document.getElementById('eform_mcb67676_TabContainer_4_TabRef_4_phBO_7_BO_hdnAutocompleteCallTime').value = new Date();
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




 
  
    
    
    
 


       
      
     
        
        
          
      
        
        
								
									
                    
                        
                            
                                
                                4) InlineContentView-inlineresultview(true), hidecontentupload=true
                                                       
                        
                    
                
								
									
								
									
										
                            
                                  
                            
                        
									
										                                                    
                            
                            
											
												
													
                                    
                                        
                                            
                                                                                                    
                                                                                                                                                
                                                
                                                
                                                
                                                
                                                 
                                                
                                                                                                          
                                                
                                                 
                                                     
                                                
                                                
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

													
                                                 of 10
                                                >
                                                >>

                                                                                            
                                            
                                        
                                    
                                
												
													params   Doc IDCurrent Revision #Doc Type NameDoc User DateDoc Create DateBM StringBM String1BM IntBM Int MVBM Small Int MVDoc Created ByBM DateTimeBM DateBM string2BM String MVCustomer NameBM Small IntBM Text
												
													/Sav.Main.UI/WMI/wmi.aspx?id=&amp;opwm=&amp;opm=WebDialog&amp;loc=REFRENCEDOC&amp;did=6F4A62655661316331774439424250384577557259773D3D&amp;pdwid=New&amp;aid=0&amp;dtid=100003&amp;dcid=100001&amp;rdocid=6F4A62655661316331774439424250384577557259773D3D&amp;|REFRENCEDOC|101109||100003|100001100003||| Render As AjaxDate  -  03/22/2017 |||||1011091000031011090Render As AjaxDate08-18-2016 06:04:00 AM08-18-2016 06:05:00 AM     Amol08-18-2016 06:04:00 AM08-18-2016     
												
													/Sav.Main.UI/WMI/wmi.aspx?id=&amp;opwm=&amp;opm=WebDialog&amp;loc=REFRENCEDOC&amp;did=3361622B397070322F70653242444A377777576B36413D3D&amp;pdwid=New&amp;aid=0&amp;dtid=100003&amp;dcid=100001&amp;rdocid=3361622B397070322F70653242444A377777576B36413D3D&amp;|REFRENCEDOC|101118||100003|100001100003||| Render As AjaxDate  -  03/17/2017 |||||1011181000031011180Render As AjaxDate08-18-2016 10:13:00 AM08-18-2016 10:13:00 AM12    ManojG     1 
												
													/Sav.Main.UI/WMI/wmi.aspx?id=&amp;opwm=&amp;opm=WebDialog&amp;loc=REFRENCEDOC&amp;did=665261526F476A537A3963727249734D79332F3238413D3D&amp;pdwid=New&amp;aid=0&amp;dtid=100003&amp;dcid=100001&amp;rdocid=665261526F476A537A3963727249734D79332F3238413D3D&amp;|REFRENCEDOC|101139||100003|100001100003||| Render As AjaxDate  -  03/22/2017 |||||1011391000031011390Render As AjaxDate08-22-2016 07:33:00 AM08-22-2016 07:33:00 AM1223    Amol       
												
													/Sav.Main.UI/WMI/wmi.aspx?id=&amp;opwm=&amp;opm=WebDialog&amp;loc=REFRENCEDOC&amp;did=397757715966307567333151564874663359757379673D3D&amp;pdwid=New&amp;aid=0&amp;dtid=100003&amp;dcid=100001&amp;rdocid=397757715966307567333151564874663359757379673D3D&amp;|REFRENCEDOC|101146||100003|100001100003||| Render As AjaxDate  -  03/22/2017 |||||1011461000031011460Render As AjaxDate08-22-2016 10:34:00 AM08-22-2016 10:34:00 AM     Amol08-22-2016 10:34:00 AM10-12-2030     
												
													/Sav.Main.UI/WMI/wmi.aspx?id=&amp;opwm=&amp;opm=WebDialog&amp;loc=REFRENCEDOC&amp;did=44714D35673862474B417359347353745774374F52773D3D&amp;pdwid=New&amp;aid=0&amp;dtid=100003&amp;dcid=100001&amp;rdocid=44714D35673862474B417359347353745774374F52773D3D&amp;|REFRENCEDOC|101175||100003|100001100003||| Render As AjaxDate  -  03/22/2017 |||||1011751000031011750Render As AjaxDate08-23-2016 08:21:00 AM08-23-2016 08:21:00 AM     Amol08-23-2016 08:21:00 AM08-23-2016     
												
											
										
                            
                                                         
                            
                        
									
								
									
										
											
												
                                        
                                         Render As AjaxDate  -  03/22/2017 
                                    
											
										
											
												
                                        
                                            
                                             
                                             
                                             
                                            
                                             
                                                                                   
                                    
											
										
									
										
                           
                                  
                            
                        
									
										                        
                            
                            
											
												
													
														BM String
													
														BM Float MV
															
																
															
																

																
															
														
													
														BM Small Int MV
															
																
															
																

																
															
														
													
														BM Currency
													
														BM Date
													
														BM Text MV
															
																
															
																

																
															
														
													
														BM DateTime MV
															
																
															
																

																
															
														
													
														BM Float
													
														BM Small Int
													
														BM Text
													
														BM DateTime
													
														BM Int MV
															
																
															
																

																
															
														
													
														BM String MV
															
																
															
																

																
															
														
													
														BM Currency MV
															
																
															
																

																
															
														
													
														BM Date MV
															
																
															
																
																	08-12-2016
																	09-24-2016

																
															
														
													
														BM Int
													
														BM String WL
															
															Value 1
															Value 2
															Value 3
															Value 4
															Value 5

														
													
														BM String WL1
															
															images/bullet_green.ico
															images/bullet_red.ico
															images/bullet_yellow.ico

														
													
														BM String WL2
															
															images/bullet_green.ico
															images/bullet_red.ico
															images/bullet_yellow.ico

														
													
														BM String Mask
													
														BM String WL MV
															
																
																	
																	Value 1
																	Value 2
																	Value 3
																	Value 4
																	Value 5

																
															
																

																
															
														
													
														BM String Nested Field
															
															N/A
															No
															Yes

														
													
														BM String Lookup Field
															
															No
															Yes

														
													
														BM Str Mask
													
														BM Text mask
													
														BM Small Int Mask
													
														BM Str Mask D
													
														BM Curr Mask
													
												
													
														BM Str Mask B
													
														BM Long Int Mask
													
														BM Date mask
													
														BM Str Mask A
													
														BM Float mask
													
														BM DateTime mask
													
														BM Str Mask E
													
														BM Str Mask F
													
														BM Str Mask G
													
														BM Str Mask H
													
														BM Str Mask I
													
														BM Str Mask J
													
														BM Str Mask K
													
														BM Str Mask L
													
														BM Str Mask M
													
														BM Str Mask N
													
														BM Str Mask O
													
														BM Str Mask Q
													
														BM Str Mask P
													
														BM Str WL A
															

														
													
														BM Str WL B
															

														
													
														Max Currency
													
														BM String1
													
														BM string2
													
														Ext Name Field
													
														Datetimefld refgrid*
													
														Max Float
													
												
											
										
                        
									
								
									
										                
                    
                        
                            
											
												ReviseReplace
											
										
                        
                        
                            
                            
                            
											
												Select or drop file:
												
                                        Drop file here
                                    
												                                       
                                        
                                        
                                    
											
										
										
                        
                    
                    
									
								
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
      <value>Object Repository/Page_WMI_NEW/Reference_Object_Feature/Inline_Content_View/iframe_Close Window_ContentPla</value>
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
      <value>(.//*[normalize-space(text()) and normalize-space(.)='* Duplicate values will be ignored.'])[1]/following::div[3]</value>
   </webElementXpaths>
   <webElementXpaths>
      <isSelected>false</isSelected>
      <matchCondition>equals</matchCondition>
      <name>xpath:position</name>
      <value>//tr[5]/td/div/div[2]</value>
   </webElementXpaths>
</WebElementEntity>
