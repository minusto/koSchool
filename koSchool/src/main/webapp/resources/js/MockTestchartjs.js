//언어 차트 START
$(function() {
	if(($("#selectNowMock").html())!= null){
		var selectNowMock = $("#selectNowMock").html().substr(7,7);
	}
		
	var myKorScore = new Array("0","0","0","0","0","0","0","0","0","0");
	for(var i in myKorScore){	
		if(typeof $("#myKorScore"+i).val() !== 'undefined'){
			myKorScore[i] = $("#myKorScore"+i).val();
		}
	}
	
	var mockKorAvg=new Array("0","0","0","0","0","0","0","0","0","0");
	for(var i in mockKorAvg){
		if(typeof $("#mockKorAvg"+i).val() !== 'undefined'){
			mockKorAvg[i] = $("#mockKorAvg"+i).val();
		}		
	}
	
	var mockName=new Array("미응시","미응시","미응시","미응시","미응시","미응시","미응시","미응시","미응시");
	for(var i = 0 ; i < mockName.length; i++){
		if(typeof $("#mockName"+i).html() !== 'undefined'){
		mockName[i] = ($("#mockName"+i).html()).substr(7,7);
		}
		
	}
	var studentName=$("#studentName").val();
	var result=0;
	

	for(var i = 0 ; i < mockName.length; i++){
		if((mockName[i] !== '미응시')&&(mockName[i]==selectNowMock)){
			if(Number(myKorScore[i])<Number(mockKorAvg[i])){
				result=Number(mockKorAvg[i])-Number(myKorScore[i]);
				$("#mockKorScore"+i).append(mockName[i]+'- 언어평균점수 :'+mockKorAvg[i]+"점,   "+studentName+'학생의 언어점수:'+myKorScore[i]+'점  '+'<br>평균보다 '+result+'점 낮습니다');			
			}else if(Number(mockKorAvg[i])<Number(myKorScore[i])){
				result=Number(myKorScore[i])-Number(mockKorAvg[i]);
				$("#mockKorScore"+i).append(mockName[i]+'- 언어평균점수 :'+mockKorAvg[i]+"점,   "+studentName+'학생의 언어점수:'+myKorScore[i]+'점  '+'<br>평균보다 '+result+'점 높습니다');			
			}else{
				$("#mockKorScore"+i).append(mockName[i]+'- 언어평균점수 :'+mockKorAvg[i]+"점,   "+studentName+'학생의 언어점수:'+myKorScore[i]+'점  '+'<br>평균점수와 동일합니다');			
			}
		}
	}


	
  var ctx, data, myLineChart, options;
  Chart.defaults.global.responsive = true;
  ctx = $('#line-chart').get(0).getContext('2d');
  options = {
	scaleOverride : true,
	scaleSteps : 5,
	scaleStepWidth : 20,
	scaleStartValue : 0 ,
    scaleShowGridLines: true,
    scaleGridLineColor: "rgba(0,0,0,.05)",
    scaleGridLineWidth: 1,
    scaleShowHorizontalLines: true,
    scaleShowVerticalLines: true,
    bezierCurve: false,
    bezierCurveTension: 0.4,
    pointDot: true,
    pointDotRadius: 4,
    pointDotStrokeWidth: 1,
    pointHitDetectionRadius: 20,
    datasetStroke: true,
    datasetStrokeWidth: 2,
    datasetFill: true,
    multiTooltipTemplate: "<%= datasetLabel %> - <%= value %>",
    legendTemplate: "<ul class=\"<%=name.toLowerCase()%>-legend\"><% for (var i=0; i<datasets.length; i++){%><li><span style=\"background-color:<%=datasets[i].strokeColor%>\"></span><%if(datasets[i].label){%><%=datasets[i].label%><%}%></li><%}%></ul>"
  };
  data = {
    labels: [mockName[0],mockName[1],mockName[2],mockName[3],mockName[4],mockName[5],mockName[6],mockName[7],mockName[8]],
    datasets: [
      {
        label: "내점수",
        fillColor: "rgba(26, 188, 156,0.2)",
        strokeColor: "#1ABC9C",
        pointColor: "#1ABC9C",
        pointStrokeColor: "#fff",
        pointHighlightFill: "#fff",
        pointHighlightStroke: "#1ABC9C",
        data: [Number(myKorScore[0]), Number(myKorScore[1]), Number(myKorScore[2]) ,Number(myKorScore[3]),Number(myKorScore[4]),Number(myKorScore[5]),Number(myKorScore[6]),Number(myKorScore[7]),Number(myKorScore[8])]
      }, {
        label: "평균점수",
        fillColor: "rgba(34, 167, 240,0.2)",
        strokeColor: "#22A7F0",
        pointColor: "#22A7F0",
        pointStrokeColor: "#fff",
        pointHighlightFill: "#fff",
        pointHighlightStroke: "#22A7F0",
        data: [Number(mockKorAvg[0]),Number(mockKorAvg[1]),Number(mockKorAvg[2]),Number(mockKorAvg[3]),Number(mockKorAvg[4]),Number(mockKorAvg[5]),Number(mockKorAvg[6]),Number(mockKorAvg[7]),Number(mockKorAvg[8])]
      }
    ]
  };
  myLineChart = new Chart(ctx).Line(data, options);
});

