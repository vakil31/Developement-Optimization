<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f" %>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>Suffie | Suffice Responsive Admin Dashboard Template</title>    <meta charset="utf-8" />  <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <!-- Bootstrap -->
    <link href="adminResources/css/bootstrap.min.css" rel="stylesheet" />
    <!-- Custom styling plus plugins -->
    <link rel="stylesheet" href="adminResources/css/main.css">
     <link href="adminResources/css/ionicons.min.css" rel="stylesheet" />
    <link href="adminResources/css/extra_colors.css" rel="stylesheet" />
    <link href="adminResources/css/bootstrap-extra.css" rel="stylesheet" />
    <!-- bootstrap-wysiwyg -->
    <!-- <link href="../vendors/google-code-prettify/bin/prettify.min.css" rel="stylesheet"> -->
    <!-- Font Awesome -->
    <link href="adminResources/css/font-awesome.min.css" rel="stylesheet">
    <!-- NProgress -->
    <link href="adminResources/css/nprogress.css" rel="stylesheet">
    <!-- Custom styling plus plugins
    <link href="adminResources/css/custom.min.css" rel="stylesheet"> -->
  <style></style> 
<script>
function fn()
{
	//alert("in fun");
	//var i=1;
	//my.innerHTML=my.innerHTML+"<br><div class='form-group'> <label class='col-lg-3 control-label'>Field Type</label><div class='col-lg-5'><input class='form-control' type='text' name='fieldType'></div></div>"
	//my.innerHTML=my.innerHTML+"<br><div class='form-group'> <label class='col-lg-3 control-label'>Field Title</label><div class='col-lg-5'><input class='form-control' type='text' name='fieldTitle'></div></div>"
	//my.innerHTML=my.innerHTML+"<br><div class='form-group'> <label class='col-lg-3 control-label'>Field Value</label><div class='col-lg-5'><input class='form-control' type='text' name='fieldValue'></div></div>"
	var a=document.getElementById("tb1");
	var b=document.getElementById("fieldType");	
	var c=document.getElementById("fieldTitle");	
	var d=document.getElementById("fieldValue");	
	
	if(b.value=="")
		{
			alert("Enter Field Type");
		}
	else if(c.value=="")
	{
		alert("Enter Field Title");
	}
	else if(d.value=="")
	{
		alert("Enter Field Value");
	}
	else
		{
		
		a.style.display="";
		var r1=a.insertRow(-1);
		var c0=r1.insertCell(0);
		var c1=r1.insertCell(1);
		var c2=r1.insertCell(2);
		c0.innerHTML=b.value+"<input type='hidden' name='fieldType' value='"+b.value+"' />";
		c1.innerHTML=c.value+"<input type='hidden' name='fieldTitle' value='"+c.value+"' />";
		c2.innerHTML=d.value+"<input type='hidden' name='fieldValue' value='"+d.value+"' />";
		/*<div class="form-group">
        <label class="col-lg-3 control-label">Field Type</label>
        <div class="col-lg-5">
            <input class="form-control"  id="fieldType" />
        </div>
    </div>
    <div class="form-group">
        <label class="col-lg-3 control-label">Field Title</label>
        <div class="col-lg-5">
            <input class="form-control"  id="fieldTitle"/>
        </div>
    </div>
    <div class="form-group">
        <label class="col-lg-3 control-label">Field Value</label>
        <div class="col-lg-5">
            <input class="form-control"  id="fieldValue"/>
        </div>
    </div> */
	
		} 
			
}
</script>
</head>
<body>
    <div id="wrapper">
     <jsp:include page="header.jsp"></jsp:include>
               <!-- Fixed navbar -->
                <!-- Fixed navbar -->

        <!-- Sidebar -->
                <!-- Sidebar -->
 	<jsp:include page="menu.jsp"></jsp:include>
        <!-- Page Content -->
        <div id="page-content-wrapper">
            <div class="container-fluid">
                <div class="title_left">
                    <h3> Add Form <small>  </small></h3>
                </div>
                <div class="row">
                    <div class="col-md-12">
                        <div class="panel">
                            <div class="panel-heading">
                                
                            </div>
                            <div class="panel-body" style="height:400px;">
                                <f:form id="defaultForm" method="post" modelAttribute="data" class="form-horizontal" action="insertForm.htm">
       					             <div class="form-group">
                                        <label class="col-lg-3 control-label">Module</label>
                                        <div class="col-lg-5">
                                            <f:select class="form-control" path="mvo.moduleId">
                                            <f:option value="">Select</f:option>
                                            <c:forEach items="${moduleList}"  var="i">
                                            
                                  				  <f:option value="${i.moduleId}">${i.moduleName}</f:option>
                                   			</c:forEach>
                                				</f:select>
                                        </div>
                                    </div>   
	
                                   <div class="form-group">
                                        <label class="col-lg-3 control-label">Form Name</label>
                                        <div class="col-lg-5">
                                            <f:input class="form-control" path="formName" />
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-lg-3 control-label">Form Details</label>
                                        <div class="col-lg-5">
                                            <f:input class="form-control" path="formDetails" />
                                        </div>
                                    </div>
                             <div class="form-group">
                                        <div class="col-lg-9 col-lg-offset-3">
                                           <input type="button" class="btn btn-primary" name="signup" value="Add Field" data-toggle="modal" data-target="#myModal" id="tb">

                                        </div>
                                    </div>
                                   <div class="form-group">
                                        <div class="col-lg-9 col-lg-offset-3">
                                           <button type="submit" class="btn btn-primary" name="signup" value="Sign up">Save</button>

                                        </div>
                                    </div>
                               
						<div class="table-responsive">
						<table style="display:none" class="table table-responsive table-striped  table-bordered" cellspacing="0" width="100%" id="tb1">
									 <thead>
									<tr>
									<th>Field Type</th>
									<th>Field Title</th>
									<th>Field Value</th>
									</tr>
									</thead>
						</table>
						</div>
						</f:form>
                            </div>
                        </div>
                    </div>

                </div>

            </div>
        </div>
       <!-- /page content -->
    </div>
