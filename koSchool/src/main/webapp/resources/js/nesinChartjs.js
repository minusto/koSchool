// 내신 과목별 
$(function() {
	var grade = $('#chartGrade').html().substr(0,1);
	if(grade == "1"){
		//1학년 과목일때 과목 수는 8개
		var s_name = new Array(8);
		for(var i=0; i<s_name.length; i++){	
			s_name[i] = $("#subjectName"+(i+1)).html();
		}
		var originalScore = new Array(8);
		for(var i=0; i<originalScore.length; i++){
			originalScore[i] = Number($("#originalScore"+(i+1)).html());
		}
		var avg = new Array(8);
		for(var i=0; i<avg.length; i++){
			avg[i] = Number($("#avg"+(i+1)).html());
		}
		var result = 0;
		var compare = '';
		// 비교문구
		for(var i=0; i<s_name.length; i++){
			result = Math.abs(avg[i] - originalScore[i]).toFixed(2);
			if(avg[i]>originalScore[i]){
				compare = "평균보다 " + result + "점 낮습니다.";
			}else if(avg[i]<originalScore[i]){
				compare = "평균보다 " + result + "점 높습니다.";
			}else{
				compare = " 평균점수와 같습니다."
			}
			$('#nesinText').append('<p>'+s_name[i]+' 평균점수: '+avg[i]+"점,   "+'학생의 '+ s_name[i]+'점수: '+originalScore[i]+'점  '+'<br>'+compare+'</p>')
		}
	}else if(grade == "2"){
		//2학년 과목일때 과목 수는 10개
		var s_name = new Array(10);
		for(var i=0; i<s_name.length; i++){	
			s_name[i] = $("#subjectName"+(i+1)).html();
		}
		var originalScore = new Array(10);
		for(var i=0; i<originalScore.length; i++){
			originalScore[i] = Number($("#originalScore"+(i+1)).html());
		}
		var avg = new Array(10);
		for(var i=0; i<avg.length; i++){
			avg[i] = Number($("#avg"+(i+1)).html());
		}
		// 비교문구
		for(var i=0; i<s_name.length; i++){
			result = Math.abs(avg[i] - originalScore[i]).toFixed(2);
			if(avg[i]>originalScore[i]){
				compare = "평균보다 " + result + "점 낮습니다.";
			}else if(avg[i]<originalScore[i]){
				compare = "평균보다 " + result + "점 높습니다.";
			}else{
				compare = " 평균점수와 같습니다."
			}
			$('#nesinText').append('<p>'+s_name[i]+' 평균점수: '+avg[i]+"점,   "+'학생의 '+ s_name[i]+'점수: '+originalScore[i]+'점  '+'<br>'+compare+'</p>')
		}
	}else{
		//3학년 과목일때 과목 수는 6개
		var s_name = new Array(6);
		for(var i=0; i<s_name.length; i++){	
			s_name[i] = $("#subjectName"+(i+1)).html();
		}
		var originalScore = new Array(6);
		for(var i=0; i<originalScore.length; i++){
			originalScore[i] = Number($("#originalScore"+(i+1)).html());
		}
		var avg = new Array(6);
		for(var i=0; i<avg.length; i++){
			avg[i] = Number($("#avg"+(i+1)).html());
		}
		// 비교문구
		for(var i=0; i<s_name.length; i++){
			result = Math.abs(avg[i] - originalScore[i]).toFixed(2);
			if(avg[i]>originalScore[i]){
				compare = "평균보다 " + result + "점 낮습니다.";
			}else if(avg[i]<originalScore[i]){
				compare = "평균보다 " + result + "점 높습니다.";
			}else{
				compare = " 평균점수와 같습니다."
			}
			$('#nesinText').append('<p>'+s_name[i]+' 평균점수: '+avg[i]+"점,   "+'학생의 '+ s_name[i]+'점수: '+originalScore[i]+'점  '+'<br>'+compare+'</p>')
		}
	}
  var ctx, data, myBarChart, option_bars;
  Chart.defaults.global.responsive = true;
  ctx = $('#radar-chart').get(0).getContext('2d');
  option_bars = {
	scaleOverride : true,
	scaleSteps : 5,
	scaleStepWidth : 20,
	scaleStartValue : 0 ,
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
    multiTooltipTemplate: "<%= datasetLabel %> - <%= value %>",
    legendTemplate: "<ul class=\"<%=name.toLowerCase()%>-legend\"><% for (var i=0; i<datasets.length; i++){%><li><span style=\"background-color:<%=datasets[i].fillColor%>\"></span><%if(datasets[i].label){%><%=datasets[i].label%><%}%></li><%}%></ul>"
  };
  if(grade=="1"){
  data = {
    labels: [s_name[0], s_name[1], s_name[2], s_name[3], s_name[4], s_name[5], s_name[6], s_name[7]],
    datasets: [
      {
        label: "내점수",
        fillColor: "rgba(26, 188, 156,0.2)",
        strokeColor: "#1ABC9C",
        pointColor: "#1ABC9C",
        pointStrokeColor: "#fff",
        pointHighlightFill: "#fff",
        pointHighlightStroke: "#1ABC9C",
        data: [originalScore[0],originalScore[1], originalScore[2], originalScore[3], originalScore[4], originalScore[5],originalScore[6], originalScore[7]]
      }, {
        label: "평균점수",
        fillColor: "rgba(34, 167, 240,0.2)",
        strokeColor: "#22A7F0",
        pointColor: "#22A7F0",
        pointStrokeColor: "#fff",
        pointHighlightFill: "#fff",
        pointHighlightStroke: "#22A7F0",
        data: [avg[0], avg[1], avg[2], avg[3], avg[4], avg[5], avg[6], avg[7]]
      }
    ]
  };
  }else if(grade=="2"){
	  data = {
			    labels: [s_name[0], s_name[1], s_name[2], s_name[3], s_name[4], s_name[5], s_name[6], s_name[7], s_name[8], s_name[9] ],
			    datasets: [
			      {
			        label: "내점수",
			        fillColor: "rgba(26, 188, 156,0.2)",
			        strokeColor: "#1ABC9C",
			        pointColor: "#1ABC9C",
			        pointStrokeColor: "#fff",
			        pointHighlightFill: "#fff",
			        pointHighlightStroke: "#1ABC9C",
			        data: [originalScore[0],originalScore[1], originalScore[2], originalScore[3], originalScore[4], originalScore[5],originalScore[6], originalScore[7], originalScore[8], originalScore[9] ]
			      }, {
			        label: "평균점수",
			        fillColor: "rgba(34, 167, 240,0.2)",
			        strokeColor: "#22A7F0",
			        pointColor: "#22A7F0",
			        pointStrokeColor: "#fff",
			        pointHighlightFill: "#fff",
			        pointHighlightStroke: "#22A7F0",
			        data: [avg[0], avg[1], avg[2], avg[3], avg[4], avg[5], avg[6], avg[7], avg[8], avg[9]]
			      }
			    ]
			  };
  }else{
	  data = {
			    labels: [s_name[0], s_name[1], s_name[2], s_name[3], s_name[4], s_name[5]],
			    datasets: [
			      {
			        label: "내점수",
			        fillColor: "rgba(26, 188, 156,0.2)",
			        strokeColor: "#1ABC9C",
			        pointColor: "#1ABC9C",
			        pointStrokeColor: "#fff",
			        pointHighlightFill: "#fff",
			        pointHighlightStroke: "#1ABC9C",
			        data: [originalScore[0],originalScore[1], originalScore[2], originalScore[3], originalScore[4], originalScore[5] ]
			      }, {
			        label: "평균점수",
			        fillColor: "rgba(34, 167, 240,0.2)",
			        strokeColor: "#22A7F0",
			        pointColor: "#22A7F0",
			        pointStrokeColor: "#fff",
			        pointHighlightFill: "#fff",
			        pointHighlightStroke: "#22A7F0",
			        data: [avg[0], avg[1], avg[2], avg[3], avg[4], avg[5] ]
			      }
			    ]
			  };
  }
  myBarChart = new Chart(ctx).Radar(data, option_bars);
});
////////////////////////////////////////////////////////////////////////////////////////
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