//언어 차트 END

//수리 차트 START
$(function() {
	if(($("#selectNowMock").html())!= null){
		var selectNowMock = $("#selectNowMock").html().substr(7,7);
	}

	var myMathScore = new Array("0","0","0","0","0","0","0","0","0","0");
	for(var i in myMathScore){	
		if(typeof $("#myMathScore"+i).val() !== 'undefined'){
			myMathScore[i] = $("#myMathScore"+i).val();
		}
	}
	
	var mockMathAvg=new Array("0","0","0","0","0","0","0","0","0","0");
	for(var i in mockMathAvg){
		if(typeof $("#mockMathAvg"+i).val() !== 'undefined'){
			mockMathAvg[i] = $("#mockMathAvg"+i).val();
		}		
	}
	
	var mockName=new Array("미응시","미응시","미응시","미응시","미응시","미응시","미응시","미응시","미응시");
	for(var i = 0 ; i < mockName.length; i++){
		if(typeof $("#mockName"+i).html() !== 'undefined'){
		mockName[i] = ($("#mockName"+i).html()).substr(7,7);
		}
	}
	var studentName=$("#studentName").val();
	var result=0;
	for(var i = 0 ; i < mockName.length; i++){
		if((mockName[i] !== '미응시')&&(mockName[i]==selectNowMock)){
			if(Number(myMathScore[i])<Number(mockMathAvg[i])){
				result=Number(mockMathAvg[i])-Number(myMathScore[i]);
				$("#mockMathScore"+i).append(mockName[i]+'- 수리평균점수 :'+mockMathAvg[i]+"점,   "+studentName+'학생의 수리점수:'+myMathScore[i]+'점  '+'<br>평균보다 '+result+'점 낮습니다');			
			}else if(Number(mockMathAvg[i])<Number(myMathScore[i])){
				result=Number(myMathScore[i])-Number(mockMathAvg[i]);
				$("#mockMathScore"+i).append(mockName[i]+'- 수리평균점수 :'+mockMathAvg[i]+"점,   "+studentName+'학생의 수리점수:'+myMathScore[i]+'점  '+'<br>평균보다 '+result+'점 높습니다');			
			}else{
				$("#mockMathScore"+i).append(mockName[i]+'- 수리평균점수 :'+mockMathAvg[i]+"점,   "+studentName+'학생의 수리점수:'+myMathScore[i]+'점  '+'<br>평균점수와 동일합니다');			
			}
		}
	}


	
  var ctx, data, myMathLineChart, options;
  Chart.defaults.global.responsive = true;
  ctx = $('#line-math').get(0).getContext('2d');
  options = {
	scaleOverride : true,
	scaleSteps : 5,
	scaleStepWidth : 20,
	scaleStartValue : 0 ,		  
    scaleShowGridLines: true,
    scaleGridLineColor: "rgba(0,0,0,.05)",
    scaleGridLineWidth: 1,
    scaleShowHorizontalLines: true,
    scaleShowVerticalLines: true,
    bezierCurve: false,
    bezierCurveTension: 0.4,
    pointDot: true,
    pointDotRadius: 4,
    pointDotStrokeWidth: 1,
    pointHitDetectionRadius: 20,
    datasetStroke: true,
    datasetStrokeWidth: 2,
    datasetFill: true,
    multiTooltipTemplate: "<%= datasetLabel %> - <%= value %>",
    legendTemplate: "<ul class=\"<%=name.toLowerCase()%>-legend\"><% for (var i=0; i<datasets.length; i++){%><li><span style=\"background-color:<%=datasets[i].strokeColor%>\"></span><%if(datasets[i].label){%><%=datasets[i].label%><%}%></li><%}%></ul>"
  };
  data = {
    labels: [mockName[0],mockName[1],mockName[2],mockName[3],mockName[4],mockName[5],mockName[6],mockName[7],mockName[8]],
    datasets: [
      {
        label: "내점수",
        fillColor: "rgba(26, 188, 156,0.2)",
        strokeColor: "#1ABC9C",
        pointColor: "#1ABC9C",
        pointStrokeColor: "#fff",
        pointHighlightFill: "#fff",
        pointHighlightStroke: "#1ABC9C",
        data: [Number(myMathScore[0]), Number(myMathScore[1]), Number(myMathScore[2]) ,Number(myMathScore[3]),Number(myMathScore[4]),Number(myMathScore[5]),Number(myMathScore[6]),Number(myMathScore[7]),Number(myMathScore[8])]
      }, {
        label: "평균점수",
        fillColor: "rgba(34, 167, 240,0.2)",
        strokeColor: "#22A7F0",
        pointColor: "#22A7F0",
        pointStrokeColor: "#fff",
        pointHighlightFill: "#fff",
        pointHighlightStroke: "#22A7F0",
        data: [Number(mockMathAvg[0]),Number(mockMathAvg[1]),Number(mockMathAvg[2]),Number(mockMathAvg[3]),Number(mockMathAvg[4]),Number(mockMathAvg[5]),Number(mockMathAvg[6]),Number(mockMathAvg[7]),Number(mockMathAvg[8])]
      }
    ]
  };
  myMathLineChart = new Chart(ctx).Line(data, options);
});
//수리 차트 END



