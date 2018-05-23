<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
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
		   flex-wrap:wrap;
		   float:left;
		   width:40%;
		}
		#right_col {
		   padding-top: 30px;
		   float:right;
		   width:60%;
		}
		
		.tabelLoad {
		    border-collapse: collapse;
		    width: 100%;
		}
		
		.thLoad, .tdLoad {
		    text-align: left;
		    padding: 8px;
		}
		
		.thLoad {
		    background-color: #0052cc;
		    color: white;
		}
		
		.trLoad:nth-child(even){background-color: #ccccff}
		
		.trLoad:nth-child(odd){background-color: #e6e6ff}
		
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
		.error {
			color: red;
			font-size: 15px;
		}
		
	</style>

</head>
<body>

		<div id='cssmenu'>
			<ul>
			
			   	<li><a href="${pageContext.request.contextPath}/goResult">Acasa</a></li>
			   
				<li class="active"><a href="#">Student</a></li>
			  
			   	<li><a href="${pageContext.request.contextPath}/goFacultate">Facultate</a></li>
			</ul>
		</div>
		
		<div id="wrap">
		    <div id="left_col">
					<form name="myForm" method="POST" action="/SpringMVCExample/addStudent">
						<table cellspacing="15">
							<tr>
								<td><label>CNP:</label></td>
								<td><input type="text" name="cnp" id="cnp"></td>
							</tr>
							<tr>
								<td><label>Nume:</label></td>
								<td><input type="text" name="nume" id="nume"></td>
							</tr>
							<tr>
								<td><label>Prenume:</label></td>
								<td><input type="text" name="prenume" id="prenume"></td>
							</tr>
							<tr>
								<td><label>Telefon:</label></td>
								<td><input type="text" name="telefon" id="telefon"></td>
							</tr>
							<tr>
								<td><label>Adresa:</label></td>
								<td><input type="text" name="adresa" id="adresa"></td>
							</tr>
							<tr>
								<td><label>Numarul camerei:</label></td>
								<td><input type="text" name="cameraID" id="cameraID"></td>
							</tr>
							<tr>
								<td><label>Id-ul facultatii:</label></td>
								<td><input type="text" name="universitateID" id="universitateID"></td>
							</tr>
							<tr>
								<td colspan="2">
									<button type="submit" name="addStudent" value="addStudent">
									Adauga
									</button>
								</td>
							</tr>
						</table>
					</form>
					<div class="error">${error}</div>
			 </div>
			<div id="right_col">
			
				<table class="tabelLoad">
						<tr>
							<th class="thLoad">Id facultate</th>
							<th class="thLoad">Denumire</th>
							<th class="thLoad">Adresa</th>
						</tr>
			    		<c:forEach items="${dataListFacultati}" var="data">
					        <tr class="trLoad">
					            <td class="tdLoad">${data.idFacultate}</td>
					            <td class="tdLoad">${data.denumire}</td>
					            <td class="tdLoad">${data.adresa}</td>
					        </tr>
					    </c:forEach>
			    </table>
				 
				<br><br>
			
				<form method="POST" action="/SpringMVCExample/cautareStudentiByNume">
					<label>Cautare studenti dupa nume: </label>
					<input type="text" name="numeCautare"></td>
					<button class="buttonStyle" type="submit" name="cautareStudenti" value="cautareStudenti">
						Cautare
					</button>	
				</form>
				<br><br>
				
				<table class="tabelLoad">
			    		<c:forEach items="${dataListStudent}" var="dataItem">
					        <tr onclick="loadDate(this)" class="trLoad">
					            <td class="tdLoad">${dataItem.cnp}</td>
					            <td class="tdLoad">${dataItem.nume}</td>
					            <td class="tdLoad">${dataItem.prenume}</td>
					            <td class="tdLoad">${dataItem.telefon}</td>
					            <td class="tdLoad">${dataItem.adresa}</td>
					        </tr>
					    </c:forEach>
			    </table>
			</div>
		</div>
	
	<script type="text/javascript">
		function loadDate(o) {			
			var tds= o.getElementsByTagName('td');			
			document.getElementById("cnp").value = tds[0].innerHTML;
			document.getElementById("nume").value = tds[1].innerHTML;
			document.getElementById("prenume").value = tds[2].innerHTML;
			document.getElementById("telefon").value = tds[3].innerHTML;
			document.getElementById("adresa").value = tds[4].innerHTML;			
		}
	</script>

</body>
</html>