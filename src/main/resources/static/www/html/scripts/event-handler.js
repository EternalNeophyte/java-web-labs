/*
 *   Entry point
 *   ����� ���������� ����������� �������
 */
var switchedToEvenWeek = true;
var selectedDay = '�����������';
var currentBlock;

$('document').ready(function() {
    try {
        preparePage();
        $('.toggle-switch').click(onToggleSwitch);
        $('.existing').click(onExistingLink);
        $('#search-button').click(onSearchButton);
        $('#edit-button').click(onEditButton);
        $('#cancel-button').click(onCancelButton);
    }
    catch(e) {
        alert(e);
    }
});

/*
 *   ����������� ������� � ��������������� ������
 */
function preparePage() {
    $('#edit-popup').hide();
    reloadSectionBy('link', selectedDay);
}

function reloadSectionBy(eventType, text) {
    $('section').empty();
    $.getScript('scripts/xml-handler.js', function() {
        var filePath = switchedToEvenWeek ? 'xml/evenWeek.xml' : 'xml/oddWeek.xml';
        getFromXML(filePath, eventType, text);
    });
   /*
    $.getScript('scripts/java-handler.js', function() {
        loadLessons();
        //recreateAll();
    });
    */
    $('section').hide();
    $('section').fadeIn(800);
    
}

function onToggleSwitch() {
    switchedToEvenWeek = !switchedToEvenWeek;
    reloadSectionBy('link', selectedDay);
    if(switchedToEvenWeek) {
        $(this).removeClass('active');
        $(this).find('input').attr('checked', false);
        $(this).find('.slider').css({"-webkit-transform" : "translateX(0px)"});
    }
    else {
        $(this).addClass('active');
        $(this).find('input').attr('checked', true);
        $(this).find('.slider').css({"-webkit-transform" : "translateX(27px)"});
    }
}

function onExistingLink(event) {
    $('.existing').removeClass('active');
    $(this).addClass('active');
    selectedDay = event.target.text;
    reloadSectionBy('link', selectedDay);
}

function onTextBlock(event) {
    $('#edit-popup').show();
    currentBlock = event.currentTarget;
    $('#edit-field').val($(currentBlock.innerHTML).find('li').last().text());
}

function onSearchButton() {
    reloadSectionBy('search', $('#search-field').val());
}

function onEditButton() {
    var htmlText = currentBlock.innerHTML;
    htmlText = htmlText.replace(htmlText.split('<li>').pop(), ($('#edit-field').val() + '</li>'));
    $(currentBlock).empty();
    $(currentBlock).append(htmlText);
    $('#edit-popup').hide();
}

function onCancelButton() {
    $('#edit-field').empty();
    $('#edit-popup').hide();
}


