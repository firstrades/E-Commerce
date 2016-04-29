<%@page import="ecom.common.FrequentUse"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>


<script src="<%=FrequentUse.jQuery%>"></script>


<script type="text/javascript">
  var userip;
</script>
<script type="text/javascript" src="https://l2.io/ip.js?var=userip"></script>
<script type="text/javascript">
  document.write("Your IP is :", userip);
</script>
<script src="http://freegeoip.net/json/?callback=cb" type="text/javascript"></script>
<script type="text/javascript">
		
function cb(a){
	alert(a.ip)
}
</script>






</head>
<body>


<script type="text/javascript">
$(document).ready(function(){
	  var totalWidth = 0;
	  $('#container').children().each(function(){
	    totalWidth += $(this).outerWidth();
	  });
	  $('#container').css('width', totalWidth+7);
});
</script>

<div id="container" style="    width: 316px;border: 1px solid;">
	<div style="width:100px;border: 1px solid;display: inline-block;">jewel</div>
	<div style="width:100px;border: 1px solid;display: inline-block;">jewel</div>
	<div style="width:100px;border: 1px solid;display: inline-block;">jewel</div>
</div>

<!-- ------------------------------------------------------------------------------------------------------------ -->

<section class="row">
        <div class="scroll-left" style="opacity: 0;"></div>
        <div class="row-scroll">
            <div class="tile">
                <img class="tile-image" src="http://cache.gawker.com/assets/images/lifehacker/2011/08/1030-macpack-notational-velocity.jpg" />
                <title class="tile-title">Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor...</title>
            </div>
          
            <div class="tile">
                <img class="tile-image" src="http://cache.gawker.com/assets/images/lifehacker/2011/08/1030-macpack-notational-velocity.jpg" />
                <title class="tile-title">Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor...</title>
            </div>
        </div>
        <div class="scroll-right" style="opacity: 0;"></div>
    </section>
    <section class="row">
        <div class="scroll-left" style="opacity: 0;"></div>
        <div class="row-scroll">
            <div class="tile">
                <img class="tile-image" src="http://cache.gawker.com/assets/images/lifehacker/2011/08/1030-macpack-notational-velocity.jpg" />
                <title class="tile-title">Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor...</title>
            </div>
           
            <div class="tile">
                <img class="tile-image" src="http://cache.gawker.com/assets/images/lifehacker/2011/08/1030-macpack-notational-velocity.jpg" />
                <title class="tile-title">Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor...</title>
            </div>
        </div>
        <div class="scroll-right" style="opacity: 0;"></div>
    </section>
<script type="text/javascript">
$(".scroll-left").hover(function() {
    $(this).parent().animate({scrollLeft: 0}, 7000);
    $(this).fadeIn('fast');
}, function() {
    $(this).parent().stop();
    $(this).fadeOut('fast');
});

$(".scroll-right").hover(function() {
    $(this).parent().animate({scrollLeft: $(this).siblings(".row-scroll").width()}, 7000);
    $(this).fadeIn('fast');
}, function() {
    $(this).parent().stop();
    $(this).fadeOut('fast');
});
</script>
</body>
</html>