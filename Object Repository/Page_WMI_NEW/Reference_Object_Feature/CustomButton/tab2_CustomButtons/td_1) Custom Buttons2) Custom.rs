<?xml version="1.0" encoding="UTF-8"?>
<WebElementEntity>
   <description></description>
   <name>td_1) Custom Buttons2) Custom</name>
   <tag></tag>
   <elementGuidId>0322fda2-94eb-4115-941c-e6d33fc426ec</elementGuidId>
   <selectorMethod>BASIC</selectorMethod>
   <useRalativeImagePath>false</useRalativeImagePath>
   <webElementProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>tag</name>
      <type>Main</type>
      <value>td</value>
   </webElementProperties>
   <webElementProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>id</name>
      <type>Main</type>
      <value>eform_mcb67676_TableCell3_4</value>
   </webElementProperties>
   <webElementProperties>
      <isSelected>false</isSelected>
      <matchCondition>equals</matchCondition>
      <name>colspan</name>
      <type>Main</type>
      <value>2</value>
   </webElementProperties>
   <webElementProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>text</name>
      <type>Main</type>
      <value>
			
				1) Custom Buttons2) Custom Buttons3) Custom Buttons4) Custom Buttons with adhoc filter5) Custom Buttons with adhoc filter - no search result6) Multiple Custom Buttons
			
				
					
                                
						
							

  


    
    
    
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




 
  
    
    
    
 


       
      
     
        
        
          
      
        
        
								
									
                    
                        
                            
                                
                                1) Custom Buttons
                                                       
                        
                    
                
								
									
								
									
										
                            
                                  
                            
                        
									
										                                                    
                            
                            
											
												
													
														
															  
														
													
												
													
                                    
                                        
                                            
                                                                                                    
                                                                                                                                                
                                                
                                                
                                                
                                                
                                                 
                                                
                                                                                                          
                                                
                                                 
                                                     
                                                
                                                
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

													
                                                 of 38
                                                >
                                                >>

                                                                                            
                                            
                                        
                                    
                                
												
													params   Doc IDCurrent Revision #Doc Type NameDoc User DateDoc Create DateBM StringBM String1BM IntBM Int MVBM Small Int MVDoc Created ByBM DateTimeBM DateBM string2BM String MVCustomer NameBM Small IntBM Text
												
													 1000091000011000090Render As Label07-25-2016 05:55:00 AM07-25-2016 05:55:00 AMshow 11902  Reema07-25-2016 05:55:00 AM     You selected Option 1
												
													 1000221000011000220Render As Label07-29-2016 08:05:00 AM07-29-2016 08:05:00 AMBM Test WMI for 100022 30  Reema07-29-2016 08:05:00 AM     Label Control
												
													 1010401000011010400Render As Label08-08-2016 05:33:00 AM08-08-2016 05:33:00 AM1    Praveen Ravanang08-08-2016 05:33:00 AM     Label Control
												
													 1010411000011010410Render As Label08-08-2016 05:36:00 AM08-08-2016 05:36:00 AM1    Praveen Ravanang08-08-2016 05:36:00 AM     Label Control
												
													 1010421000011010420Render As Label08-08-2016 05:48:00 AM08-08-2016 05:48:00 AM1    Praveen Ravanang08-08-2016 05:48:00 AM     Label Control
												
											
										
                            
                                                         
                            
                        
									
								
									
										
                           
                                  
                            
                        
									
										                        
                            
                            

										
                        
									
								
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




 
  
    
    
    
 


       
      
     
        
        
          
      
        
        
								
									
                    
                        
                            
                                
                                2) Custom Buttons
                                                       
                        
                    
                
								
									
								
									
										
                            
                                  
                            
                        
									
										                                                    
                            
                            
											
												
													
														
															  
														
													
												
													
                                    
                                        
                                            
                                                                                                    
                                                                                                                                                
                                                
                                                
                                                
                                                
                                                 
                                                
                                                                                                          
                                                
                                                 
                                                     
                                                
                                                
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

													
                                                 of 38
                                                >
                                                >>

                                                                                            
                                            
                                        
                                    
                                
												
													params   Doc IDCurrent Revision #Doc Type NameDoc User DateDoc Create DateBM StringBM String1BM IntBM Int MVBM Small Int MVDoc Created ByBM DateTimeBM DateBM string2BM String MVCustomer NameBM Small IntBM Text
												
													 1000091000011000090Render As Label07-25-2016 05:55:00 AM07-25-2016 05:55:00 AMshow 11902  Reema07-25-2016 05:55:00 AM     You selected Option 1
												
													 1000221000011000220Render As Label07-29-2016 08:05:00 AM07-29-2016 08:05:00 AMBM Test WMI for 100022 30  Reema07-29-2016 08:05:00 AM     Label Control
												
													 1010401000011010400Render As Label08-08-2016 05:33:00 AM08-08-2016 05:33:00 AM1    Praveen Ravanang08-08-2016 05:33:00 AM     Label Control
												
													 1010411000011010410Render As Label08-08-2016 05:36:00 AM08-08-2016 05:36:00 AM1    Praveen Ravanang08-08-2016 05:36:00 AM     Label Control
												
													 1010421000011010420Render As Label08-08-2016 05:48:00 AM08-08-2016 05:48:00 AM1    Praveen Ravanang08-08-2016 05:48:00 AM     Label Control
												
											
										
                            
                                                         
                            
                        
									
								
									
										
                           
                                  
                            
                        
									
										                        
                            
                            

										
                        
									
								
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




 
  
    
    
    
 


       
      
     
        
        
          
      
        
        
								
									
                    
                        
                            
                                
                                3) Custom Buttons
                                                       
                        
                    
                
								
									
								
									
										
                            
                                  
                            
                        
									
										                                                    
                            
                            
											
												
													
                                    
                                        
                                            
                                                                                                    
                                                                                                                                                
                                                
                                                
                                                
                                                
                                                 
                                                
                                                                                                          
                                                
                                                 
                                                     
                                                
                                                
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

													
                                                 of 38
                                                >
                                                >>

                                                                                            
                                            
                                        
                                    
                                
												
													params   Doc IDCurrent Revision #Doc Type NameDoc User DateDoc Create DateBM StringBM String1BM IntBM Int MVBM Small Int MVDoc Created ByBM DateTimeBM DateBM string2BM String MVCustomer NameBM Small IntBM Text
												
													 1000091000011000090Render As Label07-25-2016 05:55:00 AM07-25-2016 05:55:00 AMshow 11902  Reema07-25-2016 05:55:00 AM     You selected Option 1
												
													 1000221000011000220Render As Label07-29-2016 08:05:00 AM07-29-2016 08:05:00 AMBM Test WMI for 100022 30  Reema07-29-2016 08:05:00 AM     Label Control
												
													 1010401000011010400Render As Label08-08-2016 05:33:00 AM08-08-2016 05:33:00 AM1    Praveen Ravanang08-08-2016 05:33:00 AM     Label Control
												
													 1010411000011010410Render As Label08-08-2016 05:36:00 AM08-08-2016 05:36:00 AM1    Praveen Ravanang08-08-2016 05:36:00 AM     Label Control
												
													 1010421000011010420Render As Label08-08-2016 05:48:00 AM08-08-2016 05:48:00 AM1    Praveen Ravanang08-08-2016 05:48:00 AM     Label Control
												
											
										
                            
                                                         
                            
                        
									
								
									
										
                           
                                  
                            
                        
									
										                        
                            
                            

										
                        
									
								
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




 
  
    
    
    
 


       
      
     
        
        
          
      
        
        
								
									
                    
                        
                            
                                
                                4) Custom Buttons with adhoc filter
                                                       
                        
                    
                
								
									
								
									
										
                            
                                  
                            
                        
									
										
                          
                                  Search
                                
                                      
											
												Doc ID
												
													=
													>
													&lt;
													>=
													&lt;=
													&lt;>
													In
													Not In
													Null
													Not Null

												
												
											
										
										
                                    
											
												  
											
										
										
                                                              
                                                                            
                        
									
								
									
										
                            
                                  
                            
                        
									
										                                                    
                            
                            
											
												
													
														
															  
														
													
												
													
                                    
                                        
                                            
                                                                                                    
                                                                                                                                                
                                                
                                                
                                                
                                                
                                                 
                                                
                                                                                                          
                                                
                                                 
                                                     
                                                
                                                
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

													
                                                 of 38
                                                >
                                                >>

                                                                                            
                                            
                                        
                                    
                                
												
													params   Doc IDCurrent Revision #Doc Type NameDoc User DateDoc Create DateBM StringBM String1BM IntBM Int MVBM Small Int MVDoc Created ByBM DateTimeBM DateBM string2BM String MVCustomer NameBM Small IntBM Text
												
													/Sav.Main.UI/WMI/wmi.aspx?id=&amp;opwm=&amp;opm=WebDialog&amp;loc=REFRENCEDOC&amp;did=776F3430504D57366642356F5754394D6E76457572413D3D&amp;pdwid=New&amp;aid=0&amp;dtid=100001&amp;dcid=100001&amp;rdocid=776F3430504D57366642356F5754394D6E76457572413D3D&amp;|REFRENCEDOC|100009||100001|100001100001||| Render As Label  -  01/25/2018 |||||1000091000011000090Render As Label07-25-2016 05:55:00 AM07-25-2016 05:55:00 AMshow 11902  Reema07-25-2016 05:55:00 AM     You selected Option 1
												
													/Sav.Main.UI/WMI/wmi.aspx?id=&amp;opwm=&amp;opm=WebDialog&amp;loc=REFRENCEDOC&amp;did=4C69656E35546548366C564D52414B314548694263413D3D&amp;pdwid=New&amp;aid=0&amp;dtid=100001&amp;dcid=100001&amp;rdocid=4C69656E35546548366C564D52414B314548694263413D3D&amp;|REFRENCEDOC|100022||100001|100001100001||| BM Render As Label  -  07/29/2016 |||||1000221000011000220Render As Label07-29-2016 08:05:00 AM07-29-2016 08:05:00 AMBM Test WMI for 100022 30  Reema07-29-2016 08:05:00 AM     Label Control
												
													/Sav.Main.UI/WMI/wmi.aspx?id=&amp;opwm=&amp;opm=WebDialog&amp;loc=REFRENCEDOC&amp;did=31412B53462B6A756B6668642B35545774586F4856413D3D&amp;pdwid=New&amp;aid=0&amp;dtid=100001&amp;dcid=100001&amp;rdocid=31412B53462B6A756B6668642B35545774586F4856413D3D&amp;|REFRENCEDOC|101040||100001|100001100001||| BM Render As Label  -  08/08/2016 |||||1010401000011010400Render As Label08-08-2016 05:33:00 AM08-08-2016 05:33:00 AM1    Praveen Ravanang08-08-2016 05:33:00 AM     Label Control
												
													/Sav.Main.UI/WMI/wmi.aspx?id=&amp;opwm=&amp;opm=WebDialog&amp;loc=REFRENCEDOC&amp;did=6155436955357949713763592F7563347859436273513D3D&amp;pdwid=New&amp;aid=0&amp;dtid=100001&amp;dcid=100001&amp;rdocid=6155436955357949713763592F7563347859436273513D3D&amp;|REFRENCEDOC|101041||100001|100001100001||| BM Render As Label  -  08/08/2016 |||||1010411000011010410Render As Label08-08-2016 05:36:00 AM08-08-2016 05:36:00 AM1    Praveen Ravanang08-08-2016 05:36:00 AM     Label Control
												
													/Sav.Main.UI/WMI/wmi.aspx?id=&amp;opwm=&amp;opm=WebDialog&amp;loc=REFRENCEDOC&amp;did=454C552F595366495A5A64686E4D78487969337179513D3D&amp;pdwid=New&amp;aid=0&amp;dtid=100001&amp;dcid=100001&amp;rdocid=454C552F595366495A5A64686E4D78487969337179513D3D&amp;|REFRENCEDOC|101042||100001|100001100001||| BM Render As Label  -  08/08/2016 |||||1010421000011010420Render As Label08-08-2016 05:48:00 AM08-08-2016 05:48:00 AM1    Praveen Ravanang08-08-2016 05:48:00 AM     Label Control
												
											
										
                            
                                                         
                            
                        
									
								
									
										
                           
                                  
                            
                        
									
										                        
                            
                            

										
                        
									
								
									 ^ Back to Top
                
								
									
								
									
										
											
										
											
										
									
								
							
       
    