<!-- Modal -->
<div id="myModal" class="modal fade" role="dialog">
  <div class="modal-dialog">

    <!-- Modal content-->
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal">&times;</button>
        <h4 class="modal-title">Add Field</h4>
      </div>
      <div class="modal-body form-horizontal">
         <div class="form-group">
                                        <label class="col-lg-3 control-label">Field Type</label>
                                        <div class="col-lg-9">
                                            <input class="form-control" type="text" name="fieldType" id="fieldType" />
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-lg-3 control-label">Field Title</label>
                                        <div class="col-lg-9">
                                            <input class="form-control" type="text" name="fieldTitle" id="fieldTitle"/>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-lg-3 control-label">Field Value</label>
                                        <div class="col-lg-9">
                                            <input class="form-control" type="text" name="fieldValue" id="fieldValue"/>
                                        </div>
                                    </div>
                                    
       </div>
      <div class="modal-footer">
      <input type="button" value="Save" class="btn btn-default" data-dismiss="modal" onclick="fn()"></input>
        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
      </div>
    </div>
	
  </div>
</div>
    <script src="adminResources/js/jquery.min.js"></script>

    <script src="adminResources/js/bootstrap.min.js"></script>
    <!-- FastClick -->
    <script src="adminResources/js/fastclick.js"></script>

    <script src="adminResources/js/main.js"></script>

    <!-- jquery.dataTables -->   <script src="adminResources/js/jquery.dataTables.min.js"></script>
    <!-- bootstrap-wysiwyg -->
    <script src="adminResources/js/bootstrap-wysiwyg.min.js"></script>
    <script src="adminResources/js/jquery.hotkeys.js"></script>
    <script src="adminResources/js/prettify.js"></script>
    <!-- bootstrap-wysiwyg -->
    <!-- form validation -->
    <script src="adminResources/js/custom-formvalidation.js"></script>
</body>

</html>
