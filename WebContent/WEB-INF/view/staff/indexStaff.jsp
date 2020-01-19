<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>

    <title>Suffie | Suffice Responsive Admin Dashboard Template</title>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <!-- Bootstrap -->
    <link href="adminResources/css/bootstrap.min.css" rel="stylesheet" />

    <link href="adminResources/css/ionicons.min.css" rel="stylesheet" />
    <link href="adminResources/css/extra_colors.css" rel="stylesheet" />
    <link href="adminResources/css/bootstrap-extra.css" rel="stylesheet" />
    <!-- bootstrap-progressbar 
    <link href="adminResources/css/bootstrap-progressbar-3.3.4.min.css" rel="stylesheet">-->
    <!-- bootstrap-wysiwyg -->
    <!-- <link href="adminResources/css/prettify.min.css" rel="stylesheet"> -->
    <!-- Font Awesome -->
    <link href="adminResources/css/font-awesome.min.css" rel="stylesheet">
    <!-- NProgress -->
    <link href="adminResources/css/nprogress.css" rel="stylesheet">
    <!-- Custom styling dashboard-->
    <link href="adminResources/css/custom-dashboard.css" rel="stylesheet">
    <!-- Custom styling plus plugins -->
    <link href="adminResources/css/custom-todo.css" rel="stylesheet">
    <!-- custom styling timeline -->
    <link href="adminResources/css/custom-timeline.css" rel="stylesheet">

    <!-- Custom styling plus plugins -->
    <link rel="stylesheet" href="adminResources/css/main.css">
    <!-- Custom styling chartis-->
    <link href="adminResources/css/chartist.min.css" rel="stylesheet">
	
	<!-- Global site tag (gtag.js) - Google Analytics -->
