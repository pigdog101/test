<%@page import="java.net.URI"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<script type="text/javascript" src="js/jquery-1.11.3.min.js"></script>
<script type="text/javascript">
function f(){ 
// 	alert('tetr');
// 	$.post(
// 			   "test",
// 			   function(result){
// 				   alert("Json"); 
// // 				   for(var i = 0;i<3;i++){
// // 					   alert(result.username);
// // 				   }
// 			   }
// 	   );
	    // 获取用户输入的账号和密码
	    var td1 = $('#fajax').val();
        var student={"name":"zs","age":23};
        var students=[
        	{"name":"zs","age":23},
        	{"name":"ls","age":24},
        	{"name":"ww","age":25}
        ];
	    $.ajax({
	        url : 'test',
	        type : 'post',
	        // data对象中的属性名要和服务端控制器的参数名一致 login(name, password)
	        data : {'key' : td1},
	        dataType : 'json',
	        success : function(result) {
	                // 登录成功，设置cookie并跳转edit.html
	                alert("Json");
	        },
	        error : function(e) {
	            alert("系统异常");
	            
	        }
	    });

	}
// yuansheng ajax
// var xmlHttpRequest = null;
// function  getXmlHttpRequest(){
//     if( (typeof(XMLHttpRequest)) != 'undefined'){
//     	  xmlHttpRequest = new XMLHttpRequest();
//     	      }else {
//     	        //alert("2");
//     	        //ie浏览器
//     	        xmlHttpRequest = 
//     	        new ActiveXObject('Microsoft.XMLHttp');
//     	      }
//     	    return xmlHttpRequest;
//     	}  
    	
//     	function f(){
//     		var x = document.getElementById('fajax').value;
//     		    xmlHttpRequest = getXmlHttpRequest();
//     		    xmlHttpRequest. open('post','test',true);
//     		   xmlHttpRequest.setRequestHeader("Content-Type","application/x-www-form-urlencoded"); //设置头信息
//     		        xmlHttpRequest.onreadystatechange=fx; //挂载回调函数
//     		        xmlHttpRequest.send("key="+x); //发送参数
//     		}
//     	function fx(){ //回调函数
//     		var ka = xmlHttpRequest.responseText;
//     	    var str =  '<p>' +  ka + '<p>';
//     	    var td1 = document.getElementById('td1');
//     	    td1.innerHTML=str;
//     		        if(xmlHttpRequest.status == 200 &&xmlHttpRequest.readyState==4){
//     		            var resTXT = xmlHttpRequest.responseText;  //后台产过来的数据是 json
//     		            var j= JSON.parse(resTXT);
//     		            alert(resTXT);
//     		            //数据填充到下拉框
//     		            var selectDep = document.getElementById('depotSelect');
//     		            var temp ="<option id=\"-1\">====请选择仓库====</option>  ";
//     		            for(var i =0;i<j.length;i++){
//     		                temp=temp+"<option>"+ j[i].depotName+"</option> ";
//     		            }
//     		            selectDep.innerHTML=temp;
//                     alert(ka);
//     		        }
//     		    }    
</script>

<title>Insert title here</title>
</head>
<body>
<div id="td1">
<a href="ssmTest">ssmTest</a>

</div>
<ul>
<li></li>
<li></li>
<li></li>
</ul>
<a href="test">test</a>
手机号码<input type="text" name="fajax" id="fajax">
提交<input type="button" name="butt" value="提交" onclick="f()">
hellow maven
<a href="mavtest">tianzhuan</a>


</body>
</html>
