 /*
     Логика по взаимодействию с XML-файлами
 */
 function getFromXML(filePath, eventType, text) {
    $.ajax({
        type: 'GET',
        url: filePath,
        dataType: 'xml',
        success: function(xml) {
            switch(eventType) {
         	    case 'search':
         	        parseXMLByKeyword(filePath, xml, text);
         	        break;
         	    case 'link':
         	        parseXMLByDay(filePath, xml, text);
         	        break;
         	    }
         	}
    });
 }

 function parseXMLByDay(filePath, xml, day) {
    var lessons = $(xml).find('timeTable').filter(function() {
        return $('dayOfWeekRus', this).text() == day;
    }).find('lesson').each(appendHTML);
    check(lessons);
 }

 function parseXMLByKeyword(filePath, xml, keyword) {
    var isEqual;
    var lessons = $(xml).find('lesson').filter(function() {
        isEqual = false;
      	$(this).children().each(function() {
      	    if($(this).text().includes(keyword)) {
      	        isEqual = true;
      	    }
      	});
        return isEqual;
    }).each(appendHTML);
    check(lessons);
 }

 function appendHTML() {
     $('section').append('<div class="text-block" onclick="onTextBlock(event)"><h2>' +
         $(this).find('title').text() + '</h2><ul type="square"><li>Проходит ' +
         ($(this).find('isRemote').text() == 'true' ? 'дистанционно' : 'очно') + '</li><li>Начинается в ' +
         $(this).find('startTime').text() + ' и заканчивается в ' +
         $(this).find('endTime').text() + '</li><li>Номер аудитории: ' +
         $(this).find('audienceNumber').text() + '</li><li>Преподаватель: ' +
         $(this).find('lector').text() + '</li><li>' +
         $(this).find('description').text() + '</li></ul></div>');
 }

 function check(lessons) {
     if(lessons.length == 0) {
         ($('section')).append('<div class = "not-found-block"><div class = "not-found-404">404</div>' +
         '<div class = "not-found-text">Нет пар<br>по данному<br>запросу</div></div>');
     }
 }

