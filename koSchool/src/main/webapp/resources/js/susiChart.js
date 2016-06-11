google.charts.load('current', {'packages':['corechart']});
      google.charts.setOnLoadCallback(drawChart);
      function drawChart() {
        var data = google.visualization.arrayToDataTable([
          ['단국대', 1, 1, 5, 10] ,
          ['고려대', 1, 2, 6, 10],
          ['서울대', 1, 3, 5, 10],
          ['한성대', 1, 4, 4.6, 10],
          ['지렷구요', 1, 2, 7.7, 10],
          ['충남대', 1, 3, 4.4, 10],
          ['연세대', 1, 3, 6, 10],
          ['대전대', 1, 2, 4, 10],
          ['하하하', 1, 2, 7, 10],
          ['ㅋㅋㅋ', 1, 3, 7, 10] 
          // Treat the first row as data.
        ], true);

        var options = {
          //legend: 'none',
          bar: { groupWidth: '20%' }, // Remove space between bars.
          candlestick: {
            fallingColor: { strokeWidth: 0, fill: '#a52714' }, // red
            risingColor: { strokeWidth: 0, fill: '#0f9d58' }   // green
          }
        };

        var chart = new google.visualization.CandlestickChart(document.getElementById('chart_div'));
        chart.draw(data, options);
        
        removeLine();    
      }
      
      function removeLine() {
    	  $("rect[fill='#3366cc']").remove();
      }