/**
 * 
 */
    var delta = 0.15;
    var layers;
    var n = 0;
    var arrayColor = new Array("#00ff66","#ffff99","#99ccff","#ffccff");
    var txt = document.documentElement;
    var di = document.getElementById('div1');
    var win;
    var x=0,y=0;
    var xmlhttp;
    
   $(document).ready(function(){
	   alert('test');
	   $("#testJson").click(function(){
		   $.post(
				   "testJson",
				   function(result){
					   alert("Json");
					   for(var i = 0;i<3;i++){
						   alert(result[i].username);
					   }
				   }
		   );
	   });
   });
   function jQueryParam(){
	   $("#checkAll").click(function(){
		   $("[name=checkbox]:checkbox").attr("checked",true);
	   });
	   $("#inverse").click(function(){
		   $("[name=checkbox]:checkbox").each(function(){
			   if($(this).attr('checked')){
				   $(this).attr('checked',false);
			   }else{
				   $(this).attr('checked',true);
			   }
		   });
	   });
	   $("#checkN").click(function(){
		   $("[name=checkbox]:checkbox").attr("checked",false);
	   });
   }
   function addChild(){
	   var $p = $("<p></p>");
	   $p.html("<span>方法一</span>");
	   $("#div1").append($p);
	   $p1 = $("<p><span>方法二</span></p>");
	   $("#div1").append($p1);
	   
   }
   function jQuerySelect(){
	   var numTd =  $("#div2 table td:even,th:even");
	   numTd.click(function(){
		   var tdobj = $(this);
		   if(tdobj.children("input").length>0){
			   return false;
		   }
		   var tdtext = tdobj.html();
		   tdobj.html("");
		   var inputobj = $("<input type = 'text'/>");
		   inputobj.appendTo(tdobj);
		   inputobj.width(tdobj.width());
		   inputobj.css("background-color",tdobj.css("background-color"));
		   inputobj.val(tdtext);
		   inputobj.css("font-size","16px");
		   inputobj.trigger("focus").trigger("select");
		   inputobj.keyup(function(event){
			   var keycode = event.which;
			   if(keycode == 32){
				   var inputvalue = $(this).val();
				   tdobj.html(inputvalue);
				   alert(inputvalue);
			   }
		   });
	   });
	   $("tr:even").addClass("even");
	   $("#div2 tr:odd").addClass("odd");
	   $("#div2 table td:even,th:even").hover(
	       function(){
		   $(this).addClass("yellow");
	   },
	       function(){
		   $(this).removeClass("yellow");
	   } 
	   );
	   $("#div2 table tr").hover(
		function(){
			$(this).addClass("light");
		},
		function(){
			$(this).removeClass("light");
		}
	   );
   }
   function testAjax(){
	   getXmlhttp();
	   loadXMLDoc();
   }
   function loadXMLDoc()
	{
    var str = form1.username.value;
    if(str==""){
    	alert('shuru');
    }
	xmlhttp.onreadystatechange=function()
	  {
		  if (xmlhttp.readyState==4 && xmlhttp.status==200)
		    {
			  var strArr = xmlhttp.responseText.split('|');
			  for(var i = 0;i<strArr.length;i++){
				  if(strArr[i]==str){
					  alert('true');
				  }
			  }
		    }
		  }
//	alert(xmlhttp.status);
	xmlhttp.open("GET","ajax.txt",true);
	xmlhttp.setRequestHeader("Content-type","application/x-www-form-urlencoded");
	xmlhttp.send("fname=Bill&lname=Gates");
	
	}
     function getXmlhttp(){
    	 if(window.XMLHttpRequest){
    		 xmlhttp = new XMLHttpRequest();
    	 }else if(window.ActiveXObject){
    		 xmlhttp = new ActiveXObject(Microsoft.XMLHTTP);
    	 }
     }
     function beg(){
    	 var i = form1.username.value;
    	 i++;
    	 form1.username.value = i;
    	 timeId = setTimeout("beg()",1000);
     }
     function sta(){
    	 if(n==0){
    		 beg();
    		 n=1;
    	 }
     }
     function pau(){
    	 n=0;
    	 clearTimeout(timeId);
     }
     function go(){
    	 x++;
    	 y++;
    	 win.resizeBy(x,y);
     }
     function newresize(){
    	 win.resizeTo(200,200);
     }
     function newmove(){
    	 win.moveTo(00,00);
     }
     function newclose(){
    	 win.close();
     }
     function changeday(){
    	 var day = document.getElementById("day");
    	 var txt = day.firstChild;
    	 while(txt.nextSibling){
    		 txt = txt.nextSibling;
    		 if(txt.value >=1 ){
    		 }
    	 }
     }
     function calendar(){
    	 var date = new Date();
    	 var year = date.getFullYear();
    	 var str = "";
//    	 这是年
         str  +='<select name="s1" id="year">';
    	 for(var i=1970;i<=year;i++){
    		 str =str + '<option value=' + i + " " + (i==1996?'selected=selected':"") + ">" + i + '</option>';
    	 }
    	 str+='</select> ';
//    	 这是月
    	 str  +='<select name="s2" id="month">';
    	 for(var j=1;j<=12;j++){
    		 str =str + '<option value=' + j + " " + (j==11?'selected=selected':"") + ">" + j + '</option>';
    	 }
    	 str+='</select> ';
//    	 这是日
    	 str  +='<select name="s3" id="day">';
    	 for(var k=1;k<=31;k++){
    		 str =str + '<option value=' + k + " " + (k==23?'selected=selected':"") + ">" + k + '</option>';
    	 }
    	 str+='</select>';
    	 $("#calendar").append(str);
     } 
     function showTime(){
    	 var strTime;
    	 var strGreet;
    	 var date = new Date();
    	 var hour = date.getHours();
    	 var minu = date.getMinutes();
    	 var second = date.getSeconds();
    	 var time = document.getElementById("time");
    	 var greet = document.getElementById("greet");
    	 strTime = hour + ":" + minu + ":" + second;
    	 if(hour>12&&hour<18){
    		 strGreet = "下午好";
    	 }
    	 time.innerHTML = strTime;
    	 greet.innerHTML = strGreet;
    	 setInterval("showTime()",300);
     }
     function deleteN(){
    	 var di = document.getElementById('div1');
    	 if(di.hasChildNodes()){
    		 di.removeChild(di.firstChild);
    	 }
     }
     function addRow(bl){
    	 var node = document.getElementById('select');
    	 node.style.width = 100 + "px";
    	 node.style.height = 50 + "px";
    	 node.style.display = "block";
    	 var cloneN = node.cloneNode(bl);
    	 var br = document.createElement('br');
    	 div1.appendChild(cloneN);
    	 div1.appendChild(br);
     }
     function createNode2(){
    	 var aText = ['ceshi1','ceshi2','ceshi3','ceshi4','ceshi5','ceshi6'];
    	 var cdf   = document.createDocumentFragment();
    	 for(var i = 0;i<aText.length;i++){
    		 var n = document.createElement("p");
    		 var param = document.createTextNode(aText[i]);
    		 n.appendChild(param);
    		 var br =  document.createElement("br");
    		 cdf.appendChild(n);
    		 cdf.appendChild(br);
//    		 n.style.display = "inline";
    	 }
    	 document.form1.appendChild(cdf);
     }
     function createNode1(){
    	 var aText = ['ceshi1','ceshi2','ceshi3','ceshi4','ceshi5','ceshi6'];
    	 for(var i = 0;i<aText.length;i++){
    		 var n = document.createElement("p");
    		 var param = document.createTextNode(aText[i]);
    		 n.appendChild(param);
//    		 n.style.display = "inline";
    		 document.form1.appendChild(n);
    	 }
     }
     function insertNode(nodeId,str){
    	 var node = createNode(str);
    	 var currentNode = document.getElementById(nodeId);
    	 if(currentNode.parentNode){
    		 currentNode.parentNode.insertBefore(node,currentNode)
    	 }
     }
     function createNode(str){
    	 var n = document.createElement("p");
    	 var param = document.createTextNode(str);
    	 n.appendChild(param);
    	 return n;
     }
     function floaters(){
    	 this.items = []
    	 this.addItem = function(id,x,y,content){
    		 document.write('<div id='+id+' style="z-index:10;position:absolute;width:80px;height:60px;left:'+(typeof(x)=='string'?eval(x):x)+';top:'+y+';">' + content + '</div>');
    	     var newItem = {};
    	     newItem.object = document.getElementById(id);
    	     newItem.x = x;
    	     if(y>10){y=0;}
    	     newItem.y = y;
    	     this.items[this.items.length] = newItem;
    	 }
    	 this.player = function(){
    		 layers = this.item;
    		 setInterval('play()',10);
    	 }
     }
     function play(){
    	 for(var i=0;i<layers.length;i++){
    		 var obj = layers[i].object;
    		 var obj_x = (typeof(layers[i].x)=='string'?eval(layers[i].x):x);
    		 var obj_y = (typeof(layers[i].y)=='string'?eval(layers[i].y):y);
    		 if(obj.offsetLeft!=(document.body.scrollLeft + obj_x)){
    			 var dx = (document.body.scrollTop+obj_y-obj.offsetTop)*delta;
    		 }
    	 }
     }
     function nodeS(txt,nodeName){
    	 
    	 switch(nodeName){
    	 case "parent":
    		 if(txt.nextSibling()){
    		     txt = txt.nextSibling;
    		 }else{
    			 alert('没兄弟');
    		 }
    	 }
    	 alert(txt.nodeName);
    	 return txt;
     }
     function permute(tfloor,Top,left){
    	 var realTop = parseInt(document.body.scrollTop);
    	 buyTop = Top + realTop;
    	 document.all[tfloor].style.top = buyTop;
    	 buyLeft = left + parseInt(document.body.scrollLeft);
    	 document.all(tfloor).style.left = buyLeft;
     }
     function changeBody(){
    	 var src;
    	 var i =Math.floor(Math.random()*3);
    	 switch(i){
    	 case 0:
    		 src = "images/login.jpg";
    		 break;
    	 case 1:
    		 src = "images/login1.jpg";
    		 break;
    	 case 2:
    		 src = "images/firstpage.jpg";
    		 break;
    	 }
    	 document.body.background = src;
    	 setTimeout("changeBody()",1000);
     }
     function deleteCookie(name){
    	 var date = new Date();
    	 date.setTime(date.getTime()-1000);
    	 document.cookie = name + "=删除" + ";expires=" + date.toGMTString();
     }
     function writeCookies(){
    	 document.cookie=encodeURI("username=" + document.form1.username.value);
    	 document.cookie=encodeURI("password=" + document.form1.password.value);
     }
     function readCookies(){
    	 var cookieString = decodeURI(document.cookie);
    	 var cookieArr = cookieString.split(";");
    	 for(var i=0;i<cookieArr.length;i++){
    		 var ncookie = cookieArr[i].split("=");
    		 $("#div1").append(ncookie[0] + ncookie[1]);
    	 }
     }
     function addInput(){
    	 var txt = document.createElement("input");
    	 txt.type = "text";
    	 txt.name = "txt";
    	 txt.value = "wenben";
    	 document.form1.appendChild(txt);
     }
     function changeColor(){
    	 
    	 if(n==arrayColor.length){
    		 n=0;
    	 }
    	 n++;
    	document.bgColor = arrayColor[n];
    	//document.fgColor = arrayColor[n-1];
    	 setTimeout("changeColor()",1000);
     }
     function fastness(){
    	 window.resizeTo(150,500);
     }
     function blowup(){
    	 alert("aaab");
     }
     function onunload(){
    	 alert('sssss');
     }
     function mouseMove(){
    	 var x = window.event.x;
    	 var y = window.event.y;
    	 $("#div1").append(x + y);
     }
     function AllReset(){
    	 var T = window.confirm('shifoujinxingchongzhi?');
    	 if(T){
    		 return true;
    	 }else{
    		 return false;
    	 }
     }
     function AllSubmit(){
    	 var T;
    	 var e = window.event;
    	 var obj = e.srcElement;
    	 alert(eval("obj." + "text" + 1).value);
//    	 for(var i =1;i<=2;i++){
//    		 if(eval("obj." + "text" + i).value==""){
//                 T = false;		 
//    			 break;
//    		 }
//    	 }
    	 if(!T){
    		 alert('xinxibunengkong');
    	 }
    	 return T;
     }
     function Fcolor(event){
    	 var e = window.event;
    	 var obj = e.srcElement;
    	 form1.text1.style.background = obj.options[obj.selectedIndex].value;
     }
     function txtfocus(event){
    	 var e = window.event;
    	 var obj = e.srcElement;
    	 obj.style.background = "#d3d3d3";
     }
     function txtblur(event){
    	 var e = window.event;
    	 var obj = e.srcElement;
    	 obj.style.background = "white";
     }
     function convert(xform){
    	 var result = 0;
    	 var dec = "";
    	 if(isNaN(xform)){
    		 result = 0;
    	 }else{
    		 if(xform.length<4){
    			 result = xform;
    		 }else{
    			 pos = xform.indexOf(".",1);
    			 if(pos>0){
    				 dec = xform.substr(pos);
    				 res = xform.substr(0,pos);
    			 }else{
    				 res = xform;
    			 }
    			 var tempResult = "";
    			 for(i = res.length;i>0;i-=3){
    				 if(i-3>0){
    					 tempResult ="," + res.substr(i-3,3) + tempResult; 
    				 }else{
    					 tempResult= res.substr(0,i) + tempResult;
    				 }
    			 }
    			 result = tempResult;
    		 }
    	 }
    	 return result;
     }
