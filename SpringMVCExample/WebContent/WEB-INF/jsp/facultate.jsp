<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
		
		#divForm {
			padding-top: 20px;
    		padding-bottom: 20px;	
		}
		select {
			height: 30px;
		}
	
	</style>

</head>
<body>


		<div id='cssmenu'>
			<ul>
				<li><a href="${pageContext.request.contextPath}/goResult">Acasa</a></li>
				<li><a href="${pageContext.request.contextPath}/goStudent">Student</a></li>
				<li class='active'><a href='#'>Facultate</a></li>
			</ul>
		</div>
		
		<div id="divForm">
			<form method="POST" action="/SpringMVCExample/loadStudenti">
				<select name="denumire">
			        <c:forEach items="${universitati}" var="univ">
			            <option>${univ.denumire}</option>
			        </c:forEach>
			    </select>
			    <button type="submit" name="loadStudeni" value="loadStudenti">
					Cautare Studenti
				</button>
			</form>
		</div>
	
		<table id="tabelLoad">
					<tr class="trLoad">
						<th class="thLoad" onclick="sortTable(0, 'tabelLoad')">CNP</th>
						<th class="thLoad" onclick="sortTable(1, 'tabelLoad')">Nume</th>
						<th class="thLoad" onclick="sortTable(2, 'tabelLoad')">Prenume</th>
						<th class="thLoad" onclick="sortTable(3, 'tabelLoad')">Telefon</th>
						<th class="thLoad" onclick="sortTable(4, 'tabelLoad')">Adresa</th>
					</tr>
		    		<c:forEach items="${dataList}" var="dataItem">
				        <tr class="trLoad">
				            <td class="tdLoad">${dataItem.cnp}</td>
				            <td class="tdLoad">${dataItem.nume}</td>
				            <td class="tdLoad">${dataItem.prenume}</td>
				            <td class="tdLoad">${dataItem.telefon}</td>
				            <td class="tdLoad">${dataItem.adresa}</td>
				        </tr>
				    </c:forEach>
		  </table>	   
	   
		  <script>
	            function sortTable(n, tblid) {
	                var table, rows, switching, i, x, y, shouldSwitch, dir, switchcount = 0;
	                table = document.getElementById(tblid);
	                switching = true;
	                dir = "asc";
	                while (switching) {
	                    switching = false;
	                    rows = table.getElementsByTagName("TR");
	                    for (i = 1; i < (rows.length - 1); i++) {
	                        shouldSwitch = false;
	                        x = rows[i].getElementsByTagName("TD")[n];
	                        y = rows[i + 1].getElementsByTagName("TD")[n];
	                        if(isNumeric(x.textContent) && isNumeric(y.textContent)){
	                            var vx = parseFloat(x.textContent);
	                            var vy = parseFloat(y.textContent);
	                            if (dir == "asc") {                   
	                                if (vx >vy){
	                                    shouldSwitch= true;
	                                    break;
	                                }
	                            } else if (dir == "desc") {
	                                if (vx < vy) {
	                                    shouldSwitch= true;
	                                    break;
	                                }
	                            }
	                   
	                        }
	                        else{   
	                            if (dir == "asc") {
	                                if (x.innerHTML.toLowerCase() > y.innerHTML.toLowerCase()) {
	                                    shouldSwitch= true;
	                                    break;
	                                }
	                            } else if (dir == "desc") {
	                                    if (x.innerHTML.toLowerCase() < y.innerHTML.toLowerCase()) {
	                                    shouldSwitch= true;
	                                    break;
	                                }
	                            }
	                        }
	                    }
	                    if (shouldSwitch) {
	                        rows[i].parentNode.insertBefore(rows[i + 1], rows[i]);
	                        switching = true;
	                        switchcount ++;      
	                    } else {
	                        if (switchcount == 0 && dir == "asc") {
	                            dir = "desc";
	                            switching = true;
	                        }
	                    }
	                }
	            }
	
	            function isNumeric(n) {      
	                return parseFloat(n) == n && !isNaN(parseFloat(n)) && isFinite(n);
	            }
	       </script>

</body>
</html>