<script async src="https://www.googletagmanager.com/gtag/js?id=UA-3674109-28"></script>
<script>
  window.dataLayer = window.dataLayer || [];
  function gtag(){dataLayer.push(arguments);}
  gtag('js', new Date());

  gtag('config', 'UA-3674109-28');
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
      <!--   <div id="page-content-wrapper">
            <div class="container-fluid">
                <div class="row tile_count">
                    <div class="col-md-2 col-sm-4 col-xs-6 tile_stats_count">
                        <span class="count_top"><i class="fa fa-child"></i> Total Users</span>
                        <div class="count">2500</div>
                        <span class="count_bottom"><i class="green">4% </i>  From Last Month</span>
                    </div> 
                    <div class="col-md-2 col-sm-4 col-xs-6 tile_stats_count">
                        <span class="count_top"><i class="fa fa-clock-o"></i> Average Time</span>
                        <div class="count">42.65</div>
                        <span class="count_bottom"><i class="green"><i class="fa fa-sort-asc"></i>3% </i>  From Last Month</span>
                    </div>
                    <div class="col-md-2 col-sm-4 col-xs-6 tile_stats_count">
                        <span class="count_top"><i class="fa fa-user"></i> Total Males</span>
                        <div class="count aero">4,200</div>
                        <span class="count_bottom"><i class="green"><i class="fa fa-sort-asc"></i>34% </i>  From Last Month</span>
                    </div>
                    <div class="col-md-2 col-sm-4 col-xs-6 tile_stats_count">
                        <span class="count_top"><i class="fa fa-user"></i> Total Females</span>
                        <div class="count">4,252</div>
                        <span class="count_bottom"><i class="red"><i class="fa fa-sort-desc"></i>12% </i>  From Last Month</span>
                    </div>
                    <div class="col-md-2 col-sm-4 col-xs-6 tile_stats_count">
                        <span class="count_top"><i class="fa fa-bar-chart-o"></i> Total Collections</span>
                        <div class="count">2,315</div>
                        <span class="count_bottom"><i class="green"><i class="fa fa-sort-asc"></i>34% </i>  From Last Month</span>
                    </div>
                    <div class="col-md-2 col-sm-4 col-xs-6 tile_stats_count">
                        <span class="count_top"><i class="fa fa-clone"></i> Total Connections</span>
                        <div class="count">7,325</div>
                        <span class="count_bottom"><i class="green"><i class="fa fa-sort-asc"></i>34% </i>  From Last Month</span>
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-12 col-sm-12">
                        <div class="panel" style="min-height:10em;">
                            <div class="panel-heading">
                                <h2>Country Sales <small> Sessions</small></h2>
                              
                            </div>
                            <div class="panel-body">
                             
                                <div id="regions_div" >
                                
                                </div>
                               
                            </div>
                        </div>

                    </div>
               
                </div>
                <div class="row">

                    <div class="col-md-4 col-sm-12">
                        <div class="panel pnlTop">
                            <div class="panel-heading">
                                <h2>Top Country <small>Tax.</small></h2>
                               

                            </div>
                            <div class="panel-body">

                                <div class="ct-chart12 ct-golden-section"></div>

                            </div>
                        </div>
                    </div>
                    <div class="col-md-8 col-sm-12">
                        <div class="panel" style="min-height:15em;">
                            <div class="panel-heading">
                                <h2>Total Sales</h2>
                                

                            </div>
                            <div class="panel-body">

                               <div class="col-md-12 col-sm-12">
                                    <div>
                                        <p>Turkey</p>
                                        <div class="">
                                            <div class="progress progress_sm" style="width: 76%;">
                                                <div class="progress-bar bg-green" role="progressbar" data-transitiongoal="70"></div>
                                            </div>
                                        </div>
                                    </div>
                                    <div>
                                        <p>France</p>
                                        <div class="">
                                            <div class="progress progress_sm" style="width: 76%;">
                                                <div class="progress-bar bg-green" role="progressbar" data-transitiongoal="60"></div>
                                            </div>
                                        </div>
                                    </div>
                                    <div>
                                        <p>Canada</p>
                                        <div class="">
                                            <div class="progress progress_sm" style="width: 76%;">
                                                <div class="progress-bar bg-green" role="progressbar" data-transitiongoal="50"></div>
                                            </div>
                                        </div>
                                    </div>
                                    <div>
                                        <p>Brazil</p>
                                        <div class="">
                                            <div class="progress progress_sm" style="width: 76%;">
                                                <div class="progress-bar bg-green" role="progressbar" data-transitiongoal="40"></div>
                                            </div>
                                        </div>
                                    </div>
                                    <div>
                                        <p>United States</p>
                                        <div class="">
                                            <div class="progress progress_sm" style="width: 76%;">
                                                <div class="progress-bar bg-green" role="progressbar" data-transitiongoal="30"></div>
                                            </div>
                                        </div>
                                    </div>
                                    <div>
                                        <p>Germany</p>
                                        <div class="">
                                            <div class="progress progress_sm" style="width: 76%;">
                                                <div class="progress-bar bg-green" role="progressbar" data-transitiongoal="20"></div>
                                            </div>
                                        </div>
                                    </div>

                                </div>

                            </div>
                        </div>
                    </div>

                </div>
                <div class="row">
                    <div class="col-md-4 col-sm-12">
                        <div class="panel pnlRec">

                            <div class="panel-heading">
                                <h2>Recent Activities<small> sessions</small></h2>
                               
                            </div>
                            <div class="panel-body" style="min-height: 620px;">

                                <div class="activity-feed">
                                    <div class="feed-item">
                                        <div class="date">Sep 25</div>
                                        <div class="text">Responded to need <a href="single-need.php">âVolunteer opportunityâ</a></div>
                                    </div>
                                    <div class="feed-item">
                                        <div class="date">Sep 24</div>
                                        <div class="text">Added an interest âVolunteer Activitiesâ</div>
                                    </div>
                                    <div class="feed-item">
                                        <div class="date">Sep 23</div>
                                        <div class="text">Joined the group <a href="single-group.php">âBoardsmanship Forumâ</a></div>
                                    </div>
                                    <div class="feed-item">
                                        <div class="date">Sep 21</div>
                                        <div class="text">Responded to need <a href="single-need.php">âIn-Kind Opportunityâ</a></div>
                                    </div>
                                    <div class="feed-item">
                                        <div class="date">Sep 18</div>
                                        <div class="text">Created need <a href="single-need.php">âVolunteer Opportunityâ</a></div>
                                    </div>
                                    <div class="feed-item">
                                        <div class="date">Sep 17</div>
                                        <div class="text">Attending the event <a href="single-event.php">âSome New Eventâ</a></div>
                                    </div>
                                </div>

                            </div>

                        </div>
                    </div>
                    <div class="col-md-8 col-sm-12">

                        <div class="panel" style="min-height:27em;">
                            <div class="panel-heading">
                                <h2>Total Person <small>Country Sessions</small></h2>
                               
                            </div>
                            <div class="panel-body">
                                <div id="series_chart_div" style="min-height: 280px;"></div>
                            </div>


                        </div>
                        <div class="row">



                            <div class="col-md-6 col-sm-12">
                                <div class="panel pnlBot">
                                    <div class="panel-heading">
                                        <h2>Visitors Price <small>Sample lorem</small></h2>
                                       
                                    </div>
                                    <div class="panel-body">
                                        <div id="sankey_basic"></div>

                                    </div>
                                </div>
                            </div>  -->


                            <!-- start of weather widget -->
                        <!--     <div class="col-md-6 col-sm-12">
                                <div class="panel pnlBot">
                                    <div class="panel-heading">
                                        <h2>Daily active pc <small>Sessions</small></h2>
                                     
                                    </div>
                                    <div class="panel-body">
                                        <div id="chart_div"></div>
                                    </div>
                                </div>

                            </div>
                            <!-- end of weather widget -->
                        </div>
                    </div>
                </div>
            </div>
        </div>  -->
        <!-- /page content -->
    </div>
    <!-- /page content -->
    <!-- jquery -->
    <script src="adminResources/js/jquery.min.js"></script>
    <!-- bootstrap -->
    <script src="adminResources/js/bootstrap.min.js"></script>
    <!-- bootstrap-progressbar -->
    <script src="adminResources/js/bootstrap-progressbar.min.js"></script>
    <!-- FastClick -->
    <script src="adminResources/js/fastclick.js"></script>
    <!-- custom main js -->
    <script src="adminResources/js/main.js"></script>
    <!-- cjquery.dataTables -->
    <!-- jquery.dataTables -->
    <script src="adminResources/js/jquery.dataTables.min.js"></script>
    <!-- bootstrap-wysiwyg -->
    <script src="adminResources/js/bootstrap-wysiwyg.min.js"></script>
    <script src="adminResources/js/jquery.hotkeys.js"></script>
    <script src="adminResources/js/prettify.js"></script>
    <!-- page load pace-v1.0.0 -->
    <script src="adminResources/js/pace.min.js"></script>
    <!-- To do -->
    <script type="text/javascript" src="adminResources/js/custom-todo.js"></script>
    <!-- To do -->
    <!-- jquery.circle-diagram  -->
    <script src="adminResources/js/jquery.circle-diagram.js"></script>
    <!-- Google Chart js  -->
    <script type="text/javascript" src="../build/js/loader.js"></script>
    <!-- Chartis-->
    <script src="adminResources/js/chartist.min.js"></script>
    <!-- Custom Dashboard js  -->
    <script type="text/javascript" src="adminResources/js/custom-dashborad.js"></script>
        <!--  jQuery  "resize"  -->
    <script type="text/javascript" src="adminResources/js/jquery.throttledresize.js"></script>

</body>

</html>