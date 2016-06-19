		$(window.onload = function() {
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
			}else{
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
						selectable : false,
						selectHelper : false,
						editable : false,
						eventLimit : false,
						eventClick : function(calEvent, jsEvent, view) {
							//일정 클릭시 상세 정보 		
							$.ajax({
								url : "getSchedule",
								dataType : "json",
								success : function(data) {
									$.each(data, function(index, schedule) {
										$("#scheduleDel").css('display','none');
										$("#scheduleMod").css('display','none');
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
				start : '2014-05-23',
				end : '2014-05-26'
			};
			//페이지 로딩시 ajax실행 후 캘린더에 일정추가
			$('#calendar').fullCalendar('renderEvent', events, true);
			
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
						$('#calendar').fullCalendar('renderEvent', abc, true);
						
					})
				}
			});
		
			if($('#modalSuccess').attr("aria-hidden")==true){
				$(".form-control").attr("disabled", true);
				
			}
			

			$("#detailClose").on("click",function(){
				$('#loginSelectStudent').trigger('click'); 
			});
			

		});