$(function() {

	$('.filterOptions').click(function() {
		if (this.value == "Show All" && this.checked) {
			$('.searchResult').show();
			$('.filterOptions').attr('checked', false);
			this.checked = true;
			return;
		}
		var categoryDivs = $('.filterOptions:checked');
		if (categoryDivs[categoryDivs.length - 1].value == "Show All")
			$(categoryDivs[categoryDivs.length - 1]).attr('checked', false);
		categoryDivs = $('.filterOptions:checked');
		var categories = [];
		$(categoryDivs).each(function(){
			categories.push($(this).val());
		});
		displayCategories(categories);
	});

});

function displayCategories(categories) {
	$('.searchResult').hide();
	$('.searchResult').each(function(index) {
		var c = $(this).children('input').val().split(',');
		for (var j = 0; j < c.length; j++) {
			var a = jQuery.inArray(c[j], categories);
			if (a != -1) {
				$(this).show();
				break;
			}
		}
	});
}