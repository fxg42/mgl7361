/*global $*/
$(function () {
    
    var model = (function () {
        var data = { value1: 0, value2: 0, value3: 0, value4: 0, value5: 0 };
        var observers = [];
        
        var notifyAll = function () {
            $.each(observers, function (idx, it) {
                $(it).trigger('model:change');
            });
        };
        
        return {
            initialize: function (val) {
                data = val;
                notifyAll();
            },
            addObserver: function (obsv) {
                observers.push(obsv);
            },
            data: function (name, val) {
                if (arguments.length === 2) {
                    data[name] = val;
                    notifyAll();
                } else if (arguments.length === 1) {
                    return data[name];
                } else {
                    return data;
                }
            }
        };
    }());
    
    $('#pie-chart')
        .bind('model:change', function (evt) {
            if (evt.target === this) {
                var data = model.data();
                var chartData = data.value1 + ',' + data.value2 + ',' + data.value3 + ',' + data.value4 + ',' + data.value5;
                var src = 'http://chart.apis.google.com/chart?cht=p3&chs=290x130&chd=t:'+ chartData +'&chl=1|2|3|4|5';
                $(this).find('img').attr('src', src);
            }
        })
        .each(function () {
            model.addObserver($(this));
        });
    
    $('#bar-chart')
        .bind('model:change', function (evt) {
            if (evt.target === this) {
                var data = model.data();
                var chartData = data.value1 + ',' + data.value2 + ',' + data.value3 + ',' + data.value4 + ',' + data.value5;
                var src = 'http://chart.apis.google.com/chart?chxt=x,y&cht=bvs&chd=t:'+ chartData +'&chls=2.0&chs=250x150&chxl=0:|1|2|3|4|5';
                $(this).find('img').attr('src', src);
            }
        })
        .each(function () {
            model.addObserver($(this));
        });

    $('#control-panel').find('span')
        .slider({
            value: 0, min: 0, max: 100, step: 10, orientation: 'vertical', range: 'min'
        })
        .bind('slide', function(evt, ui) {
            var name = $(this).attr('id');
            model.data(name, ui.value);
        })
        .bind('model:change', function (evt) {
            if (evt.target === this) {
                var name = $(this).attr('id');
                var val = model.data(name);
                $(this).slider('option', 'value', val);
            }
        })
        .each(function () {
            model.addObserver($(this));
        });
    
    model.initialize({ value1: 10, value2: 30, value3: 50, value4: 30, value5: 10 });
});
