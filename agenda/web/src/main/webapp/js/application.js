$(function () {
    $('#datepicker').datepicker().find('tbody tr').find('td:first').css({borderLeft: 'none'});
    
    var evt = $('<div class="event selected" style="height: 101px"><div class="event-start-time">09:00</div><div class="event-desc">Hello world!</div></div>');
    $('#lun .h9').prepend(evt);

    evt2 = $('<div class="event" style="height: 203px"><div class="event-start-time">08:00</div><div class="event-desc">Hello world!</div></div>');
    $('#mer .h8').prepend(evt2);
});