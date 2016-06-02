		$(window.onload = function() {

			$("#scheduleDel").on('click',function(){
				var result=confirm("정말 삭제하시겠습니까?");
				if(result){
					location.href="/deleteSchedule?id="+$("#scheduleId").val()+"&title="+$("#scheduleTitle").val();
				}
				});
			
			var loadNum=0;

			
		
	

			//현재 날짜 구하기
			var now = new Date();
			var year = now.getFullYear();
			var getMonth = now.getMonth() + 1;
			var getDay = now.getDate();
			var month="";
			var day="";
			if(getMonth<10){
				month+=0;
				month+=getMonth;
			}
			if(getDay<10){
				day+=0;
				day+=getDay;
			}

			var today = year + '-' + month + '-' + day;
			
			$('#calendar').fullCalendar(
					{
						header : {
							left : 'prev,next today',
							center : 'title',
							right : 'month,agendaWeek,agendaDay'
						},
						defaultDate : today,
						selectable : true,
						selectHelper : true,
						select : function(start, end) {
							var title = prompt('일정 제목을 입력하세요:');
							var id = prompt('일정의 고유 ID를 입력하세요:');
							var eventData;

							// 일정 등록 -------
							$.ajax({
								type : 'post',
								url : '/scheduleList',
								headers : {
									"Accept" : "application/json",
									"Content-Type" : "application/json"
								/*,"X-HTTP-Method-Override": "POST" */},
								dataType : 'text',
								data : JSON.stringify({
									scheduleId : id,
									scheduleTitle : title,
									scheduleStartDate : start,
									scheduleEndDate : end
								}),
								success : function(result) {
									console.log("result: " + result);
									if (result == 'SUCCESS') {
										alert("일정이 등록 되었습니다.");
									} else {
										alert("일정등록 실패")
									}
									;
								}
							});

							///----------------

							if (title) {
								eventData = {
									id : id,
									title : title,
									start : start,
									end : end
								};
								$('#calendar').fullCalendar('renderEvent',
										eventData, true); // stick? = true
							}
							$('#calendar').fullCalendar('unselect');
						},
						editable : true,
						eventLimit : true,
						eventDrop : function(event, dayDelta, minuteDelta,
								allDay, revertFunc, jsEvent, ui, view) {
							//이벤트 옮길시 자동 일정 자동수정
							$.ajax({
								type : 'post',
								url : '/updateSchedule',
								headers : {
									"Accept" : "application/json",
									"Content-Type" : "application/json"
									,"X-HTTP-Method-Override": "POST"},
								dataType : 'text',
								data : JSON.stringify({
									scheduleId : event.id,
									scheduleTitle : event.title,
									scheduleStartDate : event.start,
									scheduleEndDate : event.end
								}),
								success : function(result) {
									console.log("result: " + result);
									if (result == 'SUCCESS') {
										alert("일정변경 완료");
									} else {
										alert("일정변경 실패")
									}
									;
								}
							});
						},
						eventClick : function(calEvent, jsEvent, view) {
							//일정 클릭시 상세 정보 
							$.ajax({
								url : "getSchedule",
								headers : {
									"Accept" : "application/json",
									"Content-Type" : "application/json"
									,"X-HTTP-Method-Override": "POST"},
								dataType : "json",
								success : function(data) {
									$.each(data, function(index, schedule) {
										var abc = {
											id : schedule.scheduleId,
											title : schedule.scheduleTitle,
											start : (schedule.scheduleStartDate).substr(0, 10),
											end : (schedule.scheduleEndDate).substr(0, 10),
											detail:schedule.scheduleDetail
										}
										if(((abc.id)===(calEvent.id))&&((abc.title)===(calEvent.title))){				
											$('#myModalLabel').html(abc.title+' - 상세정보');
											$('#scheduleId').val(abc.id);
											$('#scheduleTitle').val(abc.title);
											$('#scheduleStartDate').val(abc.start);
											$('#scheduleEndDate').val(abc.end);
											$('#scheduleDetail').val(abc.detail);
											$('#loginSelectStudent').trigger('click'); 
											// change the border color just for fun
											$(this).css('border-color', 'red');

										}
									})
								}
							});

						}
					});

			var events = {
				title : 'TEST',
				start : '2016-05-23',
				end : '2016-05-26'
			};
			//페이지 로딩시 ajax실행 후 캘린더에 일정추가
			$('#calendar').fullCalendar('renderEvent', events, true)
			$.ajax({
				url : "getSchedule",
				dataType : "json",
				success : function(data) {
					$.each(data, function(index, schedule) {
						var abc = {
							id : schedule.scheduleId,
							title : schedule.scheduleTitle,
							start : (schedule.scheduleStartDate).substr(0, 10),
							end : (schedule.scheduleEndDate).substr(0, 10)
						}

						$('#calendar').fullCalendar('renderEvent', abc, true)
						
					})

					
				}
			});
		
			if($('#modalSuccess').attr("aria-hidden")==true){
				$(".form-control").attr("disabled", true);
				
			}
			
			$("#detailClose").on('click',function(){
				$(".form-control").attr("disabled", true);
				$('#loginSelectStudent').trigger('click');
			})
			//수정 버튼 클릭시 
			$("#scheduleMod").on('click',function(){
				$(".form-control").attr("disabled", false);
				$("#scheduleTitle").attr("disabled",true);
				$("#scheduleMod").css('display','none');
				$("#scheduleModCencle").css("display",'inline');
				$("#scheduleSubmit").css("display",'inline');
				$("#scheduleDel").css("display","none");
			})
			
			//취소 버튼 클릭시 
			$("#scheduleModCencle").on('click',function(){
				$(".form-control").attr("disabled", true);
				$("#scheduleMod").css('display','inline');
				$("#scheduleModCencle").css("display",'none');
				$("#scheduleSubmit").css("display",'none');
				$("#scheduleDel").css("display","inline");
			})

		});