//   function ranStr(digit){
//	   var str = "0,1,2,3,4,5,6,7,8,9,a,b,c,d,e,f,g";
//	   var sArr = str.split(",");
//	   var enc = "";
//	   if(digit.isNaN||digit==""){
//		   alert("请输入数字");
//	   }else{
//		   for(var i =0;i<digit;i++){
//			   enc += sArr[Math.floor((Math.random()*(sArr.length)))];
//		   }
//	   }
//	   return enc;
//   }
//   function ran(digit){
//	   var str = "";
//	   for(var i =0;i<digit;i++){
//		   str+=Math.floor(10*Math.random());
//	   }
//	   alert(str); 
//   }
   function Table(row,col,width,height){
	   this.row = row;
	   this.col = col;
	   this.width = width;
	   this.height = height;
   }
   Table.prototype.border = 1;
   Table.prototype.createTable = function(){
	   var str = "";
	   var heads = "<table border = "+this.border+" width = "+this.width+" height = "+this.height+">";
	   var heade = "</table>";
	   var trs = "<tr>";
	   var tre = "</tr>";
	   str += heads;
	   for(var i = 1;i<=this.row;i++){
		   if(i%2==0){
			   trs="<tr bgcolor='#ddddff'>"
		   }else{
			   trs = "<tr bgcolor = 'white'>"
		   }
		   str += trs;
		   for(var j =1 ; j<=this.col; j++){
			   str += "<td>这是第"+ i +" 行 第"+j+"列</td>";
		   }
		   str += tre;
	   }
	   str += heade;
	   return str;
   }
   function table(span,col){
	   var str = "";
	   var heads = "<table border = '1px' width = '100%' height = '100%'>";
	   var heade = "</table>";
	   var trs = "<tr>";
	   var tre = "</tr>";
	   str += heads;
	   for(var i = 1;i<=span;i++){
		   if(i%2==0){
			   trs="<tr bgcolor='#ddddff'>"
		   }else{
			   trs = "<tr bgcolor = 'white'>"
		   }
		   str += trs;
		   for(var j =1 ; j<=col; j++){
			   str += "<td>这是第"+ i +" 行 第"+j+"列</td>";
		   }
		   str += tre;
	   }
	   str += heade;
	   return str;
   }
	

function addStr(){
	var txt1 = "<p>this is txt1</p>";
	var txt2 = $("<p></p>").text("this is txt2");
	var txt3 = document.createElement("p");
	txt3.innerHTML="this is txt3";
	$("body").append(txt1,txt2,txt3);
}

//$(document).ready(function(){	
//	$("#btn1").click(function(){
//		$("#p1").parent("div").css("width","700px");
//		alert($("#t1").width());
//	});
	
//	$("#t1").load("ajax.txt",function(responseTxt,statusTxt,xhr){
//		if(statusTxt=="success")
//		    	alert("外部内容加载成功！");
//		    if(statusTxt=="error")
//		    alert("Error: "+xhr.status+": "+xhr.statusText);
//	});
//	$("#btn2").click(function(){
//		loadXMLDoc();
//	});
//});