dummy

    
        Enter  Values. *
        
        * Duplicate values will be ignored.
        
       
               
    




						
					
                            
				
					
                                
						
							

  


    
    
    
    function setContextKey(ajaxExtendercntrlID, interval) {
        
        var callHandler = true;
        var mindiff = 0;
        var callTime = new Date();
        if (document.getElementById('eform_mcb67676_TabContainer_4_TabRef_5_phBO_8_BO_hdnAutocompleteCallTime').value.length > 0) {

            var updateTime = new Date(document.getElementById('eform_mcb67676_TabContainer_4_TabRef_5_phBO_8_BO_hdnAutocompleteCallTime').value);
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
                        document.getElementById('eform_mcb67676_TabContainer_4_TabRef_5_phBO_8_BO_hdnAutocompleteCallTime').value = new Date();
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




 
  
    
    
    
 


       
      
     
        
        
          
      
        
        
								
									
                    
                        
                            
                                
                                5) Custom Buttons with adhoc filter - no search result
                                                       
                        
                    
                
								
									
								
									
										
                            
                                  
                            
                        
									
										
                          
                                  Search
                                
                                      
											
												Doc ID
												
													=
													>
													&lt;
													>=
													&lt;=
													&lt;>
													In
													Not In
													Null
													Not Null

												
												
											
										
										
                                    
											
												  
											
										
										
                                                              
                                                                            
                        
									
								
									
										
                            
                                  
                            
                        
									
										                                                    
                            
                            
											
												
													params     Doc IDCurrent Revision #Doc Type NameDoc User DateDoc Create DateBM StringBM String1BM IntBM Int MVBM Small Int MVDoc Created ByBM DateTimeBM DateBM string2BM String MVCustomer NameBM Small IntBM Text
												
													No data found
												
											
										
                            
                                                         
                            
                        
									
								
									
										
                           
                                  
                            
                        
									
										                        
                            
                            

										
                        
									
								
									 ^ Back to Top
                
								
									
								
									
										
											
										
											
										
									
								
							
       
    




dummy

    
        Enter  Values. *
        
        * Duplicate values will be ignored.
        
       
               
    




						
					
                            
				
					
                                
						
							

  


    
    
    
    function setContextKey(ajaxExtendercntrlID, interval) {
        
        var callHandler = true;
        var mindiff = 0;
        var callTime = new Date();
        if (document.getElementById('eform_mcb67676_TabContainer_4_TabRef_6_phBO_9_BO_hdnAutocompleteCallTime').value.length > 0) {

            var updateTime = new Date(document.getElementById('eform_mcb67676_TabContainer_4_TabRef_6_phBO_9_BO_hdnAutocompleteCallTime').value);
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
                        document.getElementById('eform_mcb67676_TabContainer_4_TabRef_6_phBO_9_BO_hdnAutocompleteCallTime').value = new Date();
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




 
  
    
    
    
 


       
      
     
        
        
          
      
        
        
								
									
                    
                        
                            
                                
                                6) Multiple Custom Buttons
                                                       
                        
                    
                
								
									
								
									
										
                            
                                  
                            
                        
									
										                                                    
                            
                            
											
												
													
														
															      
														
													
												
													
                                    
                                        
                                            
                                                                                                    
                                                                                                                                                
                                                
                                                
                                                
                                                
                                                 
                                                
                                                                                                          
                                                
                                                 
                                                     
                                                
                                                
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

													
                                                 of 38
                                                >
                                                >>

                                                                                            
                                            
                                        
                                    
                                
												
													params   Doc IDCurrent Revision #Doc Type NameDoc User DateDoc Create DateBM StringBM String1BM IntBM Int MVBM Small Int MVDoc Created ByBM DateTimeBM DateBM string2BM String MVCustomer NameBM Small IntBM Text
												
													 1000091000011000090Render As Label07-25-2016 05:55:00 AM07-25-2016 05:55:00 AMshow 11902  Reema07-25-2016 05:55:00 AM     You selected Option 1
												
													 1000221000011000220Render As Label07-29-2016 08:05:00 AM07-29-2016 08:05:00 AMBM Test WMI for 100022 30  Reema07-29-2016 08:05:00 AM     Label Control
												
													 1010401000011010400Render As Label08-08-2016 05:33:00 AM08-08-2016 05:33:00 AM1    Praveen Ravanang08-08-2016 05:33:00 AM     Label Control
												
													 1010411000011010410Render As Label08-08-2016 05:36:00 AM08-08-2016 05:36:00 AM1    Praveen Ravanang08-08-2016 05:36:00 AM     Label Control
												
													 1010421000011010420Render As Label08-08-2016 05:48:00 AM08-08-2016 05:48:00 AM1    Praveen Ravanang08-08-2016 05:48:00 AM     Label Control
												
											
										
                            
                                                         
                            
                        
									
								
									
										
                           
                                  
                            
                        
									
										                        
                            
                            

										
                        
									
								
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
      <value>id(&quot;eform_mcb67676_TableCell3_4&quot;)</value>
   </webElementProperties>
   <webElementProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>ref_element</name>
      <type>Main</type>
      <value>Object Repository/Page_WMI_NEW/Reference_Object_Feature/CustomButton/tab2_CustomButtons/iframe_Close Window_ContentPla</value>
   </webElementProperties>
   <webElementXpaths>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>xpath:attributes</name>
      <value>//td[@id='eform_mcb67676_TableCell3_4']</value>
   </webElementXpaths>
   <webElementXpaths>
      <isSelected>false</isSelected>
      <matchCondition>equals</matchCondition>
      <name>xpath:idRelative</name>
      <value>//tr[@id='eform_mcb67676_TabObjRow_4']/td</value>
   </webElementXpaths>
   <webElementXpaths>
      <isSelected>false</isSelected>
      <matchCondition>equals</matchCondition>
      <name>xpath:neighbor</name>
      <value>(.//*[normalize-space(text()) and normalize-space(.)='* Duplicate values will be ignored.'])[1]/following::td[1]</value>
   </webElementXpaths>
   <webElementXpaths>
      <isSelected>false</isSelected>
      <matchCondition>equals</matchCondition>
      <name>xpath:position</name>
      <value>//tr[5]/td</value>
   </webElementXpaths>
</WebElementEntity>