//외국어 차트 START
$(function() {
	if(($("#selectNowMock").html())!= null){
		var selectNowMock = $("#selectNowMock").html().substr(7,7);
	}
	
	var myEngScore = new Array("0","0","0","0","0","0","0","0","0","0");
	for(var i in myEngScore){	
		if(typeof $("#myEngScore"+i).val() !== 'undefined'){
			myEngScore[i] = $("#myEngScore"+i).val();
		}

	}

	var mockEngAvg=new Array("0","0","0","0","0","0","0","0","0","0");
	for(var i in mockEngAvg){
		if(typeof $("#mockEngAvg"+i).val() !== 'undefined'){
			mockEngAvg[i] = $("#mockEngAvg"+i).val();
		}		
		
	}
	
	var mockName=new Array("미응시","미응시","미응시","미응시","미응시","미응시","미응시","미응시","미응시");
	for(var i = 0 ; i < mockName.length; i++){
		if(typeof $("#mockName"+i).html() !== 'undefined'){
		mockName[i] = ($("#mockName"+i).html()).substr(7,7);
		}
	}
	var studentName=$("#studentName").val();
	var result=0;
	
	
	
	for(var i = 0 ; i < mockName.length; i++){
		if((mockName[i] !== '미응시')&&(mockName[i]==selectNowMock)){
			if(Number(myEngScore[i])<Number(mockEngAvg[i])){
				result=Number(mockEngAvg[i])-Number(myEngScore[i]);
				$("#mockEngScore"+i).append(mockName[i]+'- 외국어평균점수 :'+mockEngAvg[i]+"점,   "+studentName+'학생의 외국어점수:'+myEngScore[i]+'점  '+'<br>평균보다 '+result+'점 낮습니다');			
			}else if(Number(mockEngAvg[i])<Number(myEngScore[i])){
				result=Number(myEngScore[i])-Number(mockEngAvg[i]);
				$("#mockEngScore"+i).append(mockName[i]+'- 외국어평균점수 :'+mockEngAvg[i]+"점,   "+studentName+'학생의 외국어점수:'+myEngScore[i]+'점  '+'<br>평균보다 '+result+'점 높습니다');			
			}else{
				$("#mockEngScore"+i).append(mockName[i]+'- 외국어평균점수 :'+mockEngAvg[i]+"점,   "+studentName+'학생의 외국어점수:'+myEngScore[i]+'점  '+'<br>평균점수와 동일합니다');
			}
		}
	}


	
  var ctx, data, myEngLineChart, options;
  Chart.defaults.global.responsive = true;
  ctx = $('#chartEng').get(0).getContext('2d');
  options = {	
	scaleOverride : true,
	scaleSteps : 5,
	scaleStepWidth : 20,
	scaleStartValue : 0 ,
    scaleShowGridLines: true,
    scaleGridLineColor: "rgba(0,0,0,.05)",
    scaleGridLineWidth: 1,
    scaleShowHorizontalLines: true,
    scaleShowVerticalLines: true,
    bezierCurve: false,
    bezierCurveTension: 0.4,
    pointDot: true,
    pointDotRadius: 4,
    pointDotStrokeWidth: 1,
    pointHitDetectionRadius: 20,
    datasetStroke: true,
    datasetStrokeWidth: 2,
    datasetFill: true,
    multiTooltipTemplate: "<%= datasetLabel %> - <%= value %>",
    legendTemplate: "<ul class=\"<%=name.toLowerCase()%>-legend\"><% for (var i=0; i<datasets.length; i++){%><li><span style=\"background-color:<%=datasets[i].strokeColor%>\"></span><%if(datasets[i].label){%><%=datasets[i].label%><%}%></li><%}%></ul>"
  };
  data = {
    labels: [mockName[0],mockName[1],mockName[2],mockName[3],mockName[4],mockName[5],mockName[6],mockName[7],mockName[8]],
    datasets: [
      {
        label: "내점수",
        fillColor: "rgba(26, 188, 156,0.2)",
        strokeColor: "#1ABC9C",
        pointColor: "#1ABC9C",
        pointStrokeColor: "#fff",
        pointHighlightFill: "#fff",
        pointHighlightStroke: "#1ABC9C",
        data: [Number(myEngScore[0]), Number(myEngScore[1]), Number(myEngScore[2]) ,Number(myEngScore[3]),Number(myEngScore[4]),Number(myEngScore[5]),Number(myEngScore[6]),Number(myEngScore[7]),Number(myEngScore[8])]
      }, {
        label: "평균점수",
        fillColor: "rgba(34, 167, 240,0.2)",
        strokeColor: "#22A7F0",
        pointColor: "#22A7F0",
        pointStrokeColor: "#fff",
        pointHighlightFill: "#fff",
        pointHighlightStroke: "#22A7F0",
        data: [Number(mockEngAvg[0]),Number(mockEngAvg[1]),Number(mockEngAvg[2]),Number(mockEngAvg[3]),Number(mockEngAvg[4]),Number(mockEngAvg[5]),Number(mockEngAvg[6]),Number(mockEngAvg[7]),Number(mockEngAvg[8])]
      }
    ]
  };
  myEngLineChart = new Chart(ctx).Line(data, options);
});
//외국어 차트 END












