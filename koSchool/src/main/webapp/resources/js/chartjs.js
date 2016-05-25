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
				$("#mockScore"+i).append(mockName[i]+'언어평균점수 :'+mockKorAvg[i]+"점   "+studentName+'학생의 언어점수:'+myKorScore[i]+'점  '+'평균보다'+result+'점 낮습니다');			
			}else if(Number(mockKorAvg[i])<Number(myKorScore[i])){
				result=Number(myKorScore[i])-Number(mockKorAvg[i]);
				$("#mockScore"+i).append(mockName[i]+'언어평균점수 :'+mockKorAvg[i]+"점   "+studentName+'학생의 언어점수:'+myKorScore[i]+'점  '+'평균보다'+result+'점 높습니다');			
			}
		}
	}


	
  var ctx, data, myLineChart, options;
  Chart.defaults.global.responsive = true;
  ctx = $('#line-chart').get(0).getContext('2d');
  options = {
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
    labels: [mockName[0],mockName[1],mockName[2],mockName[3],mockName[4],mockName[5],mockName[6],mockName[7],mockName[8]],
    //, (mockName[2]).substr(7,7), (mockName[3]).substr(7,7), (mockName[4]).substr(7,7), '2-9', '3-3','3-6','3-9'
    datasets: [
      {
        label: "My First dataset",
        fillColor: "rgba(26, 188, 156,0.2)",
        strokeColor: "#1ABC9C",
        pointColor: "#1ABC9C",
        pointStrokeColor: "#fff",
        pointHighlightFill: "#fff",
        pointHighlightStroke: "#1ABC9C",
        data: [Number(myKorScore[0]), Number(myKorScore[1]), Number(myKorScore[2]) ,Number(myKorScore[3]),Number(myKorScore[4]),Number(myKorScore[5]),Number(myKorScore[6]),Number(myKorScore[7]),Number(myKorScore[8])]
      }, {
        label: "My Second dataset",
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
  ctx = $('#bar-chart').get(0).getContext('2d');
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
