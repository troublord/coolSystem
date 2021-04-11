//$('.datepicker').datepicker({
//    format: 'yyyy-mm-dd',
//    startDate: '-1d'
//});
 $(function () {
        $('.datepicker').datepicker({
            format:"YYYY-MM-DD",
            defaultDate:new Date(),
            locale:"zh-tw"
        });
    });