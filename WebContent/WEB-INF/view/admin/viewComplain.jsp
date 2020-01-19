<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<!DOCTYPE html>
<html>

<head>
    <title>Suffie | Suffice Responsive Admin Dashboard Template</title>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
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
</head>

<body>
    <div id="wrapper">
        <!-- Fixed navbar -->
                <!-- Fixed navbar -->
 	<jsp:include page="header.jsp"></jsp:include>
        <!-- Sidebar -->
                <!-- Sidebar -->
 	<jsp:include page="menu.jsp"></jsp:include>
        <!-- Page Content -->
        <div id="page-content-wrapper">
            <div class="container-fluid">
                <div class="row">

                    <div class="col-md-12">
					<a href="addDept.htm">Post Complain</a>
					
                        <h3> Complain</h3>

                        <div class="table-responsive">
                            <table id="example" class="table table-responsive table-striped  table-bordered" cellspacing="0" width="100%">
                                <thead>
                                    <tr>
                                        <th>Complain ID</th>            
                                        <th>Subject</th>
                                         <th>Details</th>
                                         <th>Action</th>
                                    </tr>
                                </thead>
                                <tbody> <c:forEach items="${data}" var="i">
                                
                                    <tr>
                                        <td>${i.complainId}</td>
                                        <td>${i.subject}</td>
                                        <td>${i.details}</td>
                                        <td><a href="deleteComplain.htm?id=${i.complainId}">Delete Dept | </a></td>
                                    </tr>       
                                
                                </c:forEach>
                            </tbody>
                            </table>
                        </div>
                    </div>
                </div>

                
                   
        </div>
        <!-- /page content -->
    </div>
    <script src="adminResources/js/jquery.min.js"></script>

    <script src="adminResources/js/bootstrap.min.js"></script>
    <!-- FastClick -->
    <script src="adminResources/fastclick.js"></script>



    <!-- jquery.dataTables -->
    <script src="adminResources/js/jquery.dataTables.min.js"></script>
    <!-- bootstrap-wysiwyg -->
    <script src="adminResources/js/bootstrap-wysiwyg.min.js"></script>
    <script src="adminResources/js/jquery.hotkeys.js"></script>
    <script src="adminResources/js/prettify.js"></script>
    <!-- bootstrap-wysiwyg -->

    <!-- jquery.dataTables -->
    <script src="adminResources/js/jquery.dataTables.min.js"></script>
    <script src='adminResources/js/dataTables.buttons.min.js'></script>
    <script src='adminResources/js/buttons.colVis.min.js'></script>
    <script src='adminResources/js/buttons.html5.min.js'></script>
    <script src='adminResources/js/buttons.print.min.js'></script>
    <script src='adminResources/js/dataTables.bootstrap.min.js'></script>
    <script src='adminResources/js/buttons.bootstrap.min.js'></script>
    <script src='adminResources/js/jszip.min.js'></script>
    <script src='adminResources/js/vfs_fonts.js'></script>
    <script src='adminResources/js/pdfmake.min.js'></script>

    <script src="adminResources/js/main.js"></script>

    <script>
          $(document).on("ready",function() {
            // DataTable initialisation
            $('#example').DataTable({
                dom: 'Bfrtip',
                "paging": true,
                "autoWidth": true,
                "buttons": [
                    'colvis',
                    'copyHtml5',
                    'csvHtml5',
                    'excelHtml5',
                    'pdfHtml5',
                    'print'
                ]
            });
        });

    </script>
</body>

</html>