/*

$(function() {
	var myKorScore = new Array("0","0","0","0","0","0","0","0","0","0");
	for(var i in myKorScore){	
		if(typeof $("#myKorScore"+i).val() !== 'undefined'){
			myKorScore[i] = $("#myKorScore"+i).val();
		}
	}
	
	var mockKorAvg=new Array("0","0","0","0","0","0","0","0","0","0");
	for(var i in mockKorAvg){
		if(typeof $("#mockKorAvg"+i).val() !== 'undefined'){
			mockKorAvg[i] = $("#mockKorAvg"+i).val();
		}		
	}
	
	var mockName=new Array("미응시","미응시","미응시","미응시","미응시","미응시","미응시","미응시","미응시");
	for(var i = 0 ; i < mockName.length; i++){
		if(typeof $("#mockName"+i).html() !== 'undefined'){
		mockName[i] = ($("#mockName"+i).html()).substr(7,7);
		}
	}
	var studentName=$("#studentName").val();
	var result=0;
	for(var i = 0 ; i < mockName.length; i++){
		if(mockName[i] !== '미응시'){
			if(Number(myKorScore[i])<Number(mockKorAvg[i])){
				result=Number(mockKorAvg[i])-Number(myKorScore[i]);
				$("#mockScore1"+i).append(mockName[i]+'언어평균점수 :'+mockKorAvg[i]+"점   "+studentName+'학생의 언어점수:'+myKorScore[i]+'점  '+'평균보다'+result+'점 낮습니다');			
			}else if(Number(mockKorAvg[i])<Number(myKorScore[i])){
				result=Number(myKorScore[i])-Number(mockKorAvg[i]);
				$("#mockScore1"+i).append(mockName[i]+'언어평균점수 :'+mockKorAvg[i]+"점   "+studentName+'학생의 언어점수:'+myKorScore[i]+'점  '+'평균보다'+result+'점 높습니다');			
			}
		}
	}
	
	
	
  var ctx, data, myBarChart, option_bars;
  Chart.defaults.global.responsive = true;
  ctx = $('#line-math').get(0).getContext('2d');
  option_bars = {
    scaleBeginAtZero: true,
    scaleShowGridLines: true,
    scaleGridLineColor: "rgba(0,0,0,.05)",
    scaleGridLineWidth: 1,
    scaleShowHorizontalLines: true,
    scaleShowVerticalLines: false,
    barShowStroke: true,
    barStrokeWidth: 1,
    barValueSpacing: 5,
    barDatasetSpacing: 3,
    legendTemplate: "<ul class=\"<%=name.toLowerCase()%>-legend\"><% for (var i=0; i<datasets.length; i++){%><li><span style=\"background-color:<%=datasets[i].fillColor%>\"></span><%if(datasets[i].label){%><%=datasets[i].label%><%}%></li><%}%></ul>"
  };
  data = {
    labels: [mockName[0],mockName[1],mockName[2],mockName[3],mockName[4],mockName[5],mockName[6],mockName[7],mockName[8]],
    datasets: [
      {
        label: "My First dataset",
        fillColor: "rgba(26, 188, 156,0.6)",
        strokeColor: "#1ABC9C",
        pointColor: "#1ABC9C",
        pointStrokeColor: "#fff",
        pointHighlightFill: "#fff",
        pointHighlightStroke: "#1ABC9C",
        data: [Number(myKorScore[0]), Number(myKorScore[1]), Number(myKorScore[2]) ,Number(myKorScore[3]),Number(myKorScore[4]),Number(myKorScore[5]),Number(myKorScore[6]),Number(myKorScore[7]),Number(myKorScore[8])]
      }, {
        label: "My Second dataset",
        fillColor: "rgba(34, 167, 240,0.6)",
        strokeColor: "#22A7F0",
        pointColor: "#22A7F0",
        pointStrokeColor: "#fff",
        pointHighlightFill: "#fff",
        pointHighlightStroke: "#22A7F0",
        data: [Number(mockKorAvg[0]),Number(mockKorAvg[1]),Number(mockKorAvg[2]),Number(mockKorAvg[3]),Number(mockKorAvg[4]),Number(mockKorAvg[5]),Number(mockKorAvg[6]),Number(mockKorAvg[7]),Number(mockKorAvg[8])]
      }
    ]
  };
  myBarChart = new Chart(ctx).Bar(data, option_bars);
});





$(function() {
  var ctx, data, myBarChart, option_bars;
  Chart.defaults.global.responsive = true;
  ctx = $('#radar-chart').get(0).getContext('2d');
  option_bars = {
    scaleBeginAtZero: true,
    scaleShowGridLines: true,
    scaleGridLineColor: "rgba(0,0,0,.05)",
    scaleGridLineWidth: 1,
    scaleShowHorizontalLines: true,
    scaleShowVerticalLines: false,
    barShowStroke: false,
    barStrokeWidth: 0,
    barValueSpacing: 5,
    barDatasetSpacing: 1,
    legendTemplate: "<ul class=\"<%=name.toLowerCase()%>-legend\"><% for (var i=0; i<datasets.length; i++){%><li><span style=\"background-color:<%=datasets[i].fillColor%>\"></span><%if(datasets[i].label){%><%=datasets[i].label%><%}%></li><%}%></ul>"
  };
  data = {
    labels: ['Jan', 'Feb', 'Mar', 'Apr', 'May', 'Jun', 'Jul'],
    datasets: [
      {
        label: "My First dataset",
        fillColor: "rgba(26, 188, 156,0.2)",
        strokeColor: "#1ABC9C",
        pointColor: "#1ABC9C",
        pointStrokeColor: "#fff",
        pointHighlightFill: "#fff",
        pointHighlightStroke: "#1ABC9C",
        data: [65, 59, 80, 81, 56, 55, 40]
      }, {
        label: "My Second dataset",
        fillColor: "rgba(34, 167, 240,0.2)",
        strokeColor: "#22A7F0",
        pointColor: "#22A7F0",
        pointStrokeColor: "#fff",
        pointHighlightFill: "#fff",
        pointHighlightStroke: "#22A7F0",
        data: [28, 48, 40, 19, 86, 27, 90]
      }
    ]
  };
  myBarChart = new Chart(ctx).Radar(data, option_bars);
});

$(function() {
  var ctx, data, myPolarAreaChart, option_bars;
  Chart.defaults.global.responsive = true;
  ctx = $('#polar-area-chart').get(0).getContext('2d');
  option_bars = {
    scaleShowLabelBackdrop: true,
    scaleBackdropColor: "rgba(255,255,255,0.75)",
    scaleBeginAtZero: true,
    scaleBackdropPaddingY: 2,
    scaleBackdropPaddingX: 2,
    scaleShowLine: true,
    segmentShowStroke: true,
    segmentStrokeColor: "#fff",
    segmentStrokeWidth: 2,
    animationSteps: 100,
    animationEasing: "easeOutBounce",
    animateRotate: true,
    animateScale: false,
    legendTemplate: "<ul class=\"<%=name.toLowerCase()%>-legend\"><% for (var i=0; i<segments.length; i++){%><li><span style=\"background-color:<%=segments[i].fillColor%>\"></span><%if(segments[i].label){%><%=segments[i].label%><%}%></li><%}%></ul>"
  };
  data = [
    {
      value: 300,
      color: "#FA2A00",
      highlight: "#FA2A00",
      label: "Red"
    }, {
      value: 50,
      color: "#1ABC9C",
      highlight: "#1ABC9C",
      label: "Green"
    }, {
      value: 100,
      color: "#FABE28",
      highlight: "#FABE28",
      label: "Yellow"
    }, {
      value: 40,
      color: "#999",
      highlight: "#999",
      label: "Grey"
    }, {
      value: 120,
      color: "#22A7F0",
      highlight: "#22A7F0",
      label: "Blue"
    }
  ];
  myPolarAreaChart = new Chart(ctx).PolarArea(data, option_bars);
});

$(function() {
  var ctx, data, myLineChart, options;
  Chart.defaults.global.responsive = true;
  ctx = $('#pie-chart').get(0).getContext('2d');
  options = {
    showScale: false,
    scaleShowGridLines: false,
    scaleGridLineColor: "rgba(0,0,0,.05)",
    scaleGridLineWidth: 0,
    scaleShowHorizontalLines: false,
    scaleShowVerticalLines: false,
    bezierCurve: false,
    bezierCurveTension: 0.4,
    pointDot: false,
    pointDotRadius: 0,
    pointDotStrokeWidth: 2,
    pointHitDetectionRadius: 20,
    datasetStroke: true,
    datasetStrokeWidth: 4,
    datasetFill: true,
    legendTemplate: "<ul class=\"<%=name.toLowerCase()%>-legend\"><% for (var i=0; i<datasets.length; i++){%><li><span style=\"background-color:<%=datasets[i].strokeColor%>\"></span><%if(datasets[i].label){%><%=datasets[i].label%><%}%></li><%}%></ul>"
  };
  data = [
    {
      value: 300,
      color: "#FA2A00",
      highlight: "#FA2A00",
      label: "Red"
    }, {
      value: 50,
      color: "#1ABC9C",
      highlight: "#1ABC9C",
      label: "Green"
    }, {
      value: 100,
      color: "#FABE28",
      highlight: "#FABE28",
      label: "Yellow"
    }
  ];
  myLineChart = new Chart(ctx).Pie(data, options);
});

$(function() {
  var ctx, data, myLineChart, options;
  Chart.defaults.global.responsive = true;
  ctx = $('#jumbotron-line-chart').get(0).getContext('2d');
  options = {
    showScale: false,
    scaleShowGridLines: true,
    scaleGridLineColor: "rgba(0,0,0,.05)",
    scaleGridLineWidth: 1,
    scaleShowHorizontalLines: true,
    scaleShowVerticalLines: true,
    bezierCurve: false,
    bezierCurveTension: 0.4,
    pointDot: true,
    pointDotRadius: 4,
    pointDotStrokeWidth: 1,
    pointHitDetectionRadius: 20,
    datasetStroke: true,
    datasetStrokeWidth: 2,
    datasetFill: true,
    legendTemplate: "<ul class=\"<%=name.toLowerCase()%>-legend\"><% for (var i=0; i<datasets.length; i++){%><li><span style=\"background-color:<%=datasets[i].strokeColor%>\"></span><%if(datasets[i].label){%><%=datasets[i].label%><%}%></li><%}%></ul>"
  };
  data = {
    labels: ['Jan', 'Feb', 'Mar', 'Apr', 'May', 'Jun', 'Jul'],
    datasets: [
      {
        label: "My Second dataset",
        fillColor: "rgba(34, 167, 240,0.2)",
        strokeColor: "#22A7F0",
        pointColor: "#22A7F0",
        pointStrokeColor: "#fff",
        pointHighlightFill: "#fff",
        pointHighlightStroke: "#22A7F0",
        data: [28, 48, 40, 45, 76, 65, 90]
      }
    ]
  };
  myLineChart = new Chart(ctx).Line(data, options);
});
*/