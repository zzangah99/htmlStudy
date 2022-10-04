<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<!-- <link rel="stylesheet" type="text/css" href="jqGrid-4.7.1/plugin/grid/css/jquery-ui.css"> -->
<link rel="stylesheet" type="text/css" href="jqGrid-4.7.1/css/ui.jqgrid.css">
 
<script type="text/javascript" src="../js/jquery-3.6.1.min.js"></script>
<script type="text/javascript" src="jqGrid-4.7.1/js/i18n/grid.locale-kr.js"></script>
<script type="text/javascript" src="jqGrid-4.7.1/js/minified/jquery.jqGrid.min.js"></script>

<script type="text/javascript">
	var gridData = [{seq:"1", create_date:"2022-10-03", create_name:"세륜", title:"note1"},
		{seq:"2", create_date:"2022-10-03", create_name:"삼진", title:"note2"},
		{seq:"3", create_date:"2022-10-03", create_name:"채란", title:"note3"},
		{seq:"4", create_date:"2022-10-03", create_name:"용식", title:"note4"},
		{seq:"5", create_date:"2022-10-03", create_name:"효경", title:"note5"},
		{seq:"6", create_date:"2022-10-03", create_name:"종영", title:"note6"}];


	var searchResultColNames =  ['관리번호', '날짜', '이름', '제목'];
	/* var searchResultColModel =         
	                [{name:'bbsMgtNo',       index:'bbsMgtNo',      align:'center', hidden:true},
	                {name:'bbsNum',         index:'bbsNum',        align:'left',   width:'12%'},
	                {name:'bbsTitle',       index:'bbsTitle',      align:'center', width:'50%'},
	                {name:'bbsWriter',      index:'bbsWriter',     align:'center', width:'14%'},
	                {name:'bbsDate',        index:'bbsDate',       align:'center', width:'12%'},
	                {name:'bbsHit',         index:'bbsHit',        align:'center', width:'12%'}]; */
	 
	$(function() {
	        $("#testGrid").jqGrid({
	        	datatype:"local",
	            height: 250,
	            width: 1000,
	            colNames: searchResultColNames,
	            colModel: [            // 컬럼 모델
	                {name:'seq'},
	                {name:'create_date'},
	                {name:'create_name'},
	                {name:'title'}
	            ],
	            rowNum : 10,
	            pager: "pager",
	            caption:"테스트 목록"
	        });
	   });
	  
	for(let i=0; i<gridData.length; i++){
	/* jqGrid의 addRowData를 이용하여 각각의 row에 gridData 변수의 데이터를 add한다. */
		$("#testGrid").jqGrid('addRowData', i+1, gridData[i]);
	}

</script>

</head>
<body>
	<div class="table">
		<table id="testGrid"></table>
		<div id="pager"></div>
	</div>
	
	
</body>
</html>