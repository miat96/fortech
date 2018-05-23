<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>

    <title>Aplicatie</title>
    <style>
        body{
            background-color:#C5F0F3;
        }
        @import url(http://fonts.googleapis.com/css?family=Raleway);
		#cssmenu,
		#cssmenu ul,
		#cssmenu ul li,
		#cssmenu ul li a {
		  margin: 0;
		  padding: 0;
		  border: 0;
		  list-style: none;
		  line-height: 1;
		  display: block;
		  position: relative;
		  -webkit-box-sizing: border-box;
		  -moz-box-sizing: border-box;
		  box-sizing: border-box;
		}
		#cssmenu:after,
		#cssmenu > ul:after {
		  content: ".";
		  display: block;
		  clear: both;
		  visibility: hidden;
		  line-height: 0;
		  height: 0;
		}
		#cssmenu {
		  width: auto;
		  border-bottom: 3px solid #47c9af;
		  font-family: Raleway, sans-serif;
		  line-height: 1;
		}
		#cssmenu ul {
		  background: #ffffff;
		}
		#cssmenu > ul > li {
		  float: left;
		}
		#cssmenu.align-center > ul {
		  font-size: 0;
		  text-align: center;
		}
		#cssmenu.align-center > ul > li {
		  display: inline-block;
		  float: none;
		}
		#cssmenu.align-right > ul > li {
		  float: right;
		}
		#cssmenu.align-right > ul > li > a {
		  margin-right: 0;
		  margin-left: -4px;
		}
		#cssmenu > ul > li > a {
		  z-index: 2;
		  padding: 18px 25px 12px 25px;
		  font-size: 15px;
		  font-weight: 400;
		  text-decoration: none;
		  color: #444444;
		  -webkit-transition: all .2s ease;
		  -moz-transition: all .2s ease;
		  -ms-transition: all .2s ease;
		  -o-transition: all .2s ease;
		  transition: all .2s ease;
		  margin-right: -4px;
		}
		#cssmenu > ul > li.active > a,
		#cssmenu > ul > li:hover > a,
		#cssmenu > ul > li > a:hover {
		  color: #ffffff;
		}
		#cssmenu > ul > li > a:after {
		  position: absolute;
		  left: 0;
		  bottom: 0;
		  right: 0;
		  z-index: -1;
		  width: 100%;
		  height: 120%;
		  border-top-left-radius: 8px;
		  border-top-right-radius: 8px;
		  content: "";
		  -webkit-transition: all .2s ease;
		  -o-transition: all .2s ease;
		  transition: all .2s ease;
		  -webkit-transform: perspective(5px) rotateX(2deg);
		  -webkit-transform-origin: bottom;
		  -moz-transform: perspective(5px) rotateX(2deg);
		  -moz-transform-origin: bottom;
		  transform: perspective(5px) rotateX(2deg);
		  transform-origin: bottom;
		}
		#cssmenu > ul > li.active > a:after,
		#cssmenu > ul > li:hover > a:after,
		#cssmenu > ul > li > a:hover:after {
		  background: #47c9af;
		}
        
        
        
 		#wrap {
		   width:auto;
		   margin:0 auto;
		}
		#left_col {
		   display:flex;
		   flex-wrap:wrap;
		   float:left;
		   width:70%;
		}
		.divImage {
		   width:20%;
		   text-align:center;
		}
		#right_col {
		   float:right;
		   width:30%;
		}
		
		.inputRead {
			width:20px;
			border: none;
			border-color: transparent;
			background-color:#C5F0F3;
		}
		
		button {
		  display: inline-block;
		  padding: 5px 15px;
		  font-size: 15px;
		  cursor: pointer;
		  text-align: center;
		  text-decoration: none;
		  outline: none;
		  color: #fff;
		  background-color: #00ace6;
		  border: none;
		  border-radius: 7px;
		  box-shadow: 0 4px #999;
		}
		
		button:hover {background-color: #00394d}
		
		button:active {
		  background-color: #00394d;
		  box-shadow: 0 5px #666;
		  transform: translateY(4px);
		}
		
		#tabelLoad {
		    border-collapse: collapse;
		    width: 100%;
		}
		
		.thLoad, .tdLoad {
		    text-align: left;
		    padding: 8px;
		}
		
		.trLoad:nth-child(even){background-color: #ccccff}
		
		.trLoad:nth-child(odd){background-color: #e6e6ff}

		.thLoad {
		    background-color: #0052cc;
		    color: white;
		}
		
		.error {
			color: red;
			font-size: 15px;
		}
		
	</style>
        
</head>
<body>
		<div id='cssmenu'>
			<ul>
			
			   <li class='active'><a href='#'>Acasa</a></li>
			   
				<li><a href="${pageContext.request.contextPath}/goStudent">Student</a></li>
			  
			   <li><a href="${pageContext.request.contextPath}/goFacultate">Facultate</a></li>
			</ul>
		</div>

		<br><br><br>
	
		<div id="wrap">
		    <div id="left_col">
		    	<c:forEach items="${dataListCamere}" var="dataItem">
		    		<div class="divImage">
		    			<form action="/SpringMVCExample/loadStudentFromCamera" method="POST">
								<input type="image" src="http://worldartsme.com/images/student-door-clipart-1.jpg" onclick='<c:out value="ceva.do"></c:out>' height="110" width="80" />
								<br>
								<label>Camera:</label>
								<input class="inputRead" type="text" name="idCamera" value=${dataItem.idCamera} readonly><br>
								<label>Locuri libere:</label>
								<input class="inputRead" type="text" value=${dataItem.nrLocLiber} readonly>
							</form>
		    		</div>
		    	</c:forEach>
		    </div>
		    <div id="right_col">
		    	<form method="POST" action="/SpringMVCExample/addCamera">
					<table>
						<tr>
							<td><label>Numar camera:</label></td>
							<td><input type="text" name="idCamera"></td>
						</tr>
						<tr>
							<td><label>Numar locuri:</label></td>
							<td><input type="text" name="nrLocLiber"></td>
						</tr>
						<tr>
							<td colspan="2">
								<button class="buttonStyle" type="submit" name="addCamera" value="addCamera">
									Adauga
								</button>
							</td>
						</tr>
					</table>
				</form>
				<div class = "error">${errorAddCamera}</div>
				<br>
				
		    	<form method="POST" action="/SpringMVCExample/stergereCamera">
					<table>
						<tr>
							<td><label>Numar camera:</label></td>
							<td><input type="text" name="idCamera"></td>
						</tr>
						<tr>
							<td colspan="2">
								<button class="buttonStyle" type="submit" name="stergereCamera" value="stergereCamera">
									Stergere
								</button>
							</td>
						</tr>
					</table>
				</form> 
				<div class = "error">${errorStergereCamera}</div>
				<br>	
				
				<table id="tabelLoad">
					<tr class="trLoad">
						<th class="thLoad">CNP</th>
						<th class="thLoad">Nume</th>
						<th class="thLoad">Prenume</th>
						<th class="thLoad">Telefon</th>
						<th class="thLoad">Adresa</th>
					</tr>
		    		<c:forEach items="${dataListStudent}" var="dataItem">
				        <tr onclick="loadCNP(this)" class="trLoad">
				            <td class="tdLoad">${dataItem.cnp}</td>
				            <td class="tdLoad">${dataItem.nume}</td>
				            <td class="tdLoad">${dataItem.prenume}</td>
				            <td class="tdLoad">${dataItem.telefon}</td>
				            <td class="tdLoad">${dataItem.adresa}</td>
				        </tr>
				    </c:forEach>
		    	</table>
		    	<br>
		    	<form method="POST" action="/SpringMVCExample/stergereStudent">
					<table>
						<tr>
							<td><label>CNP student:</label></td>
							<td><input type="text" name="idStudent" id="idStudent" readonly></td>
						</tr>
						<tr>
							<td colspan="2">
								<button class="buttonStyle" type="submit" name="stergereStudent" value="stergereStudent">
									Stergere
								</button>
							</td>
						</tr>
					</table>
				</form> 
				<div class = "error">${errorStergereStudent}</div>		
		    </div>
		</div>
	
	<script type="text/javascript">
		function loadCNP(o) {			
			var tds= o.getElementsByTagName('td');			
			document.getElementById("idStudent").value = tds[0].innerHTML;
		}
	</script>
	
	
	
	
	
</body>
</html>